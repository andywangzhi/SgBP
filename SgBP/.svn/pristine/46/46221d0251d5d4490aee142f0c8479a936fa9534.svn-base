package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.ChangeDetail;
import com.gzepro.internal.query.system.model.SysLog;
import com.gzepro.internal.query.system.service.ChangeLogService;
import com.gzepro.internal.query.system.service.SysLogService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("changeLogService")
public class ChangeLogServiceImpl extends SystemBaseService implements
ChangeLogService {

/**
* 增加一条数据
* @param sysLog
*/
public  ChangeDetail add(ChangeDetail changeDetail){
return (ChangeDetail)baseDao.create(changeDetail);
}

/**
* 修改一条数据
* @param sysLog
*/
public  ChangeDetail edit(ChangeDetail changeDetail){
return (ChangeDetail)baseDao.update(changeDetail);
}

/**
* 通过ID删除一条记录
* @param id
* @return
*/
public boolean deleteById(String id){
if (id == null) {
	return false;
}else{
	ChangeDetail changeDetail = findById(id);
	baseDao.delete(changeDetail);
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
		deleteById(id);
	}
}
return true;
}

/**
* 通过ID查找一条数据
* @param id
* @return
*/
public ChangeDetail findById(String id){
return (ChangeDetail) baseDao.get(ChangeDetail.class, id);
}

/**
* 查找所有的数据
* @param jsonPaging
* @return
*/
public JsonPaging findAll(JsonPaging jsonPaging,String time,String type){
String hql = "from ChangeDetail r where 1 = 1 ";
List qo=new ArrayList();
if(time != null && !time.equals("")){
	qo.add(time);
	hql += " and r.changedate like ? ";
}
if(type != null && !type.equals("")){
	qo.add(type);
	hql += " and r.dchangtype like ? ";
}
this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
return jsonPaging;
}

}
