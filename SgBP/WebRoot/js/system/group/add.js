		function check(){
		var remark = document.getElementById("group_remark").value;
			var isPass = true; 
			//名称
			if(!(checkData.isEmptySpan("group_name")&&checkData.filterStrSpan('group_name',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('group_name',25)))   
        		  isPass = false;
			
			else if(remark.length>0&&!(checkData.isMoreSpan('group_remark',500)))
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
 			    if($('#selectGroupRight').attr('src')!=""){
				   $("#menuIds").val(window.frames["selectGroupRight"].mySelect());
				}
			   if($('#selectGroupManager').attr('src')!=""){ //返回的managerIds是以=号连接的字符串，等号前面的表示组成员，等号后面的表示组管理员
			    $("#manegerIds").val(window.frames["selectGroupManager"].sOk());
			    }
				$.blockUI({ message: "<div class='showMsg'>数据发送中,请稍后...</div> "});
				$("#frm").ajaxSubmit(
				{
					url: path+"/system/group!add.action?datestr="+new Date().getTime(),
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
