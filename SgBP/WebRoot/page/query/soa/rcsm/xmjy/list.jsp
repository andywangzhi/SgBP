<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css" />
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/business/css/reset.css" />
    <script type="text/javascript" src="<%=path%>/locale/easyui-lang-zh_CN.js"></script>
   	<script type="text/javascript" src="<%=path%>/js/query/public/checkboxDate.js"></script>
   	<script type="text/javascript" src="<%=path%>/js/query/rcsm/xmjy/input.js" ></script>
   	<script type="text/javascript" src="<%=path%>/js/jquery-form-3.14.js"></script>
		<title>项目经验</title>
		<script type="text/javascript" >
		 var path = '<%=path%>'; 
		 var entrance='<%=request.getParameter("entrance")%>';
		 var clicked=true;
	   	var listSize = '<s:property value="form.dtoList.size()" />';
		var message = '${message}';
	   	var menuId='<%=request.getParameter("menuId")%>';
	   	if(listSize == null || listSize == '' || isNaN(listSize)) {
	   		listSize = '0';
	   	}
	// 新增输入数据行
		function add() {
			var trcomp='<tr  align="center"  bgcolor="#FFFFFF" id="trID'+listSize+'">';
			trcomp+='<td><input type="checkbox"  name="deleteExperienceid" value=""></td>';
			trcomp+='<td nowrap="nowrap" style="width: 330px;"><input id="form.dtoList['+listSize+'].fromDate" name="form.dtoList['+listSize+'].fromDate" type="hidden" value="'+getFirstDay()+'"/>';
			trcomp+='<input id="form.dtoList['+listSize+'].toDate" name="form.dtoList['+listSize+'].toDate" type="hidden" value="'+getEndDay()+'"/>';
			var _change1 = "selectChange(this,'"+listSize+"','year','fromMonth','fromDate','start','form.dtoList');";
			trcomp+='<select id="fromYear'+listSize+'" name="fromYear'+listSize+'" onchange="'+_change1+'"></select>&nbsp;年&nbsp;';
			
			var _change2 = "selectChange(this,'"+listSize+"','month','fromYear','fromDate','start','form.dtoList');";
			trcomp+='<select id="fromMonth'+listSize+'" name="fromMonth'+listSize+'" onchange="'+_change2+'"></select>&nbsp;月&nbsp';
			
			trcomp+='&nbsp;-&nbsp;';
			
			var _change3 = "selectChange(this,'"+listSize+"','year','toMonth','toDate','end','form.dtoList');";
			trcomp+='<select id="toYear'+listSize+'" name="toYear'+listSize+'" onchange="'+_change3+'"></select>&nbsp;年&nbsp;';
			
			var _change4 = "selectChange(this,'"+listSize+"','month','toYear','toDate','end','form.dtoList');";
			trcomp+='<select id="toMonth'+listSize+'" name="toMonth'+listSize+'" onchange="'+_change4+'"></select>&nbsp;月';
			trcomp+='</td>';
			trcomp+='<TD><INPUT class="inp" style="width: 60px;" type="text" name="form.dtoList['+listSize+'].personnum" value="" maxlength="10"></TD>';
			trcomp+='<TD><INPUT class="inp" style="width: 100px;" type="text" name="form.dtoList['+listSize+'].projname" value=""  maxlength="100" ></TD>';
			trcomp+='<TD><INPUT class="inp" style="width: 80px;" type="text" name="form.dtoList['+listSize+'].projmoney" value="" maxlength="6"></TD>';
			trcomp+='<TD><INPUT class="inp" style="width: 120px;" type="text" name="form.dtoList['+listSize+'].projresponsibility" value=""  maxlength="100" ></TD></TR>';
			
			$("tbody").append(trcomp);
		
			if(document.getElementById('fromYear'+listSize))	addYearOpts('fromYear'+listSize);
			if(document.getElementById('fromMonth'+listSize))	addMonthOpts('fromMonth'+listSize);
			if(document.getElementById('toYear'+listSize)){	addYearOpts('toYear'+listSize);}
			if(document.getElementById('toMonth'+listSize)){	addMonthOpts('toMonth'+listSize);}
			// 每增加一行将提交的数据数组下标增加1
			listSize ++;
	
	}
	
	
	</script>
	</head>
