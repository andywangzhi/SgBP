<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.gzepro.internal.query.common.struts.interceptor.LoginInterceptor"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <title>韶关市人才实名信息管理平台 </title>

	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>

	<script type="text/javascript" src="<%=path%>/js/jquery/easyui/locale/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" src='<%=path%>/js/jquery-outlook2.js'> </script>

<!--
	<script type="text/javascript" src='<%=path%>/js/outlook.js'> </script>	
-->

    <link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
    

    <script type="text/javascript">
     var basePath = '<%=path%>';	
	 var _menus = <s:property value="menuJsonStr" escape="false"/>;
     if(_menus == undefined || _menus == null || _menus == '' ){
       alert('无权限');  
       location.href = basePath+'/logout.action';
     }
	 function logout(){
	    <%-- $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
	        if (r) {
	            location.href = '<%=path%>/logout.action';
	        }
	    }); --%>
	    if(confirm("您确定要退出本次登录吗？")){
	    	location.href = '<%=path%>/logout.action';
	    }
	 }
	 function refresh(){
	    location.href = basePath+'/system/main.action'; 
	 }
    </script>



	<script type="text/javascript" src="<%=path%>/js/jquery.jclock.js"></script>
    <script type="text/javascript">
		$(function(){
			$('#demo').jclock({withDate:true, withWeek:true});	
		});
    </script>

	

</head>


<body class="easyui-layout">

    <noscript><div style=" position:absolute; z-index:100000; height:1024px;top:0px;left:0px; width:100%; background: #FFF;"></div></noscript>

    <!--头部-->
    <div region="north" border="false" class="top_bg">
            <div class="row_l"><img src="<%=path%>/images/header_left.jpg" /></div>
            <div class="row_r top_r">
                <div class="row_l btn_top">
                    <a class="btn_top1" onClick="addTab('主页','<%=path%>/business/home.html','ico_home')">主 页</a>
                    <a class="btn_top2" href="<%=path%>/file/操作手册.doc">帮 助</a>
                    <a class="btn_top3" onclick="refresh();">刷 新</a>
                    <a class="btn_top4" onclick="logout();">退 出</a>                
                </div>
                
                <div class="row_r top_inf">
                    <span class="grxx_top">欢迎您，<s:property value="nameCN"/></span>
                    <span class="time_top" id="demo" style="height:50px;">2012-8-1 星期三 12：00</span>
                </div>
            </div>
	</div>
    <!--end头部-->
    



    <div region="west" split="true"  title="系统菜单" icon="ico_westtitle"  border="false" headerCls="panel-header-west" style="width:200px;overflow:hidden;">
		<div id="nav" class="easyui-accordion" fit="true" border="false">
			<!--  导航内容 -->
		</div>
    </div>
		
	

    <!--工作桌面-->
    <div id="mainPanle" region="center"  border="false" style=" overflow:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >

		</div>
    </div>
    <!--工作桌面-->
    
    <!--底部页脚-->
    <div region="south" border="false" class="l-layout-bottom" id="copyRightDIV"></div>
    <!--end底部页脚-->
    
	<!--右键菜单功能-->
    <div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate" style="padding-left: 30px;"></div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose" style="padding-left: 30px;"></div>
		<div id="mm-tabcloseall" style="padding-left: 30px;"></div>
		<div id="mm-tabcloseother" style="padding-left: 30px;"></div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright" style="padding-left: 30px;"></div>
		<div id="mm-tabcloseleft" style="padding-left: 30px;"></div>
		<div class="menu-sep"></div>
		<div id="mm-exit" style="padding-left: 30px;"></div>
	</div>
	<!--end右键菜单功能-->
    
	<script language="javascript" >
		$(document).ready(function(){
		document.getElementById("mm-tabupdate").innerText="刷新";
		document.getElementById("mm-tabclose").innerText="关闭";
		document.getElementById("mm-tabcloseall").innerText="全部关闭";
		document.getElementById("mm-tabcloseother").innerText="除此之外全部关闭";
		document.getElementById("mm-tabcloseright").innerText="当前页右侧全部关闭";
		document.getElementById("mm-tabcloseleft").innerText="当前页左侧全部关闭";
		document.getElementById("mm-exit").innerText="退出";
		document.getElementById("copyRightDIV").innerText="Copyright © 2012 韶关市人力资源和社会保障局 权利所有。　粤ICP备07015547号";
		$("#dvDate").css('display','block');
		$("#dvSouth").css('display','block'); 
		});
	</script>     

</body>
</html>