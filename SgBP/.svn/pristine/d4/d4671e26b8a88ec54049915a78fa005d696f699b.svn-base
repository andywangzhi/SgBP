		function check(){
			var isPass = true; 
			var remark = document.getElementById("conf_remark").value;
			if(!(checkData.isEmptySpan("conf_name")&&checkData.filterStrSpan('conf_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('conf_name',256)))   
				  isPass = false;
			else if(!(checkData.isEmptySpan('conf_typeId')))   
				  isPass = false;
			else if(!(checkData.isEmptySpan("conf_priority")&&checkData.isNumSpan('conf_priority')))
				  isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('conf_remark',250)))   
				  isPass = false;
			return isPass;	  
		}
		
		function onfocusCheck(id){
			 
			checkData.onfocusof(id);
		}
		function saveData(){
				if(check()){
					$.blockUI({ message: "<div class='showMsg'>数据发送中,请稍后...</div> "});
					$("#frm").ajaxSubmit(
					{
						url: path+"/system/conf!edit.action?dateStr="+(new Date()),
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
				}else{
					return false;
				}
		}
		

		