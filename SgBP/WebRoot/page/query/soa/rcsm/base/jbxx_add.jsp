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
    <title>人员基本信息添加页面</title>
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="business/css/reset.css" />
    <script type="text/javascript" src="js/query/date.js" charset="UTF-8"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/idCardCheck.js"></script>
    <script type="text/javascript" src="js/jquery-form-3.14.js"></script>
    <script type="text/javascript" src="js/query/rcsm/base/jbxx.js"></script>
    <script type="text/javascript">
    	var path = '<%=path%>'; 
    	var menuId='<%=request.getParameter("menuId")%>';
    	var clicked=true;
    	var entrance='<%=request.getParameter("entrance")%>';
    </script>
    
<script type="text/javascript">    
    document.onkeydown=function enterToTab() {    
    if(event.srcElement.type != 'submit' && event.srcElement.type!="image" && event.srcElement.type != 'textarea' && event.keyCode == 13 && event.srcElement.type!="file")    
    event.keyCode = 9;    
    }    
</script> 
  </head>
  
<body> 

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置:人员信息<script type="text/javascript">if(entrance==1){document.write("申报");}else{document.write("维护");}</script>&nbsp;&gt;&nbsp;人员基本信息</div>
    <div class="row_r web_paht_r tool">
        
    </div>
