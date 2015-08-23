<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>韶关市人才实名信息管理系统</title>
<link href="<%=path%>/css/user_login.css" rel="stylesheet" type="text/css"/>
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
</head>

<body onkeydown="keyDown()">
<form id="frm" name="frm" method="post" action="login.action">

    <div class="user_login">
                
        <ul class="ul_input">
            <li><span>用户名：</span><input name="name" id="name" type="text" onblur="displayBoder(this)"  onfocus="displayBoder(this)"  maxlength="30"  class="dl_input" style="width:200px;" value="<s:property value="loginAccountUserName"/>"/></li>
            <li><span>&nbsp;</span></li>
            <li><span>密　码：</span><input name="password" id="password" type="password" onblur="displayBoder(this)"  onfocus="displayBoder(this)"  maxlength="30" class="dl_input" style="width:200px;"/></li>
            <li><span>&nbsp;</span></li>
            <li><span>&nbsp;</span><button name="" type="button" class="btn_loing_ok" onclick="submitForm()"/>登&nbsp;录</button>　<button name="" type="button" class="btn_loing_no" onclick="clearData()"/>重&nbsp;置</button></li>
        </ul>
        
    </div>
    
    <div class="login_footer">Copyright &copy; 2012 韶关市人力资源和社会保障局 权利所有。　粤ICP备07015547号</div>

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
