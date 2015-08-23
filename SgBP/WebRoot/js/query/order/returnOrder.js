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
	   
	   if($(this).attr('id')=='returnBillNumber'){
	    $('#returnBill').attr('checked',true);
	   }
	});
	
	
	
	$.each($("#frm tr"),function(i,obj){
	 $(this).find('input[type=text]').eq(0).click(function(){  //每行的第一个input 点击将会清空数据
	      $.each($("#frm input[type=text]"), function(i, obj){
	         $(this).val("");
	         //凡是日期的input赋给默认值
	         if($("#purchaser").attr('checked')==true && $(this).attr('id')=='purchaserBeginMonth'){
	            $(this).val(begin);
	         }
	         if($("#purchaser").attr('checked')==true  && $(this).attr('id')=='purchaserEndMonth'){
	            $(this).val(end);
	         }
	     });
	  });
	});
	
	if($('#queryType').val() == ""){
	   $("#purchaser").attr('checked',true);
	}else if( $('#queryType').val() == "1" ){
	   $("#purchaser").attr('checked',true);
	}else if( $('#queryType').val() == "2" ){
	   $("#returnBill").attr('checked',true);
	}
	//else if( $('#queryType').val() == "3" ){
	//   $("#return").attr('checked',true);
	//}
	
	$("input[type=radio]").bind('click',function(){   //绑定点击事件，当radio切换时，清空查询条件
	    $.each($("#frm input[type=text]"), function(i, obj){
	         $(this).val("");
	         
	         /*
	         //凡是日期的input赋给默认值
	         if( $("#purchaser").attr('checked')==true && $(this).attr('id')=='purchaserBeginMonth'){
	            $(this).val(begin);
	         }
	         
	         if($("#purchaser").attr('checked')==true && $(this).attr('id')=='purchaserEndMonth'){
	            $(this).val(end);
	         }
	         */
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
   
   /*
   var  purchaser_begin = $('#purchaserBeginMonth').val();
   var  purchaser_end  = $('#purchaserEndMonth').val();
   */
   var  returnBillNumber = $('#returnBillNumber').val();
   
   var  returnNumber = $('#returnNumber').val();
   
   if(selectId == "purchaser"){  //按 "退货人员号码" 查询
     
    $('#queryType').val("1");
     
    if( $.trim(purchaserNumber) == "" ){
        $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=input_retruner_number&time="+now,
          success:function(obj){ alert(obj); }
        });
        return false;
     }
     
     if(!checkIsNumber(purchaserNumber)){  
        $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=returner_number_warn&time="+now,
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
      
      /*
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
     
      */
   }
   
 
   
   if(selectId == "returnBill"){   //按 "退货单据号" 查询
     $('#queryType').val("2");
     
     if( $.trim(returnBillNumber) == "" ){
        
        $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=input_return_number&time="+now,
          success:function(obj){ alert(obj); }
        });
        return false;
     }
     
      if(!checkIsNumber2(returnBillNumber)){
        $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=return_number_warn&time="+now,
          success:function(obj){ alert(obj); }
        });
        return false;
     }
   
    
   }
   
   if(selectId == "return"){   //按 "退货号" 查询
   
     $('#queryType').val("3");
     
     if( $.trim(returnNumber) == "" ){
        $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=input_returnNO&time="+now,
          success:function(obj){ alert(obj); }
        });
        return false;
     }
     
     if(!checkIsNumber2(returnNumber)){
        $.ajax({
          url:path+"/soa/order/order!getResourceForPage.action?resKey=returnNo_number_warn&time="+now,
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