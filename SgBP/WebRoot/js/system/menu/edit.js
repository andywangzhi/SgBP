		function check(){
			var isPass = true;
			
			var remark = document.getElementById("menu_remark").value;
			
			 if(!(checkData.isEmptySpan("menu_nameZh")&&checkData.filterStrSpan('menu_nameZh',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('menu_nameZh',30)))
				isPass = false;
			else if(!(checkData.isEmptySpan("menu_nameTw")&&checkData.filterStrSpan('menu_nameTw',"'~!@#$%^&*()-+.\"")&&checkData.isMoreSpan('menu_nameTw',30)))
				isPass = false;
			else if(!(checkData.isEmptySpan("menu_nameEn")&&checkData.filterStrSpan('menu_nameEn',"'~!@#$%^&*()-+.\"")&&checkData.isLicitSpan('menu_nameEn')&&checkData.isMoreSpan('menu_nameEn',30)))
				isPass = false;	
			else if(!(checkData.isEmptySpan("menu_url")&&checkData.isMoreSpan('menu_url',256)))
				isPass = false;
			else if(!(checkData.isEmptySpan("menu_priority")&&checkData.isNumSpan('menu_priority')))
				isPass = false;
			else if(remark.length>0&&!(checkData.isMoreSpan('menu_remark',500)))
    		 	isPass = false;	
    		 	
				return isPass;
		}
	
	
		function onfocusCheck(id){
			 
			checkData.onfocusof(id);
		}
		
		function saveData(){

		    $("#dicIds").val('');
            if(check()){
	            $.blockUI({ message: "<div class='showMsg'>数据发送中,请稍后...</div> "});
				$("#frm").ajaxSubmit(
				{
					url: path+"/system/menu!edit.action?dateStr="+(new Date()),
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

		
		function selectAll(this_obj) {
				if ($(this_obj).attr("checked") == true) { // 全选  
					$("input[name='selectDicIds']").each(function() { 
					   $(this).attr("checked", true);   
					});   
				} else { // 取消全选   
					$("input[name='selectDicIds']").each(function() {   
					   $(this).attr("checked", false);      
					});   
				}
		}