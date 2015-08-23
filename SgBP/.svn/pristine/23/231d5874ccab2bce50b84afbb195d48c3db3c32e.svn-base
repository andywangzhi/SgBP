package com.gzepro.internal.query.base.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gzepro.internal.query.base.service.BaseService;
import com.gzepro.internal.query.common.struts.ContextPvd;
import com.gzepro.internal.query.common.struts.interceptor.LoginInterceptor;
import com.gzepro.internal.query.common.util.Paging;
import com.gzepro.internal.query.common.util.json.JSONUtils;
import com.gzepro.internal.query.system.model.Account;
import com.gzepro.internal.query.system.model.SysLog;
import com.gzepro.internal.query.system.service.SysLogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class BaseAction extends ActionSupport {
	private static final Logger log = LoggerFactory.getLogger(BaseAction.class);
	// 每页行数
	protected static int DEFAULT_PAGE_SIZE = 10;
	
	protected Paging paging = new Paging();
	protected Long id;
	protected String ids;
	protected String tip;
	
	protected String rebackType = "";//返回按钮中的返回类型
	protected String rebackUrl = "";//返回按钮中使用的url
	
	protected Long menuId;//点击的菜单ID
	
	protected int entrance;
	
	@Resource
	protected ContextPvd contextPvd;
	
	@Resource
	protected BaseService baseService;
	
	@Resource
	protected SysLogService sysLogService;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getRebackType() {
		return rebackType;
	}

	public void setRebackType(String rebackType) {
		this.rebackType = rebackType;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	
	public int getEntrance() {
		return entrance;
	}

	public void setEntrance(int entrance) {
		this.entrance = entrance;
	}

	public Paging getPaging() {
		return paging;
	}
	
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	/**
	 * 获得当前的登陆用户
	 * @return
	 */
	protected Account getAccount() {
		Account loginAccount = (Account) ActionContext.getContext().getSession().get(LoginInterceptor.USER_LOGIN);
		return loginAccount;
	}
	
	/**
	 * 通过key获得当前登陆的资源值
	 * @param key
	 * @return
	 */
	protected String getResourceValue(String key) {
		String lang =ActionContext.getContext().getSession().get(LoginInterceptor.CUR_USER_LANG).toString();
		ServletContext servletContext = ServletActionContext.getServletContext();
		Map<String,String[]> map = (HashMap)servletContext.getAttribute("_WEB_SYS_RESOURCE_KEY_");
		if(map.get(key) != null){
			Object obj = map.get(key)[Integer.parseInt(lang)];
			if(obj != null){
				return (String)obj;
			}else{
				return "";
			}	
		}
		//hechuan修改，如果资源找不到，就取key中_后面的值
//		return "";
		else{
			if(key.indexOf("_")!=-1){
				int index = key.lastIndexOf("_");
				return key.substring((index+1),key.length());
				
			}else{
				return key;
			}
		}
		
	}
	/**
	 * 通过key获得当前application中的字典数据
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String,Map<String,String>> getConfValue() {
		ServletContext servletContext = ServletActionContext.getServletContext();
		Map<String,Map<String,String>> map = (Map<String, Map<String, String>>) servletContext.getAttribute("_WEB_SYS_CONF_KEY_");
		if(map!=null&&map.size()>0){
			return map;
		}
		return null;
	}
	
	protected Map<String,String> getConfTypeMap(String key) {
		ServletContext servletContext = ServletActionContext.getServletContext();
		Map<String,Map<String,String>> map = (Map<String, Map<String, String>>) servletContext.getAttribute("_WEB_SYS_CONF_KEY_");
		if(map.get(key) != null&&map.get(key).size()>0){
			return map.get(key);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	protected String getConfValue(String typekey,String key) {
		ServletContext servletContext = ServletActionContext.getServletContext();
		Map<String,Map<String,String>> map = (Map<String, Map<String, String>>) servletContext.getAttribute("_WEB_SYS_CONF_KEY_");
		if(map.get(typekey) != null&&map.get(typekey).size()>0){
			return map.get(typekey).get(key);
		}
		return null;
	}
	
	/**
	 * 获得当前登陆用户的语言
	 * @return
	 */
	protected int getLang() {
		return Integer.parseInt(ActionContext.getContext().getSession().get(LoginInterceptor.CUR_USER_LANG).toString());
	}
	
	
	/**
	 * 获得当前登陆用户的身份
	 * @return
	 */
	protected int getDistType() {
		return Integer.parseInt(ActionContext.getContext().getSession().get(LoginInterceptor.ACCOUNT_DIST_TYPE).toString());
	}
	
	/**
	 * 直接输出内容的简便函数.
	 */
	protected  String render(String text, String contentType) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(contentType);
			PrintWriter pw = response.getWriter();
			pw.print(text);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 直接输出内容的简便函数.
	 */
	protected  String render(List aList) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			JSONArray jsonArray = JSONUtils.toJSONArray(aList);
	        response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 直接输出字符串.
	 */
	protected  String renderText(String text) {
		return render(text, "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出字符串GBK编码.
	 */
	protected  String renderHtmlGBK(String html) {
		return render(html, "text/html;charset=GBK");
	}

	/**
	 * 直接输出XML.
	 */
	protected  String renderXML(String xml) {
		return render(xml, "text/xml;charset=UTF-8");
	}
	
	
	/**
	 * 获得Session
	 * @return
	 */
	public  Map getSession() {
		return ActionContext.getContext().getSession();
	}
	
	/**
	 * 获得Request
	 * @return
	 */
	public  HttpServletRequest getRequest() {
		return (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	}
	
	/**
	 * 获得Response
	 * @return
	 */
	public  HttpServletResponse getResponse() {
		return (HttpServletResponse)ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	}
	
	/**
	 * 根据Web相对路径获得文件绝对路径
	 * @param path
	 * @return
	 */
	public  String getRealPath(String path) {
		return getRequest().getSession().getServletContext().getRealPath(path);
	}
	
	/**
	 * 输出json格式
	 * @param json
	 * @throws IOException
	 */
	public String outputJson(Object json){		
		if (json.getClass()== JSONObject.class || json.getClass()== JSONArray.class){			
			try 
			{
				HttpServletResponse response = this.getResponse();
				response.setContentType("text/html;charset=UTF-8");    
				response.getWriter().print(json.toString());
				response.getWriter().close();	
			}
			catch (IOException e) 
			{				
				e.printStackTrace();
			}						
		}
		
		return null;
	}
	
	/**
	 * 系统日志添加
	 * @param logType  登陆 退出 故障 其他为模块的具体名称
	 * @param operIp
	 * @param remark
	 */
	public void saveSysLog(String logType, String remark){
		log.info(remark);//在日志文件中写日志
		SysLog sysLog = new SysLog();
		Account account = this.getAccount();
		sysLog.setLoginId(account.getLoginCode());
		sysLog.setAccountName(account.getNameCN());
		sysLog.setOperIp(contextPvd.getRemoteIp());
		sysLog.setLogType(logType);
		if(remark != null && remark.length()>800){//保存日志的前500个字符
			remark = remark.substring(0,800);
		}
		sysLog.setRemark(remark);
		sysLog.setCreateDate(new Date());
		sysLogService.add(sysLog);
	}

	public String getRebackUrl() {
		return rebackUrl;
	}

	public void setRebackUrl(String rebackUrl) {
		this.rebackUrl = rebackUrl;
	}
	
}
