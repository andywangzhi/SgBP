$(function(){
			$('#list').datagrid({
				title:'<span style="color:#4682B4">用户列表</span>',
				iconCls:'icon-edit',
				width:'auto',
				height:390,
				nowrap: false,
				striped: true,
				collapsible:true,
				url:path+'/system/account!findAll.action?datestr='+new Date().getTime(),
				queryParams:{'name':'','realName':'','groupId':'','valid':'','searchflag':'0'},
				sortName: 'id',
				sortOrder: 'desc',
				remoteSort: true,
				idField:'id',
				frozenColumns:[[
	                {field:'ck',checkbox:true}
				]],
				columns:[[
				    {field:'nameCN',title:'中文名',width:100,sortable:true},
				    {field:'nameEN',title:'英文名',width:100,sortable:true},
					{field:'loginCode',title:'登录帐号',width:100},
					{field:'gender',title:'性别',width:45,
						formatter:function(value,rec){
						     if(value=='女'){
						       return '女';
						     }else if(value=='男'){
						      return '男';
						     }
						}
					},
				    {field:'deptNames',title:'所属部门',width:60},
					{field:'groupNames',title:'所属组',width:117},
					{field:'roleNames',title:'角色',width:80},
					{field:'usertype',title:'用户类型',width:80,
						formatter:function(value,rec){
						     if(value==0){
						       return '市本级';
						     }else{
						       return '县级';
						     }
						}
					},
					{field:'usercountry',title:'用户所属区县',width:117,
						formatter:function(value,rec){
						     if(value==1){
						       return '武江区';
						     }else if(value==2){
						       return '浈江区';
						     }else if(value==3){
						       return '曲江区';
						     }else if(value==4){
						       return '始兴县';
						     }else if(value==5){
						       return '仁化县';
						     }else if(value==6){
						       return '翁源县';
						     }else if(value==7){
						       return '乳源瑶族自治县';
						     }else if(value==8){
						       return '新丰县';
						     }else if(value==9){
						       return '乐昌市';
						     }else if(value==10){
						       return '南雄市';
						     }
						}
					},
				    {field:'tel',title:'电话',width:80},
					{field:'valid',title:'状态',width:70,align:'center',
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
				}]
			});
			loadGroup();
		});
	function loadGroup(){
	  $.ajax({
	     url:path+"/system/group!findGroup.action?datestr="+new Date().getTime(),
	     dataType:"json",
	     success:function(data){ 
	        loadGroupResult(data); 
	      }
	   });
	}
	function loadGroupResult(data){
	  for(i=0;i<data.length;i++){
	    $("#search_groupId").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   
	  }
	}
	function queryRecord(){
	    var queryParams = $('#list').datagrid('options').queryParams;
	   
	    queryParams.name = $("#search_name").val(); 
	    queryParams.realName = $("#search_realName").val(); 
	    queryParams.groupId = $("#search_groupId").val(); 
	    queryParams.valid = $("#search_valid").val();
	    document.frm.currpage.value=1;//表示重新查询 需从第一页开始
	    queryParams.searchflag ="1";
	     $('#list').datagrid('options').pageNumber=1;
	    $("#list").datagrid('reload');
	    queryParams.searchflag ="0"  ;//重置为非查询状态
	    
	}
	function addRecord(){
	    openWindow(path+'/system/account!viewAdd.action?datestr='+new Date().getTime(),570,390);
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
		     openWindow(path+"/system/account!viewEdit.action?id="+rows[0].id+"&datestr="+new Date().getTime(),570,390);
		  }
		}
	}
	
	function deleteRecord(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		var flag = false;
		var curFlag = false;
		for(var i=0;i<rows.length;i++){
		    if(rows[i].id==1)flag = true;
		    if(rows[i].id==curUserId)curFlag = true;
			ids.push(rows[i].id);
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else{
            if(flag){
                $.messager.alert("信息提示", "不能删除管理员帐号", "info");
			}else if(curFlag){
                $.messager.alert("信息提示", "前登陆用户不能删除", "info");
			}else{
	             $.messager.confirm('系统提示', '您确定要删除选择的记录吗?', function(r) {
	                 if (r) {
				           $.blockUI({ message: '<div class="showMsg">正在删除中,请稍等....</div>' });
				           $.get(path+"/system/account!saveStatus.action?status=2&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
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
	       openWindow(path+"/system/account!view.action?id="+rows[0].id+"&datestr="+new Date().getTime(),570,390);
		}
	}
	function setLang(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else{
	        openWindow(path+'/page/system/account/lang.jsp?ids=' + ids.join(','),170,170);
	    }
	} 
	function startRecord(){
		var ids = [];
		var rows = $('#list').datagrid('getSelections');
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].id);
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else{
             $.messager.confirm('系统提示', '您确定要激活选择的记录吗?', function(r) {
                 if (r) {
			           $.blockUI({ message: '<div class="showMsg">正在处理中,请稍等....</div>' });
			           $.get(path+"/system/account!saveStatus.action?status=1&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
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
		var curFlag = false;
		for(var i=0;i<rows.length;i++){
		    if(rows[i].id==1)flag = true;
		    if(rows[i].id==curUserId)curFlag = true;
			ids.push(rows[i].id);
		}
		if(ids==null || ids.length == 0){
		   alert('请选择记录');
		}else{
            if(flag){
                $.messager.alert("信息提示", "不能停用管理员帐号", "info");
			}else if(curFlag){
                $.messager.alert("信息提示", "前登陆用户不能停用当", "info");
			}else{
	             $.messager.confirm('系统提示', '您确定要停用选择的记录吗?', function(r) {
	                 if (r) {
				           $.blockUI({ message: '<div class="showMsg">正在处理中,请稍等....</div>' });
				           $.get(path+"/system/account!saveStatus.action?status=0&ids=" + ids.join(':')+"&datestr="+new Date().getTime(), function(data, status, Request){
				              $(".showMsg").html(data);
				               location.reload();
				           })
	                 }
	             });
			}
		}
	}
	
	function init(){
		$('#list').datagrid('selectRow',2);
	}