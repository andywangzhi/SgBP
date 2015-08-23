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
                      <td  width="20%" style="text-align: right; font-size: 12px;">编码：</td>
                      <td width="80%"><input  type="text" id="dictionary_code" disabled="true"  name="dictionary.code" value="<s:property value="dictionary.code"/>"  style="width:335px;" /></td>
                  </tr>
                  <tr>
                      <td style="text-align: right;  font-size: 12px;">名称：</td>
                      <td><input   type="text" id="dictionary_name"  disabled="true" name="dictionary.name" value="<s:property value="dictionary.name"/>"  style="width:335px;" /></td>
                  </tr>
                  <tr>
                     <td style="text-align: right;  font-size:12px;">类别：</td>
                     <td>
                     <select id="dictionary_typeId" name="dictionary.typeId"   disabled="true"     value="<s:property value="dictionary.typeId"/>"   style="width:335px;" >
                       <s:iterator value="#request.confList" id="conf">
                          <option value="<s:property value="id"/>"  <s:if test="id==dictionary.typeId">selected</s:if>><s:property value="name"/></option>
                       </s:iterator>
                     </select>
                   </td>
                   </tr>
                   <!--  
                   <tr>
                  	<td style="text-align: right;   font-size: 12px;">敏感信息：</td>
                 	  <td >
	                     <select id="dictionary_sensitive" name="dictionary.sensitive"   disabled="true"    value="<s:property value="dictionary.sensitive"/>" style="width:335px;" >
	                       <option value="1">是</option>
	                       <option value="0">否</option>
	                     </select>
                        </td>
                  </tr>
                  -->
                  <tr>
                     <td style="text-align: right;font-size:12px;">关联菜单：</td>
                     <td style="text-align: left;">
                       <select class="easyui-combotree" id="dictionary_menuIds" disabled="true"   name="menuIds" url="<%=path%>/system/menu!findGroupForJsonSec.action?selectedIds=<s:property value="dictionary.menuIds"/>" multiple="true" cascadeCheck="false"  style="width:335px;" ></select>
                     </td>
                  </tr>
                  <tr>
                      <td style="text-align: right;  font-size: 12px;">备注：</td>
                      <td ><textarea id="dictionary_remark" disabled="true" name="dictionary.remark" rows="25" cols="43" style="height:60px;"><s:property value="dictionary.remark"/></textarea></td>
                  </tr>
              </table>
          </div>
      </div>
    </form>
</div>
</body>
</html>