<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>审核人才信息</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/query/date.js" charset="UTF-8"></script>
    
    <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
	<script type="text/javascript"> 
		String.prototype.replaceAll = function(s1,s2) { 
		    return this.replace(new RegExp(s1,"gm"),s2); 
		}
		
	    var path = '<%=path%>';
		function getSearch(){
			var _fromDate = $("#fromDate").val();
			var _toDate = $("#toDate").val();
			var flag=true;
			if((_fromDate!=null&&_fromDate!="")&&(_toDate!=null&&_toDate!="")){
				//将时间转成数字进行对比
				var fromDate=getDate(_fromDate);
				var toDate=getDate(_toDate);
				if(parseInt(fromDate)>parseInt(toDate)){
					flag=false;
					alert("开始日期不能大于结束日期！");
				}
			}
			if(flag){
				document.getElementById('frm').action = '<%=path%>/soa/RsPerson!shQuery.action?menuId=${menuId}';
				document.getElementById('frm').submit();
			}
		}
		    	function getDate(date){
    		 var dates = date.split("-");
    		 var dateReturn = '';
    		 
    		 for(var i=0; i<dates.length; i++){
    		  if(dates[i].length<2){
	    		 	dates[i]="0"+dates[i];
	    		 }
    		  dateReturn+=dates[i];
    		 }
    		 return dateReturn;
    		}
		
		function getRest() {
			document.getElementById('pname').value = '';
			document.getElementById('idCard').value = '';
			document.getElementById('personType').value = '';
			document.getElementById('fromDate').value = '';
			document.getElementById('toDate').value = '';
			document.getElementById('auditstate').value = '';
		}
		
		function vidOk() {
			var selectInt = checkSelect('1');
			if(selectInt == 0) {
				alert('请选择记录');
			} else {
				document.getElementById('frm').action = '<%=path%>/soa/RsPerson!uShState.action?menuId=${menuId}';
				document.getElementById('frm').submit();
			}
		}
		
		function preview(param){
			location.href='<%=path%>/soa/previewAction.action?menuId=${menuId}&form.uuid='+param;
		}

		function checkSelect(tmp) {
			var selectInt = 0;
			var _input = document.getElementsByTagName('input');
			for(var i = 0; i < _input.length; i++) {
				if(_input[i].type == 'checkbox') {
					var cb = _input[i];
					if(cb.checked) {
						if(tmp == '2') {
							if(cb.value == '121') {
								cb.value = '122';
							} else if(cb.value == '111') {
								cb.value = '112';
							} else if(cb.value == '101') {
								cb.value = '102';
							}
						}
						selectInt ++;
					}
				}
			}
			return selectInt;
		}

		function vidFail() {
			var selectInt = checkSelect('2');
			if(selectInt == 0) {
				alert('请选择记录');
			} else {
				document.getElementById('frm').action = '<%=path%>/soa/RsPerson!uShState.action?menuId=${menuId}';
				document.getElementById('frm').submit();
			}
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
			document.getElementById('frm').action = '<%=path%>/soa/RsPerson!shQuery.action?menuId=${menuId}';
			document.getElementById('currentPage').value = 1;
			document.getElementById('frm').submit();
		}
		
		function prePage(curPage) {
			document.getElementById('frm').action = '<%=path%>/soa/RsPerson!shQuery.action?menuId=${menuId}';
			document.getElementById('currentPage').value = (Number(curPage) - 1);
			document.getElementById('frm').submit();
		}
		
		function nextPage(curPage) {
			document.getElementById('frm').action = '<%=path%>/soa/RsPerson!shQuery.action?menuId=${menuId}';
			document.getElementById('currentPage').value = (Number(curPage) + 1);
			document.getElementById('frm').submit();
		}
		
		function endPage(endPage) {
			document.getElementById('frm').action = '<%=path%>/soa/RsPerson!shQuery.action?menuId=${menuId}';
			document.getElementById('currentPage').value = Number(endPage);
			document.getElementById('frm').submit();
		}
	</script>
