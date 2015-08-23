String.prototype.len=function()          
		{                 
		return     this.replace(/[^\x00-\xff]/g,"rr").length;          
		} 


// 删除
 function  del(_menuId){
	var delId = document.getElementsByName("educationId");
	var delIdLen = delId.length;
	var delTrs = new Array();	// 删除的tr的id集合
	var del_Ids = new Array();	// 删除记录对应的主键ID集合
	var del_Vs = new Array();	// 删除记录对应的主键值value集合
	var delTmp = 0;
	var _flag = true;	// 如果checkbox有选择就为false
	for(var i = 0; i < _listSize; i++) {
		var cbx = delId[i];
		if(!cbx){// 如果不存在这行，跳过，继续下一行
			continue;
		}
		if(cbx.checked) {
			var _v = cbx.value;// 主键值
			if(null!=_v && ''!=_v){
				del_Ids[del_Ids.length] = "form.dtoList["+i+"].educationId";
				del_Vs[del_Vs.length] = document.getElementById("form.dtoList["+i+"].educationId").value;
				
			}
			delTrs[delTrs.length] = cbx.parentNode.parentNode.id;
			_flag = false;
		}
	}
	if(_flag){
		alert("请选择记录！");
		return;
	}
	var isDelete=confirm("您确定要删除选择的记录吗？");
	if(isDelete){
		for(var j = 0; j < delTrs.length; j++) {
			var _tr = document.getElementById(delTrs[j]);
			_tr.parentNode.removeChild(_tr);
		}
		var _addDelStr="";
		for(var m = 0; m< del_Ids.length; m++){
			var _id = document.getElementById(del_Ids[m]);
			if(_id){}else{
				_addDelStr += '<input type="hidden" name="'+del_Ids[m]+'" value="'+del_Vs[m]+'"/>';
			}
			delTmp++;
		}
		document.getElementById("delIDs").innerHTML=_addDelStr;
		
		if(delTmp > 0) {
			
			$("#frm").ajaxSubmit({
					url: path + '/soa/jyjl!delete.action?menuId='+_menuId,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
				        if(flag=="1"){
				        	alert("教育简历删除成功！");
				        	location.href=path+'/soa/jyjl.action?menuId='+_menuId;
				        }else if(flag=="2"){
				        	alert("教育简历删除失败！");
				        }
					},
					error:function()
					{
						alert("教育简历删除失败！");
					}
				});
			/*frm.action = path + '/soa/jyjl!delete.action?menuId='+_menuId;
			frm.submit();*/
		}
	}
}
// 保存
function save(_menuId,param){
var flag=true;
var ram=Math.random();
	for(var i=0;i<_listSize;i++){
		var _id = document.getElementById("form.dtoList["+i+"].educationId");
		if(_id){
			var _fromDate = document.getElementById("form.dtoList["+i+"].fromDate").value;
			var _toDate = document.getElementById("form.dtoList["+i+"].toDate").value;
			var _pcollege = document.getElementById("form.dtoList["+i+"].pcollege").value;
			var _specialtyName = document.getElementById("form.dtoList["+i+"].specialtyName").value;
			
			if(_pcollege == ""){
				alert('请输入学校、机构名称！');
				flag=false;
				break;
			}
			if(_fromDate > _toDate){
				alert('开始日期不能大于结束日期！');
				flag=false;
				break;
			}
			if(_specialtyName == ""){
				alert('请输入所学专业！');
				flag=false;
				break;
			}
			if(_pcollege.len()>100){
				alert('学校、机构名称长度不能超过100！');
				flag=false;
				break;
			}
			if(_specialtyName.len()>100){
				alert('所学专业长度不能超过100！');
				flag=false;
				break;
			}
		}
	}
	
	if(clicked){
		clicked=false;
	}else{
		if(!flag){
			$("#save").attr("disabled",false);	
			$("#saveAndNext").attr("disabled",false);
			return;
		}
	}
	if(flag){
		$("#save").attr("disabled",true);	
		$("#saveAndNext").attr("disabled",true);
	$("#frm").ajaxSubmit({
				url: path + '/soa/jyjl!saveOrUpdate.action?menuId='+_menuId+"&ram="+ ram,
				dataType:"json",
				success: function(data, status)
				{   
					var flag=data.flag;
			        if(flag=="1"){
				        if(param==1){
				        	alert("教育简历保存成功！");
				        	location.href=path+'/soa/jyjl.action?menuId='+_menuId;
				        }else{
				        	location.href = path+'/soa/workexperience.action?menuId='+_menuId; 
				        }
			        }else if(flag=="2"){
			        	alert("教育简历保存失败！");
			        }
				},
				error:function()
				{
					alert("教育简历保存失败！");
				}
			});
	}
	//var frm = document.getElementById("frm");
	//frm.action = path + '/soa/jyjl!saveOrUpdate.action?menuId='+_menuId;
	//$("#frm").submit();
}