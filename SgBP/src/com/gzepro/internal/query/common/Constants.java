package com.gzepro.internal.query.common;

/**
 * 常量定义
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class Constants {
	
	//以下是错误信息提示变更
    public static final String ERROR_USER_NOINPUT = "error_no_input";
    public static final String ERROR_RSPERSON_NOINPUT = "error_no_input";
    public static final String ERROR_NOINPUT = "error_no_input";
    public static final String ERROR_SYSTEM = "error_system";
    public static final String ERROR_NO_ACCESS_RIGHT = "error_no_access_right";
    public static final String ERROR_NO_RECORD = "error_no_record";
    
    //用户的身份类型
    public static final int DIST_TYPE_SUPER =1;//超级管理员
    public static final int DIST_TYPE_SYS =2;//系统管理员的用户
    public static final int DIST_TYPE_MANAGER =3;//组管理员用户
    public static final int DIST_TYPE_COMMON =4;//普通用户
    
    //以下为与系统模块相类的常量，主要用于写日志
	
	public static final  String SOA_USER = "用户";
	public static final  String SOA_PERSON = "人员";
	public static final String SOA_EDU = "教育经历";
	public static final String SOA_WORK = "工作简历";
	public static final String SOA_TEC = "科技成果";
	public static final String SOA_PROJ = "项目经验";
	public static final String SOA_TECH = "职称信息";
	public static final String SOA_PREVIEW= "预览";
	
	public static final  String SYSTEM_RESOURCE = "资源管理";
	public static final  String SYSTEM_ACCOUNT = "用户管理";
	public static final  String SYSTEM_MENU = "菜单管理";
	public static final  String SYSTEM_DICTIONARY = "数据字典管理";
	public static final  String SYSTEM_GROUP = "用户组管理";
	public static final  String SYSTEM_DEPT = "部门管理";
	public static final  String SYSTEM_CONFTYPE = "数据类型";
	public static final  String SYSTEM_CONF = "基础数据";
	public static final  String SYSTEM_ROLE = "角色管理";
	public static final  String SYSTEM_OPERTYPE = "操作类型管理";
	public static final  String SYSTEM_GROUPRIGHT = "用户组授权";
	public static final  String SYSTEM_ACCOUNTRIGHT = "用户授权";
	public static final  String SYSTEM_ROLERIGHT = "角色授权";
	
	//2011-08-25hechuan修改，用于统一日期格式
	public static final  String FORMAT_DATETIME = "formatDatetime_MM/dd/yyyy HH:mm:ss";
	public static final  String FORMAT_DATE = "formatDate_MM/dd/yyyy";
	public static final  String FORMAT_TIME = "formatTime_HH:mm:ss";
	public static final  String FORMAT_MONTH = "formatDate_MM/yyyy";
	public static final  String FORMAT_HOUR = "formatDate_MM/dd/yyyyHH";
	
	//字典岗位类型
	public static final String GW_TYPE_ID = "9";

    
}
