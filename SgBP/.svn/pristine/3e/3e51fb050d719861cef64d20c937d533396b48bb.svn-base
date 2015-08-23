<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>用户列表</title>
<jsp:include page="../inc/top.jsp"></jsp:include>

<script type="text/javascript">
	var path='<%=path%>'; 
	var curUserId = <s:property value="#session._USER_LOGIN_.id"/>;
</script>
<script type="text/javascript" src="<%=path%>/js/system/account/list.js"></script>
</head>
<div class="main_in">
    <form id="frm"  name="frm" method="post">
    <input type="hidden" id="currpage" name="currpage"/>
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;font-size:12px">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; font-size:12px;">姓名</td>
                      <td><input width="30%" type="text" id="search_realName" name="search_realName" style="width:100px;" onkeydown="keyDownFun()"/></td>
                      <td style="text-align: right; font-size:12px;">帐号</td>
                      <td><input width="30%" type="text" id="search_name" name="search_name" style="width:100px;" onkeydown="keyDownFun()"/></td>
                      <td style="text-align: right; font-size:12px;">组别</td>
                      <td>
	                     <select id="search_groupId" name="search_groupId" style="width:100px;"  onkeydown="keyDownFun()">
	                       <option value="">全部</option>
	                     </select>
                      </td>
                      <td style="text-align: right; font-size:12px;">状态</td>
                      <td>
	                     <select id="search_valid" name="search_valid" style="width:100px;"  onkeydown="keyDownFun()">
	                       <option value="">全部</option>
	                       <option value="1">已启用</option>
	                       <option value="0">已停用</option>
	                       <option value="2">已删除</option>
	                     </select>
		              </td>
                      <td>
                      <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="queryRecord()">查询</a> 
                      <a class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)" onclick="clearData('frm')">重置</a></td>
                  </tr>
              </table>
          </div>
    </form>
<table id="list"></table>
</body>
</html>