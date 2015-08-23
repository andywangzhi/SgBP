<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<title>人才需求编辑</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/external/css/table.css"/>
	
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
		.table1 {margin:10px auto 0px auto; width:100%;border-collapse:collapse}
		.table1 img { vertical-align:middle}
		.table1 th,.table1 td {border:1px solid #cacaca;padding:0px 6px 0px 6px;height:32px;}
		.table1 caption {margin:0px auto 0px auto;padding:2px 0px 0px 12px; line-height:32px;color:#15689c;font-size:14px;font-weight:bold; text-align:left;background: url(../images/img/0_22.gif) -5px 10px no-repeat;}
		.table1 thead th {background-color:#d4f8fd;color:#1777aa; font-weight:normal;}
		.table1 tbody th {color:#333;text-align:right; font-weight:lighter;}
		.table1 tbody td {color:#333;vertical-align:middle;}
		.table1 tbody td img { vertical-align:middle}
		.table1 tfoot th {}
		.table1 tfoot td {border-width:0px;font-size:12px;color:#777;}
		.table1 tfoot a {}
		.table1 tfoot a:hover { text-decoration:underline}
		.table1 h3 {font-size:16px; font-family:"Microsoft YaHei",SimHei, Geneva, sans-serif; font-weight:bold;color:#681902; letter-spacing:8px; text-align:left; text-indent:12px;}
				
	</style>
    <script type="text/javascript">
    	var path='<%=path%>';
    	
		function modify(param,param2){
			var str=$("#"+param).find("option:selected").text(); 
			var strOther=$("#"+param+"other");
			var cultureTypeDiv=$("#"+param+"Div");
			if(str=="其他"){
				cultureTypeDiv.show();
				//strOther.attr("value",param2);
			}else{
				cultureTypeDiv.hide();
			}
		}
		$(function(){
			modify("needstation","");
			modify("neededucation","");
			if("<s:property value="form.business" />" == "view"){
				$("select").attr("readonly","true");
				$("input").attr("readonly","true");
				$("textarea").attr("readonly","true");
				
			}
		})
		function saveAt(){
			location.href = path+"/soa/rsPersonneed!toneedlist.action";
		}
		function toadd(){
			var ram=Math.random();
			var needno = $("#attenneedno").val();
			var needcopname = $("#attenneedcopname").val();
			$("#attenmes").action = path+"/external/rsPerson!tjQuery.action?ram"+ram;
			$("#attenmes").submit();			
		}

		function checkSelect() {
			var selectInt = "";			
			$("input[name='attentionid']").each(function(){
				if(this.checked){
					selectInt +=$(this).val()+",";
				}
			});
			return selectInt;
		}
		
		function todel()
		{
			var selectInt = checkSelect();			
			var ram=Math.random();
			if(selectInt == '') {
				alert('请选择要删除的记录!');
			} else {
				var ids = selectInt.substring(0,selectInt.length-1);
				$.post(path+'/external/rsAttention!delAttention.action?form.rsAttention.attentionid='+ids+'&ram='+ ram,fnback,"json");	
			   	function fnback(data){
			   		var flag=data.flag;
			   		if(flag==0){
			   			alert("删除成功!");
			   			toviewpage();			   			
			   		}else{
			   			alert("删除失败!");
			   		}
			   	}				
			}
		}
		function toviewpage(){
			var id = $("#needid").val();
   			location.href = path+"/external/rsPersonneed!toviewpage.action?form.rsPersonneed.needid="+id;	
		}
			
    </script>
</head>
<body>
<form id="attenmes" action="<%=path%>/external/rsPerson!tjQuery.action" method="post" >
	<input type="hidden" name="form.rsPerson.adduser" id="attenneedno" readonly='true' value="<s:property value="form.rsPersonneed.needcopname" />" type="text"  style="width:120px;" />
	<input type="hidden" name="form.needno" id="attenneedname" readonly='true' value="<s:property value="form.rsPersonneed.needno" />" type="text"  style="width:250px;" />	
</form>
<div class="main_in">
    <form id="frm" name="frm" method="post" action="">
    <table class="table1" cellpadding="0" cellspacing="0" style="width:100%;">
                          <tbody>
                         
        	    	 	<input name="form.rsPersonneed.needid" id="needid" readonly='true' value="<s:property value="form.rsPersonneed.needid" />" type="hidden"  style="width:120px;" /></span>
			            <input name="form.rsPersonneed.adduser"  readonly='true' value="<s:property value="form.rsPersonneed.adduser" />" type="hidden"  style="width:120px;" /></span>
			                    <tr></tr>
              					<tr>
			                    <th>编号：</th>
			                    <td colspan="3"><input name="form.rsPersonneed.needno" id="attenneedno" readonly='true' value="<s:property value="form.rsPersonneed.needno" />" type="text"  style="width:120px;" /></td>
			                    <th>日期：</th>
			                    <td><input name="form.rsPersonneed.adddate" readonly='true' value="<s:property value="form.rsPersonneed.adddate" />" type="text"  style="width:120px;" /></td>
			                 </tr>  				
							<th>招聘单位：</th><td style="width:200px;"><input name="form.rsPersonneed.needcopname" id="attenneedcopname" readonly='true' value="<s:property value="form.rsPersonneed.needcopname" />" type="text"  style="width:97%;" /></td>
							<th>联系人：</th><td style="width:150px;"><input name="form.rsPersonneed.needtelname" id="needtelname" value="<s:property value="form.rsPersonneed.needtelname" />" type="text"  style="width:120px;" /></td>
							<th>联系电话：</th style="width:150px;"><td><input name="form.rsPersonneed.needphone" id="needphone" type="text" value="<s:property value="form.rsPersonneed.needphone" />" style="width:120px;" /></td>
						
                      
                              <tr>
                                  <th>需求岗位：</th>
                                  <td style="width:130px;">
                                  <select id="needstation" name="form.rsPersonneed.needstation" value="<s:property value="form.rsPersonneed.needstation" />" style="width:97%;" class="inp" onchange="modify('needstation','');">
			                      
			                      <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="status" status="st">
			                      	  <s:if test="form.rsPersonneed.needstation==key">
		                              	 <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              </s:if>
		                              <s:if test="form.business!='view' && form.rsPersonneed.needstation!=key">
		                              	 <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              </s:if>                      	 
			                      </s:iterator>		                         
			                      </select>
								  <div id="needstationDiv" style="display:none">
								  <input id="needstationother" name="form.rsPersonneed.needstationother" type="text" value="<s:property value="form.rsPersonneed.needstationother" />" class="inp"  style="width: 97%; "  maxlength="32"/>
								  </div>
                                  </td>
                                  <th>学历要求：</th>
                                  <td style="width:120px;">
                                  <select id="neededucation" name="form.rsPersonneed.neededucation" value="<s:property value="form.rsPersonneed.neededucation" />" class="inp" style="width: 97%; "  onchange="modify('neededucation','');">
			                      <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" id="status" status="st">
			                      	  <s:if test="form.rsPersonneed.neededucation==key">
		                              	 <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              </s:if>
		                              <s:if test="form.business!='view' && form.rsPersonneed.neededucation!=key">
		                              	 <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              </s:if> 
			                      	  
			                      </s:iterator>		                         
			                      </select>
							      <div id="neededucationDiv" style="display:none"><input id="neededucationother" name="form.rsPersonneed.neededucationother" type="text" value="<s:property value="form.rsPersonneed.neededucationother" />" class="inp"  style="width: 97%; "  maxlength="32"/></div>
					  
                                  </td>
                                  <th >职称要求：</th>
                                  <td style="width:120px;">
                                  <select id="needpost" name="form.rsPersonneed.needpost" value="<s:property value="form.rsPersonneed.needpost" />" class="inp" style="width: 97%; ">
			                      <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"12\")" id="status" status="st">
			                      	  <s:if test="form.rsPersonneed.needpost==key">
		                              	 <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              </s:if>
		                              <s:if test="form.business!='view' && form.rsPersonneed.needpost!=key">
		                              	 <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              </s:if> 
			                      </s:iterator>		                         
			                      </select>
							      
                                  </td>
                              </tr>
                              <tr>
                                  <th>急需人数：</th>
                                  <td><input name="form.rsPersonneed.needcount" id="needcount" value="<s:property value="form.rsPersonneed.needcount" />" type="text"  style="width:120px;" /></td>
                                  <th>性别要求：</th>
                                  <td>
                                  <select id="needsex" name="form.rsPersonneed.needsex" value="<s:property value="form.rsPersonneed.needsex" />" class="inp" style="width: 97%; ">			                      	  
		                              <s:if test="form.business!='view'">
		                              	 <option value="无">无</option>
	                         		  	 <option value="男">男</option>
	                         		     <option value="女">女</option>
		                              </s:if> 
		                              <s:else>
		                              	  <option value="<s:property value="form.rsPersonneed.needsex" />" ><s:property value="form.rsPersonneed.needsex" /></option>
			                      	  </s:else>
			                      </select>
                                  </td>
                                  <th>年龄要求：</th>
                                  <td><input name="form.rsPersonneed.needage" value="<s:property value="form.rsPersonneed.needage" />" type="text"  style="width:120px;" /></td>
                              </tr>
                              <tr>
                              	  <th>专业：</th>
                                  <td style="width:100px;">
                                  <select id="needpost" name="form.rsPersonneed.backuptwo" value="<s:property value="form.rsPersonneed.backuptwo" />" class="inp" style="width: 97%; ">
			                      <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"5\")" id="status" status="st">
			                      	  <s:if test="form.rsPersonneed.backuptwo==key">
		                              	 <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              </s:if>
		                              <s:if test="form.business!='view' && form.rsPersonneed.backuptwo!=key">
		                              	 <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              </s:if> 
			                      </s:iterator>		                         
			                      </select>
                                  </td>                                 
                                  <th>研究方向：</th>
                                  <td colspan="3"><input name="form.rsPersonneed.needresdir" style="width:95%;" value="<s:property value='form.rsPersonneed.needresdir'/>" /></td>
                              </tr>
                              <tr>
                                  <th>技术、项目<br />或其他要求：</th>
                                  <td colspan="5" style="padding:5px;"><textarea name="form.rsPersonneed.needdemand"  cols="" rows="" style=" width:100%;height:50px"><s:property value="form.rsPersonneed.needdemand" /></textarea></td>
                              </tr>
                              <tr>
                                  <th>提供的待遇：</th>
                                  <td colspan="5" style="padding:5px;"><textarea name="form.rsPersonneed.remark"  cols="" rows="" style=" width:100%;height:30px"><s:property value="form.rsPersonneed.needdemand" /></textarea></td>
                              </tr>
                              <tfoot>
                                  <tr style="height:60px;">
                                      <td colspan="6" align="center"><button id="save" name="save" type="" onclick="saveAt();" class="btn1"  />返	回</button></td>
                                  </tr>
                              </tfoot>
                          </tbody>
                      </table>
                     <!--  <div align="left">
	                            <a onclick="toadd();" class="btn_search">推荐</a>
	                            <a onclick="todel();" class="btn_search">删除</a>		                         
                              </div>
                              
                              <table id="attenlist" class="table1" cellpadding="1" cellspacing="1" style="width:100%;">
                                  <thead>
                                      <tr>
                                      	  <th>选择</th>                                   	  
                                          <th>姓名</th>
                                          <th>性别</th>                                                                                  
                                          <th>政治面貌</th>
                                          <th>文化程度</th>
                                          <th>专业类别</th>
                                          <th>专业名称</th>
                                          <th>联系电话</th>
                                          <th>电子邮箱</th>                                          
                                          
                                      </tr>
                                  </thead>
                                  <tbody id="dataBody">
                                     <s:if test="form.attenList.size() >0 ">
					                      <s:iterator value="form.attenList" id="status" status="st">
					                          <tr>				                          	   					                              
					                          	  <td align="center">
					                              	<input type="checkbox" name="attentionid" value="<s:property value="#status.attentionid" />"/>					                              	
												  </td>	 
												  
					                              
					                              <td align="center" nowrap="nowrap"><s:property value="#status.rsPerson.pname" /></td>					
					                              <td>
			                                      <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" var="var" >
						                  				<s:if test="#status.rsPerson.psex == key">
						                  					<s:property value="value"/>
						                  				</s:if>
						                  		  </s:iterator>
												  </td>
					                              
					                              <td align="center" nowrap="nowrap">
					                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"3\")" var="var" >
						                  				<s:if test="#status.rsPerson.ppolityvisage == key">
						                  					<s:property value="value"/>
						                  				</s:if>
						                  		  </s:iterator>
						                  		  </td>
					                              <td align="center" nowrap="nowrap">
					                              	<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" status="var">					                             		
						                      	  		<s:if test="#status.rsPerson.culturetype == key">
						                  					<s:property value="value"/>
						                  				</s:if>
						                      		</s:iterator>	
					                              </td>
					                              <td align="center" nowrap="nowrap">
					                              	<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"5\")" status="var">					                             		
						                      	  		<s:if test="#status.rsPerson.specialtytype == key">
						                  					<s:property value="value"/>
						                  				</s:if>
						                      		</s:iterator>	
					                              </td>
					                              
					                              <td align="center" nowrap="nowrap"><s:property value="#status.specialtyname" /></td>			                            
						                          <td align="center" nowrap="nowrap"><s:property value="#status.rsPerson.pphone" /></td>
					                              
					                              <td align="center" nowrap="nowrap"><s:property value="#status.pemail" /></td>			                            
						                          
					                          </tr>
					                       </s:iterator>
                       					</s:if>
                       				  </tbody>                                      
                              </table> -->
                      </form>

</body>
</html>