package com.gzepro.internal.query.system.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.model.RsBatchlog;
import com.gzepro.internal.query.model.RsEducationexperience;
import com.gzepro.internal.query.model.RsPerson;
import com.gzepro.internal.query.model.RsPersontype;
import com.gzepro.internal.query.model.RsPersontypeReport;
import com.gzepro.internal.query.model.RsProjectexperience;
import com.gzepro.internal.query.model.RsResult;
import com.gzepro.internal.query.model.RsTechnicallymess;
import com.gzepro.internal.query.model.RsTechnologicalharvest;
import com.gzepro.internal.query.model.RsWorkexperience;
import com.gzepro.internal.query.model.ViewRsPersontype;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.base.QueryRsPersonListSO;
import com.gzepro.internal.query.system.service.ExcelService;

/**
 * 
 * 
 * 实现excel批量导入的service
 * 
 * @author 王志 E-mail:wangzhi291@163.com
 * @version 1.0 Created On: 2012-7-24
 */

@Component("excelService")
public class ExcelServiceImpl extends BaseService implements ExcelService {

	public RsEducationexperience addRsEducationexperience(
			RsEducationexperience educationexperience) {
		RsEducationexperience edu = (RsEducationexperience) baseDao
				.create(educationexperience);
		return edu;
	}

	public RsPerson add(RsPerson person) {
		RsPerson rsperson = (RsPerson) baseDao.create(person);
		String type = rsperson.getPersontype();
		String[] ary = type.split(",\\s*");
		for (String str : ary) {
			RsPersontype t = new RsPersontype();
			t.setPersonId(rsperson.getPersonid());
			t.setType(str);
			baseDao.create(t);
			
			RsPersontypeReport report = new RsPersontypeReport();
			report.setPersonId(rsperson.getPersonid());
			report.setType(str);
			baseDao.create(report);
		}
		String temp_type = "";
		if(type.indexOf("1") != -1){
			temp_type = "1";
		}else if(type.indexOf("2") != -1){
			temp_type = "2";
		}else if(type.indexOf("4") != -1){
			temp_type = "4";
		}else if(type.indexOf("5") != -1){
			temp_type = "5";
		}else if(type.indexOf("3") != -1){
			temp_type = "3";
		}if(type.indexOf("6") != -1){
			temp_type = "6";
		}
		ViewRsPersontype view = new ViewRsPersontype();
		view.setPersonId(rsperson.getPersonid());
		view.setType(temp_type);
		baseDao.create(view);
		return rsperson;
	}

	public RsProjectexperience addRsProjectexperience(
			RsProjectexperience projectexperience) {
		RsProjectexperience edu = (RsProjectexperience) baseDao
				.create(projectexperience);
		return edu;
	}

	public RsTechnicallymess addRsTechnicallymess(
			RsTechnicallymess rsTechnicallymess) {
		RsTechnicallymess edu = (RsTechnicallymess) baseDao
				.create(rsTechnicallymess);
		List _list = baseDao.find("from RsPersontypeReport t where type = '3' and personId = '"+edu.getRsPerson().getPersonid()+"'");
		if(_list == null || _list.size() == 0){
			RsPersontypeReport report = new RsPersontypeReport();
			report.setPersonId(edu.getRsPerson().getPersonid());
			report.setType("3");
			baseDao.create(report);
		}
		return edu;
	}

	public RsTechnologicalharvest addRsTechnologicalharvest(
			RsTechnologicalharvest rsTechnologicalharvest) {
		RsTechnologicalharvest edu = (RsTechnologicalharvest) baseDao
				.create(rsTechnologicalharvest);
		return edu;
	}

	public RsWorkexperience addRsWorkexperience(
			RsWorkexperience rsWorkexperience) {
		RsWorkexperience edu = (RsWorkexperience) baseDao
				.create(rsWorkexperience);
		return edu;
	}

	@SuppressWarnings("unchecked")
	public boolean queryRsperson(String idcard) {
		String hql = " from RsPerson r where r.idcard='" + idcard + "'";
		List ls = this.baseDao.find(hql);
		if (ls != null && ls.size() > 0) {
			return true;
		}
		return false;
	}

	public RsBatchlog addBatchlog(RsBatchlog batchlog) {
		RsBatchlog rsBatchlog = (RsBatchlog) baseDao.create(batchlog);
		return rsBatchlog;
	}

