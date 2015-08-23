function checkCode(){
	var code=document.getElementById("confType_code").value;
	  $.ajax({
	     url:path+"/system/confType!codeExist.action?dateStr="+(new Date())+"&code="+code,
	     dataType:"json",
	     success:function(data){
	        if(data==true){
	        	alert ("对不起,该编码已经存在！");
	        	document.getElementById("confType_code").focus();
	        }
	      }
	   });
}
function check(){
	var isPass = true; 
	var remark = document.getElementById("confType_remark").value;
	if(!(checkData.isEmptySpan("confType_code")&&checkData.filterStrSpan('confType_code',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('confType_code',20)))
		isPass = false;
	else if(!(checkData.isEmptySpan("confType_name")&&checkData.filterStrSpan('confType_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('confType_name',256)))   
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
					url: path+"/system/confType!add.action?dateStr="+(new Date()),
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
		