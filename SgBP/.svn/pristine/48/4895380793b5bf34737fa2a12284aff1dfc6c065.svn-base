<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>人才队伍建设情况</title>	
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon/icon.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
    <script type="text/javascript">
	 	// 产生所有的年份
		function addOptsCountAbc(){
			var qy = "<s:property value="queryYear"/>";
		 	var c = document.getElementById("queryYear");
			var opt ;
			for(var i=2000;i<=2030;i++){	
				opt = new Option(i,i);
				if(i==qy){
					opt.selected=true;
				}
				c.options.add(opt);
			}
		}
    	function find(){
    		var queryYear = document.getElementById("queryYear").value;
    		location.href="<%=path%>/soa/RsTalantTeamAction!view.action?queryYear="+queryYear;
	    }
    	function ExportPcountyExecl(){
    		var queryYear = document.getElementById("queryYear").value;
    		location.href="<%=path%>/soa/RsTalantTeamAction!ExportExecl.action?queryYear="+queryYear;
		}
    	function toConfig(){
    		var queryYear = document.getElementById("queryYear").value;
    		location.href="<%=path%>/soa/RsTalantTeamAction!toConfig.action?queryYear="+queryYear;
    	}
    </script>
	</head>
<body  onload="addOptsCountAbc();">

<div class="web_paht">
    <div class="row_l web_paht_l">您的位置：人才考核&nbsp;&gt;&nbsp;人才队伍建设
    </div>
    <div class="row_r web_paht_r tool">
          <a class="refresh" href="<%=path%>/soa/RsTalantTeamAction!view.action">刷新</a>
          <a class="settings" onclick="toConfig();">配置</a>
          <a class="up" onclick="ExportPcountyExecl();">导出统计信息</a>
    </div>
</div>

<div class="main_in">
         <form action="" method="post" name="frm" id="frm">
             <div class="table_edit">              
                  <table>
                      <tbody>
                       		<tr>
                       			<td style="text-align: right; width: 43%;">年份:</td>
                       			<td>
                       			<select style="width:90px" id="queryYear" name="queryYear"></select>
                       			&nbsp;&nbsp;&nbsp;<a href="javascript:find();" class="btn_search">搜 索</a>
                       			</td>
                       		</tr>
                      </tbody>
                  </table>
              </div>
              <div class="table_yl"">              
              <table id="contenttable">
              	<thead>
              	<tr><td colspan="13"><h2>
              	<script type="text/javascript">
				  	var q1 = "<s:property value="queryYear"/>";
				  	var q2=$("#queryYear").val();
				  	if(q2==null){
				  		document.write(q1+"年");
				  	}else{
				  		document.write(q2+"年");
				  	}
			  	  </script>
              	韶关市县（市、区）人才工作考核人才队伍建设情况表</h2></td></tr>
              	<tr>
	              	<td nowrap="nowrap" width="50px">序号</td>
	              	<td nowrap="nowrap" width="200px" colspan="2">考核内容</td>
	              	<td nowrap="nowrap" width="50px">武江</td>
	              	<td nowrap="nowrap" width="50px">浈江</td>
	              	<td nowrap="nowrap" width="50px">曲江</td>
	              	<td nowrap="nowrap" width="50px">始兴</td>
	              	<td nowrap="nowrap" width="50px">仁化</td>
	              	<td nowrap="nowrap" width="50px">翁源</td>
	              	<td nowrap="nowrap" width="50px">乳源</td>
	              	<td nowrap="nowrap" width="50px">新丰</td>
	              	<td nowrap="nowrap" width="50px">乐昌</td>
	              	<td nowrap="nowrap" width="50px">南雄</td>
              	</tr>
              	</thead>
              	<tr>
	              	<td nowrap="nowrap" rowspan="3">1</td>
	              	<td nowrap="nowrap" colspan="2">每万人口中人才资源量</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"1-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">比例增长率（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"2-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率排名</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"3-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" rowspan="3">2</td>
	              	<td nowrap="nowrap" colspan="2">企业经营管理人才占从业人员的比例（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"4-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">比例增长率（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"5-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率排名</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"6-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" rowspan="3">3</td>
	              	<td nowrap="nowrap" colspan="2">专业技术人才占从业人员的比例（%）</td>
	       			<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"7-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">比例增长率（%）</td>
	         		<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"8-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率排名</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"9-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" rowspan="3">4</td>
	              	<td nowrap="nowrap" colspan="2">高技能人才占从业人员的比例（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"10-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">比例增长率（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"11-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率排名</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"12-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" rowspan="3">5</td>
	              	<td nowrap="nowrap" colspan="2">农村实用人才占农村劳运力的比例（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"13-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">比例增长率（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"14-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率排名</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"15-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" rowspan="5">6</td>
	              	<td nowrap="nowrap" colspan="2">每万人口中持证社工人数</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"16-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" colspan="2">上一年持证社工人数</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"17-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap" colspan="2">今年持证社工人数</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"18-9\")"/></td>
              	</tr>	
              	<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率（%）</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"19-9\")"/></td>
              	</tr>	
              		<tr>
	              	<td nowrap="nowrap"></td>
	              	<td nowrap="nowrap">增长率排名</td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-0\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-1\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-2\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-3\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-4\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-5\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-6\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-7\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-8\")"/></td>
	              	<td nowrap="nowrap"><s:property value="#request.resultMap.get(\"20-9\")"/></td>
              	</tr>	
              </table>
              </div>
              </form>
                  
</div>

</body>
</html>