package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.SysLog;
import com.gzepro.internal.query.system.service.SysLogService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("sysLogService")
public class SysLogServiceImpl extends SystemBaseService implements
SysLogService {

/**
* 增加一条数据
* @param sysLog
*/
public  SysLog add(SysLog sysLog){
return (SysLog)baseDao.create(sysLog);
}

/**
* 修改一条数据
* @param sysLog
*/
public  SysLog edit(SysLog sysLog){
return (SysLog)baseDao.update(sysLog);
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
	SysLog sysLog = findById(id);
	baseDao.delete(sysLog);
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
public SysLog findById(Long id){
return (SysLog) baseDao.get(SysLog.class, id);
}

/**
* 查找所有的数据
* @param jsonPaging
* @return
*/
public JsonPaging findAll(JsonPaging jsonPaging,String name,String type){
String hql = "from SysLog r where 1 = 1 ";
List qo=new ArrayList();
if(name != null && !name.equals("")){
	qo.add("%"+name+"%");
	hql += " and r.accountName like ? ";
}
if(type != null && !type.equals("")){
	qo.add("%"+type+"%");
	hql += " and r.logType like ? ";
}
this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
return jsonPaging;
}

}
