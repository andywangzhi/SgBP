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
    <script type="text/javascript" src="<%=path%>/js/system/resource/add.js"></script>	
</head>
<body>
<div style="background:#fafafa;width:670px;height:450px;">
    <form id="frm" method="post">
    <input type="hidden"  name="sysResource.valid" value="1"/>
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">编码：</td>
                      <td><input width="30%" type="text"  onfocus="onfocusCheck('sysResource_key');" onblur="checkResourceCode();" id="sysResource_key" name="sysResource.key" /><span style="color:red">*</span></td>
                      <td style="text-align: right; width 20%; font-size: 12px;">类型：</td>
                      <td>
	                     <select id="sysResource_useType" name="sysResource.useType" value="<s:property value="sysResource.useType"/>" style="width:120px;">
	                       <option value="1">页面显示</option>
	                       <option value="2">错误提示</option>
	                       <option value="3">信息提示</option>
	                     </select> 
                      </td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">中文名：</td>
                      <td colspan="3"><textarea onfocus="onfocusCheck('sysResource_nameZh');" id="sysResource_nameZh" name="sysResource.nameZh" rows="5" cols="62"></textarea><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">英文名：</td>
                      <td colspan="3"><textarea onfocus="onfocusCheck('sysResource_nameEn');" id="sysResource_nameEn" name="sysResource.nameEn" rows="5" cols="62"></textarea><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">繁体名：</td>
                      <td colspan="3"><textarea onfocus="onfocusCheck('sysResource_nameTw');" id="sysResource_nameTw" name="sysResource.nameTw" rows="5" cols="62"></textarea><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; width 20%; font-size: 12px;">备注：</td>
                      <td colspan="3"><textarea onfocus="onfocusCheck('sysResource_remark');" id="sysResource_remark" name="sysResource.remark" rows="5" cols="62"><s:property value="sysResource.remark"/></textarea></td>
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