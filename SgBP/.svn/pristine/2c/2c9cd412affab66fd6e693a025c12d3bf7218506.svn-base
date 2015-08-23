
//保存新增数据

String.prototype.len=function(){                 
	return  this.replace(/[^\x00-\xff]/g,"rr").length;          
} 
  	
function saveData(param){
	//验证数据
	var trList=$("tbody").children("tr").size();
	var ram=Math.random();
	var flag=true;
	for(var i=0;i<trList;i++){
		var companyNameTag=document.getElementById("form.dtoDetailList["+i+"].companyName");
		if(!companyNameTag){
			continue;
		}
		var val= document.getElementById("form.dtoDetailList["+i+"].companyName").value;
		var _fromDate = document.getElementById("form.dtoDetailList["+i+"].fromDate").value;
		var _toDate = document.getElementById("form.dtoDetailList["+i+"].toDate").value;
		if(null==val||val==""){
				alert("请填写单位名称!");
				flag=false;
				break;
		}else if(val.len()>100){
			alert("单位名称长度过长!");
			flag=false;
			break;
		}else if(_fromDate > _toDate){
				alert("开始日期不能大于结束日期！");
				flag=false;
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
		//$("#frm").submit();
		$("#save").attr("disabled",true);	
		$("#saveAndNext").attr("disabled",true);
		$("#frm").ajaxSubmit({
				url: path+"/soa/workexperience!ajaxSaveOrUpdate.action?menuId="+menuId+"&ram="+ ram,
				dataType:"json",
				success: function(data, status)
				{   
					var flag=data.flag;
			        if(flag=="1"){
				        if(param==1){
				        	alert("工作简历保存成功!");
				        	location.href=path+'/soa/workexperience.action?menuId='+menuId;
				        }else{
				        	location.href = path+'/soa/kjcg!queryByPerId.action?menuId='+menuId; 
				        }
			        }else if(flag=="2"){
			        	alert("工作简历保存失败!");
			        }
			        
				},
				error:function()
				{
					alert("工作简历保存失败!");
				}
			});
	}	
		
 } 		 
			
	//全选或全不选
		$(function () {
			 	$("#seletAllOrNot").bind("click", function () {
	                $("[name = sel]:checkbox").attr("checked", this.checked);
	            });
		 });
		     
	//删除单条数据
	function delByWorkId(param){
		  $("#workId").attr("value",param);
		  $("#frm").attr("action",path+'/soa/workexperience!delete.action?menuId='+menuId);
		  $("#frm").submit();
    }
		     
	//删除已选的记录
		
		function deleteBySelect(){
			var workIds="";
			var allLines=$(":checkbox:checked").size();
			var selectedLines=$("[name = sel]:checkbox:checked").size();
			var confirmDelete=false;
			var step=0;
			var ram=Math.random();
			if(selectedLines<=0){
				if(allLines==(selectedLines+1)){
					alert("没有可用的数据!");
				}else{
					alert("请选择记录!");
				}
			}else{
				//组合要删除的ID
				$("[name = sel]:checkbox").each(function(){
					var workId=$(this).val();
					if($(this).attr("checked")){
						if(workId!=null&&workId!=""){
							workIds+=$(this).val()+",";
						}
					}
					if(step==0){
						confirmDelete=confirm("您确定要删除选择的记录吗？");
					}
					step++;
				});
				if(confirmDelete){
					$("[name = sel]:checkbox").each(function(){
						if($(this).attr("checked")){
							var workId=$(this).val();
							if(confirmDelete){
								$(this).closest("tr").remove();
							}
						}
					});
				}
				
				//再删除已经存在的
				if(workIds!=""&&confirmDelete){
					$("#frm").ajaxSubmit({
						url: path+'/soa/workexperience!ajaxDeleteBySelect.action?menuId='+menuId+'&ram='+ ram+"&form.selected="+workIds,
						dataType:"json",
						success: function(data, status)
						{   
							var flag=data.flag;
					        if(flag=="1"){
					        	alert("工作简历删除成功!");
					        	location.href=path+'/soa/workexperience.action?menuId='+menuId;
					        }else if(flag=="2"){
					        	alert("工作简历删除失败!");
					        }
						},
						error:function()
						{
							alert("工作简历删除失败!");
						}
					});
					//location.href=path+'/soa/workexperience!deleteBySelect.action?menuId='+menuId+'&ram='+ ram+"&form.selected="+workIds;
				}
			}
		}
	
		String.prototype.trim=function(){
		　　 return this.replace(/(^\s*)|(\s*$)/g, "");
		}
		String.prototype.ltrim=function(){
		　　 return this.replace(/(^\s*)/g,"");
		}
		String.prototype.rtrim=function(){
		　　 return this.replace(/(\s*$)/g,"");
		}
		
		
		
		function preview(uuid,pname,idCard,auditstate){
			var pnameEnCode=encodeURI(pname.trim().ltrim().rtrim());
			location.href=path+'/soa/previewAction.action?menuId='+menuId+'&form.uuid='+uuid+'&form.personDetail.pname='+pnameEnCode+'&form.personDetail.idCard='+idCard+'&form.personDetail.auditstate='+auditstate;
		}
			
	//删除新行
	function  delLine(){ 
		$("table tbody tr:last-child").remove();
	}