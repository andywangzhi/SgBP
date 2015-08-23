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
	    var path = '<%=path%>';//var path = '<%=path %>';
	    
	   
		
		  var forage = '<s:property value="form.queryListSO.forage"/>';
	    var toage = '<s:property value="form.queryListSO.toage"/>';
	    // 产生所有的年份
		function addOptsCount(_id,start,count){
			var c = document.getElementById(_id);
			for(var i=start;i<=count;i++){
				var opt = new Option(i,i);
				c.options.add(opt);
			}
		}
    	$(function(){
    		addOptsCount("forage",17,60);
    		$("#forage").val(forage);
    		addOptsCount("toage",17,60);
    		$("#toage").val(toage);
		});
	    
	    function getDate(date){
    		 var dates = date.split("-");  //var dates = date.split("-");
    		 var dateReturn = '';
    		 
    		 for(var i=0; i<dates.length; i++){
    		 if(dates[i].length<2){
    		 	dates[i]="0"+dates[i];
    		 }
    		  dateReturn+=dates[i];
    		 }
    		 return dateReturn;
    		}
	    
	    function getSearch(){
	    	var forage = $("#forage").val();   //var forage = $("#forage").val();
			var torage = $("#toage").val();
			if(forage!=""&&torage!=""&&(getDate(forage)-getDate(torage)>0)){
					alert("年龄开始时间不能大于年龄结束时间！");
					return ;
			}
			var cultureTypeStart = $("#cultureTypeStart").val();
			var cultureTypeStop = $("#cultureTypeStop").val();
			if(cultureTypeStart!=""&&cultureTypeStop!=""&&cultureTypeStart<cultureTypeStop){
					alert("学历的范围需由低到高!");
					return ;
			}
			
			var harvestLevelStart = $("#harvestLevelStart").val(); 
	        var harvestLevelStop = $("#harvestLevelStop").val(); 
	        if(harvestLevelStart!=""&&harvestLevelStop!=""&&harvestLevelStart<harvestLevelStop){
					alert("科级成果级别的范围需由低到高!");
					return ;
			}
			
			document.getElementById('frm').action ="<%=path%>/soa/RsPerson!mhQuery.action?menuId=${menuId}";
		  	document.getElementById('frm').submit();
			}
		
		function uploadExecl(){
			var count=0;
			var pname =document.getElementById('pname').value;
			var pnation =document.getElementById('pnation').value;
			var ppolityvisage =document.getElementById('ppolityvisage').value;
			var cultureType =document.getElementById('cultureType').value;
			var specialtytype =document.getElementById('specialtytype').value;
			var ptrade =document.getElementById('ptrade').value;
			var pquarters =document.getElementById('pquarters').value;
			var economyKind =document.getElementById('economyKind').value;
			var personType =document.getElementById('personType').value;
			var pcounty =document.getElementById('pcounty').value;
			var workCompany =document.getElementById('workCompany').value;
			var dutylevel =document.getElementById('dutylevel').value;
			var technicallyLevel =document.getElementById('technicallyLevel').value;
			var technicallyType =document.getElementById('technicallyType').value;
			var assessDep =document.getElementById('assessDep').value;
			var harvestName =document.getElementById('harvestName').value;
			var harvestLevel =document.getElementById('harvestLevel').value;
			var specialtyName =document.getElementById('specialtyName').value;
			var graduatecollege =document.getElementById('graduatecollege').value;
			var personKind =document.getElementById('personKind').value;
			var psex =document.getElementById('psex').value;
			if(null!=technicallyLevel&&""!=technicallyLevel){ 
				count++;
				}
			
			if(null!=technicallyType&&""!=technicallyType){ 
				count++;
			}
			
			if(null!=assessDep&&""!=assessDep){ 
				count++;
			}
			
			if(null!=harvestLevel&&""!=harvestLevel){ 
				count++;
			}
			
			if(null!=harvestName&&""!=harvestName){ 
				count++;
			}
			
			if(null!=specialtyName&&""!=specialtyName){ 
				count++;
			}
					
			
			if(null!=graduatecollege&&""!=graduatecollege){ 
				count++;
			}
			
			if(null!=personKind&&""!=personKind){ 
				count++;
			}
			
			if(null!=psex&&""!=psex){ 
				count++;
			}
			
			if(null!=pname&&""!=pname){ 
				count++;
				}
			if(null!=pnation&&""!=pnation){ 
					count++;
				}
			if(null!=ppolityvisage&&""!=ppolityvisage){ 
					count++;
				}
			if(null!=cultureType&&""!=cultureType){ 
					count++;
				}
			if(null!=specialtytype&&""!=specialtytype){ 
					count++;
				}
			if(null!=ptrade&&""!=ptrade){ 
					count++;
				}
			if(null!=pquarters&&""!=pquarters){ 
					count++;
				}
			if(null!=economyKind&&""!=economyKind){ 
					count++;
				}
			if(null!=personType&&""!=personType){ 
					count++;
				}
			if(null!=pcounty&&""!=pcounty){ 
					count++;
				}			
			if(null!=workCompany&&""!=workCompany){ 
					count++;
				}
			if(null!=dutylevel&&""!=dutylevel){ 
					count++;
				}
				
			var forage = $("#forage").val();   //var forage = $("#forage").val();
			var torage = $("#toage").val();
			if(forage!=""&&torage!=""){
				if (getDate(forage)-getDate(torage)>0) {
					alert("年龄开始时间不能大于年龄结束时间！");
					return ;
				}
					count++;
			}
				
			if(count>0){
			
			document.getElementById('frm').action="<%=path%>/soa/RsPerson!mhQueryExecl.action?menuId=${menuId}";
			document.getElementById('frm').submit(); 
			}else{
				alert("请输入查询条件!");
				}
		}
		function getRest() {
			document.getElementById('pname').value = '';
			document.getElementById('pnation').value = '';
			document.getElementById('ppolityvisage').value = '';
			document.getElementById('cultureType').value = '';
			document.getElementById('specialtytype').value = '';
			document.getElementById('ptrade').value = '';
			document.getElementById('pquarters').value = '';
			document.getElementById('economyKind').value = '';
			document.getElementById('personType').value = '';
			document.getElementById('pcounty').value = '';
			document.getElementById('workCompany').value = '';
			document.getElementById('dutylevel').value = '';
			
			document.getElementById('technicallyLevel').value = '';
			document.getElementById('technicallyType').value = '';
			document.getElementById('assessDep').value = '';
			document.getElementById('harvestName').value = '';
			document.getElementById('harvestLevel').value = '';
			document.getElementById('specialtyName').value = '';
			document.getElementById('graduatecollege').value = '';
			document.getElementById('personKind').value = '';
			document.getElementById('psex').value = '';
			document.getElementById('toage').value = '';
			document.getElementById('forage').value = '';
			
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
			document.getElementById('currentPage').value = 1 ;
			document.getElementById('frm').action="<%=path%>/soa/RsPerson!mhQuery.action?menuId=${menuId}";
			document.getElementById('frm').submit();
		}
		
		function prePage(curPage) {
			document.getElementById('currentPage').value = (Number(curPage) - 1);
			document.getElementById('frm').action="<%=path%>/soa/RsPerson!mhQuery.action?menuId=${menuId}";
			document.getElementById('frm').submit();
		}
		
		function nextPage(curPage) {
			document.getElementById('currentPage').value = (Number(curPage) + 1);
			document.getElementById('frm').action="<%=path%>/soa/RsPerson!mhQuery.action?menuId=${menuId}";
			document.getElementById('frm').submit();
		}
		
		function endPage(endPage) {
			document.getElementById('currentPage').value = Number(endPage);
			document.getElementById('frm').action="<%=path%>/soa/RsPerson!mhQuery.action?menuId=${menuId}";
			document.getElementById('frm').submit();
		}
	</script>