</div>

       <form id="frm" name="frm" action="<%=path%>/soa/RsPerson!saveOrUpdate.action?menuId=<%=request.getParameter("menuId")%>" method="post" enctype="multipart/form-data">
       <input type="hidden" id="combinePersonType" name="form.dto.personType"/>
       <input type="hidden" id="registeraddrprov" value="<s:property value="form.dto.registeraddrprov"/>"/>
       <input type="hidden" id="registeraddrcity" value="<s:property value="form.dto.registeraddrcity"/>"/> 
        <input type="hidden" name="form.dto.adduser" value="<s:property value="form.dto.adduser"/>"/> 
        <input type="hidden" name="form.dto.adddate" value="<s:property value="form.dto.adddate"/>"/> 
        <input type="hidden" name="form.dto.deleuser" value="<s:property value="form.dto.deleuser"/>"/> 
        <input type="hidden" name="form.dto.deledate" value="<s:property value="form.dto.deledate"/>"/> 
        <input type="hidden" name="form.dto.checkuser" value="<s:property value="form.dto.checkuser"/>"/> 
        <input type="hidden" name="form.dto.checkdate" value="<s:property value="form.dto.checkdate"/>"/> 
        <input type="hidden" name="form.dto.validateuser" value="<s:property value="form.dto.validateuser"/>"/> 
        <input type="hidden" name="form.dto.validatedate" value="<s:property value="form.dto.validatedate"/>"/> 
        <input type="hidden" name="form.dto.audituser" value="<s:property value="form.dto.audituser"/>"/> 
        <input type="hidden" name="form.dto.auditdate" value="<s:property value="form.dto.auditdate"/>"/> 
        <input type="hidden" name="form.dto.sourcetype" value="<s:property value="form.dto.sourcetype"/>"/> 
        <input type="hidden" name="form.dto.batchcode" value="<s:property value="form.dto.batchcode"/>"/> 
        <input type="hidden" name="form.dto.premark" value="<s:property value="form.dto.premark"/>"/> 
        
       <s:if test="form.dto.personId!=null">
       	<input type="hidden" id="form.dto.personId" name="form.dto.personId" value="<s:property value="form.dto.personId"/>"/>
       </s:if>

       <s:if test="form.dto.auditstate!=null">
       	  <input type="hidden" name="form.dto.auditstate" value="<s:property value="form.dto.auditstate"/>"/>
       </s:if>
       <s:else>
          <input type="hidden" name="form.dto.auditstate" value="000"/>
       </s:else>
       
       <s:if test="form.dto.delestate!=null">
       	  <input type="hidden" name="form.dto.delestate" value="<s:property value="form.dto.delestate"/>"/>
       </s:if>
       <s:else>
          <input type="hidden" name="form.dto.delestate" value="0"/>
       </s:else>
       
       
       <s:if test="form.dto.deleapplystate!=null">
       	  <input type="hidden" name="form.dto.deleapplystate" value="<s:property value="form.dto.deleapplystate"/>"/>
       </s:if>
       <s:else>
          <input type="hidden" name="form.dto.deleapplystate" value="0"/>
       </s:else>
       
       <s:if test="form.dto.auditapplystate!=null">
       	  <input type="hidden" name="form.dto.auditapplystate" value="<s:property value="form.dto.auditapplystate"/>"/>
       </s:if>
       <s:else>
          <input type="hidden" name="form.dto.auditapplystate" value="0"/>
       </s:else>
       
         
              <div class="table_yl">
              
              	<div class="table_t"><h2>人才基本信息</h2></div>
                  <table>
                      <tbody>
						  <tr><th class="tbody_t" colspan="8" nowrap="nowrap"><h3>基本信息</h3></th></tr>                      
                      
                          <tr>
                            <th width="90px" nowrap="nowrap">姓名(<font color="red">*</font>):</th>
                            <td nowrap="nowrap" align="left">
                              <s:if test="form.dto.pname!=null">
                              	  <input id="pname" name="form.dto.pname" type="text" readonly="true" value="<s:property value="form.dto.pname"/>" class="inp" style="width:90px;" />
                              </s:if>
                              <s:else>
                              	  <input id="pname" name="form.dto.pname" type="text" value="" class="inp" maxlength="32" style="width:90px;" />
                              </s:else>
                             </td>
                            <td nowrap="nowrap">
                            	<s:if test="form.dto.psex!=null">
	                            	<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" id="status" status="st">
	                             		<s:if test="form.dto.psex==key">
	                             			<input name="psex" type="radio" value="<s:property value="key"/>" checked="checked" readonly="readonly"/><s:property value="value"/>
	                             		</s:if>
									</s:iterator>
                            	</s:if>
                            	<s:else>
	                            	<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" id="status" status="st">
	                             		<input name="psex" type="radio" value="<s:property value="key"/>"/><s:property value="value"/>
									</s:iterator>
                            	</s:else>
                             	
							</td>
                            <th width="90px" nowrap="nowrap">民族:</th>
                              <td align="left">
	                              <select name="form.dto.pnation" class="inp"">
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"2\")" id="status" status="st">
		                              	  <s:if test="form.dto.pnation==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                            </td>
                            <th width="90px" nowrap="nowrap">党派:</th>
                              <td width="180" align="left">
	                              <select name="form.dto.ppolityvisage" class="inp"">
	                              		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"3\")" id="status" status="st">
		                              	 	  <s:if test="form.dto.ppolityvisage==key">
				                              	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
				                              </s:if>
				                              <s:else>
				                               	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
				                              </s:else>
			                              </s:iterator>
	                              </select>
                              </td>
                              <td rowspan="4" id="localImag" style="width:144px; vertical-align:middle; text-align:center;border-bottom:  1px #fff solid;">
                              <s:if test="form.affixList.size() > 0 ">
                       				<s:iterator value="form.affixList" id="affix" status="st">
                                   		<s:if test="#affix.affixType == \"1\"">
                               			<input type="hidden" value="<s:property value="#affix.affixId"/>" name="rsAffix.affixId"/>
                                   		<img id="showPic" style=" width: 183px; height:130px;" src="<%=path%>/soa/RsAffixAction!showImage.action?affixId=<s:property value="#affix.affixId" />" />
                                   	</s:if>
                                  </s:iterator>
                               </s:if>
                               <s:else>
                               	<img id="showPic" alt="请上传相片" style="width:144px; height:130px; " src="" />
                               </s:else> 
                              </td>
                             
                          </tr>
                          <tr>
                           	<th nowrap="nowrap">公民身份号码(<font color="red">*</font>):</th>
                          	<td colspan="6" align="left">
                          		<p align="left">
	                          	 <s:if test="form.dto.idCard!=null">
	                          	 	<input id="idCard" name="form.dto.idCard" type="text" readonly="true" value="<s:property value="form.dto.idCard"/>" class="inp" style="width: 97%; " maxlength="18"/>
	                          	 </s:if>
	                          	 <s:else>
	                            	<input id="idCard" name="form.dto.idCard" type="text" value="" class="inp" style="width: 97%"  maxlength="18" onblur="checkIdCard();"/>
	                             </s:else>
	                             </p>
                             </td>
                          </tr>
                          <tr>
                          	  <th width="90px" nowrap="nowrap">毕业院校:</th>
                              <td colspan="3" align="left">
                              	<input id="graduatecollege" name="form.dto.graduatecollege" type="text" value="<s:property value="form.dto.graduatecollege"/>" class="inp" style="width: 97%; "  maxlength="100"/>
                              </td>
							  <th width="90px" nowrap="nowrap">专业名称:</th>
                              <td colspan="2" align="left"><input id="specialtyName" name="form.dto.specialtyName" type="text" value="<s:property value="form.dto.specialtyName"/>" class="inp"  style="width: 97%; " maxlength="100"/></td>
                          </tr>
                          <tr>
                           <th width="90px" nowrap="nowrap">最高学历:</th>
                              <td colspan="3" align="left">
	                              <select id="cultureType" name="form.dto.cultureType" class="inp" style="width: 97%; "  onchange="modify('cultureType','<s:property value="form.dto.culturetypeother"/>');">
	                              	  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" id="status" status="st">
	                              	  	  <s:if test="form.dto.cultureType==key">
	                              	  	  	 <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	     <option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
		                          </select>
								  <s:if test="form.dto.cultureType!=null&&form.dto.cultureType==#application._WEB_SYS_CONF_KEY_.get(\"4\").size()">
	                         			 <div id="cultureTypeDiv" style="display: block"><input id="cultureTypeother" name="form.dto.culturetypeother" type="text" value="<s:property value="form.dto.culturetypeother"/>" class="inp" style="width: 97%; "  maxlength="32"/></div>
	                               </s:if>
	                              <s:else>
	                               		 <div id="cultureTypeDiv" style="display: none"><input id="cultureTypeother" name="form.dto.culturetypeother" type="text" value="<s:property value="form.dto.culturetypeother"/>" class="inp"  style="width: 97%; "  maxlength="32"/></div>
	                              </s:else>
                              
		                      </td>
                           <th width="90px" nowrap="nowrap">专业类别:</th>
                              <td colspan="2" align="left">
	                              <select name="form.dto.specialtytype" class="inp">
	                              	  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"5\")" id="status" status="st">
	                              	  	 <s:if test="form.dto.specialtytype==key">
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
                           <th width="90px" nowrap="nowrap">学历类别:</th>
                              <td colspan="3" align="left">
	                              <select id="xllb" name="form.dto.xllb" class="inp" style="width: 97%; " >
	                              	  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"76\")" id="status" status="st">
	                              	  	  <s:if test="form.dto.xllb==key">
	                              	  	  	 <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	     <option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
		                          </select>
		                      </td>
                           <th width="90px" nowrap="nowrap">研究方向:</th>
                              <td colspan="2" align="left"><input id="yjfx" name="form.dto.yjfx" type="text" value="<s:property value="form.dto.yjfx"/>" class="inp"  style="width: 97%; " maxlength="100"/></td>
                               <td>
                              	<font color="red" style="font-size: 11px; font-family: 宋体;">相片大小不超过1M<br/>尺寸不超过1寸</font>
                              	<input style="width:144px;" type="file" id="uploadFile" name="uploadFile" onchange="setImagePreview();"  tabindex=-1/>
                              </td>
                          </tr>
                          <tr>
                          	<th width="90px" nowrap="nowrap">通讯住址:</th>
                            <td colspan="4" align="left"><input id="messageAddr" name="form.dto.messageAddr" type="text" value="<s:property value="form.dto.messageAddr"/>" class="inp" style="width: 97%; "  maxlength="100"/></td>
                            
							 <th width="95px" nowrap="nowrap">现户口所在地:</th>
                              <td align="left">
                               <s:if test="form.dto.registeraddrprov!=null">
	                              <select id="regProv" name="form.dto.registeraddrprov" class="inp" onchange="retrieveRegCity();">
	                              	  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"6\")" id="status" status="st">
	                              	   <s:if test="form.dto.registeraddrprov==key">
	                              	  	      <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	   	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
		                          </select>
		                        </s:if>
		                        <s:else>
		                           <select id="regProv" name="form.dto.registeraddrprov" class="inp" onchange="retrieveRegCity();">
		                         	 <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"6\")" id="status" status="st">
		                         			 <s:if test="key==20">
	                              	  	   	  	<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	   	 </s:if>
	                              	  	   	 <s:else>
	                              	  	   	 	<option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	   	 </s:else>
		                              </s:iterator>	
		                           </select>
		                        </s:else>
                              </td>
                              <td id="regCity" align="left">
                              	  <s:if test="form.dto.registeraddrcity!=null">
                              	  	  <select id="registeraddrcity" name="form.dto.registeraddrcity" class="inp">
		                                   <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"7\")" id="status" status="st">
		                              	   	  <s:if test="form.dto.registeraddrcity==key">
		                              	  	      <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  	  </s:if>
			                              </s:iterator>	
		                              </select>
                              	  </s:if>
                              	  <s:else>
                              	  	 <select id="registeraddrcity" name="form.dto.registeraddrcity" class="inp">
											<option value="217" selected="selected">韶关市</option>
											<option value="213">广州市</option>
											<option value="214">深圳市</option>
											<option value="215">珠海市</option>
											<option value="216">汕头市</option>
											<option value="218">佛山市</option>
											<option value="219">江门市</option>
											<option value="220">湛江市</option>
											<option value="221">茂名市</option>
											<option value="222">肇庆市</option>
											<option value="223">惠州市</option>
											<option value="224">梅州市</option>
											<option value="225">汕尾市</option>
											<option value="226">河源市</option>
											<option value="227">阳江市</option>
											<option value="228">清远市</option>
											<option value="229">东莞市</option>
											<option value="230">中山市</option>
											<option value="231">潮阳市</option>
											<option value="232">揭阳市</option>
											<option value="233">云浮市</option>
		                              </select>
                              	  </s:else>
                              </td>
                          </tr>
                          <tr>
                             <th width="100px" nowrap="nowrap">联系电话(<font color="red">*</font>):</th>
                            <td width="17%;" colspan="2" align="left">
                              <s:if test="form.dto.pphone!=null">
                               		<input id="pphone" name="form.dto.pphone" type="text" value="<s:property value="form.dto.pphone"/>" class="inp" style="width: 97%; "  maxlength="40"/>
                               </s:if>
                               <s:else>
                               		<input id="pphone" name="form.dto.pphone" type="text" value="<s:property value="form.dto.pphone"/>" class="inp" style="width: 97%; "  maxlength="40"/>
                               </s:else>
                            </td>
                              <th width="100px" nowrap="nowrap">电子邮箱:</th>
                              <td colspan="2" align="left">
                              	  <s:if test="form.dto.pemail!=null">
                              			<input id="pemail" name="form.dto.pemail" type="text" value="<s:property value="form.dto.pemail"/>" class="inp"  style="width: 97%; " maxlength="100"/>
                              	  </s:if>
                              	  <s:else>
                              			<input id="pemail" name="form.dto.pemail" type="text" value="@" class="inp" maxlength="40" style="text-align: center; width: 97%;" />
                              	  </s:else>
                              </td>
                              <th width="90px" nowrap="nowrap">邮  编:</th>
                              <td align="left"><input id="ppost" name="form.dto.ppost" type="text" value="<s:property value="form.dto.ppost"/>" class="inp" style="width: 95%; "  maxlength="6"/></td>
                          </tr>
                      </tbody>
                  </table>
              </div>
        	
        	<div class="table_yl">
        	
                  <table>                  
                      <tbody>
 						  <tr>
 						  <th class="tbody_t" colspan="4" nowrap="nowrap"><h3>职业现状</h3></th>
 						  </tr>                       
                      
                          <tr>
                            <th width="90px" nowrap="nowrap">现所在行业:</th>
                              <td align="left">
	                              <select id="ptrade" name="form.dto.ptrade" class="inp" onchange="modify('ptrade','<s:property value="form.dto.ptradeother"/>');" style="width: 250px;">
	                              	  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"8\")" id="status" status="st">
	                              	     <s:if test="form.dto.ptrade==key">
	                              	  	      <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	      <option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
		                          </select>
		                          <div>
									<s:if test="form.dto.ptrade!=null&&form.dto.ptrade==#application._WEB_SYS_CONF_KEY_.get(\"8\").size()">
					                    <div id="ptradeDiv" style="display: block"><input id="ptradeother" name="form.dto.ptradeother" type="text" value="<s:property value="form.dto.ptradeother"/>" class="inp" style="width: 247px; "  maxlength="40"/></div>
					                </s:if>
					                <s:else>
					                    <div id="ptradeDiv" style="display: none"><input id="ptradeother" name="form.dto.ptradeother" type="text" value="<s:property value="form.dto.ptradeother"/>" class="inp" style="width: 247px; " maxlength="40"/></div>
					               </s:else>
								</div>
		                      </td>
		                      <th width="90px" nowrap="nowrap">现从事岗位:</th>
                              <td align="left">
                              	<select id="pquarters" name="form.dto.pquarters" class="inp" style="width:250px;" onchange="modify('pquarters','<s:property value="form.dto.pquartersother"/>');">
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="status" status="st">
		                               <s:if test="form.dto.pquarters==key">
	                              	  	  	<option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	  		<option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
		                          </select>
		                          <div>
			                        <s:if test="form.dto.pquartersother!=null&&form.dto.pquarters==#application._WEB_SYS_CONF_KEY_.get(\"9\").size()">
	                                	<div id="pquartersDiv" style="display: block"><input id="pquartersother" name="form.dto.pquartersother" type="text" value="<s:property value="form.dto.pquartersother"/>" class="inp"  style="width: 247px; " maxlength="40"/></div>
	                                </s:if>
	                                <s:else>
	                                	<div id="pquartersDiv" style="display: none"><input id="pquartersother" name="form.dto.pquartersother" type="text" value="<s:property value="form.dto.pquartersother"/>" class="inp" style="width: 247px; "  maxlength="40"/></div>
	                                </s:else>
		                          </div>
		                      </td>
                          </tr>
                          <tr>
                              <th width="90px" nowrap="nowrap">单位性质:</th>
                              <td align="left">
	                              <select id="economyKind" name="form.dto.economyKind" class="inp" onchange="modify('economyKind','<s:property value="form.dto.economykindother"/>');" style="width: 250px;">
	                                  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"10\")" id="status" status="st">
	                                      <s:if test="form.dto.economyKind==key">
	                              	  	     <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	     <option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
	                              </select>
	                              <div>
			                          <s:if test="form.dto.economykindother!=null&&form.dto.economyKind==#application._WEB_SYS_CONF_KEY_.get(\"10\").size()">
		                              		<div id="economyKindDiv" style="display: block"><input id="economyKindother" name="form.dto.economykindother" type="text" value="<s:property value="form.dto.economykindother"/>" class="inp"  style="width: 247px; " maxlength="20"/></div>
		                              </s:if>
		                              <s:else>
		                              		<div id="economyKindDiv" style="display: none"><input id="economyKindother" name="form.dto.economykindother" type="text" value="<s:property value="form.dto.economykindother"/>" class="inp" style="width: 247px; " maxlength="20"/></div>
		                              </s:else>
	                              </div>
		                      </td>
		                      <th width="90px" nowrap="nowrap">所在县区:</th>
		                      <td nowrap="nowrap" align="left"><select name="form.dto.pcounty" class="inp" style="width:250px; ">
		                      <s:if test='#session._USER_LOGIN_.getUsertype()=="3"'>
		                      		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")" id="status" status="st">
	                                     <s:if test="form.usercountry==key">
	                              	  	     <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	 </s:if>
		                             </s:iterator>	
		                      		
		                      	</s:if>
		                      	<s:else>	                      		 	
		                               <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")" id="status" status="st">
		                                    <s:if test="form.dto.pcounty==key">
		                              	  	      <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  	</s:if>
		                              	  	<s:else>
		                              	  		  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  	</s:else>
			                           </s:iterator>			                      		
		                      	</s:else>
		                      	</select>
		                      </td>
		                      <!-- 
                              <td nowrap="nowrap" align="left"><select name="form.dto.pcounty" class="inp" style="width:250px; ">
	                                 <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")" id="status" status="st">
	                                      <s:if test="form.dto.pcounty==key">
	                              	  	      <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
	                              	  	  </s:if>
	                              	  	  <s:else>
	                              	  	      <option value="<s:property value="key"/>"><s:property value="value"/></option>
	                              	  	  </s:else>
		                              </s:iterator>	
	                              </select>
                              </td>
                               -->
                          </tr>
                          <tr>
                          	<th width="10%;" nowrap="nowrap">现就业单位名称:</th>
                          	<td align="left">
                            	<input id="workCompany" name="form.dto.workCompany" type="text" value="<s:property value="form.dto.workCompany"/>" class="inp" style="width: 245px;" maxlength="100"/>
                            </td>
                            <th width="15%;" nowrap="nowrap">担任行政职务或级别:</th>
                          	<td align="left">
                            	<input id="dutylevel" name="form.dto.dutylevel" type="text" value="<s:property value="form.dto.dutylevel"/>" class="inp" style="width: 250px;" maxlength="100"/>
                            </td>
                          </tr>
                          <tr>
                          	<th width="10%;" nowrap="nowrap">单位所属:</th>
                          	<td colspan="3" align="left">
                            	<select name="form.dto.unitlvl" class="inp" style="width: 96%;">
	                              	  <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"74\")" id="status" status="st">
	                              	  	 <s:if test="form.dto.unitlvl==key">
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
                          	<th width="10%;" nowrap="nowrap">其他专长技能描述:</th>
                          	<td colspan="3" align="left">
                            	<input id="specialtyStrong" name="form.dto.specialtyStrong" type="text" value="<s:property value="form.dto.specialtyStrong"/>" class="inp" style="width: 675px;"  maxlength="200"/>
                            </td>
                          </tr>
                          <tr>
                          	<th width="10%" nowrap="nowrap">人才类型(可多选<font color="red">*</font>):</th>
                          	<td colspan="3" align="left">
                          		<%
                          			Map typeMap = (Map) ((Map) application.getAttribute("_WEB_SYS_CONF_KEY_")).get("11");
                          			Map pMap = (Map) request.getAttribute("_PERSON_TYPE");
                          			if(pMap == null) {
                          				pMap = new HashMap();
                          			}
                         			if(typeMap != null && typeMap.size() > 0) {
                         				for(Object obj : typeMap.keySet()) {
                         					Object flag = pMap.get(obj.toString().trim());
                         					if(flag != null && flag.toString().trim().length() > 0) {
                          		%>
                          			<input name="form.dto.personType" type="checkbox" value="<%=obj%>" checked="checked" tabindex=-1/><%=typeMap.get(obj)%>
                          		<%
                          					} else {
                    			%>
                    				<input name="form.dto.personType" type="checkbox" value="<%=obj%>" tabindex=-1/><%=typeMap.get(obj)%>
                                <%			
	                          				}
	                          			}
                          			}
                          		%>
                            </td>
                          </tr>
                           
                          <tr>
                         	<th width="10%;" nowrap="nowrap">填表日期(<font color="red">*</font>):</th>
                          	<td align="left">
                          		<input id="operationalDate" readonly="readonly" type="text" name="form.dto.operationalDate" onfocus="HS_setDate(this)" value="<s:property value="form.dto.operationalDate"/>" tabindex=-1/>
                            </td>
                            <th width="10%;" nowrap="nowrap">审核状态:</th>
                          	<td>
                          	 	<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"63\")" id="status" status="st">
	                                 <s:if test="form.dto.auditstate==key">
	                              	  	 <font color="red"><s:property value="value"/></font>
	                              	 </s:if>
	                              	 
		                         </s:iterator>	
                            </td>
                          </tr>
                      </tbody>
                      <tfoot>
                          <tr><td colspan="4">
                          	<s:if test="form.dto.auditstate=='000'||form.dto.auditstate=='200'||form.dto.auditstate=='100'||form.dto.auditstate==null">
	                          	<a id="save" href="javascript:addOrUpdateRecord(1);" class="btn_search" >保存</a>
	                          	<a id="saveAndNext" href="javascript:addOrUpdateRecord(2);" class="btn_search" >保存并下一步</a>
                          	</s:if>
                          </td></tr>
                      </tfoot>
                   </table>
            
             </div>
        
        </form>
   <script>
   		retrieveRegCity();
   </script>
</body>
</html>
