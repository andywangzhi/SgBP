package com.gzepro.internal.query.soa.extaction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.outrcsm.base.RsPersonOutQo;
import com.gzepro.internal.query.common.persistence.BaseDao;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.PropertyUtil;
import com.gzepro.internal.query.soa.extaction.sundoctor.SchedulerService;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.QueryRsPersonListSO;
import com.gzepro.internal.query.system.model.ChangeTime;

@Service("dataChangeTask")
public class DataChangeTask{
	@Resource
	private DataChangeAtion dataChangeAtion;
	@Resource
	private SchedulerService schedulerService;
	@Resource
	private BaseDao baseDao;
	
	protected static final String GLOBAL_CHANGE_FILE = "config/changedata.properties";
	private String updatetime;
	private String isdochangejob;
	private String hours;
	private String minute;
	private String id="20121225";
	
	/**
	 * 设置定时任务
	 */
	public void setDataChangeTime(){
		try {
			List<Object> list_obj = baseDao.find("from ChangeTime where id = '20121225'");
			if(list_obj != null && list_obj.size() >0){
				ChangeTime obj = (ChangeTime)list_obj.get(0);
				updatetime = obj.getDlastchangetime();
				isdochangejob = obj.getDiscanchange();
				hours = obj.getDchangehours();
				minute = obj.getDchangeminute();
			}else{
				updatetime = "2012-01-01";
				isdochangejob = "no";
				hours = "22";
				minute = "10";
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 设置定时任务
	 */
	public void setAndReadDataChangeTime(){
		try {
			List<Object> list_obj = baseDao.find("from ChangeTime where id = '20121225'");
			if(list_obj != null && list_obj.size() >0){
				ChangeTime obj = (ChangeTime)list_obj.get(0);
				updatetime = obj.getDlastchangetime();
				if(updatetime == null || !updatetime.equals("")){
					updatetime = "2012-01-01";
				}
				isdochangejob = obj.getDiscanchange();
				hours = obj.getDchangehours();
				minute = obj.getDchangeminute();
			}else{
				updatetime = "2012-01-01";
				isdochangejob = "no";
				hours = "22";
				minute = "10";
			}
			setChangeTime();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			updatetime = "2012-01-01";
			isdochangejob = "no";
			hours = "22";
			minute = "10";
			setChangeTime();
			e.printStackTrace();
		}
	}
	public void setChangeTime(){
		String cronExpression = "0 "+minute+" "+hours+" * * ?";
		schedulerService.schedule(cronExpression);
	}
	
	/**
     * 读取配置文件
     * @param filePath
     * @param proName
     * @return
     */
	public String getPropertieValue(String proName) {
		PropertyUtil propertyUtil = new PropertyUtil();
		return propertyUtil.getPropertieValue(GLOBAL_CHANGE_FILE, proName);
	}
	/**
	 * 交换数据
	 */
	public void doChangeJob(){
		try {
			setDataChangeTime();
			startChangeJob();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public String writeConfig(){
		try {
			List<Object> list_obj = baseDao.find("from ChangeTime where id = '20121225'");
			ChangeTime obj = null;
			if(list_obj != null && list_obj.size() >0){
				obj = (ChangeTime)list_obj.get(0);
				updatetime = obj.getDlastchangetime();
				if(updatetime == null || updatetime.equals("")){
					updatetime = "2012-01-01";
				}
				isdochangejob = obj.getDiscanchange();
			}else{
				obj = new ChangeTime();
				updatetime = "2012-01-01";
				isdochangejob = "no";
			}
			obj.setDchangehours(hours);
			obj.setId("20121225");
			obj.setDchangeminute(minute);
			obj.setDiscanchange(isdochangejob);
			obj.setDlastchangetime(updatetime);
			baseDao.saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	     return null;
    }
	
	public String writeConfig(String str_updatetime){
		try {
			List<Object> list_obj = baseDao.find("from ChangeTime where id = '20121225'");
			ChangeTime obj = null;
			if(list_obj != null && list_obj.size() >0){
				obj = (ChangeTime)list_obj.get(0);
				updatetime = obj.getDlastchangetime();
				isdochangejob = obj.getDiscanchange();
			}else{
				obj = new ChangeTime();
			}
			obj.setDlastchangetime(str_updatetime);
			obj.setDchangehours(hours);
			obj.setId("20121225");
			obj.setDchangeminute(minute);
			obj.setDiscanchange(isdochangejob);
			baseDao.saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	     return null;
    }
	
	public String startChangeJob(){			
		try {
			if(!isdochangejob.equals("yes")){
				System.out.println(DateUtil.getSystemDateTime() + "未进行交换");
				return "false";
			}	
			//先实名系统交换到公共服务平台
			String startTime = DateUtil.getSystemDateTime();
			QueryRsPersonListSO query = new QueryRsPersonListSO();
			query.setDateStr("sh");
			query.setAuditstate("1%1");
			query.setFromDate(dealUpdateTime());			
			dataChangeAtion.rspersonDataChangeFormIn(query);
			//然后公共服务平台交换到实名系统
			RsPersonOutQo outQo = new RsPersonOutQo();
			outQo.setDateStr("sh");
			outQo.setAuditstate("1%1");
			outQo.setAuditdate(dealDate(dealUpdateTime()));
			dataChangeAtion.repersonDataChangeFormOut(outQo);
			writeConfig(DateUtil.getSystemDate());
			System.out.println(startTime +" 至  " + DateUtil.getSystemDateTime() + " 内交换完成");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 获取配置时间的前一天
	 * @return
	 * @throws Exception
	 */
	public String dealUpdateTime() throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(updatetime);
		Calendar calendar = Calendar.getInstance();		
		calendar.setTime(date);		
		calendar.add(Calendar.DAY_OF_MONTH, -2);		
		date = calendar.getTime();	
		return format.format(date);	
	}
	
	/**
	 * 处理日期 格式为yyyy-MM-dd
	 * @return 返回日期的整形
	 */
	public int dealDate(String inputQuery){
		int dateInt = 0;
		if(inputQuery!=null && !inputQuery.trim().equals("")){
			Date beginDate=DateUtil.getDate(inputQuery,"yyyy-MM-dd");  //yyyy-MM-dd
    		int bYYYY = DateUtil.getYear(beginDate);
    		int bMM = DateUtil.getMonth(beginDate);
    		int bDD = DateUtil.getDay(beginDate);
    		if( bMM <=9 ){
    			dateInt= Integer.parseInt(bYYYY +"0"+ bMM);
    		}else{
    			dateInt= Integer.parseInt(bYYYY +""+ bMM);
    		}
    		if( bDD <=9 ){
    			dateInt= Integer.parseInt(dateInt +"0"+ bDD);
    		}else{
    			dateInt= Integer.parseInt(dateInt +""+ bDD);
    		}
    	}
		return dateInt;
	}

	

	public DataChangeAtion getDataChangeAtion() {
		return dataChangeAtion;
	}
	

	public void setDataChangeAtion(DataChangeAtion dataChangeAtion) {
		this.dataChangeAtion = dataChangeAtion;
	}
  
	
	public SchedulerService getSchedulerService() {
		return schedulerService;
	}
	public void setSchedulerService(SchedulerService schedulerService) {
		this.schedulerService = schedulerService;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}
	public BaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}
