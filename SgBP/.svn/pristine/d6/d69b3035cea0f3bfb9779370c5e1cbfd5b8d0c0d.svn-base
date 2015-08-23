<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>数据字典列表</title>
	<jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/dictionary/list.js"></script>
</head>
<div class="main_in"><body>
    <form id="frm"  name="frm"  method="post">
    <input type="hidden" id="currpage" name="currpage"/>
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; font-size:12px;">编码</td>
                      <td ><input type="text" id="search_code" name="search_code" style="width:80px;"/></td>
                      <td  style="text-align: right; font-size:12px;">名称</td>
                      <td ><input type="text" id="search_name" name="search_name" style="width:80px;"/></td>
                      <td  style="text-align: right; font-size:12px;">类型</td>
                      <td  style="text-align: right;font-size:12px;">
	                     <select id="search_type" name="search_type" style="width:80px;">
	                       <option value="">全部</option>
	                     </select>
                      </td>
                      <td style="text-align: right;font-size:12px;">状态</td>
                      <td  style="text-align: right;font-size:12px;">
	                     <select id="search_valid" name="search_valid" style="width:80px;">
	                       <option value="">全部</option>
	                       <option value="1">已启用</option>
	                       <option value="0">已停用</option>
	                       <option value="2">已删除</option>
	                     </select>
		              </td>
		              <!--  
		              <td  style="text-align: right;font-size:12px;"><input type="checkbox" name="search_sensitive" id="search_sensitive" value="1"/>是否敏感信息</td>
                      -->
                      <td  >
                      <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="queryRecord()">查询</a> 
                      <a class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)" onclick="clearData('frm')">重置</a></td>
                  </tr>
              </table>
          </div>
    </form>

<table id="list"></table>
<script type="text/javascript"> 
		
</script>
</body>
</html>