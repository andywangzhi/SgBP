package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.ConfType;
import com.gzepro.internal.query.system.service.ConfTypeService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("confTypeService")
public class ConfTypeServiceImpl extends SystemBaseService implements
		ConfTypeService {

	/**
	 * 增加一条数据
	 * @param confType
	 */
	public  ConfType add(ConfType confType){
		return (ConfType)baseDao.create(confType);
	}
	
	/**
	 * 修改一条数据
	 * @param confType
	 */
	public  ConfType edit(ConfType confType){
		return (ConfType)baseDao.update(confType);
	}
	
	/**
	 * 是否存在唯一的Code
	 */
	public ConfType codeExist(String code){
		String hql = "from ConfType d where d.code = ? ";
		List<ConfType> confType = baseDao.find(hql, new String[] { code });
		if (confType != null && confType.size() > 0) {
			return confType.get(0);
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
				ConfType confType = (ConfType) baseDao.get(ConfType.class, new Long(id));
				confType.setValid(status);
				baseDao.saveOrUpdate(confType);
				if(status.equals("0") || status.equals("2")){//如果是停用或者删除类型,要停用或者删除类型下的所有数据
					String sql = "update mstb_sys_conf set is_valid='"+status+"' where type_id="+confType.getId();
					this.springJdbcQueryManager.execute(sql);
				}
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
			ConfType confType = findById(id);
			String sql = "delete from  mstb_sys_conf where type_id=1"+confType.getId();
			this.springJdbcQueryManager.execute(sql);//永久删除类型下的所有基础数据
			baseDao.delete(confType);
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
	public ConfType findById(Long id){
		return (ConfType) baseDao.get(ConfType.class, id);
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String valid){
		String hql = "from ConfType r where 1 = 1  ";
		List qo=new ArrayList();
		if(code != null && !code.equals("")){
			qo.add("%"+code+"%");
			hql += " and r.code like ? ";
		}
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.name like ? ";
		}
		if(valid != null && !valid.equals("")){
			qo.add(valid);
			hql += " and r.valid=? ";
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			ConfType confType = (ConfType)it.next();
			list.add(confType);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}

	/**
	 * 查找所有的数据
	 * @return
	 */
	public List<ConfType> findAll(){
		String hql = "from ConfType m where m.valid ='1' ";
		return this.baseDao.find(hql);
	}
	
}