<body>
<form action="<%=path%>/soa/proj!saveOrUpdate.action?menuId=<%=request.getParameter("menuId")%>" method="post" id="frm" name="frm">
<DIV class="web_paht">
<DIV class="row_l web_paht_l">您的位置：人员信息<script type="text/javascript">if(entrance==1){document.write("申报");}else{document.write("维护");}</script>&nbsp;&gt;&nbsp;项目经验
<font style="color: blue;">（${personName}-${personIdCard}）</font>
</DIV>
<DIV class="row_r web_paht_r tool">
状态:<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"63\")" id="status" status="st">
	         <s:if test="form.auditstate==key">
	           <font color="red"><s:property value="value"/></font>
	         </s:if>
		 </s:iterator>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</DIV></DIV>
<div id="delIDs"></div>  
<div style="text-align: center; font-weight:bold; font-size:25px; margin-top: 10px;">项 目 经 验</div>
<div class="row_l web_paht_l tool" style="height:20px; text-align: left;margin: 0px 15px;">
        <a class="refresh" onclick="refresh();" style="margin-left: 0px;">刷新</a>
        <a href="javascript:preview('<%=session.getAttribute("personId")%>','<%=session.getAttribute("personName")%>','<%=session.getAttribute("personIdCard")%>','<%=session.getAttribute("auditstate")%>');" class="msn" >预览</a>
        <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
        <a class="plus" onclick="add();">新增</a>
        <a class="delete" onclick="deleteBySelect();">删除</a>
        </s:if>
