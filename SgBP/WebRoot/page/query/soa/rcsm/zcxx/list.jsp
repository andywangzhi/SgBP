<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery-form-3.14.js"></script>
   	    <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
		<script type="text/javascript" src="<%=path%>/locale/easyui-lang-zh_CN.js"></script>
   	    <script type="text/javascript" src="<%=path%>/js/query/public/checkboxDate.js"></script>
   	     <script type="text/javascript" src="<%=path%>/js/query/rcsm/zcxx/input.js"></script>
		<title>职称信息</title>
		<script type="text/javascript">
		 	var path = '<%=path%>'; 
		 	var entrance='<%=request.getParameter("entrance")%>';
		 	var clicked=true;
		   	var listSize = '<s:property value="form.dtoList.size()" />';
		   	var menuId='<%=request.getParameter("menuId")%>';
			var message = '${message}';
		   	if(listSize == null || listSize == '' || isNaN(listSize)) {
		   		listSize = '0';
		   	}
			function addRecord(){
			   
			  $("#frm").submit();
			}
		// 新增输入数据行
		function add() {
			var trcomp='<tr class="table_l3" align="center" id="trID'+listSize+'">';

			trcomp+='<td><input type="checkbox" name="deleteTechId" value=""></td>';
			trcomp+='<td><input type="hidden"  name="form.dtoList['+listSize+'].personid" value="'+$("#personid").val()+'">';
			trcomp+='<input id="form.dtoList['+listSize+'].assessDate" type="hidden" name="form.dtoList['+listSize+'].assessDate" value="'+getFirstDay()+'"/>';
			
			var _change1 = "selectChange(this,'"+listSize+"','year','fromMonth','assessDate','start','form.dtoList');";
			trcomp+='<select id="fromYear'+listSize+'" name="fromYear'+listSize+'" onchange="'+_change1+'"></select>&nbsp;年&nbsp;&nbsp;';
			
			var _change2 = "selectChange(this,'"+listSize+"','month','fromYear','assessDate','start','form.dtoList');";
			trcomp+='<select id="fromMonth'+listSize+'" name="fromMonth'+listSize+'" onchange="'+_change2+'"></select>&nbsp;月&nbsp;</td>';
			trcomp+='<td><input id="form.dtoList['+listSize+'].technicallyType" name="form.dtoList['+listSize+'].technicallyType" type="text" value="" class="inp" maxlength="100"/></td>';
			trcomp+='<td><select name="form.dtoList['+listSize+'].technicallyLevel"  class="inp"  >';
			
			<s:iterator value="#application._WEB_SYS_CONF_KEY_.get('12')">
				var _valueA='<s:property value="key"/>';
				var _keyA='<s:property value="value"/>';
				trcomp+='<option value="'+_valueA+'">'+_keyA+'</option>';
			</s:iterator>
			
			trcomp+='</select></td></tr>';
			$("#techTable").append(trcomp);
			
			if(document.getElementById('fromYear'+listSize)){	addYearOpts('fromYear'+listSize);	}
			if(document.getElementById('fromMonth'+listSize)){	addMonthOpts('fromMonth'+listSize);	}
			// 每增加一行将提交的数据数组下标增加1
			listSize ++;
		}
		</script>
	</head>
<body>
<form action="<%=path%>/soa/tech!saveOrUpdate.action?menuId=<%=request.getParameter("menuId")%>" id="frm" name="frm"  method="post" >
<input type="hidden" id="personid" name="form.retrieveSO.personId" value="<s:property value="form.personId" />"/>
<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：人员信息<script type="text/javascript">if(entrance==1){document.write("申报");}else{document.write("维护");}</script>&nbsp;&gt;&nbsp;职称技能信息 
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
<div id="delIDs"></div>
<div style="text-align: center; font-weight:bold; font-size:25px; margin-top: 10px;">职 称 技 能</div>
<div class="row_l web_paht_l tool" style="height:20px; text-align: left;margin: 0px 15px;">
 <a class="refresh" onclick="refresh();" style="margin-left: 0px;">刷新</a>
 <a href="javascript:preview('<%=session.getAttribute("personId")%>','<%=session.getAttribute("personName")%>','<%=session.getAttribute("personIdCard")%>','<%=session.getAttribute("auditstate")%>');" class="msn" >预览</a>
 <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
    <a class="plus" onclick="add();">新增</a>
    <a class="delete" onclick="deleteBySelect();">删除</a>
 </s:if>
