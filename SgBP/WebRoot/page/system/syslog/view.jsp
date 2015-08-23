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
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
      <div fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">操作人：</td>
                      <td><input width="30%" type="text" id="sysLog_accountName" disabled="true" name="sysLog.accountName" value="<s:property value="sysLog.accountName"/>"/></td>
                      <td style="text-align: right; width 20%; font-size: 12px;">类型：</td>
                      <td><input width="30%" type="text" id="sysLog_logType" disabled="true" name="sysLog.logType"  value="<s:property value="sysLog.logType"/>"/></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">IP：</td>
                      <td><input width="30%" type="text" id="sysLog_operIp" disabled="true" name="sysLog.operIp" value="<s:property value="sysLog.operIp"/>"/></td>
                      <td style="text-align: right; width 20%; font-size: 12px;">创建日期：</td>
                      <td><input width="30%" type="text" id="sysLog_createDate" disabled="true" name="sysLog.createDate"  value="<s:date name="sysLog.createDate" format="yyyy-MM-dd HH:mm:ss"/>"/></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">备注：</td>
                      <td colspan="3"><textarea id="sysLog_remark" name="sysLog.remark" disabled="true" rows="25" cols="48" style="height:160px;"><s:property value="sysLog.remark"/></textarea></td>
                  </tr>
              </table>
          </div>
      </div>
    </form>
</div>
</body>
</html>