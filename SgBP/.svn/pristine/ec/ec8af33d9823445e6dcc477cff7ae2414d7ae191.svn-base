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
    <title>启用管理模块</title>

    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
	<script type="text/javascript" src="js/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery/jquery.form.js"></script>
    <link rel="stylesheet" type="text/css" href="business/css/reset.css" />
	<script type="text/javascript" src="js/query/rcsm/base/qyQuery.js"></script>
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
</script>

  </head>
  
<body>
<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：其它管理&nbsp;&gt;&nbsp;启用管理</div>
</div>

<div class="main_in">

      <form id="frm" name="frm" action="<%=path%>/soa/RsPerson!qyQuery.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
              <div class="table_edit" style="border: 0px;">
                  <table>
                      <tbody>
                          <tr>
                              <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">姓名：</th>
                              <td><input style="width:150px;" id="pname" name="form.queryListSO.pname" type="text" value="<s:property value="form.queryListSO.pname" />" class="inp" /></td>
                              <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">删除申请：</th>
                              <td>
                              	<select style="width:100px;" id="deleapplystate" name="form.queryListSO.deleapplystate" class="inp">
		                            <option value="" <s:if test="null==form.queryListSO.deleapplystate || form.queryListSO.deleapplystate.length==0">selected="selected"</s:if>>请选择</option>
	                  				<option value="0" <s:if test="form.queryListSO.deleapplystate.indexOf('0')==0">selected="selected"</s:if>>未申请</option>
	                               	<option value="1" <s:if test="form.queryListSO.deleapplystate==1">selected="selected"</s:if>>已申请</option>
	                  			</select>
                              </td> 
                              <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">数据来源：</th>
                              <td colspan="2">
                             	 <select style="width:100px;" id="sourcetype" name="form.queryListSO.sourcetype" class="inp" value='<s:property value="form.queryListSO.sourcetype"/>'>
	                  				    <option value="" <s:if test="null==form.queryListSO.sourcetype || form.queryListSO.sourcetype.length==0">selected="selected"</s:if>>请选择</option>
                               			<option value="1" <s:if test="form.queryListSO.sourcetype==1">selected="selected"</s:if>>录入</option>
	                               		<option value="2" <s:if test="form.queryListSO.sourcetype==2">selected="selected"</s:if>>导入</option>
	                               		<option value="3" <s:if test="form.queryListSO.sourcetype==3">selected="selected"</s:if>>交换</option>
                  				 </select>
							   </td>
                           </tr>


							<tr>
							  <th nowrap="nowrap" style="padding-right: 0px;">公民身份号码：</th>
                              <td ><input style="width:150px;" id="idCard" name="form.queryListSO.idCard" type="text" value="<s:property value="form.queryListSO.idCard" />" class="inp" /></td>
                              
                              
                              <th nowrap="nowrap" style="padding-right: 0px;">审核申请：</th>
                             <td>
                              	<select style="width:100px;" id="auditapplystate" name="form.queryListSO.auditapplystate" class="inp">
		                            <option value="" <s:if test="null==form.queryListSO.auditapplystate || form.queryListSO.auditapplystate.length==0">selected="selected"</s:if>>请选择</option>
	                  				<option value="0" <s:if test="form.queryListSO.auditapplystate.indexOf('0')==0">selected="selected"</s:if>>未申请</option>
	                               	<option value="1" <s:if test="form.queryListSO.auditapplystate==1">selected="selected"</s:if>>已申请</option>
	                  			</select>
							   </td>
							   <th nowrap="nowrap" style="padding-right: 0px;width: 100px;">经办人：</th>
                              <td colspan="2"><input style="width:150px;" id="adduser" name="form.queryListSO.adduser" type="text" value="<s:property value="form.queryListSO.adduser" />" class="inp" /></td>
                              
                           </tr>
                      </tbody>
						<tfoot>
                          <tr><td colspan="7" style="padding-top: 5px;">
                          <a href="javascript:search();" class="btn_search" >搜 索</a>&nbsp;&nbsp;
                  			<a class="btn_search" onclick="getRest()">重  置</a>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
              
<div class="row_l web_paht_l tool" style="text-align: left;width: 100%;height: 25px;margin-left: 0px;padding-left: 0px;">
<a class="modify" onclick="delQyRun()" style="margin-left: 0px;">删除启用</a>
<a class="modify" onclick="shQyRun()">审核启用</a>
</div>
              <div class="table_edit" style="height: 288px;">
                  <table>
                      <thead>
                          <tr>
                          	  <th nowrap="nowrap"><p align="center">选择</p></th>
                          	  <th nowrap="nowrap"><p align="center">预览</p></th>
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
								  
	                              	<input id="form.dtoList[<s:property value="#st.index" />].deleapplystate" type="hidden" value="<s:property value="#status.deleapplystate" />"/>
	                              	<input id="form.dtoList[<s:property value="#st.index" />].auditapplystate" type="hidden" value="<s:property value="#status.auditapplystate" />"/>
								  </td>
	                          	  <td align="center">
	                                 <a href="javascript:preview('<s:property value="#status.personId"/>','<s:property value="#status.pname"/>','<s:property value="#status.idCard"/>','<s:property value="#status.auditstate"/>');"><img src="business/images/View_file.gif"/></a>
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

	<div id="upload" class="easyui-window" title="批量导入人员信息"  closed="true" modal="true" style="width:550px;height:320px;">
		<div style=" margin-top: 28px; margin-left: 28px;">
			<div id="formDiv">
				<form  action="" id="fileForm" name="fileForm" method="post" enctype="multipart/form-data">
				<input type="file" name="attachFile" id="attachFile" style="height: 22px;width: 300px;"/>&nbsp&nbsp
				<input type="button" onclick="saveUpload();" value="&nbsp&nbsp&nbsp上&nbsp传&nbsp&nbsp&nbsp"/>&nbsp;&nbsp;<input id="closeButton" type="button" onclick="closeUpload();" value="&nbsp&nbsp&nbsp取&nbsp消&nbsp&nbsp&nbsp" />
				</form>
			</div>
			<div id="w"></div>
			<div class="w_p">
					<p><span>温馨提示：</span></p>
					<p>1、请上传Excel表，Excel表包含的人员信息不能超过500条；如果超过的请分分次上传。</p>
					<p>2、其他信息中的身份证号码必须在人员信息中存在，否则不予导入。</p>
					<p>3、如果导入失败，请到手工申报页面重新添加。</p>
					<p>4、点击上传之后，请不要离开此页面，否则接收不到批量上传的返回信息。</p>
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