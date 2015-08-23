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
	
		
	
		function show(logId){
			listHtml=document.getElementById(logId).value;
			$("#inf").html(listHtml);
			$('#w_c').window('open');
			}
		function closeW(){
			$('#w_c').window('close');
			}

    	function getDate(date){
    		 var dates = date.split("-");
    		 var dateReturn = '';
    		 
    		 for(var i=0; i<dates.length; i++){
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
		 function doBack() 
			{
			 location.href=path+"/mypro/uploadExecl!queryBatchlog.action?menuId="+menuId;
			} 


    </script>
	
  </head>
  
  <body>
    <div class="web_paht">
    <div class="row_l web_paht_l">您的位置：其它管理&nbsp;&gt;&nbsp;批量导入</div>
    <div class="row_r web_paht_r tool">
    </div>
</div>

<div class="main_in">

    <div id="nav" class="easyui-accordion" fit="true" border="false">
      <form id="frm" name="frm" action="<%=path%>/uploadExecl!queryBatchlog.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
         <div title="批量导入日志详细信息" headerCls="bar_title" icon="title" selected="true">
              <div class="table_edit">
              </div>
              
              <div class="table_edit">
                  <table>
                      <thead>
                          <tr>
                              <th  nowrap="nowrap"><p align="center">导入时间</p></th>
                              <th  nowrap="nowrap"><p align="center">批次</p></th>
                              <th nowrap="nowrap"><p align="center">日志类别</p></th>
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
	                              <td align="center"  nowrap="nowrap"><s:property value="#status.lognumber"/></td>      
	                              <td align="center"  nowrap="nowrap"><s:property value="#application._WEB_SYS_CONF_KEY_.get(\"17\").get(#status.typeid)" /> </td>
	                              <td align="center"  nowrap="nowrap"><s:property value="#status.total" /></td>
		                  		  <td align="center"  nowrap="nowrap"><s:property value="#status.successcount"/></td>
	                              <td align="center"  nowrap="nowrap"><s:property value="#status.failcount" /></td>
	                              <td align="center"  nowrap="nowrap">
	                              <input type="hidden"  id="<s:property value="#status.logid" />" value="<s:property value="#status.errorlog" />" />
	                               <a href="javascript:show('<s:property value="#status.logid"/>');"><font color="red">查看日志详细信息</font></a>
	                              </td>
	                             
	                          </tr>
	                       </s:iterator>
                       </s:if>
                      </tbody>
                      <tfoot>
                          <tr><td colspan="7">
                          	<a class="btn_search" onclick="javascript:this.disabled=true;doBack();">返回</a>
                          </td></tr>
                      </tfoot>
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
  </body>
</html>
