package com.gzepro.internal.query.soa.action.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.exception.ValidateException;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.QueryUserListSO;
import com.gzepro.internal.query.soa.service.user.dto.RetrieveUserSO;
import com.gzepro.internal.query.soa.service.user.dto.UserDetailDTO;
import com.gzepro.internal.query.soa.service.user.dto.UserForm;
import com.gzepro.internal.query.soa.service.user.dto.UserListDTO;
import com.gzepro.internal.query.soa.service.user.impl.UserService;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.user")
public class UserAction  extends SoaBaseJsonAction{
	@Resource
	private UserService userService;// 通过spring注入业务实例
	private UserForm form = new UserForm();// 查询表单封装对象
	
	/**
	 * 查询用户列表
	 */
	public String query() {
		try {
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("list");
			this.saveSysLog(Constants.SOA_USER, queryInputParameter);//保存查询日志
		    // 调用ws
			List<UserListDTO> dtoList = (List<UserListDTO>) userService.query(form.getQueryListSO(), menuId, this.getAccount().getId());
			if(dtoList != null && dtoList.size()==1){
				form.getRetrieveSO().setUserId(dtoList.get(0).getUserId());
				return view();
			}else{
				form.setDtoList(dtoList);
				return "list";
			}
		} catch (Exception ex) {
			// 统一异常处理类
			ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_USER, ex);
			return "list";
		}
	}
	
	/**
	 * 新增/编辑用户信息
	 */
	public String input() {
		String userId = form.getRetrieveSO().getUserId();
		if(userId != null && !userId.equals("")){//编辑
			try {
				UserDetailDTO dto= (UserDetailDTO) userService.find(form.getRetrieveSO());
				form.setDto(dto);
			} catch (Exception ex) {
				// 统一异常处理类
				this.handleException(queryInputParameter,Constants.SOA_USER, ex);
			}
		}
		return "input";
	}
	
	/**
	 * 保存用户信息
	 */
	public String saveOrUpdate() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_USER, form.getDto().getUserId());//保存查询日志
			int result = userService.saveOrUpdate(form.getDto());
			return "save";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(form.getDto().getUserId(),Constants.SOA_USER, ex);
			return "save";
		}
	}
	
	/**
	 * 查看用户详细信息
	 */
	public String view() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			validateInput("view");
			this.saveSysLog(Constants.SOA_USER, queryInputParameter);//保存查询日志
			//调用ws
			UserDetailDTO dto= (UserDetailDTO) userService.view(form.getRetrieveSO(), menuId, this.getAccount().getId());
			form.setDto(dto);
			return "view";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(queryInputParameter,Constants.SOA_USER, ex);
			return "view";
		}
	}
	
	/**
	 * 删除用户信息
	 */
	public String delete() {
		try{
			this.resetPromptMessage();// 清空错误提示信息 做一个reset方法，设置tip为空
			this.saveSysLog(Constants.SOA_USER, form.getRetrieveSO().getUserId());//保存查询日志
			int result = userService.delete(form.getRetrieveSO().getUserId());
			return "delete";
		}catch (Exception ex) {
			// 统一异常处理类
			//ex.printStackTrace();
			this.handleException(form.getRetrieveSO().getUserId(),Constants.SOA_USER, ex);
			return "delete";
		}
	}
	
	/**
	 * 检查输入参数
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	private void validateInput(String type)throws Exception{
		if(type.equals("list"))
		{
			QueryUserListSO queryListSO = form.getQueryListSO();// 获得参数对象
		}else if(type.equals("view")){
			RetrieveUserSO retrieveSO=form.getRetrieveSO();// 获得参数对象
			String userId = retrieveSO.getUserId(); 
			//保存输入参数
			queryInputParameter=userId;
			// 分析输入参数
			if(userId.equals("") ){
				throw new ValidateException(Constants.ERROR_USER_NOINPUT);
			}
		}
	}
	
	public UserForm getForm() {
		return form;
	}
	public void setForm(UserForm form) {
		this.form = form;
	}
	
}
