<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>"/>
    <title>人员基本信息搜索</title>

    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
	<script type="text/javascript" src="js/jquery/jquery-1.4.4.min.js"></script>
	<!-- 	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> 因为插件不兼容 -->
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="js/query/rcsm/base/jbxx.js"></script>
    <link rel="stylesheet" type="text/css" href="business/css/reset.css" />
    <style type="text/css">
	.window .window-header .panel-tool{	display:none}
		h2 {
		    font-size:18px;
		    color:#333;
		    font-weight:bold;
		    margin:0;
		    margin-bottom:15px;
		}
		.demo-info{
			background:#FFFEE6;
			color:#8F5700;
			padding:12px;
		}
		.demo-tip{
			width:24px;
			height:16px;
			float:left;
		}

	</style>
    
	<script type="text/javascript">
    	var path = '<%=path%>'; 
    	var menuId='<%=request.getParameter("menuId")%>';
// 删除启用申请
function deleApplyState(){
	var selectInt = checkSelect("1");
	if(selectInt == 0) {
		alert('请选择记录！');
	} else if(selectInt == -1) {
		alert('请选择已删除的记录！');
	} else if(selectInt == -11) {
		alert('请选择未申请的记录！');
	} else {
		<%-- document.getElementById('frm').action = '<%=path%>/soa/RsPerson!delSqState.action?menuId=${menuId}';
		document.getElementById('frm').submit(); --%>
		
		
		$("#frm").ajaxSubmit({
			url: path+'/soa/RsPerson!delSqState.action?menuId='+menuId,
			dataType:"json",
			success: function(data, status)
			{   
				var flag=data.flag;
		        if(flag=="1"){
		        	alert("删除启用,申请成功！");
		        	search();
		        }else if(flag=="2"){
		        	alert("删除启用,申请失败！");
		        }
			},
			error:function()
			{
				alert("删除启用,申请失败！");
			}
		});
	}
}
// 审核启用申请
function auditApplyState(){
	var selectInt = checkSelect("2");
	if(selectInt == 0) {
		alert('请选择记录！');
	} else if(selectInt == -2) {
		alert('请选择审核过的记录！');
	} else if(selectInt == -22) {
		alert('请选择未申请的记录！');
	} else {
	
	<%-- 	document.getElementById('frm').action = '<%=path%>/soa/RsPerson!shSqState.action?menuId=${menuId}';
		document.getElementById('frm').submit(); --%>
		
		$("#frm").ajaxSubmit({
			url: path+'/soa/RsPerson!shSqState.action?menuId='+menuId,
			dataType:"json",
			success: function(data, status)
			{   
				var flag=data.flag;
		        if(flag=="1"){
		        	alert("审核启用，申请成功！");
		        	search();
		        }else if(flag=="2"){
		        	alert("审核启用，申请失败！");
		        }
			},
			error:function()
			{
				alert("审核启用，申请失败！");
			}
		});
	}
}
// tem=1删除启用申请，tem=2审核删除启用
function checkSelect(tem) {
	var selectInt = 0;
	var _input = document.getElementsByTagName('input');
	for(var i = 0; i < _input.length; i++) {
		if(_input[i].type == 'checkbox') {
			var cb = _input[i];
			if(cb.checked) {
				if(tem=='1'){
					var _delState = document.getElementById(cb.id.replace("personId","delestate")).value;
					var _deleapplystate = document.getElementById(cb.id.replace("personId","deleapplystate")).value;
					
					if(_delState!='1'){
						return -1;
					}
					if(_deleapplystate=='1'){
						return -11;
					}
				}else if(tem=='2'){
					var _auditstate = document.getElementById(cb.id.replace("personId","auditstate")).value;
					var _auditapplystate = document.getElementById(cb.id.replace("personId","auditapplystate")).value;
					
					if(_auditstate.substring(2,3)==0){
						return -2;
					}
					if(_auditapplystate=='1'){
						return -22;
					}
				}
				selectInt ++;
			}
		}
	}
	return selectInt;
}


	// 重置
	function getRest(){
		document.getElementById('pname').value = '';
		document.getElementById('psex').value = '';
		document.getElementById('adduser').value = '';
		document.getElementById('delestate').value = '0';
		document.getElementById('auditstate').value = '';
		document.getElementById('idCard').value = '';
		document.getElementById('sourcetype').value = '';
		document.getElementById('batchcode').value = '';
	}
    </script>

  </head>
  
  <body>
