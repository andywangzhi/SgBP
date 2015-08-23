<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
    <title>添加</title>
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/menu/add.js"></script>	
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
     <input type="hidden"  id="menu_valid" name="menu.valid" value="1"/>
     <input type="hidden"  id="dicIds" name="dicIds"/>
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            <table cellpadding=3>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">父菜单：</td>
                    <td style="text-align: left width 30%;">
                        <input id="menu_parentId" name="menu.parentId"  class="easyui-combotree" url="<%=path%>/system/menu!findMenuJsonStr.action" style="width:130px;" ><span style="color:red">*</span>
                    </td>
                    <td style="text-align: right; width 20%;font-size:12px;">编码：</td>
                    <td><input width="30%" type="text" onblur="checkMenuCode();" id="menu_code" onfocus="onfocusCheck('menu_code');" name="menu.code"  /><span style="color:red">*</span></td>
                </tr>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">名称：</td>
                    <td><input width="30%" type="text" id="menu_nameZh" onfocus="onfocusCheck('menu_nameZh');" name="menu.nameZh"  /><span style="color:red">*</span></td>
                    <td style="text-align: right; width 20%;font-size:12px;">繁体名称：</td>
                    <td><input width="30%" type="text" onfocus="onfocusCheck('menu_nameTw');" id="menu_nameTw" name="menu.nameTw"  /><span style="color:red">*</span></td>
                </tr>
                <tr>
                    <td width="20%" style="text-align: right;font-size:12px;">英文名称：</td>
                    <td width="30%" colspan="3"><input type="text" id="menu_nameEn" onfocus="onfocusCheck('menu_nameEn');" name="menu.nameEn"  /><span style="color:red">*</span></td>
                    <%--
                    <td  width="20%" style="text-align: right;font-size:12px;">类别：</td>
                    <td width="30%" >
                    <select id="menu_typeId" name="menu.typeId"  style="width:133px;" >
                      <option value=""></option>
                      <s:iterator value="#request.confList" id="conf">
                         <option value="<s:property value="id"/>"><s:property value="name"/></option>
                      </s:iterator>
                    </select>
                    </td>
                     --%>
                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">URL：</td>
                    <td  width="30%" ><input type="text" id="menu_url" onfocus="onfocusCheck('menu_url');" name="menu.url"  /><span style="color:red">*</span></td>
                    <td style="text-align: right; width 20%;font-size:12px;">图标：</td>
                    <td>
	                    <select id="menu_icon" name="menu.icon" style="width:133px;">
	                      <option value="icon001">icon001</option>
	                      <option value="icon002">icon002</option> 
	                      <option value="icon003">icon003</option>
	                      <option value="icon004">icon004</option> 
	                      <option value="icon005">icon005</option>
	                      <option value="icon006">icon006</option> 
	                      <option value="icon007">icon007</option>
	                      <option value="icon008">icon008</option> 
	                      <option value="icon009">icon009</option>
	                      <option value="icon010">icon010</option> 
	                      <option value="icon011">icon011</option>
	                      <option value="icon012">icon012</option> 
	                    </select> 
                 </td>
                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">排序：</td>
                    <td  width="30%" ><input type="text" id="menu_priority" name="menu.priority"  /><span style="color:red">*</span></td>
                    <td style="text-align: right; width 20%;font-size:12px;">类型：</td>
                    <td>
	                    <select id="menu_model" name="menu.model" style="width:133px;">
	                      <option value="0" selected>系统菜单</option>
	                      <option value="1">非系统菜单</option> 
	                    </select> 
                    </td>
                </tr>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">备注：</td>
                    <td colspan="3"><textarea id="menu_remark" onfocus="onfocusCheck('menu_remark');" name="menu.remark" rows="25" cols="45" style="height:60px;"></textarea></td>
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