<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>紧缺人才需求</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script> 
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/js/js_validate.js"></script>
	<style>
		body,td,div,select,input{ font-size:12px;}
		body{background-color:#FFF;}
		.btn_s { display:inline-block;width:45px; height:17px; line-height:18px;margin:0; padding:0; border:0;
			font-size:12px; color:#a16f0c; text-indent:14px;
			background: url(<%=path%>/external/images/btn_s.gif); 
			vertical-align:middle;overflow:hidden;cursor:pointer;}
		.btn_s:hover {color:#a50000;}
	</style>
    <script type="text/javascript">
    	var path='<%=path%>';
		function queryRecord(){
			$("#frm").submit();
		}
		function preview(param){
			var ram=Math.random();
			location.href = path+"/soa/rsPersonneed!toviewpage.action?form.business=view&form.rsPersonneed.needid="+param+"&ram="+ram;
		}
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

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：紧缺人才管理&nbsp;&gt;&nbsp;紧缺人才需求</div>
    <div class="row_r web_paht_r tool"></div>
</div>

<div class="main_in">
    <form id="frm" name="frm" method="post" action = "<%=path%>/soa/rsPersonneed!toneedlist.action">        
    			<div class="table_edit" >       
                   <table cellpadding="1" cellspacing="1" style="width:98%;">
                          <tbody>
                               <tr>
                    			<th style="width:100px;">企业名称</th>
                    			<td style="width:205px;"><input type="text" id="needcopname" name="form.rsPersonneedQuery.needcopname" value='<s:property value="form.rsPersonneedQuery.needcopname" />' style="width:200px;"/></td>
                                   <th style="width:100px;">编号：</th>
                                   <td style="width:150px;"><input name="form.rsPersonneedQuery.needno" value='<s:property value="form.rsPersonneedQuery.needno" />' id="needno" type="text"  style="width:140px;" /></td>
                                   <th style="width:100px;">需求岗位：</th>                                                                                  
                                          <td style="width:110px;">										  
										  <select id="needstation" name="form.rsPersonneedQuery.needstation" class="inp" style="width:100px; " >
						                      <option value="">请选择</option>
						                      <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="status" status="st">
						                      	
						                      	  <s:if test="form.rsPersonneedQuery.needstation == key">
						                  				<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
						                  		  </s:if>
						                  		  <s:else>
				                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
				                  				 </s:else>
						                      </s:iterator>		                         
						                   </select>
										  </td>                                                                 
                               </tr>                              
                               <tfoot>
                                   <tr style="height:30px;">
                                       <td colspan="6" align="center">
                                       	<a class="btn_search" icon="icon-ok" href="javascript:void(0)" onclick="queryRecord();">查询</a> 
                      					<a class="btn_search" icon="icon-cancel" href="javascript:void(0)" onclick="clearData('frm');">重置</a></td>
                                       </td>
                                   </tr>
                               </tfoot>
                           	</tbody>
                       </table>
                 	</div>
                 	<div class="table_edit" style="height: 290px;">
                              <table class="allDatas" cellpadding="1" cellspacing="1" style="width:100%;">
                                  <thead>
                                      <tr>
                                      	  <th>预览</th>                                         
                                          <th>编号</th>                                          
                                          <th>联系人</th>
                                          <th>需求岗位</th>
                                          <th>学历要求</th>
                                          <th>职称要求</th>
                                          <th>急需人数</th>
                                          <th>企业名称</th> 
                                          <th>经办日期</th>
                                      </tr>
                                  </thead>
                                  <tbody id="dataBody">
                                     <s:if test="form.dtoList.size() >0 ">
					                      <s:iterator value="form.dtoList" id="status" status="st">
					                          <tr id='<s:property value="#status.needid"/>'>	
					                          	  <td align="center">
					                              	<a onclick="preview('<s:property value="#status.needid"/>');"><img src="<%=path%>/business/images/View_file.gif"/></a>
												  </td>												  			                          	   					                              
					                              <td align="center" nowrap="nowrap"><s:property value="#status.needno" /></td>
					                              <td align="center" nowrap="nowrap"><s:property value="#status.needtelname" /></td>
					                              <td align="center" nowrap="nowrap">
						                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="status1" status="var">
						                               <s:if test="#status.needstation==key">
					                              	  	  	<s:property value="value"/>
					                              	  	  </s:if>
						                              </s:iterator>	
					                              </td>
					                              <td align="center" nowrap="nowrap">
					                              		 <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" status="var">
							                              	<s:if test="#status.neededucation==key">
							                              	  	  	 <s:property value="value"/>
							                              	</s:if>
								                         </s:iterator>	
					                              </td>
					                              <td align="center" nowrap="nowrap">
				                              		 <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"12\")" status="var">
						                              	<s:if test="#status.needpost==key">
						                              	  	  	 <s:property value="value"/>
						                              	</s:if>
							                         </s:iterator>	
					                              </td>
					                              <td align="center" nowrap="nowrap"><s:property value="#status.needcount" /></td>
					                              <td align="center" nowrap="nowrap"><s:property value="#status.needcopname" /></td>					                              
					                              <td align="center" nowrap="nowrap"><s:property value="#status.adddate" /></td>
					                          </tr>
					                       </s:iterator>
                       					</s:if>
                       				  </tbody>
                                      <tfoot>
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
                                      </tfoot>
                                  </tbody>
                              </table>
    				</div>
    </form>

</body>
</html>