<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：人员信息维护&nbsp;&gt;&nbsp;基本信息维护</div>
    
</div>

<div class="main_in">

      <form id="frm" name="frm" action="<%=path%>/soa/RsPerson!query.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
              <div class="table_edit" style="border: 0px;">
                  <table>
                      <tbody>
                          <tr>
                              <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">姓名：</th>
                              <td><input style="width:136px;" id="pname" name="form.queryListSO.pname" type="text" value="<s:property value="form.queryListSO.pname" />" class="inp" /></td>
                              <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">性别：</th>
                              <td>
                             	 <select style="width:70px;" id="psex" name="form.queryListSO.psex" class="inp">
                             	 	<option value="" nowrap="nowrap">请选择</option>
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" var="var" >
		                  				<s:if test="form.queryListSO.psex == key">
		                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                  				</s:if>
		                  				<s:else>
		                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
		                  				</s:else>
	                  				</s:iterator>
                  				 </select>
							   </td>
							   <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">删除状态：</th>
                              <td>
	                               <select style="width:70px;" id="delestate" name="form.queryListSO.delestate" class="inp">
	                               		<s:if test="form.queryListSO.delestate==null||form.queryListSO.delestate==''">
	                               			<option value="" selected="selected">请选择</option>
	                               			<option value="0">未删除</option>
		                               		<option value="1">已删除</option>
	                               		</s:if>
	                               		<s:elseif test="form.queryListSO.delestate==0">
		                               		<option value="">请选择</option>
	                               			<option value="0" selected="selected">未删除</option>
		                               		<option value="1">已删除</option>
	                               		</s:elseif>
	                               		<s:else>
		                               		<option value="">请选择</option>
	                              			<option value="0">未删除</option>
		                               		<option value="1" selected="selected">已删除</option>
                              			</s:else>
	                               		
	                               </select>
                              </td>
                              
                              <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">批次号：</th>
                              <td><input style="width:170px;" id="batchcode" name="form.queryListSO.batchcode" type="text" value="<s:property value="form.queryListSO.batchcode" />" class="inp" />
                              </td>
                           </tr>


							<tr>
							  <th nowrap="nowrap" style="padding-right: 0px;">公民身份号码：</th>
                              <td ><input style="width:136px;" id="idCard" name="form.queryListSO.idCard" type="text" value="<s:property value="form.queryListSO.idCard" />" class="inp" /></td>
                                                            
                              <th nowrap="nowrap" style="padding-right: 0px;">数据来源：</th>
                              <td>
                             	 <select style="width:70px;" id="sourcetype" name="form.queryListSO.sourcetype" class="inp">
	                  				    <s:if test="form.queryListSO.sourcetype==null||form.queryListSO.sourcetype==''">
	                               			<option value="" selected="selected">请选择</option>
	                               			<option value="1">录入</option>
		                               		<option value="2">导入</option>
		                               		<option value="3">交换</option>
	                               		</s:if>
	                               		<s:elseif test="form.queryListSO.sourcetype==1">
		                               		<option value="">请选择</option>
	                               			<option value="1" selected="selected">录入</option>
		                               		<option value="2">导入</option>
		                               		<option value="3">交换</option>
	                               		</s:elseif>
	                               		<s:elseif test="form.queryListSO.sourcetype==2">
		                               		<option value="">请选择</option>
		                               		<option value="1">录入</option>
	                               			<option value="2" selected="selected">导入</option>
		                               		<option value="3">交换</option>
	                               		</s:elseif>
	                               		<s:else>
		                               		<option value="">请选择</option>
	                               			<option value="1">录入</option>
	                               			<option value="2">导入</option>
	                               			<option value="3" selected="selected">交换</option>
                              			</s:else>
                  				 </select>
							   </td>
							   
                              <th nowrap="nowrap" style="padding-right: 0px;">审核状态：</th>
                              <td>
                              	<%--  <select style="width:70px;" id="auditstate" name="form.queryListSO.auditstate" class="inp">
	                  				<option value="" <s:if test="null==form.queryListSO.auditstate || form.queryListSO.auditstate.length==0">selected="selected"</s:if>>请选择</option>
                              		<option value="0" <s:if test="form.queryListSO.auditstate.indexOf('0')==0">selected="selected"</s:if>>否</option>
                               		<option value="1" <s:if test="form.queryListSO.auditstate==1">selected="selected"</s:if>>是</option>
                  				 </select>  --%>
                  				 
                  			<select id="auditstate" name="form.queryListSO.auditstate" style="width: 250px;" class="inp">
                  				<option value="">请选择</option>
                  				<option value="000" <s:if test="form.queryListSO.auditstate == \"000\"">selected="selected"</s:if>>未比对未验证未审核</option>
                  				<option value="200" <s:if test="form.queryListSO.auditstate == \"200\"">selected="selected"</s:if>>比对未通过未验证未审核</option>
                  				<option value="100" <s:if test="form.queryListSO.auditstate == \"100\"">selected="selected"</s:if>>比对已通过未验证未审核</option>
                  				<option value="120" <s:if test="form.queryListSO.auditstate == \"120\"">selected="selected"</s:if>>比对已通过已验证未通过未审核</option>
                  				<option value="110" <s:if test="form.queryListSO.auditstate == \"110\"">selected="selected"</s:if>>比对已通过已验证已通过未审核</option>
                  				<option value="111" <s:if test="form.queryListSO.auditstate == \"111\"">selected="selected"</s:if>>比对已通过已验证已通过审核已通过</option>
                  				<option value="112" <s:if test="form.queryListSO.auditstate == \"112\"">selected="selected"</s:if>>比对已通过已验证已通过审核未通过</option>
                  				<option value="101" <s:if test="form.queryListSO.auditstate == \"101\"">selected="selected"</s:if>>比对已通过未验证审核已通过</option>
                  				<option value="102" <s:if test="form.queryListSO.auditstate == \"102\"">selected="selected"</s:if>>比对已通过未验证审核未通过</option>
                  				<option value="121" <s:if test="form.queryListSO.auditstate == \"121\"">selected="selected"</s:if>>比对已通过已验证未通过审核已通过</option>
                  			</select>
                  			</td>
                               <th nowrap="nowrap" style="padding-right: 0px;">经办人：</th>
                               <td>
                              		<input  style="width:170px;" id="adduser" name="form.queryListSO.adduser" type="text" value="<s:property value="form.queryListSO.adduser" />" class="inp" />
                               </td>
                           </tr>
                      </tbody>
						<tfoot>
                          <tr><td colspan="8" style="padding-top: 5px;">
                          <a href="javascript:search();" class="btn_search" >搜 索</a>
                  			<a class="btn_search" onclick="getRest()">重  置</a>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
              
              
              
