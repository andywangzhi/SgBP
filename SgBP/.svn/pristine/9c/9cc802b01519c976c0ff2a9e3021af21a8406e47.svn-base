package com.gzepro.internal.query.system.base;

import java.util.List;

import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.system.model.Group;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class SystemBaseService extends BaseService{
	/**
	 * 获得当前登陆用户所在的组
	 * @param accountId 用户Id
	 * @return 组的Id字符串,以","分隔
	 */
	public String findAccountGroupById(Long accountId){
		String result = "";
		String hql = "select distinct r from Group r,GroupAccount ga where r.valid='1' and r.id=ga.groupId and ga.accountId="+accountId;
		List<Group> list = this.baseDao.find(hql);
		if(list != null && list.size() >0){
			for(Group g:list){
				result += g.getId()+",";
			}
			if(result.endsWith(","))result = result.substring(0,result.length()-1);
		}
		return result;
	}
	
}