</head>
<body>
<form id="frm" name="frm" action="<%=path%>/soa/RsPerson!uShState.action?menuId=${menuId}" method="post" >  

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：个人信息审核&nbsp;&gt;&nbsp;审核</div>
</div>
<div class="main_in">
              <div class="table_edit">
                  <table>
                  	<tr>
                  		<th nowrap="nowrap" style="padding-right: 0px;">姓名：</th>
                  		<td><input type="text" id="pname" name="form.queryListSO.pname" value="<s:property value="form.queryListSO.pname" />" /></td>
                  		<th nowrap="nowrap" style="padding-right: 0px;">身份证号：</th>
                  		<td><input type="text" id="idCard" name="form.queryListSO.idCard" value="<s:property value="form.queryListSO.idCard" />" /></td>
                  	</tr>
                  	<tr>
                  		<th nowrap="nowrap" style="padding-right: 0px;">人才类型：</th>
                  		<td>
                  			<select id="personType" name="form.queryListSO.personType" style="width: 150px;">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"11\")" var="var" >
                  				<s:if test="form.queryListSO.personType == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		<th nowrap="nowrap" style="padding-right: 0px;">审核状态：</th>
                  		<td>
                  			<select id="auditstate" name="form.queryListSO.auditstate" style="width: 150px;">
                  				<option value="">请选择</option>
                  				<option value="111" <s:if test="form.queryListSO.auditstate == \"111\"">selected="selected"</s:if>>已验证已通过已审核已通过</option>
                  				<option value="112" <s:if test="form.queryListSO.auditstate == \"112\"">selected="selected"</s:if>>已验证已通过已审核未通过</option>
                  				<option value="121" <s:if test="form.queryListSO.auditstate == \"121\"">selected="selected"</s:if>>已验证未通过已审核已通过</option>
                  				<option value="122" <s:if test="form.queryListSO.auditstate == \"122\"">selected="selected"</s:if>>已验证未通过已审核未通过</option>
                  				<option value="101" <s:if test="form.queryListSO.auditstate == \"101\"">selected="selected"</s:if>>未验证已审核已通过</option>
                  				<option value="102" <s:if test="form.queryListSO.auditstate == \"102\"">selected="selected"</s:if>>未验证已审核未通过</option>
                  				<option value="1%0" <s:if test="form.queryListSO.auditstate == \"1%0\"">selected="selected"</s:if>>未审核</option>
                  			</select>
                  		</td>
                  	</tr>
                  	<tr>
                  		<th nowrap="nowrap" style="padding-right: 0px;">审核日期-开始日期：</th>
                  		<td><input type="text" id="fromDate" readonly="readonly" onfocus="HS_setDate(this)" name="form.queryListSO.fromDate" value="<s:property value="form.queryListSO.fromDate" />" /></td>
                  		<th nowrap="nowrap" style="padding-right: 0px;">审核日期-结束日期：</th>
                  		<td><input type="text" id="toDate" readonly="readonly" onfocus="HS_setDate(this)" name="form.queryListSO.toDate" value="<s:property value="form.queryListSO.toDate" />" /></td>
                  	</tr>
                  	<tr>
                  		<td colspan="4" align="center">
                  			<a class="btn_search" onclick="getSearch();"> 搜 索 </a>&nbsp;&nbsp;
                  			<a class="btn_search" onclick="getRest()"> 重 置 </a>
                  		</td>
                  	</tr>
                  </table>
              </div>
               
              <div class="table_edit" style="height: 290px;">
                  <table id="allDatas">
                      <thead>
                          <th nowrap="nowrap"><p align="center">选择</p></th>     
                          <th nowrap="nowrap"><p align="center">预览</p></th>          
                          <th nowrap="nowrap"><p align="center">验证状态</p></th>            
                          <th nowrap="nowrap"><p align="center">审核状态</p></th> 
                          <th nowrap="nowrap"><p align="center">姓名</p></th>         
                          <th nowrap="nowrap"><p align="center">性别</p></th>
                          <th nowrap="nowrap"><p align="center">民族</p></th>
                          <th nowrap="nowrap"><p align="center">党派</p></th>
                          <th nowrap="nowrap"><p align="center">公民身份号码</p></th>
                          <th nowrap="nowrap"><p align="center">户口所在地</p></th>
                          <th nowrap="nowrap"><p align="center">通讯地址</p></th>
                          <th nowrap="nowrap"><p align="center">现工作岗位</p></th>
                          <th nowrap="nowrap"><p align="center">现在就业单位</p></th>
                          <th nowrap="nowrap"><p align="center">专业名称</p></th>
                          <th nowrap="nowrap"><p align="center">人才类型</p></th>
                          <th nowrap="nowrap"><p align="center">审核状态</p></th>
                          
                      </thead>
                      <tbody class="bg_x">
                      	<s:if test="form.dtoList.size() > 0 ">
				            <s:iterator value="form.dtoList" id="personInfo" status="st">
								  <tr align="center" class="table_l3">
								  <td nowrap="nowrap">
								  	<s:if test="#personInfo.auditstate == \"111\"">
								  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="111" disabled="disabled"/>
									</s:if>
									<s:elseif test="#personInfo.auditstate == \"121\"">
										<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="121" disabled="disabled"/>
									</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"101\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="101" disabled="disabled"/>
				                  	</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"122\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="121" />
				                  	</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"112\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="111" />
				                  	</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"102\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="101" />
				                  	</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"100\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="101" />
				                  	</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"120\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="121" />
				                  	</s:elseif>
				                  	<s:elseif test="#personInfo.auditstate == \"110\"">
				                  		<input type="checkbox" name="form.dtoList[<s:property value="#st.index" />].auditstate" value="111" />
				                  	</s:elseif>
	                  				<input type="hidden" id="personTypes_<s:property value="#st.index" />" name="personTypes" value="<s:property value="#personInfo.personType" />" />
								  	<input type="hidden" name="form.dtoList[<s:property value="#st.index" />].personId" value="<s:property value="#personInfo.personId" />"/>
								  </td>
								  <td nowrap="nowrap"><a href="javascript:preview('<s:property value="#personInfo.personId"/>');"><img src="<%=path%>/business/images/View_file.gif"/></td>
				                  <td nowrap="nowrap">
				                  	<s:if test="#personInfo.auditstate == \"111\" || #personInfo.auditstate == \"112\" || #personInfo.auditstate == \"110\""><font color="green">已验证已通过</font></s:if>
				                  	<s:elseif test="#personInfo.auditstate == \"120\" || #personInfo.auditstate == \"121\" || #personInfo.auditstate == \"122\"">
				                  		已验证未通过
				                  	</s:elseif>
				                  	<s:else>
				                  		<font color="red">未验证</font>
				                  	</s:else>
				                  </td>
				                  <td nowrap="nowrap">
				                  	<s:if test="#personInfo.auditstate == \"111\" || #personInfo.auditstate == \"101\" || #personInfo.auditstate == \"121\""><font color="green">已审核已通过</font></s:if>
				                  	<s:elseif test="#personInfo.auditstate == \"112\" || #personInfo.auditstate == \"102\" || #personInfo.auditstate == \"122\"">已审核未通过</s:elseif>
				                  	<s:else>
				                  		<font color="red">未审核</font>
				                  	</s:else>
				                  </td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.pname" /></td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" var="var" >
	                  				<s:if test="#personInfo.psex == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap">
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
					               <td nowrap="nowrap" align="center">
			                          <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"63\")" id="id" status="st">
		                                 <s:if test="#personInfo.auditstate==key">
		                              	  	 <s:property value="value"/>
		                              	 </s:if>
			                         </s:iterator>
		                          </td>
					              
				                </tr>
				            </s:iterator>
				          </s:if>
				          <s:if test="paging.totalPages > 0">
				          <tr>
				          	<td colspan="16">
				          		<div class="row_l">
				          		<a class="btn_search" onclick="vidOk();">审核通过</a>&nbsp;&nbsp;
				          		<a class="btn_search" onclick="vidFail();">审核未通过</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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