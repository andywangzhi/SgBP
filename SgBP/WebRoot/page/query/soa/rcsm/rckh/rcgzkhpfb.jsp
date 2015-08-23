<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	    <link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon/icon.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script language="JavaScript" src="<%=path%>/images/FusionCharts.js"></script>
		<script type="text/javascript" src="<%=path%>/js/query/date.js" charset="UTF-8"></script>

<link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />

	    <script type="text/javascript">
	    
	    // 产生所有的年份
		function addOptsCountAbc(_id,start,count){
			var c = document.getElementById(_id);
			var opt ;
			if(count != "0"){
				opt = new Option("请选择","");
				c.options.add(opt);
			}	
			for(var i=start;i<=count+start;i++){				
				opt = new Option(i,i);
				c.options.add(opt);
			}
		}
		var forage = "<s:property value="form.year"/>";
		var year = "<s:property value="form.rsRcgzkhpfb.year"/>";
		var pk = "<s:property value="form.rsRcgzkhpfb.pk"/>";
		var myDate = "<s:property value="_nowYear"/>";
    	$(function(){
    		addOptsCountAbc("forage",2000,60);
    		$("#forage").val(forage);
    		setYear();
    		
    		if(year != myDate){   			
    			$("#save").css("display","none");//display:none;
    		}		
		});
		function setYear(){
			var opt;
			if(year == ""){
	    		year = myDate;   		    		
    		}else{
    			var retrieveSOpcountyc = document.getElementById("retrieveSOpcounty");
	    		var value = retrieveSOpcountyc.value;
				var text = retrieveSOpcountyc.options[retrieveSOpcountyc.selectedIndex].text;
				retrieveSOpcountyc.options.length=0;
				opt = new Option(text,value);
				retrieveSOpcountyc.options.add(opt);	 
    		}
    		
    		var c = document.getElementById("year");
    		opt = new Option(year,year);
			c.options.add(opt);
		}
    	function find(){
    		var formpcounty = $("#formpcounty").val();
    		if(formpcounty == ""){
    			alert("请选择区县");
				return;
    		}	
    		var year = $("#forage").val();
			if(year == ""){
				alert("请选择年份");
				return;
			}
			$("#frm").attr("action","<%=path%>/soa/rcgzkh!query.action?menuId=");
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
    	function ExportPcountyExecl(){
			$("#frm").attr("action","<%=path%>/soa/rcgzkh!ExportRcgzkhpfbExecl.action?menuId=");
    		$("#frm").submit();
		}
		function addOrUpdateRecord(){
			var retrieveSOpcounty = $("#retrieveSOpcounty").val();
			if(retrieveSOpcounty == ""){
				alert("请选择区县");
				return;
			}
			var year = $("#year").val();
			if(year == ""){
				alert("请选择年份");
				return;
			}
			var value = $("#bsxwbl").val();
			if(value == ""){
				alert("引进的博士学位或正高人数分值不能为空");
				return;
			}
			value = $("#fgzc").val();
			if(value == ""){
				alert("引进的副高职称人数分值不能为空");
				return;
			}
			value = $("#ssrc").val();
			if(value == ""){
				alert("引进的硕士人数分值不能为空");
				return;
			}
			value = $("#bkrc").val();
			if(value == ""){
				alert("引进的本科人数分值不能为空");
				return;
			}
			value = $("#jsfg").val();
			if(value == ""){
				alert("培养的副高人数分值不能为空");
				return;
			}
			value = $("#jszg").val();
			if(value == ""){
				alert("培养的正高人数分值不能为空");
				return;
			}
			value = $("#sjjl").val();
			if(value == ""){
				alert("获得省级项数分值不能为空");
				return;
			}
			value = $("#bsjl").val();
			if(value == ""){
				alert("获得市级项数分值不能为空");
				return;
			}
			$("#frm").attr("action","<%=path%>/soa/rcgzkh!saveOrUpdate.action?menuId=");
    		$("#frm").submit();
		}
			function checkData(obj,num){
				var value = $(obj).val();
				if(value == ""){
					return ;
				}
				if(!isFloat(value)){
					alert("请输入数字！");
					$(obj).attr("value","");
					return ;
				}
				if(0>value || value - num > 0){
					alert("请输入0到"+num+"之间的合法值");
					$(obj).attr("value","");
				}				
			}
			
			function isFloat(str)   
			{   
			    if(/^(-?\d+)(\.\d+)?$/.test(str))   
			   {   
			        return true;   
			   }   
			    return false;   
			} 
			
	    </script>
	   <style type="text/css">

		.readabled {
			background-color: #A2A2A2;
		}
			</style>
	</head>
<body>

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：人才考核&nbsp;&gt;&nbsp;人才考核评分表
    </div>
    <div class="row_r web_paht_r tool">
          <a class="refresh" href="<%=path%>/soa/rcgzkh!query.action?menuId=">刷新</a>
          <a class="up" href="javascript:ExportPcountyExecl();">导出统计信息</a>
    </div>
</div>

<div class="main_in">

         <form action="<%=path%>/soa/rcgzkh!saveOrUpdate.action?menuId=" method="post" name="frm" id="frm">
              <div class="table_edit">              
                  <table>
                      <tbody>
                       		<tr>
                       			<td nowrap="nowrap" width="100px" >区县</td>
                       			<td width="15%;" nowrap="nowrap">
			                         <select id="formpcounty" name="form.pcounty">
			                         	<option value="">请选择</option>
			                       		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")">
			                              	 <option value="<s:property value="key"/>" <s:if test="form.pcounty == key"> selected="selected"</s:if> ><s:property value="value"/></option>
										</s:iterator>
			                         </select>
			                     </td>                       			
                       			<td nowrap="nowrap" width="100px">年份</td>
                       			<td ><select style="width:90px" id="forage" name="form.year">
                    			</td>                      			
                       		</tr>
                      </tbody>
                      <tfoot>
                          <tr><td colspan="5">
                          <a href="javascript:find();" class="btn_search" >搜 索</a>
                          <a href="javascript:getRest();" class="btn_search" >重 置</a>
                          </td></tr>
                      </tfoot>
                  </table>
              </div>
              <div class="table_yl"">              
              <table id="contenttable">
              	<thead>
              	<tr>
              		<td width="90px" nowrap="nowrap" colspan="2">区县：
                    
                         <select id="retrieveSOpcounty" name="form.rsRcgzkhpfb.pcounty">
                         	<option value="">请选择</option>
                       		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")">
                              	 <option value="<s:property value="key"/>" <s:if test="form.rsRcgzkhpfb.pcounty == key"> selected="selected"</s:if> ><s:property value="value"/></option>
							</s:iterator>
                         </select>
                     </td>
              		<td width="90px" nowrap="nowrap" colspan="4" align="left">年份：
                    <select style="width:90px" id="year" name="form.rsRcgzkhpfb.year">                                                                                                        
                    </select></td>	
                </tr>
              	<tr><td colspan="6"><h2>韶关市县（市、区）人才工作考核评分表</h2></td></tr>
              	<tr>
	              	<td nowrap="nowrap" width="50px">考核<br />指标</td>
	              	<td nowrap="nowrap" width="50px">序号</td>
	              	<td nowrap="nowrap" width="200px">考核内容</td>
	              	<td nowrap="nowrap" width="40px">分值</td>
	              	<td nowrap="nowrap" width="180px">考评方法</td>
	              	<td nowrap="nowrap" width="100px">考评<br />得分</td>
              	</tr>
              	</thead>
	              	<tr>
	              	<input id="pk" type="hidden" name="form.rsRcgzkhpfb.pk" value="<s:property value="form.rsRcgzkhpfb.pk"/>"/>
		              	<td nowrap="nowrap" rowspan="7">基础<br />指标<br />(40分)</td>
		              	<td nowrap="nowrap">1</td>
		              	<td nowrap="nowrap" align="left">每年至少分别召开1次党委常委会、政府<br />常务会议专题研究人才工作；人才工作协调小<br />组召开2次以上会议研究、部署人才工作</td>
		              	<td nowrap="nowrap">6</td>
		              	<td nowrap="nowrap" align="left">党委常委会和政府常务会议各<br />1次以上，协调小组成员会议2次以<br />上，每次得1分，最高6分</td>
		              	<td nowrap="nowrap"><input onblur="checkData(this,6);" id="ztyjrcgz" name="form.rsRcgzkhpfb.ztyjrcgz" type="text"  value="<s:property value="form.rsRcgzkhpfb.ztyjrcgz"/>" class="inp" style="width:98%;" /></td>
	              	</tr>	
              	<tr>
              		<td nowrap="nowrap">2</td>
              		<td nowrap="nowrap" align="left">出台人才工作文件（政策）并积极实施</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">以党委、政府（含“两办”）<br />名义出台的得分=文件数×2，人才<br />工作协调小组成员单位出台的得分<br />=文件数×1,最高3分</td>
              		<td nowrap="nowrap"><input id="ctrcgzwj" onblur="checkData(this,3);"  name="form.rsRcgzkhpfb.ctrcgzwj" type="text"  value="<s:property value="form.rsRcgzkhpfb.ctrcgzwj"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">建立县（区）级各类人才信息库，并实行<br />动态管理</td>
              		<td nowrap="nowrap">12</td>
              		<td nowrap="nowrap" align="left"    >按6大类人才计算，每类人才数据库<br />各2分</td>
              		<td nowrap="nowrap"><input id="jlrcxxk" readonly="readonly" class="readabled" class="readabled" name="form.rsRcgzkhpfb.jlrcxxk" type="text"  value="<s:property value="form.rsRcgzkhpfb.jlrcxxk"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">4</td>
              		<td nowrap="nowrap" align="left">有目标管理制度，人才工作有计划、有分<br />工、有检查、有总结；有工作报告制度，向全<br />县（市、区）性会议报告人才工作情况</td>
              		<td nowrap="nowrap">6</td>
              		<td nowrap="nowrap" align="left">落实每项制度各3分，最高6分</td>
              		<td nowrap="nowrap"><input id="bgrcgzqk"  onblur="checkData(this,6);" name="form.rsRcgzkhpfb.bgrcgzqk" type="text"  value="<s:property value="form.rsRcgzkhpfb.bgrcgzqk"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">5</td>
              		<td nowrap="nowrap" align="left">设立人才资源开发专项资金（划拨到组织<br />部、人社局或人才协调小组办公室），制定管<br />理办法，资金占本级财政一般预算支出的0.5%<br />以上</td>
              		<td nowrap="nowrap">6</td>
              		<td nowrap="nowrap" align="left">有人才专项资金及管理办法的<br />得1分；占比在0.5%及以上的得5<br />分，以下的一次递减0.2分</td>
              		<td nowrap="nowrap"><input id="rczykfzxzj"  onblur="checkData(this,6);" name="form.rsRcgzkhpfb.rczykfzxzj" type="text"  value="<s:property value="form.rsRcgzkhpfb.rczykfzxzj"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">6</td>
              		<td nowrap="nowrap" align="left">媒体宣传优秀人才事迹及先进工作经验</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">得分=次数×0.5，最高3分</td>
              		<td nowrap="nowrap"><input id="xcyxrcsj"  onblur="checkData(this,3);" name="form.rsRcgzkhpfb.xcyxrcsj" type="text"  value="<s:property value="form.rsRcgzkhpfb.xcyxrcsj"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">7</td>
              		<td nowrap="nowrap" align="left">实施重大人才工程且有较明显成效</td>
              		<td nowrap="nowrap">4</td>
              		<td nowrap="nowrap" align="left">每项工程各2分，最高4分</td>
              		<td nowrap="nowrap"><input id="sszdrcgz" onblur="checkData(this,4);"  name="form.rsRcgzkhpfb.sszdrcgz" type="text"  value="<s:property value="form.rsRcgzkhpfb.sszdrcgz"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
	              	<td nowrap="nowrap" rowspan="7">发展<br />指标<br />(60<br />分)</td>
	              	<td nowrap="nowrap">8</td>
	              	<td nowrap="nowrap" align="left">加强人才引进，本年度引进硕士及以上学<br />位或副高及以上职称人数、全日制本科学历人数</td>
	              	<td nowrap="nowrap">6</td>
	              	<td nowrap="nowrap" align="left">得分=博士学位或正高人数×<input id="bsxwbl" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.bsxwbl" type="text"  value="<s:property value="form.rsRcgzkhpfb.bsxwbl"/>" class="inp" style="width:50px;" /><br />
	              	，副高职称人数×<input id="fgzc" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.fgzc" type="text"  value="<s:property value="form.rsRcgzkhpfb.fgzc"/>" class="inp" style="width:50px;" /><br />
	              	，硕士人数×<input id="ssrc" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.ssrc" type="text"  value="<s:property value="form.rsRcgzkhpfb.ssrc"/>" class="inp" style="width:50px;" /><br />
	              	，本科人数×<input id="bkrc" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.bkrc" type="text"  value="<s:property value="form.rsRcgzkhpfb.bkrc"/>" class="inp" style="width:50px;" /><br />，最高6分</td>
	              	<td nowrap="nowrap"><input id="jqrcyj" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.jqrcyj" type="text"  value="<s:property value="form.rsRcgzkhpfb.jqrcyj"/>" class="inp" style="width:98%;" /></td>
              	</tr>	
              	<tr>
              		<td nowrap="nowrap">9</td>
              		<td nowrap="nowrap" align="left">加强人才培养，本年度新晋升副高以上职<br />称人数</td>
              		<td nowrap="nowrap">4</td>
              		<td nowrap="nowrap" align="left">得分= 副高总人数×<input id="jsfg" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.jsfg" type="text"  value="<s:property value="form.rsRcgzkhpfb.jsfg"/>" class="inp" style="width:50px;" /><br />
              		，正高总人数×<input id="jszg"  onblur="checkData(this,1);" name="form.rsRcgzkhpfb.jszg" type="text"  value="<s:property value="form.rsRcgzkhpfb.jszg"/>" class="inp" style="width:50px;" /><br />
              		，  最高4分</td>
              		<td nowrap="nowrap"><input id="jqrcpy" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.jqrcpy" type="text"  value="<s:property value="form.rsRcgzkhpfb.jqrcpy"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">10</td>
              		<td nowrap="nowrap" align="left">获得度市级及以上科学技术奖励数量</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">得分=省级项数×<input id="sjjl" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.sjjl" type="text"  value="<s:property value="form.rsRcgzkhpfb.sjjl"/>" class="inp" style="width:50px;" /><br />
              		，市级项数×<input id="bsjl" onblur="checkData(this,1);"  name="form.rsRcgzkhpfb.bsjl" type="text"  value="<s:property value="form.rsRcgzkhpfb.bsjl"/>" class="inp" style="width:50px;" />，最高3分 </td>
              		<td nowrap="nowrap"><input id="kxjsjl" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.kxjsjl" type="text"  value="<s:property value="form.rsRcgzkhpfb.kxjsjl"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">11</td>
              		<td nowrap="nowrap" align="left">专利授权量</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">得分=发明专利授权量×0.1+<br />实用新型专利授权量×0.03+外观<br />设计专利授权量×0.01，最高3分</td>
              		<td nowrap="nowrap"><input id="zysqsl" onblur="checkData(this,3);"  name="form.rsRcgzkhpfb.zysqsl" type="text"  value="<s:property value="form.rsRcgzkhpfb.zysqsl"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">12</td>
              		<td nowrap="nowrap" align="left">2012年复核、认定的高新技术企业或民营<br />科技企业数量</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">得分=高新技术企业个数×2，<br />民营科技企业个数×1，最高3分</td>
              		<td nowrap="nowrap"><input id="gxjsqy" onblur="checkData(this,3);"  name="form.rsRcgzkhpfb.gxjsqy" type="text"  value="<s:property value="form.rsRcgzkhpfb.gxjsqy"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">13</td>
              		<td nowrap="nowrap" align="left">企业工程技术研究开发中心数量</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">得分=省级个数×3，市级个数<br />×1.5，最高3分</td>
              		<td nowrap="nowrap"><input id="gcjsyjkfzx" onblur="checkData(this,3);"  name="form.rsRcgzkhpfb.gcjsyjkfzx" type="text"  value="<s:property value="form.rsRcgzkhpfb.gcjsyjkfzx"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">14</td>
              		<td nowrap="nowrap" align="left">每万人口中人才资源总量及增长率</td>
              		<td nowrap="nowrap">10</td>
              		<td nowrap="nowrap" align="left">按照全市统计数据从高往低<br />排，第一名得满分，其他县（市）<br />、区按照统计数据与第一名的比例<br />折算得分</td>
              		<td nowrap="nowrap"><input id="rczyzlhzzl" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.rczyzlhzzl" type="text"  value="<s:property value="form.rsRcgzkhpfb.rczyzlhzzl"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
	              	<td nowrap="nowrap" rowspan="4">发展<br />指标<br />(60<br />分)</td>
	              	<td nowrap="nowrap">15</td>
	              	<td nowrap="nowrap" align="left">企业经营管理人才占从业人员比例<br />及增长率</td>
	              	<td nowrap="nowrap">8</td>
	              	<td nowrap="nowrap" align="left">按照全市统计数据从高往低<br />排，第一名得满分，其他县（市）<br />、区按照统计数据与第一名的比例<br />折算得分</td>
	              	<td nowrap="nowrap"><input id="qyjyglrc" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.qyjyglrc" type="text"  value="<s:property value="form.rsRcgzkhpfb.qyjyglrc"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">16</td>
              		<td nowrap="nowrap" align="left">专业技术人才占从业人员比例及增长率</td>
              		<td nowrap="nowrap">8</td>
              		<td nowrap="nowrap" align="left">按照全市统计数据从高往低<br />排，第一名得满分，其他县（市）<br />、区按照统计数据与第一名的比例<br />折算得分</td>
              		<td nowrap="nowrap"><input id="zyjsrc" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.zyjsrc" type="text"  value="<s:property value="form.rsRcgzkhpfb.zyjsrc"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">17</td>
              		<td nowrap="nowrap" align="left">农村实用人才占农村劳动力比例及增长率</td>
              		<td nowrap="nowrap">9</td>
              		<td nowrap="nowrap" align="left">按照全市统计数据从高往低<br />排，第一名得满分，其他县（市）<br />、区按照统计数据与第一名的比例<br />折算得分</td>
              		<td nowrap="nowrap"><input id="ncsyrc" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.ncsyrc" type="text"  value="<s:property value="form.rsRcgzkhpfb.ncsyrc"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">18</td>
              		<td nowrap="nowrap" align="left">社会工作人才队伍建设</td>
              		<td nowrap="nowrap">3</td>
              		<td nowrap="nowrap" align="left">社会工作者考试报名人数在中<br />间值及以上得1分、以下得0.7分；<br />持证社工人数增长率在中间值及以<br />上得2分、以下得1.5分</td>
              		<td nowrap="nowrap"><input id="shgzrc" onblur="checkData(this,3);" name="form.rsRcgzkhpfb.shgzrc" type="text"  value="<s:property value="form.rsRcgzkhpfb.shgzrc"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">合计</td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap">100</td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap"><input id="countall" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.countall" type="text"  value="<s:property value="form.rsRcgzkhpfb.countall"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap" rowspan="3">加分<br />指标</td>
              		<td nowrap="nowrap">19</td>
              		<td nowrap="nowrap" align="left">当年省人才工作“扬帆计划”项目</td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap" align="left">通过市初审的得1分，通过省评审的得2分</td>
              		<td nowrap="nowrap"><input id="srcgzxm" onblur="checkData(this,3);"   name="form.rsRcgzkhpfb.srcgzxm" type="text"  value="<s:property value="form.rsRcgzkhpfb.srcgzxm"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">20</td>
              		<td nowrap="nowrap" align="left">当年引进“千人计划”入选者</td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap" align="left">进入现现场评审每个得5分</td>
              		<td nowrap="nowrap"><input id="yjqrjh" onblur="checkData(this,5);"   name="form.rsRcgzkhpfb.yjqrjh" type="text"  value="<s:property value="form.rsRcgzkhpfb.yjqrjh"/>" class="inp" style="width:98%;" /></td>
              	</tr>
              	<tr>
              		<td nowrap="nowrap">21</td>
              		<td nowrap="nowrap" align="left"> 当年引进广东省创新科研团队、领军人才</td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap" align="left">进入现场评审每个分别得5分、3分</td>
              		<td nowrap="nowrap"><input id="yjgdscxtd" onblur="checkData(this,8);" name="form.rsRcgzkhpfb.yjgdscxtd" type="text"  value="<s:property value="form.rsRcgzkhpfb.yjgdscxtd"/>" class="inp" style="width:98%;" /></td>             	             		
              	</tr>
              	<tr>
              		<td nowrap="nowrap">最终得分</td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap"></td>
              		<td nowrap="nowrap"><input id="endcountall" readonly="readonly" class="readabled" name="form.rsRcgzkhpfb.endcountall" type="text"  value="<s:property value="form.rsRcgzkhpfb.endcountall"/>" class="inp" style="width:98%;" /></td>             	             		
              	</tr>
              	<tfoot>
                    <tr><td colspan="6">
                    <a id="save" href="javascript:addOrUpdateRecord();" class="btn_search" >保存</a>
                    </td></tr>
                </tfoot>
              </table>
              </div>
              </form>
                  
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