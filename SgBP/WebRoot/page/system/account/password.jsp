<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
    <title>修改</title>
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/account/password.js"></script>	
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;" align="center">
            <table cellpadding=3>
                <tr>
                    <td style="text-align: right; font-size:12px;">新密码：</td>
                    <td style="text-align: left;">
                        <input type="password" id="newpassword" name="newpassword" value="" title="留空表示保留原密码"/><span style="color:red">*</span>
                    </td>
                    <td style="text-align: right;font-size:12px;">确认密码：</td>
                    <td style="text-align: left;">
                        <input type="password" id="passconfirm" name="passconfirm" value=""/><span style="color:red">*</span>
                    </td>
                    <td id="msg"></td>
                </tr>
            </table>
          </div>
          <div border="false" style="text-align: center; height: 30px;margin-top:10px;  line-height: 30px;">
              <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
          </div>
      </div>
    </form>
</div>
</body>
</html>

