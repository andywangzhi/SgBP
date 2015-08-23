$(function(){
			$('#mytab').tabs({
			});
			loadGroup();
		});
		
		function loadGroup(){
		  $.ajax({
		     url:path+"/system/group!findUserGroup.action?dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
		        loadGroupResult(data); 
		      }
		   });
		}
		
		function loadGroupResult(data){
		  for(i=0;i<data.length;i++){
		    if(groupId==data[i].id){
		       $("#role_groupId").append('<option value="'+data[i].id+'" selected>'+data[i].name+'</option>');   
		    }else{
		       $("#role_groupId").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   
		    }
		  }
		}