<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String ids=request.getParameter("ids");
%>
<html>
	<head>
		<title>设置用户语言</title>
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<script type="text/javascript">
		function saveData()
		{
		   var lang ='1';
		   var inputs = document.getElementsByTagName("input");
		   for(var i=0;i<inputs.length;i++){   
		        if(inputs[i].type=="radio"){
		           if(inputs[i].checked){
		              lang = inputs[i].value;
		           }   
		        }
		    }
		    $.get("<%=path%>/system/account!saveLang.action?lang="+lang+"&ids=<%=ids%>", function(data, status, Request){
		        window.opener.location.href = window.opener.location.href; 
		        window.close();
		    })
		}
		</script>		
	</head>
	<body>
	<div border="false"
		style="padding: 15px; background: #fff; border: 1px solid #ccc;">
		<table cellpadding=3 border="0">
			<tr>
			  <td style="text-align: right; font-size: 12px;">
				  <input type="radio" id="lang_1" name="lang" checked value="1"/>中文
			  </td>
			</tr>
			<tr>
			  <td style="text-align: right; font-size: 12px;">
				  <input type="radio" id="lang_2" name="lang"  value="2"/>英文
			  </td>
			</tr>
			<tr>
			  <td style="text-align: right; font-size: 12px;">
				  <input type="radio" id="lang_3" name="lang" value="3"/>繁体
			  </td>
			</tr>
		</table>
	</div>
    <div border="false" style="text-align: center; height: 30px; margin-top:10px; line-height: 30px;">
        <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
    </div>
	</body>
</html>