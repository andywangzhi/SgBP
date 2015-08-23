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
    <title>批量导入日志信息搜索</title>

    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
	<!--<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> -->
	<script type="text/javascript" src="js/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="js/query/date.js" charset="UTF-8"></script>
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
    	var lognum="";
    	var color= 0;
    	var listHtml='';
		function search(){
			var _fromDate = $("#fromDate").val();
			var _toDate = $("#todate").val();
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
				$("#frm").submit();
			}
		}
		
		String.prototype.replaceAll = function(s1,s2) { 
		    return this.replace(new RegExp(s1,"gm"),s2); 
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
		function show(logId){
			location.href=path+'/uploadExecl!queryBatchlogs.action?menuId='+${menuId}+'&form.lognumber='+logId;
			}
		function closeW(){
			$('#w_c').window('close');
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

		function setTxt() 
		{ 
			var str = listHtml.replace(/<[^>].*?>/g,"");  
			str=str.replace(/[ ]/g,"");
		    window.clipboardData.setData('text',str); 
		} 
		function openUpload(){
			$("#w").html(" ");
			$('#upload').window('open');
		}
		function closeUpload(){
			$('#upload').window('close');
		}
		function saveUpload(){
			var attachFile = $('#attachFile').val();
			if(attachFile==""){
				alert("请选择文件\r\n");
				return ;
				}
			 var pos = attachFile.lastIndexOf(".");
			 var lastname = attachFile.substring(pos,attachFile.length) 
			 if (lastname.toLowerCase()!=".xls")
			 {
			     alert("文件类型必须为xls类型");
			     return ;
			 }
			 $("#formDiv").hide();
			 $("#fileForm").ajaxSubmit(
						{
							url: "uploadExecl!saveExecl.action?dateStr="+(new Date()),
							dataType:'json',
							success: function(data, status)
							{   
							$('#upload').window('close');
							var error='';
							try   { 
								error = data.error;
								} 
							catch(exception){} 
							if(error!=null&&error.length>0){
								$("#formDiv").show();
								$('#upload').window('close');
								$("#w").html(" ");
						     	 alert(error);
							}else{
									alert("批量导入成功");
									location.href= path+'/uploadExecl!queryBatchlog.action?menuId='+${menuId}+'&form.lognumber='+data.lognumber;
								}
							},
							error:function()
							{
								$("#formDiv").show();
								$('#upload').window('close');
								$("#w").html(" ");
								alert("保存失败");
							}
						});
						doStatus();
		}
		 function doStatus() 
			{
				$.post(path+"/uploadExecl!doStatus.action?dateStr="+(new Date()), null, callBack, "json"); 
				
			} 
		function callBack(data) 
			{ 
				
						if(data.status!='2'){
						setTimeout("doStatus()",500);//定时调用
						$("#w").html(data.schedule); 
						}
			}
		function getRest() {
			document.getElementById('lognumber').value = '';
			document.getElementById('adduser').value = '';
			document.getElementById('fromDate').value = '';
			document.getElementById('todate').value = '';
		}
    </script>
	
  </head>
  
  <body>
    <div class="web_paht">
    <div class="row_l web_paht_l">您的位置：其它管理&nbsp;&gt;&nbsp;批量导入</div>
    <div class="row_r web_paht_r tool">
  		<a href="<%=path%>/file/人才名册.xls" class="page_excel">批量导入模板</a>
        <a href="<%=path%>/file/采集表.doc" class="page_word">采集表</a>
		<a href="javascript:openUpload();" class="up">批量导入</a>
    </div>
</div>

<div class="main_in">

    <div id="nav" class="easyui-accordion" fit="true" border="false">
      <form id="frm" name="frm" action="<%=path%>/uploadExecl!queryBatchlog.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
         <div title="批量导入日志信息" headerCls="bar_title" icon="title" selected="true">
              <div class="table_edit">
                  <table>
                      <tbody>
                          <tr>
                              <th width="90px">导入批次</th>
                              <td><input id="lognumber" name="form.lognumber" type="text" value="<s:property value="form.lognumber" />" maxlength="16" style="width:120px;"/></td>
                              <th width="90px">导入人员：</th>
                              <td>
                              <input id="adduser" name="form.adduser" type="text" value="<s:property value="form.adduser" />" maxlength="10" style="width:120px;"/>
                             <!-- 	 <select id="typeId" name="form.typeid" style="width:90px;">
                             	 	<option value="">全&nbsp;部</option>
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"17\")" var="var" >
		                  				<s:if test="form.typeid == key">
		                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                  				</s:if>
		                  				<s:else>
		                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
		                  				</s:else>
	                  				</s:iterator>
                  				 </select> -->
							   </td>
                               <th width="90px">时间段：</th>
                              <td  nowrap="nowrap"><input type="text" id="fromDate" readonly="readonly" onfocus="HS_setDate(this)" name="form.fromDate"  style="width:120px;" value="<s:property value="form.fromDate"/>" />
                               至 <input type="text" id="todate" readonly="readonly" onfocus="HS_setDate(this)" name="form.toDate"  style="width:120px;"  value="<s:property value="form.toDate"/>"/></td>
                          </tr>
                      </tbody>
                      <tfoot>
                          <tr><td colspan="8">
                          <a href="javascript:search();" class="btn_search" >搜 索</a>
                          <a class="btn_search" onclick="getRest()">重  置</a>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
              
              <div class="table_edit">
                  <table>
                      <thead>
                          <tr>
                              <th  nowrap="nowrap"><p align="center">导入时间</p></th>
                              <th  nowrap="nowrap"><p align="center">批次</p></th>
                              <th nowrap="nowrap"><p align="center">导入人员</p></th>
                              <th  nowrap="nowrap"><p align="center">总数</p></th>
                              <th  nowrap="nowrap"><p align="center">成功数</p></th>
                              <th  nowrap="nowrap"><p align="center">失败数</p></th>
                              <th  nowrap="nowrap"><p align="center">操作</p></th>
                          </tr>
                      </thead>
                      <tbody class="bg_x">
                       <s:if test="form.dtoList.size() > 0 ">
	                      <s:iterator value="form.dtoList" id="status" status="st">
	                          <tr>
	                              <td align="center"  nowrap="nowrap"><s:date name="#status.adddate"  format="yyyy-MM-dd"/> </td>
	                              <td align="center"  nowrap="nowrap">
	                              <a href="javascript:show('<s:property value="#status.lognumber"/>');"><s:property value="#status.lognumber"/>
	                        <!--       <script type="text/javascript">
	                              	if(lognum==""){
		                              	lognum= '<s:property value="#status.lognumber"/>';
		                              	color=1;
		                              	document.write('<p style="color:#0678b7;">'+lognum+'</p>');
	                              	}else{
		                              	var lognum1='<s:property value="#status.lognumber"/>';
										if(lognum==lognum1){
											if(color==1){
												document.write('<p style="color:#0678b7;">'+lognum+'</p>');
												color==1
												}else{
													document.write('<p style="color:#038b2c;">'+lognum+'</p>');
													color==1
													}
											}else{
												lognum=lognum1;
												if(color==1){
													document.write('<p style="color:#038b2c;">'+lognum+'</p>');
													color=0;
													}else{
														document.write('<p style="color:#0678b7;">'+lognum+'</p>');
														color=1;
														}
												}
		                              	}
	                              </script> -->
	                              </a>
	                             </td>
	                             
	                              <td align="center"  nowrap="nowrap"><s:property value="#status.adduser" /></td>
	                              <td align="center"  nowrap="nowrap"><s:property value="#status.total" /></td>
		                  		  <td align="center"  nowrap="nowrap"><s:property value="#status.successcount"/></td>
	                              <td align="center"  nowrap="nowrap"><s:property value="#status.failcount" /></td>
	                              <td align="center"  nowrap="nowrap">
	                              <input type="hidden"  id="<s:property value="#status.logid" />" value="<s:property value="#status.errorlog" />" />
	                               <a href="javascript:show('<s:property value="#status.lognumber"/>');"><font color="red">查看详细日志</font></a>
	                              </td>
	                             
	                          </tr>
	                       </s:iterator>
                       </s:if>
                      </tbody>
                      <!-- 分页开始 -->
                      <s:if test="paging.totalPages > 0">
				          <tr>
				          	<td colspan="12"  nowrap="nowrap">
				          		<div class="row_l">
				          		<s:if test="paging.currentIndex == 1">
				          			<img src="business/images/page/ico_p1.gif" width="12" height="11" align="absmiddle" />&nbsp;首页&nbsp;&nbsp;
				          			<img src="business/images/page/ico_p2.gif" width="12" height="11" align="absmiddle" />&nbsp;上一页&nbsp;&nbsp;
				          		</s:if>
				          		<s:else>
					          	<a href="javascript:firstPage();">
					          		<img src="business/images/page/ico_p1.gif" width="12" height="11" align="absmiddle" />&nbsp;首页
					          	</a>&nbsp;&nbsp;
					          	<a href="javascript:prePage('<s:property value="paging.currentIndex" />');">
					          		<img src="business/images/page/ico_p2.gif" width="12" height="11" align="absmiddle" />&nbsp;上一页&nbsp;&nbsp;
					          	</a>
					          	</s:else>
				          		<s:if test="paging.currentIndex == paging.totalPages">
				          			下一页&nbsp;<img src="business/images/page/ico_p3.gif" width="12" height="11" align="absmiddle" />&nbsp;&nbsp;
				          			尾页&nbsp;<img src="business/images/page/ico_p4.gif" width="12" height="11" align="absmiddle" />
				          		</s:if>
				          		<s:else>
						          	<a href="javascript:nextPage('<s:property value="paging.currentIndex" />');">
						          	下一页&nbsp;<img src="business/images/page/ico_p3.gif" width="12" height="11" align="absmiddle" />&nbsp;&nbsp;
						          	</a>
						          	<a href="javascript:endPage('<s:property value="paging.totalPages" />');">
						          	尾页&nbsp;<img src="business/images/page/ico_p4.gif" width="12" height="11" align="absmiddle" />
						          	</a>
					          	</s:else>
				          		当前第<s:property value="paging.currentIndex" />页/共<s:property value="paging.totalPages" />页&nbsp;&nbsp;
					          	每页&nbsp;<input type="text" id="pageSize" name="paging.pageSize" value="<s:property value="paging.pageSize" />" maxlength="10" style="width: 50px;text-align: center;" 
				          				onchange="getSearch()" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
				          		条记录/共<span style="color: blue;"><s:property value="paging.totalRecords" /></span>条记录&nbsp;&nbsp;
				          		
				          		<input type="hidden" id="currentPage" name="paging.currentIndex" value="<s:property value="paging.currentIndex" />"/>
				          		</div>
				          	</td>
				          </tr>
				       </s:if>
                      <!-- 分页结束 -->
                  </table>
              </div>
              
        	</div>
        </form>
    </div>
</div>
		<div id="w_c" closed="true" class="easyui-window" title="批量导入返回信息" iconCls="icon-save" style="width:700px;height:350px;padding:5px;">
		<div class="easyui-layout" fit="true">
			<div id="inf" region="center" border="false" style="padding:10px;background:#fff;border:1px solid #ccc;">
				
			</div>
			<div region="south" border="false" style="text-align:right;padding:5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="setTxt()">复制信息</a>
				<a  class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeW()">关闭</a>
			</div>
		</div>
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
