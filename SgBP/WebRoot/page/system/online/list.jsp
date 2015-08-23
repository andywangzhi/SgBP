<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>在线用户列表</title>
<jsp:include page="../inc/top.jsp"></jsp:include>
</head>
<div class="main_in">
<table id="list"></table>
<script type="text/javascript"> 
		$(function(){
			$('#list').datagrid({
				title:'<span style="color:#fff">在线用户</span>',
				iconCls:'icon-edit',
				width:'auto',
				height:448,
				nowrap: false,
				striped: true,
				collapsible:true,
				url:'<%=path%>/system/online!findAll.action?datestr='+new Date().getTime(),
				sortName: 'lastVisitDate',
				sortOrder: 'desc',
				remoteSort: true,
				idField:'id',
				columns:[[
					{field:'loginId',title:'登陆帐号',width:203},
					{field:'accountName',title:'用户名',width:200,sortable:true},
					{field:'operIp',title:'IP',width:100},
				    {field:'loginDate',title:'登陆时间',width:140},
				    {field:'lastVisitDate',title:'最近活动时间',width:140}
				]],
				pagination:true,
				rownumbers:true
			});
		});
</script>
</body>
</html>