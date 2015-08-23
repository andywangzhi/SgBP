<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String topPath = request.getContextPath();
%>

<link rel="stylesheet" type="text/css" href="<%=topPath%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=topPath%>/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=topPath%>/business/css/reset.css">

<%--
<script type="text/javascript" src="<%=topPath%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=topPath%>/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/jquery/jquery.blockUI.js"></script>

<script type="text/javascript" src="<%=topPath%>/js/common.js"></script>

<script type="text/javascript" src="<%=topPath%>/plugins/jquery.form.js"></script>
<script type="text/javascript" src="<%=topPath%>/plugins/js_validate.js"></script>
 --%>
 
<script type="text/javascript" src="<%=topPath%>/js/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/jquery/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/jquery/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/common.js"></script> 
<script type="text/javascript" src="<%=topPath%>/js/jquery/jquery.form.js"></script>
<script type="text/javascript" src="<%=topPath%>/js/js_validate.js"></script>
<%-- 
--%>
 
<script>
function keyDownFun(){
      if(window.event.keyCode==13){
          queryRecord();
      } 
   }
</script>
<style>
body,td,div,select,input{ font-size:12px;}
body{background-color:#FFF;}
</style>	
