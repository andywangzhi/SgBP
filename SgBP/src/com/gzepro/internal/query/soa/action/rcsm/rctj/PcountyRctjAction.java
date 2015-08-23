package com.gzepro.internal.query.soa.action.rcsm.rctj;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.MD5Util;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj.RctjDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.rctj.RctjForm;
import com.gzepro.internal.query.soa.service.user.impl.PcountyRctjService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.service.AccountService;

@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.PcountyRctj")
public class PcountyRctjAction extends SoaBaseJsonAction {

	@Resource
	private PcountyRctjService pcountyRctjService;// 通过spring注入业务实例
	private RctjForm form = new RctjForm();// 查询表单封装对象
	private String filename;

	protected String dqType;//地区类型
	
	/**
	 * @return the dqType
	 */
	public String getDqType() {
		return dqType;
	}

	/**
	 * @param dqType the dqType to set
	 */
	public void setDqType(String dqType) {
		this.dqType = dqType;
	}
	
	/**
	 * 获取配置时间的前一天
	 * @return
	 * @throws Exception
	 */
	private String dealAgeTime(String age) throws Exception{
		if(age == null || "".equals(age)){
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(DateUtil.getCurDate());
		Calendar calendar = Calendar.getInstance();		
		calendar.setTime(date);		
		calendar.add(Calendar.YEAR, 0-Integer.parseInt(age));	
		date = calendar.getTime();	
		return format.format(date).substring(0, format.format(date).indexOf("-"))+"-01-01";	
	}
	
	private String getDateString(String date){
		if(date == null || "".equals(date)){
			return "";
		}
		 String[] dates = date.split("-");
		 String dateReturn = dates[0];
		 
		 for(int i=1; i<dates.length; i++){
			 if(dates[i].length()<2){
			 	dates[i]="0"+dates[i];
			 }
			 dateReturn += "-" + dates[i];
		 }
		 return dateReturn;
	}
	String forage = "";
	String toage = "";
	private void dealRetrieveSO(){
		try {
			forage = form.getRetrieveSO().getForage();
			toage = form.getRetrieveSO().getToage();
			form.getRetrieveSO().setForage(dealAgeTime(form.getRetrieveSO().getForage()));
			form.getRetrieveSO().setToage(dealAgeTime(form.getRetrieveSO().getToage()));
			form.getRetrieveSO().setHarvestassessforDate(getDateString(form.getRetrieveSO().getHarvestassessforDate()));
			form.getRetrieveSO().setHarvestassesstoDate(getDateString(form.getRetrieveSO().getHarvestassesstoDate()));
			form.getRetrieveSO().setTechassessforDate(getDateString(form.getRetrieveSO().getTechassessforDate()));
			form.getRetrieveSO().setTechassesstoDate(getDateString(form.getRetrieveSO().getTechassesstoDate()));
			if(form.getRetrieveSO().getPcounty() != null && !form.getRetrieveSO().getPcounty().equals("")){
				form.getRetrieveSO().setPcounty(form.getRetrieveSO().getPcounty().replace(",", ""));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			form.getRetrieveSO().setForage("");
			form.getRetrieveSO().setToage("");
		}		
	}
	
	private String checkpassword(){
		if(password == null || password.length() < 7){
			return "false";
		}
		String firstPass = password.substring(0, password.length() - 6);
		String md5Password = MD5Util.getMD5String(firstPass.trim());
		String isReport = password.substring(password.length() - 6, password.length());
		if(!isReport.equals("report")){
			return "false";
		}
		if(!this.getAccount().getLoginCode().trim().equals("sgrcb")){
			return "false";
		}
		Account account = accountService.findByName("sgrcb");
		if(account.getPassword().equals(md5Password)){
			return "true";
		}
		return "false";
	}
	
	/**
	 * 上报数据统计
	 * @return
	 */
	@Resource
	private AccountService accountService;
	private String password;
	private String isCanSee = "false";
	public String queryPcountyforReport() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			if(checkpassword().equals("false") && !isCanSee.equals("true")){	
				isCanSee = "false";
				return "pcountyforReport";
			}else{
				isCanSee = "true";
			}
			form.getRetrieveSO().setIsreport("true");
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findPcounty(form.getRetrieveSO());
			form.getRetrieveSO().setForage(forage);
			form.getRetrieveSO().setToage(toage);
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}
				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("15"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return "pcountyforReport";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "pcountyforReport";
		}
	}


