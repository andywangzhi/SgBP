package com.gzepro.internal.query.soa.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.gzepro.internal.query.base.action.BaseJsonAction;
import com.gzepro.internal.query.common.Constants;
import com.gzepro.internal.query.common.exception.ValidateException;
import com.gzepro.internal.query.common.struts.interceptor.LoginInterceptor;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class SoaBaseJsonAction extends BaseJsonAction {
	protected String queryInputParameter = "";
	
	protected String resKey; 
	
	/**
	 * 跳转到查询页面
	 */
	public String viewFind(){
		resetPromptMessage();   //清空之前的出错提示信息
		return "success";
	}
	
	/**
	 * 重置提示信息为空字符串
	 */
	public void resetPromptMessage(){
		tip = "";   //清空页面的提示信息
	}
	
    /**
     *设置tip的值
     */
	public void setPromptMessage(String info){
	   tip = info;//设置页面提示信息
	}
	
	/**
	 * 处理安利编号
	 * @return
	 */
	public String handleAdanumber(String adanumber) {
		if(isInteger(adanumber.trim())){
			Long adaStr=Long.parseLong( adanumber.trim().toString());
			Long ada = 36000000000000L+Long.parseLong(adanumber.trim());
			
			//将当前查询的安利编号存入session ,以供其他查询使用
			Map<String,String> curUserMap=(HashMap<String,String>)ActionContext.getContext().getSession().get(LoginInterceptor.GZEPRO_NUM);
			if(curUserMap==null){
				 curUserMap = new HashMap<String,String>();
				 curUserMap.put("mstChiNam", "");
			     curUserMap.put("spouseChiNam", "");
			}else{
				if(curUserMap.containsKey("adanumber") && !curUserMap.get("adanumber").equals("") && !curUserMap.get("adanumber").equals(adaStr+"")){
					curUserMap.put("mstChiNam", "");
				    curUserMap.put("spouseChiNam", "");
				}
			}
			curUserMap.put("adanumber", String.valueOf(adaStr));//保存安利的编号 供查询使用
			ActionContext.getContext().getSession().put(LoginInterceptor.GZEPRO_NUM, curUserMap);
			
			return ada+"";
		}
		return "";
	}

	/**
	  * 判断字符串是否是整数
	  */
	 public boolean isInteger(String value) {
	  try {
	   Long.parseLong(value);
	   return true;
	  } catch (NumberFormatException e) {
	   return false;
	  }
	 }
	 
     /**
	  * 判断字符串是否是整数
	  */
	 public boolean isLong(String value) {
	  try {
	   Long.parseLong(value);
	   return true;
	  } catch (NumberFormatException e) {
	   return false;
	  }
	 }
	 
	 
	 
	 /**
	  * 判断字符串是否是整数
	  */
	 public boolean isDate(String dateTimeStr) {
		try {
			if (dateTimeStr == null || dateTimeStr.equals("")) {
				return false;
			}
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = sdf.parse(dateTimeStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	 }
	  
	 
	 /**
	  * 保存异常信息,返回异常的错误提示
	  */
	public void handleException(String queryStr,String modelName,Exception ex) {
        if(ex instanceof ValidateException){
        	ValidateException vEx = (ValidateException)ex;
        	String a  =vEx.getErrorCode();
        	setPromptMessage(getResourceValue(vEx.getErrorCode()));
		}else{//抛出服务调用的自定义异常
			String faulCode = "";
			String faulDetail = "";
			faulCode = ex.getMessage();
			faulDetail = ex.getStackTrace().toString();
			String str = queryStr+"查询出错";
			if(!faulCode.equals("")){
				str += ",错误码为:"+faulCode;
	     	}
			str += ",信息为:"+faulDetail;
			this.saveSysLog(modelName, str);//保存出错日志
			setPromptMessage(getResourceValue(Constants.ERROR_SYSTEM));
		}
	 } 
	
	/**
	 * 检查登陆人员对指定菜单的最大pin
	 * @param pinGrading 被查询营销人员的pinGrading
	*/
	public int findAccountMenuPin(){
		int menuPin = this.baseService.getAccountMenuPin(this.getAccount().getId(), menuId);
		return menuPin; 
	 }
	
	
	/**
	 * js异步获取资源文件
	 * @return
	 */
	public String getResourceForPage(){
		renderText(this.getResourceValue(resKey)); 
        return null; 
	}
	
    public String getAdaForPage(){
    	Map<String,String> curUserMap=(HashMap<String,String>)ActionContext.getContext().getSession().get(LoginInterceptor.GZEPRO_NUM);
    	if(curUserMap!=null && curUserMap.containsKey("adanumber") && !curUserMap.get("adanumber").equals("")){
    		renderText(curUserMap.get("adanumber"));
    	}
    	return null;
    }
	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}
	
	
	
}
