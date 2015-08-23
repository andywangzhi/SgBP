$(function(){
			$('#list').datagrid({
				title:'<span style="color:#4682B4">资源列表</span>',
				iconCls:'icon-edit',
				width:'auto',
				height:390,
				nowrap: false,
				striped: true,
				collapsible:true,
				url:path+'/system/resource!findAll.action?datestr='+new Date().getTime(),
				queryParams:{'code':'','dec':'','type':'','valid':'','searchflag':'0'},
				sortName: 'createDate',
				sortOrder: 'desc',
				remoteSort: true,
				idField:'id',
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
					{field:'key',title:'编码',width:140},
					{field:'nameEn',title:'英文名',width:155},
					{field:'nameZh',title:'中文名',width:150},
					{field:'nameTw',title:'繁体名',width:150},
					{field:'useType',title:'类型',width:80,
						formatter:function(value,rec){
						     if(value=='1'){
						       return '页面显示';
						     }else if(value=='2'){
						      return '错误提示';
						     }else if(value=='3'){
						      return '信息提示';
						     }
						}
					},
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
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					text:'新增',
					iconCls:'icon-add',
					handler:addRecord
				},{
					text:'修改',
					iconCls:'icon-undo',
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
				},'-',{
					text:'刷新缓存',
					iconCls:'icon-reload',
					handler:refreshResource
				}]
			});
		});
	function queryRecord(){
	    var queryParams = $('#list').datagrid('options').queryParams;
	    queryParams.code = $("#search_code").val(); 
	    queryParams.dec = $("#search_dec").val(); 
	    queryParams.type = $("#search_type").val(); 
	    queryParams.valid = $("#search_valid").val(); 
	    document.frm.currpage.value=1;//表示重新查询 需从第一页开始
	    queryParams.searchflag ="1";
	     $('#list').datagrid('options').pageNumber=1;
 	    queryParams.searchflag ="0"  ;//重置为非查询状态
	    $("#list").datagrid('reload');
	}
	function addRecord(){
	    openWindow(path+'/system/resource!viewAdd.action?datestr='+new Date().getTime(),700,490);
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
		      openWindow(path+"/system/resource!viewEdit.action?id="+rows[0].id+"&datestr="+new Date().getTime(),700,490);
		  }
		}
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
			           $.get(path+"/system/resource!saveStatus.action?status=2&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
			              $(".showMsg").html(data);
			               location.reload();
			           })
                 }
             });
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
			           $.get(path+"/system/resource!saveStatus.action?status=1&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
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
		var flag2 = true;
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
			if(rows[i].valid == '2')flag2=false;
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else if(!flag2){
		   alert('不能停用已删除的记录');
		}else{
             $.messager.confirm('系统提示', '您确定要停用选择的记录吗?', function(r) {
                 if (r) {
			           $.blockUI({ message: '<div class="showMsg">正在处理中,请稍等....</div>' });
			           $.get(path+"/system/resource!saveStatus.action?status=0&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
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
	       openWindow(path+"/system/resource!view.action?id="+rows[0].id+"&datestr="+new Date().getTime(),700,490);
		}
	}
	
	function refreshResource(){
        $.messager.confirm('系统提示', '您确定要刷新所有的资源缓存吗?', function(r) {
            if (r) {
           $.blockUI({ message: '<div class="showMsg">正在刷新所有的资源缓存,请稍等....</div>' });
           $.get(path+"/system/resource!refreshResource.action?datestr="+new Date().getTime(), function(data, status, Request){
              $(".showMsg").html(data);
               location.reload();
           })
            }
        });
        }
