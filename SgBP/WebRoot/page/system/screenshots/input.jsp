<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html> 
<head>
    <title>修改</title>
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
		
		
		function save(filePath){
		  $.ajax({
		     url:"<%=path%>/system/screenshots!save.action?datestr="+new Date().getTime(),
		     dataType:"json",
		     success:function(data){
		        alert(data.msg);
		        window.location.reload();
		      }
		   });
		}
    </script>
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<div class="main_in">
<div style="background:#fafafa;">
    <form id="frm" method="post" enctype="multipart/form-data">
      <input type="hidden"  name="moduleId" value="1"/>
      <div border="false" style="text-align: center; height: 30px;margin-top:10px;  line-height: 30px;">
              <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="save()">确定</a> 
      </div>
    </form>
</div>
</body>
</html>