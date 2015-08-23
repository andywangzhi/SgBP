	
String.prototype.len=function()          
		{                 
		return     this.replace(/[^\x00-\xff]/g,"rr").length;          
		} 
	// 保存数据
		function save(type) {
			var frm = document.getElementById("frm");
			var trList=$("tbody").children("tr").size();
			var ram=Math.random();
			var flag=true;
			for(var i=0;i<trList;i++){
				var technicallyType=document.getElementById("form.dtoList["+i+"].technicallyType");
				if(null==technicallyType){
					trList++;
				}else{
					 var value=technicallyType.value;
					if(null==value||value==""){
							alert("请填写职称技能专业名称!");
							flag=false;
							break;
					}else if(value.len()>100){
						alert("职称技能专业名称长度过长!");
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
					url: path+'/soa/tech!ajaxSaveOrUpdate.action?menuId='+menuId+'&ram='+ ram,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
				        if(flag=="1"){
				        	if(type==1){
					        	alert("职称技能保存成功!");
					        	location.href = path+'/soa/tech!query.action?menuId='+menuId;
				        	}else{
				        		location.href = path+'/soa/jyjl.action?menuId='+menuId; 
				        	}
				        	
				        }else if(flag=="2"){
				        	alert("职称技能保存失败!");
				        }
					},
					error:function()
					{
						alert("职称技能保存失败!");
					}
				});
			}
			
		}
	
	function deleteBySelect(){
			var techIds="";
			var selectedLines=$("[name = deleteTechId]:checkbox:checked").size();
			var confirmDelete=false;
			var step=0;
			var ram=Math.random();
			if(selectedLines<=0){
				alert("请选择记录!");
			}else{
				//组合要删除的ID
				$("[name = deleteTechId]:checkbox").each(function(){
					var techId=$(this).val();
					if($(this).attr("checked")){
						if(techId!=null&&techId!=""){
							techIds+=$(this).val()+",";
						}
					}
					if(step==0){
						confirmDelete=confirm("您确定要删除选择的记录吗？");
					}
					step++;
				});
				if(confirmDelete){
					$("[name = deleteTechId]:checkbox").each(function(){
						if($(this).attr("checked")){
							var techId=$(this).val();
							if(confirmDelete){
								$(this).closest("tr").remove();
							}
						}
					});
				}
				//再删除已经存在的
				if(techIds!=""&&confirmDelete){			
					$("#frm").ajaxSubmit({
					url: path+'/soa/tech!ajaxDeleteBySelect.action?menuId='+menuId+'&ram='+ ram+"&form.selected="+techIds,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
				        if(flag=="1"){
				          alert("职称技能删除成功!");
					      location.href = path+'/soa/tech!query.action?menuId='+menuId;
				        }else if(flag=="2"){
				        	alert("职称技能删除失败!");
				        	location.href = path+'/soa/tech!query.action?menuId='+menuId;
				        }
					},
					error:function()
					{
						alert("职称技能删除成功!");
					}
				});
				}
			}
		}
		
		// 刷新
		function refresh(){
		   location.href = path+'/soa/tech!query.action?menuId='+menuId; 
		}
		
		function preview(param,p1,p2,p3){
			var pnameEnCode=encodeURI(p1);
			location.href=path+'/soa/previewAction.action?menuId='+menuId+'&form.uuid='+param+'&form.personDetail.pname='+pnameEnCode+'&form.personDetail.idCard='+p2+'&form.personDetail.auditstate='+p3;
		}
