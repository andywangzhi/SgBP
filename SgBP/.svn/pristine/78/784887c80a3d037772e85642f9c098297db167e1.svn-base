package com.gzepro.internal.query.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.json.JsonPaging;
import com.gzepro.internal.query.system.base.SystemBaseService;
import com.gzepro.internal.query.system.model.Online;
import com.gzepro.internal.query.system.service.OnlineService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Component("onlineService")
public class OnlineServiceImpl extends SystemBaseService implements
		OnlineService {

	/**
	 * 增加一条数据 
	 * @param online
	 */
	public  Online add(Online online){
		//因Db存放时差,所以使用这种方式添加记录
		String sql = "insert into mstb_sys_online(online_id,login_id,account_name,oper_ip,login_date,last_visit_date,account_level)" +
				     "values(" +
				     "SEQ_SYS_ONLINE.NEXTVAL,?,?,?,sysdate,sysdate,?)";
		this.springJdbcQueryManager.update(sql,new Object[]{online.getLoginId(),online.getAccountName(),online.getOperIp(),online.getAccountLevel()});
		return null;
	}
	
	/**
	 * 修改一条数据
	 * @param online
	 */
	public  Online edit(Online online){
		//因Db2存放时差,所以使用这种方式修改记录
		String sql = "update mstb_sys_online set last_visit_date = sysdate,oper_ip = ?  where online_id=? ";
		this.springJdbcQueryManager.update(sql,new Object[]{online.getOperIp(),online.getId()});
		return null;
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
			Online online = findById(id);
			baseDao.delete(online);
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
	 * 请空超过30分钟没有活动的在线用户数据
	 * @param remark
	 */
	public void deleteOverOnline(){
		String sql = "delete from mstb_sys_online where round((sysdate-last_visit_date)*24*60)>=30";//oracle
		this.getSpringJdbcQueryManager().execute(sql);
	}
	
	/**
	 * 通过ID查找一条数据
	 * @param id
	 * @return
	 */
	public Online findById(Long id){
		return (Online) baseDao.get(Online.class, id);
	}
	
	/**
	 * 通过登陆用户ID查找一条数据
	 * @param loginId
	 * @return
	 */
	public Online findByLoginId(String loginId){
		String hql = "from Online u where u.loginId = ?";
		List<Online> onlines = baseDao.find(hql, new String[] { loginId });
		if (onlines != null && onlines.size() > 0) {
			return onlines.get(0);
		}
		return null;
	}
	
	/**
	 * 查找所有的数据
	 * @param jsonPaging
	 * @return
	 */
	public JsonPaging findAll(JsonPaging jsonPaging){
		String hql = "from Online r";
		List params = new ArrayList();
		this.baseDao.selectJsonPaging(hql, params.toArray(), jsonPaging);
		return jsonPaging;
	}

}
