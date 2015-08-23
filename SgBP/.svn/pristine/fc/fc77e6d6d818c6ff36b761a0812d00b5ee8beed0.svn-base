		function check(){
			var isPass = true; 
			var remark = document.getElementById("dictionary_remark").value;
			if(!(checkData.isEmptySpan("dictionary_name")&&checkData.filterStrSpan('dictionary_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('dictionary_name',25)))   
        		  isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('dictionary_remark',250)))   
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
						url: path+"/system/dictionary!edit.action?dateStr="+(new Date()),
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
		

		