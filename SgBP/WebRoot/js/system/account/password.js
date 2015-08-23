
		function saveData(){
			var newpassword = document.getElementById("newpassword").value;
			var passconfirm = document.getElementById("passconfirm").value;
			if(newpassword!=passconfirm){
				alert("两次输入的密码不一致，请重新输入!");
				return false;
			}else{
				$("#frm").ajaxSubmit(
				{
					url: path+"/system/account!editPassword.action",
					iframe: true,
					success: function(data, status)
					{   
				        $("#msg").html("&nbsp;&nbsp;&nbsp;<span style='color:red'>修改成功,请劳记密码!</span>");
					},
					error:function()
					{
						alert("保存失败，请重试!");
					}
				});
            }
		}