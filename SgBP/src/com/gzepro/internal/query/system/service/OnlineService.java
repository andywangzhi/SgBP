package com.gzepro.internal.query.system.service;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.model.Online;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public interface OnlineService {
	/**
	 * 增加一条数据
	 * @param online
	 */
	public  Online add(Online online);
	
	/**
	 * 修改一条数据
	 * @param online
	 */
	public  Online edit(Online online);
	
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
	 * 请空超过30分钟没有活动的在线用户数据
	 * @param remark
	 */
	public void deleteOverOnline();
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Online findById(Long id);
	
	/**
	 * 通过登陆用户ID查找一条数据
	 * @param loginId
	 * @return
	 */
	public Online findByLoginId(String loginId);
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging);
	
}
