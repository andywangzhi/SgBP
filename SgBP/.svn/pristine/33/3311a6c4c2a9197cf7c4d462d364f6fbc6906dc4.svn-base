<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>岗位查询</title>
	<script type="text/javascript" src="<%=path%>/js/jquery/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	   
	<link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
	<script type="text/javascript"> 
	    var path = '<%=path%>';
		function getSearch(){
		  	document.getElementById('frm').submit();
		}
		function getRest() {
			document.getElementById('pquarters').value = '';
			document.getElementById('ptrade').value = '';
		}
		
		function preview(param){
			location.href='<%=path%>/soa/previewAction.action?menuId=${menuId}&form.uuid='+param;
		}

		function peronTypeData() {
			this.key,
			this.value
		}
		var personTypeList = new Array();
		var data = null;
		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"11\")" var="var" >
			data = new peronTypeData();
			data.key = '<s:property value="key"/>';
			data.value = '<s:property value="value"/>';
			personTypeList[personTypeList.length] = data;
		</s:iterator>

		String.prototype.Trim = function() { 
			return this.replace(/(^\s*)|(\s*$)/g, ""); 
		}
	</script>
	
	<script type="text/javascript">
		function firstPage() {
			document.getElementById('currentPage').value = 1;
			document.getElementById('frm').submit();
		}
		
		function prePage(curPage) {
			document.getElementById('currentPage').value = (Number(curPage) - 1);
			document.getElementById('frm').submit();
		}
		
		function nextPage(curPage) {
			document.getElementById('currentPage').value = (Number(curPage) + 1);
			document.getElementById('frm').submit();
		}
		
		function endPage(endPage) {
			document.getElementById('currentPage').value = Number(endPage);
			document.getElementById('frm').submit();
		}
	</script>
