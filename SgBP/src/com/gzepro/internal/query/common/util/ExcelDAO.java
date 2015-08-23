package com.gzepro.internal.query.common.util;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.gzepro.internal.query.model.RsBatchlog;
import com.gzepro.internal.query.model.RsEducationexperience;
import com.gzepro.internal.query.model.RsPerson;
import com.gzepro.internal.query.model.RsProjectexperience;
import com.gzepro.internal.query.model.RsTechnicallymess;
import com.gzepro.internal.query.model.RsTechnologicalharvest;
import com.gzepro.internal.query.model.RsWorkexperience;

/**
 * 
 * 
 * 描述信息！
 * 
 * @author 王志 E-mail:wangzhi291@163.com
 * @version 1.0 Created On: 2012-7-24
 */
public class ExcelDAO {
	private Map<String, String> personMap = new HashMap<String, String>();
	private RsBatchlog person = new RsBatchlog();// 人员错误信息
	private RsBatchlog technicallymess = new RsBatchlog();// 职称错误信息
	private RsBatchlog educationexperience = new RsBatchlog();// 教育错误信息
	private RsBatchlog workexperience = new RsBatchlog();// 工作错误信息
	private RsBatchlog projectexperience = new RsBatchlog();// 项目错误信息
	private RsBatchlog technologicalharvest = new RsBatchlog(); // 成果错误信息
	private HSSFWorkbook workbook;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static Map<String,Map<String,String>> map=null;
	
	@SuppressWarnings({ "unchecked", "static-access" })
	private ExcelDAO(HSSFWorkbook workbook) {
		this.workbook = workbook;
		if (this.map == null) {
			ServletContext servletContext = ServletActionContext
					.getServletContext();
			this.map = (Map<String, Map<String, String>>) servletContext
					.getAttribute("_WEB_SYS_CONF_KEY_");
		}
	}