</head>
<body>
<form id="frm" name="frm" action="<%=path%>/soa/RsPerson!mhQuery.action?menuId=${menuId}" method="post" >  

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：个人信息查询&nbsp;&gt;&nbsp;模糊查询</div>
    <div class="row_r web_paht_r tool">
          <a class="up" href="javascript:uploadExecl();">导出人员信息</a></div>
</div>
<div class="main_in">
    		<div class="table_edit">  
                  <table>
                  	<tr>
                  	<th nowrap="nowrap" style="padding-right: 0px;">姓名：</th>
                  		<td><input style="width:130px;" type="text" id="pname" name="form.queryListSO.pname" value="<s:property value="form.queryListSO.pname" />"  /></td>
                  		
						<th nowrap="nowrap" style="padding-right: 0px;">担任职务：</th>
                  		<td><input style="width:130px;" type="text" id="dutylevel" name="form.queryListSO.dutylevel" value="<s:property value="form.queryListSO.dutylevel" />"  />
                  		</td>
                  		<th nowrap="nowrap" style="padding-right: 0px;">性别：</th>
                  		<td style="width:100px;">
                  			<select style="width:100px;" id="psex" name="form.queryListSO.psex" class="inp">
                  				<option value="">请选择</option>
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
                  		<th nowrap="nowrap" style="padding-right: 0px;">党派：</th>
                  		<td style="width:100px;">
                  			<select style="width:100px;" id="ppolityvisage" name="form.queryListSO.ppolityvisage" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"3\")" var="var" >
                  				<s:if test="form.queryListSO.ppolityvisage == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		
                  		<!-- <th width="75px" nowrap="nowrap" style="padding-right: 0px;">人才分类：</th>
                           <td  nowrap="nowrap" style="width:100px;">
                            <select id="personKind"style="width:100px;"  name="form.queryListSO.personKind" class="inp"">
                            	  <option value="">请选择</option>
                             <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"78\")" id="status" status="st">
                             	  <s:if test="form.queryListSO.personKind==key">
                             	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                             	  </s:if>
                             	  <s:else>
                             	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
                             	  </s:else>
                             </s:iterator>		                         
                            </select>
                           </td> -->
                  		<th nowrap="nowrap" style="padding-right: 0px;">人才类型：</th>
                  		<td style="width:100px;">
                  			<select style="width:100px;" id="personType" name="form.queryListSO.personType" class="inp">
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
                  			
                  	</tr>
                  	<tr>
                  		<th  width="75px" nowrap="nowrap" style="padding-right: 0px;">毕业院校：</th>
						<td>
								<input style="width: 130px;" type="text" id=graduatecollege name="form.queryListSO.graduatecollege"
								value="<s:property value="form.queryListSO.graduatecollege" />" />
						</td>
						 <th nowrap="nowrap" style="padding-right: 0px;">专业名称：</th>
						<td>
							<input style="width: 130px;" type="text" id="specialtyName" name="form.queryListSO.specialtyName"
								value="<s:property value="form.queryListSO.specialtyName" />" />
						</td>
                  	
                  	
                  		<th  width="75px" nowrap="nowrap" style="padding-right: 0px;">专业类别：</th>
                  		<td>
                  			<select style="width:100px;" id="specialtytype" name="form.queryListSO.specialtytype" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"5\")" var="var" >
                  				<s:if test="form.queryListSO.specialtytype == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		
                  		<th nowrap="nowrap" style="padding-right: 0px;">单位所属：</th>
                  		<td>
                  			<s:if test='#session._USER_LOGIN_.getUsertype()=="3" '>
                  				<select style="width:100px;" id="unitlvl" name="form.queryListSO.unitlvl" class="inp">
		                  				<option value="3">县（市、区）单位</option>
	                  			</select>
	                  			
                  			</s:if>
                  			
                  			<s:else>
	                  			<select style="width:100px;" id="unitlvl" name="form.queryListSO.unitlvl" class="inp">
	                  				<option value="">请选择</option>
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"74\")" var="var" >
	                  				<s:if test="form.queryListSO.unitlvl == key">
	                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                  				</s:if>
	                  				<s:else>
	                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
	                  				</s:else>
	                  				</s:iterator>
	                  			</select>
	                  		</s:else>
                  		</td>
                  		
                  		
                  		
                  		<th nowrap="nowrap" style="padding-right: 0px;">现在所在行业：</th>
                  		<td>
                  			<select style="width:100px;" id="ptrade" name="form.queryListSO.ptrade" class="inp">
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
                  		
                  		
                  		
                  	</tr>
                  	
                  	<tr>
                  	
                  		<th nowrap="nowrap" style="padding-right: 0px;">发证单位：</th>
						<td>
									<input style="width: 130px;" type="text" id="assessDep" name="form.queryListSO.assessDep"
									value="<s:property value="form.queryListSO.assessDep" />" />
						</td>
						<th nowrap="nowrap" style="padding-right: 0px;">现在就业单位：</th>
                  		<td><input style="width:130px;" type="text" id="workCompany" name="form.queryListSO.workCompany" value="<s:property value="form.queryListSO.workCompany" />"  />
                  		</td>
                  		
                  		<th nowrap="nowrap" style="padding-right: 0px;">单位性质：</th>
                  		<td>
                  			<select style="width:100px;" id="economyKind" name="form.queryListSO.economyKind" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"10\")" var="var" >
                  				<s:if test="form.queryListSO.economyKind == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		<th  width="75px" nowrap="nowrap" style="padding-right: 0px;">所在县区：</th>
	                  		<td>
	                  			<select style="width:100px;" id="pcounty" name="form.queryListSO.pcounty" class="inp">
	                  				<s:if test='#session._USER_LOGIN_.getUsertype()=="3"'>
	                  					<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")" var="var" >
			                  				<s:if test="#session._USER_LOGIN_.usercountry == key">
		                  						<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
			                  				</s:if>
	                  					</s:iterator>
	                  					
	                  				</s:if>
	                  				
	                  				<s:else>
	                  					<option value="">请选择</option>
		                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")" var="var" >
		                  						<s:if test="form.queryListSO.pcounty == key">
		                  							<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
			                  					</s:if>
			                  					<s:else>
			                  						<option value="<s:property value="key"/>"><s:property value="value"/></option>
			                  					</s:else>
		                  				</s:iterator>
		                  			</s:else>
	                  			</select>
                  		</td>
                  		 <th nowrap="nowrap" style="padding-right: 0px;">民族：</th>
                  			<td style="width:100px;">
                  			<select style="width:100px;" id="pnation" name="form.queryListSO.pnation" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"2\")" var="var" >
                  				<s:if test="form.queryListSO.pnation == key">
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
                  		
                  		<th nowrap="nowrap" style="padding-right: 0px;">科技成果名称：</th>
						<td>
								<input style="width: 130px;" type="text" id="harvestName" name="form.queryListSO.harvestName"
										value="<s:property value="form.queryListSO.harvestName" />" />
						</td>
								
						<th width="100px"  nowrap="nowrap" style="padding-right: 0px;">科技成果级别：</th>
                           <td  nowrap="nowrap" colspan="2">
                            <select id="harvestLevelStart" name="harvestLevelStart" class="inp" style="width:80px;">
                            	  <option value="">请选择</option>
                             <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"13\")" id="status" status="st">
                             	  <s:if test="harvestLevelStart==key">
                             	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                             	  </s:if>
                             	  <s:else>
                             	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
                             	  </s:else>
                             </s:iterator>		                         
                            </select>至
                            <select id="harvestLevelStop" name="harvestLevelStop" class="inp" style="width:80px;">
                            	  <option value="">请选择</option>
                             <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"13\")" id="status" status="st">
                             	  <s:if test="harvestLevelStop == key">
                             	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                             	  </s:if>
                             	  <s:else>
                             	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
                             	  </s:else>
                             </s:iterator>		                         
                            </select>
                           </td>
                  		
                  		
                  		
                  		
                  		<th nowrap="nowrap" style="padding-right: 0px;">学历：</th>
                  		<td colspan="2">
                  			<select style="width:70px;" id="cultureTypeStart" name="form.queryListSO.cultureType" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" var="var" >
                  				<s:if test="cultureTypeStart == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>至
                  			<select style="width:70px;" id="cultureTypeStop" name="form.queryListSO.cultureType" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" var="var" >
                  				<s:if test="cultureTypeStop == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		
                  		<th nowrap="nowrap" style="padding-right: 0px;">现在从事岗位：</th>
                  		<td>
                  			<select style="width:100px;" id="pquarters" name="form.queryListSO.pquarters" class="inp">
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
						<th nowrap="nowrap" style="padding-right: 0px;">技能专业名称：</th>
                  				<td>
										<input style="width: 130px;" type="text" id="technicallyType" name="form.queryListSO.technicallyType"
										value="<s:property value="form.queryListSO.technicallyType" />" />
								</td>
                  		
                  		<th  width="75px" nowrap="nowrap" style="padding-right: 0px;">
                  		<select style="width:95%;" id="technicallyLevel" name="technicallyLevel" class="inp">
                  		<option value="1" selected="selected">职称级别</option>
                  		<option value="2">技能级别</option>
                  		</select>
                  		</th>
                  		<td colspan="3" >
                  			<select style="width:135px;" id="technicallyLevelStart" name="technicallyLevelStart" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"12\")" var="var" >
                  				<s:if test="technicallyLevelStart == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select> 至 
                  			<select style="width:135px;" id="technicallyLevelStop" name="technicallyLevelStop" class="inp">
                  				<option value="">请选择</option>
                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"12\")" var="var" >
                  				<s:if test="technicallyLevelStop == key">
                  					<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
                  				</s:if>
                  				<s:else>
                  					<option value="<s:property value="key"/>"><s:property value="value"/></option>
                  				</s:else>
                  				</s:iterator>
                  			</select>
                  		</td>
                  		<th width="90px" nowrap="nowrap" style="padding-right: 0px;">年龄段：</th>
                      	<td nowrap="nowrap" colspan="3" >
                      		<select style="width:100px;" id="forage" name="form.queryListSO.forage" >
                            <option value="">请选择</option>  
                            </select>  至　 
                            <select style="width:100px;margin-left: 15px;" id="toage" name="form.queryListSO.toage">
                        	<option value="">请选择</option>  
                        	</select>
                       	</td>                  		
                  	</tr>                 	
                  	<tr>
                  		<td colspan="10" align="center">
                  			<a class="btn_search" onclick="getSearch()">搜  索</a>&nbsp;&nbsp;
                  			<a class="btn_search" onclick="getRest()">重  置</a>
                  		</td>
                  	</tr>
                  </table>
              </div>
              
              <div class="table_edit" style="height: 265px;">
                  <table>
                      <thead>
                      	  <th nowrap="nowrap"><p align="center">预览</p></th>
                          <th nowrap="nowrap"><p align="center">姓名</p></th>                     
                          <th nowrap="nowrap"><p align="center">性别</p></th>
                          <th nowrap="nowrap"><p align="center">民族</p></th>
                          <th nowrap="nowrap"><p align="center">党派</p></th>
                          <th nowrap="nowrap"><p align="center">公民身份号码</p></th>
                          <th nowrap="nowrap"><p align="center">户口所在地</p></th>
                          <th nowrap="nowrap"><p align="center">最高学历</p></th>
                          <th nowrap="nowrap"><p align="center">专业类别</p></th>
                          <th nowrap="nowrap"><p align="center">现在所在行业</p></th>
                          <th nowrap="nowrap"><p align="center">现从事岗位</p></th>
                          <th nowrap="nowrap"><p align="center">单位性质</p></th>
                          <th nowrap="nowrap"><p align="center">所在县区</p></th>
                          <th nowrap="nowrap"><p align="center">现在就业单位</p></th>
                          <th nowrap="nowrap"><p align="center">担任职务</p></th>
                          <th nowrap="nowrap"><p align="center">人才类型</p></th>
                          <th nowrap="nowrap"><p align="center">删除状态</p></th>
                          <th nowrap="nowrap"><p align="center">审核状态</p></th>
                          
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
								  <td nowrap="nowrap"><a href="javascript:preview('<s:property value="#personInfo.personId"/>');"><img src="<%=path%>/business/images/View_file.gif"/></a></td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.pname" /></td>
				                  <td>
	                  				<input type="hidden" id="personTypes_<s:property value="#st.index" />" name="personTypes" value="<s:property value="#personInfo.personType" />" />
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
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" var="var" >
	                  				<s:if test="#personInfo.cultureType == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
	                  			  </td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"5\")" var="var" >
	                  				<s:if test="#personInfo.specialtytype == key">
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
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" var="var" >
	                  				<s:if test="#personInfo.pquarters == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"10\")" var="var" >
	                  				<s:if test="#personInfo.economyKind == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap">
	                  				<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")" var="var" >
	                  				<s:if test="#personInfo.pcounty == key">
	                  					<s:property value="value"/>
	                  				</s:if>
	                  				</s:iterator>
				                  </td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.workCompany" /></td>
				                  <td nowrap="nowrap"><s:property value="#personInfo.dutylevel" /></td>
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
	                              <td align="center" nowrap="nowrap">
		                              <s:if test="#personInfo.delestate==0">
		                             		<font color="green">未删除</font>
		                              </s:if>
		                              <s:else>
		                              		<font color="red">已删除</font>
		                              </s:else>
		                          </td>
					               <td align="center" nowrap="nowrap">
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
				          	<td colspan="17">
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