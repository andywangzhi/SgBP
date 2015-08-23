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
		$(function(){
			$('#mytab').tabs({});
		});	
	</script>
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
	<div id="mytab" style="width:670px;height:450px;">
		<div title="科室信息" style="padding:10px;">
            <form id="frm" method="post">
              <table cellpadding=3>
                  <tr>
                      <td width="20%" style="text-align: right; font-size: 12px;">编码：</td>
                      <td width="80%"><input type="text" disabled="true" id="dept_code" name="dept.code" value="<s:property value="dept.code"/>" style="width:335px;" /></td>
                 </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">名称：</td>
                      <td><input type="text"  disabled="true" id="dept_nameCN" name="dept.nameCN" value="<s:property value="dept.nameCN"/>" style="width:335px;" /></td>
                  </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">父节点：</td>
                      <td><input id="dept_parentId" name="dept.parentId"  class="easyui-combotree" url="<%=path%>/system/dept!findDeptJsonStr.action" style="width:335px;"  disabled="true" value="<s:property value="dept.parentId"/>"></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size: 12px;">备注：</td>
                      <td><textarea id="dept_remark"  disabled="true"  name="dept.remark" rows="25" cols="43" style="height:285px;"><s:property value="dept.remark"/></textarea></td>
                  </tr>
              </table>
           </form>
		</div>
		<div title="科室成员" style="padding:10px;">
            <iframe scrolling="yes" id="selectDeptAccount"  name="selectDeptAccount" frameborder="0"  src="<%=path%>/page/include/selectDeptAccount.jsp?deptId=<s:property value="dept.id"/>" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
</body>
</html>