<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	long deptId = 0;
	if(request.getParameter("deptId") != null&&!request.getParameter("deptId").equals("")){
		deptId = Long.parseLong(request.getParameter("deptId"));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>人员选择</title>
<jsp:include page="../system/inc/top.jsp"></jsp:include>
<script language="javascript" type="text/javascript">
	var path='<%=path%>';
	var deptId='<%=deptId%>';
</script>
<script type="text/javascript" src="<%=path%>/js/system/include/selectDeptAccount.js"></script>
<style>
.icon{
	background:url('icons/edit_add.png') no-repeat;
}
</style>
</head>
<body>
<form id="frm" method="post">
  <div  border="false" style="background: #fff; border: 1px solid #ccc;">
    <table cellpadding=5>
        <tr>
            <td style="text-align: right; width 20%;font-size:12px;">搜索类型：
              <select id="search_type" name="search_type" style="width:105px;">
                <option value="1">用户名</option>
                <option value="2">帐号</option>
              </select>
            </td>
            <td><input width="30%" type="text" id="search_name" name="search_name"/></td>
            <td>
              <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="queryRecord()">查询</a> 
            </td>
        </tr>
    </table>
  </div>
</form>
<br/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:12px;">
  <tr align="center">
    <td>待选用户</td>
    <td></td>
    <td>已选用户</td>
  </tr>
  <tr>
    <td width="25%">
      <select name="s0" size="13" id="s0" style="width:185px;height:330px;"></select>
    </td>
    <td align="center"><img name="addall" id="addall" src="<%=path %>/images/right3.gif"/><br /><br />
     <img name="add" id="add" src="<%=path %>/images/right2.gif"/><br /><br />
     <img name="remove" id="remove" src="<%=path %>/images/left2.gif"/><br /><br />
     <img  name="removeall" id="removeall"  src="<%=path %>/images/left3.gif"/>
    </td>
    <td width="25%"><select name="s1" size="13" multiple="multiple" id="s1" style="width:185px;height:330px;"></select></td>
  </tr>
</table>
</body>
</html>

