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
    <script type="text/javascript" src="<%=path%>/js/system/role/add.js"></script>			
</head>
<body>

<div id="mytab" style="width:670px;height:450px;">
	<div title="角色信息" style="padding:10px;">
           <form id="frm" method="post">
             <input type="hidden"  id="role_valid" name="role.valid" value="1"/>
             <table cellpadding=3>
                  <tr>
                      <td width="10%" style="text-align: right;font-size:12px;">所在组：</td>
                      <td width="90%"><select id="role_groupId" name="role.groupId" style="width:445px;" ></select><span style="color:red">*</span></td>
                  </tr>  
                  <tr>
                      <td style="text-align: right; font-size:12px;">名称：</td>
                      <td width="30%" ><input type="text" onfocus="onfocusCheck('role_name');" id="role_name" name="role.name" style="width:445px;"/><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size:12px;">描述：</td>
                      <td><textarea id="role_remark" onfocus="onfocusCheck('role_remark');" name="role.remark" rows="10" cols="53" ></textarea></td>
                  </tr>
             </table>
          </form>
	</div>
</div>
<div border="false" style="text-align: center; height: 30px;margin-top:10px;  line-height: 30px;">
    <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
</div>  
</body>
</html>