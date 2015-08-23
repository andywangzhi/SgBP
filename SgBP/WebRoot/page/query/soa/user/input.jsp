<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<jsp:include page="../../inc/top.jsp"></jsp:include>
<script type="text/javascript" src="<%=path%>/js/jquery/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"> 
    var path = '<%=path%>'; 
   	$(function(){ 
       $("#userId").bind('keyup',function(){
         $(this).val($(this).val().replace(/[^\w\.\/]/ig,''));
       });
    })
	function addRecord(){
	   var  userId = $.trim($('#userId').val());  
	   var  userName = $.trim($('#userName').val()); 
	   var  birthDate = $.trim($('#birthDate').val()); 
	   var  status = $.trim($('#status').val()); 
	   if(userId == ""){
	      alert('请输入帐号');
	      return false;
	   }
	   if(userName == "" ){
	      alert('请输入用户名');
	      return false;
	   }
	   if(birthDate == "" ){
	      alert('请选择出生日期');
	      return false;
	   }
	   if(status == "" ){
	      alert('请选择状态');
	      return false;
	   }
	  $("#frm").submit();
	} 
</script>

<div class="divInit">
  <div style="width:97%; height:70px;">
      <form id="frm" name="frm" action="<%=path%>/soa/user!saveOrUpdate.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
		<table width="769" border="0" cellpadding="1" cellspacing="1"  bgcolor="#CCCCCC">
			<tr>
				<td bgcolor="#FFFFFF" class="table_l"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_userId[session._CUR_USER_LANG_]"/></div></td>
				<td bgcolor="#FFFFFF" class="table_r1"><input class="query" id="userId" name="form.dto.userId" type="text" maxlength="11" value="<s:property value="form.dto.userId"/>"/></td>
				<td bgcolor="#FFFFFF" class="table_l"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_userName[session._CUR_USER_LANG_]"/></div></td>
				<td bgcolor="#FFFFFF" class="table_r1"><input type="text" class="query" id="userName" name="form.dto.userName" value="<s:property value="form.dto.userName"/>"/></td>
			</tr>
			<tr>
				<td bgcolor="#FFFFFF" class="table_l"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_birthDate[session._CUR_USER_LANG_]"/></div></td>
				<td bgcolor="#FFFFFF" class="table_r1"><input id="birthDate" name="form.dto.birthDate"   type="text"  readonly="true" class=Wdate onFocus="WdatePicker({maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd'})" value="<s:if test='form.dto.birthDate!=null '><s:property value="form.dto.birthDate"/></s:if>" size="16"/></td>
				<td bgcolor="#FFFFFF" class="table_l"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_status[session._CUR_USER_LANG_]"/></div></td>
				<td bgcolor="#FFFFFF" class="table_r1">
					<select id="status"  name="form.dto.status" style="width:135px;">
					  <option value="1" <s:if test='form.dto.status==null || (form.dto.status!=null && form.dto.status=="1")'>selected</s:if>>在职</option>
					  <option value="2" <s:if test='form.dto.status!=null && form.dto.status=="2"'>selected</s:if>>离任</option>
					  <option value="3" <s:if test='form.dto.status!=null && form.dto.status=="3"'>selected</s:if>>去世</option>
					</select>
				</td>
			</tr>
		    <tr>
			    <td bgcolor="#FFFFFF" colspan="6" height="30">
			      <div align="center">
				    <img src="<%=path%>/images/bt_add.jpg" width="71" height="22"  onclick="addRecord()" style="cursor:pointer"/>
				  </div>
			    </td>
			</tr>
		</table>
      </form>
   </div>   
</div>
<jsp:include page="../../inc/foot.jsp"></jsp:include>