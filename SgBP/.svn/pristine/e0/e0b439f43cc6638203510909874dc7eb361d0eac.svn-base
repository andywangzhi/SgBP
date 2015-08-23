<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>紧缺人才统计</title>
	    <link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon/icon.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
		<script language="JavaScript" src="<%=path%>/images/FusionCharts.js"></script>
		<script type="text/javascript" src="<%=path%>/js/query/date.js" charset="UTF-8"></script>
	     <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
	    <script type="text/javascript">
	    var value='<s:property value="isCanSee"/>';
	    function find(){
			$("#frm").attr("action","<%=path%>/soa/rctj!queryNeedSpecialtyType.action?menuId=<%=request.getParameter("menuId")%>");
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
			document.getElementById('neededucation').value = '';
			document.getElementById('needsex').value = '';
			document.getElementById('needpost').value = '';
		}
		function ExportSpecialtyTypeExecl(){
	   		$("#frm").attr("action","<%=path%>/soa/rctj!ExportNeedSpecialtyTypeExecl.action?menuId=<%=request.getParameter("menuId")%>");
	   		$("#frm").submit();
		}

		$(document).ready(function(){
			var _xAxisName = "";
			if(typeof(_typeValue)!="undefined" && null!=_typeValue && _typeValue.replace(/(^\s*)|(\s*$)/g, "").length>0)	_xAxisName="人才类型";
			else _xAxisName="专业";
			var chart = new FusionCharts("<%=path %>/images/Column3D.swf", "Column3D", "100%", "408", "0", "0");
			//chart.addParam("wmode","Opaque");
			var _xmlSrc = "<chart caption='专业分布统计' xAxisName='"+_xAxisName+"' yAxisName='人才需求数量' showValues='0' decimals='0' formatNumberScale='0' baseFontSize='12' rotateYAxisName='0'>";
			_xmlSrc += _dataXML;
			_xmlSrc += "</chart>";
			//chart.setDataURL("images/Column3D.xml");
			chart.setDataXML(_xmlSrc);	   
			chart.render("chartdivA");
			
			var chart = new FusionCharts("<%=path %>/images/Pie3D.swf", "ChartId", "100%", "408", "0", "0");
			//chart.addParam("wmode","Opaque");
			_xmlSrc = "<chart caption='专业分布统计' palette='4' decimals='0' enableSmartLabels='1' isSmartLineSlanted='0.1' skipOverlapLabels='1' isSmartLineSlanted='0' baseFontSize='12' formatNumberScale='0' enableRotation='0' bgColor='99CCFF,FFFFFF' bgAlpha='40,100' bgRatio='0,100' numberSuffix='' bgAngle='360' showBorder='10' startingAngle='70' >";
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
    <div class="row_l web_paht_l">您的位置：紧缺人才管理&nbsp;&gt;&nbsp;紧缺人才统计</div>
    <div class="row_r web_paht_r tool">
        <a href="<%=path%>/soa/rctj!querySpecialtyType.action?menuId=<%=request.getParameter("menuId")%>" class="refresh">刷新</a>
        <a class="up" href="javascript:ExportSpecialtyTypeExecl();">导出统计信息</a>
    </div>
</div>
<div class="main_in">
         <form action="<%=path%>/soa/rctj!queryNeedSpecialtyType.action?menuId=<%=request.getParameter("menuId")%>" method="post" name="frm" id="frm">
              <div class="table_edit">
                  <table>
                      <tbody>
                          <tr>        
                              <th width="90px" nowrap="nowrap">最高学历：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select id="neededucation" name="form.retrieveSO.neededucation" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"4\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.neededucation==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                                                                                                 
                              <th width="90px" nowrap="nowrap">职称级别：</th>
                              <td width="15%;" nowrap="nowrap">
	                              <select id="needpost" name="form.retrieveSO.needpost" class="inp"">
	                              	  <option value="">请选择</option>
		                              <s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"12\")" id="status" status="st">
		                              	  <s:if test="form.retrieveSO.needpost==key">
		                              	   	  <option value="<s:property value="key"/>" selected="selected"><s:property value="value"/></option>
		                              	  </s:if>
		                              	  <s:else>
		                              	  	  <option value="<s:property value="key"/>"><s:property value="value"/></option>
		                              	  </s:else>
		                              </s:iterator>		                         
	                              </select>
                              </td>
                              <td colspan="2"></td>
                          </tr>
                      </tbody>
                      <tfoot>
                          <tr><td colspan="6">
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
                              <th nowrap="nowrap"><p align="center">专业</p></th>
                              <th nowrap="nowrap"><p align="center">管理</p></th>
                              <th nowrap="nowrap"><p align="center">技术</p></th>
                              <th nowrap="nowrap"><p align="center">艺术</p></th>
                              <th nowrap="nowrap"><p align="center">营销</p></th>
                              <th nowrap="nowrap"><p align="center">协会</p></th>
                              <th nowrap="nowrap"><p align="center">其他</p></th>
                              <th nowrap="nowrap"><p align="center">总数</p></th>
                          </tr>
                      </thead>
                      <tbody class="bg_x">
                    <script type="text/javascript">
						var _dataXML="";
					</script>
                      <s:iterator value="form.dtoList.keySet()"  var="id">
                            <tr>
	                    		 <th nowrap="nowrap"><p align="center" id="lable<s:property value='#id' />"><s:property value="#application._WEB_SYS_CONF_KEY_.get(\"5\").get(#id)" /></p></th>
	                         	  <td nowrap="nowrap"><p align="center" id="dzrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"1\")==null?0:form.dtoList.get(#id).get(\"1\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="qyjygl<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"2\")==null?0:form.dtoList.get(#id).get(\"2\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="zyjsrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"3\")==null?0:form.dtoList.get(#id).get(\"3\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="gjnrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"4\")==null?0:form.dtoList.get(#id).get(\"4\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="ncsyrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"5\")==null?0:form.dtoList.get(#id).get(\"5\")"/></p></td>
	                              <td nowrap="nowrap"><p align="center" id="sgrc<s:property value='#id' />"><s:property value="form.dtoList.get(#id).get(\"6\")==null?0:form.dtoList.get(#id).get(\"6\")"/></p></td>
		                    	  <td nowrap="nowrap"><p align="center" ><s:property value="form.dtoList.get(#id).get(\"10\")==null?0:form.dtoList.get(#id).get(\"10\")"/></p></td>
		                      </tr>
		                      
                      <script type="text/javascript">
                      	var _typeValue = "";
                      	var _index='<s:property value="#id" />';
                      	var _label=document.getElementById("lable"+_index).innerText;
                      	var _dzrc = document.getElementById("dzrc"+_index).innerText;
                      	var _qyjygl = document.getElementById("qyjygl"+_index).innerText;
                      	var _zyjsrc = document.getElementById("zyjsrc"+_index).innerText;
                      	var _gjnrc = document.getElementById("gjnrc"+_index).innerText;
                      	var _ncsyrc = document.getElementById("ncsyrc"+_index).innerText;
                      	var _sgrc = document.getElementById("sgrc"+_index).innerText;
                      	if(null!=_typeValue && _typeValue.replace(/(^\s*)|(\s*$)/g, "").length>0){
                      		_dataXML += "<set label='管理' value='"+_dzrc+"' />";
                      		_dataXML += "<set label='技术' value='"+_qyjygl+"' />";
                      		_dataXML += "<set label='艺术' value='"+_zyjsrc+"' />";
                      		_dataXML += "<set label='营销' value='"+_gjnrc+"' />";
                      		_dataXML += "<set label='协会' value='"+_ncsyrc+"' />";
                      		_dataXML += "<set label='其他' value='"+_sgrc+"' />";
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
              <div class="easyui-tabs" fit="false" style=" margin-top:10px;width:auto; overflow:hidden; clear:both;height:auto;">
                  <div title="柱形图" style="padding:0px;margin-right: 10px;">
                    <div id="chartdivA"  align="center" class="chartDiv" style="margin-right: 10px;padding-right: 10px;"></div>
                  </div>
                  <div title="饼形图" style="padding:0px;margin-right: 10px;">
                    <div id="chartdivB"  align="center" class="chartDiv" style="margin-right: 10px;padding-right: 10px;"></div>
                  </div>
              </div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){ 
            var color="#fbfdfe"
            $(".bg_x tr:odd td").css("background-color",color);  //改变偶数行背景色
            $(".data_list tr:odd").attr("bg",color);
            $(".data_list tr:even").attr("bg","#fff");
      })
</script>

</html>