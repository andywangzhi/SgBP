function check(){
		    var isPass = true;
			var remark = document.getElementById("sysResource_remark").value;
			 if(!(checkData.isEmptySpan("sysResource_key"))){
			    //alert("编码不能为空！");
				isPass = false;
		    }
		    else if(!checkData.filterStrSpan('sysResource_key',"'~!@#$%^&*()-+.\"")){
		      // alert("编码不能含有特殊字符！");
		        isPass = false;
		    }else if(!checkData.isMoreSpan('sysResource_key',500)){
		       //alert("编码长度不能超过500字符!");
		       isPass = false;
		    }
		    else if(!(checkData.isEmptySpan("sysResource_nameZh"))) {
			     // alert("中文名称不能为空！");
        		  isPass = false;
             }
             else if(!(checkData.isEmptySpan("sysResource_nameEn"))) {
			     // alert("英文文名称不能为空！");
        		  isPass = false;
             }
             else if(!(checkData.isEmptySpan("sysResource_nameTw"))) {
			      //alert("繁体文名称不能为空！");
        		  isPass = false;
             }
             else if(remark.length>0&&!(checkData.isMoreSpan('sysResource_remark',1024))) {
			  //alert("备注长度不能超过1024字符！");
			  isPass = false;
			}  
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
						url: path+"/system/resource!edit.action?dateStr="+(new Date()),
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
		
