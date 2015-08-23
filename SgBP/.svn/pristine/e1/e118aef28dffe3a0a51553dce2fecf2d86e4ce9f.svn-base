<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<jsp:include page="../../inc/top.jsp"></jsp:include>
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
    function MbEdit(code){
      location.href='<%=path%>/soa/user!input.action?form.retrieveSO.userId='+code+'&menuId=<%=request.getParameter("menuId")%>';
    } 
    function MbDetail(code){
      var flagUrl = "form.queryListSO.userId="+$('#userId').val()+"&form.queryListSO.userName="+$('#userName').val();
      location.href='<%=path%>/soa/user!view.action?form.retrieveSO.userId='+code+'&menuId=<%=request.getParameter("menuId")%>&'+flagUrl;
    }
    function MbDelete(code){
        if(confirm('确定要删除选择的数据吗?')){
           location.href='<%=path%>/soa/user!delete.action?form.retrieveSO.userId='+code+'&menuId=<%=request.getParameter("menuId")%>';
        }
    }
</script>
<div class="divInit">
  <div style="width:97%; height:70px;">
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
   </div>   

  <table width="97%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
       <table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#AEAEAE">
          <tr align="center"  bgcolor="#e2e2e2">
            <td width="6%"  background="<%=path%>/images/bg.jpg" class="style2"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.index[session._CUR_USER_LANG_]"/></td>
            <td width="20%" background="<%=path%>/images/bg.jpg" class="style2"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_userId[session._CUR_USER_LANG_]"/></td>
            <td width="10%" background="<%=path%>/images/bg.jpg" class="style2"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_userName[session._CUR_USER_LANG_]"/></td>
            <td width="10%" background="<%=path%>/images/bg.jpg" class="style2"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_birthDate[session._CUR_USER_LANG_]"/></td>
            <td width="10%" background="<%=path%>/images/bg.jpg" class="style2"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.user_status[session._CUR_USER_LANG_]"/></td>  
            <td width="10%" background="<%=path%>/images/bg.jpg" class="style2"><div align="center"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.oper[session._CUR_USER_LANG_]"/></td>
          </tr>
         </table>
 </td></tr></table>
   <div class="divscroll" style="height:expression(document.documentElement.clientHeight-146);">
        <table width="97%" border="0" cellpadding="5" cellspacing="1" bgcolor="#AEAEAE">
          <s:if test="form.dtoList.size() > 0 ">
            <s:iterator value="form.dtoList" id="status" status="st">
              <s:if test="#st.odd"> 
				  <tr align="center"  bgcolor="#FFFFFF">
			  </s:if>	
			  <s:else>
				  <tr align="center" class="table_l3">
			  </s:else>
                  <td width="6%"><s:property value="#st.index+1" /></td>
                  <td width="20%" class="alink"><a href="javascript:MbDetail('<s:property value="#status.userId" />');" ><s:property value="#status.userId" /></a></td>
                  <td width="10%"><s:property value="#status.userName" /></td>
                  <td width="10%"><s:property value="#status.birthDate" /></td>
                  <td width="10%"><s:property value="#status.status" /></td>
                  <td width="10%" class="alink"><a href="javascript:MbEdit('<s:property value="#status.userId" />');" ><s:property value="#application._WEB_SYS_RESOURCE_KEY_.edit[session._CUR_USER_LANG_]"/></a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:MbDetail('<s:property value="#status.userId" />');" ><s:property value="#application._WEB_SYS_RESOURCE_KEY_.view[session._CUR_USER_LANG_]"/></a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="javascript:MbDelete('<s:property value="#status.userId" />');" ><s:property value="#application._WEB_SYS_RESOURCE_KEY_.delete[session._CUR_USER_LANG_]"/></a></td>
                </tr>
            </s:iterator>
          </s:if>
        </table>        
</div>
</div>
<jsp:include page="../../inc/foot.jsp"></jsp:include>