	public Paging queryRsBatchlog(String lognumber, Date fromDate, Date todate,
			String adduser, String typeid, Paging paging) {
		Paging pag = null;
		String hql = " from RsBatchlog r where 1=1 ";
		if (typeid != null && typeid.length() > 0) {
			hql = hql + " and  r.typeid='" + typeid + "' ";
		}
		if (adduser != null && adduser.length() > 0) {
			hql = hql + " and r.adduser like '%" + adduser + "%' ";
		}
		if (lognumber != null && lognumber.length() > 0) {
			hql = hql + " and r.lognumber like '%" + lognumber + "%'";
		}
		Object[] date = null;
		if (fromDate != null && todate != null) {
			hql = hql + " and r.adddate between ? and ? ";
			date = new Object[] { fromDate, todate };
		} else if (fromDate != null && todate == null) {
			hql = hql + " and r.adddate >= ?";
			date = new Object[] { fromDate };
		} else if (fromDate == null && todate != null) {
			hql = hql + " and r.adddate <= ?";
			date = new Object[] { todate };
		}
		hql = hql + " order by adddate desc ";
		pag = this.baseDao.selectPaging(hql, date, paging);

		return pag;
	}

	public Long queryBatchlogNumber() {
		HibernateTemplate h = baseDao.getHbTemplate();
		Session session = h.getSessionFactory().getCurrentSession();
		Query query = session
				.createSQLQuery("select SEQ_Batchlog_number.Nextval from dual ");
		List list = query.list();
		Long number = new Long(list.get(0).toString());
		return number;
	}


	public Paging jqQueryRsperson(String name, String idcard,
			String personType,Paging p, String pcounty,String unitlvl) {
		String hql = " from RsPerson r where 1=1 ";
		if (idcard != null && idcard.trim().length() > 0) {
			hql = hql + " and r.idcard='"+idcard+"'";
		}
		if (name != null && name.trim().length() > 0) {
			hql = hql + " and r.pname like '%"+name+"%' ";
		}
		if (personType != null && personType.trim().length() > 0) {
			hql = hql + " and r.persontype like '%" + personType + "%' ";
		}
		
		if(pcounty!=null&&!pcounty.trim().equals("")){
			//表示用户类型为县级用户
			hql += " and r.pcounty = '"+pcounty+"' ";
		}
		if(unitlvl!=null&&!unitlvl.trim().equals("")){
			hql += " and r.unitlvl = '"+unitlvl+"' ";
		}
		hql =hql+" order by r.operationaldate DESC ";
		p = baseDao.selectPaging(hql, null, p);
		if (p != null &&p.getVoList()!=null&& p.getVoList().size() > 0) {
			return p;
		}
		return null;
	}


	public Long jqQueryRsperson(String name, String idcard,String personType,String pcounty,String unitlvl) {
		String hql = "select count(r) from RsPerson r where 1=1 ";
		if (idcard != null && idcard.trim().length() > 0) {
			hql = hql + " and r.idcard='"+idcard+"'";
		}
		if (name != null && name.trim().length() > 0) {
			hql = hql + " and r.pname like '%"+name+"%' ";
		}
		if (personType != null && personType.trim().length() > 0) {
			hql = hql + " and r.persontype like '%" + personType + "%' ";
		}
		if(pcounty!=null&&!pcounty.trim().equals("")){
			//表示用户类型为县级用户
			hql += " and r.pcounty = '"+pcounty+"' ";
			hql += " and r.unitlvl = '"+unitlvl+"' ";
		}else{
			//表示用户类型为市本级用户(以下条件用于精确和模糊查询的时候，是否选择了单位所属)
			if(unitlvl!=null&&!unitlvl.trim().equals("")){
				hql += " and r.unitlvl = '"+unitlvl+"' ";
			}
		}
		List<Object> l = baseDao.find(hql);
		if (l != null && l.size() > 0) {
			return new Long(l.get(0).toString());
		}
		return new Long(0);
	}


