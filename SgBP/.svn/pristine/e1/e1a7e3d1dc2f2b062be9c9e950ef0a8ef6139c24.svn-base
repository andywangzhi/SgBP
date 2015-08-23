<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>用户组列表</title>
<jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/group/list.js"></script>	
</head>
<div class="main_in">
    <form id="frm" name="frm" method="post">
    <input type="hidden" id="currpage" name="currpage"/>
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; width 20%;font-size:12px;">名称：</td>
                      <td><input width="30%" type="text" id="search_name" name="search_name"/></td>
                      <td style="text-align: right; width 20%;font-size:12px;">描述：</td>
                      <td><input width="30%" type="text" id="search_remark" name="search_remark"/></td>
                      <td style="text-align: right; width 20%;font-size:12px;">状态：</td>
                      <td>
	                     <select id="search_valid" name="search_valid" style="width:155px;">
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