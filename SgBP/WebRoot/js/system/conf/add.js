function checkCode(){
	var code=document.getElementById("conf_code").value;
	  $.ajax({
	     url:path+"/system/conf!codeExist.action?dateStr="+(new Date())+"&code="+code,
	     dataType:"json",
	     success:function(data){
	        if(data==true){
	        	alert ("对不起,该编码已经存在！");
	        	document.getElementById("conf_code").focus();
	        }
	      }
	   });
}
function check(){
	var isPass = true; 
	var remark = document.getElementById("conf_remark").value;
	if(!(checkData.isEmptySpan("conf_code")&&checkData.filterStrSpan('conf_code',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('conf_code',20)))
		isPass = false;
	else if(!(checkData.isEmptySpan("conf_name")&&checkData.filterStrSpan('conf_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('conf_name',256)))   
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
					url: path+"/system/conf!add.action?dateStr="+(new Date()),
					iframe: true,
					success: function(data, status)
					{    
				        $(".showMsg").html(data);
					    window.opener.location.href = window.opener.location.href; 
					    window.close();
					},
					error:function()
					{
						$(".showMsg").html(data);
	
					}
				});
			}else {
				return false;
			}
			
		}
		