<div class="row_l web_paht_l tool" style="width: 100%;height: 25px;margin-left: 0px;padding-left: 0px;">
	<a href="<%=path%>/soa/RsPerson!toaddPage.action?menuId=<%=request.getParameter("menuId")%>" class="plus" style="margin-left: 0px;">新增</a>
	<a href="<%=path%>/file/人才名册.xls" class="page_excel">批量导入模板</a>
	<a href="<%=path%>/file/采集表.doc" class="page_word">采集表</a>
	<a href="javascript:openUpload();" class="up">Word导入</a>
    <a href="javascript:deleApplyState();" class="archives">&nbsp;删除启用申请&nbsp;</a>
    <a href="javascript:auditApplyState();" class="bluebook">&nbsp;审核启用申请&nbsp;</a>
</div>           
            
              <div class="table_edit" style="height: 288px;">
                  <table>
                      <thead>
                          <tr>
                          	  <th nowrap="nowrap"><p align="center">选择</p></th>
                          	  <th nowrap="nowrap"><p align="center">预览</p></th>
                          	  <th nowrap="nowrap"><p align="center">操作</p></th>
                              <th nowrap="nowrap"><p align="center">姓名</p></th>
                              <th nowrap="nowrap"><p align="center">性别</p></th>
                              <th nowrap="nowrap"><p align="center">公民身份号码</p></th>
                              <th nowrap="nowrap"><p align="center">政治面貌</p></th>
                              <th nowrap="nowrap"><p align="center">文化程度</p></th>
                              <th nowrap="nowrap"><p align="center">联系电话</p></th>
                              <th nowrap="nowrap"><p align="center">电子邮箱</p></th>
                              <th nowrap="nowrap"><p align="center">删除状态</p></th>
                              <th nowrap="nowrap"><div style="width:110px;"><p align="center">审核状态</p></div></th>
                              <th nowrap="nowrap"><p align="center">经办人</p></th>
                              <th nowrap="nowrap"><p align="center">经办时间</p></th>
                              <th nowrap="nowrap"><p align="center">审核人</p></th>
                              <th nowrap="nowrap"><p align="center">审核时间</p></th>
                              <th nowrap="nowrap"><p align="center">数据来源</p></th>
                              <th nowrap="nowrap"><p align="center">删除申请</p></th>
                              <th nowrap="nowrap"><p align="center">审核申请</p></th>
                              
                          </tr>
                      </thead>
                      <tbody id="dataBody" class="bg_x">
                       <s:if test="form.dtoList.size() > 0 ">
	                      <s:iterator value="form.dtoList" id="status" status="st">
	                          <tr>
	                          	  <td align="center">
	                              	<input id="form.dtoList[<s:property value="#st.index" />].personId" type="checkbox" name="form.dtoList[<s:property value="#st.index" />].personId" value="<s:property value="#status.personId" />"/>
	                              	<input id="form.dtoList[<s:property value="#st.index" />].delestate" type="hidden" value="<s:property value="#status.delestate" />"/>
	                              	<input id="form.dtoList[<s:property value="#st.index" />].auditstate" type="hidden" value="<s:property value="#status.auditstate" />"/>
								  
	                              	<input id="form.dtoList[<s:property value="#st.index" />].deleapplystate" type="hidden" value="<s:property value="#status.deleapplystate" />"/>
	                              	<input id="form.dtoList[<s:property value="#st.index" />].auditapplystate" type="hidden" value="<s:property value="#status.auditapplystate" />"/>
								  </td>
	                          	  <td align="center">
	                                 <a href="javascript:preview('<s:property value="#status.personId"/>','<s:property value="#status.pname"/>','<s:property value="#status.idCard"/>','<s:property value="#status.auditstate"/>');"><img src="business/images/View_file.gif"/></a>
	                              </td>
	                               <td align="center">
	                               <s:if test="#status.delestate==1">
	                             		修改
	                               </s:if>
	                               <s:else>
	                               <a href="javascript:toEdit('<s:property value="#status.personId"/>');"><font color="red">修改</font></a>
	                               </s:else>
	                               <s:if test="#status.delestate==1">
	                             		删除
	                               </s:if>
	                               <s:else>
	                               	<s:if test="#status.auditstate=='000'||#status.auditstate=='200'||#status.auditstate=='100'||#status.auditstate==null">
	                               		<a href="javascript:toDelete('<s:property value="#status.personId"/>');"><font color="red">删除</font></a>
	                               	</s:if>
	                               	<s:else>删除</s:else>
	                               </s:else>
	                              </td>
	                              <td align="center" nowrap="nowrap"><s:property value="#status.pname" /></td>
	                              <td align="center" nowrap="nowrap">
	                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" var="var" >
		                  				<s:if test="#status.psex == key">
		                  					<s:property value="value"/>
		                  				</s:if>
		                  		  </s:iterator>
		                  		  </td>
	                              <td align="center" nowrap="nowrap"><s:property value="#status.idCard" /></td>
	                              <td align="center" nowrap="nowrap">
	                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"3\")" var="var" >
		                  				<s:if test="#status.ppolityvisage == key">
		                  					<s:property value="value"/>
		                  				</s:if>
		                  		  </s:iterator>
		                  		  </td>
		                  		  <td align="center" nowrap="nowrap">
	                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" var="var" >
		                  				<s:if test="#status.cultureType == key">
		                  					<s:property value="value"/>
		                  				</s:if>
		                  		  </s:iterator>
		                  		  </td>
	                              <td align="center" nowrap="nowrap"><s:property value="#status.pphone" /></td>
	                              <td align="center" nowrap="nowrap"><s:property value="#status.pemail" /></td>
	                              <td align="center">
		                              <s:if test="#status.delestate==0">
		                             		<font color="green">未删除</font>
		                              </s:if>
		                              <s:else>
		                              		<font color="red">已删除</font>
		                              </s:else>
		                          </td>
		                          <td align="center">
			                          <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"63\")" id="id" status="st">
		                                 <s:if test="#status.auditstate==key">
		                              	  	 <s:property value="value"/>
		                              	 </s:if>
			                         </s:iterator>	
		                          </td>
		                          <td><s:property value="#status.adduser"/></td>
		                          <td nowrap="nowrap"><s:property value="#status.adddate"/></td>
		                          <td><s:property value="#status.audituser"/></td>
		                          <td nowrap="nowrap"><s:property value="#status.auditdate"/></td>
		                          <td align="center">
		                              <s:if test="#status.sourcetype==1">
		                              	  录入
		                              </s:if>
		                              <s:elseif test="#status.sourcetype==2">
		                              	  导入
		                              </s:elseif>
		                              <s:else>
		                              	  交换
		                              </s:else>
		                          </td>
	                             <td align="center">
	                             	<s:if test="#status.deleapplystate==1">
		                              	 <font color="red">已申请</font>
		                              </s:if>
		                              <s:if test="#status.deleapplystate==0">
		                              	 <font color="green">未申请</font>
		                              </s:if>
	                             </td>
	                             <td align="center">
	                             	<s:if test="#status.auditapplystate==1">
		                              	 <font color="red">已申请</font>
		                              </s:if>
		                              <s:if test="#status.auditapplystate==0">
		                              	 <font color="green">未申请</font>
		                              </s:if>
	                             </td>
	                          </tr>
	                       </s:iterator>
                       </s:if>
                      </tbody>
                      
                      <!-- 分页开始 -->
                      <s:if test="paging.totalPages > 0">
				          <tr>
				          	<td colspan="20">
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
                      <!-- 分页结束 -->
                  </table>
              </div>
              
        </form>
