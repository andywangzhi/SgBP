<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>科技成果</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
	<script type="text/javascript" src="<%=path%>/js/query/public/checkboxDate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/query/rcsm/kjcg/input.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-form-3.14.js"></script>
    <script type="text/javascript">
    var entrance='<%=request.getParameter("entrance")%>';
    </script>
</head>
<body>


<form id="frm" name="frm" action="<%=path%>/soa/kjcg!saveOrUpdate.action?menuId=${menuId}" method="post" >  

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：个人信息<script type="text/javascript">if(entrance==1){document.write("申报");}else{document.write("维护");}</script>&nbsp;&gt;&nbsp;科技成果
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
<input type="hidden" id="personId_save" name="form.retrieveSO.personId" value="<s:property value="form.retrieveSO.personId" />"/>
<div id="delIDs"></div>
<div style="text-align: center; font-weight:bold; font-size:25px; margin-top: 10px;">科 技 成 果</div>
<div class="row_l web_paht_l tool" style="height:20px; text-align: left;margin: 0px 15px;">
	<a class="refresh" onclick="refreshPage();" style="margin-left: 0px;">刷新</a>
    <a href="javascript:preview('<%=session.getAttribute("personId")%>','<%=session.getAttribute("personName")%>','<%=session.getAttribute("personIdCard")%>','<%=session.getAttribute("auditstate")%>');" class="msn" >预览</a>
    <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
    <a class="plus" onclick="add();">新增</a>
    <a class="delete" onclick="del();">删除</a>
    </s:if>
</div>
<div class="main_in">
  
              <div class="table_edit"   style="height: 294px;">
                  <table id="allDatas">
                      <thead>
                          <th nowrap="nowrap"><p align="center">选择</p></th>
                          <th nowrap="nowrap"><p align="center" style="width: 150px;">评定日期</p></th>
                          <th nowrap="nowrap"><p align="center">成果等级</p></th>
                          <th nowrap="nowrap"><p align="center">成果名称</p></th>
                          <th nowrap="nowrap"><p align="center">发证单位</p></th>
                          <th nowrap="nowrap"><p align="center">备注</p></th>
                      </thead>
                      <tbody>
                      		<s:if test="form.dtoList.size() > 0 ">
				            <s:iterator value="form.dtoList" id="kjcgs" status="st">
								  <tr align="center" class="table_l3">
				                  <td><input type="checkbox" id="<s:property value="#st.index" />" name="deleteHarvestId" value="<s:property value="#kjcgs.harvestId" />" /></td>
				                  <td nowrap="nowrap">
				                  	<input type="hidden" id="<s:property value="#st.index" />adddate" name="form.dtoList[<s:property value="#st.index" />].adddate" value="<s:property value="#kjcgs.adddate" />"/>
				                  	<input type="hidden" id="<s:property value="#st.index" />adduser" name="form.dtoList[<s:property value="#st.index" />].adduser" value="<s:property value="#kjcgs.adduser" />"/>
								    <input type="hidden" id="<s:property value="#st.index" />personId" name="form.dtoList[<s:property value="#st.index" />].personId" value="<s:property value="#kjcgs.personId" />"/>
								    <input type="hidden" name="form.dtoList[<s:property value="#st.index" />].harvestId" value="<s:property value="#kjcgs.harvestId" />"/>

			    				    <input id='form.dtoList[<s:property value="#st.index" />].assessDate' name='form.dtoList[<s:property value="#st.index" />].assessDate' type="hidden" value='<s:property value="#kjcgs.assessDate"/>' />
                  					<select id='fromYear<s:property value="#st.index" />' name='fromYear<s:property value="#st.index" />' 
                  						onchange="selectChange(this,'<s:property value="#st.index" />','year','fromMonth','assessDate','start','form.dtoList');" 
                  					></select>&nbsp;年&nbsp;
                  	
				                  	<select id='fromMonth<s:property value="#st.index" />' name='fromMonth<s:property value="#st.index" />' 
				                  	onchange="selectChange(this,'<s:property value="#st.index" />','month','fromYear','assessDate','start','form.dtoList');" 
				                  	></select>&nbsp;月&nbsp;
									<script type="text/javascript">
										var _v='<s:property value="#kjcgs.assessDate"/>';
					                  	addYearOpts('fromYear<s:property value="#st.index" />');
					                  	addMonthOpts('fromMonth<s:property value="#st.index" />');
					                  	var myDate= new Date(Date.parse(_v.replace(/-/g, "/")));
					                  	var _yyyy = myDate.getFullYear();
					                  	var _MM = myDate.getMonth() + 1;
					                  	_MM = (_MM<10?("0"+_MM):_MM)
							            document.getElementById('fromYear<s:property value="#st.index" />').value = _yyyy;
							            document.getElementById('fromMonth<s:property value="#st.index" />').value = _MM;
				                  	</script>
				                  
				                  </td>
				                  <td>
				                  	  <select name="form.dtoList[<s:property value="#st.index" />].harvestLevel"  class="inp"  >
					                  		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get('13')" id="sta" status="stx">
				                              	  <s:if test="#kjcgs.harvestLevel==key">
				                              	  		<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
				                              	  </s:if>
				                              	  <s:else>
				                              	  		<option value="<s:property value="key"/>"><s:property value="value"/></option>
				                              	  </s:else>
				                            </s:iterator>
			                           </select>
				                  </td>
				                  <td>
				                  	<input type="text" name="form.dtoList[<s:property value="#st.index" />].harvestName" value="<s:property value="#kjcgs.harvestName" />" maxlength="100"/>
				                  </td>
				                  <td>
				                  	<input type="text" name="form.dtoList[<s:property value="#st.index" />].assessDep" value="<s:property value="#kjcgs.assessDep" />" maxlength="100"/>
				                  </td>
				                  <td>
				                  	<input type="text" name="form.dtoList[<s:property value="#st.index" />].pdemo" value="<s:property value="#kjcgs.pdemo" />" maxlength="200"/>
				                  </td>
				                </tr>
				            </s:iterator>
				          </s:if>
                      </tbody>
                       <tfoot>
                          <tr><td colspan="6">
                          <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
                          	 <a id="save" class="btn_search" onclick="save(1);">保存</a>
                          	 <a id="saveAndNext" class="btn_search" onclick="save(2);">保存并下一步</a>
                          </s:if>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
 
    
