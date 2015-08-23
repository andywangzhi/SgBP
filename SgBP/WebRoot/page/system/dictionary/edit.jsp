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
	<script type="text/javascript" src="<%=path%>/js/system/dictionary/edit.js"></script>
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
      <input type="hidden"  name="dictionary.id" value="<s:property value="dictionary.id"/>"/>
      <input type="hidden"  name="dictionary.valid" value="<s:property value="dictionary.valid"/>"/>
      <input type="hidden"  name="dictionary.sensitive" value="<s:property value="dictionary.sensitive"/>"/>
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td width="20%" style="text-align: right;  font-size: 12px;">编码：</td>
                      <td width="80%"><input  readonly="readonly" type="text" id="dictionary_code"  name="dictionary.code" value="<s:property value="dictionary.code"/>"  style="width:335px;" /><span style="color:red">*</span></td>
                   </tr>
                   <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">名称：</td>
                      <td><input  type="text" id="dictionary_name"  onfocus="onfocusCheck('dictionary_name');" name="dictionary.name" value="<s:property value="dictionary.name"/>"  style="width:335px;" /><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                     <td style="text-align: right;  font-size:12px;">类别：</td>
                     <td>
                     <select id="dictionary_typeId" name="dictionary.typeId"   value="<s:property value="dictionary.typeId"/>"   style="width:335px;" >
                       <s:iterator value="#request.confList" id="conf">
                          <option value="<s:property value="id"/>"  <s:if test="id==dictionary.typeId">selected</s:if>><s:property value="name"/></option>
                       </s:iterator>
                     </select>
                   </td>
                  </tr>
                  <!-- 
                  <tr>
                  	<td style="text-align: right;  font-size: 12px;">敏感信息：</td>
                    <td>
	                     <select id="dictionary_sensitive" name="dictionary.sensitive"  value="<s:property value="dictionary.sensitive"/>"  style="width:335px;" >
	                       <option value="1" <s:if test="dictionary.sensitive==1">selected</s:if>>是</option>
	                       <option value="0" <s:if test="dictionary.sensitive==0">selected</s:if>>否</option>
	                     </select><span style="color:red">*</span>
                        </td>
                  </tr>
                   -->
                  <tr>
                     <td style="text-align: right;font-size:12px;">关联菜单：</td>
                     <td style="text-align: left;">
                       <select class="easyui-combotree" id="dictionary_menuIds" name="menuIds" url="<%=path%>/system/menu!findGroupForJsonSec.action?selectedIds=<s:property value="dictionary.menuIds"/>" multiple="true" cascadeCheck="false"  style="width:335px;" ></select>
                     </td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size: 12px;">备注：</td>
                      <td><textarea id="dictionary_remark"  onfocus="onfocusCheck('dictionary_remark');" name="dictionary.remark" rows="25" cols="43" style="height:60px;"><s:property value="dictionary.remark"/></textarea></td>
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