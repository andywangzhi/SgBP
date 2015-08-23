$(function(){
		function selectAll(this_obj) {
				if ($(this_obj).attr("checked") == true) { // 全选  
					$("input[name='selectIds']").each(function() { 
					   $(this).attr("checked", true);   
					});   
				} else { // 取消全选   
					$("input[name='selectIds']").each(function() {   
					   $(this).attr("checked", false);      
					});   
				}
		}
})