</head>
<body>
<form id="frm" name="frm" action="<%=path%>/soa/RsPerson!gwQuery.action?menuId=${menuId}" method="post" >  

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：服务管理&nbsp;&gt;&nbsp;岗位查询</div>
</div>
<div class="main_in">
    		<div class="table_edit">
                  <table>
                  	<tr>
                  		<th width="90px;" nowrap="nowrap" style="padding-right: 0px;">行业：</th>
                  		<td>
                  			<select style="width:120px;" id="ptrade" name="form.queryListSO.ptrade" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"8\")" var="var" >
                  				<s:if test="form.queryListSO.ptrade == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		<th width="90px;" nowrap="nowrap" style="padding-right: 0px;">岗位：</th>
                  		<td colspan="1">
                  			<select style="width:120px;" id="pquarters" name="form.queryListSO.pquarters" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" var="var" >
                  				<s:if test="form.queryListSO.pquarters == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  	</tr>
                  	<tr>
                  		<td colspan="4" align="center">
                  			<a class="btn_search" onclick="getSearch()">搜  索</a>&nbsp;&nbsp;
                  			<a class="btn_search" onclick="getRest()">重  置</a>
                  		</td>
                  	</tr>
                  </table>
              </div>
              
              <div class="table_edit" style="height: 340px;">
                  <table>
                      <thead>
                      	  <th nowrap="nowrap"><p align="center">预览</p></th>
                          <th nowrap="nowrap"><p align="center">姓名</p></th>
                          <th nowrap="nowrap"><p align="center">民族</p></th>
                          <th nowrap="nowrap"><p align="center">党派</p></th>
                          <th nowrap="nowrap"><p align="center">公民身份号码</p></th>
                          <th nowrap="nowrap"><p align="center">户口所在地</p></th>
                          <th nowrap="nowrap"><p align="center">通讯地址</p></th>
                          <th nowrap="nowrap"><p align="center">现工作岗位</p></th>
                          <th nowrap="nowrap"><p align="center">现在所在行业</p></th>
                          <th nowrap="nowrap"><p align="center">现在就业单位</p></th>
                          <th nowrap="nowrap"><p align="center">专业名称</p></th>
                          <th nowrap="nowrap"><p align="center">人才类型</p></th>
                          
                      </thead>
                      <tbody class="bg_x">
                      	<s:if test="form.dtoList.size() > 0 ">
				            <s:iterator value="form.dtoList" id="personInfo" status="st">
					              <s:if test="#st.odd"> 
									  <tr align="center"  bgcolor="#FFFFFF" id="trID<s:property value="#st.index" />">
								  </s:if>	
								  <s:else>
									  <tr align="center" class="table_l3" id="trID<s:property value="#st.index" />">
								  </s:else>
								  <td nowrap="nowrap"><a href="javascript:preview('<s:property value="#personInfo.personId"/>');"><img src="<%=path%>/business/images/View_file.gif"/></td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.pname" /></td>
				                  <td nowrap="nowrap">
	                  				<input type="hidden" id="personTypes_<s:property value="#st.index" />" name="personTypes" value="<s:property value="#personInfo.personType" />" />
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"2\")" var="var" >
	                  				<s:if test="#personInfo.pnation == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"3\")" var="var" >
	                  				<s:if test="#personInfo.ppolityvisage == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.idCard" /></td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"6\")" var="var" >
	                  				<s:if test="#personInfo.registeraddrprov == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"7\")" var="var" >
	                  				<s:if test="#personInfo.registeraddrcity == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.messageAddr" /></td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" var="var" >
	                  				<s:if test="#personInfo.pquarters == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"8\")" var="var" >
	                  				<s:if test="#personInfo.ptrade == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.workCompany" /></td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.specialtyName" /></td>
				                  <td nowrap="nowrap" id="perTypeShows_<s:property value="#st.index" />">
					              </td>
					              
			                  	  <script type="text/javascript">
			                  		var index = '<s:property value="#st.index" />';
			                  		var val = '';
			                  		var personType = document.getElementById("personTypes_" + index).value;
			                  		if(personType != null && personType.Trim() != '') {
				                  		var types = personType.split(',');
				                  		for(var i = 0; i < personTypeList.length; i++) {
					                  		var d = personTypeList[i];
					                  		for(var j = 0; j < types.length; j++) {
						                  		var type = types[j];
						                  		if(type != null && type.Trim() != '') {
					                  				if(d.key == type.Trim()) {
					                  					val += d.value;
					                  					val += " ";
					                  				}
						                  		}
					                  		}
				                  		}
			                  		}
			                  		document.getElementById("perTypeShows_" + index).innerHTML = val;
			                  	  </script>
				                  
				                </tr>
				            </s:iterator>
				          </s:if>
				          <s:if test="paging.totalPages > 0">
				          <tr>
				          	<td colspan="12">
				          		<div class="row_l">
				          		<s:if test="paging.currentIndex == 1">
				          			<img src="<%=path%>/business/images/page/ico_p1.gif" width="12" height="11" align="absmiddle" />&nbsp;首页&nbsp;&nbsp;
				          			<img src="<%=path%>/business/images/page/ico_p2.gif" width="12" height="11" align="absmiddle" />&nbsp;上一页&nbsp;&nbsp;
				          		</s:if>
				          		<s:else>
					          	<a href="javascript:firstPage();">
					          		<img src="<%=path%>/business/images/page/ico_p1.gif" width="12" height="11" align="absmiddle" />&nbsp;首页
					          	</a>&nbsp;&nbsp;
					          	<a href="javascript:prePage('<s:property value="paging.currentIndex" />');">
					          		<img src="<%=path%>/business/images/page/ico_p2.gif" width="12" height="11" align="absmiddle" />&nbsp;上一页&nbsp;&nbsp;
					          	</a>
					          	</s:else>
				          		<s:if test="paging.currentIndex == paging.totalPages">
				          			下一页&nbsp;<img src="<%=path%>/business/images/page/ico_p3.gif" width="12" height="11" align="absmiddle" />&nbsp;&nbsp;
				          			尾页&nbsp;<img src="<%=path%>/business/images/page/ico_p4.gif" width="12" height="11" align="absmiddle" />
				          		</s:if>
				          		<s:else>
						          	<a href="javascript:nextPage('<s:property value="paging.currentIndex" />');">
						          	下一页&nbsp;<img src="<%=path%>/business/images/page/ico_p3.gif" width="12" height="11" align="absmiddle" />&nbsp;&nbsp;
						          	</a>
						          	<a href="javascript:endPage('<s:property value="paging.totalPages" />');">
						          	尾页&nbsp;<img src="<%=path%>/business/images/page/ico_p4.gif" width="12" height="11" align="absmiddle" />
						          	</a>
					          	</s:else>
				          		<input type="hidden" id="currentPage" name="paging.currentIndex" value="<s:property value="paging.currentIndex" />"/>
				          		
					          	&nbsp;&nbsp;当前第<s:property value="paging.currentIndex" />页/共<s:property value="paging.totalPages" />页&nbsp;&nbsp;
					          	每页&nbsp;<input type="text" id="pageSize" name="paging.pageSize" value="<s:property value="paging.pageSize" />" maxlength="10" style="width: 50px;text-align: center;" 
				          				onchange="getSearch()" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
				          		条记录/共<span style="color: blue;"><s:property value="paging.totalRecords" /></span>条记录
				          		&nbsp;&nbsp;&nbsp;&nbsp;
				          		</div>
				          	</td>
				          </tr>
				          </s:if>
                      </tbody>
                  </table>
              </div>
</div>

</form>
<script type="text/javascript">
$(document).ready(function(){ 
            var color="#fbfdfe"
            $(".bg_x tr:odd td").css("background-color",color);  //改变偶数行背景色
            $(".data_list tr:odd").attr("bg",color);
            $(".data_list tr:even").attr("bg","#fff");
      })
</script>

</body>
</html>