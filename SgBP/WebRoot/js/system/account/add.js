			function check(){
			var isPass = true;
			var remark = document.getElementById("account_remark").value;
			var account_password = document.getElementById("account_password").value;
			var passConfirm = document.getElementById("passConfirm").value;
			var checkVal=document.getElementById("account.usertype").value;
			if(!(checkData.isEmptySpan("account_loginCode")&&checkData.filterStrSpan('account_loginCode',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('account_loginCode',30)))
				isPass = false;
     		else if(!(checkData.isEmptySpan("account_password")&&checkData.filterStrSpan('account_password',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('account_password',30)))
				isPass = false;
			else if(!(checkData.isEmptySpan("account_nameCN")&&checkData.filterStrSpan('account_nameCN',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('account_nameCN',30)))
				isPass = false;
			else if(!(checkData.isEmptySpan("account_nameEN")&&checkData.filterStrSpan('account_nameEN',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('account_nameEN',30)))
				isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('account_remark',500)))
    		 	isPass = false;	
			else if(account_password!=passConfirm){
				alert("两次输入的密码不一致，请重新输入!");
				isPass = false;	
			}else if(checkVal==3){
				var temp=$("#retrieveSOpcounty").val();			
				 if(temp == ""){
					 isPass = false;	
				 	alert("请选择县!");
				 }
			}
			return isPass;
		}
		function checkSel(){
    		var checkVal=document.getElementById("account.usertype").value;
    		if(checkVal==3){
    			document.getElementById("g1").style.display="block";
    		}else{
    			document.getElementById("g1").style.display="none";
    		}
    	}
		function onfocusCheck(id){
			checkData.onfocusof(id);
		}
		function saveData(){
            if(check()){
	            $.blockUI({ message: "<div class='showMsg'>数据发送中,请稍后...</div> "});
				$("#frm").ajaxSubmit(
				{
					url: path+"/system/account!add.action?dateStr="+(new Date()),
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
		
		function checkCode(){
		  var accountCode = $.trim($('#account_loginCode').val()); 
		  if(accountCode.length == 0) return;
		  $.ajax({
		     url:path+"/system/account!checkCode.action?accountCode="+accountCode+"&dateStr="+(new Date().getTime()),
		     dataType:"json",
		     success:function(data){
			    if(data == true)
			    { 
			        alert("帐号已存在!");
			        $('#account_loginCode').focus();
			    }
		      }
		   });
		}
			