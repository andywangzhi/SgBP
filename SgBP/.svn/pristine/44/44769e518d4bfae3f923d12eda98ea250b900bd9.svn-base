<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
  String _dqType = request.getParameter("dqType");// 职称等级类型
  String _strType = "";
  if(null!=_dqType){
  	_strType = "&dqType="+_dqType;
  }
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Insert title here</title>
	    <link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon/icon.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script language="JavaScript" src="<%=path%>/images/FusionCharts.js"></script>
		<script type="text/javascript" src="<%=path%>/js/query/date.js" charset="UTF-8"></script>
	    <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
	    <script type="text/javascript">
	    var forage = '<s:property value="form.retrieveSO.forage"/>';
	    var toage = '<s:property value="form.retrieveSO.toage"/>';
	    var value='<s:property value="isCanSee"/>';
	    // 产生所有的年份
		function addOptsCount(_id,start,count){
			var c = document.getElementById(_id);
			for(var i=start;i<=count;i++){
				var opt = new Option(i,i);
				c.options.add(opt);
			}
		}
		$(function(){
    		addOptsCount("forage",20,60);
    		$("#forage").val(forage);
    		addOptsCount("toage",20,60);
    		$("#toage").val(toage);
		});
	    function find(){
			var fromDate=$("#fromDate").val();
			var todate=$("#todate").val();
			if(fromDate!=""&&todate!=""&&(getDate(fromDate)-getDate(todate)>0)){
				alert("开始时间不能大于结束时间！");
				return ;
			}
			var harvestassessforDate = $("#harvestassessforDate").val();
			var harvestassesstoDate = $("#harvestassesstoDate").val();
			if(harvestassessforDate!=""&&harvestassesstoDate!=""&&(getDate(harvestassessforDate)-getDate(harvestassesstoDate)>0)){
				alert("科技成果开始时间不能大于科技成果结束时间！");
				return ;
			}
			var techassessforDate = $("#techassessforDate").val();
			var techassesstoDate = $("#techassesstoDate").val();
			if(techassessforDate!=""&&techassesstoDate!=""&&(getDate(techassessforDate)-getDate(techassesstoDate)>0)){
				alert("职称获取开始时间不能大于职称获取结束时间！");
				return ;
			}
			var forage = $("#forage").val();
			var torage = $("#toage").val();
			if(forage!=""&&torage!=""&&(getDate(forage)-getDate(torage)>0)){
				alert("年龄开始时间不能大于年龄结束时间！");
				return ;
			}
			$("#frm").attr("action","<%=path%>/soa/rctj!queryTechnicallytype.action?menuId=<%=request.getParameter("menuId") + _strType%>");
			$("#frm").submit();
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
	function getRest() {
		document.getElementById('fromDate').value = '';
		document.getElementById('todate').value = '';
		document.getElementById('form.retrieveSO.pcounty').value = '';
	}
	function ExportTechnicallytypeExecl(){
		//	var fdate=$("#fromDate").val();
	    //	var tdate=$("#todate").val();
	    //	var pcounty=$("#form.retrieveSO.pcounty").val();
	    //	var ra= Math.random();
	    //	$.get("/soa/rctj!ExportPcountyExecl.action?ra="+ra,{"form.retrieveSO.pcounty":pcounty,"form.retrieveSO.forDate":fdate,"form.retrieveSO.todate":tdate});
    		$("#frm").attr("action","<%=path%>/soa/rctj!ExportTechnicallytypeExecl.action?menuId=<%=request.getParameter("menuId") + _strType%>");
    		$("#frm").submit();
			}
	
$(document).ready(function(){
	var _xAxisName = "";
	if(typeof(_typeValue)!="undefined" && null!=_typeValue && _typeValue.replace(/(^\s*)|(\s*$)/g, "").length>0)	_xAxisName="人才类型";
	else _xAxisName="职称等级";
	var chart = new FusionCharts("<%=path %>/images/Column3D.swf", "Column3D", "100%", "408", "0", "0");
	//chart.addParam("wmode","Opaque");
	var _xmlSrc = "<chart caption='职称等级分布统计' xAxisName='"+_xAxisName+"' yAxisName='人才数量' showValues='0' decimals='0' formatNumberScale='0' baseFontSize='12' rotateYAxisName='0'>";
	_xmlSrc += _dataXML;
	_xmlSrc += "</chart>";
	//chart.setDataURL("images/Column3D.xml");
	chart.setDataXML(_xmlSrc);	   
	chart.render("chartdivA");
	
	var chart = new FusionCharts("<%=path %>/images/Pie3D.swf", "ChartId", "100%", "408", "0", "0");
	//chart.addParam("wmode","Opaque");
	_xmlSrc = "<chart caption='职称等级分布统计' palette='4' decimals='0' enableSmartLabels='1' isSmartLineSlanted='0.1' skipOverlapLabels='1' isSmartLineSlanted='0' baseFontSize='12' formatNumberScale='0' enableRotation='0' bgColor='99CCFF,FFFFFF' bgAlpha='40,100' bgRatio='0,100' numberSuffix='' bgAngle='360' showBorder='10' startingAngle='70' >";
	_xmlSrc += _dataXML;
	_xmlSrc += "</chart>";
	chart.setDataXML(_xmlSrc);
	//chart.setDataURL("images/Pie3D.xml");
	chart.render("chartdivB");
});
	    </script>
	</head>
<body>

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：人才统计监控&nbsp;&gt;&nbsp;职称人才统计&nbsp;&gt;&nbsp;韶关市职称等级人才统计</div>
    <div class="row_r web_paht_r tool">
        <a href="<%=path%>/soa/rctj!queryTechnicallytype.action?menuId=<%=request.getParameter("menuId") + _strType%>" class="refresh">刷新</a>
        <a class="up" href="javascript:ExportTechnicallytypeExecl();">导出统计信息</a>
        <a class="up" href="<%=path%>/soa/RsPerson!tjQueryExecl.action">导出统计报表</a>
    </div>
</div>

<div class="main_in">


         <form action="<%=path%>/soa/rctj!queryTechnicallytype.action?menuId=<%=request.getParameter("menuId") + _strType%>" method="post" name="frm" id="frm">
              <div class="table_edit">
              <% if(null!=_dqType && _dqType!=""){ %>
              	<input type="hidden" name="form.retrieveSO.pcounty" value="<%=_dqType %>"/>
              <%} %>
                  <table>
                      <tbody>
                      	  <tr>
                          	  <th width="90px" nowrap="nowrap">职称等级：</th>
                              <td width="15%;" nowrap="nowrap">
                                  <select id="form.retrieveSO.pcounty" name="form.retrieveSO.pcounty" class="inp">
                                		<option value="" selected="selected">全&nbsp;&nbsp;&nbsp;部</option>
                                		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"12\")">
                                       	 <option value="<s:property value="key"/>" <s:if test="form.retrieveSO.pcounty == key"> selected="selected"</s:if> ><s:property value="value"/></option>
										</s:iterator>
                                  </select>
                              </td>
                              <th width="90px" nowrap="nowrap">最高学历：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.cultureType" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.cultureType==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                              <th width="90px" nowrap="nowrap">性别：</th>
                               <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.psex" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"16\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.psex==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                              <th width="90px" nowrap="nowrap">录入时间段：</th>
                              <td nowrap="nowrap"><input type="text" id="fromDate" readonly="readonly"  onfocus="HS_setDate(this)" name="form.retrieveSO.forDate" value="<s:property value="form.retrieveSO.forDate"/>" />
                               至 <input type="text" id="todate" readonly="readonly"  onfocus="HS_setDate(this)" name="form.retrieveSO.todate" value="<s:property value="form.retrieveSO.todate"/>" /></td>
                          </tr>
                          <th width="90px" nowrap="nowrap">所在行业：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.ptrade" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"8\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.ptrade==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                          <th width="90px" nowrap="nowrap">单位性质：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.economykind" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"10\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.economykind==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                              <th width="90px" nowrap="nowrap">专业：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.specialtyType" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"5\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.specialtyType==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                          	  <th width="90px" nowrap="nowrap">职称获取时间：</th>
                              <td nowrap="nowrap" colspan="4"><input type="text" id="techassessforDate" readonly="readonly"  onfocus="HS_setDate(this)" name="form.retrieveSO.techassessforDate" value="<s:property value="form.retrieveSO.techassessforDate"/>" />
                               至 <input type="text" id="techassesstoDate" readonly="readonly"  onfocus="HS_setDate(this)" name="form.retrieveSO.techassesstoDate" value="<s:property value="form.retrieveSO.techassesstoDate"/>" />
                               </td>	
                          </tr>
                          <tr>
                          	  <th width="90px" nowrap="nowrap">所属岗位：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.pquarters" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"9\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.pquarters==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                          	  <th width="90px" nowrap="nowrap">单位所属：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.unitlvl" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"74\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.unitlvl==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                              <th width="90px" nowrap="nowrap">科技成果级别：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select name="form.retrieveSO.harvestLevel" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"13\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.harvestLevel==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                          	  <th width="90px" nowrap="nowrap">成果获取时间：</th>
                              <td nowrap="nowrap" colspan="4"><input type="text" id="harvestassessforDate" readonly="readonly"  onfocus="HS_setDate(this)" name="form.retrieveSO.harvestassessforDate" value="<s:property value="form.retrieveSO.harvestassessforDate"/>" />
                               至 <input type="text" id="harvestassesstoDate" readonly="readonly"  onfocus="HS_setDate(this)" name="form.retrieveSO.harvestassesstoDate" value="<s:property value="form.retrieveSO.harvestassesstoDate"/>" />
                               </td>	
                          </tr>
                          <tr><th width="90px" nowrap="nowrap">年龄段：</th>
                              <td colspan="10"><select style="width:90px" id="forage" name="form.retrieveSO.forage">
                              <option value="">请选择</option>                                                                                      
                              </select>
                              	至 <select style="width:90px" id="toage" name="form.retrieveSO.toage">
                              	<option value="">请选择</option>
                              	</select></td>	
                          </tr>
                          
                      </tbody>
                      <tfoot>
                          <tr><td colspan="8">
                          <a href="javascript:find();" class="btn_search" >搜 索</a>
                          <a href="javascript:getRest();" class="btn_search" >重 置</a>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
              </form>
              <div class="table_edit" style="min-height:135px;*+height:100%;_height:135px;">
                  <table>
                      <thead>
                          <tr>
                              <th nowrap="nowrap"><p align="center">职称等级</p></th>
                              <th nowrap="nowrap"><p align="center">党政人才</p></th>
                              <th nowrap="nowrap"><p align="center">企业经营管理人才</p></th>
                              <th nowrap="nowrap"><p align="center">专业技术人才</p></th>
                              <th nowrap="nowrap"><p align="center">高技能人才</p></th>
                              <th nowrap="nowrap"><p align="center">农村实用人才</p></th>
                              <th nowrap="nowrap"><p align="center">社工人才</p></th>
                              <th nowrap="nowrap"><p align="center">总数</p></th>
                          </tr>
                      </thead>
                      <tbody class="bg_x">
                    <script type="text/javascript">
						var _dataXML="";
					</script>
                      <s:iterator value="form.dtoList.keySet()"  var="id">
                            <tr>
	                    		 <th nowrap="nowrap"><p align="center" id="lable<s:property value='#id' />"><s:property value="#application._WEB_SYS_CONF_KEY_.get(\"12\").get(#id)" /></p></th>
	                         	  <td nowrap="nowrap"><p align="center" id="dzrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"1\")==null?0:form.dtoList.get(#id).get(\"1\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="qyjygl<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"2\")==null?0:form.dtoList.get(#id).get(\"2\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="zyjsrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"3\")==null?0:form.dtoList.get(#id).get(\"3\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="gjnrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"4\")==null?0:form.dtoList.get(#id).get(\"4\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="ncsyrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"5\")==null?0:form.dtoList.get(#id).get(\"5\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="sgrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"6\")==null?0:form.dtoList.get(#id).get(\"6\")"/></p></td>
		                          <td nowrap="nowrap"><p align="center" ><s:property value="form.dtoList.get(#id).get(\"10\")==null?0:form.dtoList.get(#id).get(\"10\")"/></p></td>
		                      </tr>
                      <script type="text/javascript">
                      	var _typeValue = document.getElementById("form.retrieveSO.pcounty").value;
                      	
                      	var _index='<s:property value="#id" />';
                      	var _label=document.getElementById("lable"+_index).innerText;
                      	var _dzrc = document.getElementById("dzrc"+_index).innerText;
                      	var _qyjygl = document.getElementById("qyjygl"+_index).innerText;
                      	var _zyjsrc = document.getElementById("zyjsrc"+_index).innerText;
                      	var _gjnrc = document.getElementById("gjnrc"+_index).innerText;
                      	var _ncsyrc = document.getElementById("ncsyrc"+_index).innerText;
                      	var _sgrc = document.getElementById("sgrc"+_index).innerText;
                      	
                      	if(null!=_typeValue && _typeValue.replace(/(^\s*)|(\s*$)/g, "").length>0){
                      		_dataXML += "<set label='党政人才' value='"+_dzrc+"' />";
                      		_dataXML += "<set label='企业经营管理人才' value='"+_qyjygl+"' />";
                      		_dataXML += "<set label='专业技术人才' value='"+_zyjsrc+"' />";
                      		_dataXML += "<set label='高技能人才' value='"+_gjnrc+"' />";
                      		_dataXML += "<set label='农村实用人才' value='"+_ncsyrc+"' />";
                      		_dataXML += "<set label='社工人才' value='"+_sgrc+"' />";
                      	}else{
	                      	var _value = parseInt(_dzrc) + parseInt(_qyjygl) + parseInt(_zyjsrc) + parseInt(_gjnrc) + parseInt(_ncsyrc) + parseInt(_sgrc);
                      		_dataXML += "<set label='"+_label+"' value='"+_value+"' />";
                      	}
                      	
                      </script>
                       </s:iterator> 
                        <s:if test="form.countList.size > 0">
                             <tr>
	                      		  <th nowrap="nowrap"><p align="center" >总数</p></th>
	                         	  <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"1\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"2\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"3\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"4\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"5\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"6\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" ><s:property value="form.countList.get(\"10\")"/></p></td>
		                      </tr>
		                 </s:if>
                      </tbody>
                  </table>
              </div>
              <%-- 
              <div style=" margin-top:10px; border:1px #CCC dashed;overflow:hidden; clear:both">
                  <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="800" height="328" align="middle">
                      <param name="allowScriptAccess" value="sameDomain" />
                      <param name="movie" value="<%=path %>/images/category.swf" />
                      <param name="quality" value="high" />
                      <param name="wmode" value="transparent" />
                      <param name="FlashVars" value="ntitle=统计项目&toggle=全部显示|全部隐藏&vtitle=数值&cnames=&datatype=300000&rtitle=职称等级公布&gtypes=bar|line|hbar|pie&uloc=cn|$|0|1|2|3|4|5|6&total=<s:property value="form.swf" />" />
                      <embed src="<%=path %>/images/category.swf" FlashVars="ntitle=统计项目&toggle=全部显示|全部隐藏&vtitle=数值&cnames=&datatype=300000&rtitle=职称等级公布&gtypes=bar|line|hbar|pie&uloc=cn|$|0|1|2|3|4|5|6&total=<s:property value="form.swf" />" quality="high" width="800" height="328" align="middle" wmode="transparent" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
                  </object>
              </div> --%>
              
              
              <div class="easyui-tabs" fit="false" style=" margin-top:10px;width:auto; overflow:hidden; clear:both;height:auto;">
                  <div title="柱形图" style="padding:0px;margin-right: 10px;">
                    <div id="chartdivA"  align="center" class="chartDiv" style="margin-right: 10px;padding-right: 10px;"></div>
                  </div>
                  <div title="饼形图" style="padding:0px;margin-right: 10px;">
                    <div id="chartdivB"  align="center" class="chartDiv" style="margin-right: 10px;padding-right: 10px;"></div>
                  </div>
              </div>
    
</div>
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