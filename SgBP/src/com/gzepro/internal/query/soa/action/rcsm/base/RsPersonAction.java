package com.gzepro.internal.query.soa.action.rcsm.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.gmcc.support.trade.service.provider.rcsm.affix.RsAffixVo;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.exception.ValidateException;
import com.gzepro.internal.query.common.struts.interceptor.LoginInterceptor;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.HtmlToJpgUtil;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.StrUtils;
import com.gzepro.internal.query.model.RsPerson;
import com.gzepro.internal.query.model.RsResult;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.QueryRsPersonListSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RetrieveRsPersonSO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonForm;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.RsPersonListDTO;
import com.gzepro.internal.query.soa.service.user.impl.RsAffixService;
import com.gzepro.internal.query.soa.service.user.impl.RsPersonService;
import com.gzepro.internal.query.system.action.LoginAction;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.service.ConfService;
import com.gzepro.internal.query.system.service.ExcelService;
import com.gzepro.internal.query.system.service.RsPersonSer;

/**
 * 
  * @ClassName: RsPersonAction
  * @Description: TODO(后台业务系统人员信息Action类)
  * @author 张建薇
  * @date Jul 25, 2012 10:31:10 AM
  *
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.RsPerson")
public class RsPersonAction  extends SoaBaseJsonAction{
	//execl最大行数
	public static int rowcount=1000;
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	public static SimpleDateFormat sdfDay=new SimpleDateFormat("yyyyMMdd");
	public static final int BUFFER = 1024 ;//缓存大小 
	@Resource
	private RsPersonService rsPersonService;// 通过spring注入业务实例
	@Resource
	private ConfService confService;
	private RsPersonForm form = new RsPersonForm();// 查询表单封装对象
	
	@Resource
	private RsPersonSer rsPersonSer;
	
	@Resource
	protected ExcelService excelService;// Exel批量导入的接口serice
	
	@Resource
	private RsAffixService rsAffixService;//附件服务业务调用类
	
	private RsAffixDTO rsAffix = new RsAffixDTO();//附件查询参数的封装对象
	private File[] uploadFile;//上传文件，已字节类型保存到数据库
	
	private String htmlSrc = "";
	
		/**
	 * @return the htmlSrc
	 */
	public String getHtmlSrc() {
		return htmlSrc;
	}
	/**
	 * @param htmlSrc the htmlSrc to set
	 */
	public void setHtmlSrc(String htmlSrc) {
		this.htmlSrc = htmlSrc;
	}
	
		//测试入口
	@Override
	public String execute() throws Exception {
		return "search";
	}
	public String toaddPage(){		
		this.getSession().remove("personId");
		this.getSession().remove("personName");
		this.getSession().remove("personIdCard");
		this.getSession().remove("auditstate");
		this.validateUserType();
		this.setUserCountry();
		return "toaddPage";
	}
	public void setUserCountry(){
		Object usercountry=this.getSession().get(LoginAction.ACCOUNT_TYPE);
		if(usercountry!=null&&!"".equals(usercountry)){
			form.setUsercountry(usercountry.toString());
		}
	}
	/**
	 * 将预览信息的html生成jpg图片
	 * @return	结果
	 */
	public String saveHtmlSrc(){
		JSONObject json = new JSONObject();
		try {
			byte[] b = HtmlToJpgUtil.toJpg(htmlSrc);
			
			String fileName = "韶关市人才信息_"+form.getDto().getPname()+".jpg";
			rsAffix.setAffixContext(b);
			rsAffix.setAffixName(fileName);
			rsAffix.setAffixStyle("1");// jpg
			rsAffix.setAffixType("2");// 采集表
			rsAffix.setAuditState("000");
			rsAffix.setDeleState("0");
			rsAffix.setUploadDate(DateUtil.getCurDate());
			rsAffix.setUploadPerson(this.getAccount().getLoginCode());
			rsAffix.setPersonId(form.getDto().getPersonId());
			RsAffixVo vo = rsAffixService.saveOrUpdateVo(rsAffix);
			
			json.put("gdImgID", vo.getAffixId());
			json.put("msg", "归档保存成功");
		} catch (Exception ex) {
			json.put("msg", "归档保存失败！");
			// 统一异常处理类
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	//点修改进入修改页面
	@SuppressWarnings("unchecked")
	public String toEditPage(){
		String personId = form.getRetrieveSO().getPersonId();
		this.getSession().put("personId", personId);
		if(personId != null && !personId.equals("")){//编辑
			try {
				RsPersonDetailDTO dto= (RsPersonDetailDTO) rsPersonService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
				String pt = dto.getPersonType();
				if(pt != null && pt.trim().length() > 0) {
					Map<String, String> map = new HashMap<String, String>();
					pt = pt.trim();
					String[] pts = pt.split(",");
					for(String p : pts) {
						if(p != null && p.trim().length() > 0) {
							map.put(p.trim(), p.trim());
						}
					}
					this.request.setAttribute("_PERSON_TYPE", map);
				}
				this.getSession().put("personName", dto.getPname());
				this.getSession().put("personIdCard", dto.getIdCard());
				this.getSession().put("auditstate", dto.getAuditstate());
				rsAffix = new RsAffixDTO();
				rsAffix.setPersonId(personId);
				rsAffix.setDeleDate("0");
				rsAffix.setAffixType("1");
				List<RsAffixDTO> affixList = (List<RsAffixDTO>) rsAffixService.query(rsAffix, menuId, this.getAccount().getId());
				if(affixList!=null&&affixList.size()>0){
					form.setAffixList(affixList);
				}else{
					form.setAffixList(new ArrayList<RsAffixDTO>());
				}
				//处理子典显示数据
				form.setDto(dto);
				this.setUserCountry();
			} catch (Exception ex) {
				// 统一异常处理类
				this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			}
		}
		return "toaddPage";
	}
	public String goQuery() {
		this.setUserCountry();
		return "query";
	}
	
	/**
	 * 精确查询人员列表
	 */
	public String query() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("query");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(form.getQueryListSO().getDelestate()==null){
				form.getQueryListSO().setDelestate("0");//默认查询未删除的人员
			}
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getIdCard()!=null){
				form.getQueryListSO().setIdCard(form.getQueryListSO().getIdCard().trim());
			}
			if(form.getQueryListSO().getBatchcode()!=null){
				form.getQueryListSO().setBatchcode(form.getQueryListSO().getBatchcode().trim());
			}
			//验证用户类型:市本级/县级
			validateUserType();
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "list";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "error";
		}
	}
	

	/**
	 * 精确查询人员列表
	 */
	public String jqQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("query");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getIdCard()!=null){
				form.getQueryListSO().setIdCard(form.getQueryListSO().getIdCard().trim());
			}
			//验证用户类型:市本级/县级
			validateUserType();
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "query";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "query";
		}
	}
	
	/**
	 * 精确导出人员基本信息
	 * 
	 * 2012-9-4 王志
	 */
	public String jqQueryExecl() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			HttpServletResponse response=getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流   
			  response.reset();// 清空输出流   
			QueryRsPersonListSO so= form.getQueryListSO();
			String pcounty="";
			String unitlvl=so.getUnitlvl();
			Object usercountry=this.getSession().get(LoginAction.ACCOUNT_TYPE);
			if(usercountry!=null&&!"".equals(usercountry)){
				pcounty=usercountry.toString();
				unitlvl="3";
			}
		    long count=	excelService.jqQueryRsperson(so.getPname(), so.getIdCard(), so.getPersonType(),pcounty,unitlvl);
			if(count<=0){
				  HSSFWorkbook workbook = new HSSFWorkbook(); //创建execl
				String n="韶关市人才基本信息.xls";
		        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
		        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
		        response.setContentType("application/msexcel");// 定义输出类型 
				workbook.write(os); // 写入文件   
			}else if (count<=rowcount) {
				String n="韶关市人才基本信息.xls";
		        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
		        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
		        response.setContentType("application/msexcel");// 定义输出类型 
		        Paging p=new Paging();
		        p.setPageSize(rowcount);
		        p.setStartRow(1);
		        p =excelService.jqQueryRsperson(so.getPname(), so.getIdCard(), so.getPersonType(),p,pcounty,unitlvl);
			    List<RsPerson> list=p.getVoList();    
			    getExecl(list).write(os); // 写入文件   
			}else{
				String n="韶关市人才基本信息.zip";
		        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
		        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
		        response.setContentType("application/zip");// 定义输出类型 
		        int index = this.getClass().getClassLoader().getResource("/").getPath().indexOf("/WEB-INF");
				String url = this.getClass().getClassLoader().getResource("/").getPath().substring(0,index) + "\\file"+"\\"+DateUtil.dateToDateString(new Date(), "yyyyMMdd");
		        
		       String folder= "P"+sdf.format(new Date(System.currentTimeMillis()));
		       String fname= url+"\\"+folder+"\\";
		        for (int i = 1; i < 1000; i++) {
		        	Paging p=new Paging();
			        p.setPageSize(rowcount);
			        p.setCurrentIndex(i);
			        p =excelService.jqQueryRsperson(so.getPname(), so.getIdCard(), so.getPersonType(),p,pcounty,unitlvl);
				    List<RsPerson> list=p.getVoList();  
				    HSSFWorkbook book= getExecl(list);
					File file=new File(fname);
					if (!file.exists()) { // 目录不存在就创建
						file.mkdirs();
					}
					OutputStream out=new FileOutputStream(new File(fname+String.valueOf(i) +".xls"));
					book.write(out);
					out.flush();
					out.close();
				    if(i*rowcount>count){
				    	break;
				    }
				}
		        zipFile(fname, fname+"file.zip");
		        InputStream in=new  FileInputStream(fname+"file.zip");
		        BufferedInputStream is=new BufferedInputStream(in);
	            int readLen=0;  
	            byte[] buf=new byte[1024];  
	            while ((readLen=is.read(buf, 0, 1024))!=-1) {  
	                os.write(buf, 0, readLen);  
	            }
	            is.close();
	            in.close();
			}
			os.close(); // 关闭流
			return this.NONE;
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return this.NONE;
		}
	}
	
	/**
	 * 导出统计表中的统计数据
	 * 
	 * 2012-9-25 王志
	 */
	public String tjQueryExecl() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			HttpServletResponse response=getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流   
			response.reset();// 清空输出流   
			String n = "人才统计报表.xls";
			String name = new String(n.getBytes("GB2312"), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment; filename=\""
					+ name + "\"");// 设定输出文件头
			response.setContentType("application/msexcel");// 定义输出类型
			int index = this.getClass().getClassLoader().getResource("/").getPath().indexOf("/WEB-INF");
			String url = this.getClass().getClassLoader().getResource("/").getPath().substring(0,index) + "\\file";
		   String folder= "P"+sdfDay.format(new Date(System.currentTimeMillis()));
		   String fname= url+"\\"+folder+"\\";
		   File	file=new File(fname+"人才统计报表.xls");
		   if (file.isFile()) {
			   InputStream in=new  FileInputStream(file);
			   int readLen=0;  
	            byte[] buf=new byte[1024];  
	            while ((readLen=in.read(buf, 0, 1024))!=-1) {  
	            	os.write(buf, 0, readLen);  
	            }
	            in.close();
		   }else {
					List<RsResult> list = excelService.tjQueryRsperson();
					Map<Long, RsResult> map=new HashMap<Long, RsResult>();
					for (RsResult rsResult : list) {
						map.put(rsResult.getId(), rsResult);
					}
					 InputStream in=new  FileInputStream(url+"\\"+"人才统计报表.xls");
			        BufferedInputStream is=new BufferedInputStream(in);
			    	 file=new File(fname);
					if (!file.exists()) { // 目录不存在就创建
						file.mkdirs();
					}
					file=new File(fname+"人才统计报表.xls");
					OutputStream out=new FileOutputStream(file);
		            int readLen=0;  
		            byte[] buf=new byte[1024];  
		            while ((readLen=is.read(buf, 0, 1024))!=-1) {  
		            	out.write(buf, 0, readLen);  
		            }
		            is.close();
		            in.close();
		            out.close();
		            FileInputStream input= new FileInputStream(file);
		            HSSFWorkbook workbook = new HSSFWorkbook(input);
		            //第三页  表一
		            HSSFSheet sheet = workbook.getSheetAt(2);
		            HSSFRow row = sheet.getRow(8);
		            RsResult result=map.get(new Long(1));
		            row.getCell(1).setCellValue(result.getA()==null||result.getA().length()<=0?null:new HSSFRichTextString(result.getA()));
		            row.getCell(2).setCellValue(result.getB()==null||result.getB().length()<=0?null:new HSSFRichTextString(result.getB()));
		            row.getCell(3).setCellValue(result.getC()==null||result.getC().length()<=0?null:new HSSFRichTextString(result.getC()));
		            row.getCell(4).setCellValue(result.getD()==null||result.getD().length()<=0?null:new HSSFRichTextString(result.getD()));
		            row.getCell(5).setCellValue(result.getE()==null||result.getE().length()<=0?null:new HSSFRichTextString(result.getE()));
		            row.getCell(6).setCellValue(result.getF()==null||result.getF().length()<=0?null:new HSSFRichTextString(result.getF()));
		            row.getCell(7).setCellValue(result.getG()==null||result.getG().length()<=0?null:new HSSFRichTextString(result.getG()));
		            row.getCell(8).setCellValue(result.getH()==null||result.getH().length()<=0?null:new HSSFRichTextString(result.getH()));
		            row.getCell(9).setCellValue(result.getI()==null||result.getI().length()<=0?null:new HSSFRichTextString(result.getI()));
		           row.getCell(10).setCellValue(result.getJ()==null||result.getJ().length()<=0?null:new HSSFRichTextString(result.getJ()));
		           row.getCell(11).setCellValue(result.getK()==null||result.getK().length()<=0?null:new HSSFRichTextString(result.getK()));
		           row.getCell(12).setCellValue(result.getL()==null||result.getL().length()<=0?null:new HSSFRichTextString(result.getL()));
		           row.getCell(13).setCellValue(result.getM()==null||result.getM().length()<=0?null:new HSSFRichTextString(result.getM()));
		           row.getCell(15).setCellValue(result.getN()==null||result.getN().length()<=0?null:new HSSFRichTextString(result.getN()));
		           row.getCell(16).setCellValue(result.getO()==null||result.getO().length()<=0?null:new HSSFRichTextString(result.getO()));
		           row.getCell(17).setCellValue(result.getP()==null||result.getP().length()<=0?null:new HSSFRichTextString(result.getP()));
		           row.getCell(18).setCellValue(result.getQ()==null||result.getQ().length()<=0?null:new HSSFRichTextString(result.getQ()));
		           row.getCell(19).setCellValue(result.getR()==null||result.getR().length()<=0?null:new HSSFRichTextString(result.getR()));
		           row.getCell(20).setCellValue(result.getS()==null||result.getS().length()<=0?null:new HSSFRichTextString(result.getS()));
		           row.getCell(21).setCellValue(result.getT()==null||result.getT().length()<=0?null:new HSSFRichTextString(result.getT()));
		           row.getCell(22).setCellValue(result.getU()==null||result.getU().length()<=0?null:new HSSFRichTextString(result.getU()));
		           row.getCell(23).setCellValue(result.getV()==null||result.getV().length()<=0?null:new HSSFRichTextString(result.getV()));
		           row.getCell(24).setCellValue(result.getW()==null||result.getW().length()<=0?null:new HSSFRichTextString(result.getW()));
		          //第四页  表二
		           sheet = workbook.getSheetAt(3);
		           row = sheet.getRow(8);
		           result=map.get(new Long(2));
		           row.getCell(1).setCellValue(result.getA()==null||result.getA().length()<=0?null:new HSSFRichTextString(result.getA()));
		           row.getCell(2).setCellValue(result.getB()==null||result.getB().length()<=0?null:new HSSFRichTextString(result.getB()));
		           row.getCell(3).setCellValue(result.getC()==null||result.getC().length()<=0?null:new HSSFRichTextString(result.getC()));
		           row.getCell(4).setCellValue(result.getD()==null||result.getD().length()<=0?null:new HSSFRichTextString(result.getD()));
		           row.getCell(5).setCellValue(result.getE()==null||result.getE().length()<=0?null:new HSSFRichTextString(result.getE()));
		           row.getCell(6).setCellValue(result.getF()==null||result.getF().length()<=0?null:new HSSFRichTextString(result.getF()));
		           row.getCell(7).setCellValue(result.getG()==null||result.getG().length()<=0?null:new HSSFRichTextString(result.getG()));
		           row.getCell(8).setCellValue(result.getH()==null||result.getH().length()<=0?null:new HSSFRichTextString(result.getH()));
		           row.getCell(9).setCellValue(result.getI()==null||result.getI().length()<=0?null:new HSSFRichTextString(result.getI()));
		           row.getCell(10).setCellValue(result.getJ()==null||result.getJ().length()<=0?null:new HSSFRichTextString(result.getJ()));
		           row.getCell(11).setCellValue(result.getK()==null||result.getK().length()<=0?null:new HSSFRichTextString(result.getK()));
		           row.getCell(12).setCellValue(result.getL()==null||result.getL().length()<=0?null:new HSSFRichTextString(result.getL()));
		           row.getCell(13).setCellValue(result.getM()==null||result.getM().length()<=0?null:new HSSFRichTextString(result.getM()));
		           row.getCell(14).setCellValue(result.getN()==null||result.getN().length()<=0?null:new HSSFRichTextString(result.getN()));
		           row.getCell(15).setCellValue(result.getO()==null||result.getO().length()<=0?null:new HSSFRichTextString(result.getO()));
		           row.getCell(16).setCellValue(result.getP()==null||result.getP().length()<=0?null:new HSSFRichTextString(result.getP()));
		           row.getCell(17).setCellValue(result.getQ()==null||result.getQ().length()<=0?null:new HSSFRichTextString(result.getQ()));
		           //第五页  表三
		           sheet = workbook.getSheetAt(4);
		           row = sheet.getRow(8);
		           result=map.get(new Long(3));
		           row.getCell(1).setCellValue(result.getA()==null||result.getA().length()<=0?null:new HSSFRichTextString(result.getA()));
		           row.getCell(2).setCellValue(result.getB()==null||result.getB().length()<=0?null:new HSSFRichTextString(result.getB()));
		           row.getCell(3).setCellValue(result.getC()==null||result.getC().length()<=0?null:new HSSFRichTextString(result.getC()));
		           row.getCell(4).setCellValue(result.getD()==null||result.getD().length()<=0?null:new HSSFRichTextString(result.getD()));
		           row.getCell(5).setCellValue(result.getE()==null||result.getE().length()<=0?null:new HSSFRichTextString(result.getE()));
		           row.getCell(6).setCellValue(result.getF()==null||result.getF().length()<=0?null:new HSSFRichTextString(result.getF()));
		           row.getCell(7).setCellValue(result.getG()==null||result.getG().length()<=0?null:new HSSFRichTextString(result.getG()));
		           row.getCell(8).setCellValue(result.getH()==null||result.getH().length()<=0?null:new HSSFRichTextString(result.getH()));
		           row.getCell(9).setCellValue(result.getI()==null||result.getI().length()<=0?null:new HSSFRichTextString(result.getI()));
		           row.getCell(10).setCellValue(result.getJ()==null||result.getJ().length()<=0?null:new HSSFRichTextString(result.getJ()));
		           row.getCell(11).setCellValue(result.getK()==null||result.getK().length()<=0?null:new HSSFRichTextString(result.getK()));
		           row.getCell(12).setCellValue(result.getL()==null||result.getL().length()<=0?null:new HSSFRichTextString(result.getL()));
		           row.getCell(13).setCellValue(result.getM()==null||result.getM().length()<=0?null:new HSSFRichTextString(result.getM()));
		           row.getCell(14).setCellValue(result.getN()==null||result.getN().length()<=0?null:new HSSFRichTextString(result.getN()));
		           //第六页  表四
		           sheet = workbook.getSheetAt(5);
		           row = sheet.getRow(8);
		           result=map.get(new Long(4));
		           row.getCell(1).setCellValue(result.getA()==null||result.getA().length()<=0?null:new HSSFRichTextString(result.getA()));
		           row.getCell(2).setCellValue(result.getB()==null||result.getB().length()<=0?null:new HSSFRichTextString(result.getB()));
		           row.getCell(3).setCellValue(result.getC()==null||result.getC().length()<=0?null:new HSSFRichTextString(result.getC()));
		           row.getCell(4).setCellValue(result.getD()==null||result.getD().length()<=0?null:new HSSFRichTextString(result.getD()));
		           row.getCell(5).setCellValue(result.getE()==null||result.getE().length()<=0?null:new HSSFRichTextString(result.getE()));
		           row.getCell(6).setCellValue(result.getF()==null||result.getF().length()<=0?null:new HSSFRichTextString(result.getF()));
		           row.getCell(7).setCellValue(result.getG()==null||result.getG().length()<=0?null:new HSSFRichTextString(result.getG()));
		           row.getCell(8).setCellValue(result.getH()==null||result.getH().length()<=0?null:new HSSFRichTextString(result.getH()));
		           row.getCell(9).setCellValue(result.getI()==null||result.getI().length()<=0?null:new HSSFRichTextString(result.getI()));
		           row.getCell(10).setCellValue(result.getJ()==null||result.getJ().length()<=0?null:new HSSFRichTextString(result.getJ()));
		           row.getCell(11).setCellValue(result.getK()==null||result.getK().length()<=0?null:new HSSFRichTextString(result.getK()));
		           row.getCell(12).setCellValue(result.getL()==null||result.getL().length()<=0?null:new HSSFRichTextString(result.getL()));
		           row.getCell(14).setCellValue(result.getM()==null||result.getM().length()<=0?null:new HSSFRichTextString(result.getM()));   
		           row.getCell(15).setCellValue(result.getN()==null||result.getN().length()<=0?null:new HSSFRichTextString(result.getN()));
		           row.getCell(16).setCellValue(result.getO()==null||result.getO().length()<=0?null:new HSSFRichTextString(result.getO()));
		           row.getCell(17).setCellValue(result.getP()==null||result.getP().length()<=0?null:new HSSFRichTextString(result.getP()));
		           //第7页  表五
		           sheet = workbook.getSheetAt(6);
		           row = sheet.getRow(8);
		           result=map.get(new Long(5));
		           row.getCell(1).setCellValue(result.getA()==null||result.getA().length()<=0?null:new HSSFRichTextString(result.getA()));
		           row.getCell(2).setCellValue(result.getB()==null||result.getB().length()<=0?null:new HSSFRichTextString(result.getB()));
		           row.getCell(3).setCellValue(result.getC()==null||result.getC().length()<=0?null:new HSSFRichTextString(result.getC()));
		           row.getCell(4).setCellValue(result.getD()==null||result.getD().length()<=0?null:new HSSFRichTextString(result.getD()));
		           row.getCell(5).setCellValue(result.getE()==null||result.getE().length()<=0?null:new HSSFRichTextString(result.getE()));
		           row.getCell(6).setCellValue(result.getF()==null||result.getF().length()<=0?null:new HSSFRichTextString(result.getF()));
		           row.getCell(7).setCellValue(result.getG()==null||result.getG().length()<=0?null:new HSSFRichTextString(result.getG()));
		           row.getCell(8).setCellValue(result.getH()==null||result.getH().length()<=0?null:new HSSFRichTextString(result.getH()));
		           row.getCell(9).setCellValue(result.getI()==null||result.getI().length()<=0?null:new HSSFRichTextString(result.getI()));
		           row.getCell(10).setCellValue(result.getJ()==null||result.getJ().length()<=0?null:new HSSFRichTextString(result.getJ()));
		           row.getCell(11).setCellValue(result.getK()==null||result.getK().length()<=0?null:new HSSFRichTextString(result.getK()));
		           row.getCell(12).setCellValue(result.getL()==null||result.getL().length()<=0?null:new HSSFRichTextString(result.getL()));
		           //第8页  表六
		           sheet = workbook.getSheetAt(7);
		           row = sheet.getRow(8);
		           result=map.get(new Long(6));
		           row.getCell(1).setCellValue(result.getA()==null||result.getA().length()<=0?null:new HSSFRichTextString(result.getA()));
		           row.getCell(2).setCellValue(result.getB()==null||result.getB().length()<=0?null:new HSSFRichTextString(result.getB()));
		           row.getCell(3).setCellValue(result.getC()==null||result.getC().length()<=0?null:new HSSFRichTextString(result.getC()));
		           row.getCell(4).setCellValue(result.getD()==null||result.getD().length()<=0?null:new HSSFRichTextString(result.getD()));
		           row.getCell(5).setCellValue(result.getE()==null||result.getE().length()<=0?null:new HSSFRichTextString(result.getE()));
		           row.getCell(6).setCellValue(result.getF()==null||result.getF().length()<=0?null:new HSSFRichTextString(result.getF()));
		           row.getCell(7).setCellValue(result.getG()==null||result.getG().length()<=0?null:new HSSFRichTextString(result.getG()));
		           row.getCell(8).setCellValue(result.getH()==null||result.getH().length()<=0?null:new HSSFRichTextString(result.getH()));
		           row.getCell(9).setCellValue(result.getI()==null||result.getI().length()<=0?null:new HSSFRichTextString(result.getI()));
		           row.getCell(10).setCellValue(result.getJ()==null||result.getJ().length()<=0?null:new HSSFRichTextString(result.getJ()));
		           row.getCell(11).setCellValue(result.getK()==null||result.getK().length()<=0?null:new HSSFRichTextString(result.getK()));
		           row.getCell(12).setCellValue(result.getL()==null||result.getL().length()<=0?null:new HSSFRichTextString(result.getL()));
		           row.getCell(13).setCellValue(result.getM()==null||result.getM().length()<=0?null:new HSSFRichTextString(result.getM()));
		           row.getCell(14).setCellValue(result.getN()==null||result.getN().length()<=0?null:new HSSFRichTextString(result.getN()));
		           row.getCell(15).setCellValue(result.getO()==null||result.getO().length()<=0?null:new HSSFRichTextString(result.getO()));
		           row.getCell(16).setCellValue(result.getP()==null||result.getP().length()<=0?null:new HSSFRichTextString(result.getP()));
		           row.getCell(17).setCellValue(result.getQ()==null||result.getQ().length()<=0?null:new HSSFRichTextString(result.getQ()));
		           row.getCell(18).setCellValue(result.getR()==null||result.getR().length()<=0?null:new HSSFRichTextString(result.getR()));
		           row.getCell(19).setCellValue(result.getS()==null||result.getS().length()<=0?null:new HSSFRichTextString(result.getS()));
		           row.getCell(20).setCellValue(result.getT()==null||result.getT().length()<=0?null:new HSSFRichTextString(result.getT()));
		           row.getCell(21).setCellValue(result.getU()==null||result.getU().length()<=0?null:new HSSFRichTextString(result.getU()));
		           row.getCell(22).setCellValue(result.getV()==null||result.getV().length()<=0?null:new HSSFRichTextString(result.getV()));
		           row.getCell(23).setCellValue(result.getW()==null||result.getW().length()<=0?null:new HSSFRichTextString(result.getW()));
		           out= new FileOutputStream(file);
		           workbook.write(out);
		           out.flush();
		           workbook.write(os);  
		           out.close();
			}   
			os.close(); // 关闭流
			return this.NONE;
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return this.NONE;
		}
	}
	
	
	
	/**
	 * 根据传来的HSSFCell 取值 
	 * 
	 * @param cell
	 * @return String
	 */
	public static String getCellString(HSSFCell cell) {
		if (cell != null) {
			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				return cell.getRichStringCellValue().getString();
			} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				String value="";
				try {
					 cell.getNumericCellValue();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					Date s=cell.getDateCellValue();
					value=sdf.format(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return value;
			} else {
				try {
					return cell.getRichStringCellValue().getString();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}

		} else {
			return null;
		}
	}
	
	public String goMhQuery() {
		this.setUserCountry();
		return "mhquery";
	}
	
	/**
	 * 返回人才类型
	 * @return
	 */
	public String getPersonType(char c) {
		String str="";
			if(c!=' '){
				if (c==',') {
					str="  ";
				}else{
					str=this.getConfTypeMap("11").get(String.valueOf(c));
				}
			}
		return str;
	}
	
	String forage = "";
	String toage = "";
	private void dealRetrieveSO(){
		try {
			forage = form.getQueryListSO().getForage();
			toage  = form.getQueryListSO().getToage();
			form.getQueryListSO().setForage(dealAgeTime(form.getQueryListSO().getForage()));
			form.getQueryListSO().setToage(dealAgeTime(form.getQueryListSO().getToage()));

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			form.getQueryListSO().setForage("");
			form.getQueryListSO().setToage("");
		}		
	}
	
	/**
	 * 获取配置时间的前一天  通过年龄算出出生 年份+ "-01-01"
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
	/**
	 * 模糊查询人员列表
	 */
	public String mhQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("mhquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
			// 调用ws
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getWorkCompany()!=null){
				form.getQueryListSO().setWorkCompany(form.getQueryListSO().getWorkCompany().trim());
			}
			if(form.getQueryListSO().getDutylevel()!=null){
				form.getQueryListSO().setDutylevel(form.getQueryListSO().getDutylevel().trim());
			}
			
			//graduatecollege specialtyName harvestName  assessDep technicallyType
			
			if(form.getQueryListSO().getGraduatecollege()!=null){
				form.getQueryListSO().setGraduatecollege(form.getQueryListSO().getGraduatecollege().trim());
			}
			
			if(form.getQueryListSO().getSpecialtyName()!=null){
				form.getQueryListSO().setSpecialtyName(form.getQueryListSO().getSpecialtyName().trim());
			}
			
			if(form.getQueryListSO().getHarvestName()!=null){
				form.getQueryListSO().setHarvestName(form.getQueryListSO().getHarvestName().trim());
			}
			
			if(form.getQueryListSO().getAssessDep()!=null){
				form.getQueryListSO().setAssessDep(form.getQueryListSO().getAssessDep().trim());
			}
			
			if(form.getQueryListSO().getTechnicallyType()!=null){
				form.getQueryListSO().setTechnicallyType(form.getQueryListSO().getTechnicallyType().trim());
			}
			
			dealRetrieveSO();

			//验证用户类型:市本级/县级
			this.validateUserType();
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			form.getQueryListSO().setForage(forage);
			form.getQueryListSO().setToage(toage);

			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			
			return "mhquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "mhquery";
		}
	}
	
	/**
	 * 导出模糊查询人员信息
	 * 
	 */
	public String mhQueryExecl() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("mhquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getWorkCompany()!=null){
				form.getQueryListSO().setWorkCompany(form.getQueryListSO().getWorkCompany().trim());
			}
			if(form.getQueryListSO().getDutylevel()!=null){
				form.getQueryListSO().setDutylevel(form.getQueryListSO().getDutylevel().trim());
			}
			
			//graduatecollege specialtyName harvestName  assessDep technicallyType
			
			if(form.getQueryListSO().getGraduatecollege()!=null){
				form.getQueryListSO().setGraduatecollege(form.getQueryListSO().getGraduatecollege().trim());
			}
			
			if(form.getQueryListSO().getSpecialtyName()!=null){
				form.getQueryListSO().setSpecialtyName(form.getQueryListSO().getSpecialtyName().trim());
			}
			
			if(form.getQueryListSO().getHarvestName()!=null){
				form.getQueryListSO().setHarvestName(form.getQueryListSO().getHarvestName().trim());
			}
			
			if(form.getQueryListSO().getAssessDep()!=null){
				form.getQueryListSO().setAssessDep(form.getQueryListSO().getAssessDep().trim());
			}
			
			if(form.getQueryListSO().getTechnicallyType()!=null){
				form.getQueryListSO().setTechnicallyType(form.getQueryListSO().getTechnicallyType().trim());
			}
			dealRetrieveSO();
			Long count = rsPersonService.queryCountByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			
			HttpServletResponse response=getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流   
			response.reset();// 清空输出流   
			if(count<=0){
				HSSFWorkbook workbook = new HSSFWorkbook(); //创建execl
				String n="韶关市人才基本信息.xls";
		        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
		        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
		        response.setContentType("application/msexcel");// 定义输出类型 
				workbook.write(os); // 写入文件   
			}else if (count<=rowcount) {
				String n="韶关市人才基本信息.xls";
		        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
		        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
		        response.setContentType("application/msexcel");// 定义输出类型 
		        Paging p=new Paging();
		        p.setPageSize(rowcount);
		        p.setStartRow(1);
		        List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(p, form.getQueryListSO(), menuId, this.getAccount().getId());
			    getExcel(dtoList).write(os);
			}else{
				String n="韶关市人才基本信息.zip";
		        String name=new String(n.getBytes("GB2312"), "ISO8859-1");
		        response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
		        response.setContentType("application/zip");// 定义输出类型 
		        
		        int index = this.getClass().getClassLoader().getResource("/").getPath().indexOf("/WEB-INF");
				String url = this.getClass().getClassLoader().getResource("/").getPath().substring(0,index) + "\\file"+"\\"+DateUtil.dateToDateString(new Date(), "yyyyMMdd");
		        String folder= "P"+sdf.format(new Date(System.currentTimeMillis()));
		        String fname= url+"\\"+folder+"\\";
		        for (int i = 1; i < 1000; i++) {
		        	Paging p=new Paging();
			        p.setPageSize(rowcount);
			        p.setCurrentIndex(i);
			        List<RsPersonListDTO> list = (List<RsPersonListDTO>) rsPersonService.queryByPage(p, form.getQueryListSO(), menuId, this.getAccount().getId());
				    HSSFWorkbook book= getExcel(list);
					File file=new File(fname);
					if (!file.exists()) { // 目录不存在就创建
						file.mkdirs();
					}
					OutputStream out=new FileOutputStream(new File(fname+String.valueOf(i) +".xls"));
					book.write(out);
					out.flush();
					out.close();
				    if(i*rowcount>count){
				    	break;
				    }
				}
		        zipFile(fname, fname+"file.zip");
		        InputStream in=new  FileInputStream(fname+"file.zip");
		        BufferedInputStream is=new BufferedInputStream(in);
	            int readLen=0;  
	            byte[] buf=new byte[1024];  
	            while ((readLen=is.read(buf, 0, 1024))!=-1) {  
	                os.write(buf, 0, readLen);  
	            }
	            is.close();
	            in.close();
			}
			os.close();
			return this.NONE;
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return this.NONE;
		}
	}
	public HSSFWorkbook getExcel(List<RsPersonListDTO> dtoList) {
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建execl
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
		HSSFCellStyle cellStyle1 = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		cellStyle.setWrapText(true);
		
		//性别字典
		Map<String, String> sexMap =this.getConfTypeMap("16");
		//民族字典
		Map<String, String> nationMap =this.getConfTypeMap("2");
		//党派
		Map<String, String> polityvisageMap =this.getConfTypeMap("3");
		//市
		Map<String, String> cityMap =this.getConfTypeMap("7");
		//省
		Map<String, String> provinceMap =this.getConfTypeMap("6");
		//学历
		Map<String, String> cultureMap =this.getConfTypeMap("4");
		//专业
		Map<String, String> specialtyMap =this.getConfTypeMap("5");
		//行业
		Map<String, String> tradeMap =this.getConfTypeMap("8");
		//岗位
		Map<String, String> postMap =this.getConfTypeMap("9");
		//单位性质
		Map<String, String> kindMap =this.getConfTypeMap("10");
		//所在县区
		Map<String, String> countyMap =this.getConfTypeMap("15");
		//审核状态
		Map<String, String> auditMap =this.getConfTypeMap("63");
		// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
		
		HSSFSheet sheet = workbook.createSheet();
		// 设置宽度
		sheet.setColumnWidth(0, 2500);
		sheet.setColumnWidth(1, 1500);
		sheet.setColumnWidth(2, 3500);
		sheet.setColumnWidth(3, 3500);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 5000);
		sheet.setColumnWidth(6, 2500);
		sheet.setColumnWidth(7, 2500);
		sheet.setColumnWidth(8, 4000);
		sheet.setColumnWidth(9, 3500);
		sheet.setColumnWidth(10, 2500);
		sheet.setColumnWidth(11, 3500);
		sheet.setColumnWidth(12, 3500);
		sheet.setColumnWidth(13, 3500);
		sheet.setColumnWidth(14, 12000);
		sheet.setColumnWidth(15, 5000);
		sheet.setColumnWidth(16, 9000);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("姓名"));
		cell = row.createCell(1);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("性别"));
		cell = row.createCell(2);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("民族"));
		cell = row.createCell(3);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("党派"));
		cell = row.createCell(4);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("公民身份号码"));
		cell = row.createCell(5);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("户口所在地"));
		cell = row.createCell(6);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("最高学历"));
		cell = row.createCell(7);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("专业类别"));
		cell = row.createCell(8);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("现所在行业"));
		cell = row.createCell(9);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("现从事岗位"));
		cell = row.createCell(10);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("单位性质"));
		cell = row.createCell(11);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("所在县区"));
		cell = row.createCell(12);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("现就业单位"));
		cell = row.createCell(13);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("担任职务"));
		cell = row.createCell(14);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("人才类型"));
		cell = row.createCell(15);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("删除状态"));
		cell = row.createCell(16);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(new HSSFRichTextString("审核状态"));
		for (int i = 0; i < dtoList.size(); i++) {
			RsPersonListDTO rs=dtoList.get(i);
			if(rs==null){
				continue;
			}
			row = sheet.createRow(i+1);
			cell = row.createCell(0);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(rs.getPname()));
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(sexMap.get(rs.getPsex())));
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(nationMap.get(rs.getPnation())));
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(polityvisageMap.get(rs.getPpolityvisage())));
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(rs.getIdCard()));
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle1);
			String  fk=provinceMap.get(rs.getRegisteraddrprov());
			fk=fk+"  "+cityMap.get(rs.getRegisteraddrcity());
			cell.setCellValue(new HSSFRichTextString(fk));
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(cultureMap.get(rs.getCultureType())));
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(specialtyMap.get(rs.getSpecialtytype())));
			cell = row.createCell(8);
			cell.setCellStyle(cellStyle1);
			//现所在行业
			String trade="";
			if(rs.getPtrade()=="13"){
				trade=rs.getPtradeother();
			}else{
				trade=tradeMap.get(rs.getPtrade());
			}
			cell.setCellValue(new HSSFRichTextString(trade));
			cell = row.createCell(9);
			cell.setCellStyle(cellStyle1);
			//现从事岗位
			String post="";
			if(rs.getPquarters()=="6"){
				post=rs.getPquartersother();
			}else{
				post=postMap.get(rs.getPquarters());
			}
			cell.setCellValue(new HSSFRichTextString(post));
			cell = row.createCell(10);
			cell.setCellStyle(cellStyle1);
			//单位性质
			String kind=""; 
			if (rs.getEconomyKind()=="7") {
				kind=rs.getEconomykindother();
			}else{
				kind=kindMap.get(rs.getEconomyKind());
			}
			cell.setCellValue(new HSSFRichTextString(kind));
			cell = row.createCell(11);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(countyMap.get(rs.getPcounty())));
			cell = row.createCell(12);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(rs.getWorkCompany()));
			cell = row.createCell(13);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(rs.getDutylevel()));
			cell = row.createCell(14);
			cell.setCellStyle(cellStyle1);
			String type=rs.getPersonType();
			if(type!=null&&type.length()>0){
				char[] c=type.toCharArray();
				type="";
				for (char d : c) {
					type=type+getPersonType(d);
				}
			}else{
				type="";
			}
			cell.setCellValue(new HSSFRichTextString(type.trim()));
			cell = row.createCell(15);
			cell.setCellStyle(cellStyle1);
			
			cell.setCellValue(new HSSFRichTextString(rs.getDelestate()=="1"?"已删除":"未删除"));
			cell = row.createCell(16);
			cell.setCellStyle(cellStyle1);
			cell.setCellValue(new HSSFRichTextString(auditMap.get(rs.getAuditstate())));	
		}
		return workbook;
	}
	public String goGwQuery() {
		return "gwquery";
	}
	
	/**
	 * 岗位查询人员列表
	 */
	public String gwQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("gwquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "gwquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "gwquery";
		}
	}
	
	public String dbQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("dbquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
			if(!StrUtils.strIsNull(form.getQueryListSO().getAuditstate())) {
				form.getQueryListSO().setAuditstate("%00");
			}
			form.getQueryListSO().setDelestate("0");
		    // 调用ws
			form.getQueryListSO().setDateStr("db");//对比时间
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getIdCard()!=null){
				form.getQueryListSO().setIdCard(form.getQueryListSO().getIdCard().trim());
			}
			this.validateUserType();
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			
			return "dbquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "dbquery";
		}
	}
	
	public String yzQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("yzquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(!StrUtils.strIsNull(form.getQueryListSO().getAuditstate())) {
				form.getQueryListSO().setAuditstate("1%0");
			}
			form.getQueryListSO().setDelestate("0");
			form.getQueryListSO().setDateStr("yz");//验证时间
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getIdCard()!=null){
				form.getQueryListSO().setIdCard(form.getQueryListSO().getIdCard().trim());
			}
			this.validateUserType();
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);	
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			
			return "yzquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "yzquery";
		}
	}

	public String shQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("shquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(!StrUtils.strIsNull(form.getQueryListSO().getAuditstate())) {
				form.getQueryListSO().setAuditstate("1%");
			}
			form.getQueryListSO().setDelestate("0");
			form.getQueryListSO().setDateStr("sh");//审核时间
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getIdCard()!=null){
				form.getQueryListSO().setIdCard(form.getQueryListSO().getIdCard().trim());
			}
			this.validateUserType();
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			
			return "shquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "shquery";
		}
	}



	/**
	 * 启用管理入口
	 * @return
	 */
	public String goQyQuery() {
		return "qyquery";
	}

	/**
	 * 启用管理 列表
	 */
	public String qyQuery() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("qyquery");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			
			if(form.getQueryListSO().getPname()!=null){
				form.getQueryListSO().setPname(form.getQueryListSO().getPname().trim());
			}
			if(form.getQueryListSO().getIdCard()!=null){
				form.getQueryListSO().setIdCard(form.getQueryListSO().getIdCard().trim());
			}
			if(form.getQueryListSO().getSourcetype()!=null){
				form.getQueryListSO().setSourcetype(form.getQueryListSO().getSourcetype().trim());
			}
			if(form.getQueryListSO().getAdduser()!=null){
				form.getQueryListSO().setAdduser(form.getQueryListSO().getAdduser().trim());
			}
			
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "qyquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "qyquery";
		}
	}
	/**
	 * 申请：删除启用申请，更新删除启用申请状态
	 * @return
	 */
	public String delSqState(){
		JSONObject json=new	JSONObject();
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
			
			// 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(null!=dto && StrUtils.strIsNull(dto.getPersonId())) {
						dto.setDeleapplystate("1");
						int result = rsPersonService.updateState(dto);
					}
				}
			}

			json.put("flag", 1);
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);

			json.put("flag", 2);
		}
		outputJson(json);
		return this.NONE;
	}
	/**
	 * 申请：审核启用申请，更新审核启用申请状态
	 * @return
	 */
	public String shSqState(){
		JSONObject json=new	JSONObject();
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
			
			// 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(null!=dto && StrUtils.strIsNull(dto.getPersonId())) {
						dto.setAuditapplystate("1");
						int result = rsPersonService.updateState(dto);
					}
				}
			}

			json.put("flag", 1);
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);

			json.put("flag", 2);
		}
		outputJson(json);
		return this.NONE;
	}
	/**
	 * 启用：删除 启用，更新删除启用 相关信息
	 * @return
	 */
	public String delQyRun(){
		JSONObject json=new	JSONObject();
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
			
			// 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(null!=dto && StrUtils.strIsNull(dto.getPersonId())) {
						dto.setDeleapplystate("0");
						dto.setDeledate("");
						dto.setDelestate("0");
						dto.setDeleuser("");
						int result = rsPersonService.updateState(dto);
					}
				}
			}
			
			json.put("flag", 1);
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			json.put("flag", 2);
		}
		outputJson(json);
		return this.NONE;
	}
	/**
	 * 启用：审核 启用，更新审核启用 相关信息
	 * @return
	 */
	public String shQyRun(){
		JSONObject json=new	JSONObject();
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
			
			// 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(null!=dto && StrUtils.strIsNull(dto.getPersonId())) {
						dto.setAuditapplystate("0");
						dto.setAuditdate("");
						dto.setAuditdetaildate("");
						dto.setAuditstate("000");
						dto.setAudituser("");
						int result = rsPersonService.updateState(dto);
					}
				}
			}
			
			json.put("flag", 1);
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			json.put("flag", 2);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 修改用户对比状态
	 * @return
	 */
	public String uDbState() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
			
			// 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(StrUtils.strIsNull(dto.getPersonId()) && StrUtils.strIsNull(dto.getAuditstate())) {
						dto.setCheckdate(DateUtil.getCurDate());
						dto.setCheckuser(this.getAccount().getLoginCode());
						int result = rsPersonService.updateRsPersonState(dto);
					}
				}
			}
			// 重新查询
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(!StrUtils.strIsNull(form.getQueryListSO().getAuditstate())) {
				form.getQueryListSO().setAuditstate("%00");
			}
			form.getQueryListSO().setDelestate("0");
			form.getQueryListSO().setDateStr("db");//对比时间
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "dbquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "dbquery";
		}
	}
	
	/**
	 * 修改用户验证状态
	 * @return
	 */
	public String uYzState() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
		    // 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(StrUtils.strIsNull(dto.getPersonId()) && StrUtils.strIsNull(dto.getAuditstate())) {
						dto.setValidatedate(DateUtil.getCurDate());
						dto.setValidateuser(this.getAccount().getLoginCode());
						int result = rsPersonService.updateRsPersonState(dto);
					}
				}
			}

			// 重新查询
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(!StrUtils.strIsNull(form.getQueryListSO().getAuditstate())) {
				form.getQueryListSO().setAuditstate("1%0");
			}
			form.getQueryListSO().setDelestate("0");
			form.getQueryListSO().setDateStr("yz");//验证时间
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "yzquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "yzquery";
		}
	}
	
	/**
	 * 修改用户审核状态
	 * @return
	 */
	public String uShState() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存修改日志
		    // 修改状态
			if(form.getDtoList().size() > 0) {
				for(int i = 0; i < form.getDtoList().size(); i++) {
					RsPersonListDTO dto = (RsPersonListDTO) form.getDtoList().get(i);
					if(StrUtils.strIsNull(dto.getPersonId()) && StrUtils.strIsNull(dto.getAuditstate())) {
						dto.setAuditdate(DateUtil.getCurDate());
						dto.setAuditdetaildate(DateUtil.getSystemDateTime());
						dto.setAudituser(this.getAccount().getLoginCode());
						int result = rsPersonService.updateRsPersonState(dto);
					}
				}
			}

			// 重新查询
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
		    // 调用ws
			if(!StrUtils.strIsNull(form.getQueryListSO().getAuditstate())) {
				form.getQueryListSO().setAuditstate("1%");
			}
			form.getQueryListSO().setDelestate("0");
			form.getQueryListSO().setDateStr("sh");//审核时间
			List<RsPersonListDTO> dtoList = (List<RsPersonListDTO>) rsPersonService.queryByPage(paging, form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList!=null&&dtoList.size()>0){
				form.setDtoList(dtoList);
			}else{
				form.setDtoList(new ArrayList<RsPersonListDTO>());
			}
			return "shquery";
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "shquery";
		}
	}
	
	/**
	 * 新增/编辑人员信息
	 */
	public String input() {
		String rsPersonId = form.getRetrieveSO().getPersonId();
		if(rsPersonId != null && !rsPersonId.equals("")){//编辑
			try {
				RsPersonDetailDTO dto= (RsPersonDetailDTO) rsPersonService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
				form.setDto(dto);
			} catch (Exception ex) {
				// 统一异常处理类
				this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			}
		}
		return "input";
	}
	
	/**
	 * 保存人员信息
	 */
	@SuppressWarnings("unchecked")
	public String saveOrUpdate() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存查询日志
			
			if(form.getDto().getPersonId()==null||"".equals(form.getDto().getPersonId())){
				//新增状态
				form.getDto().setAdduser(this.getAccount().getLoginCode());
				form.getDto().setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
			}else{
				//修改状态
				form.getDto().setModifyuser(this.getAccount().getLoginCode());
				form.getDto().setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
			}
			
			if(form.getDto().getPemail()!=null&&form.getDto().getPemail().equals("@")){
				form.getDto().setPemail("");
			}
			form.getDto().setPoperator(this.getAccount().getLoginCode());
			//数据来源
			//1.录入 2.导入 3.交换
			if(form.getDto().getPersonId()==null||"".equals(form.getDto().getPersonId())){
				form.getDto().setSourcetype("1");
			}
			String result = rsPersonService.saveOrUpdate(form.getDto());
			if(result != null && result.trim().length() == 32) {
				form.getRetrieveSO().setPersonId(result);
				RsPersonDetailDTO dto = (RsPersonDetailDTO) rsPersonService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
				form.getDto().setPersonId(result);
				this.getSession().put("personId", dto.getPersonId());
				this.getSession().put("personName", dto.getPname());
				this.getSession().put("personIdCard", dto.getIdCard());
				this.getSession().put("auditstate",dto.getAuditstate());
			}
			if(checkPic()) {
				savePic();
			} else {
				this.setUploadErr("1");
			}
			form.setFlag("1");
			return "save";
		}catch (Exception ex) {
			form.setFlag("2");
			this.handleException(form.getDto().getPersonId(),Constants.SOA_PERSON, ex);
			return "save";
		}
	}
	
	//验证用户类型:市本级/县级
	public void validateUserType(){
		Object usercountry=this.getSession().get(LoginAction.ACCOUNT_TYPE);
		if(usercountry!=null&&!"".equals(usercountry)){
			//排除市本级用户的赋值
			Account account = (Account) this.getSession().get(LoginInterceptor.USER_LOGIN);
			if(account.getUsertype().equals("3")){
				form.getQueryListSO().setPcounty(usercountry.toString());
				form.getQueryListSO().setUnitlvl("3");
			}			
		}
	}
	/**
	 * ajax保存人员信息
	 */
	@SuppressWarnings("unchecked")
	public String ajaxSaveOrUpdate() {
		JSONObject json=new	JSONObject();
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getDto().getPersonId());//保存查询日志
			
			if(form.getDto().getPersonId()==null||"".equals(form.getDto().getPersonId())){
				//新增状态
				form.getDto().setAdduser(this.getAccount().getLoginCode());
				form.getDto().setAdddate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
			}else{
				//修改状态
				form.getDto().setModifyuser(this.getAccount().getLoginCode());
				form.getDto().setModifydate(DateUtil.dateToDateString(new Date(), "yyyyMMdd"));
			}
			
			if(form.getDto().getPemail()!=null&&form.getDto().getPemail().equals("@")){
				form.getDto().setPemail("");
			}
			form.getDto().setPoperator(this.getAccount().getLoginCode());
			//数据来源
			//1.录入 2.导入 3.交换
			if(form.getDto().getPersonId()==null||"".equals(form.getDto().getPersonId())){
				form.getDto().setSourcetype("1");
			}
			String result = rsPersonService.saveOrUpdate(form.getDto());
			if(result != null && result.trim().length() == 32) {
				form.getRetrieveSO().setPersonId(result);
				RsPersonDetailDTO dto = (RsPersonDetailDTO) rsPersonService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
				form.getDto().setPersonId(result);
				this.getSession().put("personId", dto.getPersonId());
				json.put("personId", dto.getPersonId());
				this.getSession().put("personName", dto.getPname());
				this.getSession().put("personIdCard", dto.getIdCard());
				this.getSession().put("auditstate",dto.getAuditstate());
			}
			if(checkPic()) {
				savePic();
			} else {
				json.put("uploadErr", 1);
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			json.put("flag", 2);
			this.handleException(form.getDto().getPersonId(),Constants.SOA_PERSON, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	private boolean checkPic() {
		if(uploadFile != null && uploadFile.length > 0){
			File file = uploadFile[0];
			long lon = file.length();
			if((lon / 1024) > 1000) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 保存附件
	 * @return
	 * @throws IOException 
	 */
	private void savePic() throws Exception {
		if(uploadFile != null && uploadFile.length > 0){
			InputStream inputStream = new FileInputStream(uploadFile[0]);
			rsAffix.setAffixContext(rsAffixService.inputStreamToByte(inputStream));
			rsAffix.setAffixName(uploadFile[0].getName());
			rsAffix.setAffixStyle("1");
			rsAffix.setAffixType("1");
			rsAffix.setAuditState("000");
			rsAffix.setDeleState("0");
			rsAffix.setUploadDate(DateUtil.getCurDate());
			rsAffix.setUploadPerson(this.getAccount().getLoginCode());
			rsAffix.setPersonId(form.getDto().getPersonId());
			rsAffixService.saveOrUpdate(rsAffix);
		}
	}
	
	/**
	 * 查看人员详细信息
	 */
	public String view() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("view");
			this.saveSysLog(Constants.SOA_PERSON, queryInputParameter);//保存查询日志
			//调用ws
			RsPersonDetailDTO dto= (RsPersonDetailDTO) rsPersonService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
			form.setDto(dto);
			return "view";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_PERSON, ex);
			return "view";
		}
	}
	
	/**
	 * 删除人员信息
	 */
	public String delete() {
		JSONObject json = new	JSONObject();
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_PERSON, form.getRetrieveSO().getPersonId());//保存查询日志
			if(StrUtils.strIsNull(form.getRetrieveSO().getPersonId()) && StrUtils.strIsNull(this.getAccount().getLoginCode())) {
				form.getDto().setPersonId(form.getRetrieveSO().getPersonId());
				form.getDto().setDeledate(DateUtil.getCurDate());
				form.getDto().setDeleuser(this.getAccount().getLoginCode());
				form.getDto().setDelestate("1");
				rsPersonService.delete(form.getDto());
			}
			json.put("delPerson", "删除成功！");
			outputJson(json);
			return this.NONE;
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			json.put("delPerson", "删除失败！");
			this.handleException(form.getRetrieveSO().getPersonId(),Constants.SOA_PERSON, ex);
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 检查输入参数
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	private void validateInput(String type)throws Exception{
		if(type.equals("list"))
		{
			QueryRsPersonListSO queryListSO = form.getQueryListSO();// 获得参数对象
		}else if(type.equals("view")){
			RetrieveRsPersonSO retrieveSO=form.getRetrieveSO();// 获得参数对象
			String rsPersonId = retrieveSO.getPersonId(); 
			//保存输入参数
			queryInputParameter=rsPersonId;
			// 分析输入参数
			if(rsPersonId.equals("") ){
				throw new ValidateException(Constants.ERROR_NOINPUT);
			}
		}
	}
	
	public String ajaxGetRegCity(){
		StringBuilder regCityHtml=new StringBuilder("<select name='form.dto.registeraddrcity' class='inp'>");
		JSONObject json=new	JSONObject();
		String parentCode="1";//默认
		String registeraddrprov=form.getRegisteraddrprov();
		String registeraddrcity=form.getRegisteraddrcity();//户口所在地市，用来检测是否已经保存过基本信息
		Long parentId=new Long(1);//默认
		if(form.getParentCode()!=null&&!"".equals(form.getParentCode())){
			parentCode=form.getParentCode();
			Conf parentConf=confService.findConf(parentCode,new Long(6));
			if(parentConf!=null){
				parentId=Long.valueOf(parentConf.getId().toString());
			}
		}
		List<Conf> confList=confService.findChildConf(parentId);
		for (Conf cf : confList) {	
			if(null==registeraddrcity||"".equals(registeraddrcity)){
				//新增加
				//如果选择广东省,市就要默认为韶光市
				//142表示广东省,217表示韶光市
				if(parentId.toString().equals("142")){
					if("217".equals(cf.getCode())){
						regCityHtml.append("<option value='"+cf.getCode()+"' selected='selected'>"+cf.getName()+"</option>");
					}else{
						regCityHtml.append("<option value='"+cf.getCode()+"'>"+cf.getName()+"</option>");
					}
				}else{
						regCityHtml.append("<option value='"+cf.getCode()+"'>"+cf.getName()+"</option>");
				}
			}else{
				if(registeraddrprov.equals(form.getParentCode())){
					if(registeraddrcity.equals(cf.getCode())){
						regCityHtml.append("<option value='"+cf.getCode()+"' selected='selected'>"+cf.getName()+"</option>");
					}else{
						regCityHtml.append("<option value='"+cf.getCode()+"'>"+cf.getName()+"</option>");
					}
				}else{
					regCityHtml.append("<option value='"+cf.getCode()+"'>"+cf.getName()+"</option>");
				}
			}
		}
		regCityHtml.append("</select>");
		json.put("regCityHtml", regCityHtml.toString());
		outputJson(json);
		return this.NONE;
	}

	public String ajaxCheckIdCard(){
		JSONObject json=new	JSONObject();
		String idCard=form.getIdCard();
		if(idCard!=null&&!"".equals(idCard)){
			RsPerson rs=rsPersonSer.idCardExist(idCard);
			if(rs!=null){
				json.put("flag", false);
			}else{
				json.put("flag", true);
			}
		}
		outputJson(json);
		return this.NONE;
	}
	
	/**
	 * 
	 * @param baseDir 要打包的目录
	 * @param fileName 打包的成ZIP的文件
	 * @throws Exception
	 * 
	 */
	public static void zipFile(String baseDir,String fileName) throws Exception{  
        try {
			List fileList=getSubFiles(new File(baseDir));  
			ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(fileName));  
			ZipEntry ze=null;  
			byte[] buf=new byte[BUFFER];  
			int readLen=0;  
			for(int i = 0; i <fileList.size(); i++) {  
			    File f=(File)fileList.get(i);  
			    ze=new ZipEntry(getAbsFileName(baseDir, f));  
			    ze.setSize(f.length());  
			    ze.setTime(f.lastModified());     
			    zos.putNextEntry(ze);  
			    InputStream is=new BufferedInputStream(new FileInputStream(f));  
			    while ((readLen=is.read(buf, 0, BUFFER))!=-1) {  
			        zos.write(buf, 0, readLen);  
			    }  
			    is.close();  
			}  
			zos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}  
    }
	
	/** 
	    * 给定根目录，返回另一个文件名的相对路径，用于zip文件中的路径. 
	    * @param baseDir java.lang.String 根目录 
	    * @param realFileName java.io.File 实际的文件名 
	    * @return 相对文件名 
	    */  
	    private static String getAbsFileName(String baseDir, File realFileName){  
	        File real=realFileName;  
	        File base=new File(baseDir);  
	        String ret=real.getName();  
	        while (true) {  
	            real=real.getParentFile();  
	            if(real==null)   
	                break;  
	            if(real.equals(base))   
	                break;  
	            else  
	                ret=real.getName()+"/"+ret;  
	        }  
	        return ret;  
	    }  
	      
	    /** 
	    * 取得指定目录下的所有文件列表，包括子目录. 
	    * @param baseDir File 指定的目录 
	    * @return 包含java.io.File的List 
	    */  
	    private static List getSubFiles(File baseDir){  
	        List ret=new ArrayList();  
	        File[] tmp=baseDir.listFiles();  
	        for (int i = 0; i <tmp.length; i++) {  
	            if(tmp[i].isFile())  
	                ret.add(tmp[i]);  
	            if(tmp[i].isDirectory())  
	                ret.addAll(getSubFiles(tmp[i]));  
	        }  
	        return ret;  
	    }  
	    
	    
	    /**
		 * 生成execl文件
		 * @param list
		 * @return
		 */
		public HSSFWorkbook getExecl(List<RsPerson> list) {
			HSSFWorkbook workbook = new HSSFWorkbook(); // 创建execl
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
			HSSFCellStyle cellStyle1 = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
			cellStyle.setWrapText(true);
			
			//性别字典
			Map<String, String> sexMap =this.getConfTypeMap("16");
			//民族字典
			Map<String, String> nationMap =this.getConfTypeMap("2");
			//党派
			Map<String, String> polityvisageMap =this.getConfTypeMap("3");
			//市
			Map<String, String> cityMap =this.getConfTypeMap("7");
			//省
			Map<String, String> provinceMap =this.getConfTypeMap("6");
			//学历
			Map<String, String> cultureMap =this.getConfTypeMap("4");
			//专业
			Map<String, String> specialtyMap =this.getConfTypeMap("5");
			//行业
			Map<String, String> tradeMap =this.getConfTypeMap("8");
			//岗位
			Map<String, String> postMap =this.getConfTypeMap("9");
			//单位性质
			Map<String, String> kindMap =this.getConfTypeMap("10");
			//所在县区
			Map<String, String> countyMap =this.getConfTypeMap("15");
			//审核状态
			Map<String, String> auditMap =this.getConfTypeMap("63");
			// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
			
			HSSFSheet sheet = workbook.createSheet();
			// 设置宽度
			sheet.setColumnWidth(0, 2500);
			sheet.setColumnWidth(1, 1500);
			sheet.setColumnWidth(2, 3500);
			sheet.setColumnWidth(3, 3500);
			sheet.setColumnWidth(4, 5000);
			sheet.setColumnWidth(5, 5000);
			sheet.setColumnWidth(6, 2500);
			sheet.setColumnWidth(7, 2500);
			sheet.setColumnWidth(8, 4000);
			sheet.setColumnWidth(9, 3500);
			sheet.setColumnWidth(10, 2500);
			sheet.setColumnWidth(11, 3500);
			sheet.setColumnWidth(12, 3500);
			sheet.setColumnWidth(13, 3500);
			sheet.setColumnWidth(14, 12000);
			sheet.setColumnWidth(15, 5000);
			sheet.setColumnWidth(16, 9000);
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("姓名"));
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("性别"));
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("民族"));
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("党派"));
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("公民身份号码"));
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("户口所在地"));
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("最高学历"));
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("专业类别"));
			cell = row.createCell(8);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("现所在行业"));
			cell = row.createCell(9);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("现从事岗位"));
			cell = row.createCell(10);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("单位性质"));
			cell = row.createCell(11);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("所在县区"));
			cell = row.createCell(12);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("现就业单位"));
			cell = row.createCell(13);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("担任职务"));
			cell = row.createCell(14);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("人才类型"));
			cell = row.createCell(15);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("删除状态"));
			cell = row.createCell(16);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(new HSSFRichTextString("审核状态"));
			for (int i = 0; i < list.size(); i++) {
				RsPerson rs=list.get(i);
				if(rs==null){
					continue;
				}
				row = sheet.createRow(i+1);
				cell = row.createCell(0);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(rs.getPname()));
				cell = row.createCell(1);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(sexMap.get(rs.getPsex())));
				cell = row.createCell(2);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(nationMap.get(rs.getPnation())));
				cell = row.createCell(3);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(polityvisageMap.get(rs.getPpolityvisage())));
				cell = row.createCell(4);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(rs.getIdcard()));
				cell = row.createCell(5);
				cell.setCellStyle(cellStyle1);
				String  fk=provinceMap.get(rs.getRegisteraddrprov());
				fk=fk+"  "+cityMap.get(rs.getRegisteraddrcity());
				cell.setCellValue(new HSSFRichTextString(fk));
				cell = row.createCell(6);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(cultureMap.get(rs.getCulturetype())));
				cell = row.createCell(7);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(specialtyMap.get(rs.getSpecialtytype())));
				cell = row.createCell(8);
				cell.setCellStyle(cellStyle1);
				//现所在行业
				String trade="";
				if(rs.getPtrade()=="13"){
					trade=rs.getPtradeother();
				}else{
					trade=tradeMap.get(rs.getPtrade());
				}
				cell.setCellValue(new HSSFRichTextString(trade));
				cell = row.createCell(9);
				cell.setCellStyle(cellStyle1);
				//现从事岗位
				String post="";
				if(rs.getPquarters()=="6"){
					post=rs.getPquartersother();
				}else{
					post=postMap.get(rs.getPquarters());
				}
				cell.setCellValue(new HSSFRichTextString(post));
				cell = row.createCell(10);
				cell.setCellStyle(cellStyle1);
				//单位性质
				String kind=""; 
				if (rs.getEconomykind()=="7") {
					kind=rs.getEconomykindother();
				}else{
					kind=kindMap.get(rs.getEconomykind());
				}
				cell.setCellValue(new HSSFRichTextString(kind));
				cell = row.createCell(11);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(countyMap.get(rs.getPcounty())));
				cell = row.createCell(12);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(rs.getWorkcompany()));
				cell = row.createCell(13);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(rs.getDutylevel()));
				cell = row.createCell(14);
				cell.setCellStyle(cellStyle1);
				String type=rs.getPersontype();
				if(type!=null&&type.length()>0){
					char[] c=type.toCharArray();
					type="";
					for (char d : c) {
						type=type+getPersonType(d);
					}
				}else{
					type="";
				}
				cell.setCellValue(new HSSFRichTextString(type.trim()));
				cell = row.createCell(15);
				cell.setCellStyle(cellStyle1);
				
				cell.setCellValue(new HSSFRichTextString(rs.getDelestate()=="1"?"已删除":"未删除"));
				cell = row.createCell(16);
				cell.setCellStyle(cellStyle1);
				cell.setCellValue(new HSSFRichTextString(auditMap.get(rs.getAuditstate())));	
			}
			return workbook;
		}
	
	private String uploadErr;
	
	public RsPersonForm getForm() {
		return form;
	}

	public void setForm(RsPersonForm form) {
		this.form = form;
	}

	public File[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File[] uploadFile) {
		this.uploadFile = uploadFile;
	}
	public RsAffixDTO getRsAffix() {
		return rsAffix;
	}
	public void setRsAffix(RsAffixDTO rsAffix) {
		this.rsAffix = rsAffix;
	}
	public String getUploadErr() {
		return uploadErr;
	}
	public void setUploadErr(String uploadErr) {
		this.uploadErr = uploadErr;
	}
	
}
