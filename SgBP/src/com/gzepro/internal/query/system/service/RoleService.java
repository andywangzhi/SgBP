package com.gzepro.internal.query.system.service;

import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Role;
import com.gzepro.internal.query.system.vo.TreeBean;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface RoleService {
	/**
	 * 增加一条数据
	 * @param role
	 */
	public  Role add(Role role);
	
	/**
	 * 修改一条数据
	 * @param role
	 */
	public  Role edit(Role role);
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status);
	
	/**
	 * 通过ID删除一条记录
	 * @param id
	 * @return
	 */
	public boolean deleteById(Long id);
	
	/**
	 * 删除多条数据
	 * @param ids
	 * @return
	 */
	public  boolean delete(String ids);
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Role findById(Long id);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String name,String remark,String groupId,String valid);
	
	/**
	 * 查找所有的菜单--用户组授权使用
	 * @param groupId 选择的用户组Id
	 * @return
	 */
	public List<TreeBean> findAllMenu(Long groupId);
	
	/**
	 * 角色授权使用 查找所有的根数据
	 * @param roleId 选择的角色Id
	 * @return
	 */
	public List<TreeBean> findRootAll(Long groupId,Long roleId);
	
	/**
	 * 保存角色的授权
	 * @param roleId 选择的角色Id
	 * @param roleMenuStr 权限字符串
	 * 		//  roleMenuStr的格式为
		    //  menuid1;dicId1:dicId2:dicId3:dicId4,
		    //  menuid2;dicId1:dicId4,
	 * @return
	 */
	public boolean saveRoleMenu(Long roleId,String roleMenuStr);
	
	/**
	 * 保存角色的用户
	 * @param roleId 选择的角色Id
	 * @param accountIds 用户Id字符串
	 * @return
	 */
	public boolean saveRoleAccount(Long roleId,String accountIds);
	
	
	/**
	 * 查找用户组的角色
	 * @return
	 */
	public List<Role> findUserRole(Long groupId,String name);
	
	/**
	 * 通过用户ID获得用户已有的角色
	 * @return
	 */
	public List<Role> findSelectedRole(Long accountId);
	
}