function checkCode(){
	var code=document.getElementById("dept_code").value;
	  $.ajax({
	     url:path+"/system/dept!codeExist.action?dateStr="+(new Date())+"&code="+code,
	     dataType:"json",
	     success:function(data){
	        if(data==true){
	        	alert ("对不起,该编码已经存在！");
	        	document.getElementById("dept_code").focus();
	        }
	      }
	   });
}
function check(){
	var isPass = true; 
	var remark = document.getElementById("dept_remark").value;
	if(!(checkData.isEmptySpan("dept_code")&&checkData.filterStrSpan('dept_code',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('dept_code',20)))
		isPass = false;
	else if(!(checkData.isEmptySpan("dept_nameCN")&&checkData.filterStrSpan('dept_nameCN',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('dept_nameCN',256)))   
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
					url: path+"/system/dept!add.action?dateStr="+(new Date()),
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
		