
		
		String.prototype.trim=function(){
		　　 return this.replace(/(^\s*)|(\s*$)/g, "");
		}
		String.prototype.ltrim=function(){
		　　 return this.replace(/(^\s*)/g,"");
		}
		String.prototype.rtrim=function(){
		　　 return this.replace(/(\s*$)/g,"");
		}
		String.prototype.len=function()          
		{                 
		return     this.replace(/[^\x00-\xff]/g,"rr").length;          
		} 
// 预览
function preview(uuid,pname,idCard,auditstate){
	var pnameEnCode=encodeURI(pname.trim().ltrim().rtrim());
	location.href=path+'/soa/previewAction.action?menuId='+menuId+'&form.uuid='+uuid+'&form.personDetail.pname='+pnameEnCode+'&form.personDetail.idCard='+idCard+'&form.personDetail.auditstate='+auditstate;
}


// 查询
function search(){
	var _flag=true;
	var _pname = document.getElementById('pname').value;
	var _idCard = document.getElementById('idCard').value;
	var _sourcetype = document.getElementById('sourcetype').value;
	var _deleapplystate = document.getElementById('deleapplystate').value;
	var _auditapplystate = document.getElementById('auditapplystate').value;
	var _adduser = document.getElementById('adduser').value;
	
	if(null!=_pname && _pname.len()>0)	_flag=false;
	if(null!=_idCard && _idCard.len()>0)	_flag=false;
	if(null!=_sourcetype &&  _sourcetype.len()>0)	_flag=false;
	if(null!=_deleapplystate && _deleapplystate.len()>0)	_flag=false;
	if(null!=_auditapplystate && _auditapplystate.len()>0)	_flag=false;
	if(null!=_adduser && _adduser.len()>0)	_flag=false;
	
	if(_flag){
		alert("请选择查询条件！");
		return;
	}
	
	document.getElementById('frm').action = path+'/soa/RsPerson!qyQuery.action?menuId='+menuId;
	document.getElementById('frm').submit();
}
// 重置
function getRest(){
	document.getElementById('pname').value = '';
	document.getElementById('idCard').value = '';
	document.getElementById('sourcetype').value = '';
	document.getElementById('deleapplystate').value = '';
	document.getElementById('auditapplystate').value = '';
	document.getElementById('adduser').value = '';
}

//删除启用
function delQyRun(){
	var selectInt = checkSelect("1");
	if(selectInt == 0) {
		alert('请选择记录');
	} else if(selectInt == -1) {
		alert('请选择已申请删除启用的记录！');
	} else {
		/*document.getElementById('frm').action = path+'/soa/RsPerson!delQyRun.action?menuId='+menuId;
		document.getElementById('frm').submit();*/

		$("#frm").ajaxSubmit({
			url: path+'/soa/RsPerson!delQyRun.action?menuId='+menuId,
			dataType:"json",
			success: function(data, status)
			{   
				var flag=data.flag;
		        if(flag=="1"){
		        	alert("删除启用，操作成功！");
		        	document.getElementById('frm').action = path+'/soa/RsPerson!qyQuery.action?menuId='+menuId;
		        	document.getElementById('frm').submit();
		        }else if(flag=="2"){
		        	alert("删除启用，操作失败！");
		        }
			},
			error:function()
			{
				alert("删除启用，操作失败！");
			}
		});
	}
}
//审核启用
function shQyRun(){
	var selectInt = checkSelect("2");
	if(selectInt == 0) {
		alert('请选择记录');
	} else if(selectInt == -2) {
		alert('请选择已申请审核启用的记录！');
	} else {
		/*document.getElementById('frm').action = path+'/soa/RsPerson!shQyRun.action?menuId='+menuId;
		document.getElementById('frm').submit();*/

		$("#frm").ajaxSubmit({
			url: path+'/soa/RsPerson!shQyRun.action?menuId='+menuId,
			dataType:"json",
			success: function(data, status)
			{   
				var flag=data.flag;
		        if(flag=="1"){
		        	alert("审核启用，操作成功！");

		        	document.getElementById('frm').action = path+'/soa/RsPerson!qyQuery.action?menuId='+menuId;
		        	document.getElementById('frm').submit();
		        }else if(flag=="2"){
		        	alert("审核启用，操作失败！");
		        }
			},
			error:function()
			{
				alert("审核启用，操作失败！");
			}
		});
	}
}
//tem=1删除启用申请，tem=2审核删除启用
function checkSelect(tem) {
	var selectInt = 0;
	var _input = document.getElementsByTagName('input');
	for(var i = 0; i < _input.length; i++) {
		if(_input[i].type == 'checkbox') {
			var cb = _input[i];
			if(cb.checked) {
				if(tem=='1'){
					var _deleapplystate = document.getElementById(cb.id.replace("personId","deleapplystate")).value;
					
					if(_deleapplystate!='1'){
						return -1;
					}
				}else if(tem=='2'){
					var _auditapplystate = document.getElementById(cb.id.replace("personId","auditapplystate")).value;
					
					if(_auditapplystate!='1'){
						return -2;
					}
				}
				selectInt ++;
			}
		}
	}
	return selectInt;
}




/*---------------------分页----------------------------------------*/
function firstPage() {
	document.getElementById('currentPage').value = 1;
	document.getElementById('frm').submit();
}

function prePage(curPage) {
	document.getElementById('currentPage').value = (Number(curPage) - 1);
	document.getElementById('frm').submit();
}

function nextPage(curPage) {
	document.getElementById('currentPage').value = (Number(curPage) + 1);
	document.getElementById('frm').submit();
}

function endPage(endPage) {
	document.getElementById('currentPage').value = Number(endPage);
	document.getElementById('frm').submit();
}
