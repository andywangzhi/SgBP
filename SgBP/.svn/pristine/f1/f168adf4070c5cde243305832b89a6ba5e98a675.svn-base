package com.gzepro.internal.query.system.service;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Menu;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface MenuService {
	/**
	 * 增加一条数据
	 * @param menu
	 */
	public  Menu add(Menu menu);
	
	/**
	 * 修改一条数据
	 * @param menu
	 */
	public  Menu edit(Menu menu);
	
	/**
	 * 修改数据的状态
	 * @param ids
	 * @param status
	 */
	public  boolean saveStatus(String ids,String status);
	
	/**
	 * 保存菜单的敏感字段
	 * @param menuId
	 * @param operIds
	 * @return
	 */
	public  void saveDic(Long menuId,String dicIds);
	
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
	public Menu findById(Long id);
	
	/**
	 * 检测菜单Code 存在
	 */
	public Menu menuCodeExist(String code);
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging,String code,String name,String type,String valid);
	
	/**
	 * 菜单操作 获得所有菜单的json格式串
	 * @return
	 */
	public String findMenuJsonStr();
	
	/**
	 * 获得所有菜单的json格式串 不包含根结点
	 * @return
	 */
	public String findMenuJsonStrSec(String selectedIds);
	
}
