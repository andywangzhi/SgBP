<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>交换日志列表</title>
	<jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/changelog/list.js"></script>
    <script type="text/javascript" src="<%=path%>/js/query/date.js" charset="UTF-8"></script>
</head>
<body>
    <form id="frm"  name="frm"  method="post">
    <input type="hidden" id="currpage" name="currpage"/>
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;z-index: ">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; font-size:12px;">交换时间</td>
                      <td ><input type="text" title="格式为2012-01-01" id="search_accountName" name="search_accountName" style="width:160px;"/></td>
                      
                      <td>
                      <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="queryRecord()">查询</a> 
                      <a class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)" onclick="clearData('frm')">重置</a></td>
                  </tr>
              </table>
          </div>
    </form>
<table id="list" style="z-index: -1"></table>
<script type="text/javascript"> 
</script>
</body>
</html>