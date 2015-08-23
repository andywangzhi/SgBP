function queryRecord(){
   var now = new Date();
   
   var  adanumber = $.trim($('#adanumber').val());  
   var  beginMonth = $('#beginMonth').val();
   var  endMonth = $('#endMonth').val();
    if (adanumber==""){
	    $.ajax({
         url:path+"/soa/achievement/achievement!getResourceForPage.action?resKey=inputadanumber&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
    }  
    if (beginMonth=="" || endMonth==""){
	    $.ajax({
         url:path+"/soa/achievement/achievement!getResourceForPage.action?resKey=error_achievement_month_input&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
    } 
   	if(endMonth < beginMonth ){
   	    $("#queryBn").attr("disabled","disabled");
	    $.ajax({
         url:path+"/soa/achievement/achievement!getResourceForPage.action?resKey=error_achievement_month_equal&time="+now,
         success:function(obj){alert(obj); $("#queryBn").attr("disabled","");}
        });
        return false;
    }
  $("#frm").submit();
}