</div>
<DIV class="main_in">
<DIV class="table_edit"  style="height: 294px;">
<input type="hidden" name="form.retrieveSO.personId" value="<s:property value="form.personId" />">
<TABLE id="experTable">
  <THEAD>
  <TR>
  <TH>
      <P align="center" style="width: 30px;">选择</P></TH>
    <TH>
      <P align="center">起止年月</P></TH>
    <TH>
      <P align="center">团队人数</P></TH>
    <TH>
      <P align="center">项目名称</P></TH>
    <TH>
      <P align="center">项目金额(万)</P></TH>
     <TH>
      <P align="center">项目中担任的角色</P></TH></TR></THEAD>
  <TBODY>
	    <s:iterator value="form.dtoList" id="id" status="stat" >
		  	<s:if test="#stat.odd"> 
							  <tr align="center"  bgcolor="#FFFFFF" id="trID<s:property value="#stat.index" />">
						  </s:if>	
						  <s:else>
							  <tr align="center" id="trID<s:property value="#stat.index" />">
						  </s:else>
		  		<td>
		  			  	 <input type="checkbox"   name="deleteExperienceid" value="<s:property value="#id.experienceid"/>">
		  				<input type="hidden" id="form.dtoList[${stat.index}].experienceid" name="form.dtoList[${stat.index}].experienceid" value="<s:property value="#id.experienceid"/>"  >
		  				<input type="hidden" name="form.dtoList[${stat.index}].personId" value="<s:property value="#id.personId"/>"  >
		  				<input type="hidden" name="form.dtoList[${stat.index}].adduser" value="<s:property value="#id.adduser"/>"  >
		  				<input type="hidden" name="form.dtoList[${stat.index}].adddate" value="<s:property value="#id.adddate"/>"  >
		  		
		  		</td>
				 <TD nowrap="nowrap" style="width: 330px;"><input id='form.dtoList[<s:property value="#stat.index" />].fromDate' name='form.dtoList[<s:property value="#stat.index" />].fromDate' type="hidden" value='<s:property value="#id.fromDate"/>' />
				 <input id="form.dtoList[<s:property value="#stat.index" />].toDate" name="form.dtoList[<s:property value="#stat.index" />].toDate" type="hidden" value='<s:property value="#id.toDate"/>' /><select id='fromYear<s:property value="#stat.index" />' name='fromYear<s:property value="#stat.index" />' onchange="selectChange(this,'<s:property value="#stat.index" />','year','fromMonth','fromDate','start','form.dtoList');"></select>&nbsp;年&nbsp;<select id='fromMonth<s:property value="#stat.index" />' name='fromMonth<s:property value="#stat.index" />' onchange="selectChange(this,'<s:property value="#stat.index" />','month','fromYear','fromDate','start','form.dtoList');"></select>&nbsp;月&nbsp;
						<script type="text/javascript">
							var _v='<s:property value="#id.fromDate"/>';
		                  	addYearOpts('fromYear<s:property value="#stat.index" />');
		                  	addMonthOpts('fromMonth<s:property value="#stat.index" />');
		                  	var myDate= new Date(Date.parse(_v.replace(/-/g, "/")));
		                  	var _yyyy = myDate.getFullYear();
		                  	var _MM = myDate.getMonth() + 1;
		                  	_MM = (_MM<10?("0"+_MM):_MM)
				            document.getElementById('fromYear<s:property value="#stat.index" />').value = _yyyy;
				            document.getElementById('fromMonth<s:property value="#stat.index" />').value = _MM;
	                  	</script>
	                  	-&nbsp;<select id='toYear<s:property value="#stat.index" />' name='toYear<s:property value="#stat.index" />' onchange="selectChange(this,'<s:property value="#stat.index" />','year','toMonth','toDate','end','form.dtoList');"></select>&nbsp;年&nbsp;<select id='toMonth<s:property value="#stat.index" />' name='toMonth<s:property value="#stat.index" />' onchange="selectChange(this,'<s:property value="#stat.index" />','month','toYear','toDate','end','form.dtoList');"></select>&nbsp;月
	                  	<script type="text/javascript">
							var _v='<s:property value="#id.toDate"/>';
		                  	addYearOpts('toYear<s:property value="#stat.index" />');
		                  	addMonthOpts('toMonth<s:property value="#stat.index" />');
		                  	var myDate= new Date(Date.parse(_v.replace(/-/g, "/")));
		                  	var _yyyy = myDate.getFullYear();
		                  	var _MM = myDate.getMonth() + 1;
		                  	_MM = (_MM<10?("0"+_MM):_MM)
				            document.getElementById('toYear<s:property value="#stat.index" />').value = _yyyy;
				            document.getElementById('toMonth<s:property value="#stat.index" />').value = _MM;
	                  	</script>
</TD>
			    <TD><INPUT class="inp" style="width: 60px;"  type="text" name="form.dtoList[${stat.index}].personnum" value="<s:property value="#id.personnum"/>" maxlength="10"></TD>
			    <TD><INPUT class="inp" style="width: 100px;"  type="text" name="form.dtoList[${stat.index}].projname" value="<s:property value="#id.projname"/>"  maxlength="100"></TD>
			    <TD><INPUT class="inp" style="width: 80px;"  type="text" name="form.dtoList[${stat.index}].projmoney" value="<s:property value="#id.projmoney"/>" maxlength="10"></TD>
		    	<TD><INPUT class="inp"  style="width: 120px;" type="text" name="form.dtoList[${stat.index}].projresponsibility" value="<s:property value="#id.projresponsibility"/>" maxlength="100"></TD>
		    	</TR>
	    </s:iterator>
  </TBODY>
   <tfoot>
                          <tr><td colspan="6"> 
                          <s:if test="form.auditstate=='000'||form.auditstate=='200'||form.auditstate=='100'">
                          <a id="save" class="btn_search" onclick="save();">保存</a>
                          </s:if>
                          </td></tr>
                      </tfoot>
</TABLE>
  
    </DIV></DIV> 
    </form>

    
</body>
</html>