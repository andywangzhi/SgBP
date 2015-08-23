$(function(){ 

	$("input:first").click(function () { 
		var check1 = $(this).val(); 
		if (check1 == '<s:property value="#application._WEB_SYS_RESOURCE_KEY_.inputadanumber[session._CUR_USER_LANG_]"  escape="false"/>') { 
		 $(this).val(""); 
		} 
	}); 
	$("input:first").blur(function () {
	    var check1 = $(this).val();  
		if (check1 == '<s:property value="#application._WEB_SYS_RESOURCE_KEY_.inputadanumber[session._CUR_USER_LANG_]"  escape="false"/>') { 
		   $(this).val('<s:property value="#application._WEB_SYS_RESOURCE_KEY_.inputadanumber[session._CUR_USER_LANG_]"  escape="false"/>'); 
		 } 
	});   
}) 

function queryRecord(){
   var now = new Date();
   
   var selectId = $("input[name=radiobutton][checked=true]").attr("id");  //获得被选定的raido ID
  
   if(selectId == "sell"  || document.frm.sell.checked ){
     var url = path+"/soa/income/monthlyIncome!queryList.action?menuId="+menuId;
     $("#frm").attr('action',url);
     
     $("#queryType").val("1");
   }else {
    
     $("#queryType").val("2");
   }

    if($("#adanumber").val() == "" ){
      
      $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=inputadanumber&time="+now,
         success:function(obj){ alert(obj); }
      });
      return false;
    }
    
    if($("#adanumber").val().length>11 ){
       $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=ada_length_warn&time="+now,
         success:function(obj){ alert(obj); }
      });
      return false;
    }
    
    /*
    if(isNaN($("#adanumber").val())){
      $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=adanumber_warn&time="+now,
         success:function(obj){ alert(obj); }
      });
      return false;
    }
   */ 
   
    if( $("#beginMonth").val()!="" && $("#endMonth").val()=="" ){
      $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=inputEndMonth&time="+now,
         success:function(obj){ alert(obj); }
      });
      return false;
    }
    
    if( $("#beginMonth").val()=="" && $("#endMonth").val()!="" ){
      $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=inputBeginMonth&time="+now,
         success:function(obj){ alert(obj); }
      });
      return false;
    }
    
    if( $("#beginMonth").val() > $("#endMonth").val() ){
      $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=month_warn&time="+now,
         success:function(obj){ alert(obj); }
      });
      return false;
    }
    
    $("#frm").submit();
}
function clearData(){
	$('#frm').form('clear');
}

