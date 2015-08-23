package com.gzepro.internal.query.system.service;


import java.util.List;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Group;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface GroupService {
	/**
	 * 增加一条数据
	 * @param group
	 */
	public  Group add(Group group);
	
	/**
	 * 修改一条数据
	 * @param group
	 */
	public  Group edit(Group group);
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status);
	
	/**
	 * 保存用户组的管理员和菜单权限
	 * @param groupId
	 * @param manegerIds
	 * @param menuIds
	 * @return
	 */
	public  void saveRight(Long groupId,String manegerIds,String menuIds);
	
	/**
	 * 保存组成员
	 * @param groupId
	 * @param accountIds
	 * @return
	 */
	public  void saveAccount(Long groupId,String accountIds);
	
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
	public Group findById(Long id);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String name,String remark,String valid);
	
	/**
	 * 查找登陆用户的组
	 * @return
	 */
	public List<Group> findLoginUserGroup(Long accountId);
	
	/**
	 * 查找用户组
	 * @return
	 */
	public List<Group> findUserGroup(String name);
	
	/**
	 * 敏感信息中待选用户角色
	 * @param 已选择角色
	 * @return
	 */
	public String  findGroupForJson(String selectedIds);

}
