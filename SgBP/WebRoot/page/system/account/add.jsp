<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>
<html>
<head>
    <title>添加</title>
    <jsp:include page="../inc/top.jsp"></jsp:include>
    <script type="text/javascript">
    	var path='<%=path%>';
    </script>
    <script type="text/javascript" src="<%=path%>/js/system/account/add.js"></script>	
<style type="text/css">
 BODY {text-align:left; margin:0;}
</style>
</head>
<body>
<div style="background:#fafafa;">
    <form id="frm" method="post">
     <input type="hidden"  id="account_valid" name="account.valid" value="1"/>
      <div  fit="true">
          <div  border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
            <table cellpadding=3>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">帐号：</td>
                    <td style="text-align: left width 30%;">
                        <input width="30%" type="text" id="account_loginCode" onfocus="onfocusCheck('account_loginCode');" onBlur="checkCode()" name="account.loginCode"  /><span style="color:red">*</span>
                    </td>
                    <td style="text-align: right; width 20%;font-size:12px;">用户类型：</td>
                    <td>
	                    <select id="account.usertype" name="account.usertype" style="width:133px;" onchange="checkSel();">
	                      <option value="0" selected="selected">市本级</option>
	                      <option value="3">县级</option> 
	                    </select> 
                    </td>
                </tr>
                <tr id="g1" style="display: none;">
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
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">密码：</td>
                     <td style="text-align: left width 30%;">
                        <input width="30%" type="password" id="account_password" onfocus="onfocusCheck('account_password');" name="account.password"  /><span style="color:red">*</span>
                    </td>
                	<td style="text-align: right; width 20%;font-size:12px;">确认密码：</td>
                	<td style="text-align: left width 30%;">
                        <input width="30%" type="password" id="passConfirm" onfocus="onfocusCheck('passConfirm');" name="passConfirm"  /><span style="color:red">*</span>
                    </td>
                </tr>
                <tr>
                    <td  style="text-align: right;width=20%;font-size:12px;">中文名：</td>
                    <td>
                        <input width="30%" type="text" id="account_nameCN" onfocus="onfocusCheck('account_nameCN');" name="account.nameCN"  /><span style="color:red">*</span>
                    </td>
                    <td style="text-align: right; width 20%;font-size:12px;">英文名：</td>
                    <td>
                        <input width="30%" type="text" id="account_nameEN" onfocus="onfocusCheck('account_nameEN');" name="account.nameEN"  /><span style="color:red">*</span>
                     </td>
                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">性别：</td>
                    <td>
	                    <select id="account.gender" name="account.gender" style="width:133px;">
	                      <option value="男">男</option>
	                      <option value="女">女</option> 
	                    </select> 
                    </td>
                    <td style="text-align: right; width 20%;font-size:12px;">语言：</td>
                    <td>
	                    <select id="account.lang" name="account.lang" style="width:133px;">
	                      <option value="1">中文</option>
	                      <option value="2">英文</option> 
	                      <option value="3">繁体</option> 
	                    </select> 
                    </td>
                </tr>
                <tr>
                    <td  width="20%" style="text-align: right;font-size:12px;">联系电话：</td>
                    <td  width="30%" ><input type="text" id="account_tel" name="account.tel"  /></td>
                    <td style="text-align: right; width 20%;font-size:12px;">电子邮箱</td>
                    <td  width="30%" ><input type="text" id="account_email" name="account.email"  /></td>
                </tr>
                <tr>
                    <td style="text-align: right; width 20%;font-size:12px;">备注：</td>
                    <td colspan="3"><textarea id="account_remark" onfocus="onfocusCheck('account_remark');" name="account.remark" rows="25" cols="45" style="height:60px;"></textarea></td>
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