</div>

	<div id="upload" class="easyui-window" title="Word导入人员信息"  closed="true" modal="true" style="width:550px;height:320px;">
		<div style=" margin-top: 28px; margin-left: 28px;">
			<div id="formDiv">
				<form  action="" id="fileForm" name="fileForm" method="post" enctype="multipart/form-data">
				<input type="file" name="attachFile" id="attachFile" style="height: 22px;width: 300px;"/>&nbsp&nbsp
				<input type="button" onclick="saveUpload();" value="&nbsp&nbsp&nbsp上&nbsp传&nbsp&nbsp&nbsp"/>&nbsp;&nbsp;<input id="closeButton" type="button" onclick="closeUpload();" value="&nbsp&nbsp&nbsp取&nbsp消&nbsp&nbsp&nbsp" />
				</form>
			</div>
			<div id="w">正在导入，请您稍等.....</div>
			<div class="w_p">
					<p><span>温馨提示：</span></p>
					<p>1、请上传Word文档，Word文档必须保证表格样式不能发送改变；</p>
					<p>2、Word文档中可以勾选的选项，必须使用要统一标示，一篇文档不能使用多种标示。</p>
					<p>3、职称/技能信息和教育简历下面必须有4行，工作简历、科技成果和项目经验下面必须有5行。</p>
					<p>4、点击上传之后，请不要离开此页面，否则接收不到返回的日志信息。</p>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){ 
	            var color="#fafafa"
	            $(".bg_x tr:odd td").css("background-color",color);  //改变偶数行背景色
	            $(".data_list tr:odd").attr("bg",color);
	            $(".data_list tr:even").attr("bg","#fff");
	            
	      })
	</script>
  </body>
</html>
