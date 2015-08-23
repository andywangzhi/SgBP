<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.4.2.min.js"></script>

<script>
$(function(){
if(window.top.location!=window.location){
   window.top.location.reload(); 
}
var frm = document.frm;
	frm.name.focus();
})

function errorEffect(dom){
 		var target = $(dom);
	var tagName = target.attr('tagName');
	if(tagName=="DIV"){
		if(target.attr('class')=='roleSelect'){
			target.removeClass('roleSelect').addClass('roleSelectWrapError');
		}else{
			target.removeClass('selectWrap').addClass('selectWrapError');
			target.children('select').change(function(){$(this).parent('div').removeClass('selectWrapError').addClass('selectWrap');});
		}
	}else{
		target.css('border','1px solid #FF6331');
		target.focus(function(){$(this).css('border','1px solid #FF6331');});
	}
	 
}
function check(){
	var frm = document.frm;
	if($.trim(frm.name.value)==""){
	    errorEffect(frm.name);
		alert("用户名不能为空!");
	    frm.name.focus();
		return false;
	}else if($.trim(frm.password.value)==""){
	     errorEffect(frm.password);
	     alert("登录密码不能为空!");
	     frm.password.focus();
	    return false;
	}else {
		return true;
	}
}

function clearData(){
	var frm = document.frm;
	frm.name.value = "";
	frm.password.value = "";
	frm.name.focus();
}

function submitForm(){
    if(check()){
      	$('#frm').submit();
    }
}

function keyDown()
{
    if (window.event.keyCode == 13)
    {
        window.event.returnValue=false;
        window.event.cancel = true;
        submitForm();
    }
}
function displayBoder(vth){ 
  	//if($.trim(vth.value)!=""){
  	  //$(vth).css('border','0px solid');
	//} 
}

</script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color:#FFFFFF;
}
#Layer1 {
	position:absolute;
	width:680px;
	height:68px;
	z-index:1;
	top: 395px;
}
-->
</style>
</head>

<body onkeydown="keyDown()">
<form id="frm" name="frm" method="post" action="login.action">
<table width="1002" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div id="Layer1">
      <table width="220" border="0" align="right" cellpadding="3" cellspacing="0">
        <tr>
          <td><div align="right"><strong>用户：</strong></div></td>
          <td><input name="name" id="name" type="text" onblur="displayBoder(this)"  onfocus="displayBoder(this)"  maxlength="30"  style="width:150px;" value="<s:property value="loginAccountUserName"/>"/>
          </td>
        </tr>
        <tr>
          <td><div align="right"><strong>密码：</strong></div></td>
          <td> <input name="password" id="password" type="password" onblur="displayBoder(this)"  onfocus="displayBoder(this)"  maxlength="30"  style="width:150px;"/></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><img src="images/login1_bt1.jpg" width="77" height="26" onclick="submitForm()"  style="cursor:pointer;"/> <img src="images/login1_bt2.jpg" width="77" height="26" onclick="clearData()"  style="cursor:pointer;" /></td>
        </tr>
      </table>
    </div>
    <img src="images/login1_bg.jpg" width="1002" height="473" /></td>
  </tr>
  <tr height="90"></tr>
  <tr>
    <td>
    <img src="images/login1_copyright.jpg" width="1002" height="40" /></td>
  </tr>
</table>
</form>
<s:if test="hasActionErrors()">    
   <s:iterator value="actionErrors">    
          <script   language="JavaScript">    
           alert("<s:property escape="false"/>")    
          </script>    
    </s:iterator>    
</s:if> 
</body>
</html>
