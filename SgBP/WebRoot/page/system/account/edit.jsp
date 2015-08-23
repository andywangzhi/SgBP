<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
    <title>修改</title>
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/account/edit.js"></script>	
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
     <input type="hidden"  name="account.id" value="<s:property value="account.id"/>"/>
     <input type="hidden"  name="account.password" value="<s:property value="account.password"/>"/>
     <input type="hidden"  id="account_valid" name="account.valid" value="<s:property value="account.valid"/>"/>
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            <table cellpadding=3>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">帐号：</td>
                    <td style="text-align: left width 30%;">
                        <input width="30%" type="text" id="account_loginCode" onfocus="onfocusCheck('account_loginCode');" name="account.loginCode"  value="<s:property value="account.loginCode"/>" readonly="true"/><span style="color:red">*</span>
                    </td>
                    
                    <td style="text-align: right; width 20%;font-size:12px;">用户类型：</td>
                    <td>
	                    <select id="account.usertype" name="account.usertype" style="width:133px;" onchange="checkSel();">
	                      <option value="0"  <s:if test='account.usertype=="0"'>selected</s:if>>市本级</option>
	                      <option value="3"  <s:if test='account.usertype=="3"'>selected</s:if>>县级</option> 
	                    </select> 
                    </td>
                </tr>
                <s:if test='account.usertype=="3"'>
	                <tr id="g1">
		                <td style="text-align: right;">用户所属区县:</td>
	                <td colspan="3" style="text-align: left;">	                
	                <select id="retrieveSOpcounty" name="account.usercountry">
                         	<option value="">请选择</option>
                       		<s:iterator value="#application._WEB_SYS_CONF_KEY_.get(\"15\")">
                              	 <option value="<s:property value="key"/>" <s:if test="account.usercountry == key"> selected="selected"</s:if> ><s:property value="value"/></option>
							</s:iterator>
                    </select>
                	</td>
	                </tr>
                </s:if>
                <s:else>
                	<tr id="g1" style="display: none;">
                	<td style="text-align: right;">用户所属区县:</td>
                	 <td colspan="3" style="text-align: left;">
	                	 <select id="retrieveSOpcounty" name="account.usercountry">
	                	 	<option value="">请选择</option>
	                	 	<option value="1">武江区</option>
	                	 	<option value="2">浈江区</option>
	                	 	<option value="3">曲江区</option>
	                	 	<option value="4">始兴县</option>
	                	 	<option value="5">仁化县</option>
	                	 	<option value="6">翁源县</option>
	                	 	<option value="7">乳源瑶族自治县</option>
	                	 	<option value="8">新丰县</option>
	                	 	<option value="9">乐昌市</option>
	                	 	<option value="10">南雄市</option>
	                	 </select>
                	 </td>
	                </tr>
                </s:else>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">密码：</td>
                     <td style="text-align: left width 30%;">
                        <input width="30%" type="password" id="newpassword" name="newpassword" value="" title="留空表示保留原密码"/><span style="color:red">*</span>
                    </td>
                	<td style="text-align: right; width 20%;font-size:12px;">确认密码：</td>
                	<td style="text-align: left width 30%;">
                        <input width="30%" type="password" id="passConfirm" onfocus="onfocusCheck('passConfirm');" name="passConfirm"  /><span style="color:red">*</span>
                    </td>

                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">中文名：</td>
                    <td>
                        <input width="30%" type="text" id="account_nameCN" onfocus="onfocusCheck('account_nameCN');" name="account.nameCN"  value="<s:property value="account.nameCN"/>"/><span style="color:red">*</span>
                    </td>
                    <td style="text-align: right; width 20%;font-size:12px;">英文名：</td>
                    <td>
                        <input width="30%" type="text" id="account_nameEN" onfocus="onfocusCheck('account_nameEN');" name="account.nameEN"  value="<s:property value="account.nameEN"/>"/><span style="color:red">*</span>
                 	</td>
                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">性别：</td>
                    <td>
                       <select id="account.gender" name="account.gender" style="width:133px;">
	                      <option value="男"  <s:if test='account.gender=="男"'>selected</s:if>>男</option>
	                      <option value="女"  <s:if test='account.gender=="女"'>selected</s:if>>女</option> 
	                    </select> 
                    </td>
                    <td style="text-align: right; width 20%;font-size:12px;">语言：</td>
                    <td>
                       <select id="account.lang" name="account.lang" style="width:133px;">
	                      <option value="1"  <s:if test='account.lang=="1"'>selected</s:if>>中文</option>
	                      <option value="2"  <s:if test='account.lang=="2"'>selected</s:if>>英文</option>
	                      <option value="3"  <s:if test='account.lang=="3"'>selected</s:if>>繁体</option> 
	                    </select> 
                    </td>
                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">联系电话：</td>
                    <td  width="30%" ><input type="text" id="account_tel" name="account.tel"    value="<s:property value="account.tel"/>"/></td>
                	<td style="text-align: right; width 20%;font-size:12px;">电子邮箱</td>
                    <td  width="30%" ><input type="text" id="account_email" name="account.email"    value="<s:property value="account.email"/>"/></td>
                </tr>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">备注：</td>
                    <td colspan="3"><textarea id="account_remark" onfocus="onfocusCheck('account_remark');" name="account.remark" rows="25" cols="45" style="height:60px;"><s:property value="account.remark"/></textarea></td>
                </tr>
            </table>
          </div>
          <div border="false" style="text-align: center; height: 30px;margin-top:10px;  line-height: 30px;">
              <a class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" onclick="saveData()">确定</a> 
          </div>
      </div>
    </form>
</div>
</body>
</html>

