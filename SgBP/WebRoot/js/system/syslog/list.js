$(function(){
			$('#list').datagrid({
				title:'<span style="color:#4682B4">日志列表</span>',
				iconCls:'icon-edit',
				width:'auto',
				height:448,
				nowrap: false,
				striped: true,
				collapsible:true,
				url:path+'/system/sysLog!findAll.action?datestr='+new Date().getTime(),
				sortName: 'id',
				sortOrder: 'desc',
				remoteSort: true,
				idField:'id',
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
					{field:'accountName',title:'操作人',width:100},
					{field:'logType',title:'类型',width:200,sortable:true},
					{field:'operIp',title:'IP',width:90},
				    {field:'createDate',title:'创建日期',width:120},
					{field:'remark',title:'备注',width:245}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					text:'查看',
					iconCls:'icon-search',
					handler:viewRecord
				}]
			});
		});

	function queryRecord(){
	    var queryParams = $('#list').datagrid('options').queryParams;
	    queryParams.name = $("#search_accountName").val(); 
	    queryParams.type = $("#search_logType").val();  
	    document.frm.currpage.value=1;//表示重新查询 需从第一页开始
	    queryParams.searchflag ="1";
	     $('#list').datagrid('options').pageNumber=1;
	      queryParams.searchflag ="0"  ;//重置为非查询状态
	    $("#list").datagrid('reload');
	}
	
	function deleteRecord(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else{
             $.messager.confirm('系统提示', '您确定要删除选择的记录吗?', function(r) {
                 if (r) {
			           $.blockUI({ message: '<div class="showMsg">正在删除中,请稍等....</div>' });
			           $.get(path+"/system/account!delete.action?ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
			              $(".showMsg").html(data);
			               location.reload();
			           })
                 }
             });
		}
	}
		
	function viewRecord(){
		var rows = $('#list').datagrid('getSelections');
		if(rows==null || rows.length == 0){
		  alert('请选择记录');
		}else if(rows.length>1){
		  alert('只能选择一条记录');
		}else { 
	       openWindow(path+"/system/sysLog!view.action?id="+rows[0].id+"&datestr="+new Date().getTime(),570,350);
		}
	}