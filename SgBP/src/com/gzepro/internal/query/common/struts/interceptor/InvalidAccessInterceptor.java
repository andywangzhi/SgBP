package com.gzepro.internal.query.common.struts.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author zjw
 * @version 1.0
 * Created on: 2012-2-19
 */
@SuppressWarnings("serial")
public class InvalidAccessInterceptor extends AbstractInterceptor{
	
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	   ActionContext ctx = invocation.getInvocationContext();
	   Map session = ctx.getSession();
	   HttpServletRequest request = ServletActionContext.getRequest();
	   String requestURL=buildOriginalURL(request);
	   String menuJsonStr=session.get("menuJsonStr")==null?"":session.get("menuJsonStr").toString();
	   String allUrl=session.get("allUrl")==null?"":session.get("allUrl").toString();
	   //System.out.println("requestURL==="+requestURL);
	   String pubName=request.getContextPath();
	   //System.out.println(pubName);
	   //String tempStr=requestURL.substring(requestURL.indexOf("mypro")+5);
	   String tempStr=requestURL.substring(requestURL.indexOf(pubName)+pubName.length());
	   if(tempStr.endsWith("&")){
		   tempStr=tempStr.substring(0,tempStr.length()-1);
	   }
	   if(tempStr.indexOf("&")>0){
		   tempStr=tempStr.substring(0,tempStr.indexOf("&"));
	   }
	   if(tempStr.indexOf("menuId")>0){
		   tempStr=tempStr.substring(0,tempStr.indexOf("?"));
	   }
	  //System.out.println("tempStr==="+tempStr);
	  //System.out.println(menuJsonStr);
	   if(!"".equals(requestURL)){
		   //验证资源请求的合法性
		   if(allUrl.indexOf(tempStr)<0){
			   return invocation.invoke();
		   }else if(menuJsonStr.indexOf(tempStr)>0){
			   return invocation.invoke();
		   }else{
			   //return Action.ERROR;
			   return "invalidAccess";
		   }
	   }else{
		   return Action.NONE;
	   }
	}
	/**
	 * 组装请求的url
	 * 
	 * @param request
	 * @return
	 */
	private String buildOriginalURL(HttpServletRequest request) {
		StringBuffer originalURL = request.getRequestURL();
		Map parameters = request.getParameterMap();
		if (parameters != null && parameters.size() > 0) {
			originalURL.append("?");
			for (Iterator iter = parameters.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				String[] values = (String[]) parameters.get(key);
				for (int i = 0; i < values.length; i++) {
					originalURL.append(key).append("=").append(values[i])
							.append("&");
				}
			}
		}
		return originalURL.toString();
	}
}
