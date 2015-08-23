function check(){
			var isPass = true; 
			var remark = document.getElementById("role_remark").value;
			
			if(!(checkData.isEmptySpan("role_name")&&checkData.filterStrSpan('role_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('role_name',25)))   
        		  isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('role_remark',250)))   
        		  isPass = false;
			return isPass;
		}
		
		function onfocusCheck(id){
			checkData.onfocusof(id);
		}
		$(function(){
			$('#mytab').tabs({
			});
			loadGroup();
		});
		
		function loadGroup(){
		  $.ajax({
		     url:path+"/system/group!findUserGroup.action?dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
		        loadGroupResult(data); 
		      }
		   });
		}
		
		function loadGroupResult(data){
		  for(i=0;i<data.length;i++){
		    if(groupId==data[i].id){
		       $("#role_groupId").append('<option value="'+data[i].id+'" selected>'+data[i].name+'</option>');   
		    }else{
		       $("#role_groupId").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   
		    }
		  }
		}
		
		function saveData(){
			if(check()){
				$("#menuIds").val(window.frames["selectRoleRight"].mySelect());
			    $("#userIds").val(window.frames["selectUser"].sOk());
				$.blockUI({ message: "<div class='showMsg'>数据发送中,请稍后...</div> "});
				$("#frm").ajaxSubmit(
				{
					url: path+"/system/role!edit.action?dateStr="+(new Date()),
					iframe: true,
					success: function(data, status)
					{   
				        $(".showMsg").html(data);
					    window.opener.location.href = window.opener.location.href; 
					    window.close();
					},
					error:function()
					{
						$(".showMsg").html("保存失败，请重试");
					}
				});
			}else {
				return false;
			}
		}
		
