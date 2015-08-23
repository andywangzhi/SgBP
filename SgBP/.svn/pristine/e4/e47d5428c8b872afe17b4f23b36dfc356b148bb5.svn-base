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
		function saveData(){
			var attachFile = $('#attachFile').val();
			if(attachFile==""){
				alert("请选择文件\r\n");
				return false;
			}
			$("#frm").ajaxSubmit(
			{
				url: path+"/system/upload!saveFile.action?dateStr="+(new Date()),
				iframe: true,
				success: function(data, status)
				{   
			        var json = eval("("+data+")");
					var listHtml=''; 
					listHtml=listHtml+"<a href='"+path+"/system/upload!downFile.action?attachPath="+json.filePath+"'>"+json.fileName+"</a> &nbsp;&nbsp;<br/>";
					listHtml=listHtml+"<a onclick=delFile('"+json.filePath+"') href='#'>删除</a> &nbsp;&nbsp;";
					$("#fileList").html(listHtml);
				},
				error:function()
				{
					alert("保存失败");
				}
			});
		}
		
		function delFile(filePath){
		  $.ajax({
		     url:"<%=path%>/system/upload!deleteFile.action?attachPath="+filePath+"&datestr="+new Date().getTime(),
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
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                 <tr>
                      <td width="20%" style="text-align: right; font-size: 12px;">文件：</td>
                      <td width="80%">
                        <input type="file" id="attachFile" name="attachFile">
                      </td>
                 </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;"></td>
                      <td>
				          <div align="left" id="fileList"></div>
                      </td>
                  </tr>
              </table>
          </div>
          <div border="false" style="text-align: center; height: 30px;margin-top:10px;  line-height: 30px;">
              <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
          </div>
      </div>
    </form>
</div>
</body>
</html>