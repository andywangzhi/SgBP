<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<html>
  <head>
    <title>页面转向中，请稍等..</title>
	<script type="text/javascript">
		var secs =5; //倒计时的秒数 
		var URL ; 
		var path = '<%=path%>'; 
    	var menuId='<%=request.getParameter("menuId")%>';
    	var entrance='<%=request.getParameter("entrance")%>';
    	var p1=path+"/soa/RsPerson!toaddPage.action?entrance="+entrance+"&menuId="+menuId;
    	var p2=path+"/soa/RsPerson!query.action?entrance="+entrance+"&menuId="+menuId;
		function load(){ 
			if(entrance==1){
				URL =p1; 
			}else{
				URL =p2; 
			}
			for(var i=secs;i>=0;i--){ 
				window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000); 
			} 
		} 
		function doUpdate(num){ 
			if(entrance==1){
				document.getElementById('ShowDiv').innerHTML ='请先在个人信息新增页面填写个人基本信息，系统将在&nbsp;&nbsp;&nbsp;&nbsp;<span>'+num+'</span>&nbsp;&nbsp;&nbsp;&nbsp;秒后自动跳转到人员信息新增页面！';
			}else{
				document.getElementById('ShowDiv').innerHTML ='请在人员信息维护页面选择需要维护信息的个人，系统将在&nbsp;&nbsp;&nbsp;<span>'+num+'</span>&nbsp;&nbsp;&nbsp;&nbsp;秒后自动跳转到人员信息维护页面！'; 
			}
			if(num == 0){
			 	window.location=URL; 
			} 
		} 
	</script> 
	<style>
	<!--
	#ShowDiv { height: 80px;color: #0767a1;font-size: 14px; line-height: 80px;text-align:center; }
	
	#ShowDiv span {color: #ff0000;font-size: 38px; font-weight:bold;}
	-->
	</style>
  </head>
  
  <body>
   <div id="ShowDiv"></div>
  <script type="text/javascript">
  	load();
  </script>
  </body>
</html>
