<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<jsp:include page="../../inc/findTop.jsp"></jsp:include>
<script type="text/javascript"> 
    var path = '<%=path%>'; 
   	$(function(){ 
       $("#userId").bind('keyup',function(){
         $(this).val($(this).val().replace(/[^\w\.\/]/ig,''));
       });
    })
	function queryRecord(){
	   var  userId = $.trim($('#userId').val());  
	   var  userName = $.trim($('#userName').val()); 
	     if( userId == "" && userName == "" ){
	          alert('<s:property value="#application._WEB_SYS_RESOURCE_KEY_.error_noinput[session._CUR_USER_LANG_]"  escape="false"/>');
	        return false;
	     }
	  $("#frm").submit();
	}
    function addRecord(){
      location.href='<%=path%>/soa/user!input.action?menuId=<%=request.getParameter("menuId")%>&dateStr='+(new Date().getTime());
    }
</script>
<div class="divtab">
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	  <td height="40" bgcolor="#FFFFFF">
	  <form id="frm" name="frm" action="<%=path%>/soa/user!query.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
			<table width="769" border="0" cellpadding="1" cellspacing="1"  bgcolor="#CCCCCC">
				<tr>
					<td bgcolor="#FFFFFF" class="table_l"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_userId[session._CUR_USER_LANG_]"/></div></td>
					<td bgcolor="#FFFFFF" class="table_r1"><input class="query" id="userId" name="form.queryListSO.userId" type="text" maxlength="11" value="<s:property value="form.queryListSO.userId"/>"/></td>
					<td bgcolor="#FFFFFF" class="table_l"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_userName[session._CUR_USER_LANG_]"/></div></td>
					<td bgcolor="#FFFFFF" class="table_r1"><input type="text" class="query" id="userName" name="form.queryListSO.userName" value="<s:property value="form.queryListSO.userName"/>"/></td>
				</tr>
			    <tr>
			    <td bgcolor="#FFFFFF" colspan="6" height="30">
			      <div align="center">
				    <img src="<%=path%>/images/bt.jpg" width="71" height="22"  onclick="queryRecord()" style="cursor:pointer"/>
				    <img src="<%=path%>/images/bt_add.jpg" width="71" height="22"  onclick="addRecord()" style="cursor:pointer"/>
				  </div>
			    </td>
			    </tr>
			</table>
		</form>
	 </td>
	</tr>
</table>
<s:if test='tip != ""'>
  <div class="error">
   <p><s:property value="tip"/></p>
  </div>
</s:if>
</div>
<jsp:include page="../../inc/foot.jsp"></jsp:include>