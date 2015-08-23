package com.gzepro.internal.query.soa.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.model.RsSocialworker;
import com.gzepro.internal.query.model.RsTalantteam;

/**
 * 
  * @ClassName: EducationexperienceService
  * @Description: TODO(人才队伍建设)
  * @author 张建薇
  * @date Jul 24, 2012 7:25:33 PM
  *
 */
@Service("rsTalantTeamService")
public class RsTalantTeamService  extends BaseService{
	
	/**
	 * 
	 * @return 查询某一年的配置信息
	 * 配置信息中包含:某年的持证社工数、人口总量、从业人员总量和农村农运力总量
	 */
	@SuppressWarnings("unchecked")
	public List<RsSocialworker> queryCurrentYearConf(String curYear) {
		String hql = " from RsSocialworker r where r.swdate='" + curYear + "' order by r.qx";
		List list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<RsSocialworker> queryCurYearAndLastYearConf(String curYear) {
		String lastYear=String.valueOf(Integer.valueOf(curYear)-1);
		String hql = " from RsSocialworker r where r.swdate in (?,?) order by r.swdate,r.qx";
		List list = this.baseDao.find(hql,new Object[]{curYear,lastYear});
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	/**
	 * 特定的行今年、去年的数据
	 * @param year
	 * @param type
	 * @return
	 */
	public List<RsTalantteam> queryRowByYear(String year,String type){
		String lastYear=String.valueOf(Integer.valueOf(year)-1);
		String hql = " from RsTalantteam r where r.td in('" + year + "','" + lastYear + "') and r.tp = '" + type + "' order by r.td desc";
		List list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	/**
	 * 
	 * @return 查询某一年统计的总数据集
	 */
	@SuppressWarnings("unchecked")
	public List<RsTalantteam> queryDataByYear(String year) {
		String hql = " from RsTalantteam r where r.td='" + year + "' order by r.tp";
		List list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	/**
	 * 
	 * @return 查询某一年统计的总数据集
	 */
	@SuppressWarnings("unchecked")
	public List<RsTalantteam> queryCurYearAndLastYearDataByYear(String year) {
		String lastYear=String.valueOf(Integer.valueOf(year)-1);
		String hql = " from RsTalantteam r where r.td in (?,?) order by r.td,r.tp";
		List list = this.baseDao.find(hql,new Object[]{year,lastYear});
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
	
	/**
	 * 
	 * @param rsSocialworkerList 持证社会和配置信息
	 * @return 更新当前年的持证社工人数和配置信息
	 */
	public RsSocialworker saveOrUpdate(RsSocialworker rsSocialworker) {
		return (RsSocialworker) this.baseDao.saveOrUpdate(rsSocialworker);
	}
}
