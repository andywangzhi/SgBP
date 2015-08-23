$(document).ready(function(){
     var now = new Date();
     
   
    $("input[type=text]:first").click(function(){
       $(this).val("");
    });
    
   
    
    
    $("#adanumber").attr("maxlength","11")
    $("#adanumber").bind('keyup',function(){
          $(this).val($(this).val().replace(/\D/g,''));
    });
    $("#adanumber").blur(function () { 
		var check1 = $(this).val(); 
		if (check1 == '') { 
		    $.ajax({
               url:path+"/soa/achievement/achievement!getAdaForPage.action?resKey=inputadanumber&time="+now,
               success:function(obj){ $("#adanumber").val(obj); }
           });
		}
	});  
    
    $("input[type=text]:first").focus();
    
    
    $("input").bind('keydown',function(){
        if(window.event.keyCode==13){
	      queryRecord();
        } 
    });
    
})

function hideTable(obj){
   var trs = $("tr[name=flag]").siblings();

   if(trs.is(":visible")){   
      $(obj).attr("src",path+"/images/2.gif");
   }else{
      $(obj).attr("src",path+"/images/1.gif");
   }
   trs.toggle();
}

function pageSubmit(flag){
  	$("#currentIndex").val(flag);
    $("#form").submit();
} 

function checkIsNumber(fval) { 
   if(isNaN(fval)){        
      return false; 
   }else{
      return true;   
   }
}





