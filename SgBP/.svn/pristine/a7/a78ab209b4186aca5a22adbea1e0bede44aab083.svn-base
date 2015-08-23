	String.prototype.len=function()          
		{                 
		return     this.replace(/[^\x00-\xff]/g,"rr").length;          
		} 
	// 保存数据
	function save() {
		
		var frm = document.getElementById("frm");
		var trList=$("tbody").children("tr").size();
		var flag=true;
		var ram=Math.random();
		var total = checkNull();
		if(clicked){
			clicked=false;
		}else{
			if(total>0){
				$("#save").attr("disabled",false);	
				$("#saveAndNext").attr("disabled",false);
				return;
			}
		}
		if(total == 0) {
			for(var i=0;i<trList;i++){
				var fdate = document.getElementById("form.dtoList["+i+"].fromDate");
				if(null==fdate){
					trList++;
				}else{
					var _fromDate =fdate.value;
					var _toDate = document.getElementById("form.dtoList["+i+"].toDate").value;
					if(_fromDate > _toDate){
						alert("开始日期不能大于结束日期！");
						flag=false;
						break;
					}
				}
			}
			if(flag){
				$("#save").attr("disabled",true);	
				//frm.action = path + '/soa/proj!saveOrUpdate.action?menuId='+menuId;
				//frm.submit();
				$("#frm").ajaxSubmit({
					url: path + '/soa/proj!ajaxSaveOrUpdate.action?menuId='+menuId+"&ram="+ ram,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
				        if(flag=="1"){
					       alert("项目经验保存成功!");
					       location.href=path+'/soa/proj!query.action?menuId='+menuId;
				        }else if(flag=="2"){
				        	alert("项目经验保存失败!");
				        }
					},
					error:function()
					{
						alert("项目经验保存失败!");
					}
				});
			}
		}	
	}
	
	// 验证输入信息是否完整
	function checkNull() {
		var total = 0;
		var txtObj = document.getElementsByTagName("input");
		for(var i = 0; i < txtObj.length; i++) {
			if(txtObj[i].type == "text") {
				var txtName = txtObj[i].name;
				var txtValue = txtObj[i].value;
				if(txtName.indexOf("personnum") != -1) {
					if(txtValue == null || txtValue == ''|| !isNumber(txtValue)) {
						alert("团队人数不能为空并且是整数!");
						return 1;
					}
				} else if(txtName.indexOf("projname") != -1) {
					if(txtValue == null || txtValue == '') {
						alert("请输入项目名称！");
						return 1;
					}else if(txtValue.len()>100){
						alert("项目名称长度太长！");
						return 1;
					}
				} else if(txtName.indexOf("projresponsibility") != -1) {
					if(txtValue == null || txtValue == '') {
						alert("请输入项目中担任的角色!");
						return 1;
					}else if(txtValue.len()>100){
						alert("项目中担任的角色长度太长！");
						return 1;
					}
				}else if(txtName.indexOf("projmoney")){
					if(txtValue == null || txtValue == '' || !isNumber(txtValue)) {
						alert("请输入项目金额，并且为数字类型！");
						return 1;
						}
					}
			}
		}
		return total;
	}
	// 删除数据
	function  del(){

		var delId = document.getElementsByName("deleteExperienceid");
		var delIdLen = delId.length;
		var delTrs = new Array();	// 删除的tr的id集合
		var del_Ids = new Array();	// 删除记录对应的主键ID集合
		var del_Vs = new Array();	// 删除记录对应的主键值value集合
		var delTmp = 0;
		var _flag = true;
		for(var i = 0; i < listSize; i++) {
			var cbx = delId[i];
			if(!cbx){// 如果不存在这行，跳过，继续下一行
				continue;
			}
			if(cbx.checked) {
				var _v = cbx.value;// 主键值
				if(null!=_v && ''!=_v){
					del_Ids[del_Ids.length] = "form.dtoList["+i+"].experienceid";
					del_Vs[del_Vs.length] = document.getElementById("form.dtoList["+i+"].experienceid").value;
					
				}
				delTrs[delTrs.length] = cbx.parentNode.parentNode.id;
				_flag = false;
			}
		}
		if(_flag){
			alert("请选择记录");
			return;
		}
		var isDelete=confirm("您真的要删除选中的记录吗？");
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
				frm.action = path + '/soa/proj!delete.action?menuId='+menuId;
				frm.submit();
			}
		}
}

	function deleteBySelect(){
			var proExpIds="";
			var selectedLines=$("[name = deleteExperienceid]:checkbox:checked").size();
			var confirmDelete=false;
			var step=0;
			var ram=Math.random();
			if(selectedLines<=0){
				alert("请选择记录!");
			}else{
				//组合要删除的ID
				$("[name = deleteExperienceid]:checkbox").each(function(){
					var proExpId=$(this).val();
					if($(this).attr("checked")){
						if(proExpId!=null&&proExpId!=""){
							proExpIds+=$(this).val()+",";
						}
					}
					if(step==0){
						confirmDelete=confirm("您确定要删除选择的记录吗？");
					}
					step++;
				});
				if(confirmDelete){
					$("[name = deleteExperienceid]:checkbox").each(function(){
						if($(this).attr("checked")){
							var proExpId=$(this).val();
							if(confirmDelete){
								$(this).closest("tr").remove();
							}
						}
					});
				}
				
				//再删除已经存在的
				if(proExpIds!=""&&confirmDelete){
					$("#frm").ajaxSubmit({
						url: path+'/soa/proj!ajaxDeleteBySelect.action?menuId='+menuId+'&ram='+ ram+"&form.selected="+proExpIds,
						dataType:"json",
						success: function(data, status)
						{   
							var flag=data.flag;
					        if(flag=="1"){
					        	alert("项目经验删除成功!");
					        	location.href=path+'/soa/proj!query.action?menuId='+menuId;
					        }else if(flag=="2"){
					        	alert("项目经验删除失败!");
					        }
						},
						error:function()
						{
							alert("项目经验删除失败!");
						}
					});
					//location.href=path+'/soa/proj!deleteBySelect.action?menuId='+menuId+'&ram='+ ram+"&form.selected="+proExpIds;
				}
			}
		}
		
	// 刷新
	function refresh(){
	   location.href = path+'/soa/proj!query.action?menuId='+menuId;
	}
	function isNumber(oNum) 
	   { 
		  if(!oNum) return false; 
			  var strP=/^\d+(\.\d+)?$/; 
			  if(!strP.test(oNum)) return false; 
			  try{ 
			  if(parseFloat(oNum)!=oNum) return false; 
			  } 
			  catch(ex) 
			  { 
			   return false; 
			  } 
			  return true; 
	   }
	   function preview(param,p1,p2,p3){
	   		var pnameEnCode=encodeURI(p1);
			location.href=path+'/soa/previewAction.action?menuId='+menuId+'&form.uuid='+param+'&form.personDetail.pname='+pnameEnCode+'&form.personDetail.idCard='+p2+'&form.personDetail.auditstate='+p3;
		}
	  