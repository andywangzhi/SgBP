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
<script type="text/javascript" src="<%=path%>/js/system/dept/add.js"></script>
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
	<div id="mytab" style="width:670px;height:450px;">
		<div title="科室信息" style="padding:10px;">
            <form id="frm" method="post">
             <input type="hidden"  id="accountIds" name="accountIds" />
              <table cellpadding=3>
                  <tr>
                      <td width="20%" style="text-align: right; font-size: 12px;">编码：</td>
                      <td width="80%"><input type="text" id="dept_code" onBlur="checkCode();" onfocus="onfocusCheck('dept_code');"  name="dept.code" style="width:335px;" /><span style="color:red">*</span></td>
                 </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">名称：</td>
                      <td><input type="text"  onfocus="onfocusCheck('dept_nameCN');" id="dept_nameCN" name="dept.nameCN" style="width:335px;" /><span style="color:red">*</span></td>
                  </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">父节点：</td>
                      <td><input id="dep_parentId" name="dept.parentId"  class="easyui-combotree" url="<%=path%>/system/dept!findDeptJsonStr.action" style="width:335px;" ><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size: 12px;">备注：</td>
                      <td><textarea id="dept_remark"  onfocus="onfocusCheck('dept_remark');" name="dept.remark" rows="25" cols="43" style="height:285px;"></textarea></td>
                  </tr>
              </table>
           </form>
		</div>
		<div title="科室成员" style="padding:10px;">
            <iframe scrolling="yes" id="selectDeptAccount"  name="selectDeptAccount" frameborder="0"  src="<%=path%>/page/include/selectDeptAccount.jsp" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
    <div border="false" style="text-align: center; height: 30px; margin-top:10px; line-height: 30px;">
        <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
    </div>
</body>
</html>