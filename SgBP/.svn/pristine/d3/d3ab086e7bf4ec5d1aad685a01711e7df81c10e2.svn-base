   function queryRecord(){
       var now = new Date();

	   var  chiNam = $.trim($('#chiNam').val()); 
	   var  agTNam = $.trim($('#agTNam').val());
	   var  idcardNum = $.trim($('#idcardNum').val());
	   var  beginBirthday  = $.trim($('#beginBirthday').val());
	   var  endBirthday = $.trim($('#endBirthday').val());
	   var  address =$.trim($('#address').val()); 
	   var  phoneS = $.trim($('#phoneS').val()); 
	   var  phoneM = $.trim($('#phoneM').val());
	     if( chiNam == "" && agTNam == "" && idcardNum=="" && beginBirthday=="" && endBirthday=="" && address=="" && phoneS=="" && phoneM==""){
	        $.ajax({
               url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=error_searchmember_noinput&time="+now,
               success:function(obj){ alert(obj); }
            });
            return false;
	     }
	     if (idcardNum!="" && idcardNum.length<4){
	        $.ajax({
               url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=idcardNum_warn&time="+now,
               success:function(obj){ alert(obj); }
            });
            return false;
	     }
	     if (address!="" && address.length<2){
	        $.ajax({
               url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=address_warn&time="+now,
               success:function(obj){ alert(obj); }
            });
            return false;
	     }     
	     if (phoneS!="" && phoneS.length<4){
	        $.ajax({
               url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=phoneS_warn&time="+now,
               success:function(obj){ alert(obj); }
            });
            return false;
	     } 
	     if(beginBirthday!=""){
	        if(endBirthday==""){
	           $.ajax({
	              url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=error_searchmember_endbirthday&time="+now,
	              success:function(obj){alert(obj);}
	           });
	           return false;
	        }
	     }   
	     if( endBirthday < beginBirthday ){
	     	$.ajax({
               url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=etime_noless_btime&time="+now,
               success:function(obj){ alert(obj); }
            });
            return false;
	     }
	     if (agTNam!="" && agTNam.length<2){
	     	$.ajax({
               url:path+"/soa/member/searchMember!getResourceForPage.action?resKey=agTNam_warn&time="+now,
               success:function(obj){ alert(obj); }
            });
            return false;
	     }        
	  $("#frm").submit();
	}