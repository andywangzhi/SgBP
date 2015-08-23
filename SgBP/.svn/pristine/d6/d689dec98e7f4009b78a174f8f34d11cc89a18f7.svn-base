package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Dept;
import com.gzepro.internal.query.system.model.Group;
import com.gzepro.internal.query.system.model.Role;
import com.gzepro.internal.query.system.service.AccountService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("accountService")
public class AccountServiceImpl extends SystemBaseService implements
AccountService {
/**
* 增加一条数据
* @param account
*/
public  Account add(Account account){
account = (Account)baseDao.create(account);
return account;
}

/**
* 修改一条数据
* @param account
*/
public  Account edit(Account account){
return (Account)baseDao.update(account);
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
	Account account = findById(id);
	deleteRelate(id.toString());
	baseDao.delete(account);
	return true;
}
}

/**
* 删除关联信息
* @param id
* @return
*/
private void deleteRelate(String id){
String sql = " delete from mstb_sys_role_account t where  t.account_id=? ";
this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
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
public Account findById(Long id){
Account account = (Account) baseDao.get(Account.class, id);
return account;
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
		Account account = (Account) baseDao.get(Account.class, new Long(id));
		account.setValid(status);
		baseDao.saveOrUpdate(account);
	}
}
return true;
}

/**
* 修改用户的语言
* @param ids
* @param status
*/
public  boolean saveLang(String ids,String lang){
if(ids.endsWith(","))ids=ids.substring(0,ids.length()-1);
if(ids != null && !ids.equals("")){
	String sql = " update mstb_sys_account t set t.lang=? where t.account_id in( "+ids+" ) ";
	this.springJdbcQueryManager.update(sql,new Object[]{lang});
	
}
return true;
}

/**
* 查找所有的数据
* @param jsonPaging
* @return
*/
public JsonPaging findAll(JsonPaging jsonPaging,String name,String realName,String groupId,String valid){
String hql = "from Account r where 1=1 ";
List qo=new ArrayList();
if(name != null && !name.equals("")){
	qo.add("%"+name+"%");
	hql += " and r.loginCode like ? ";
}
if(realName != null && !realName.equals("")){
	qo.add("%"+realName+"%");
	qo.add("%"+realName+"%");
	hql += " and (r.nameCN like ? or r.nameEN like ?) ";
}
if(groupId != null && !groupId.equals("")){
	qo.add(new Long(groupId));
	hql += " and  r.id in (select gm.accountId from GroupAccount gm where gm.groupId in( ? )) ";
}
int dist = this.getDistType();
if(dist != Constants.DIST_TYPE_SUPER && dist != Constants.DIST_TYPE_SYS){//超级管理员和系统管理员组的用户可以看到所有的用户
	String groupIds  = this.findAccountGroupById(this.getAccount().getId());
	if(!groupIds.equals("")){
		hql += " and  r.id in (select gm.accountId from GroupAccount gm where gm.groupId in( "+groupIds+" )) ";
	}
}
if(valid != null && !valid.equals("")){
	qo.add(valid);
	hql += " and r.valid=? ";
}
this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
List list = new ArrayList();
Iterator it = jsonPaging.getList().iterator();
while(it.hasNext()){
	Account account = (Account)it.next();
	
	hql = "select r from Group r,GroupAccount ga where r.valid='1' and r.id=ga.groupId and ga.accountId=? ";
	List<Group> lsTmp = this.baseDao.find(hql,new Object[]{account.getId()});
	if(lsTmp != null && lsTmp.size() >0){
		Group groupTmp = lsTmp.get(0);
		if(groupTmp != null){
			account.setGroupNames(groupTmp.getName());
		}
	}
	
	String roleNames = "";
	hql = "select r from AccountRole f,Role r where f.roleId=r.id  and f.accountId=? ";
	List<Role> ls =  baseDao.find(hql,new Object[]{account.getId()});
	if(ls != null && ls.size()>0){
		for(Role role:ls){
			roleNames +=role.getName()+",";
		}
	}
	if(roleNames.endsWith(","))roleNames=roleNames.substring(0,roleNames.length()-1);
	account.setRoleNames(roleNames);
	
	String deptNames = "";
	hql = "select r from AccountDept f,Dept r where f.deptId=r.id  and f.accountId=? ";
	List<Dept> lsDept =  baseDao.find(hql,new Object[]{account.getId()});
	if(lsDept != null && lsDept.size()>0){
		for(Dept dept:lsDept){
			deptNames +=dept.getNameCN()+",";
		}
	}
	if(deptNames.endsWith(","))deptNames=deptNames.substring(0,deptNames.length()-1);
	account.setDeptNames(deptNames);
	
	list.add(account);
}
jsonPaging.setList(list);
return jsonPaging;
}

