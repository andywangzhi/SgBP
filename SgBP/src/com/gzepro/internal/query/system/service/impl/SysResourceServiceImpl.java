package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.SysResource;
import com.gzepro.internal.query.system.service.SysResourceService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("sysResourceService")
public class SysResourceServiceImpl extends SystemBaseService implements
		SysResourceService {

	/**
	 * 增加一条数据
	 * @param sysResource
	 */
	public  SysResource add(SysResource sysResource){
		sysResource.setCreateDate(new Date());
		sysResource.setCreator(this.getAccount().getId());
		return (SysResource)baseDao.create(sysResource);
	}
	
	/**
	 * 修改一条数据
	 * @param sysResource
	 */
	public  SysResource edit(SysResource sysResource){
		sysResource.setCreateDate(new Date());
		sysResource.setCreator(this.getAccount().getId());
		return (SysResource)baseDao.update(sysResource);
	}
	
	/**
	 * 检测资源Code
	 */
	public SysResource  resourceCodeExist(String code){
		String hql = "from SysResource s where s.key = ? and s.valid<>'2'  ";
		List<SysResource> sysresource = baseDao.find(hql, new String[] { code });
		if (sysresource != null && sysresource.size() > 0) {
			return sysresource.get(0);
		}
		return null;
	}
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status){
		if (ids != null && !ids.equals("")) {
			if(ids.endsWith(":"))ids = ids.substring(0,ids.length()-1);
			String[] arr = ids.split(":");
			for (String id : arr) {
				SysResource sysResource = (SysResource) baseDao.get(SysResource.class, new Long(id));
				sysResource.setValid(status);
				baseDao.saveOrUpdate(sysResource);
			}
		}
		return true;
	}
	
	/**
	 * 通过ID删除一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(Long id){
		if (id == null) {
			return false;
		}else{
			SysResource sysResource = findById(id);
			baseDao.delete(sysResource);
			return true;
		}
	}
	
	/**
	 * 删除多条数据
	 * @param account
	 */
	public  boolean delete(String ids){
		if (ids != null && !ids.equals("")) {
			if(ids.endsWith(":"))ids = ids.substring(0,ids.length()-1);
			String[] arr = ids.split(":");
			for (String id : arr) {
				deleteById(new Long(id));
			}
		}
		return true;
	}
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public SysResource findById(Long id){
		return (SysResource) baseDao.get(SysResource.class, id);
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String dec,String type,String valid){
		List qo=new ArrayList();
		String hql = "from SysResource r  where 1=1 ";
		if(code != null && !code.equals("")){
			qo.add("%"+code+"%");
			hql += " and r.key like ? ";
		}
		if(dec != null && !dec.equals("")){
			qo.add("%"+dec+"%");
			qo.add("%"+dec+"%");
			qo.add("%"+dec+"%");
			hql += " and (r.nameZh like ? or r.nameEn like ?  or r.nameTw like ? ) ";
		}
		if(type != null && !type.equals("")){
			qo.add(type);
			hql += " and r.useType=? ";
		}
		if(valid != null && !valid.equals("")){
			qo.add(valid);
			hql += " and r.valid=? ";
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			SysResource sysResource = (SysResource)it.next();
			if(sysResource.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, sysResource.getCreator());
				sysResource.setCreatorName(creator.getNameCN());
			}
			list.add(sysResource);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<SysResource> findAll(){
		String hql = "from SysResource r where r.valid='1' ";
		return this.baseDao.find(hql);
	}

}
