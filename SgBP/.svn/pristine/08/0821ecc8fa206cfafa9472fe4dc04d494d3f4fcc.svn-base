<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	long roleId = 0;
	if(request.getParameter("roleId") != null){
		roleId = Long.parseLong(request.getParameter("roleId"));
	}
	
	long groupId = 0;
	if(request.getParameter("groupId") != null){
		groupId = Long.parseLong(request.getParameter("groupId"));
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script language="javascript" src="<%=path%>/js/jquery/jquery-1.4.2.min.js"></script>
		<script language="javascript" src="<%=path%>/js/jquery/tree/hashMap.js"></script>
		<script language="javascript" src="<%=path%>/js/jquery/tree/tableTree.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery/tree/tableTree2.css">
		<script type="text/javascript"> 
			var myTree= new GridTree();
			/**
			 * 表格树
			 */
			function myTableTree()
			{                  
				var GridColumnType = [
			                  {
								header : 'ID',
								headerIndex : 'disid',
								//建议下面的宽带使用百分比,效果较好.
								width:'10%'
							}, {
								header : '名称',
								headerIndex : 'disname',
								width:'100px'
							}, {
								header : '上级',
								headerIndex : 'disparentName',
								width:'100px'
							}
							/*, {
								header : '操作类型',
								headerIndex : 'operStr',
								width:'150px'
							}*/
							, {
								header : '敏感信息',
								headerIndex : 'dicStr',
								width:'150px'
							}];
				var content = {columnModel:GridColumnType,        
					                dataUrl:"<%=path%>/system/role!findRootMenu.action?groupId=<%=groupId%>&roleId=<%=roleId%>",
			                        idColumn:'disid',//id所在的列,一般是主键(不一定要显示出来)
			                        parentColumn:'disparentId', //父亲列id
			                        pageSize:2,
			                        //pageBar:true,
			                        debug:false,
			                        //exchangeColor:false,
			                        analyzeAtServer:true,//设置了dataUrl属性的时候，如果此属性是false表示分析树形结构在前台进行，默认是后台分析（仅支持java）,体现在json格式不用！
			                        multiChooseMode:5,//选择模式，共有1，2，3，4，5种。 
			                      	tableId:'myTreeTable',//表格树的id
			                      	checkOption:2,//1:出现单选按钮,2:出现多选按钮,其他:不出现选择按钮
			                      	//rowCount:true,
			                      	onLazyLoadSuccess:function(gt){   
			                      		//alert('懒加载执行完了..');
			                      	},
			                      	onSuccess:function(gt){   
			                      		//alert('初次加载表格树执行完了..');
			                      	},
			                      	onPagingSuccess:function(gt){   
			                      		//alert('翻页执行完了..');
			                      	},
			                      	//lazy:true,//使用懒加载模式（此时打开全部，关闭全部功能不可使用）
			                      	chooesdOptionColumn:'rddisbled',//用来标识默认的就选择多选框的属性,在有多选的选按钮的情况时候有用
			                      	leafColumn:'isLeaf',//用于判断节点是不是树叶
			                        el:'newtableTree'//要进行渲染的div id
			           };
				myTree.loadData(content);
				myTree.makeTable();
				 
			}
			
			/**
			 * 双击事件,双击一行调用该方法.
			 * @param {行对象} obj
			 */
			function doubleClickOnRow(obj)
			{
				debugObjectInfo(obj);
			}
			
			function showHtml()
			{
				jQuery('#ans').text(jQuery('#newtableTree').html());
			}
			
			/**
			 * 用来查看一个对象的属性
			 */
			function debugObjectInfo(obj){
				traceObject(obj);
				function traceObject(obj){ 
					var str = '';
					if(obj.tagName&&obj.name&&obj.id)
					str="<table border='1' width='100%'><tr><td colspan='2' bgcolor='#ffff99'>traceObject 　　tag: &lt;"+obj.tagName+"&gt;　　 name = \""+obj.name+"\" 　　id = \""+obj.id+"\" </td></tr>"; 
					else{
						str="<table border='1' width='100%'>"; 
					}
					var key=[]; 
					for(var i in obj){ 
						key.push(i); 
					} 
					key.sort(); 
					for(var i=0;i<key.length;i++){ 
						var v= new String(obj[key[i]]).replace(/</g,"&lt;").replace(/>/g,"&gt;"); 
						if(typeof obj[key[i]]=='string'&&v!=null&&v!='')
							str+="<tr><td valign='top'>"+key[i]+"</td><td>"+v+"</td></tr>"; 
					} 
					str=str+"</table>"; 
					writeMsg(str); 
				} 
				function trace(v){ 
					var str="<table border='1' width='100%'><tr><td bgcolor='#ffff99'>"; 
					str+=String(v).replace(/</g,"&lt;").replace(/>/g,"&gt;"); 
					str+="</td></tr></table>"; 
					writeMsg(str); 
				} 
				function writeMsg(s){ 
					traceWin=window.open("","traceWindow","height=600, width=800,scrollbars=yes"); 
					traceWin.document.write(s); 
				} 
			}
			
			function mySelect()
			{
				var ans = getAllCheckValue();
				var roleMenuStr = '';
				var urlStr = '';
				if(ans!=''){
				   var arr = ans.split(',');
				   for(i=0;i<arr.length;i=i+1){
				      var menuId = arr[i];
					   var dicIds = '-1:';
					   jQuery('[name=menu_dic_'+menuId+']:checked').each(function(){
						 dicIds += this.value+':';
					   });
					   dicIds = dicIds.substring(0,dicIds.length-1); 
					   
					   roleMenuStr += menuId+';'+dicIds+',';
				   }
				   if(roleMenuStr != ''){
				     roleMenuStr = roleMenuStr.substring(0,roleMenuStr.length-1); 
				   }
				}
				return roleMenuStr;
			}
			function myClose()
			{
				window.close();
			}
		</script>
		<style>			
		body{
			font-size: 12px;
			background-color: #ffffff;
		}</style>
	</head>

	<BODY onload='myTableTree();'>
		<div id='newtableTree' style='width: 100%;border: 1px solid #000099; overflow-x: visible; overflow-y: scroll;'>
			正在装载，请等待。。。
		</div>
		<!-- 
		<button onclick='mySelect();' id='bt2'>
			选择
		</button> &nbsp;&nbsp;
		<button onclick='myClose();'>
			关闭
		</button>
		 -->
		<br>
		<div id='ans'></div> 
	</BODY>
</html>
