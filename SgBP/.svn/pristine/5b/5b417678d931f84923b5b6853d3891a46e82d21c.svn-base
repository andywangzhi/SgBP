package com.gzepro.internal.query.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.common.util.ValidateUtil;
import com.gzepro.internal.query.model.RsEducationexperience;
import com.gzepro.internal.query.model.RsPerson;
import com.gzepro.internal.query.model.RsProjectexperience;
import com.gzepro.internal.query.model.RsTechnicallymess;
import com.gzepro.internal.query.model.RsTechnologicalharvest;
import com.gzepro.internal.query.model.RsWorkexperience;
import com.gzepro.internal.query.system.action.BatchUploadExeclAction;

/**
 * 
 * @author HYQ
 * 
 */
public class WordDAO {
	/**
	 * 读取word文档的表格数据
	 * 
	 * @param filePath
	 * @return List
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	public Map<String, Map<String, String>> map;
	public StringBuffer log = new StringBuffer();
	private FileInputStream in = null;
	private POIFSFileSystem pfs = null;
	private HWPFDocument hwpf = null;
	private Range range = null;
	private TableIterator it = null;
	private Table tb = null;

	public WordDAO(String path, Map<String, Map<String, String>> map) {
		try {
			in = new FileInputStream(path);// 载入文档
			pfs = new POIFSFileSystem(in);
			hwpf = new HWPFDocument(pfs);
			range = hwpf.getRange();// 得到文档的读取范围
			it = new TableIterator(range);
			this.map = map;
		} catch (Exception e) {
			this.log.append("无法读取word文档，请检查文档是否有误！");
		}
	}

	public RsPerson getRsPerson() {
		String marked = "";// 标示为用户怎么勾选的word选项
		String paragraph_data = "";
		RsPerson rs = new RsPerson();
		if (it.hasNext()) {
			TableRow tr = null;
			TableCell td = null;
			tb = (Table) it.next();
			int tablePosition = tb.getStartOffset();// 获取表格所在位置
			Range r1 = new Range(0, tablePosition, hwpf);
			try {
			// 获取填表时间
			paragraph_data = this.replace(r1.text());
			paragraph_data = paragraph_data.replace("：", "");
			if (paragraph_data.indexOf("填表日期") < 0) {
				throw new Exception("找不到填表日期,请检查模板完好性！");
			}
			paragraph_data = paragraph_data.substring(paragraph_data
					.lastIndexOf("填表日期") + 4);
			Date operationalDate = null;
			
			
				// 检查word表格结构
				String title1 = this.replace(tb.getRow(0).text());
				if (title1.indexOf("个人基本信息") < 0) {
					throw new Exception(
							"\n模板出错，请检查模板完整性\n第1行个人基本信息附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				String title2 = this.replace(tb.getRow(7).text());
				if (title2.indexOf("职业现状") < 0) {
					throw new Exception(
							"\n个人基本信息模板被改动\n第8行职业现状附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				String title3 = this.replace(tb.getRow(12).text());
				if (title3.indexOf("职称/技能信息") < 0) {
					throw new Exception(
							"\n职业现状模板被改动\n第13行职称/技能信息附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				String title4 = this.replace(tb.getRow(18).text());
				if (title4.indexOf("教育简历") < 0) {
					throw new Exception(
							"\n职称/技能信息行数应为4行\n第19行教育简历附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				String title5 = this.replace(tb.getRow(24).text());
				if (title5.indexOf("工作简历") < 0) {
					throw new Exception(
							"\n教育简历行数应为4行\n第25行工作简历附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				String title6 = this.replace(tb.getRow(31).text());
				if (title6.indexOf("科技成果") < 0) {
					throw new Exception(
							"\n工作简历行数应为5行\n第32行科技成果附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				String title7 = this.replace(tb.getRow(38).text());
				if (title7.indexOf("项目经验") < 0) {
					throw new Exception(
							"\n科技成果行数应为5行\n第39行项目经验附近的word结构已经发生改变，无法读取word内容，请修改好后重新上传！");
				}
				
				String Poperator = this.replace(tb.getRow(47).text());
				Poperator = Poperator.replace("\r", "");
				Poperator = Poperator.replace("\n", "");
				if (Poperator.indexOf("申明") >= 0
						&& Poperator.indexOf("签名") >= 0) {
					if (Poperator.indexOf("签名") + 3 < Poperator.length()) {
						Poperator = Poperator
								.substring(Poperator.indexOf("签名") + 3);
						 rs.setPoperator(Poperator);
					}
				} else {
					throw new Exception(
							"第48行申明附近的文档结构已经改变，无法读取word内容，请修改好后重新上传！");
				}
				
				try{
				paragraph_data = paragraph_data.replace("年", "-");
				paragraph_data = paragraph_data.replace("月", "-");
				if (paragraph_data.indexOf("日") < 0) {
					paragraph_data = paragraph_data + "01";
				} else {
					paragraph_data = paragraph_data.substring(0, paragraph_data.indexOf("日"));
				}
				 operationalDate = sdf.parse(BatchUploadExeclAction.parseDate(paragraph_data));
				 rs.setOperationaldate(operationalDate);
				} catch (Exception e2) {
					throw new Exception("填表日期为空或者填表日期不对!");
				}

				// 获取姓名
				String pname = this.replace(tb.getRow(1).getCell(1).text());
				if (pname != null && pname.length() > 0 && pname.length() <= 10) {		
					  rs.setPname(pname); // 如果填表人员没有 默认取人员的姓名 
					  if (rs.getPoperator() == null
								|| rs.getPoperator().length() <= 0) {
							rs.setPoperator(pname);
						}			 
				} else {
					throw new Exception("姓名为空或者姓名格式、长度不对！");
				}

				// 获得勾选符号的标记
				String mak = this.replace(tb.getRow(1).getCell(2).text());
				mak = mak.replace("男", "");
				mak = mak.replace("女", "");
				mak = mak.replace("□", "");
				if (mak == null || mak.length() <= 0 || mak.length() >= 2) {
					throw new Exception("没有选择性别,或者改动了性别里面的字符，无法取得标示符！");
				}
				marked = mak;

				try {
					String pnation = this.replace(tb.getRow(1).getCell(4).text());
					pnation = pnation.replace(" ", "");
					if (!pnation.substring(pnation.length() - 1).equals("族")) {// 补回“族”字
							pnation = pnation + "族";
					}
					if (pnation != null && pnation.length() > 0) {
						// 循环民族
						Map<String, String> pmap = map.get("2");
						for (String code : pmap.keySet()) {
							if (pmap.get(code).equals(pnation)) {
								 rs.setPnation(code);
								break;
							}
						}
					}
				} catch (Exception e1) {
				}
				// 如果民族为空 默认为汉族
				if (rs.getPnation() == null || rs.getPnation().length() <= 0) {
					rs.setPnation("1");
				}
				 
				// 获取党派
				try {
					String polityvisage = this.replace(tb.getRow(1).getCell(6).text());
					int i = polityvisage.indexOf(marked);
					if (i >= 0) {
						polityvisage = polityvisage.substring(i);
						polityvisage = polityvisage.substring(1, polityvisage.indexOf("□") > 0 ? polityvisage.indexOf("□"): polityvisage.length());
						Map<String, String> pmap = map.get("3");
						for (String code : pmap.keySet()) {
							if (pmap.get(code).equals(polityvisage)) {
								rs.setPpolityvisage(code);// 3党派
								break;
							}
						}
					}

				} catch (Exception e6) {
				}

				// 表格第3行
				tr = tb.getRow(2);
				// 获取身份证号码
				String idcard = "";
				for (int i = 1; i < 19; i++) {
					idcard = idcard + this.replace(tr.getCell(i).text());
				}

				if (idcard != null && idcard.trim().length() > 0) {
					if (ValidateUtil.isPersonId(idcard) == null) {
						rs.setIdcard(idcard);
					} else {
						throw new Exception("身份证"
								+ ValidateUtil.isPersonId(idcard));
					}
				} else {
					throw new Exception("身份证号码格式或者长度不对！");
				}

				// 表格第4行
				tr = tb.getRow(3);
				// 获取毕业学校
				String graduatecollege = tr.getCell(1).text().trim();
				if (graduatecollege != null && graduatecollege.length() > 50) {
					throw new Exception("毕业院校的长度不能超过50个字!");
				}
				 rs.setGraduatecollege(graduatecollege);// 6为毕业院校

				// 获取专业名称
				String specialtyname = tr.getCell(3).text().trim();
				if (specialtyname != null && specialtyname.length() > 50) {
					throw new Exception("专业名称的长度不能超过50个字!");
				}
				 rs.setSpecialtyname(specialtyname);// 9为专业名称

				// 表格第5行
				tr = tb.getRow(4);
				// 获取学历
				String culturetype = tr.getCell(1).text().trim();
				culturetype = culturetype.replaceAll("_", "");
				culturetype = culturetype.replace("\r", "");
				culturetype = culturetype.replace("\n", "");
				if (culturetype.indexOf(marked) < 0) {
					try {
						culturetype = culturetype.substring(culturetype
								.indexOf("其他") + 2);
					} catch (Exception e) {
						culturetype = "";
					}
					if (culturetype != null && culturetype.length() > 0) {
						 rs.setCulturetype("6");// 6为其他
						 rs.setCulturetypeother(culturetype.trim().equals("√")?"":culturetype.trim());
					}
				} else if ((culturetype.indexOf(marked) + 1) == culturetype
						.length()) {
					 rs.setCulturetype("6");// 6为其他
					 rs.setCulturetypeother("不详");// 8为其他学历
				} else {
					culturetype = culturetype.substring(culturetype.indexOf(marked));
					culturetype = culturetype.substring(1, culturetype.indexOf("□") > 0 ? culturetype.indexOf("□"): culturetype.length());
					culturetype = culturetype.replace("□", "");
					culturetype = culturetype.replace("其他", "");
					Map<String, String> pmap = map.get("4");
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(culturetype)) {
							rs.setCulturetype(code);// 学历
							break;
						}
					}
				}

				// 获取专业类别
				String specialtyType = tr.getCell(3).text().trim();
				// 查看用户是否选择了 如果没有选择 默认见为空
				if (specialtyType.indexOf(marked) >= 0) {
					specialtyType = specialtyType.substring(specialtyType.indexOf(marked));
					specialtyType = specialtyType.substring(1, specialtyType.indexOf("□") > 0 ? specialtyType.indexOf("□"): specialtyType.length());
					specialtyType = specialtyType.replace("□", "");
					if (specialtyType != null && specialtyType.length() > 0) {
						Map<String, String> pmap = map.get("5");
						for (String code : pmap.keySet()) {
							if (pmap.get(code).equals(specialtyType)) {
								rs.setSpecialtytype(code);// 10专业类别
								break;
							}
						}
					}
				}

				// 表格第6行
				tr = tb.getRow(5);
				// 通讯住址
				String messageaddr = this.replace(tr.getCell(1).text());
				if (messageaddr != null && messageaddr.length() > 100) {
					throw new Exception("通讯地址的长度不能超过100个字!");
				}
					rs.setMessageaddr(messageaddr);// 11为通讯地址

				// 现户口 所在地
				String provs = this.replace(tr.getCell(3).text().trim());
				provs = provs.replace("_", "");
				String prov = provs.substring(0, provs.indexOf("省") + 1);
				
				if (prov != null && prov.length() > 0) {
					Map<String, String> pmap = map.get("6");
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(prov)) {
							rs.setRegisteraddrprov(code);// 10户口所在省
							break;
						}
					}
				}

				String rcity = provs.substring(provs.lastIndexOf("省") + 1);
				
				if (rcity != null && rcity.length() > 0) {
					Map<String, String> pmap = map.get("7");
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(rcity)) {
							rs.setRegisteraddrcity(code);// 10户口所在市
							break;
						}
					}
				}

				// 表格第7行
				tr = tb.getRow(6);
				// 获取电话号码
				String phone = tr.getCell(1).text().trim().replace(" ", "");
				if (phone != null && phone.length() > 0) {
					if (phone.length() > 40) {
						throw new Exception("电话号码的长度不能超过40个字!");
					}
					 rs.setPphone(phone);// 12为电话
				} else {
					throw new Exception("电话号码不能为空！");
				}
				// 获取邮箱
				String pemail = tr.getCell(3).text().trim().replace(" ", "");// 13为邮箱
				if (pemail != null && pemail.length() > 100) {
					throw new Exception("邮箱地址的长度不能超过100个字!");
				}
				if (!pemail.equals("@")) {
					rs.setPemail(pemail);
				}
				// 获取邮政编码
				String ppost = tr.getCell(5).text().trim().replace(" ", "");// 14为邮编
				if (ppost != null && ppost.length() > 6) {
					throw new Exception("邮编的长度不能超过6个字!");
				}
					rs.setPpost(ppost);

				// 表格第9行
				tr = tb.getRow(8);
				// 现在所在行业
				String Ptrade = this.replace(tr.getCell(1).text());
				Ptrade = Ptrade.replaceAll("_", "");
				if (Ptrade.indexOf(marked) < 0) {
					try {
						Ptrade = Ptrade.substring(Ptrade.indexOf("其他") + 2);
					} catch (Exception e) {
						Ptrade = "";
					}
					if (Ptrade != null && Ptrade.length() > 0) {
						rs.setPtrade("13");// 6为其他行业
						rs.setPtradeother(Ptrade.trim().equals("√")?"":Ptrade.trim());
					}
				} else if ((Ptrade.indexOf(marked) + 1) == Ptrade.length()) {
					rs.setPtrade("13");// 6为其他行业
					rs.setPtradeother("不详");// 8为其他行业
				} else {
					Ptrade = Ptrade.substring(Ptrade.indexOf(marked));
					Ptrade = Ptrade.substring(1,
							Ptrade.indexOf("□") > 0 ? Ptrade.indexOf("□")
									: Ptrade.length());
					Ptrade = Ptrade.replace("□", "");
					Ptrade = Ptrade.replace("其他", "");
					Map<String, String> pmap = map.get("8");
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(Ptrade)) {
							rs.setPtrade(code);// 行业
							break;
						}
					}
				}
				
				  if (rs.getPtrade() == null ||rs.getPtrade().trim().equals("")) { 
					 throw new Exception("现所在行业不能为空！"); }


				// 现从事岗位
				String pquarters = this.replace(tr.getCell(3).text());
				pquarters = pquarters.replaceAll("_", "");
				pquarters = pquarters.replace("\r", "");
				pquarters = pquarters.replace("\n", "");
				if (pquarters.indexOf(marked) < 0) {
					try {
						pquarters = pquarters
								.substring(pquarters.indexOf("其他") + 2);
					} catch (Exception e) {
						pquarters = "";
					}
					if (pquarters != null && pquarters.length() > 0) {
						 rs.setPquarters("6");// 6为其他岗位
						 rs.setPquartersother(pquarters);
					}
				} else if ((pquarters.indexOf(marked) + 1) == pquarters
						.length()) {
					rs.setPquarters("6");// 6为其他
					rs.setPquartersother("不详");// 8为其他岗位
				} else {
					pquarters = pquarters.substring(pquarters.indexOf(marked));
					pquarters = pquarters.substring(1,
							pquarters.indexOf("□") > 0 ? pquarters.indexOf("□")
									: pquarters.length());
					pquarters = pquarters.replace("□", "");
					pquarters = pquarters.replace("其他", "");
					Map<String, String> pmap = map.get("9");
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(pquarters)) {
							rs.setPquarters(code);// 现从事岗位
							break;
						}
					}
				}

				// 表格第10行
				tr = tb.getRow(9);
				// 单位性质
				String economyKind = this.replace(tr.getCell(1).text());
				economyKind = economyKind.replaceAll("_", "");
				economyKind = economyKind.replace(")", "");
				// 去掉 机关( 三个字 因为其中的( 有特殊意义
				economyKind = economyKind.substring(3);
				if (economyKind.indexOf(marked) < 0) {
					try {
						economyKind = economyKind.substring(economyKind
								.indexOf("其他") + 2);
					} catch (Exception e) {
						economyKind = "";
					}
					if (economyKind != null && economyKind.length() > 0) {
						rs.setEconomykind("9");// 9为其他
						rs.setEconomykindother(economyKind.trim().equals("√")?"":economyKind.trim());
					}
				} else if ((economyKind.indexOf(marked) + 1) == economyKind
						.length()) {
					rs.setEconomykind("9");// 9为其他
					rs.setEconomykindother("不详");// 8为其他单位性质
				} else {
					economyKind = economyKind.substring(economyKind
							.indexOf(marked));
					economyKind = economyKind.substring(1, economyKind
							.indexOf("□") > 0 ? economyKind.indexOf("□")
							: economyKind.length());
					economyKind = economyKind.replace("□", "");
					economyKind = economyKind.replace("其他", "");
					Map<String, String> pmap = map.get("10");
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(economyKind)) {
							rs.setEconomykind(code);// 单位性质
							break;
						}
					}
				}

				String pcounty = this.replace(tr.getCell(3).text());
				pcounty = pcounty.replace("区", "");
				pcounty = pcounty.replace("（", "");
				pcounty = pcounty.replace("县", "");
				pcounty = pcounty.replace("）", "");
				pcounty = pcounty.substring(pcounty.indexOf("市") + 1);
				Map<String, String> pmap = map.get("15");
				for (String code : pmap.keySet()) {
					if(pcounty.length()>1&&pmap.get(code).indexOf(pcounty)>-1){
						rs.setPcounty(code);// 现所在县区
						break;
					}
				/*	if (pmap.get(code).equals(pcounty + "县")
							|| pmap.get(code).equals(pcounty + "区")
							|| pmap.get(code).equals(pcounty + "市")) {
						rs.setPcounty(code);// 现所在县区
						break;
					}*/
				}
				
				 if (rs.getPcounty() == null ||
				 rs.getPcounty().trim().equals("")) { 
					 throw new Exception("现所在县区不能为空！"); }

				// 表格第11行
				tr = tb.getRow(10);
				// 现就业单位名称
				String workcompany = tr.getCell(1).text().trim().replace(" ",
						"");
				if (workcompany != null && workcompany.length() > 50) {
					throw new Exception("现就业单位名称长度不能超过50个字！");
				}
				 rs.setWorkcompany(workcompany);// 20为现就业单位名称
				 
				// 担任行政（技术）职务或级别
				String Dutylevel = tr.getCell(3).text().trim().replace(" ", "");
				if (Dutylevel != null && Dutylevel.length() > 50) {
					throw new Exception("担任行政职务或级别长度不能超过50个字！");
				}
				 rs.setDutylevel(Dutylevel);// 21为担任行政职务或级别

				// 表格第12行
				tr = tb.getRow(11);
				String Persontype = tr.getCell(1).text().trim().replace(" ", "");
				String[] personTypes = new String[6];
				int i = 0;
				while (Persontype.indexOf(marked) >= 0) {
					String y = Persontype.substring(Persontype.indexOf(marked) + 1);
					String x = y.substring(0, y.indexOf(marked) < 0 ? y.length() : y.indexOf(marked));
					String z = y.substring(0, y.indexOf("□") < 0 ? y.length(): y.indexOf("□"));
					if (x.length() <= z.length()) {
						personTypes[i] = y.substring(0, x.length());
					} else {
						personTypes[i] = y.substring(0, z.length());
					}
					Persontype = y.substring(personTypes[i].length());
					i++;
				}
				if (i == 0) {
					throw new Exception("人才类型不能为空!");
				}
				Persontype = "";
				pmap = map.get("11");
				for (String s : personTypes) {
					if (s != null && s.length() > 0) {
						for (String code : pmap.keySet()) {
							if (pmap.get(code).equals(s)) {
								Persontype = Persontype + code + ",";
								break;
							}
						}
					}
				}
				try {
					 rs.setPersontype(Persontype.substring(0,Persontype.length() - 1));// 人才类型
				} catch (java.lang.StringIndexOutOfBoundsException e) {
					throw new Exception("没有该人才类型，请检查模板完好性");
				}
				// 其他特长
				int StrongRow = tb.numRows() - 2;
				String Specialtystrong = tb.getRow(StrongRow).text().trim().replace(" ", "");
				if (Specialtystrong != null && Specialtystrong.length() > 100) {
					throw new Exception("其他特长不能超过100个字!");
				}
				rs.setSpecialtystrong(Specialtystrong);// 其他特长
				String[] birthDayAndSex = ValidateUtil.getBirthDayAndSex(rs.getIdcard());// 获取人员的出生上期和性别
				Date birthDate = DateUtil.getYYYYMMddDateFromInt(Integer.valueOf(birthDayAndSex[0]));
				String psex = (birthDayAndSex[1]).equals("1") ? "1" : "2";// 1为男2为女
				rs.setPsex(psex);
				rs.setPbirthday(birthDate);
				rs.setDelestate("0");
				rs.setAuditstate("000");
				rs.setAuditapplystate("0");
				rs.setDeleapplystate("0");

			}catch (Exception e) {
				this.log.append(e.getMessage());
				//throw new Exception();
			}
		}
		return rs;
	}

	 public List<RsTechnicallymess> getRsTechnicallymessList() {
		List<RsTechnicallymess> rsList = new ArrayList<RsTechnicallymess>();
		RsTechnicallymess rs = null;
		Date assessdate = null;
		Date currentTime = new Date();
		int[] date = new int[2];
		
		for(int i=14,j=0;i<=17;i++,j=0){
			try {
				rs = new RsTechnicallymess();
				//职称/技能信息：取得时间
				String assessDateStr = this.replace(tb.getRow(i).getCell(j).text());
				if(null==assessDateStr||"".equals(assessDateStr)){
					continue;
				}
				String message = "取得时间填写了错误数字!";
				date = wordFormatDate(assessDateStr, message);
				if(date[0]==0&&date[1]==0){
					continue;
				}
				assessdate = new Date(date[0]-1900,date[1]-1,1);
				//设置取得时间
				if(assessdate.before(currentTime)){
					rs.setAssessdate(assessdate);
				}else{
					throw new Exception(message);
				}
				//职称/技能信息：职称/技能专业名称
				String technicallytype =this.replace(tb.getRow(i).getCell(++j).text());
				if (technicallytype != null && technicallytype.length() > 0
						&& technicallytype.length() <= 50) {
					rs.setTechnicallytype(technicallytype);
				}else{
					throw new Exception("职称技能专业名称为空或者超过50个字!");
				}
				//职称/技能信息：职称技能级别
				String technicallylevel =this.replace(tb.getRow(i).getCell(++j).text());
				String key = "12";
				Map<String,String> pmap=map.get(key);
				if(null==technicallylevel||"".equals(technicallylevel)){
					throw new Exception("职称/技能级别不能为空!");
				}else if(pmap.containsValue(technicallylevel)){
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(technicallylevel)){
							rs.setTechnicallylevel(code);
						}
					}
				}else {
					throw new Exception("没有相应的职称/技能级别!");
				}
				rsList.add(rs);
			} catch (Exception e) {
				this.log.append("职称错误信息:"+e.getMessage());
			}
		}

		return rsList;
	}

	/**
	 * zhangwq
	 * 
	 * 2012-10-31
	 * 
	 * @return 教育简历信息
	 */
	public List<RsEducationexperience> getRsEducationexperienceList(){
		List<RsEducationexperience> rsList=new ArrayList<RsEducationexperience>();
		RsEducationexperience rs = null;
	
		Date fromdate=null;
		Date todate=null;
		Date currentTime = new Date();
		int[] date = new int [2];  		//存放年、月2个值
		for(int i=20,j=0;i<=23;i++,j=0){
			try{
				rs = new RsEducationexperience();
				//教育简历：从何年何月
				String fromdateStr = this.replace(tb.getRow(i).getCell(j).text());
				String message1 = "从何年何月填写了错误数字!";
				if(null==fromdateStr||"".equals(fromdateStr)){
					continue;
				}
				date = wordFormatDate(fromdateStr, message1);
				if(date[0] == 0 && date[1] == 0){
					continue;
				}
				fromdate = new Date(date[0]-1900,date[1]-1,1);
				//设置从何年何月
			
				if(fromdate.before(currentTime)){
					rs.setFromdate(fromdate);
				}else{
					throw new Exception(message1);
				}
				
				//教育简历：至何年何月
				String toDateStr =  this.replace(tb.getRow(i).getCell(++j).text());
				String message2 = "至何年何月填写了错误数字!";
				
				date = wordFormatDate(toDateStr, message2);
				if(date[0]==0&&date[1]==0){
					todate = new Date();
				}else{
					todate = new Date(date[0]-1900,date[1]-1,1);
				}
				currentTime = new Date();
				//设置至何年何月
				if(fromdate.before(todate)&&fromdate.before(todate)&&todate.getDate()<=currentTime.getDate()){
					rs.setTodate(todate);
				}else{
					throw new Exception(message2);
				}
			
				//教育简历: 毕业院校
				String pcollege =   this.replace(tb.getRow(i).getCell(++j).text());
				if(pcollege !=null && pcollege.length() > 0 && pcollege.length() <= 50){
					rs.setPcollege(pcollege);
				}else{
					throw new Exception("毕业院校名称为空或者超过50个字!");
				}
				//教育简历: 所学专业
				String specialtyname = this.replace(tb.getRow(i).getCell(++j).text());
				if(specialtyname != null && specialtyname.length() > 0 
						&& specialtyname.length() <= 50){
					rs.setSpecialtyname(specialtyname);
				}else{
					throw new Exception("所学专业名称为空或者超过50个字!");
				}
				
				rsList.add(rs);
			}catch(Exception e){
				this.log.append("教育简历错误信息:"+e.getMessage());
			}
		}
	
		return rsList;
	}	
	
	/**
	 * HYQ
	 * 
	 * 2012-12-10
	 * 
	 * @return 工作简历信息
	 */
	public List<RsWorkexperience> getRsWorkexperienceList(){
		List<RsWorkexperience> rsList=new ArrayList<RsWorkexperience>();
		RsWorkexperience rs = null;
		
			Date fromdate=null;
			Date todate=null;
			Date currentTime = new Date();
			int[] date = new int [2];
			for(int i=26,j=0;i<=30;i++,j=0){
			try{
				rs = new RsWorkexperience();
				//工作简历：从何年何月
				String fromdateStr = this.replace(tb.getRow(i).getCell(j).text());
				if(null==fromdateStr||"".equals(fromdateStr)){
					continue;
				}
				String message1 = "从何年何月填写了错误数字!";
			
				date = wordFormatDate(fromdateStr, message1);
				if(date[0] == 0 && date[1] == 0){
					continue;
				}
				fromdate = new Date(date[0]-1900,date[1]-1,1);
				//设置从何年何月
			
				if(fromdate.before(currentTime)){
					rs.setFromdate(fromdate);
				}else{
					throw new Exception(message1);
				}
			
				//工作简历：至何年何月
				String toDateStr = this.replace(tb.getRow(i).getCell(++j).text());
				String message2 = "至何年何月填写了错误数字!";
			
				date = wordFormatDate(toDateStr, message2);
				if(date[0]==0&&date[1]==0){
					todate = new Date();
				}else{
					todate = new Date(date[0]-1900,date[1]-1,1);
				}
				currentTime = new Date();
				//设置至何年何月
				if(fromdate.before(todate)&&fromdate.before(todate)&&todate.getDate()<=currentTime.getDate()){
					rs.setTodate(todate);
				}else{
					throw new Exception(message2);
				}
			
				//工作简历:单位名称
				String companyname=this.replace(tb.getRow(i).getCell(++j).text());
				if(companyname != null && companyname.length() >0 
						&& companyname.length() <=50){
					rs.setCompanyname(companyname);
				}else{
					throw new Exception("单位名称为空或者超过50个字!");
				}
				String pposition=this.replace(tb.getRow(i).getCell(++j).text());
				String key ="9";
				Map<String,String> pmap = map.get(key);
				if(null==pposition||"".equals(pposition)){
					throw new Exception("从事岗位不能为空!");
				}else if(pmap.containsValue(pposition)){
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(pposition)){
							rs.setPposition(code);
						}
					}
				}else{
					throw new Exception("没有相应的从事岗位!");
				}
				rsList.add(rs);
			}catch(Exception e){
				this.log.append("工作简历错误信息:"+e.getMessage());
			}
		}
		return rsList;
	}
	
	
	/**
	 * HYQ
	 * 
	 * 2012-12-10
	 * 
	 * @return 科技成果信息
	 */
	public List<RsTechnologicalharvest> getRsTechnologicalharvestList(){
		List<RsTechnologicalharvest> rsList=new ArrayList<RsTechnologicalharvest>();
		RsTechnologicalharvest rs = null;
		Date assessdate = null;
		Date currentTime = new Date();
		int[] date = new int [2];
		for(int i=33,j=0;i<=37;i++,j=0){
			try{
				rs = new RsTechnologicalharvest();
				//科技成果信息：取得时间
				String assessDateStr = this.replace(tb.getRow(i).getCell(j).text());
				if(null==assessDateStr||"".equals(assessDateStr)){
					continue;
				}
				String message = "取得时间填写了错误数字!";
				date = wordFormatDate(assessDateStr, message);
				
				if(date[0]==0&&date[1]==0){
					continue;
				}
				assessdate = new Date(date[0]-1900,date[1]-1,1);
				
				//设置取得时间
				if(assessdate.before(currentTime)){
					rs.setAssessdate(assessdate);
				}else{
					throw new Exception("取得时间填写了错误数字!");
				}
				//科技成果信息：成果等级
				String harvestlevel = this.replace(tb.getRow(i).getCell(++j).text());
				String key = "13";
				Map<String,String> pmap=map.get(key);
				if(null==harvestlevel||"".equals(harvestlevel)){
					throw new Exception("成果等级不能为空!");
				}
				else if(harvestlevel.indexOf("省级")>-1){	//防止只填写省级（正确为：省部级）
					harvestlevel="省部级";
				}
				else if(harvestlevel.indexOf("县级")>-1){	//防止只填写县级（正确为：县（区）级）
					harvestlevel="县（区）级";
				}
				if(pmap.containsValue(harvestlevel)){
					for (String code : pmap.keySet()) {
						if (pmap.get(code).equals(harvestlevel)){
							rs.setHarvestlevel(code);
						}
					}
				}else {
					throw new Exception("没有相应的成果等级!");
				}
				String harvestname =  this.replace(tb.getRow(i).getCell(++j).text());
				if(harvestname != null && harvestname.length() > 0 
						&& harvestname.length() <=50){
					rs.setHarvestname(harvestname);
				}else{
					throw new Exception("科技成果名称为空或者超过50个字!");
				}
				
				String assessdep =  this.replace(tb.getRow(i).getCell(++j).text());
				if(assessdep != null && assessdep.length() > 0 
						&& assessdep.length() <=50){
					rs.setAssessdep(assessdep);
				}else{
					throw new Exception("发证单位名称为空或者超过50个字!");
				}
				String pdemo =  this.replace(tb.getRow(i).getCell(++j).text());
				
				if(pdemo != null && pdemo.length()>0 && pdemo.length() <=100){
					rs.setPdemo(pdemo);
				}else if(pdemo == null || pdemo.length() ==0){
					
				}else{
					throw new Exception("备注信息超过100个字"+pdemo.length());
				}
				rsList.add(rs);
			}catch(Exception e){
				this.log.append("科技成果错误信息:"+e.getMessage());
			}
		}
		return rsList;
	}
	
	
	/**
	 *HYQ
	 * 
	 * 2012-12-01
	 * 
	 * @return 项目经验信息
	 */
	public List<RsProjectexperience> getRsProjectexperienceList(){
		List<RsProjectexperience> rsList=new ArrayList<RsProjectexperience>();
		RsProjectexperience rs = null;
		Date fromdate = null;
		Date todate = null;
		Date currentTime = new Date();
		int[] date =new int [2];   //存放年、月2个值
		for(int i=40,j=0;i<=44;i++,j=0){
			try{
				rs = new RsProjectexperience();
				//项目经验：从何年何月
				String fromdateStr = this.replace(tb.getRow(i).getCell(j).text());
				if(null==fromdateStr||"".equals(fromdateStr)){
					continue;
				}
				String message1 = "从何年何月填写了错误数字!";
				date = wordFormatDate(fromdateStr, message1);
				if(date[0] == 0 && date[1] == 0){
					continue;
				}
				fromdate = new Date(date[0]-1900,date[1]-1,1);
				//设置从何年何月		
				if(fromdate.before(currentTime)){
					rs.setFromdate(fromdate);
				}else{
					throw new Exception(message1);
				}			
				//项目经验：至何年何月
				String toDateStr =  this.replace(tb.getRow(i).getCell(++j).text());
				String message2 = "至何年何月填写了错误数字!";
			
				date = wordFormatDate(toDateStr, message2);
				if(date[0]==0&&date[1]==0){
					todate = new Date();
				}else{
					todate = new Date(date[0]-1900,date[1]-1,1);
				}
				//设置至何年何月
				if(fromdate.before(todate)&&todate.getDate()<=currentTime.getDate()){
					rs.setTodate(todate);
				}else{
					throw new Exception(message2);
				}
			
				//项目经验:团队人数
				String personnumStr = this.replace(tb.getRow(i).getCell(++j).text());
				try{
					if(null != personnumStr && !"".equals(personnumStr)){
						BigDecimal personnum = new BigDecimal(personnumStr);
						rs.setPersonnum(personnum);
					}
				}catch(Exception e){
					throw new Exception("项目人数填写了非法数字!");
				}
				//项目经验:项目名称
				String projname =this.replace(tb.getRow(i).getCell(++j).text());
				if(projname != null && projname.length() > 0 
						&& projname.length() <=50){
					rs.setProjname(projname);
				}else{
					throw new Exception("项目名称为空或者超过50个字!");
				}
				//项目经验:项目金额
				String projmoneyStr =this.replace(tb.getRow(i).getCell(++j).text());
				try{
					Double projmoney = Double.parseDouble(projmoneyStr);
					rs.setProjmoney(projmoney);
				}catch(Exception e){
					throw new Exception("项目金额填写了非法数字!");
				}
				//项目经验:项目担任的角色
				String projresponsibility = this.replace(tb.getRow(i).getCell(++j).text());
				if(projresponsibility != null && projresponsibility.length() > 0 
						&& projresponsibility.length() <=50){
					rs.setProjresponsibility(projresponsibility);
				}else if(projresponsibility == null || projresponsibility.length() == 0){
				
				}else {
					throw new Exception("项目中担任的角色超过50个字!");
				}
				rsList.add(rs);
			}catch(Exception e){
				this.log.append("项目经验错误信息:"+e.getMessage());
			}
		}
		return rsList;
	}
	
	public String change(String docfile){
		BufferedOutputStream output = null;
		String newfile="";
		try{
			
			List<Picture> pictures=hwpf.getPicturesTable().getAllPictures();
			if(pictures.size()>0){
				Picture t=pictures.get(0);
				newfile=docfile.replace("doc", "jpg");
				output = new BufferedOutputStream(new FileOutputStream(newfile));
						output.write(t.getContent());
						output.flush();
						output.close();
			}else{
				return null;
			}
			
		}catch (Exception e) {
			this.log.append("图片读取失败");
			return null;
		}
		return newfile;	
	}
	
	public  void change(String docfile, String htmlfile) {
		BufferedOutputStream output = null;
		try{
			Picture picture=hwpf.getPicturesTable().getAllPictures().get(0);
			if(picture!=null){
				File file=new File("D://"+htmlfile);
				if (!file.isDirectory()) {// 判断是否存在失败文件夹
					file.mkdir(); // 创建文件夹
				}
				output = new BufferedOutputStream(new FileOutputStream(htmlfile+"//aaa.jpg"));
						output.write(picture.getContent());
						output.flush();
						output.close();
			}
			
		}catch (Exception e) {
			this.log.append("图片读取失败");
		}
		finally{
			
		}
		
	}
	
	public void close() {
		if (null != in) {
			try {
				in.close();
			} catch (Exception e) {
			}
		}
	}

	private String replace(String cellString) {
		if (cellString != null && cellString.compareTo("") != 0) {
			// 如果不trim，取出的内容后会有一个乱码字符
			cellString = cellString.trim();
			cellString = cellString.replace("\r", "");
			cellString = cellString.replace("\n", "");
			cellString = cellString.replace(" ", "");
			cellString = cellString.replace("　", "");
		}
		return cellString;
	}

	// 过滤word文档日期多种填写方式
	public static int[] wordFormatDate(String dateStr, String message)
			throws Exception {
		int year = 0, month = 0;
		int date[] = new int[2];
		dateStr = dateStr.replace('年', '-').replace('月', '-');
		String[] dateArr = dateStr.split("-");
		if (dateArr.length > 1) {
			year = Integer.parseInt(dateArr[0]);
			month = Integer.parseInt(dateArr[1]);
			if (month > 12 || (year < 1000 && year > 0)) {
				throw new Exception(message);
			}
		} else if (dateArr.length == 1) {
			if (isNumericByPattern(dateArr[0])) {
				year = Integer.parseInt(dateArr[0]);
				month = 1;
				if (month > 12 || (year < 1000 && year > 0)) {
					throw new Exception(message);
				}
			} else {
				year = 0;
				month = 0;
			}
		} else {
			year = 0;
			month = 0;
		}

		date[0] = year;
		date[1] = month;

		return date;
	}

	// 判断是否数字字串
	public static boolean isNumericByPattern(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}


}