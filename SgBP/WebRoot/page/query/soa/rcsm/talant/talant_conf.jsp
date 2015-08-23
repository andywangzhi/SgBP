<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
  <head>
    <title>人才队伍建设信息配置</title>    
    <link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/icon/icon.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
    <script type="text/javascript">
		var path = '<%=path%>'; 
		var ram=Math.random();
		var clicked=true;
	 	
		// 产生所有的年份
		function addOptsCountAbc(){
			var qyy = "<s:property value="queryYear"/>";
		 	var c = document.getElementById("queryYear");
			var opt ;
			for(var i=2000;i<=2030;i++){	
				opt = new Option(i,i);
				if(i==qyy){
					opt.selected=true;
				}
				c.options.add(opt);
			}
		}
		function save(){
			if(clicked){
				$("#save").attr("disabled",true);	
				clicked=false;
			}else{
				return;
			}
			var ckpass=true;
			var queryYear = document.getElementById("queryYear").value;
			$("input[type='text']").each(function(i){
		    	if(isNaN(this.value)){
		    		alert("请填写数字!");
		    		ckpass=false;
		    		return false; 
		    	}
		 	});
			if(ckpass){
				$("#frm").ajaxSubmit({
					url: path+'/soa/RsTalantTeamAction!saveOrUpdate.action?ram='+ ram,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
				        if(flag=="1"){
					        alert("保存成功");
					        location.href=path+'/soa/RsTalantTeamAction!toConfig.action?queryYear='+queryYear;
				        }else{
				        	clicked=true;
				        	alert("保存失败");
				        	$("#save").attr("disabled",false);	
				        }
					},
					error:function()
					{
						clicked=true;
						$("#save").attr("disabled",false);	
						alert("保存失败");
					}
				});
			}else{
				$("#save").attr("disabled",false);	
				clicked=true;
			}
		}
		function find(){
			var queryYear = document.getElementById("queryYear").value;
    		location.href="<%=path%>/soa/RsTalantTeamAction!toConfig.action?queryYear="+queryYear;
    	}
		function bk(){
			var queryYear = document.getElementById("queryYear").value;
    		location.href="<%=path%>/soa/RsTalantTeamAction!view.action?queryYear="+queryYear;
		}
    	function getRest() {
    		document.getElementById('queryYear').value = '';
    	}
    </script>
  </head>
  
  <body onload="addOptsCountAbc();">
   <div class="web_paht">
    <div class="row_l web_paht_l">您的位置：人才队伍建设&nbsp;&gt;&nbsp;基本信息配置</div>
</div>

<div class="main_in">
    <div id="nav" class="easyui-accordion" fit="true" border="false"  >
         <div title="基本信息配置" headerCls="bar_title" icon="title" selected="true">
         <form id="frm" name="frm" action="" method="post">
              <div class="table_edit">
              <table>
                      <tbody>
                       		<tr style="height: 40px;">
                       			<td style="text-align: right; width: 43%;">年份:</td>
                       			<td>
                       			<select style="width:90px" id="queryYear" name="queryYear"></select>
                       			&nbsp;&nbsp;&nbsp;<a href="javascript:find();" class="btn_search">搜 索</a>
                       			</td>
                       		</tr>
                      </tbody>
                  </table>
                  <table>
                      <tbody>
                      <s:if test="socialworkerList.size()>0 ">
	                      <tr>
                          	<th width="90px"></th>
                          	<th width="90px">人口总量</th>
                          	<th width="90px">从业人员总量</th>
                          	<th width="90px">农村农运力总量</th>
                          	<th width="90px">持证社工人数</th>
	                      </tr>
	                     <s:iterator value="socialworkerList" id="status" status="stat">
                          <tr>
                          	<input type="hidden" name="socialworkerList[<s:property value="#stat.index" />].swid" value="<s:property value="#status.swid"/>"/>
                          	<input type="hidden" name="socialworkerList[<s:property value="#stat.index" />].swdate" value="<s:property value="#status.swdate"/>"/>
                          	<input type="hidden" name="socialworkerList[<s:property value="#stat.index" />].qx" value="<s:property value="#status.qx"/>"/>
                          	  <s:if test="#status.qx==1">
                          	  	<th width="90px">武江</th>
                          	  </s:if>
                          	  <s:elseif test="#status.qx==2">
                          	  	<th width="90px">浈江</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==3">
                          	  	<th width="90px">曲江</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==4">
                          	  	<th width="90px">始兴</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==5">
                          	  	<th width="90px">仁化</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==6">
                          	  	<th width="90px">翁源</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==7">
                          	  	<th width="90px">乳源</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==8">
                          	  	 <th width="90px">新丰</th>
                          	  </s:elseif>
                          	  <s:elseif test="#status.qx==9">
                          	  	<th width="90px">乐昌</th>
                          	  </s:elseif>
                          	  <s:else>
                          	  	<th width="90px">南雄</th>
                          	  </s:else>
                              <td><input id="socialworkerList[<s:property value="#stat.index" />].t1" name="socialworkerList[<s:property value="#stat.index" />].t1" type="text" value="<s:property value="#status.t1"/>" class="inp" maxlength="6"/></td>
                              <td><input id="socialworkerList[<s:property value="#stat.index" />].t2" name="socialworkerList[<s:property value="#stat.index" />].t2" type="text" value="<s:property value="#status.t2"/>" class="inp" maxlength="6"/></td>
                              <td><input id="socialworkerList[<s:property value="#stat.index" />].t3" name="socialworkerList[<s:property value="#stat.index" />].t3" type="text" value="<s:property value="#status.t3"/>" class="inp" maxlength="6"/></td>
                              <td><input id="socialworkerList[<s:property value="#stat.index" />].t4" name="socialworkerList[<s:property value="#stat.index" />].t4" type="text" value="<s:property value="#status.t4"/>" class="inp" maxlength="6"/></td>
                          </tr>
                          </s:iterator>
                      
                      </tbody>
                      <tfoot>
                          <tr><td colspan="5">
                          <a id="save" onclick="save();" class="btn_search" >保 存</a>&nbsp;&nbsp;
                          <a onclick="bk();"; class="btn_search" >返回</a>
                          </td></tr>
                      </tfoot>
                      </s:if>
                  </table>
              </div>
             </form>
        </div>
    </div>
    
</div>
<script type="text/javascript">
var myDate = new Date();
var curY=myDate.getYear();
var qy = "<s:property value="queryYear"/>";
var qy1=$("#queryYear").val();
if(qy1==null){
	if(qy<curY){
		$("#save").remove();
	}
}else{
	if(qy1<curY){
		$("#save").remove();
	}
}
</script>
  </body>
</html>