</div>

</form>
	
	<script type="text/javascript"> 
	    var path = '<%=path%>'; 
	    var clicked=true;
	    var	menuId='<%=request.getParameter("menuId")%>';
	   	var listSize = '<s:property value="form.dtoList.size()" />';
	   	if(listSize == null || listSize == '' || isNaN(listSize)) {
	   		listSize = '0';
	   	}
		function addRecord(){
		   
		  $("#frm").submit();
		}

		String.prototype.len=function()          
				{                 
				return     this.replace(/[^\x00-\xff]/g,"rr").length;          
				} 
	</script>
	<script type="text/javascript">
		// 新增输入数据行
		function add() {
			var frm = document.getElementById("frm");
			var personId_save = document.getElementById("personId_save").value;
			frm.action = path + '/soa/kjcg!saveOrUpdate.action?menuId=${menuId}';
			var kjcgTable = document.getElementById("allDatas");
			// 获得当前表格的行数
			var rowCount = kjcgTable.rows.length - 1;
			// 在最后行增加一个新行
			var newRow = kjcgTable.insertRow(rowCount);
			newRow.id = listSize + 'tr';
			// 在新增行上增加一个新列
			var newCell = newRow.insertCell();
			// 在新增列上增加数据
			newCell.align = 'center';
			newCell.innerHTML = '<input type="hidden" name="form.dtoList[' + listSize + '].personId" value="' + personId_save + '"/>' + 
				'<input type="checkbox" id="' + listSize + '" name="deleteHarvestId" value="">';	
			newCell = newRow.insertCell();
			newCell.align = 'center';
			
			var _rqStr = '<input id="form.dtoList['+listSize+'].assessDate" name="form.dtoList['+listSize+'].assessDate" type="hidden" value="'+getFirstDay()+'"/>';
			var _change1 = "selectChange(this,'"+listSize+"','year','fromMonth','assessDate','start','form.dtoList');";
			_rqStr+='<select id="fromYear'+listSize+'" name="fromYear'+listSize+'" onchange="'+_change1+'"></select>&nbsp;年&nbsp;';

			var _change2 = "selectChange(this,'"+listSize+"','month','fromYear','assessDate','start','form.dtoList');";
			_rqStr+='<select id="fromMonth'+listSize+'" name="fromMonth'+listSize+'" onchange="'+_change2+'"></select>&nbsp;月&nbsp';

			newCell.innerHTML = _rqStr;


			newCell = newRow.insertCell();
			newCell.align = 'center';

			var hlevel = '<select name="form.dtoList[' + listSize + '].harvestLevel"  class="inp"  >';
			<s:iterator value="#application._WEB_SYS_CONF_KEY_.get('13')" id="sta" status="stx">
            hlevel += '<option value="<s:property value="key"/>"><s:property value="value"/></option>';
            </s:iterator>
            hlevel += '</select>';
			newCell.innerHTML = hlevel;
			newCell = newRow.insertCell();
			newCell.align = 'center';
			newCell.innerHTML = '<input type="text" name="form.dtoList[' + listSize + '].harvestName" value=""  maxlength="100" />';
			newCell = newRow.insertCell();
			newCell.align = 'center';
			newCell.innerHTML = '<input type="text" name="form.dtoList[' + listSize + '].assessDep" value=""  maxlength="100" />';
			newCell = newRow.insertCell();
			newCell.align = 'center';
			newCell.innerHTML = '<input type="text" name="form.dtoList[' + listSize + '].pdemo" value=""  maxlength="200" />';
			
			if(document.getElementById('fromYear'+listSize)){addYearOpts('fromYear'+listSize);}
			if(document.getElementById('fromMonth'+listSize)){	addMonthOpts('fromMonth'+listSize);}
			// 每增加一行将提交的数据数组下标增加1
			listSize ++;
		}
				// 保存数据
		function save(param) {
			//var frm = document.getElementById("frm");
			var total = checkNull();
			if(clicked){
				clicked=false;
			}
			if(total>0){
					clicked=true;
					$("#save").attr("disabled",false);	
					$("#saveAndNext").attr("disabled",false);
					if(total == 1) {
						alert("请输入评定日期！");
					} else if(total == 2) {
						alert("请输入成果名称！");
					} else if(total == 3) {
						alert("请输入发证单位！");
					}else if(total == 4){
						alert("成果名称过长！")
					}else if(total == 5){
						alert("发证单位过长！")
					}else if(total == 6){
						alert("备注过长！")
					}
					return;
			}
			var ram=Math.random();
			if(total == 0) {
			$("#save").attr("disabled",true);	
			$("#saveAndNext").attr("disabled",true);
			//frm.action = path + '/soa/kjcg!saveOrUpdate.action?menuId=${menuId}';
			//frm.submit();
			$("#frm").ajaxSubmit({
					url: path + '/soa/kjcg!ajaxSaveOrUpdate.action?menuId=${menuId}&ram='+ ram,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
				        if(flag=="1"){
				        	if(param==1){
					        	alert("科技成果保存成功");
					        	location.href=path+'/soa/kjcg!queryByPerId.action?menuId=${menuId}';
				        	}else{
				        		location.href = path+'/soa/proj!query.action?menuId=${menuId}';
				        	}
				        	
				        }else if(flag=="2"){
				        	alert("科技成果保存失败");
				        }
					},
					error:function()
					{
						alert("科技成果保存失败");
					}
				});
			}
		}
		
		// 验证输入信息是否完整
		function checkNull() {
			var total = 0;
			var txtObj = document.getElementsByTagName("input");
			for(var i = 0; i < txtObj.length; i++) {
				if(txtObj[i].type == "text") {
					var txtName = txtObj[i].name;
					var txtValue = txtObj[i].value;
					if(txtName.indexOf("assessDate") != -1) {
						if(txtValue == null || txtValue == '') {
							return 1;
						}
					} else if(txtName.indexOf("harvestName") != -1) {
						if(txtValue == null || txtValue == '') {
							return 2;
						}else if(txtValue.len()>100){
							return 4;
						}
					} else if(txtName.indexOf("assessDep") != -1) {
						if(txtValue == null || txtValue == '') {
							return 3;
						}else if(txtValue.len()>100){
							return 5;
						}
					}else if(txtName.indexOf("pdemo") != -1){
						if(txtValue.len()>200){
							return 6;
						}
					}
					
				}
			}
			return total;
		}
		
		// 删除数据
		function del(){
			var workIds="";
			var allLines=$(":checkbox:checked").size();
			var selectedLines=$("[name = deleteHarvestId]:checkbox:checked").size();
			var confirmDelete=false;
			var step=0;
			var ram=Math.random();
			if(selectedLines<=0){
				if(allLines==(selectedLines+1)){
					alert("没有可用的数据!");
				}else{
					alert("请选择记录!");
				}
			}else{
				//组合要删除的ID
				$("[name = deleteHarvestId]:checkbox").each(function(){
					var workId=$(this).val();
					if($(this).attr("checked")){
						if(workId!=null&&workId!=""){
							workIds+=$(this).val()+",";
						}
					}
					if(step==0){
						confirmDelete=confirm("您确定要删除选择的记录吗？");
					}
					step++;
				});
				if(confirmDelete){
					$("[name = deleteHarvestId]:checkbox").each(function(){
						if($(this).attr("checked")){
							var workId=$(this).val();
							if(confirmDelete){
								$(this).closest("tr").remove();
							}
						}
					});
				}
				
				//再删除已经存在的
				if(workIds!=""&&confirmDelete){
					$("#frm").ajaxSubmit({
						url: path + '/soa/kjcg!ajaxDelete.action?menuId='+menuId+'&ram='+ram+'&form.selected='+workIds,
						dataType:"json",
						success: function(data, status)
						{   
							var flag=data.flag;
					        if(flag=="1"){
					        	alert("科技成果删除成功!");
					        	location.href=path+'/soa/kjcg!queryByPerId.action?menuId='+menuId;
					        }else if(flag=="2"){
					        	alert("科技成果删除失败!");
					        }
						},
						error:function()
						{
							alert("科技成果删除失败!");
						}
					});
				}
			}
		}
		function refreshPage() {
			window.location='<%=path%>/soa/kjcg!queryByPerId.action?menuId=${menuId}';
		}
		function preview(param,p1,p2,p3){
			var pnameEnCode=encodeURI(p1);
			location.href=path+'/soa/previewAction.action?menuId='+${menuId}+'&form.uuid='+param+'&form.personDetail.pname='+pnameEnCode+'&form.personDetail.idCard='+p2+'&form.personDetail.auditstate='+p3;
		}
	</script>
</body>
</html>