/**
* 查找指定部门所有的用户数据
* @param deptCode
* @param roleId 角色ID 在角色中加载组成员时，要去掉角色下已有的成员
* @return
*/
public List<Account> findAllByDeptCode(String deptId,Long roleId){
List qo=new ArrayList();
qo.add(new Long(deptId));
String hql = "from Account u where u.valid ='1' and  u.id not in (select ga.accountId from GroupAccount ga) and  u.id in (select ad.accountId from AccountDept ad where ad.deptId = ?) ";
if(roleId != null){
	String roleAccountIds = "";
	List<Account> list = findRoleAccount(roleId);
	for(Account tmp:list){
		roleAccountIds += tmp.getId()+",";
	}
	if(roleAccountIds.endsWith(","))roleAccountIds=roleAccountIds.substring(0,roleAccountIds.length()-1);
	if(!roleAccountIds.equals("")){
		hql += " and u.id not in ( "+roleAccountIds+" )  ";
	}
}
return this.baseDao.find(hql,qo.toArray());
}

/**
* 查找所有的组成员
* @param groupId
* @param roleId 角色ID 在角色中加载组成员时，要去掉角色下已有的成员
* @param manager 是否组管理员
* @return
*/
public List<Account> findGroupAccount(Long groupId,Long roleId,String manager){
List qo=new ArrayList();
qo.add(groupId);
String hql = "from Account u where u.valid ='1' and  u.id in (select gm.accountId from GroupAccount gm where gm.groupId = ? ";
if(manager != null && !manager.equals("")){
	qo.add(manager);
	hql += " and gm.manager=?  ";
}
if(roleId != null){
	String roleAccountIds = "";
	List<Account> list = findRoleAccount(roleId);
	for(Account tmp:list){
		roleAccountIds += tmp.getId()+",";
	}
	if(roleAccountIds.endsWith(","))roleAccountIds=roleAccountIds.substring(0,roleAccountIds.length()-1);
	if(!roleAccountIds.equals("")){
		hql += " and u.id not in ( "+roleAccountIds+" )  ";
	}
}
hql += " ) ";
hql += " order by u.nameCN asc ";
return this.baseDao.find(hql, qo.toArray());
}

/**
* 查找角色的所有用户
* @param roleId
* @return
*/
public List<Account> findRoleAccount(Long roleId){
String hql = "from Account u where u.valid ='1' and  u.id in (select ar.accountId from AccountRole ar where ar.roleId = ?) order by u.nameCN asc  ";
return this.baseDao.find(hql, new Object[] { roleId });
}

/**
* 查找指定部门所有的用户数据
* @param deptCode
* @return
*/
public List<Account> findAllByDeptCode(String deptId){
String hql = "from Account u where u.valid ='1' and  u.id not in (select ga.accountId from GroupAccount ga) and  u.id in (select ad.accountId from AccountDept ad where ad.deptId = ?) ";
return this.baseDao.find(hql, new Object[] { new Long(deptId) });
}

/**
* 通过名称查找用户
* @param name
* @return
*/
public Account findByName(String name){
String hql = "from Account u where u.valid ='1' and  (u.loginCode = ? or u.loginCode = ?)";
List<Account> users = baseDao.find(hql, new String[] {name.toLowerCase(),name.toUpperCase()});
if (users != null && users.size() > 0) {
	return users.get(0);
}
return null;
}


/**
* 通过名称查找用户,超级管理员排除
* @param name
* @param code
* @return
*/
public List<Account> findByNameOrCode(String name,String code){
List qo=new ArrayList();
String hql = "from Account u where u.valid ='1' and u.id <> 1 and u.id not in (select ga.accountId from GroupAccount ga) ";
if(name != null && !name.equals("")){
	qo.add("%"+name+"%");
	hql += " and  u.nameCN like ?  ";
}
if(code != null && !code.equals("")){
	qo.add("%"+code.toUpperCase()+"%");
	qo.add("%"+code.toLowerCase()+"%");
	hql += " and  (u.loginCode like ? or u.loginCode like ? ) ";
}
hql += " order by u.nameCN asc ";
return this.baseDao.find(hql, qo.toArray());
}


/**
* 通过名称查找用户,部门处使用,一个用户只能属于一个部门,超级管理员不属于任何部门
* @param name
* @param code
* @return
*/
public List<Account> findByNameOrCodeForDept(String name,String code){
List qo=new ArrayList();
String hql = "from Account u where u.valid ='1' and u.id <> 1 and u.id not in (select ad.accountId from AccountDept ad) ";
if(name != null && !name.equals("")){
	qo.add("%"+name+"%");
	hql += " and  u.nameCN like ?  ";
}
if(code != null && !code.equals("")){
	qo.add("%"+code.toUpperCase()+"%");
	qo.add("%"+code.toLowerCase()+"%");
	hql += " and  (u.loginCode like ? or u.loginCode like ? ) ";
}
hql += " order by u.nameCN asc ";
return this.baseDao.find(hql, qo.toArray());
}

/**
* 通过用户ID获得用户所在的部门
* @param name
* @return
*/
public String findDeptByAccountId(Long accountId){
String hql = "from Dept d where d.id in(select u.deptId from AccountDept u where u.accountId = ? ) ";
List<Dept> depts = baseDao.find(hql, new Long[] { accountId });
if (depts != null && depts.size() > 0) {
	String deptNames = "";
	for(Dept dept:depts){
		deptNames += dept.getNameCN()+",";
	}
	if(deptNames.endsWith(","))deptNames=deptNames.substring(0,deptNames.length()-1);
	return deptNames;
}
return "";
}

}