	public Paging mhQueryRsperson(QueryRsPersonListSO so, Paging p) {
		String hql = " from RsPerson r where 1=1 ";
		
		if (so.getPname()!=null&&so.getPname().trim().length()>0) {
			hql = hql + " and r.pname like '%"+so.getPname().trim()+"%' ";
		}
		
		if (so.getPnation()!=null&&so.getPnation().trim().length()>0) {
			hql = hql + " and r.pnation="+so.getPnation();
		}
		
		if (so.getPpolityvisage()!=null&&so.getPpolityvisage().length()>0) {
			hql = hql +" and r.ppolityvisage="+so.getPpolityvisage();
		}
		
		if (so.getCultureType()!=null&&so.getCultureType().length()>0) {
			hql = hql +" and r.culturetype="+so.getCultureType();
		}
		
		if (so.getSpecialtytype()!=null&&so.getSpecialtytype().length()>0) {
			hql = hql +" and r.specialtytype="+so.getSpecialtytype();
		}
		
		if (so.getPtrade()!=null&&so.getPtrade().length()>0) {
			hql = hql +" and r.ptrade="+so.getPtrade();
		}
		
		if (so.getPquarters()!=null&&so.getPquarters().length()>0) {
			hql = hql +" and r.pquarters="+so.getPquarters();
		}
		
		if (so.getEconomyKind()!=null&&so.getEconomyKind().length()>0) {
			hql = hql +" and r.economykind="+so.getEconomyKind();
		}
		
		if (so.getPcounty()!=null&&so.getPcounty().length()>0) {
			hql = hql +" and r.pcounty="+so.getPcounty();
		}
		
		if (so.getWorkCompany()!=null&&so.getWorkCompany().length()>0) {
			hql = hql +" and r.workcompany like '%"+so.getWorkCompany()+"%'";
		}
		
		if (so.getDutylevel()!=null&&so.getDutylevel().length()>0) {
			hql = hql +" and r.dutylevel like '%"+so.getDutylevel()+"%'";
		}
		
		if (so.getPersonType()!=null&&so.getPersonType().length()>0) {
			hql = hql +" and r.persontype like '%"+so.getPersonType()+"%'";
		}
		
		
		if (so.getTechnicallyLevel()!=null&&so.getTechnicallyLevel().length()>0) {
			hql = hql + " and r.technicallyLevel="+so.getTechnicallyLevel();
		}
		if (so.getTechnicallyType()!=null&&so.getTechnicallyType().trim().length()>0) {
			hql = hql +" and r.technicallyType like '%"+so.getTechnicallyType()+"%'";
		}
		if (so.getAssessDep()!=null&&so.getAssessDep().trim().length()>0) {
			hql = hql +" and r.assessDep like '%"+so.getAssessDep()+"%'";
		}
		if (so.getHarvestName()!=null&&so.getHarvestName().trim().length()>0) {
			hql = hql +" and r.harvestName like '%"+so.getHarvestName()+"%'";
		}
		if (so.getHarvestLevel()!=null&&so.getHarvestLevel().length()>0) {
			hql = hql + " and r.harvestLevel="+so.getHarvestLevel();
		}
		if (so.getSpecialtyName()!=null&&so.getSpecialtyName().trim().length()>0) {
			hql = hql +" and r.specialtyName like '%"+so.getSpecialtyName()+"%'";
		}
		if (so.getGraduatecollege()!=null&&so.getGraduatecollege().trim().length()>0) {
			hql = hql +" and r.graduatecollege like '%"+so.getGraduatecollege()+"%'";
		}
		
		if (so.getPersonKind()!=null&&so.getPersonKind().length()>0) {
			hql = hql + " and r.personKind="+so.getPersonKind();
		}
		
		if (so.getPsex()!=null&&so.getPsex().length()>0) {
			hql = hql + " and r.psex="+so.getPsex();
		}
		
		if(so.getForage()!=null&&!so.getForage().trim().equals("")){
			hql = hql + " and r.pbirthday <= To_date( '"+ so.getForage() + "','YYYY-MM-DD' ) " ;
		}
		
		if(so.getToage()!=null&&!so.getToage().trim().equals("")){
			hql = hql + " and r.pbirthday >= To_date( '"+ so.getToage() + "','YYYY-MM-DD' ) " ;
		}
		
		System.out.println(" hql = " +hql);
		
		hql =hql+" order by r.operationaldate DESC ";
		p = baseDao.selectPaging(hql, null, p);
		if (p != null &&p.getVoList()!=null&& p.getVoList().size() > 0) {
			return p;
		}
		return null;
	}


