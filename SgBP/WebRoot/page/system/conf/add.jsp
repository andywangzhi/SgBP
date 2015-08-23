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
<script type="text/javascript" src="<%=path%>/js/system/conf/add.js"></script>
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
              <table cellpadding=3>
                  <tr>
                      <td width="20%" style="text-align: right; font-size: 12px;">编码：</td>
                      <td width="80%"><input type="text" id="conf_code" onBlur="checkCode();" onfocus="onfocusCheck('conf_code');"  name="conf.code" style="width:335px;" /><span style="color:red">*</span></td>
                 </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">名称：</td>
                      <td><input type="text"  onfocus="onfocusCheck('conf_name');" id="conf_name" name="conf.name" style="width:335px;" /><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                     <td style="text-align: right;font-size:12px;">类别：</td>
                     <td>
                     <select id="conf_typeId" name="conf.typeId"  style="width:335px;;" >
                       <option value="" selected>--请选择--</option>
                       <s:iterator value="#request.confTypeList" id="confType">
                          <option value="<s:property value="id"/>"><s:property value="name"/></option>
                       </s:iterator>
                     </select><span style="color:red">*</span>
                   </td>
                   </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">父节点：</td>
                      <td><input id="conf_parentId" name="conf.parentId"  class="easyui-combotree" url="<%=path%>/system/conf!findConfJsonStr.action" style="width:335px;" ><span style="color:red">*</span></td>
                  </tr>
                 <tr>
                      <td style="text-align: right;font-size: 12px;">排序：</td>
                      <td><input type="text" id="conf_priority" name="conf.priority"  style="width:335px;"/><span style="color:red">*</span></td>
                  </tr>
                  <tr>
                      <td style="text-align: right; font-size: 12px;">备注：</td>
                      <td><textarea id="conf_remark"  onfocus="onfocusCheck('conf_remark');" name="conf.remark" rows="25" cols="43" style="height:335px;"></textarea></td>
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