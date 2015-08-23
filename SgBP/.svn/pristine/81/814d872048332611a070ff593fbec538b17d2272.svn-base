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
import com.gzepro.internal.query.system.model.AccountRole;
import com.gzepro.internal.query.system.model.Dictionary;
import com.gzepro.internal.query.system.model.Group;
import com.gzepro.internal.query.system.model.GroupAccount;
import com.gzepro.internal.query.system.model.Menu;
import com.gzepro.internal.query.system.model.Role;
import com.gzepro.internal.query.system.model.RoleMenu;
import com.gzepro.internal.query.system.service.RoleService;
import com.gzepro.internal.query.system.vo.TreeBean;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("roleService")
public class RoleServiceImpl extends SystemBaseService implements RoleService {

	/**
	 * 增加一条数据
	 * @param role
	 */
	public  Role add(Role role){
		role.setCreateDate(new Date());
		role.setCreator(this.getAccount().getId());
		role.setManager("0");//为普通角色
		return (Role)baseDao.create(role);
	}
	
	/**
	 * 修改一条数据
	 * @param role
	 */
	public  Role edit(Role role){
		role.setCreateDate(new Date());
		role.setCreator(this.getAccount().getId());
		role.setManager("0");//为普通角色
		return (Role)baseDao.saveOrUpdate(role);
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
				Role role = (Role) baseDao.get(Role.class, new Long(id));
				role.setValid(status);
				if(status.equals("2")){//删除的时候,则删除相关联的信息
					deleteRelate(id);
				}
				baseDao.saveOrUpdate(role);
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
		//删除角色用户
		String sql = " delete from mstb_sys_account_role t where t.role_id=?";
		this.springJdbcQueryManager.update(sql,new Object[]{new Long(id)});
		
		//删除角色最大权限
		sql = " delete from mstb_sys_role_menu t where t.role_id=?";
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
			Role role = findById(id);
			deleteRelate(id.toString());
    		baseDao.delete(role);
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
	public Role findById(Long id){
		Role role = (Role) baseDao.get(Role.class, id);
		if(role.getCreator() != null ){
			Account creator = (Account) baseDao.get(Account.class, role.getCreator());
			role.setCreatorName(creator.getNameCN());
		}
		return role;
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String name,String remark,String groupId,String valid){
		String hql = "from Role r where 1=1 ";
		List qo=new ArrayList();
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.name like ? ";
		}
		if(remark != null && !remark.equals("")){
			qo.add("%"+remark+"%");
			hql += " and r.remark like ? ";
		}
		if(groupId != null && !groupId.equals("")){
			qo.add(new Long(groupId));
			hql += " and r.groupId=? ";
		}
		if(valid != null && !valid.equals("")){
			qo.add(valid);
			hql += " and r.valid=? ";
		}
		
		int dist = this.getDistType();
		if(dist != Constants.DIST_TYPE_SUPER && dist != Constants.DIST_TYPE_SYS){//超级管理员和系统管理员组的用户可以看到所有的用户
			String groupIds  = this.findAccountGroupById(this.getAccount().getId());
			if(!groupIds.equals("")){
				hql += " and  r.id in (select role.id from  Role role where role.valid='1' and role.groupId in( "+groupIds+" ) ) ";
			}
		}
		
		this.baseDao.selectJsonPaging(hql, qo.toArray(), jsonPaging);
		List list = new ArrayList();
		Iterator it = jsonPaging.getList().iterator();
		while(it.hasNext()){
			Role role = (Role)it.next();
			if(role.getCreator() != null ){
				Account creator = (Account) baseDao.get(Account.class, role.getCreator());
				role.setCreatorName(creator.getNameCN());
			}
			if(role.getGroupId() != null ){
				Group group = (Group) baseDao.get(Group.class, role.getGroupId());
				role.setGroupName(group.getName());
			}
			list.add(role);
		}
		jsonPaging.setList(list);
		return jsonPaging;
	}
	