</div>
<div class="main_in" >

               <div class="table_edit"   style="height: 294px;">
                  <table >
                      <thead>
                    	  <th><p align="center">选择</p></th>
                          <th><p align="center">取得时间</p></th>
                          <th><p align="center">职称技能专业名称</p></th>
                          <th><p align="center">职称技能级别</p></th>
                      </thead>
                      <tbody id="techTable">
                            <s:iterator value="form.dtoList" id="id" status="stat" >
                          <s:if test="#stat.odd"> 
							  <tr align="center"  bgcolor="#FFFFFF" id='trID<s:property value="#stat.index" />'>
						  </s:if>	
						  <s:else>
							  <tr align="center" class="table_l3" id='trID<s:property value="#stat.index" />'>
						  </s:else>
	                          <td align="center">
	                          	 <input type="checkbox"  name="deleteTechId" value='<s:property value="#id.techId"/>'/>
	                          	 <input  type="hidden" id="form.dtoList[${stat.index}].techId"  name="form.dtoList[${stat.index}].techId" value='<s:property value="#id.techId"/>'/>
	                         	 <input  type="hidden"   name="form.dtoList[${stat.index}].personId" value='<s:property value="#id.personId"/>'/>
	                           <input  type="hidden" id="form.dtoList[${stat.index}].adduser"  name="form.dtoList[${stat.index}].adduser" value='<s:property value="#id.adduser"/>'/>
	                         	 <input  type="hidden"   name="form.dtoList[${stat.index}].adddate" value='<s:property value="#id.adddate"/>'/>
	                          
	                          </td>
                              <td align="center"><input id="form.dtoList[${stat.index}].assessDate" type="hidden" name="form.dtoList[${stat.index}].assessDate" value='<s:property value="#id.assessDate"/>'/>
                               <select id='fromYear<s:property value="#stat.index" />' name='fromYear<s:property value="#stat.index" />' onchange="selectChange(this,'<s:property value="#stat.index" />','year','fromMonth','assessDate','start','form.dtoList');"></select>&nbsp;年&nbsp;
                               <select id='fromMonth<s:property value="#stat.index" />' name='fromMonth<s:property value="#st.index" />' onchange="selectChange(this,'<s:property value="#stat.index" />','month','fromYear','assessDate','start','form.dtoList');"></select>&nbsp;月&nbsp;
							  <script type="text/javascript">
									var _v='<s:property value="#id.assessDate"/>';
				                  	addYearOpts('fromYear<s:property value="#stat.index" />');
				                  	addMonthOpts('fromMonth<s:property value="#stat.index" />');
				                  	var myDate= new Date(Date.parse(_v.replace(/-/g, "/")));
				                  	var _yyyy = myDate.getFullYear();
				                  	var _MM = myDate.getMonth() + 1;
				                  	_MM = (_MM<10?("0"+_MM):_MM)
						            document.getElementById('fromYear<s:property value="#stat.index" />').value = _yyyy;
						            document.getElementById('fromMonth<s:property value="#stat.index" />').value = _MM;
						          
			                  	</script>
                              </td>
                              <td align="center"><input id="form.dtoList[${stat.index}].technicallyType" name="form.dtoList[${stat.index}].technicallyType" type="text" value='<s:property value="#id.technicallyType"/>' class="inp" maxlength="100"/></td>
                          	  <td align="center">
                          	  	<select name="form.dtoList[${stat.index}].technicallyLevel "  class="inp"  >
                                		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get('12')">
                                		<s:if test="#id.technicallyLevel == key">
                                       	 	<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                                       	 </s:if>
                                       	 <s:else>
                                       		 <option value="<s:property value="key"/>"><s:property value="value"/></option>
                                       	 </s:else>
										</s:iterator>
                                  </select></td>
                          </tr>
                         </s:iterator>
                      </tbody>
                       <tfoot>
                          <tr><td colspan="4">
                          <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
                          	<a id="save" class="btn_search" onclick="javascript:save(1);">保存</a>
                          	<a id="saveAndNext" class="btn_search" onclick="javascript:save(2);">保存并下一步</a>
                          </s:if>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
        </div>
 

</form>
</body>
</html>