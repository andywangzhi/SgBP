<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>

<jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/group/edit.js"></script>	

</head>
<body>
	<div id="mytab" style="width:670px;height:450px;">
		<div title="组信息" style="padding:10px;">
            <form id="frm" method="post">
              <input type="hidden"  name="group.id" value="<s:property value="group.id"/>"/>
              <input type="hidden"  name="group.valid" value="<s:property value="group.valid"/>"/>
              <input type="hidden"  id="manegerIds" name="manegerIds" />
              <input type="hidden"  id="menuIds" name="menuIds"/>
              <table cellpadding=3>
                  <tr>
                     <td width="10%" style="text-align: right;font-size:12px;">名称：</td>
                     <td width="90%" ><input type="text" style="width:445px;" onfocus="onfocusCheck('group_name');" id="group_name" name="group.name"  value="<s:property value="group.name"/>"/><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size:12px;">描述：</td>
                      <td ><textarea  onfocus="onfocusCheck('group_remark');" id="group_remark" name="group.remark" rows="10" cols="53"><s:property value="group.remark"/></textarea></td>
                  </tr>
              </table>
           </form>
		</div>
		<div title="分配成员" style="padding:10px;">
            <iframe scrolling="yes" id="selectGroupManager"  name="selectGroupManager" frameborder="0"  src="<%=path%>/page/include/groupUserManager.jsp?groupId=<s:property value="group.id"/>" style="width:100%;height:100%;"></iframe>
		</div>
		<div title="可控权限"  style="padding:10px;">
			<iframe scrolling="yes" frameborder="0" id="selectGroupRight"  name="selectGroupRight" src="<%=path%>/js/jquery/tree/groupTree.jsp?groupId=<s:property value="group.id"/>" style="width:100%;height:100%;"></iframe>
		</div>
	</div>
    <div border="false" style="text-align: center; height: 30px; margin-top:10px; line-height: 30px;">
        <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
    </div>
</body>
</html>