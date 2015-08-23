<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>"/>
    <title>模板下载</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="business/css/reset.css" />
  </head>
  
  <body>
    
<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：其它管理&nbsp;&gt;&nbsp;模板下载</div>
    <div class="row_r web_paht_r tool"></div>
</div>

<div class="main_in">
        
    
    
    <div id="nav" class="easyui-accordion" fit="false" border="false"  >
         <div title="模板下载" headerCls="bar_title" icon="title" selected="true">
         
              <div class="mbxz" style="height:40%;">
              
                   <a href="<%=path%>/file/人才名册.xls"  class="row_l mbxz_li">
                      <img src="business/images/Download_pic1.jpg" class="row_l mbxz_pic" />
                      <span class="row_l mbxz_info">
                          <span class="mbxz_1">批量导入模板</span>
                          <span class="mbxz_2">批量导入人员信息Excel表</span>
                      </span>
                  </a>
                   <a href="<%=path%>/file/采集表.doc"  class="row_l mbxz_li">
                      <img src="business/images/Download_pic2.jpg" class="row_l mbxz_pic" />
                      <span class="row_l mbxz_info">
                          <span class="mbxz_1">采集表</span>
                          <span class="mbxz_2">采集人员信息Word表</span>
                      </span>
                  </a>
              </div>
              
        </div>
    </div>
    
</div>

    
  </body>
</html>