	/************ 角色授权使用 开始********************/
	/**
	 * 查找所有的菜单--用户组授权使用
	 * @return
	 */
	public List<TreeBean> findAllMenu(Long groupId){
		List<TreeBean> result = new ArrayList<TreeBean>();
		List qo=new ArrayList();
		String hql = "from Menu r  where r.valid ='1' ";//使用一次加载
		int dist = this.getDistType();
		if(dist != Constants.DIST_TYPE_SUPER && dist != Constants.DIST_TYPE_SYS){//超级管理员和系统管理员组的用户可以看到所有的用户
			String groupIds  = this.findAccountGroupById(this.getAccount().getId());
			if(!groupIds.equals("")){
				hql += " and  r.id in ( select rm.menuId  from  GroupMenu rm where groupId in( "+groupIds+" )) ";
			}
		}
                
	     if(groupId == null || groupId != 1){//系统管理员组才能看到 用户组管理 这个菜单
	             hql += " and  r.id <> 5 ";//去掉用户组管理这个菜单
	     }
                
		hql += " order by r.priority asc";//使用一次加载
		
		List<Menu> list = this.baseDao.find(hql,qo.toArray());
		for(Menu menu:list){
			TreeBean bean = new TreeBean();
			bean.setDisid(menu.getId().toString());
		    if(groupId != null && checkGroupMenu(menu.getId(),groupId)){
		    	bean.setRddisbled("1");//1表示选中
		    }else{
				bean.setRddisbled("0");//0表示不选中
			}
			bean.setDisname(menu.getNameZh());
			if(menu.getParentId() != null){
				bean.setDisparentId(menu.getParentId().toString());
				Menu parantMenu = (Menu)this.baseDao.get(Menu.class, menu.getParentId());
				bean.setDisparentName(parantMenu.getNameZh());
			}else{
				bean.setDisparentId("");
				bean.setDisparentName("");
			}
			String isLeaf = isLeaf(menu.getId());
			bean.setIsLeaf(isLeaf);
			result.add(bean);
		}
		return result;
	}
	/**
	 * 判断指定组是否具有指定的菜单
	 * @param menuId 菜单Id
	 * @param roleId 角色Id
	 * @param type m表示菜单权限 d表示数据字典权限
	 * @return
	 */
	public boolean checkGroupMenu(Long menuId,Long groupId) {
		String hql = "select distinct f from GroupMenu f where f.menuId = ? and f.groupId = ? ";
		List list = this.baseDao.find(hql,new Object[]{menuId,groupId});
		if(list != null && list.size() > 0 ){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * 查找所有的根数据
	 * @param roleId 选择的角色Id
	 * @return
	 */
	public List<TreeBean> findRootAll(Long groupId,Long roleId){
		List<TreeBean> result = new ArrayList<TreeBean>();
		String hql = "select distinct f from Menu f where f.valid ='1' and f.id in(select gm.menuId from GroupMenu gm where gm.groupId = ? )  order by f.priority asc";//使用一次加载
		List<Menu> list = this.baseDao.find(hql,new Object[]{groupId});
		for(Menu menu:list){
			TreeBean bean = new TreeBean();
			bean.setDisid(menu.getId().toString());
		    if(roleId != null && checkRoleMenu(menu.getId(),roleId,null,"")){
		    	bean.setRddisbled("1");//1表示选中
		    }else{
				bean.setRddisbled("0");//0表示不选中
			}
			bean.setDisname(menu.getNameZh());
			if(menu.getParentId() != null){
				bean.setDisparentId(menu.getParentId().toString());
				Menu parantMenu = (Menu)this.baseDao.get(Menu.class, menu.getParentId());
				bean.setDisparentName(parantMenu.getNameZh());
			}else{
				bean.setDisparentId("");
				bean.setDisparentName("");
			}
			
			String isLeaf = isLeaf(menu.getId());
			bean.setIsLeaf(isLeaf);
			if(isLeaf.equals("0")){
				bean.setDicStr(findDic(menu.getId(),roleId));
			}
			result.add(bean);
		}
		return result;
	}
	
	/**
	 * 判断指定角色是否具有指定的菜单
	 * @param menuId 菜单Id
	 * @param roleId 角色Id
	 * @param type m表示菜单权限 d表示数据字典权限
	 * @return
	 */
	public boolean checkRoleMenu(Long menuId,Long roleId,Long rightId,String type) {
		String hql = "";
		List list = null;
		if(type.equals("")){
			hql = " select distinct f from RoleMenu f where f.menuId = ? and f.roleId = ? ";
			list = this.baseDao.find(hql,new Object[]{menuId,roleId});
		}else{
			hql = " select distinct f from RoleMenu f where f.menuId = ? and f.roleId = ?  and f.rightId = ? and rightType = ? ";
			list = this.baseDao.find(hql,new Object[]{menuId,roleId,rightId,type});
		}
		if(list != null && list.size() > 0 ){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查找菜单的数据字典
	 * @param menuId
	 * @return
	 */
	public String findDic(Long menuId,Long roleId) {
		String result = "" ;
		String hql = "select distinct f from Dictionary f,MenuDictionary md where md.dictionaryId=f.id and f.valid ='1' and  md.menuId = ? ";
		List<Dictionary> list = this.baseDao.find(hql,new Object[]{menuId});
		if(list != null && list.size() > 0 ){
			for(Dictionary dic:list){
				result += "<input type=\"checkbox\" id=\"menu_dic_"+menuId+"\" name=\"menu_dic_"+menuId+"\"  ";
				result += "  value=\""+dic.getId()+"\"  ";
				if(checkRoleMenu(menuId,roleId,dic.getId(),"d")){
					result += " checked ";
				}
				result += "/>";
				result += dic.getName()+"&nbsp;&nbsp;";
			}
		}
		return result;
	}
	
	/**
	 * 判断是否为叶子节点
	 * @param id
	 * @return
	 */
	public String isLeaf(Long parentId) {
		String hql = "select distinct f from Menu f where f.valid ='1' and f.parentId = ?  order by f.priority asc";
		List list = this.baseDao.find(hql,new Object[]{parentId});
		if(list != null && list.size() > 0 ){
			return "1";
		}else{
			return "0";
		}
	}
	
	/**
	 * 保存角色的授权
	 * @param roleId 选择的角色Id
	 * @param roleMenuStr 权限字符串
	 * 		//  roleMenuStr的格式为
		    //  menuid1;dicId1:dicId2:dicId3:dicId4,
		    //  menuid2;dicId1:dicId4,
	 * @return
	 */
	public boolean saveRoleMenu(Long roleId,String roleMenuStr){
		boolean result = true;
		//操作之前先清空菜单原来的记录
		String sql = " delete from mstb_sys_role_menu t where t.role_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{roleId});
	
		if(roleMenuStr != null && !roleMenuStr.equals("")){
			if(roleMenuStr.endsWith(","))roleMenuStr=roleMenuStr.substring(0,roleMenuStr.length()-1);
			String[] arr = roleMenuStr.split(",");
			for(int i = 0; i < arr.length ; i ++){
				String menuStr = arr[i];
				String[] arrSec = menuStr.split(";");
				String menuId = arrSec[0];
				String dicIds =arrSec[1];
				
				RoleMenu rm = new RoleMenu();
				rm.setRoleId(roleId);
				rm.setMenuId(new Long(menuId));
				rm.setRightId(null);
				rm.setRightType("m");
				this.baseDao.create(rm);
				
				//保存菜单字典
				if(dicIds != null && !dicIds.equals("") && !dicIds.equals("-1")){
					String[] temp = dicIds.split(":");
					for(int k = 0; k < temp.length ; k ++){
						String dicId = temp[k];
						if(dicId != null && !dicId.equals("") && !dicId.equals("-1")){
							RoleMenu roleMenu = new RoleMenu();
							roleMenu.setRoleId(roleId);
							roleMenu.setMenuId(new Long(menuId));
							roleMenu.setRightId(new Long(dicId));
							roleMenu.setRightType("d");
							this.baseDao.create(roleMenu);
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 保存角色的用户
	 * @param roleId 选择的角色Id
	 * @param accountIds 用户Id字符串
	 * @return
	 */
	public boolean saveRoleAccount(Long roleId,String accountIds){
		boolean result = true;
        //操作之前先清空角色原来的记录
		String sql = " delete from mstb_sys_account_role t where t.role_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{roleId});
		if(accountIds != null && !accountIds.equals("")){
			if(accountIds.endsWith(","))accountIds=accountIds.substring(0,accountIds.length()-1);
			String[] arr = accountIds.split(",");
			for(int i = 0; i < arr.length ; i ++){
				String accountId = arr[i];
				AccountRole accountRole = new AccountRole();
				accountRole.setRoleId(roleId);
				accountRole.setAccountId(new Long(accountId));
				this.baseDao.create(accountRole); 
				
				String hql = "from GroupAccount r where r.accountId = ? ";
				List<GroupAccount> list = this.baseDao.find(hql,new Object[]{new Long(accountId)});
				if(list == null || list.size() == 0){////如果用户不在此角色的用户组中,则进入添加
					Role role = this.findById(roleId);
					GroupAccount groupAccount = new GroupAccount();
					groupAccount.setAccountId(new Long(accountId));
					groupAccount.setGroupId(role.getGroupId());
					groupAccount.setManager("0");//组成员
					this.baseDao.create(groupAccount);
				}
			}
		}
		return result;
	}
	/************ 角色授权使用 结束********************/

	/**
	 * 查找用户组的角色
	 * @return
	 */
	public List<Role> findUserRole(Long groupId,String name){
		String hql = "from Role r where r.valid='1' and r.groupId = ? ";
		List qo=new ArrayList();
		qo.add(groupId);
		if(name != null && !name.equals("")){
			qo.add("%"+name+"%");
			hql += " and r.name like ? ";
		}
		return this.baseDao.find(hql,qo.toArray());
	}
	
	/**
	 * 通过用户ID获得用户已有的角色
	 * @return
	 */
	public List<Role> findSelectedRole(Long accountId){
		String hql = "from Role r where r.valid='1' and r.id in (select ar.roleId from AccountRole ar where ar.accountId = ?) ";
		return this.baseDao.find(hql,new Object[]{accountId});
	}
	
}
