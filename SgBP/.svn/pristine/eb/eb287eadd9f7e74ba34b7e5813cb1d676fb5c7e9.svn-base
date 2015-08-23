
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
	
	
	$("input[type=text]").click(function(){
	   $(this).parent().parent().find('input[type=radio]').attr('checked',true);
	   if($(this).attr('id')=='orderNumber'){
	    $('#order').attr('checked',true);
	   }
	});
	

	if($('#queryType').val() == ""){
	   //$("#achievement").attr('checked',true);
	   $("#purchaser").attr('checked',true);
	}else if( $('#queryType').val() == "1" ){
	   $("#achievement").attr('checked',true);
	}else if( $('#queryType').val() == "2" ){
	   $("#purchaser").attr('checked',true);
	}else if( $('#queryType').val() == "3" ){
	   $("#order").attr('checked',true);
	}
	//else if( $('#queryType').val() == "4" ){
	//   $("#bill").attr('checked',true);
	//}
	
	$.each($("#frm tr"),function(i,obj){
	
	 $(this).find('input[type=text]').eq(0).click(function(){  //每行的第一个input 点击将会清空数据
	      $.each($("#frm input[type=text]"), function(i, obj){
	         $(this).val("");
	         
	         //凡是日期的input赋给默认值
	         if( $("#achievement").attr('checked')==true && $(this).attr('id')=='achievementBeginMonth'){
	            $(this).val(begin);
	         }
	         
	         if($("#achievement").attr('checked')==true && $(this).attr('id')=='achievementEndMonth'){
	            $(this).val(end);
	         }
	         
	         if($("#purchaser").attr('checked')==true && $(this).attr('id')=='purchaserBeginMonth'){
	            $(this).val(begin);
	         }
	         
	         if($("#purchaser").attr('checked')==true  && $(this).attr('id')=='purchaserEndMonth'){
	            $(this).val(end);
	         }
	         
	     });
	  });
	});
	
	
	
	
	$("input[type=radio]").bind('click',function(){   //绑定点击事件，当radio切换时，清空查询条件
	    $.each($("#frm input[type=text]"), function(i, obj){
	         $(this).val("");
	         
	         //凡是日期的input赋给默认值
	         if( $("#achievement").attr('checked')==true && $(this).attr('id')=='achievementBeginMonth'){
	            $(this).val(begin);
	         }
	         
	         if($("#achievement").attr('checked')==true && $(this).attr('id')=='achievementEndMonth'){
	            $(this).val(end);
	         }
	         
	         if($("#purchaser").attr('checked')==true && $(this).attr('id')=='purchaserBeginMonth'){
	            $(this).val(begin);
	         }
	         
	         if($("#purchaser").attr('checked')==true  && $(this).attr('id')=='purchaserEndMonth'){
	            $(this).val(end);
	         }
	         
	     });
	});
	
})  

//检测是否数字
function checkIsNumber(fval) { 
	if(isNaN(fval)){        
	 return false;   //不是数字
	}else{
	  return true;   
	}  
}

//检测是否数字
function checkIsNumber2(fval) { 
  var reg1 =  /^\d+$/;
  if(fval.match(reg1) == null)return false;
  return true;   
}

function queryRecord(){
   var now = new Date();
   
   var selectId = $("input[name=radiobutton][checked=true]").attr("id");  //获得被选定的raido ID
   
   var  purchaserNumber = $('#purchaserNumber').val();
   var  purchaserStoreNumber = $('#purchaserStoreNumber').val();
   var  purchaser_begin = $('#purchaserBeginMonth').val();
   var  purchaser_end  = $('#purchaserEndMonth').val();
  
   var  achievementNumber = $('#achievementNumber').val();
   var  achievementStoreNumber =$('#achievementStoreNumber').val();
   var  achievement_begin = $('#achievementBeginMonth').val();
   var  achievement_end  = $('#achievementEndMonth').val();
   
   var  orderNumber = $('#orderNumber').val();
   var  billNumber = $('#billNumber').val();
   
   
  if(selectId == "achievement"){   //按 "获业绩人员号码" 查询
     
     $('#queryType').val("1");
      
     if( $.trim(achievementNumber) == "" ){
        $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=input_achievement_number&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
     }
     
    if(!checkIsNumber(achievementNumber)){  
        $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=achievement_number_warn&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
    }
    
    if(achievementNumber.length>11){  
        $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=ada_length_warn&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
    }
   
   
    if( achievement_end =="" && achievement_begin != "" ){
       $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=input_achievement_end&time="+now,
         success:function(obj){ alert(obj); }
        });
       return false;
    }
     
    if( achievement_end !="" && achievement_begin == "" ){
       $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=input_achievement_begin&time="+now,
         success:function(obj){ alert(obj); }
       });
      return false;
    }
     
    if( achievement_end < achievement_begin ){
        $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=month_warn&time="+now,
         success:function(obj){alert(obj);}
        });
       return false;
    }
   }
   
   if(selectId == "purchaser"){  //按 "购货人员编号" 查询
    $('#queryType').val("2");
    
    if( $.trim(purchaserNumber) == "" ){
       
       $.ajax({ 
         url:path+"/soa/order/order!getResourceForPage.action?resKey=input_purchaser_number&time="+now,
         success:function(obj){alert(obj);}
       });
       return false;
     }
     
     if(!checkIsNumber(purchaserNumber)){  
       
       $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=purchaser_warn_number&time="+now,
         success:function(obj){ alert(obj); }
        });
       return false;
     }
     
    if(purchaserNumber.length>11){  
        $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=ada_length_warn&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
    }
     
    if( purchaser_end =="" && purchaser_begin != "" ){
      $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=input_purchaser_end&time="+now,
         success:function(obj){ alert(obj); }
        });
        
      return false;
    }
     
   if( purchaser_end !="" && purchaser_begin == "" ){
     
      $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=input_purchaser_begin&time="+now,
          success:function(obj){ alert(obj); }
      });
        
      return false;
    }
     
   if( purchaser_end < purchaser_begin ){
      $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=month_warn&time="+now,
          success:function(obj){ alert(obj); }
      });
      
      return false;
   }
   
  }
   
 
   
   
   if(selectId == "order"){   //按 "订单编号" 查询
   
     $('#queryType').val("3");
     
     if( $.trim(orderNumber) == "" ){
     
       $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=input_bill_number&time="+now,
          success:function(obj){ alert(obj); }
       });
       
       return false;
     }
     
     if(!checkIsNumber2(orderNumber)){  
        $.ajax({
         url:path+"/soa/order/order!getResourceForPage.action?resKey=order_warn_number&time="+now,
         success:function(obj){ alert(obj); }
        });
        return false;
    }
   }
   
   if(selectId == "bill"){   //按 "单据号" 查询
   
     $('#queryType').val("4");
     
     if( $.trim(billNumber) == "" ){
        $.ajax({
           url:path+"/soa/order/order!getResourceForPage.action?resKey=input_bill&time="+now,
           success:function(obj){ alert(obj); }
        });
       return false;
     }
     
    if(!checkIsNumber2(billNumber)){  
       $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=bill_number_warn&time="+now,
          success:function(obj){ alert(obj); }
        });
      return false;
    }
   }
  
  $("#frm").submit();
}
 
function clearData(){
   $('#frm').form('clear');
}