	@SuppressWarnings("unchecked")
	public String queryPcounty() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findPcounty(form.getRetrieveSO());
			form.getRetrieveSO().setForage(forage);
			form.getRetrieveSO().setToage(toage);
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}
				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("15"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return "pcounty";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "pcounty";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String queryPcountyforgcc() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			form.getRetrieveSO().setPersonKind("1");
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findPcounty(form.getRetrieveSO());
			form.getRetrieveSO().setForage(forage);
			form.getRetrieveSO().setToage(toage);
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}
				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("15"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return "pcountyforgcc";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "pcountyforgcc";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String queryPcountyforlxs() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			form.getRetrieveSO().setPersonKind("2");
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findPcounty(form.getRetrieveSO());
			form.getRetrieveSO().setForage(forage);
			form.getRetrieveSO().setToage(toage);
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}
				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("15"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return "pcountyforlxs";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "pcountyforlxs";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String ExportPcountyExecl() throws Exception {
		
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			dealRetrieveSO();
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findPcounty(form.getRetrieveSO());
			Map<String, Map> map = new HashMap<String, Map>();
			if (dtoList != null && dtoList.size() > 0) {
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}
				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					map.put("100", amap);
				}
			}
			//区县字典
			Map<String, String> countyMap=this.getConfTypeMap("15");
			
			//人才类型字典
			Map<String, String> personTypeMap=this.getConfTypeMap("11");
	        HSSFWorkbook workbook = new HSSFWorkbook(); //创建execl
	     // 用于格式化单元格的数据
			HSSFDataFormat format = workbook.createDataFormat();
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName(" 黑体 "); // 字体
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
			// font.setStrikeout(true); // 是否使用划线
			// 设置单元格类型
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFont(font);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
			cellStyle.setWrapText(true);
			// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
			HSSFSheet sheet = workbook.createSheet("地区统计");
			//设置宽度
			sheet.setColumnWidth(0, 3500);
			sheet.setColumnWidth(1, 2500);
			sheet.setColumnWidth(2, 5000);
			sheet.setColumnWidth(3, 5000);
			sheet.setColumnWidth(4, 3000);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6, 2500);
			sheet.setColumnWidth(7, 2500);
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			//第一行
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("区域"));
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("党政人才"));
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("企业经营管理人才"));
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("专业技术人才"));
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("高技能人才"));
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("农村实用人才"));
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("社工人才"));
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("总数"));
			cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setWrapText(true);
			if (map!=null&&map.size()>0) {
				int count=1;
				//循环多少个区域
				for (String str : map.keySet()) {
					 row = sheet.createRow(count);
					 count++;
					 cell = row.createCell(0);
					 cell.setCellStyle(cellStyle);
					 String l="";
					 if(str.trim().equals("100")){
						 l="总数";
					 }else{
						 l=countyMap.get(str);
					 }
					 cell.setCellValue(new HSSFRichTextString(l));
					Map<String, Long> amap=map.get(str);
					//循环人才类型
					for (int i = 1; i < 7; i++) {
						 cell = row.createCell(i);
						 if(amap.get(String.valueOf(i))!=null){
							 cell.setCellValue(amap.get(String.valueOf(i)));
						 }else{
							 cell.setCellValue(0);
						 }
					}
					//取总数
					 cell = row.createCell(7);
					 cell.setCellValue(amap.get(String.valueOf("10")));
				}
				
			}
			HttpServletResponse response=getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流   
	        response.reset();// 清空输出流   
	    	String n="韶关市人才统计.xls";
	        if(dqType!=null&&dqType.length()>0){
	        	 n=countyMap.get(dqType);
	        	if(n!=null&&n.length()>0){
	        		n = n+"人才统计.xls";
	        	}
	        }	   
	        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
	        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
	        response.setContentType("application/msexcel");// 定义输出类型 
			workbook.write(os); // 写入文件   
			os.close(); // 关闭流
			return this.NONE;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return this.NONE;
		}
	}
	

	@SuppressWarnings("unchecked")
	public String querySpecialtyType() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findSpecialtyType(form.getRetrieveSO());
			form.getRetrieveSO().setForage(forage);
			form.getRetrieveSO().setToage(toage);
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}

				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("5"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return "specialtyType";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return  "specialtyType";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String queryNeedSpecialtyType() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findNeedSpecialtyType(form.getRetrieveSO());
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}

				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("5"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return "needspecialtyType";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return  "needspecialtyType";
		}
	}
	

	public String ExportSpecialtyTypeExecl() throws Exception {
		HttpServletResponse response=getResponse();
		OutputStream os = response.getOutputStream();// 取得输出流   
        response.reset();// 清空输出流   
        String name=new String("韶关市专业人才统计.xls".getBytes("GB2312"), "ISO8859-1");
        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
        response.setContentType("application/msexcel");// 定义输出类型 
        try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findSpecialtyType(form.getRetrieveSO());
			Map<String, Map> map = new HashMap<String, Map>();
			if (dtoList != null && dtoList.size() > 0) {
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}

				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					map.put("100", amap);
				}
			}
			//区县字典
			Map<String, String> countyMap=this.getConfTypeMap("5");
			//人才类型字典
			Map<String, String> personTypeMap=this.getConfTypeMap("11");
	        HSSFWorkbook workbook = new HSSFWorkbook(); //创建execl
	     // 用于格式化单元格的数据
			HSSFDataFormat format = workbook.createDataFormat();
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName(" 黑体 "); // 字体
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
			// font.setStrikeout(true); // 是否使用划线
			// 设置单元格类型
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFont(font);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
			cellStyle.setWrapText(true);
			// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
			HSSFSheet sheet = workbook.createSheet("专业统计");
			//设置宽度
			sheet.setColumnWidth(1, 2500);
			sheet.setColumnWidth(2, 5000);
			sheet.setColumnWidth(3, 5000);
			sheet.setColumnWidth(4, 3000);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6, 2500);
			sheet.setColumnWidth(7, 2500);
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			//第一行
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("专业"));
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("党政人才"));
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("企业经营管理人才"));
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("专业技术人才"));
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("高技能人才"));
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("农村实用人才"));
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("社工人才"));
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("总数"));
			cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setWrapText(true);
			if (map!=null&&map.size()>0) {
				int count=1;
				//循环多少个区域
				for (String str : map.keySet()) {
					 row = sheet.createRow(count);
					 count++;
					 cell = row.createCell(0);
					 cell.setCellStyle(cellStyle);
					 String l="";
					 if(str.trim().equals("100")){
						 l="总数";
					 }else{
						 l=countyMap.get(str);
					 }
					 cell.setCellValue(new HSSFRichTextString(l));
					Map<String, Long> amap=map.get(str);
					//循环人才类型
					for (int i = 1; i < 7; i++) {
						 cell = row.createCell(i);
						 if(amap.get(String.valueOf(i))!=null){
							 cell.setCellValue(amap.get(String.valueOf(i)));
						 }else{
							 cell.setCellValue(0);
						 }
					}
					//取总数
					 cell = row.createCell(7);
					 cell.setCellValue(amap.get(String.valueOf("10")));
				}
			}
			workbook.write(os); // 写入文件   
			os.close(); // 关闭流
			return this.NONE;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return this.NONE;
		}
	}
	
	public String ExportNeedSpecialtyTypeExecl() throws Exception {
		HttpServletResponse response=getResponse();
		OutputStream os = response.getOutputStream();// 取得输出流   
        response.reset();// 清空输出流   
        String name=new String("韶关市紧缺人才统计.xls".getBytes("GB2312"), "ISO8859-1");
        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
        response.setContentType("application/msexcel");// 定义输出类型 
        try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findNeedSpecialtyType(form.getRetrieveSO());
			Map<String, Map> map = new HashMap<String, Map>();
			if (dtoList != null && dtoList.size() > 0) {
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}

				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					map.put("100", amap);
				}
			}
			//区县字典
			Map<String, String> countyMap=this.getConfTypeMap("5");
			//人才类型字典
			Map<String, String> personTypeMap=this.getConfTypeMap("11");
	        HSSFWorkbook workbook = new HSSFWorkbook(); //创建execl
	     // 用于格式化单元格的数据
			HSSFDataFormat format = workbook.createDataFormat();
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName(" 黑体 "); // 字体
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
			// font.setStrikeout(true); // 是否使用划线
			// 设置单元格类型
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFont(font);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
			cellStyle.setWrapText(true);
			// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
			HSSFSheet sheet = workbook.createSheet("专业统计");
			//设置宽度
			sheet.setColumnWidth(1, 2500);
			sheet.setColumnWidth(2, 5000);
			sheet.setColumnWidth(3, 5000);
			sheet.setColumnWidth(4, 3000);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6, 2500);
			sheet.setColumnWidth(7, 2500);
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			//第一行
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("专业"));
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("管理"));
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("技术"));
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("艺术"));
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("营销"));
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("协会"));
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("其他"));
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("总数"));
			cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setWrapText(true);
			if (map!=null&&map.size()>0) {
				int count=1;
				//循环多少个区域
				for (String str : map.keySet()) {
					 row = sheet.createRow(count);
					 count++;
					 cell = row.createCell(0);
					 cell.setCellStyle(cellStyle);
					 String l="";
					 if(str.trim().equals("100")){
						 l="总数";
					 }else{
						 l=countyMap.get(str);
					 }
					 cell.setCellValue(new HSSFRichTextString(l));
					Map<String, Long> amap=map.get(str);
					//循环人才类型
					for (int i = 1; i < 7; i++) {
						 cell = row.createCell(i);
						 if(amap.get(String.valueOf(i))!=null){
							 cell.setCellValue(amap.get(String.valueOf(i)));
						 }else{
							 cell.setCellValue(0);
						 }
					}
					//取总数
					 cell = row.createCell(7);
					 cell.setCellValue(amap.get(String.valueOf("10")));
				}
			}
			workbook.write(os); // 写入文件   
			os.close(); // 关闭流
			return this.NONE;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return this.NONE;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public String queryTechnicallytype() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findTechnicallytype(form.getRetrieveSO());
			form.getRetrieveSO().setForage(forage);
			form.getRetrieveSO().setToage(toage);
			if (dtoList != null && dtoList.size() > 0) {
				Map<String, Map> map = new HashMap<String, Map>();
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}

				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);//总数
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					form.setCountList(amap);
				}
				form.setDtoList(map);
			}
			form.setConfList(this.getConfTypeMap("12"));
			form.setPersonTypeList(this.getConfTypeMap("11"));
			return  "technicallytype";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return "technicallytype";
		}
	}
	
	public String ExportTechnicallytypeExecl() throws Exception {
		HttpServletResponse response=getResponse();
		OutputStream os = response.getOutputStream();// 取得输出流   
        response.reset();// 清空输出流   
        String name=new String("韶关职市称等级人才统计.xls".getBytes("GB2312"), "ISO8859-1");
        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
        response.setContentType("application/msexcel");// 定义输出类型 
        try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_TECH, queryInputParameter);// 保存查询日志
			if(null!=dqType && dqType.trim().length()>0){
				form.getRetrieveSO().setPcounty(dqType);
			}
			dealRetrieveSO();
			// 调用ws
			List<RctjDetailDTO> dtoList = (List<RctjDetailDTO>) pcountyRctjService
					.findTechnicallytype(form.getRetrieveSO());
			Map<String, Map> map = new HashMap<String, Map>();
			if (dtoList != null && dtoList.size() > 0) {
				for (RctjDetailDTO dto : dtoList) {
					Map<String, Long> amap = map.get(dto.getArea());
					if (amap != null && amap.size() > 0) {
						if (amap.get(dto.getType().trim()) != null&& !"".equals(amap.get(dto.getType().trim()))) {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount() + amap.get(dto.getType().trim()));
						} else {
							map.get(dto.getArea()).put(dto.getType().trim(),dto.getCount());
						}
					} else {
						Map<String, Long> lmap = new HashMap<String, Long>();
						lmap.put(dto.getType(), dto.getCount());
						map.put(dto.getArea(), lmap);
					}

				}
				if(map!=null&&map.size()>0){
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						Long count=new Long(0);
						for (String a : amap.keySet()) {
							count =count+amap.get(a);
						}
						map.get(s).put("10", count);
					}
				}
				if(map!=null&&map.size()>1){
					Long count1=new Long(0);
					Long count2=new Long(0);
					Long count3=new Long(0);
					Long count4=new Long(0);
					Long count5=new Long(0);
					Long count6=new Long(0);
					Long count7=new Long(0);
					Long count10=new Long(0);
					for (String s : map.keySet()) {
						Map<String, Long> amap = map.get(s);
						count1=amap.get("1")==null?count1:amap.get("1")+count1;
						count2=amap.get("2")==null?count2:amap.get("2")+count2;
						count3=amap.get("3")==null?count3:amap.get("3")+count3;
						count4=amap.get("4")==null?count4:amap.get("4")+count4;
						count5=amap.get("5")==null?count5:amap.get("5")+count5;
						count6=amap.get("6")==null?count6:amap.get("6")+count6;
						count7=amap.get("7")==null?count7:amap.get("7")+count7;
						count10=amap.get("10")==null?count10:amap.get("10")+count10;
					}
					Map<String, Long> amap = new HashMap<String, Long>();
					amap.put("1", count1);
					amap.put("2", count2);
					amap.put("3", count3);
					amap.put("4", count4);
					amap.put("5", count5);
					amap.put("6", count6);
					amap.put("7", count7);
					amap.put("10", count10);
					map.put("100", amap);
				}
			}
			//区县字典
			Map<String, String> countyMap=this.getConfTypeMap("12");
			//人才类型字典
			Map<String, String> personTypeMap=this.getConfTypeMap("11");
	        HSSFWorkbook workbook = new HSSFWorkbook(); //创建execl
	     // 用于格式化单元格的数据
			HSSFDataFormat format = workbook.createDataFormat();
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName(" 黑体 "); // 字体
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 宽度
			// font.setStrikeout(true); // 是否使用划线
			// 设置单元格类型
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFont(font);
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
			cellStyle.setWrapText(true);
			// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
			HSSFSheet sheet = workbook.createSheet("职称统计");
			//设置宽度
			sheet.setColumnWidth(0, 2500);
			sheet.setColumnWidth(1, 2500);
			sheet.setColumnWidth(2, 5000);
			sheet.setColumnWidth(3, 5000);
			sheet.setColumnWidth(4, 3000);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6, 2500);
			sheet.setColumnWidth(7, 2500);
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			//第一行
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("职称级别"));
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("党政人才"));
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("企业经营管理人才"));
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("专业技术人才"));
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("高技能人才"));
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("农村实用人才"));
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("社工人才"));
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue( new HSSFRichTextString("总数"));
			cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyle.setWrapText(true);
			if (map!=null&&map.size()>0) {
				int count=1;
				//循环多少个区域
				for (String str : map.keySet()) {
					 row = sheet.createRow(count);
					 count++;
					 cell = row.createCell(0);
					 cell.setCellStyle(cellStyle);
					 String l="";
					 if(str.trim().equals("100")){
						 l="总数";
					 }else{
						 l=countyMap.get(str);
					 }
					 cell.setCellValue(new HSSFRichTextString(l));
					Map<String, Long> amap=map.get(str);
					//循环人才类型
					for (int i = 1; i < 7; i++) {
						 cell = row.createCell(i);
						 if(amap.get(String.valueOf(i))!=null){
							 cell.setCellValue(amap.get(String.valueOf(i)));
						 }else{
							 cell.setCellValue(0);
						 }
					}
					//取总数
					 cell = row.createCell(7);
					 cell.setCellValue(amap.get(String.valueOf("10")));
				}
			}
			workbook.write(os); // 写入文件   
			os.close(); // 关闭流
			return this.NONE;
		} catch (Exception ex) {
			ex.printStackTrace();
			this.handleException(queryInputParameter, Constants.SOA_TECH, ex);
			return  this.NONE;
		}
	}

	public RctjForm getForm() {
		return form;
	}

	public void setForm(RctjForm form) {
		this.form = form;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public String getIsCanSee() {
		return isCanSee;
	}

	public void setIsCanSee(String isCanSee) {
		this.isCanSee = isCanSee;
	}
	
}
