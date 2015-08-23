		function check(){
			var isPass = true; 
			var remark = document.getElementById("confType_remark").value;
			if(!(checkData.isEmptySpan("confType_name")&&checkData.filterStrSpan('confType_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('confType_name',256)))   
				  isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('confType_remark',250)))   
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
						url: path+"/system/confType!edit.action?dateStr="+(new Date()),
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
		

		