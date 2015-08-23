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
<div style="background:#fafafa;width:670px;height:450px;">
    <form id="frm" method="post">
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">编码：</td>
                      <td><input width="30%" type="text" disabled="true" id="sysResource_key" name="sysResource.key"  value="<s:property value="sysResource.key"/>"/></td>
                      <td style="text-align: right; width 20%; font-size: 12px;">类型：</td>
                      <td>
                      	<select id="sysResource_useType" name="sysResource.useType" value="<s:property value="sysResource.useType"/>" disabled="true" style="width:160px;">
	                       <option value="1"  <s:if test="sysResource.useType==1">selected</s:if>>页面显示</option>
	                       <option value="2"  <s:if test="sysResource.useType==2">selected</s:if>>错误提示</option>
	                       <option value="3"  <s:if test="sysResource.useType==3">selected</s:if>>信息提示</option>
                     	</select>
                      </td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">中文名：</td>
                      <td colspan="3"><textarea  id="sysResource_nameZh" name="sysResource.nameZh" rows="5" cols="62" disabled="true"><s:property value="sysResource.nameZh"/></textarea></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">英文名：</td>
                      <td colspan="3"><textarea  id="sysResource_nameEn" name="sysResource.nameEn" rows="5" cols="62" disabled="true"><s:property value="sysResource.nameEn"/></textarea></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">繁体名：</td>
                      <td colspan="3"><textarea  id="sysResource_nameTw" name="sysResource.nameTw" rows="5" cols="62" disabled="true"><s:property value="sysResource.nameTw"/></textarea></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">备注：</td>
                      <td colspan="3"><textarea id="sysResource_remark" name="sysResource.remark" rows="5" cols="62" disabled="true"><s:property value="sysResource.remark"/></textarea></td>
                  </tr>
              </table>
          </div>
      </div>
    </form>
</div>
</body>
</html>