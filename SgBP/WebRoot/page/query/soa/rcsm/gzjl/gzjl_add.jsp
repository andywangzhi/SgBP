<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
  <head>
    <title>工作简历</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
    <script type="text/javascript" src="<%=path%>/js/query/public/checkboxDate.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-form-3.14.js"></script>
    <script type="text/javascript" src="<%=path%>/js/query/rcsm/gzjl/gzjl.js"></script>
    <script type="text/javascript">
    	var path = '<%=path%>'; 
    	var entrance='<%=request.getParameter("entrance")%>';
    	var clicked=true;
    	var _listSize = '<s:property value="form.dtoDetailList.size()" />';
    	var	menuId='<%=request.getParameter("menuId")%>';
    		// 新增一空行
		function  addNewLine(){ 
					var _fromYear="selectChange(this,'"+_listSize+"','year','fromMonth','fromDate','start','form.dtoDetailList');";
					var _fromMonth="selectChange(this,'"+_listSize+"','month','fromYear','fromDate','start','form.dtoDetailList');";
					var _toYear="selectChange(this,'"+_listSize+"','year','toMonth','toDate','end','form.dtoDetailList');";
					var _toMonth="selectChange(this,'"+_listSize+"','month','toYear','toDate','end','form.dtoDetailList');";
					var	newLine='<tr>';
					    newLine+='<td align="center" width="50px;"><input name="sel" type="checkbox" value=""/></td>';					
						newLine+='<td align="center" nowrap="nowrap"  style="width: 350px;" >';
						newLine+='<input id="form.dtoDetailList['+_listSize+'].fromDate" name="form.dtoDetailList['+_listSize+'].fromDate" type="hidden" value="'+getFirstDay()+'"/>';
						newLine+='<input id="form.dtoDetailList['+_listSize+'].toDate" name="form.dtoDetailList['+_listSize+'].toDate" type="hidden" value="'+getEndDay()+'"/>';
						newLine+='<select id="fromYear'+_listSize+'" name="fromYear'+_listSize+'" onchange="'+_fromYear+'"></select>&nbsp;年&nbsp;&nbsp;';
						newLine+='<select id="fromMonth'+_listSize+'" name="fromMonth'+_listSize+'" onchange="'+_fromMonth+'"></select>&nbsp;月&nbsp';
						newLine+='&nbsp;&nbsp;-&nbsp;&nbsp;';
						newLine+='<select id="toYear'+_listSize+'" name="toYear'+_listSize+'" onchange="'+_toYear+'"></select>&nbsp;年&nbsp;&nbsp;';
						newLine+='<select id="toMonth'+_listSize+'" name="toMonth'+_listSize+'" onchange="'+_toMonth+'"></select>&nbsp;月&nbsp';
						newLine+='</td>';
						newLine+='<td nowrap="nowrap" style="width: 250px;"><input id="form.dtoDetailList['+_listSize+'].companyName" name="form.dtoDetailList['+_listSize+'].companyName" type="text" value="" class="inp"  maxlength="100" /></td>';
						newLine+='<td nowrap="nowrap">';
						newLine+='	<select name="form.dtoDetailList['+_listSize+'].pposition" class="inp">';
						newLine+='		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="status" status="st">';
						newLine+='			 <option value="<s:property value="key"/>"><s:property value="value"/></option>';
						newLine+='		</s:iterator>';
						newLine+='	</select>';
						newLine+='</td>';
						newLine+='</tr>';
						$("tbody").append(newLine);
						if(document.getElementById('fromYear'+_listSize))	addYearOpts('fromYear'+_listSize);
						if(document.getElementById('fromMonth'+_listSize))	addMonthOpts('fromMonth'+_listSize);
						if(document.getElementById('toYear'+_listSize)){	addYearOpts('toYear'+_listSize);}
						if(document.getElementById('toMonth'+_listSize)){	addMonthOpts('toMonth'+_listSize);}
						_listSize ++;	
						
		}

    </script>
  </head>
  
  <body>
     <form id="frm" name="frm" action="<%=path%>/soa/workexperience!saveOrUpdate.action?menuId=<%=request.getParameter("menuId")%>" method="post" >
    <div class="web_paht">
    <div class="row_l web_paht_l">您的位置：个人信息<script type="text/javascript">if(entrance==1){document.write("申报");}else{document.write("维护");}
      </script>
    &nbsp;&gt;&nbsp;工作简历
    <font style="color: blue;">（${personName}-${personIdCard}）</font>
    </div>
    <div class="row_r web_paht_r tool">
        状态:<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"63\")" id="status" status="st">
	         <s:if test="form.auditstate==key">
	           <font color="red"><s:property value="value"/></font>
	         </s:if>
		 </s:iterator>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
