		function check(){
			var isPass = true; 
			var remark = document.getElementById("dept_remark").value;
			if(!(checkData.isEmptySpan("dept_nameCN")&&checkData.filterStrSpan('dept_nameCN',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('dept_nameCN',256)))   
				  isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('dept_remark',250)))   
				  isPass = false;
			return isPass;	  
		}
		
		function onfocusCheck(id){
			 
			checkData.onfocusof(id);
		}
		
		$(function(){
			$('#mytab').tabs({});
		});	
		
		function saveData(){
				if(check()){
					 $("#accountIds").val(window.frames["selectDeptAccount"].sOk());
					
					$.blockUI({ message: "<div class='showMsg'>数据发送中,请稍后...</div> "});
					$("#frm").ajaxSubmit(
					{
						url: path+"/system/dept!edit.action?dateStr="+(new Date()),
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
		

		