	private ExcelDAO(){
		
	}
	public static ExcelDAO getExcelDAO(FileInputStream file) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		return new ExcelDAO(workbook);
	}

	/**
	 * 返回批量导入人员基本信息集合
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, RsPerson> getRsPerson() throws Exception {
		Map<String, RsPerson> map = new HashMap<String, RsPerson>();
		HSSFSheet sheet = this.workbook.getSheetAt(0);
		HSSFRow row1 = sheet.getRow(1);
		String Poperator = null;
		Date operationalDate = null;
		try {
			Poperator = row1.getCell(5).getRichStringCellValue().getString();
			//operationalDate = row1.getCell(8).getDateCellValue();
			String date=getCellString(row1.getCell(8));
			operationalDate=sdf.parse(date);// 填表时间
			if (Poperator == null || Poperator.trim().length() <= 0
					|| operationalDate == null) {
				throw new Exception("录入人员姓名或者录入时间为空或者格式不对！");
			}
		} catch (Exception e) {
			throw new Exception("录入人员姓名或者录入时间为空或者格式不对！");
		}
		if (sheet.getLastRowNum() - 3 >= 305) {
			throw new Exception("录入数据过多，请分两次导入，每次导入不能大于300条！");

		}
		int i = 0;
		for (int rowIndex = 3; rowIndex <= sheet.getLastRowNum() + 3; rowIndex++) {
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			RsPerson rs = new RsPerson();
			rs.setPoperator(Poperator);
			rs.setOperationaldate(operationalDate);
			rs.setIdcard(getCellString(row.getCell(0)).trim());// 0为身份证
			if (rs.getIdcard() != null && rs.getIdcard().trim().length() > 0) {
				this.person.setTotals();// 总数加1
				if (ValidateUtil.isPersonId(rs.getIdcard()) == null) {
					try {
						if (map.get(rs.getIdcard()) != null) {
							throw new Exception("身份证号码重复，只取第一条数据！");
						} 
						try {
							rs.setPname(row.getCell(1).getRichStringCellValue()
									.getString());// 1姓名
						} catch (Exception e7) {
							throw new Exception("姓名为空或者姓名格式不对！");
						}
						if (rs.getPname().length() <= 0
								|| rs.getPname().length() > 10) {
							throw new Exception("姓名长度不对！");
						}
						try {
							String pnation = row.getCell(2)
									.getRichStringCellValue().getString();
							rs.setPnation(pnation.substring(0, pnation
									.indexOf(".")));// 2民族
						} catch (Exception e6) {
						}				
						if(!this.checkNumber("2", rs.getPnation())&&!rs.getPnation().equals("60")){
							throw new Exception("所选民族不在可选范围内！");
						}
						try {
							String polityvisage = row.getCell(3)
									.getRichStringCellValue().getString();
							rs.setPpolityvisage(polityvisage.substring(0,
									polityvisage.indexOf(".")));// 3党派
						} catch (Exception e6) {
						}
						if(!this.checkNumber("3", rs.getPpolityvisage())){
							throw new Exception("所选党派不在可选范围内！");
						}
						try {
							String prov = getCellString(row.getCell(4));
							rs.setRegisteraddrprov(prov.substring(0, prov
									.indexOf(".")));// 4为现户口所在地省
						} catch (Exception e5) {
						}
						if(!this.checkNumber("6", rs.getRegisteraddrprov())){
							throw new Exception("所选户口所在地省不在可选范围内！");
						}
						try {
							String rcity = getCellString(row.getCell(5));
							rs.setRegisteraddrcity(rcity.substring(0, rcity
									.indexOf(".")));// 5为现户口所在地市
						} catch (Exception e5) {
						}
						if(!this.checkNumber("7", rs.getRegisteraddrcity())){
							throw new Exception("所选户口所在地市不在可选范围内！");
						}
						rs.setGraduatecollege(getCellString(row.getCell(6)));// 6为毕业院校
						if (rs.getGraduatecollege() != null
								&& rs.getGraduatecollege().length() > 50) {
							throw new Exception("毕业院校的长度不能超过50个字!");
						}
						try {
							String culturetype = row.getCell(7)
									.getRichStringCellValue().getString();
							rs.setCulturetype(culturetype.substring(0,
									culturetype.indexOf(".")));// 7为最高学历
							if (rs.getCulturetype().equals("6")) {
								rs.setCulturetypeother(getCellString(row
										.getCell(8)));// 8为其他学历
							}
						} catch (Exception e4) {
						}
						if(!this.checkNumber("4", rs.getCulturetype())){
							throw new Exception("所选最高学历不在可选范围内！");
						}
						rs.setSpecialtyname(getCellString(row.getCell(9)));// 9为专业名称
						if (rs.getSpecialtyname() != null
								&& rs.getSpecialtyname().length() > 40) {
							throw new Exception("专业名称的长度不能超过40个字!");
						}
						try {
							String specialtyType = row.getCell(10)
									.getRichStringCellValue().getString();
							rs.setSpecialtytype(specialtyType.substring(0,
									specialtyType.indexOf(".")));// 10专业类别
						} catch (Exception e4) {
						}
						if(!this.checkNumber("5", rs.getSpecialtytype())){
							throw new Exception("所选专业类别不在可选范围内！");
						}
						rs.setMessageaddr(getCellString(row.getCell(11)));// 11为通讯地址
						if (rs.getMessageaddr() != null
								&& rs.getMessageaddr().length() > 100) {
							throw new Exception("通讯地址的长度不能超过100个字!");
						}
						String phone = getCellString(row.getCell(12));
						if (phone != null && phone.length() > 0) {
							if (phone.length() > 40) {
								throw new Exception("电话号码的长度不能超过40个字!");
							}
							rs.setPphone(phone);// 12为电话
						} else {
							throw new Exception("电话号码不能为空！");
						}
						rs.setPemail(getCellString(row.getCell(13)));// 13为邮箱
						if (rs.getPemail() != null
								&& rs.getPemail().length() > 40) {
							throw new Exception("邮箱地址的长度不能超过100个字!");
						}
						rs.setPpost(getCellString(row.getCell(14)));// 14为邮编
						if (rs.getPpost() != null && rs.getPpost().length() > 6) {
							throw new Exception("邮编的长度不能超过6个字!");
						}
						try {
							String Ptrade = row.getCell(15)
									.getRichStringCellValue().getString();
							rs.setPtrade(Ptrade.substring(0, Ptrade
									.indexOf(".")));// 15为现所在行业
						} catch (Exception e3) {
						}
						if (rs.getPtrade() == null
								|| rs.getPtrade().trim().equals("")) {
							throw new Exception("现所在行业不能为空！");
						}
						if(!this.checkNumber("8", rs.getPtrade())){
							throw new Exception("所选现所在行业不在可选范围内！");
						}
						if (rs.getPtrade().equals("13")) {
							String ptrade = getCellString(row.getCell(16));
							if (ptrade != null && ptrade.length() > 40) {
								throw new Exception("其他行业长度不能超过40个字！");
							}
							rs.setPtradeother(ptrade); // 16为现所在其他行业
						}
						// 为所在其他行业
						try {
							String pcounty = row.getCell(17)
									.getRichStringCellValue().getString();
							rs.setPcounty(pcounty.substring(0, pcounty
									.indexOf(".")));// 17为所在县区
						} catch (Exception e2) {
						}
						if (rs.getPcounty() == null
								|| rs.getPcounty().trim().equals("")) {
							throw new Exception("现所在县区不能为空！");
						}
						if(!this.checkNumber("15", rs.getPcounty())){
							throw new Exception("所选所在县区不在可选范围内！");
						}
						try {
							String pquarters = row.getCell(18)
									.getRichStringCellValue().getString();
							rs.setPquarters(pquarters.substring(0, pquarters
									.indexOf(".")));// 18为现从事岗位
						} catch (Exception e1) {
						}
						if (rs.getPquarters() != null
								&& rs.getPquarters().equals("6")) {
							String pquartersother = getCellString(row
									.getCell(19));
							if (pquartersother != null
									&& pquartersother.length() > 40) {
								throw new Exception("其他岗位不能超过40个字！");
							}
							rs.setPquartersother(pquartersother);// 19为现从事其他岗位
						}
						if(!this.checkNumber("9", rs.getPquarters())){
							throw new Exception("所选现从事岗位不在可选范围内！");
						}
						rs.setWorkcompany(getCellString(row.getCell(20)));// 20为现就业单位名称
						if (rs.getWorkcompany() != null
								&& rs.getWorkcompany().length() > 100) {
							throw new Exception("现就业单位名称长度不能超过100个字！");
						}
						rs.setDutylevel(getCellString(row.getCell(21)));// 21为担任行政职务或级别
						if (rs.getDutylevel() != null
								&& rs.getDutylevel().length() > 20) {
							throw new Exception("担任行政职务或级别长度不能超过20个字！");
						}
						try {
							String economyKind = row.getCell(22)
									.getRichStringCellValue().getString();
							rs.setEconomykind(economyKind.substring(0,
									economyKind.indexOf(".")));// 22为单位性质
						} catch (Exception e) {
						}
						if(!this.checkNumber("10", rs.getEconomykind())){
							throw new Exception("所选单位性质不在可选范围内！");
						}
						if (rs.getEconomykind() != null
								&& rs.getEconomykind().equals("9")) {
							String economykindother = getCellString(row
									.getCell(23));
							if (economykindother != null
									&& economykindother.length() > 20) {
								throw new Exception("其他单位性质长度不能超过20个字！");
							}
							rs.setEconomykindother(economykindother);// 23为其他单位性质
						}
				
						try {
							String personType = row.getCell(24)
									.getRichStringCellValue().getString();// 24为人才类型
							String personTypes = "";
							if (personType != null
									&& personType.trim().length() > 0) {
								String[] ary = personType.split(",\\s*");
								for (String string : ary) {
									personTypes += string.substring(0, string
											.indexOf("."))
											+ ",";
								}
								personTypes = personTypes.substring(0,
										personTypes.length() - 1);
							}
						
							rs.setPersontype(personTypes);
						} catch (Exception e) {
						}
						if (rs.getPersontype() == null
								|| rs.getPersontype().trim().equals("")) {
							throw new Exception("人才类型不能为空!");
						}
						String[] ary = rs.getPersontype().split(",\\s*");//判断人才类型是否在空值范围内
						for (String string : ary) {
							if(!this.checkNumber("11", string)){
								throw new Exception("人才类型不在选择范围内！");
							}
						}
						
						rs.setSpecialtystrong(getCellString(row.getCell(25)));// 其他特长
						if (rs.getSpecialtystrong() != null&& rs.getSpecialtystrong().length()>100) {
							throw new Exception("其他特长不能超过100个字!");
						}
						String[] birthDayAndSex = ValidateUtil
								.getBirthDayAndSex(rs.getIdcard());// 获取人员的出生上期和性别
						Date birthDate = DateUtil
								.getYYYYMMddDateFromInt(Integer
										.valueOf(birthDayAndSex[0]));
						String psex = (birthDayAndSex[1]).equals("1") ? "1"
								: "2";// 1为男2为女
						rs.setPsex(psex);
						rs.setPbirthday(birthDate);
						rs.setDelestate("0");
						rs.setAuditstate("000");
						rs.setAuditapplystate("0");
						rs.setDeleapplystate("0");
						map.put(rs.getIdcard(), rs);
						i = 0;
					} catch (Exception e) {
						this.person.setFailcounts();// 失败数加1
						this.person.getErrorlogs().append("<p>"+
								this.person.getFailcount().toString() + "、"
										+ "身份证号码：" + rs.getIdcard()
										+ "," +e.getMessage() + "</p>");
						this.personMap.put( rs.getIdcard(), e.getMessage() );
						setFirstErroeMessage(e.getMessage());
					}
				} else {
					this.person.setFailcounts();
					this.person.getErrorlogs().append("<p>"+
							this.person.getFailcount().toString() + "、"
									+ "身份证号码：" + rs.getIdcard()+"," 
									+ ValidateUtil.isPersonId(rs.getIdcard())
									+ "</p>");
					this.personMap.put( rs.getIdcard(), ValidateUtil.isPersonId(rs.getIdcard()));
				}
			} else {
				i++;
				if (i >= 3) {
					return map;
				}
			}
		}
		return map;
	}
	private String firstErroeMessage = "";

	/**
	 * 返回批量导入人员的职称、技能信息
	 * 
	 * @return
	 */
	public Map<String, List<RsTechnicallymess>> getRsTechnicallymess() {
		Map<String, List<RsTechnicallymess>> map = new HashMap<String, List<RsTechnicallymess>>();
		HSSFSheet sheet = this.workbook.getSheetAt(1);// 取职称页面
		int i = 0;
		for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum() + 2; rowIndex++) {
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			HSSFCell cell = row.getCell(0);
			String idCard = getCellString(cell);// 身份证号码
			if (idCard != null && idCard.trim().length() > 0) {
				RsTechnicallymess rs = new RsTechnicallymess();
				this.getTechnicallymess().setTotals();
				try {
					try {
						String date=getCellString(row.getCell(2));
						rs.setAssessdate(sdf.parse(date));// 取得时间
					} catch (Exception e) {
						throw new Exception("职称时间为空或者格式不对！");
					}
					try {
						rs.setTechnicallytype(row.getCell(3)
								.getRichStringCellValue().getString());
						if(rs.getTechnicallytype()==null||rs.getTechnicallytype().length()<=0||rs.getTechnicallytype().length()>40){
							throw new Exception("");
						}
					} catch (Exception e) {
						throw new Exception("职称名称为空或者长度不对！");
					}
					try {
						String technicallylevel = row.getCell(4)
								.getRichStringCellValue().getString();
						rs.setTechnicallylevel(technicallylevel.substring(0,
								technicallylevel.lastIndexOf(".")));
					} catch (Exception e) {
						throw new Exception("职称级别为空或者格式不对！");
					}
					if(!this.checkNumber("12", rs.getTechnicallylevel())){
						throw new Exception("所选职称级别不在可选范围内！");
					}
					i = 0;
					List<RsTechnicallymess> l = map.get(idCard);
					if (l != null && l.size() > 0) {
						l.add(rs);
						map.put(idCard, l);
					} else {
						List<RsTechnicallymess> lists = new ArrayList<RsTechnicallymess>();
						lists.add(rs);
						map.put(idCard, lists);
					}
				} catch (Exception e) {
					this.technicallymess.setFailcounts();// 失败数加1
					this.technicallymess.getErrorlogs().append("<p>"+
							this.technicallymess.getFailcount().toString()
									+ "身份证号码：" + idCard +"," +e.getMessage()
									+ "</p>");

				}
			} else {
				i++;
				if (i > 3) {
					return map;
				}
			}
		}
		return map;
	}

	/**
	 * 返回批量导入人员的教育简历
	 * 
	 * @return
	 */
	public Map<String, List<RsEducationexperience>> getRsEducationexperience() {
		Map<String, List<RsEducationexperience>> map = new HashMap<String, List<RsEducationexperience>>();
		HSSFSheet sheet = this.workbook.getSheetAt(2);// 取教育简历页面
		int i = 0;
		for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			RsEducationexperience rs = new RsEducationexperience();
			HSSFCell cell = row.getCell(0);
			String idCard = getCellString(cell);// 身份证号码
			if (idCard != null && idCard.trim().length() > 0) {
				this.educationexperience.setTotals();// 总数加1
				try {
					try {
						String date=getCellString(row.getCell(2));
						rs.setFromdate(sdf.parse(date));// 从何年何月
					} catch (Exception e) {
						throw new Exception("从何年何月为空或者格式不对！");
					}
					try {
						String date=getCellString(row.getCell(3));
						rs.setTodate(sdf.parse(date));// 至何年何月
					} catch (Exception e) {
						throw new Exception("至何年何月为空或者格式不对！");
					}
					try {
						rs.setPcollege(row.getCell(4).getRichStringCellValue()
								.getString());// 毕业院校
						if(rs.getPcollege() == null || rs.getPcollege().equals("") || rs.getPcollege().length() > 40){
							throw new Exception();
						}
					} catch (Exception e) {
						throw new Exception("毕业院校为空或者格式、长度不对！");
					}
					try {
						rs.setSpecialtyname(row.getCell(5)
								.getRichStringCellValue().getString());// 所学专业
						if( rs.getSpecialtyname() == null || rs.getSpecialtyname().equals("") || rs.getSpecialtyname().length()>40){
							throw new Exception();
						}
					} catch (Exception e) {
						throw new Exception("所学专业为空或者格式、长度不对！");
					}
					i = 0;
					List<RsEducationexperience> l = map.get(idCard);
					if (l != null && l.size() > 0) {
						l.add(rs);
						map.put(idCard, l);
					} else {
						List<RsEducationexperience> lists = new ArrayList<RsEducationexperience>();
						lists.add(rs);
						map.put(idCard, lists);
					}
				} catch (Exception e) {
					this.educationexperience.setFailcounts();// 失败数加1
					this.educationexperience.getErrorlogs().append("<p>"+
							this.educationexperience.getFailcount().toString()
									+ "身份证号码：" + idCard +"," +e.getMessage()
									+ "</p>");
				}
			} else {// 连续空3行 表示已经读取完了
				i++;
				if (i > 3) {
					return map;
				}
			}
		}
		return map;
	}

	/**
	 * 返回批量导入人员的工作简历
	 * @return
	 */
	public Map<String, List<RsWorkexperience>> getRsWorkexperience() {
		Map<String, List<RsWorkexperience>> map = new HashMap<String, List<RsWorkexperience>>();
		HSSFSheet sheet = this.workbook.getSheetAt(3);// 取工作简历页面
		int i = 0;
		for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum() + 1; rowIndex++) {// 从第二条开始读取
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			HSSFCell cell = row.getCell(0);
			String idCard = getCellString(cell);// 身份证号码
			if (idCard != null && idCard.trim().length() > 0) {
				this.workexperience.setTotals();// 总数
				try {
					RsWorkexperience rs = new RsWorkexperience();
					try {
						String date=getCellString(row.getCell(2));
						rs.setFromdate(sdf.parse(date));// 从何年何月
					} catch (Exception e) {
						throw new Exception("从何年何月为空或者格式不对！");
					}
					try {
						String date=getCellString(row.getCell(3));
						rs.setTodate(sdf.parse(date));// 至何年何月
					} catch (Exception e) {
						throw new Exception("至何年何月为空或者格式不对！");
					}
					try {
						rs.setCompanyname(row.getCell(4)
								.getRichStringCellValue().getString());// 单位名称
						if (rs.getCompanyname().length()>40) {
							throw new Exception();
						}
					} catch (Exception e) {
						throw new Exception("单位名称为空或者格式、长度不对！");
					}
					try {
						String pposition = row.getCell(5)
								.getRichStringCellValue().getString();
						rs.setPposition(pposition.substring(0, pposition
								.lastIndexOf(".")));// 从事岗位
					} catch (Exception e) {
						throw new Exception("从事岗位为空或者格式不对！");
					}
					if(!this.checkNumber("9", rs.getPposition())){
						throw new Exception("所选从事岗位不在可选范围内！");
					}
					i = 0;
					List<RsWorkexperience> l = map.get(idCard);
					if (l != null && l.size() > 0) {
						l.add(rs);
						map.put(idCard, l);
					} else {
						List<RsWorkexperience> lists = new ArrayList<RsWorkexperience>();
						lists.add(rs);
						map.put(idCard, lists);
					}
				} catch (Exception e) {
					this.workexperience.setFailcounts();// 失败数加1
					this.workexperience.getErrorlogs().append("<p>"+
							this.workexperience.getFailcount().toString() + "身份证号码：" + idCard
									+ "," +e.getMessage() + "</p>");
				}
			} else {// 连续空3行 表示已经读取完了
				i++;
				if (i > 3) {
					return map;
				}
			}
		}
		return map;
	}

	/**
	 * 返回批量导入人员的成果、专利、奖项
	 * 
	 * @return
	 */
	public Map<String, List<RsTechnologicalharvest>> getRsTechnologicalharvest() {
		Map<String, List<RsTechnologicalharvest>> map = new HashMap<String, List<RsTechnologicalharvest>>();
		HSSFSheet sheet = this.workbook.getSheetAt(4);// 取成果、专利、奖项页面
		int i = 0;
		for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum() + 1; rowIndex++) {// 从第二条开始读取
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			HSSFCell cell = row.getCell(0);
			String idCard = getCellString(cell);// 身份证号码
			if (idCard != null && idCard.trim().length() > 0) {
				RsTechnologicalharvest rs = new RsTechnologicalharvest();
				this.technologicalharvest.setTotals();
				try {
					try {
						String date=getCellString(row.getCell(2));
						rs.setAssessdate(sdf.parse(date));// 获取日期
					} catch (Exception e) {
						throw new Exception("获取日期为空或者格式不对！");
					}
					try {
						String harvestlevel = row.getCell(3)
								.getRichStringCellValue().getString();
						rs.setHarvestlevel(harvestlevel.substring(0,
								harvestlevel.lastIndexOf(".")));// 成果级别
					} catch (Exception e) {
						throw new Exception("成果级别为空或者格式不对！");
					}
					if(!this.checkNumber("13", rs.getHarvestlevel())){
						throw new Exception("所选成果级别不在可选范围内！");
					}
					try {
						rs.setHarvestname(row.getCell(4)
								.getRichStringCellValue().getString());// 成果名称
						if (rs.getHarvestname() == null || rs.getHarvestname().equals("") || rs.getHarvestname().length()>40) {
							throw new Exception();
						}
					} catch (Exception e) {
						throw new Exception("成果名称为空或者格式、长度不对！");
					}
					try {
						rs.setAssessdep(row.getCell(5).getRichStringCellValue()
								.getString());
						if (rs.getAssessdep() == null || rs.getAssessdep().equals("") || rs.getAssessdep().length()>40) {
							throw new Exception();
						}
					} catch (Exception e) {
						throw new Exception("发证单位为空或者格式、长度不对！");
					}
					rs.setPdemo(getCellString(row.getCell(6)));
					List<RsTechnologicalharvest> l = map.get(idCard);
					if (l != null && l.size() > 0) {
						l.add(rs);
						map.put(idCard, l);
					} else {
						List<RsTechnologicalharvest> lists = new ArrayList<RsTechnologicalharvest>();
						lists.add(rs);
						map.put(idCard, lists);
					}
					i = 0;
				} catch (Exception e) {
					this.technologicalharvest.setFailcounts();// 失败数加1
					this.technologicalharvest.getErrorlogs().append("<p>"+
							this.technologicalharvest.getFailcount().toString() + "身份证号码："
									+ idCard + "," +e.getMessage() + "</p>");
				}
			} else {// 连续空3行 表示已经读取完了
				i++;
				if (i > 3) {
					return map;
				}
			}
		}
		return map;
	}

	/**
	 * 返回批量导入人员的项目经验
	 * 
	 * @return
	 */
	public Map<String, List<RsProjectexperience>> getRsProjectexperience() {
		Map<String, List<RsProjectexperience>> map = new HashMap<String, List<RsProjectexperience>>();
		HSSFSheet sheet = this.workbook.getSheetAt(5);// 项目经验
		int i = 0;
		for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum() + 2; rowIndex++) {// 从第二条开始读取
			HSSFRow row = sheet.getRow(rowIndex);
			if (row == null) {
				continue;
			}
			HSSFCell cell = row.getCell(0);
			String idCard = getCellString(cell);// 身份证号码
			if (idCard != null && idCard.trim().length() > 0) {
				RsProjectexperience rs = new RsProjectexperience();
				this.projectexperience.setTotals();
				try {
					try {
						String date=getCellString(row.getCell(2));
						rs.setFromdate(sdf.parse(date));// 从何年何月
					} catch (Exception e1) {
						throw new Exception("从何年何月为空或者格式不对！");
					}
					try {
						String date=getCellString(row.getCell(3));
						rs.setTodate(sdf.parse(date));// 至何年何月
					} catch (Exception e1) {
						throw new Exception("至何年何月为空或者格式不对！");
					}
					try {
						BigDecimal j = BigDecimal.valueOf(Integer
								.valueOf(getCellString(row.getCell(4))));
						rs.setPersonnum(j);
					} catch (Exception e) {
						throw new Exception("团队人数为空或者格式不对！");
					}
					try {
						rs.setProjname(row.getCell(5).getRichStringCellValue()
								.getString());// 项目名称
						if(rs.getProjname() == null || rs.getProjname().equals("") || rs.getProjname().length()>40){
							throw new Exception();
						}
					} catch (Exception e1) {
						throw new Exception("项目名称为空或者格式、长度不对！");
					}
					Double projmoney = 0.0;
					try {
						projmoney = row.getCell(6).getNumericCellValue();
					} catch (Exception e) {
						projmoney = 0.0;
					}
					rs.setProjmoney(projmoney);// 项目金额
					rs.setProjresponsibility(getCellString(row.getCell(7)));// 参与者角色
					if(rs.getProjresponsibility()!=null&&rs.getProjresponsibility().length()>200){
						throw new Exception("参与角色不能超过200个字！");
					}
					i = 0;
					List<RsProjectexperience> l = map.get(idCard);
					if (l != null && l.size() > 0) {
						l.add(rs);
						map.put(idCard, l);
					} else {
						List<RsProjectexperience> lists = new ArrayList<RsProjectexperience>();
						lists.add(rs);
						map.put(idCard, lists);
					}
				} catch (Exception e) {
					this.projectexperience.setFailcounts();// 失败数加1
					this.projectexperience.getErrorlogs().append("<p>"+
							this.projectexperience.getFailcount().toString() + "身份证号码："
									+ idCard +"," + e.getMessage() + "</p>");
				}
			} else {// 连续空3行 表示已经读取完了
				i++;
				if (i > 3) {
					return map;
				}
			}
		}
		return map;
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public RsBatchlog getPerson() {
		return person;
	}

	public void setPerson(RsBatchlog person) {
		this.person = person;
	}

	public RsBatchlog getTechnicallymess() {
		return technicallymess;
	}

	public void setTechnicallymess(RsBatchlog technicallymess) {
		this.technicallymess = technicallymess;
	}

	public RsBatchlog getEducationexperience() {
		return educationexperience;
	}

	public void setEducationexperience(RsBatchlog educationexperience) {
		this.educationexperience = educationexperience;
	}

	public RsBatchlog getWorkexperience() {
		return workexperience;
	}

	public void setWorkexperience(RsBatchlog workexperience) {
		this.workexperience = workexperience;
	}

	public RsBatchlog getProjectexperience() {
		return projectexperience;
	}

	public void setProjectexperience(RsBatchlog projectexperience) {
		this.projectexperience = projectexperience;
	}

	public RsBatchlog getTechnologicalharvest() {
		return technologicalharvest;
	}

	public void setTechnologicalharvest(RsBatchlog technologicalharvest) {
		this.technologicalharvest = technologicalharvest;
	}

	private static String getCellString(HSSFCell cell) {
		String strRe = "";
		try {
			int iCellType = cell.getCellType();
			switch (iCellType) {
			case HSSFCell.CELL_TYPE_NUMERIC: {
				boolean b = HSSFDateUtil.isCellDateFormatted(cell);
				if (b) {
					cell.getDateCellValue();
					String strDate = sdf.format(cell.getDateCellValue());
					return strDate.trim();
				}
				double db = cell.getNumericCellValue();
				if (db == 0) {
					strRe = "0";
				}

				// 此处就是采用DecimalFormat 格式化的方式来解决的。
				java.text.DecimalFormat formatter = new java.text.DecimalFormat(
						"###########");
				strRe = formatter.format(cell.getNumericCellValue());
				break;
			}
			case HSSFCell.CELL_TYPE_STRING:
				strRe = cell.getRichStringCellValue().getString();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
			default:
				break;
			}
			return strRe.trim();
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String getCheckLog(StringBuffer log) {
		String logs=log.toString();
		if(log.length()>1000&&log.length()<2000){
			logs=StringUtils.rightPad(log.toString(), 2008);
		}
		return logs;
	}
	
	/**
	 *  验证电话号码
	 * @param args
	 * @throws Exception
	 */
	public boolean getCheckPhone() {
		String regEx="[1]{1}[3,5,8,6]{1}[0-9]{9}"; //表示a或f
		boolean p = Pattern.compile(regEx).matcher("13558842633").find();
		//-------------电话号码,以0开始,不含括号----------------------------------------------
		String tregEx="[0]{1}[0-9]{2,3}-[0-9]{7,8}"; //表示a或f 0832-80691990
		boolean tp = Pattern.compile(tregEx).matcher("028-80691990").find();
		if(p||tp){
			return true;
		}
		return false;
	}

	public Map<String, String> getPersonMap() {
		return personMap;
	}

	public void setPersonMap(Map<String, String> personMap) {
		this.personMap = personMap;
	}
	private  boolean checkNumber(String mapNo,String cellValue){//判断excel的值是否为map长度范围内，是返回true，否返回fasle	
		if(cellValue==null||cellValue.equals("")){
			return false;
		}
		int cValue=0;
		try {
			cValue= Integer.parseInt(cellValue);
		} catch (Exception e) {
			cValue=0;
			return true;
		}
		int mapSize=this.map.get(mapNo).size();
		if(mapSize>=cValue&&0<cValue){
			return true;
		}
		return false;
	}

	public String getFirstErroeMessage() {
		return firstErroeMessage;
	}

	public void setFirstErroeMessage(String firstErroeMessage) {
		this.firstErroeMessage = firstErroeMessage;
	}

}
