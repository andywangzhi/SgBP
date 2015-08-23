package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.Group;
import com.gzepro.internal.query.system.model.GroupAccount;
import com.gzepro.internal.query.system.model.GroupMenu;
import com.gzepro.internal.query.system.model.Role;
import com.gzepro.internal.query.system.service.GroupService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("groupService")
public class GroupServiceImpl extends SystemBaseService implements
		GroupService {

	/**
	 * 增加一条数据
	 * @param group
	 */
	public  Group add(Group group){
		group.setGroupLevel(1);
		group.setCreateDate(new Date());
		group.setCreator(this.getAccount().getId());
		return (Group)baseDao.create(group);
	}
	
	/**
	 * 修改一条数据
	 * @param group
	 */
	public  Group edit(Group group){
		if(group.getId() == 1){
			group.setGroupLevel(0);
		}else{
			group.setGroupLevel(1);
		}
		group.setCreateDate(new Date());
		group.setCreator(this.getAccount().getId());
		return (Group)baseDao.update(group);
	}
	
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status){
		if(status.equals("2")){
			if(!checkGroupRole(ids)){
				return false;
			}
		}
		if (ids != null && !ids.equals("")) {
			if(ids.endsWith(":"))ids = ids.substring(0,ids.length()-1);
			String[] arr = ids.split(":");
			for (String id : arr) {
				Group group = (Group) baseDao.get(Group.class, new Long(id));
				group.setValid(status);
				if(status.equals("2")){//删除的时候,则删除相关联的信息
					deleteRelate(id);
				}
				baseDao.saveOrUpdate(group);
			}
		}
		return true;
	}
	
	/**
	 * 删除关联信息
	 * @param id
	 * @return
	 */
	private boolean checkGroupRole(String ids){
		String str = "";
		if (ids != null && !ids.equals("")) {
			if(ids.endsWith(":"))ids = ids.substring(0,ids.length()-1);
			String[] arr = ids.split(":");
			for (String id : arr) {
				str +=id+",";
			}
			if(str.endsWith(","))str = str.substring(0,str.length()-1);
			if(!str.equals("")){
				String hql = "from Role r where r.valid in('1','0') and r.groupId in( "+str+" ) ";
				List ls =  this.baseDao.find(hql);
				if (ls != null && ls.size() > 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 删除关联信息
	 * @param id
	 * @return
	 */
	private void deleteRelate(String id){
		//删除成员
		String sql = " delete from mstb_sys_account_role t where t.role_id in(select role_id from mstb_sys_role where group_id=? ) ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		//删除角色菜单
		sql = " delete from mstb_sys_role_menu t where t.role_id in(select role_id from mstb_sys_role where group_id=? ) ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		//删除角色
		sql = " delete from mstb_sys_role t where  t.group_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		//删除组成员
		sql = " delete from mstb_sys_group_account t where  t.group_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		//删除组菜单
		sql = " delete from mstb_sys_group_menu t where  t.group_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
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
			Group group = findById(id);
			deleteRelate(id.toString());
    		baseDao.delete(group);
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
	 * 保存用户组的管理员和菜单权限
	 * @param groupId
	 * @param manegerIds
	 * @param menuIds
	 * @return
	 */
	public  void saveRight(Long groupId,String manegerIds,String menuIds){		
		//删除组管理员
		String sql = " delete from mstb_sys_group_account t where t.is_manager='1' and t.group_id = ? ";
		this.springJdbcQueryManager.update(sql,new Object[]{groupId});
		
		if(!manegerIds.equals("")){
			//要成为组管理员的人员需要先清空原来的角色以及菜单等信息
			//sql = " delete from mstb_sys_role_menu t where t.role_id in(select role_id from mstb_sys_account_role where account_id in( "+manegerIds+" )) ";
			//this.springJdbcQueryManager.execute(sql);
			
			sql = " delete from mstb_sys_account_role t where  t.account_id in("+manegerIds+" ) ";
			this.springJdbcQueryManager.execute(sql);
			
			sql = " delete from mstb_sys_group_account t where  t.account_id in(" + manegerIds+") ";
			this.springJdbcQueryManager.execute(sql);
		}
		
		if(!manegerIds.equals("")){
			String[] arr = manegerIds.split(",");
			for(int i = 0; i < arr.length ; i ++){
				Long accountId = Long.parseLong(arr[i]);
				if(accountId != -1){
	    			GroupAccount groupAccount = new GroupAccount();
	    			groupAccount.setAccountId(accountId);
	    			groupAccount.setGroupId(groupId);
	    			groupAccount.setManager("1");//组管理员
	    			this.baseDao.create(groupAccount);
				}
			}
		}

		
		//操作之前先清空原来有组菜单
		sql = " delete from mstb_sys_group_menu t where t.group_id = ?";
		this.springJdbcQueryManager.update(sql,new Object[]{groupId});
		
        if(menuIds != null && !menuIds.equals("")){
        	if(menuIds.endsWith(","))menuIds=menuIds.substring(0,menuIds.length()-1);
        	if(menuIds != null && !menuIds.equals("")){

        		String[] arr = menuIds.split(",");
        		for(int i = 0; i < arr.length ; i ++){
        			Long menuId = Long.parseLong(arr[i]);
        			GroupMenu groupMenu = new GroupMenu();
        			groupMenu.setMenuId(menuId);
        			groupMenu.setGroupId(groupId);
        			this.baseDao.create(groupMenu);
        		}
        	}
        }
	}
	
	/**
	 * 保存组成员
	 * @param groupId
	 * @param accountIds
	 * @return
	 */
	public  void saveAccount(Long groupId,String accountIds){
		String newAccountIds = "";
		
		//对于是从已有组成员中添加为组管理员的情况,需要做以下排除原有组管理员的处理
		String tmpAccountIds = ","+accountIds+",";
        if(accountIds != null && !accountIds.equals("")){
        	String oldManagerIds = findGroupAccount(groupId,"1");
        	String[] arr = tmpAccountIds.split(",");
        	for(String id :arr){
        		if(id != null && !id.equals("") && !id.equals("-1") &&  !oldManagerIds.contains(","+id+",")){
        			newAccountIds+=id+",";
        		}
        	}
        	if(newAccountIds.endsWith(","))newAccountIds = newAccountIds.substring(0,newAccountIds.length()-1);
        }
        if(!newAccountIds.equals(""))newAccountIds = ","+newAccountIds+",";
        else newAccountIds = ","+accountIds+",";


		String oldAccountIds = findGroupAccount(groupId,"0");
		String deleteIds = "";//查找到要删除的记录
        if(oldAccountIds != null && !oldAccountIds.equals("")){
        	String[] arr = oldAccountIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") && !newAccountIds.contains(","+id+",")){
        			deleteIds+=id+",";
        		}
        	}
        }
        if(deleteIds.endsWith(","))deleteIds = deleteIds.substring(0,deleteIds.length()-1);
        if(!deleteIds.equals("")){
			//要成为组管理员的人员需要先清空原来的角色以及菜单等信息
        	String sql = "";
			//String sql = " delete from mstb_sys_role_menu t where t.role_id in(select role_id from mstb_sys_account_role where account_id in("+deleteIds+")) ";
			//this.springJdbcQueryManager.execute(sql);
			sql = " delete from mstb_sys_account_role t where  t.account_id in("+deleteIds+") ";
			this.springJdbcQueryManager.execute(sql);
			sql = " delete from mstb_sys_group_account t where  t.account_id in("+deleteIds+") ";
			this.springJdbcQueryManager.execute(sql);
        }
        
        if(newAccountIds != null && !newAccountIds.equals("")){
        	oldAccountIds = ","+oldAccountIds+",";
        	String[] arr = newAccountIds.split(",");
        	for(String id :arr){
        		if(id != null &&  !id.equals("") &&  !id.equals("-1") && !oldAccountIds.contains(","+id+",")){ //剩下的就是新增的记录
        			GroupAccount groupAccount = new GroupAccount();
					groupAccount.setAccountId(new Long(id));
					groupAccount.setGroupId(groupId);
					groupAccount.setManager("0");//组成员
					this.baseDao.create(groupAccount);
        		}
        	}
        }
        
	}
	

	/**
	 * 获得组的成员
	 * @param groupId 用户Id
	 * @return 以","分隔的成员
	 */
	public String findGroupAccount(Long groupId,String isManager){
		String result = "";
		List qo=new ArrayList();
		qo.add(new Long(groupId));
		String hql = " from GroupAccount where groupId = ? ";
		if(!isManager.equals("")){
			qo.add(isManager);
			hql += " and manager=? ";
		}
		List<GroupAccount> ls = baseDao.find(hql, qo.toArray());
		if (ls != null && ls.size() > 0) {
			for(GroupAccount ga:ls){
				result += ga.getAccountId()+",";
			}
			if(result.endsWith(","))result = result.substring(0,result.length()-1);
		}
		return result;
	}
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Group findById(Long id){
		Group group = (Group) baseDao.get(Group.class, id);
		if(group.getCreator() != null ){
			Account creator = (Account) baseDao.get(Account.class, group.getCreator());
			group.setCreatorName(creator.getNameCN());
		}
		return group;
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String name ,String remark,String valid){
		String hql = "from Group r where 1=1 ";
		List qo=new ArrayList();
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.name like ? ";
		}
		if(remark != null && !remark.equals("")){
			qo.add("%"+remark+"%");
			hql += " and r.remark like ? ";
		}
		if(valid != null && !valid.equals("")){
			qo.add(valid);
			hql += " and r.valid=? ";
		}
		int dist = this.getDistType();
		if(dist != Constants.DIST_TYPE_SUPER && dist != Constants.DIST_TYPE_SYS){//超级管理员和系统管理员组的用户可以看到所有的用户
			String groupIds  = this.findAccountGroupById(this.getAccount().getId());
			if(!groupIds.equals("")){
				hql += " and  r.id in ( "+groupIds+" ) ";
			}
		}
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			Group group = (Group)it.next();
			if(group.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, group.getCreator());
				group.setCreatorName(creator.getNameCN());
			}
			String groupManager = "";
			hql = "select f from Account f,GroupAccount m where m.manager='1' and f.id = m.accountId and m.groupId = ? ";
			List<Account> ls =  baseDao.find(hql, new Object[] { group.getId() });
			if(ls != null && ls.size()>0){
				for(Account account:ls){
					groupManager +=account.getNameCN()+",";
				}
			}
			if(groupManager.endsWith(","))groupManager=groupManager.substring(0,groupManager.length()-1);
			group.setGroupManager(groupManager);
			list.add(group);
		}
		jsonPaging.setList(list);
		
		return jsonPaging;
	}
	
	/**
	 * 查找登陆用户的组
	 * @return
	 */
	public List<Group> findLoginUserGroup(Long accountId){
		String hql = "from Group r where r.valid='1' ";
		int dist = this.getDistType();
		List qo=new ArrayList();
		if(dist != Constants.DIST_TYPE_SUPER && dist != Constants.DIST_TYPE_SYS){//超级管理员和系统管理员组的用户可以看到所有的用户
			String groupIds  = this.findAccountGroupById(accountId);
			if(!groupIds.equals("")){
				hql += " and  r.id in ( "+groupIds+" ) ";
			}
		}
		return this.baseDao.find(hql,qo.toArray());
	}

	/**
	 * 查找用户组 用户管理员搜索使用
	 * @return
	 */
	public List<Group> findUserGroup(String name){
		String hql = "from Group r where r.valid='1' ";
		List qo=new ArrayList();
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.name like ? ";
		}
		int dist = this.getDistType();
		if(dist != Constants.DIST_TYPE_SUPER && dist != Constants.DIST_TYPE_SYS){//超级管理员和系统管理员组的用户可以看到所有的用户
			String groupIds  = this.findAccountGroupById(this.getAccount().getId());
			if(!groupIds.equals("")){
				hql += " and  r.id in ("+groupIds+") ";
			}
		}
		return this.baseDao.find(hql,qo.toArray());
	}
	
	/**
	 * 敏感信息中待选用户角色
	 * @param 已选择角色
	 * @return
	 */
	public String  findGroupForJson(String selectedIds){
		String result = "[";
		String hql = "from Group r where r.valid='1' ";
		List<Group> list = this.baseDao.find(hql);
		if (list != null && list.size() > 0) {
			for (Group group:list) {
				result += "{\"id\":"+group.getId()+",\"text\":\""+group.getName()+"\" ";
				hql = "from Role r where r.valid='1' and r.groupId=? ";
				List<Role> ls = this.baseDao.find(hql,new Object[]{group.getId()});
				String roleStr = "";
				if (ls != null && ls.size() > 0) {
					roleStr += ",\"children\":[";
					for (Role role:ls) {
						roleStr += "{\"id\":"+role.getId()+",\"text\":\""+role.getName()+"\" ";
						roleStr += "},";
					}
					if(roleStr.endsWith(","))roleStr=roleStr.substring(0,roleStr.length()-1);
					roleStr += "]";
				}
				result += roleStr+"},";
			}
			if(result.endsWith(","))result=result.substring(0,result.length()-1);
		}
		result += "]";
		return result;
	}

}
