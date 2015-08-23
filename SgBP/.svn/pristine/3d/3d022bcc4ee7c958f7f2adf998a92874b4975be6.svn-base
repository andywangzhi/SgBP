/**
 * 
 */
package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Conf;
import com.gzepro.internal.query.system.model.RsRcgzkhpfb;

/**
 * @author SgBP 广州易宝信息技术有限公司
 * @since  2013-3-21
 * @version 1.0
 */
@Service("rsRcgzkhpfbService")
public class RsRcgzkhpfbService extends SystemBaseService{
	
	public RsRcgzkhpfb saveOrUpdate(RsRcgzkhpfb object){
		if(object.getPk() != null && !object.getPk().equals("")){
			return (RsRcgzkhpfb)baseDao.update(object);
		}
		return (RsRcgzkhpfb)baseDao.create(object);
	}	
	/**
	* 通过ID查找一条数据
	* @param id
	* @return
	*/
	public RsRcgzkhpfb findById(String id){
	return (RsRcgzkhpfb) baseDao.get(RsRcgzkhpfb.class, id);
	}
	/**
	 * 根据参数查询
	 * @param hql
	 * @param obj
	 * @return
	 */
	public List<RsRcgzkhpfb> findByYear(String pcounty,String year) {
			return (List<RsRcgzkhpfb>)baseDao.find("from RsRcgzkhpfb where year = ? and pcounty = ?", new String[]{year,pcounty});
	}
	
	public List<Object> findBySql (String sql){		
		return (List<Object>)baseDao.selectAllBySQL(sql, null);
	}
}   