	public Long mhQueryRsperson(QueryRsPersonListSO so) {
		String hql = "select count(r) from RsPerson r where 1=1 ";
		if (so.getPname()!=null&&so.getPname().trim().length()>0) {
			hql = hql + " and r.pname like '%"+so.getPname().trim()+"%' ";
		}
		if (so.getPnation()!=null&&so.getPnation().trim().length()>0) {
			hql = hql + " and r.pnation="+so.getPnation();
		}
		if (so.getPpolityvisage()!=null&&so.getPpolityvisage().length()>0) {
			hql = hql +" and r.ppolityvisage="+so.getPpolityvisage();
		}
		if (so.getCultureType()!=null&&so.getCultureType().length()>0) {
			hql = hql +" and r.culturetype="+so.getCultureType();
		}
		if (so.getSpecialtytype()!=null&&so.getSpecialtytype().length()>0) {
			hql = hql +" and r.specialtytype="+so.getSpecialtytype();
		}
		if (so.getPtrade()!=null&&so.getPtrade().length()>0) {
			hql = hql +" and r.ptrade="+so.getPtrade();
		}
		if (so.getPquarters()!=null&&so.getPquarters().length()>0) {
			hql = hql +" and r.pquarters="+so.getPquarters();
		}
		if (so.getEconomyKind()!=null&&so.getEconomyKind().length()>0) {
			hql = hql +" and r.economykind="+so.getEconomyKind();
		}
		if (so.getPcounty()!=null&&so.getPcounty().length()>0) {
			hql = hql +" and r.pcounty="+so.getPcounty();
		}
		if (so.getWorkCompany()!=null&&so.getWorkCompany().length()>0) {
			hql = hql +" and r.workcompany like '%"+so.getWorkCompany()+"%'";
		}
		if (so.getDutylevel()!=null&&so.getDutylevel().length()>0) {
			hql = hql +" and r.dutylevel like '%"+so.getDutylevel()+"%'";
		}
		if (so.getPersonType()!=null&&so.getPersonType().length()>0) {
			hql = hql +" and r.persontype like '%"+so.getPersonType()+"%'";
		}
		if (so.getTechnicallyLevel()!=null&&so.getTechnicallyLevel().length()>0) {
			hql = hql + " and r.technicallyLevel="+so.getTechnicallyLevel();
		}
		if (so.getTechnicallyType()!=null&&so.getTechnicallyType().trim().length()>0) {
			hql = hql +" and r.technicallyType like '%"+so.getTechnicallyType()+"%'";
		}
		if (so.getAssessDep()!=null&&so.getAssessDep().trim().length()>0) {
			hql = hql +" and r.assessDep like '%"+so.getAssessDep()+"%'";
		}
		if (so.getHarvestName()!=null&&so.getHarvestName().trim().length()>0) {
			hql = hql +" and r.harvestName like '%"+so.getHarvestName()+"%'";
		}
		if (so.getHarvestLevel()!=null&&so.getHarvestLevel().length()>0) {
			hql = hql + " and r.harvestLevel="+so.getHarvestLevel();
		}
		if (so.getSpecialtyName()!=null&&so.getSpecialtyName().trim().length()>0) {
			hql = hql +" and r.specialtyName like '%"+so.getSpecialtyName()+"%'";
		}
		if (so.getGraduatecollege()!=null&&so.getGraduatecollege().trim().length()>0) {
			hql = hql +" and r.graduatecollege like '%"+so.getGraduatecollege()+"%'";
		}
		
		if (so.getPersonKind()!=null&&so.getPersonKind().length()>0) {
			hql = hql + " and r.personKind="+so.getPersonKind();
		}
		
		if (so.getPsex()!=null&&so.getPsex().length()>0) {
			hql = hql + " and r.psex="+so.getPsex();
		}
		
		if(so.getForage()!=null&&!so.getForage().trim().equals("")){
			hql = hql + " and r.pbirthday <= To_date( '"+ so.getForage() + "','YYYY-MM-DD' ) " ;
		}
		
		if(so.getToage()!=null&&!so.getToage().trim().equals("")){
			hql = hql + " and r.pbirthday >= To_date( '"+ so.getToage() + "','YYYY-MM-DD' ) " ;
		}
		
		List<Object> l = baseDao.find(hql);
		if (l != null && l.size() > 0) {
			return new Long(l.get(0).toString());
		}
		return new Long(0);
	}

	public List<RsResult> tjQueryRsperson() {
		String hql=" from RsResult ";
		return  baseDao.find(hql);
	}

}