</div>
<div style="text-align: center; font-weight:bold; font-size:25px; margin-top: 10px;">工 作 简 历</div>
<div class="row_l web_paht_l tool" style="height:20px; text-align: left;margin: 0px 15px;">
 	<a href="<%=path%>/soa/workexperience.action?menuId=<%=request.getParameter("menuId")%>" class="refresh" style="margin-left: 0px;">刷新</a>
    <a href="javascript:preview('<%=session.getAttribute("personId")%>','<%=session.getAttribute("personName")%>','<%=session.getAttribute("personIdCard")%>','<%=session.getAttribute("auditstate")%>');" class="msn">预览</a>
    <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
      <a href="javascript:addNewLine();" class="plus">新增</a>
      <a href="javascript:this.disabled=true;deleteBySelect();" class="delete">删除</a>
    </s:if>
</div>
<div class="main_in">
     	<input name="form.retrieveSO.personId" value="<s:property value="form.retrieveSO.personId" />" type="hidden"/>
     	<input id="workId" name="form.retrieveSO.workId" value="" type="hidden"/>
     	
     	<input id="ids" name="form.selected" value="" type="hidden"/>
         
              <div class="table_edit"  style="height: 294px;">
                  <table>
                  
                      <thead>
                       	  <th nowrap="nowrap"><p align="center">选择</p></th>
                          <th nowrap="nowrap"><p align="center">起止年月</p></th>
                          <th nowrap="nowrap"><p align="center">单位名称</p></th>
                          <th nowrap="nowrap"><p align="center">从事岗位</p></th>
                      </thead>
                      <tbody>
                      
                        <s:if test="form.dtoDetailList.size()>0 ">
	                       	  <s:iterator value="form.dtoDetailList" id="status" status="stat">
		                          	<tr>
		                          	  <td align="center" width="50px;">
										<input name="sel" type="checkbox" value="<s:property value="#status.workId"/>"/>
									  </td>
									  <input type="hidden" name="form.dtoDetailList[<s:property value="#stat.index" />].adddate" value="<s:property value="#status.adddate"/>"/> 
        							  <input type="hidden" name="form.dtoDetailList[<s:property value="#stat.index" />].adduser" value="<s:property value="#status.adduser"/>"/> 
				 					 <td align="center" nowrap="nowrap" style="width: 350px;">
				 					 	<input id='form.dtoDetailList[<s:property value="#stat.index" />].workId' name='form.dtoDetailList[<s:property value="#stat.index" />].workId' type="hidden" value='<s:property value="#status.workId"/>' />
								        <input id='form.dtoDetailList[<s:property value="#stat.index" />].fromDate' name='form.dtoDetailList[<s:property value="#stat.index" />].fromDate' type="hidden" value='<s:property value="#status.fromDate"/>' />
					                  	<input id="form.dtoDetailList[<s:property value="#stat.index" />].toDate" name="form.dtoDetailList[<s:property value="#stat.index" />].toDate" type="hidden" value='<s:property value="#status.toDate"/>' />
					                  	<select id='fromYear<s:property value="#stat.index" />' name='fromYear<s:property value="#stat.index" />' 
					                  	onchange="selectChange(this,'<s:property value="#stat.index" />','year','fromMonth','fromDate','start','form.dtoDetailList');"></select>&nbsp;年&nbsp;
					                  	<select id='fromMonth<s:property value="#stat.index" />' name='fromMonth<s:property value="#stat.index" />' 
					                  	onchange="selectChange(this,'<s:property value="#stat.index" />','month','fromYear','fromDate','start','form.dtoDetailList');"></select>&nbsp;月&nbsp;
										<script type="text/javascript">
											var _v='<s:property value="#status.fromDate"/>';
						                  	addYearOpts('fromYear<s:property value="#stat.index" />');
						                  	addMonthOpts('fromMonth<s:property value="#stat.index" />');
						                  	var myDate= new Date(Date.parse(_v.replace(/-/g, "/")));
						                  	var _yyyy = myDate.getFullYear();
						                  	var _MM = myDate.getMonth() + 1;
						                  	_MM = (_MM<10?("0"+_MM):_MM)
								            document.getElementById('fromYear<s:property value="#stat.index" />').value = _yyyy;
								            document.getElementById('fromMonth<s:property value="#stat.index" />').value = _MM;
					                  	</script>
					                  	&nbsp;-&nbsp;&nbsp;<select id='toYear<s:property value="#stat.index" />' name='toYear<s:property value="#stat.index" />' 
					                  	onchange="selectChange(this,'<s:property value="#stat.index" />','year','toMonth','toDate','end','form.dtoDetailList');"></select>&nbsp;年&nbsp;
					                  	
					                  	<select id='toMonth<s:property value="#stat.index" />' name='toMonth<s:property value="#stat.index" />' 
					                  	onchange="selectChange(this,'<s:property value="#stat.index" />','month','toYear','toDate','end','form.dtoDetailList');"></select>&nbsp;月&nbsp;
					                  	
					                  	<script type="text/javascript">
											var _v='<s:property value="#status.toDate"/>';
						                  	addYearOpts('toYear<s:property value="#stat.index" />');
						                  	addMonthOpts('toMonth<s:property value="#stat.index" />');
						                  	var myDate= new Date(Date.parse(_v.replace(/-/g, "/")));
						                  	var _yyyy = myDate.getFullYear();
						                  	var _MM = myDate.getMonth() + 1;
						                  	_MM = (_MM<10?("0"+_MM):_MM)
								            document.getElementById('toYear<s:property value="#stat.index" />').value = _yyyy;
								            document.getElementById('toMonth<s:property value="#stat.index" />').value = _MM;
					                  	</script>
								      </td>
				      
		                              <td nowrap="nowrap"  style="width: 250px;"><input id="form.dtoDetailList[${stat.index}].companyName" name="form.dtoDetailList[${stat.index}].companyName" type="text" value="<s:property value="#status.companyName" />" class="inp" maxlength="100"/></td>
		                              <td nowrap="nowrap">
		                               <select name="form.dtoDetailList[${stat.index}].pposition" class="inp">
			                               <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="id" status="st">
			                              	   <s:if test="#status.pposition==key">
			                              	     	<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
			                              	   </s:if>
			                              	   <s:else>
			                              	    	<option value="<s:property value="key"/>" ><s:property value="value"/></option>
			                              	   </s:else>
		                              	   </s:iterator>
		                              	</select>
		                              </td>
		                          </tr>
		                     </s:iterator>
	                     </s:if>

                      </tbody>
                      <tfoot>
                          <tr><td colspan="4">
                          <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
                           	<a id="save" class="btn_search" onclick="saveData(1);">保 存</a>
                           	<a id="saveAndNext" class="btn_search" onclick="saveData(2);">保存并下一步</a>
                          </s:if>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>

	</div>
</form>
    
  </body>
</html>
