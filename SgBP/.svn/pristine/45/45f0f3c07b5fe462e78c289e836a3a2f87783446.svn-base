<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();

%>
<html>
<head>
    <title>查看</title>
    <script type="text/javascript">
    	var path='<%=path%>';
    	var operIds='<s:property value="menu.operIds"/>';
    </script>
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript" src="<%=path%>/js/system/menu/view.js"></script>	
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
	              <table cellpadding=3>
	                  <tr>
	                      <td style="text-align: right; width 20%;font-size:12px;">父菜单：</td>
	                      <td style="text-align: left width 30%;">
	                          <input id="menu_parentId" name="menu.parentId" class="easyui-combotree" disabled="true"   url="<%=path%>/system/menu!findMenuJsonStr.action" value="<s:property value="menu.parentId"/>" style="width:130px;">
	                      </td>
	                      <td style="text-align: right; width 20%;font-size:12px;">编码：</td>
	                      <td><input width="30%" type="text" id="menu_code" name="menu.code"  disabled="true"      value="<s:property value="menu.code"/>"/></td>
	                  </tr>
	                  <tr>
	                      <td style="text-align: right; width 20%;font-size:12px;">名称：</td>
	                      <td><input width="30%" type="text" id="menu_nameZh" name="menu.nameZh"   disabled="true"     value="<s:property value="menu.nameZh"/>"/></td>
	                      <td style="text-align: right; width 20%;font-size:12px;">繁体名称：</td>
	                      <td><input width="30%" type="text" id="menu_nameTw" name="menu.nameTw"    disabled="true"     value="<s:property value="menu.nameTw"/>"/></td>
	                  </tr>
	                  <tr>
	                      <td style="text-align: right; width 20%;font-size:12px;">英文名称：</td>
	                      <td colspan="3"><input width="30%" type="text" id="menu_nameEn" name="menu.nameEn"  disabled="true"     value="<s:property value="menu.nameEn"/>"/></td>
	                      <%--
	                      <td style="text-align: right; width 20%;font-size:12px;">类别：</td>
	                      <td>
		                     <select id="menu_typeId" name="menu.typeId"  style="width:133px;"  disabled="true"    value="<s:property value="menu.typeId"/>" >
		                       <s:iterator value="#request.confList" id="conf">
		                          <option value="<s:property value="id"/>" <s:if test="id==menu.typeId">selected</s:if>><s:property value="name"/></option>
		                       </s:iterator>
		                     </select>
		                  </td>
	                       --%>
	                  </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">URL：</td>
                    <td  width="30%" ><input type="text" id="menu_url" disabled="true"    name="menu.url"  value="<s:property value="menu.url"/>"  /></td>
                    <td style="text-align: right; width 20%;font-size:12px;">图标：</td>
                    <td>
	                     <select id="menu_icon" name="menu.icon" disabled="true"   style="width:133px;">
	                      <option value="icon001" <s:if test='menu.icon=="icon001"'>selected</s:if>>icon001</option>
	                      <option value="icon002" <s:if test='menu.icon=="icon002"'>selected</s:if>>icon002</option> 
	                      <option value="icon003" <s:if test='menu.icon=="icon003"'>selected</s:if>>icon003</option>
	                      <option value="icon004" <s:if test='menu.icon=="icon004"'>selected</s:if>>icon004</option> 
	                      <option value="icon005" <s:if test='menu.icon=="icon005"'>selected</s:if>>icon005</option>
	                      <option value="icon006" <s:if test='menu.icon=="icon006"'>selected</s:if>>icon006</option> 
	                      <option value="icon007" <s:if test='menu.icon=="icon007"'>selected</s:if>>icon007</option>
	                      <option value="icon008" <s:if test='menu.icon=="icon008"'>selected</s:if>>icon008</option> 
	                      <option value="icon009" <s:if test='menu.icon=="icon009"'>selected</s:if>>icon009</option>
	                      <option value="icon010" <s:if test='menu.icon=="icon010"'>selected</s:if>>icon010</option> 
	                      <option value="icon011" <s:if test='menu.icon=="icon011"'>selected</s:if>>icon011</option>
	                      <option value="icon012" <s:if test='menu.icon=="icon012"'>selected</s:if>>icon012</option> 
	                    </select> 
                 </td>
                </tr>
	                <tr>
	                    <td  width="20%" style="text-align: right;font-size:12px;">排序：</td>
	                    <td  width="30%" ><input type="text" id="menu_priority" name="menu.priority"  disabled="true"    value="<s:property value="menu.priority"/>" /></td>
	                    <td style="text-align: right; width 20%;font-size:12px;">类型：</td>
	                    <td>
		                     <select id="menu_model" name="menu.model"    disabled="true"    value="<s:property value="menu.model"/>"  style="width:133px;">
		                       <option value="0"  <s:if test="menu.model==0">selected</s:if>>系统菜单</option>
		                       <option value="1"  <s:if test="menu.model==1">selected</s:if>>非系统菜单</option>
		                     </select>
	                    </td>
	                </tr>
	                  <tr>
	                      <td style="text-align: right; width 20%;font-size:12px;">备注：</td>
	                      <td colspan="3"><textarea id="menu_remark" name="menu.remark"  disabled="true"    rows="25" cols="45" style="height:60px;"><s:property value="menu.remark"/></textarea></td>
	                  </tr>
	              </table>
          </div>
      </div>
</div>
</body>
</html>