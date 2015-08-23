package com.gzepro.internal.query.soa.service.user.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gmcc.support.trade.service.provider.UserVo;
import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.util.CloneUtil;
import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.soa.service.user.dto.QueryUserListSO;
import com.gzepro.internal.query.soa.service.user.dto.RetrieveUserSO;
import com.gzepro.internal.query.soa.service.user.dto.UserDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.UserListDTO;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@Service("userService")
public class UserService  extends BaseService{
	/**
	 * 保存或者修改用户信息
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Integer saveOrUpdate(Object obj)throws Exception {
		UserDetailDTO dto = (UserDetailDTO)obj;
		if(dto.getUserId() != null && !dto.getUserId().equals("")){
			com.gmcc.support.trade.service.provider.UserVo parameters = new com.gmcc.support.trade.service.provider.UserVo();
			parameters.setUserId(dto.getUserId());
			parameters.setUserName(dto.getUserName());
			parameters.setBirthDate(this.dealDate(dto.getBirthDate()));
			parameters.setStatus(Integer.parseInt(dto.getStatus()));
			int result = this.initUserStub().acceptSaveUser(parameters);
			return result;
		}
		return null;
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Integer delete(Object obj)throws Exception {
		String userId = (String)obj;
		if(userId != null && !userId.equals("")){
			int result = this.initUserStub().acceptDelUser(userId);
			return result;
		}
		return null;
	}
	
	
	/**
	 * 根据查询参数调用WS,返回查询到的用户详细信息
	 * @param soObject 查询的参数对象
	 * @return 结果对象
	 */
	public Object find(Object soObject)throws Exception {
		//将搜索对象转换成用户详细信息查询的搜索对象
		RetrieveUserSO retrieveSO = (RetrieveUserSO) soObject;
		
		com.gmcc.support.trade.service.provider.UserVo valueElement = null;
        valueElement = this.initUserStub().acceptUserDetail(retrieveSO.getUserId());
		
		//调用WS返回结果 value
        UserVo value = valueElement;
		if( value != null ){ 
			UserDetailDTO  result = new UserDetailDTO();//保存处理结果
			result  = (UserDetailDTO) CloneUtil.cloneObject(value,result,null); //转换dto对象
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			result.setBirthDate(DateUtil.getDateStringFormInt(value.getBirthDate(),formatStr));
			return result;
	    }
		return null;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的用户详细信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Object view(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户详细信息查询的搜索对象
		RetrieveUserSO retrieveSO = (RetrieveUserSO) soObject;
		
		com.gmcc.support.trade.service.provider.UserVo valueElement = null;
        valueElement = this.initUserStub().acceptUserDetail(retrieveSO.getUserId());
		
		//调用WS返回结果 value
        UserVo value = valueElement;
		if( value != null ){ 
			return this.parseDetailResult(value, menuId, accountId);
	    }
		return null;
	}
	
	/**
	 * 根据查询参数调用WS,返回查询到的用户信息
	 * @param soObject 查询的参数对象
	 * @param menuId  功能模块Id
	 * @param accounted 当前的登录用户
	 * @return 结果对象
	 */
	public Object query(Object soObject, Long menuId, Long accountId)throws Exception {
		//将搜索对象转换成用户查询的搜索对象
		QueryUserListSO queryListSO = (QueryUserListSO) soObject;
		//处理参数
		String userId = "";
		if(queryListSO.getUserId() != null){
			userId = queryListSO.getUserId();
		}
		String userName = "";
		if(queryListSO.getUserName() != null){
			userName = queryListSO.getUserName();
		}
        com.gmcc.support.trade.service.provider.UserQo parameters = new com.gmcc.support.trade.service.provider.UserQo();
		parameters.setUserId(userId);
		parameters.setUserName(userName);
		
		com.gmcc.support.trade.service.provider.UserVo[] valueElement = null;
        valueElement = this.initUserStub().acceptQueryUser(parameters);
		
		//调用WS返回结果 value
        UserVo[] value =valueElement;
		if (value != null && value.length>0) {
			return this.parseQueryResult(value, menuId, accountId);
		}
		return null;
	}

	/**
	 * 屏蔽查询结果的敏感信息
	 * @param obj 待分析对象
	 * @param menuId 功能模块Id
	 * @param accountId 当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception 
	 */
	private Object parseQueryResult(Object obj, Long menuId, Long accountId)throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);//获取用户指定功能模块的敏感字段
		ArrayList<UserListDTO> result = new ArrayList<UserListDTO>();//保存处理结果
		UserVo[] dtoArr = (UserVo[]) obj; //转换object对象
		for (int i = 0; i < dtoArr.length; i++) {
			UserVo dto = dtoArr[i];
			UserListDTO tmpDto = new UserListDTO();
			tmpDto = (UserListDTO) CloneUtil.cloneObject(dto, tmpDto, map); //转换dto对象
			
			String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
			if (map == null || (map != null && !map.containsKey("birthDate"))) tmpDto.setBirthDate(DateUtil.getDateStringFormInt(dto.getBirthDate(),formatStr));
			
			//将用户状态转换为相应的语言
			if ((map == null || (map != null && !map.containsKey("status"))) && dto.getStatus()!=null){
				tmpDto.setStatus(this.getResourceValue("user_status_"+dto.getStatus()));
			}
			result.add(tmpDto);
		}
		return result;
	}
	
	/**
     * 屏蔽查询结果的敏感信息
	 * @param obj 待分析对象
	 * @param menuId 功能模块Id
	 * @param accountId 当前登录用户Id
	 * @return 分析的结果
	 * @throws Exception 
	 */
	private Object parseDetailResult(Object obj, Long menuId, Long accountId) throws Exception {
		Map map = this.findMenuDicByAccountId(menuId, accountId);//获取用户指定功能模块的敏感字段
		UserDetailDTO  result = new UserDetailDTO();//保存处理结果
		UserVo value =(UserVo) obj; //转换object对象
		result  = (UserDetailDTO) CloneUtil.cloneObject(value,result,map); //转换dto对象
		
		String formatStr=getResourceValue(Constants.FORMAT_DATE);//页面显示的日期格式
		if (map == null || (map != null && !map.containsKey("birthDate"))) result.setBirthDate(DateUtil.getDateStringFormInt(value.getBirthDate(),formatStr));
		//将用户状态转换为相应的语言
		if ((map == null || (map != null && !map.containsKey("user_status"))) && value.getStatus()!=null){
			result.setStatus(this.getResourceValue("user_status_"+value.getStatus()));
		}
		return result;
	}
	
}
