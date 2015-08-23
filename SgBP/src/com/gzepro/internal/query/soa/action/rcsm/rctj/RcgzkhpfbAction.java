/**
 * 
 */
package com.gzepro.internal.query.soa.action.rcsm.rctj;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import wsepr.easypoi.excel.Excel;

import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.action.rcsm.base.RsTalantTeamAction;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.rckh.RckhForm;
import com.gzepro.internal.query.soa.service.user.impl.RsRcgzkhpfbService;
import com.gzepro.internal.query.soa.service.user.impl.RsRczytjnrService;
import com.gzepro.internal.query.soa.service.user.impl.RsTalantTeamService;
import com.gzepro.internal.query.system.model.RsRcgzkhpfb;
import com.gzepro.internal.query.system.model.RsRczytjnr;

/**
 * @author SgBP 广州易宝信息技术有限公司
 * @since  2013-3-21
 * @version 1.0
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.RcgzkhpfbAction")
public class RcgzkhpfbAction extends SoaBaseJsonAction {
	private RsRcgzkhpfbService rsRcgzkhpfbService;
	private RckhForm form = new RckhForm();
	
	private RsRczytjnrService rsRczytjnrService;
	
	private RsTalantTeamService rsTalantTeamService;
	
	private RsTalantTeamAction rsTalantTeam;
	
	private String _nowYear;
	private String isQuan;

	public String saveOrUpdate(){
		//按6大类人才计算，每类人才数据库各2分
		set_nowYear();
		String strYearStrat = form.getRsRcgzkhpfb().getYear()+"-01"+"-01";
		String strYearEnd = form.getRsRcgzkhpfb().getYear()+"-12"+"-31";
		setBLZZL();
		List<Object> obj=null;
		List<RsRcgzkhpfb> list_ = rsRcgzkhpfbService.findByYear(form.getRsRcgzkhpfb().getPcounty(), form.getRsRcgzkhpfb().getYear());
		if(list_ != null && list_.size() != 0){
			form.getRsRcgzkhpfb().setPk(list_.get(0).getPk());
		}
		
		obj= rsRcgzkhpfbService.findBySql("select count(*),y.type from RS_PERSONTYPE y join RS_PERSON r on y.personid=r.personid and pcounty like '"+form.getRsRcgzkhpfb().getPcounty()+"' group by y.type");
		int count = 0;
		count = obj.size() * 2 >12?12:obj.size() * 2;
		form.getRsRcgzkhpfb().setJlrcxxk(count+"");
		//博士学位或正高人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNICALLYMESS y join RS_PERSON r on y.personid=r.personid and (y.technicallyLevel='5' or r.cultureType='1') and r.pcounty " +
				"like '"+form.getRsRcgzkhpfb().getPcounty()+"' and r.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and r.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _bsrs = ((BigDecimal)obj.get(0)).intValue();		
//		//副高职称人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNICALLYMESS y join RS_PERSON r on y.personid=r.personid and y.technicallyLevel='4' and r.pcounty " +
				"like '"+form.getRsRcgzkhpfb().getPcounty()+"' and r.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and r.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _fgrs = ((BigDecimal)obj.get(0)).intValue();
//		//硕士人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_PERSON r where r.cultureType='2' and " +
				"r.pcounty like '"+form.getRsRcgzkhpfb().getPcounty()+"' and r.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and r.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _ssrs = ((BigDecimal)obj.get(0)).intValue();
//		//本科人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_PERSON r where r.cultureType='3' and " +
				"r.pcounty like '"+form.getRsRcgzkhpfb().getPcounty()+"' and r.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and r.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _bkrs = ((BigDecimal)obj.get(0)).intValue();
		float count1 = _bsrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getBsxwbl())))+
				_fgrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getFgzc())))+
				_ssrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getSsrc())))+
				_bkrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getBkrc())));
		count1 = count1 > 6 ? 6 : count1;
		form.getRsRcgzkhpfb().setJqrcyj(setfloat(count1));
//		//副高总人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNICALLYMESS y join RS_PERSON r on y.personid=r.personid and y.technicallyLevel='4' and r.pcounty " +
				"like '"+form.getRsRcgzkhpfb().getPcounty()+"' and y.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and y.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _fgzrs = ((BigDecimal)obj.get(0)).intValue();
//		//正高总人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNICALLYMESS y join RS_PERSON r on y.personid=r.personid and y.technicallyLevel='5' and r.pcounty " +
				"like '"+form.getRsRcgzkhpfb().getPcounty()+"' and y.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and y.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _zgzrs = ((BigDecimal)obj.get(0)).intValue();
		float count2 = _fgzrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getJsfg())))+
				_zgzrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getJszg())));
		count2 = count2 > 4 ? 4 : count2;
		form.getRsRcgzkhpfb().setJqrcpy(setfloat(count2));
//		
//		//省级项数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNOLOGICALHARVEST y join RS_PERSON r on y.personid=r.personid and y.harvestLevel='2' and r.pcounty " +
				"like '"+form.getRsRcgzkhpfb().getPcounty()+"' and y.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and y.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _sjxs = ((BigDecimal)obj.get(0)).intValue();
//		//市级项数
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNOLOGICALHARVEST y join RS_PERSON r on y.personid=r.personid and y.harvestLevel='3' and r.pcounty " +
				"like '"+form.getRsRcgzkhpfb().getPcounty()+"' and y.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and y.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _sjzrs = ((BigDecimal)obj.get(0)).intValue();
		float count3 = _sjxs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getSjjl())))+
				_sjzrs *(Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getBsjl())));
		count3 = count3 > 3 ? 3 : count3;
		setCount();
		form.getRsRcgzkhpfb().setKxjsjl(setfloat(count3));
		rsRcgzkhpfbService.saveOrUpdate(form.getRsRcgzkhpfb());
		form.setPcounty(form.getRsRcgzkhpfb().getPcounty());
		form.setYear(form.getRsRcgzkhpfb().getYear());
		return "rcgzkhpfb";
	}
	//每万人口中人才资源总量及增长率
	private String setBLZZL(){
		float[] arr_p = rsTalantTeam.getDataMap(form.getRsRcgzkhpfb().getPcounty(),form.getRsRcgzkhpfb().getYear());
		//每万人口中人才资源总量及增长率
		form.getRsRcgzkhpfb().setRczyzlhzzl(setfloat(arr_p[0]*10));
		//企业经营管理人才占从业人员比例<br />及增长率
		form.getRsRcgzkhpfb().setQyjyglrc(setfloat(arr_p[1]*8));
		//专业技术人才占从业人员比例及增长率
		form.getRsRcgzkhpfb().setZyjsrc(setfloat(arr_p[2]*8));
		//农村实用人才占农村劳动力比例及增长率
		form.getRsRcgzkhpfb().setNcsyrc(setfloat(arr_p[3]*9));
		return null;
	}
		
	private String setfloat(float value){
		BigDecimal   b   =   new   BigDecimal(value);
		return b.setScale(1,BigDecimal.ROUND_HALF_UP).floatValue()+"";		  
	}
	
	private String setCount(){
		float value = Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getZtyjrcgz()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getCtrcgzwj()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getJlrcxxk()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getBgrcgzqk()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getRczykfzxzj()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getXcyxrcsj()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getSszdrcgz()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getJqrcyj()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getJqrcpy()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getKxjsjl()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getZysqsl()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getGxjsqy()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getGcjsyjkfzx()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getRczyzlhzzl()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getQyjyglrc()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getZyjsrc()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getNcsyrc()));
			value +=  Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getShgzrc()));
			  
		form.getRsRcgzkhpfb().setCountall(setfloat(value));
		value += Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getSrcgzxm()))+
				Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getYjqrjh()))+
				Float.parseFloat(setValue0(form.getRsRcgzkhpfb().getYjgdscxtd()))
				;	 
		form.getRsRcgzkhpfb().setEndcountall(setfloat(value));
		return null;
	}
	
	private String setValue0(String value){
		if(value == null || value.equals("")){
			return "0";
		}
		try {
			Float.parseFloat(value);
		} catch (Exception e) {
			return "0";
		}
		return value;
	}
	
	public String query(){
		set_nowYear();
		List<RsRcgzkhpfb> list = null;
		if(form.getPcounty() != null && !form.getPcounty().equals("")
				&& form.getYear() != null && !form.getYear().equals("")){
			list = rsRcgzkhpfbService.findByYear(form.getPcounty(),form.getYear());
		}		
		if(list != null && list.size() != 0){
			form.setRsRcgzkhpfb(list.get(0));
		}else{
			form.setRsRcgzkhpfb(new RsRcgzkhpfb());
		}
		return "rcgzkhpfb";
	}
	

	public String ExportRcgzkhpfbExecl(){
		try{
			
			String n = "人才工作考核评分表.xls";
			String url = "\\file";
			String fname = url + "\\";
			String pathname = fname + n;
			
			//weblogic 部署的war包没有 getRealPath()，需要以下方法获取路径
			int index = this.getClass().getClassLoader().getResource("/").getPath().indexOf("/WEB-INF");
			pathname = this.getClass().getClassLoader().getResource("/").getPath().substring(0,index) + pathname;

			String pcounty = form.getPcounty();
			String year = form.getYear();
			List<RsRcgzkhpfb> rcgzs = rsRcgzkhpfbService.findByYear(pcounty, year);
			
			Map conf = (Map) ServletActionContext.getServletContext().getAttribute("_WEB_SYS_CONF_KEY_");
			Map pconty_conf = (Map) conf.get("15");
			pcounty = (String) pconty_conf.get(pcounty);
			
			HSSFWorkbook workbook = generateExcleForRctj( rcgzs, pathname,pcounty);
			
			HttpServletResponse response = getResponse();
			response.reset();// 清空输出流
			
			String name = new String(n.getBytes("GB2312"), "ISO8859-1");
			if(workbook != null ){
			response.setHeader("Content-disposition", "attachment; filename=\""+ name + "\"");// 设定输出文件头
			response.setContentType("application/msexcel");// 定义输出类型
			OutputStream os = response.getOutputStream();// 取得输出流
			workbook.write(os);
			}else{
				response.setCharacterEncoding("GB2312");
				PrintWriter out = response.getWriter();
				out.print("<font size='5'>   该区县的年份考核评分数据不存在!</font>");
				out.close();
			}
			
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return this.NONE;
		}
		   
	}
	
public HSSFWorkbook generateExcleForRctj( List<RsRcgzkhpfb> rcgzs,String pathname, String pcounty) throws IOException {
		
		Excel excel = new Excel(pathname);
		HSSFWorkbook workbook = null;
		String sheetName = pcounty;
		if(sheetName != null)
		excel.sheet(0).sheetName(sheetName);
		
		if(rcgzs!=null&&rcgzs.size()>0){
		workbook = excel.getWorkBook();
		RsRcgzkhpfb r = rcgzs.get(0);
		
		HSSFFont fontTitle = workbook.createFont();
		fontTitle.setFontName("宋体"); // 使用字体
		fontTitle.setFontHeightInPoints((short) 22);
		fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		HSSFCellStyle cellStyleTitle = workbook.createCellStyle();
		cellStyleTitle.setFont(fontTitle); 
		cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		excel.cell(0,0).style(cellStyleTitle);
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(true); // 自动换行
		cellStyle.setBorderBottom((short) 1); // 设置边框样式
		cellStyle.setBorderLeft((short) 1); // 左边框
		cellStyle.setBorderRight((short) 1); // 右边框
		cellStyle.setBorderTop((short) 1);
		
		int khmode_column = 4;
		
		excel.cell(9, khmode_column).style(cellStyle);
		excel.cell(10, khmode_column).style(cellStyle);
		excel.cell(11,khmode_column).style(cellStyle);
		excel.cell(9,khmode_column).value("  得分=博士学位或正高人数×"+r.getBsxwbl()+"，副高职称人数×"+r.getFgzc()+"，硕士人数×"+r.getSsrc()+"，本科人数×"+r.getBkrc()+"，最高6分");
		excel.cell(10,khmode_column).value("   得分= 副高总人数×"+r.getFgzc()+"，正高总人数×"+r.getJszg()+"，  最高4分");
		excel.cell(11,khmode_column).value("  得分=省级项数×"+r.getSjjl()+"，市级项数×"+r.getBsjl()+"，最高3分");
		
		int score_column = 6;
		excel.cell(2,score_column).value(r.getZtyjrcgz());
		excel.cell(3,score_column).value(r.getCtrcgzwj());
		excel.cell(4,score_column).value(r.getJlrcxxk());
		excel.cell(5,score_column).value(r.getBgrcgzqk());
		excel.cell(6,score_column).value(r.getRczykfzxzj());
		excel.cell(7,score_column).value(r.getXcyxrcsj());
		excel.cell(8,score_column).value(r.getSszdrcgz());
		excel.cell(9,score_column).value(r.getJqrcyj());
		excel.cell(10,score_column).value(r.getJqrcpy());
		excel.cell(11,score_column).value(r.getKxjsjl());
		excel.cell(12,score_column).value(r.getZysqsl());
		excel.cell(13,score_column).value(r.getGxjsqy());
		excel.cell(14,score_column).value(r.getGcjsyjkfzx());
		excel.cell(15,score_column).value(r.getRczyzlhzzl());
		excel.cell(16,score_column).value(r.getQyjyglrc());
		excel.cell(17,score_column).value(r.getZyjsrc());
		excel.cell(18,score_column).value(r.getNcsyrc());
		excel.cell(19,score_column).value(r.getShgzrc());
		excel.cell(20,score_column).value(r.getCountall());
		excel.cell(21,score_column).value(r.getSrcgzxm());
		excel.cell(22,score_column).value(r.getYjqrjh());
		excel.cell(23,score_column).value(r.getYjgdscxtd());
		excel.cell(24,score_column).value(r.getEndcountall());
		}
		return workbook;
	}
	
	
	public String queryTJ(){
		set_nowYear();
		List<RsRczytjnr> _list = null;
		if(form.getYear() != null && !form.getYear().equals("")){
			_list = rsRczytjnrService.find(form.getYear());			
		}
		if(_list != null && _list.size() != 0){
			form.setRsRczytjnr(_list.get(0));
		}else{
			form.setRsRczytjnr(new RsRczytjnr());
		}
		return "rczytjnr";
	}
	
	public String saveOrupdateTong(){
		set_nowYear();
		//按6大类人才计算，每类人才数据库各2分
		String strYearStrat = form.getRsRczytjnr().getYear()+"-01"+"-01";
		String strYearEnd = form.getRsRczytjnr().getYear()+"-12"+"-31";
		List<Object> obj=null;
		List<RsRczytjnr> list= rsRczytjnrService.find(form.getRsRczytjnr().getYear());
		if(list != null && list.size() !=0){
			form.getRsRczytjnr().setPk(list.get(0).getPk());
		}
		//人才资源总量
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y");
		int rczyzs = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setRczyzl(rczyzs+"");
		//人才资源总量占人力资源总量比例
		float rczybl = rczyzs*100/Float.parseFloat(setValue0(form.getRsRczytjnr().getRlzyzl()));
		form.getRsRczytjnr().setRczybl(setfloat(rczybl)+"%");
		//党政、企业经营管理和专业技术人才中大学本科及以上学历<br />人员所占比例
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y where " +
				"y.personType like '%1%' or y.personType like '%2%' or y.personType like '%3%' ");
		int dzqyzs = ((BigDecimal)obj.get(0)).intValue();
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y where " +
				"(y.personType like '%1%' or y.personType like '%2%' or y.personType like '%3%') and y.cultureType in ('1','2','3') ");		
		int bkyszs = ((BigDecimal)obj.get(0)).intValue();
		float count;
		if(dzqyzs != 0){
			count = bkyszs*100/dzqyzs;
		}else{
			count = 0;
		}
		form.getRsRczytjnr().setBkysxlbl(setfloat(count)+"%");
		//农村实用人才平均受教育年限
		setNcsyrc();					
		//获得国家级、省级科学技术奖励数量
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNOLOGICALHARVEST y join RS_PERSON r on y.personid=r.personid and y.harvestLevel in ('1','2') " +
				" and y.adddate>=to_date('"+strYearStrat+"','YYYY-MM-dd') and y.adddate<=to_date('"+strYearEnd+"','YYYY-MM-dd') ");
		int _sjxs = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setHdgjjjlsl(_sjxs+"");
		//党政人才
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from " +
				"RS_PERSON y join view_rs_persontype r on y.personid=r.personid and y.personType like '%1%'");
		int dzrczl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setDzrczl(dzrczl+"");
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y " +
				"join view_rs_persontype r on y.personid=r.personid and y.personType like '%1%'  and y.cultureType in ('1','2','3') ");
		//大学本科及以上学历人数及比例
		int _bkysdzrczl = ((BigDecimal)obj.get(0)).intValue();
		if(dzrczl != 0){
			count = _bkysdzrczl*100/dzrczl;
		}else{
			count = 0;
		}
		form.getRsRczytjnr().setDzbkysrsbl(setfloat(count)+"%");
		//副科以上干部人数
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from " +
				"RS_PERSON y join view_rs_persontype r on y.personid=r.personid and y.personType like '%1%'" +
				" and (Dutylevel like '%科长%' or Dutylevel like '%科员%' or Dutylevel like '%处长%' or Dutylevel like '%局长%' or Dutylevel like '%调研员%')");
		int dzrcfkjzl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setDzrcfkjzl(dzrcfkjzl+"");
		
		//企业经<br />营管理<br />人才
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from " +
				"RS_PERSON y join view_rs_persontype r on y.personid=r.personid and r.type like '%2%'");
		int qyrczl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setQyrczl(qyrczl+"");
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y join " +
				"view_rs_persontype r on y.personid=r.personid and r.type like '%2%'  and y.cultureType in ('1','2','3') ");		
		//大学本科及以上学历人数及比例
		int _bkyqyrczl = ((BigDecimal)obj.get(0)).intValue();
		if(dzrczl != 0){
			count = _bkyqyrczl*100/qyrczl;
		}else{
			count = 0;
		}
		form.getRsRczytjnr().setQybkysszbl(setfloat(count)+"%");
		//占从业人员的比例
		int nmcyrys = Integer.parseInt(form.getRsRczytjnr().getNmcyrys());
		if(nmcyrys != 0){
			count = qyrczl*100/nmcyrys;
		}else{
			count = 0;
		}
		form.getRsRczytjnr().setQyzcyrcbl(setfloat(count)+"%");
		//专业技<br />术人才
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON" +
				" y join view_rs_persontype r on y.personid=r.personid and r.type like '%3%'");
		int zyrczl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setZyjszl(zyrczl+"");
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from " +
				"RS_PERSON y join view_rs_persontype r on y.personid=r.personid and r.type like '%3%'  and y.cultureType in ('1','2','3') ");		
		//大学本科及以上学历人数及比例
		int _bkyzyrczl = ((BigDecimal)obj.get(0)).intValue();
		if(zyrczl != 0){
			count = _bkyzyrczl*100/zyrczl;
		}else{
			count = 0;
		}
		form.getRsRczytjnr().setZybkjysbl(setfloat(count)+"%");
		//占从业人员的比例及
		if(nmcyrys != 0){
			count = zyrczl*100/nmcyrys;
		}else{
			count = 0;
		}
		form.getRsRczytjnr().setZyzcyrcbl(setfloat(count)+"%");
		//高技<br />能人才
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from " +
				"RS_PERSON y join view_rs_persontype r on y.personid=r.personid and r.type like '%4%'");
		int gjnrczl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setRlzyzhslzs(gjnrczl+"");
		//农村实<br />用人才
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y join view_rs_persontype r on y.personid=r.personid and r.type like '%5%'");
		int ncrczl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setNcrczl(ncrczl+"");
		//社会工<br />作人才
		obj= rsRcgzkhpfbService.findBySql("select count(*) as count from RS_PERSON y join view_rs_persontype r on y.personid=r.personid and r.type like '%6%'");
		int shgzzl = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setShgzzl(shgzzl+"");
		//具有副高以上职称人才数量
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_TECHNICALLYMESS y join RS_PERSON r on y.personid=r.personid and y.technicallyLevel in('4','5') ");
		int _fgzrs = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setJyfgrcsl(_fgzrs+"");
		//具有博士学位人才数量
		obj= rsRcgzkhpfbService.findBySql("select count(*) from RS_PERSON r where r.cultureType like '1'");
		int _bszrs = ((BigDecimal)obj.get(0)).intValue();
		form.getRsRczytjnr().setJybsrcsl(_bszrs+"");
		rsRczytjnrService.saveOrUpdate(form.getRsRczytjnr());
		return "rczytjnr";
	}
	
	private String setNcsyrc(){
		//农村实用人才平均受教育年限
		List<Object> list = rsRcgzkhpfbService.findBySql("select count(*) as count,y.cultureType from RS_PERSON y join view_rs_persontype r on y.personid=r.personid and r.type like '%5%' group by y.cultureType order by cultureType desc");				
		String[][] arr_year = {{"1","20"},{"2","17"},{"3","14"},{"4","13"},{"5","12"},{"6","9"}};
		int yearCount = 0;
		int rcCount = 0;
		if(list == null || list.size() == 0){
			form.getRsRczytjnr().setNcsyrcjynx("0");
			return null;
		}
		for(int i = 0; i<list.size();i++){
			Object[] obj = (Object[])list.get(i);
			int count = ((BigDecimal)obj[0]).intValue();
			String type = (String)obj[1] == null ? "":((String)obj[1]).trim();
			for(int j = 0; j < arr_year.length; j++){
				if((arr_year[j][0]).equals(type)){
					yearCount += Integer.parseInt(arr_year[j][1])*count;
					rcCount += count;
					break;
				}
			}
		}
		if(rcCount != 0){
			float value = yearCount/rcCount;
			form.getRsRczytjnr().setNcsyrcjynx(setfloat(value));
		}else{
			form.getRsRczytjnr().setNcsyrcjynx("0");
		}
		return null;
		
	}

	public String ExportRczytjnrExecl() {
		try {

			String n = "全市人才资源统计内容及任务分工.xls";
			String url = "\\file";
			String fname = url + "\\";
			String pathname = fname + n;
			
			//weblogic 部署的war包没有 getRealPath()，需要以下方法获取路径
			int index = this.getClass().getClassLoader().getResource("/").getPath().indexOf("/WEB-INF");
			pathname = this.getClass().getClassLoader().getResource("/").getPath().substring(0,index) + pathname;
			
			String year = form.getYear();
			List<RsRczytjnr>  rc = rsRczytjnrService.find(year);
		 
			HSSFWorkbook workbook = generateExcleForRczytjnr( rc, pathname);

			HttpServletResponse response = getResponse();
			
			
			if(workbook != null ){
				OutputStream os = response.getOutputStream();// 取得输出流
				response.reset();// 清空输出流
				String name = new String((year+n).getBytes("GB2312"), "ISO8859-1");
				response.setHeader("Content-disposition", "attachment; filename=\""
						+ name + "\"");// 设定输出文件头
				response.setContentType("application/msexcel");// 定义输出类型
				workbook.write(os);
				}else{
					response.setCharacterEncoding("GB2312");
					PrintWriter out = response.getWriter();
					out.write("<font size='5'>   该年份的数据不存在!</font>");
					out.flush();
					out.close();
				}
			
		 

			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return this.NONE;
		}
	}

	private HSSFWorkbook generateExcleForRczytjnr(List<RsRczytjnr> rc, String pathname) {
		Excel excel = new Excel(pathname);
		HSSFWorkbook workbook = null;
		
		if(rc!=null&&rc.size()>0){
			workbook = excel.getWorkBook();
			RsRczytjnr r = rc.get(0);
			int zrunits = 3;
			excel.cell(4,zrunits).value(r.getRlzyzhslzs());
			excel.cell(5,zrunits).value(r.getRlzbgxl());
			excel.cell(6,zrunits).value(r.getRcgxl());
			
			
			excel.cell(8,zrunits).value(r.getRczyzl());
			excel.cell(9,zrunits).value(r.getRlzyzl());
			excel.cell(10,zrunits).value(r.getRczybl());
			excel.cell(11,zrunits).value(r.getBkysxlbl());
			excel.cell(12,zrunits).value(r.getGjnrcbl()); 
			excel.cell(13,zrunits).value(r.getNcsyrcjynx());
			excel.cell(14,zrunits).value(r.getGnpjsjynx());   
			excel.cell(15,zrunits).value(r.getXzldsjynx());   
			excel.cell(16,zrunits).value(r.getZyldnlrksjy()); 
			excel.cell(17,zrunits).value(r.getMwldlzyfry());  
			excel.cell(18,zrunits).value(r.getMbwrkkxjrs());  
			excel.cell(19,zrunits).value(r.getNmcyrys());     
			excel.cell(20,zrunits).value(r.getCyryszbl());    
			                                            
			excel.cell(22,zrunits).value(r.getRlzbtzzbl());   
			excel.cell(23,zrunits).value(r.getRczxzjzbl());	 
			excel.cell(24,zrunits).value(r.getCzrlzbtzzbl());	 
			excel.cell(25,zrunits).value(r.getQsfmzlsql());	 
			excel.cell(26,zrunits).value(r.getQsgjzlsql());	 
			excel.cell(27,zrunits).value(r.getGjkjlwsll());	 
			excel.cell(28,zrunits).value(r.getGjkjlwyyl());	 
			excel.cell(29,zrunits).value(r.getHdgjjjlsl());	 
			                                           
			excel.cell(31,zrunits).value(r.getDzrczl());     
			excel.cell(32,zrunits).value(r.getDzrcfkjzl());	 
			excel.cell(33,zrunits).value(r.getDzbkysrsbl());	 
			excel.cell(34,zrunits).value(r.getXlygwyszbl());	 
			excel.cell(35,zrunits).value(r.getQyrczl());		 
			excel.cell(36,zrunits).value(r.getQybkysszbl());	 
			excel.cell(37,zrunits).value(r.getQyyjwgzszbl()); 
			excel.cell(38,zrunits).value(r.getSchfsxprcs());	 
			excel.cell(39,zrunits).value(r.getFgyjjqyrcsl());	 
			                                             
			excel.cell(40,zrunits).value(r.getQyzcyrcbl());    
			excel.cell(41,zrunits).value(r.getZyjszl());		 
			excel.cell(42,zrunits).value(r.getZyfjjrczl());	 
			excel.cell(43,zrunits).value(r.getZybkjysbl());	 
			excel.cell(44,zrunits).value(r.getZyzcyrcbl());	 
			excel.cell(45,zrunits).value(r.getQyzyjsrsbl());	 
			excel.cell(46,zrunits).value(r.getRlzyzhslzs());	 
			excel.cell(47,zrunits).value(r.getGjnfgjjsl());	 
			
			excel.cell(48,zrunits).value(r.getNcrczl());    
			excel.cell(49,zrunits).value(r.getNczldlbl()); 
			excel.cell(50,zrunits).value(r.getShgzzl());	 
			excel.cell(51,zrunits).value(r.getShgsysl());	 
			excel.cell(52,zrunits).value(r.getShgszbl());	 
			excel.cell(53,zrunits).value(r.getJyfgrcsl());	 
			excel.cell(54,zrunits).value(r.getJybsrcsl());	 
			excel.cell(55,zrunits).value(r.getZzbshrcsl());	 
			excel.cell(56,zrunits).value(r.getYjgccrcsl()); 
			
			excel.cell(58,zrunits).value(r.getXzgxqymd());     
			excel.cell(59,zrunits).value(r.getXzgjjyjzx());	 
			excel.cell(60,zrunits).value(r.getXzgjjqyzx());	 
			excel.cell(61,zrunits).value(r.getXzgjjsys());	 
			excel.cell(62,zrunits).value(r.getXzgcsys());	 
			excel.cell(63,zrunits).value(r.getXzkygzz());	 
			
		
		}
		

		return workbook;
	}

	public RsRcgzkhpfbService getRsRcgzkhpfbService() {
		return rsRcgzkhpfbService;
	}

	public void setRsRcgzkhpfbService(RsRcgzkhpfbService rsRcgzkhpfbService) {
		this.rsRcgzkhpfbService = rsRcgzkhpfbService;
	}

	public RckhForm getForm() {
		return form;
	}

	public void setForm(RckhForm form) {
		this.form = form;
	}

	public RsRczytjnrService getRsRczytjnrService() {
		return rsRczytjnrService;
	}

	public void setRsRczytjnrService(RsRczytjnrService rsRczytjnrService) {
		this.rsRczytjnrService = rsRczytjnrService;
	}
	public RsTalantTeamService getRsTalantTeamService() {
		return rsTalantTeamService;
	}
	public void setRsTalantTeamService(RsTalantTeamService rsTalantTeamService) {
		this.rsTalantTeamService = rsTalantTeamService;
	}
	public RsTalantTeamAction getRsTalantTeam() {
		return rsTalantTeam;
	}
	public void setRsTalantTeam(RsTalantTeamAction rsTalantTeam) {
		this.rsTalantTeam = rsTalantTeam;
	}
	public String get_nowYear() {
		return _nowYear;
	}
	public void set_nowYear() {
		this._nowYear = DateUtil.getCurDate().substring(0, 4);
	}
	public String getIsQuan() {
		return isQuan;
	}
	public void setIsQuan(String isQuan) {
		this.isQuan = isQuan;
	}
	
}
