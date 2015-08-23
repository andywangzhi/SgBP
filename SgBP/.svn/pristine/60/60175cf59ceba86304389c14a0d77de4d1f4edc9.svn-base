<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
<head> 
    <title>查看</title>
    <jsp:include page="../inc/top.jsp"></jsp:include>
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
      <div   fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td width="20%" style="text-align: right; font-size: 12px;">编码：</td>
                      <td width="80%"><input type="text" disabled="true" id="confType_code" name="confType.code" value="<s:property value="confType.code"/>" style="width:335px;" /></td>
                 </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">名称：</td>
                      <td><input type="text"  disabled="true" id="confType_name" name="confType.name" value="<s:property value="confType.name"/>" style="width:335px;" /></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size: 12px;">备注：</td>
                      <td><textarea id="confType_remark"  disabled="true"  name="confType.remark" rows="25" cols="43" style="height:60px;"><s:property value="confType.remark"/></textarea></td>
                  </tr>
              </table>
          </div>
      </div>
    </form>
</div>
</body>
</html>