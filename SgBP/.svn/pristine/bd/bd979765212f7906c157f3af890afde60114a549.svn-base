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
    <script type="text/javascript">
    	var path='<%=path%>';
    	var groupId='<s:property value="role.groupId"/>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/role/view.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
<div id="mytab" style="width:670px;height:450px;">
	<div title="角色信息" style="padding:10px;">
           <form id="frm" method="post">
             <table cellpadding=3>
                 <tr>
                      <td  width="10%" style="text-align: right;font-size:12px;">所在组：</td>
                      <td  width="90%"><select id="role_groupId" name="role.groupId" style="width:445px;"  disabled="true"   value="<s:property value="role.groupId"/>" ></select></td>
                 </tr>
                 <tr>
                      <td style="text-align: right; font-size:12px;">名称：</td>
                      <td ><input type="text" id="role_name" name="role.name"  style="width:445px;" disabled="true"   value="<s:property value="role.name"/>"/></td>
                 </tr>
                 <tr>
                     <td style="text-align: right; font-size:12px;">描述：</td>
                     <td ><textarea id="role_remark" name="role.remark" rows="10" cols="53" disabled="true" ><s:property value="role.remark"/></textarea></td>
                 </tr>
             </table>
          </form>
	</div>
	<div title="角色用户"  style="padding:10px;">
           <iframe scrolling="yes" id="selectUser"  name="selectUser" frameborder="0"  src="<%=path%>/page/include/selectRoleUser.jsp?roleId=<s:property value="role.id"/>&groupId=<s:property value="role.groupId"/>" style="width:100%;height:100%;"></iframe>
	</div>
	<div title="角色权限"  style="padding:10px;">
			<iframe scrolling="yes" frameborder="0" id="selectRoleRight"  name="selectRoleRight" src="<%=path%>/js/jquery/tree/rightTree.jsp?groupId=<s:property value="role.groupId"/>&roleId=<s:property value="role.id"/>" style="width:100%;height:100%;"></iframe>
	
 	</div>
</div>
</body>
</html>