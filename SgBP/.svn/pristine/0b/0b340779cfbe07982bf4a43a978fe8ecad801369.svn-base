$(function(){
			$('#list').datagrid({
				title:'<span style="color:#4682B4">用户组列表</span>',
				iconCls:'icon-edit',
				width:'auto',
				height:390,
				nowrap: false,
				striped: true,
				collapsible:true,
				url:path+'/system/group!findAll.action?datestr='+new Date().getTime(),
				queryParams:{'name':'','reamrk':'','valid':'','searchflag':'0'},
				sortName: 'createDate',
				sortOrder: 'desc',
				remoteSort: true,
				idField:'id',
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
					{field:'name',title:'组名',width:200},
					{field:'groupManager',title:'组管理员',width:150},
					{field:'valid',title:'状态',width:80,align:'center',
						formatter:function(value,rec){
						     if(value=='0'){
						       return '<span style="color:gray">已停用</span>';
						     }else if(value=='2'){
						       return '<span style="color:red">已删除</span>';
						     }else{
						       return '<span style="color:blue">已启用</span>';
						     }
						}
					},
					{field:'remark',title:'描述',width:327}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					text:'新增',
					iconCls:'icon-add',
					handler:addRecord
				},{
					text:'修改',
					iconCls:'icon-edit',
					handler:editRecord
				},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:deleteRecord
				},'-',{
					text:'查看',
					iconCls:'icon-search',
					handler:viewRecord
				},'-',{
					text:'激活',
					iconCls:'icon-redo',
					handler:startRecord
				},'-',{
					text:'停用',
					iconCls:'icon-cancel',
					handler:stopRecord
				}]
			});
		});
		
	function queryRecord(){
	    var queryParams = $('#list').datagrid('options').queryParams;
	    queryParams.name = $("#search_name").val();
	    queryParams.remark = $("#search_remark").val(); 
	    queryParams.valid = $("#search_valid").val(); 
	    document.frm.currpage.value=1;//表示重新查询 需从第一页开始
	    queryParams.searchflag ="1";
	     $('#list').datagrid('options').pageNumber=1;
 	    queryParams.searchflag ="0"  ;//重置为非查询状态
	    $("#list").datagrid('reload');
	}

	
	function addRecord(){
	    openWindow(path+'/system/group!viewAdd.action?datestr='+new Date().getTime(),700,490);
	}
	
	function editRecord(){
		var rows = $('#list').datagrid('getSelections');
		if(rows==null || rows.length == 0){
		  alert('请选择记录');
		}else if(rows.length>1){
		  alert('只能选择一条记录');
		}else { 
		  if(rows[0].valid != '1'){
		      alert('只能修改状态为‘已启用’的记录');
		  }else{
		    openWindow(path+"/system/group!viewEdit.action?id="+rows[0].id+"&datestr="+new Date().getTime(),700,490);
		  }
		}
	}
	
	function deleteRecord(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		var flag = false;
		for(var i=0;i<rows.length;i++){
		    if(rows[i].id==1)flag = true;
			ids.push(rows[i].id);
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else{
			if(flag){
			    $.messager.alert("信息提示", "不能删除系统管理员组", "info");
			}else {
				if(confirm('您确定要删除选择的记录吗?')){
						$.blockUI({ message: '<div class="showMsg">正在删除中,请稍等....</div>' });
				           $.get(path+"/system/group!saveStatus.action?status=2&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
			                  if(data=='false'){
				            	 alert("删除失败，请先删除组关联的角色");
				              }else{
				            	 alert("删除成功");
				              }
				              location.reload();
				           });
				}
			}
             
		}
	}
	
	function startRecord(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		var flag = true;
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
			if(rows[i].valid == '2')flag=false;
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else if(!flag){
		   alert('不能激活已删除的记录');
		}else{
             $.messager.confirm('系统提示', '您确定要激活选择的记录吗?', function(r) {
                 if (r) {
			           $.blockUI({ message: '<div class="showMsg">正在处理中,请稍等....</div>' });
			           $.get(path+"/system/group!saveStatus.action?status=1&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
			              $(".showMsg").html(data);
			               location.reload();
			           })
                 }
             });
		}
	}
	
	function stopRecord(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		var flag = false;
		var flag2 = true;
		for(var i=0;i<rows.length;i++){
		    if(rows[i].id==1)flag = true;
			ids.push(rows[i].id);
			if(rows[i].valid == '2')flag2=false;
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else if(!flag2){
		   alert('不能停用已删除的记录');
		}else{
			if(flag){
			    $.messager.alert("信息提示", "不能停用系统管理员组", "info");
			}else {
	             $.messager.confirm('系统提示', '您确定要停用选择的记录吗?', function(r) {
	                 if (r) {
				           $.blockUI({ message: '<div class="showMsg">正在处理中,请稍等....</div>' });
				           $.get(path+"/system/group!saveStatus.action?status=0&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
				              $(".showMsg").html(data);
				               location.reload();
				           })
	                 }
	             });
			}
		}
	}
	
	function viewRecord(){
		var rows = $('#list').datagrid('getSelections');
		if(rows==null || rows.length == 0){
		  alert('请选择记录');
		}else if(rows.length>1){
		  alert('只能选择一条记录');
		}else { 
	       openWindow(path+"/system/group!view.action?id="+rows[0].id+"&datestr="+new Date().getTime(),700,490);
		}
	}