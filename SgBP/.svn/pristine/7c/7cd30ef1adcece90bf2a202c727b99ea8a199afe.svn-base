$(function(){

  $("#s0").click(function(){
    var so = $('#s0').val(); 
    if(so != null){
       loadAccount(so);
    }
   });

   $("#s1").dblclick(function(){
     var alloptions = $("#s1 option");
     var so = $("#s1 option:selected");
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s2").append(so);
   });
  
   $("#s2").dblclick(function(){
     var alloptions = $("#s2 option");
     var so = $("#s2 option:selected");
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s3").append(so);
   });
  
   $("#s3").dblclick(function(){
     var alloptions = $("#s3 option");
     var so = $("#s3 option:selected");
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s2").append(so);
   });
  
  
   $("#add").click(function(){
     var alloptions = $("#s1 option");
     var so = $("#s1 option:selected");
     if(so.length > 0){
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s2").append(so);
     }
   });
  
   $("#remove").click(function(){
     var alloptions = $("#s2 option");
     var so = $("#s2 option:selected");
       if(so.length > 0){
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s1").append(so);
     }
   });
  
   $("#addall").click(function(){
     $("#s2").append($("#s1 option").attr("selected",true));
   });
  
   $("#removeall").click(function(){
     $("#s1").append($("#s2 option").attr("selected",true));
   });
     $("#add_n").click(function(){
       var alloptions = $("#s2 option");
     
       var so = $("#s2 option:selected");
       if(so.length > 0){
         so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
         $("#s3").append(so);
       }
   });
  
   $("#remove_n").click(function(){
     var alloptions = $("#s3 option");
     var so = $("#s3 option:selected");
       if(so.length > 0){
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s2").append(so);
     
     }
   });
  
   $("#addall_n").click(function(){
     $("#s3").append($("#s2 option").attr("selected",true));
   });
  
   $("#removeall_n").click(function(){
     $("#s2").append($("#s3 option").attr("selected",true));
   });
   $("#s1up").click(function(){
     var so = $("#s1 option:selected");
     if(so.get(0).index!=0){
       so.each(function(){
           $(this).prev().before($(this));
       });
     }
   });
   $("#s1down").click(function(){
     var alloptions = $("#s1 option");
     var so = $("#s1 option:selected");
     if(so.get(so.length-1).index!=alloptions.length-1){
       for(i=so.length-1;i>=0;i--)
       {
         var item = $(so.get(i));
         item.insertAfter(item.next());
       }
     }
   });
  
   $("#s2up").click(function(){
     var so = $("#s2 option:selected");
     if(so.get(0).index!=0){
       so.each(function(){
           $(this).prev().before($(this));
       });
     }
   });
  
   $("#s2down").click(function(){
     var alloptions = $("#s2 option");
     var so = $("#s2 option:selected");
     if(so.get(so.length-1).index!=alloptions.length-1){
       for(i=so.length-1;i>=0;i--)
       {
         var item = $(so.get(i));
         item.insertAfter(item.next());
       }
     }
   });
  selectedUser();
  selectedManager();
 });

function selectedUser(){
  $.ajax({
     url:path+"/system/account!findGroupAccountForJson.action?manager=0&groupId="+groupId+"&dateStr="+(new Date()),
     dataType:"json",
     success:function(data){
        selectedUserResult(data); 
      }
   });
}

function selectedUserResult(data){
 for(i=0;i<data.length;i++){
   $("#s2").append('<option value="'+data[i].id+'" title="'+data[i].title+'">'+data[i].name+'</option>');   
 }
}

function queryRecord(){
    var name = $.trim($("#search_name").val());
    var type = $.trim($("#search_type").val());
    if(type == '1'){
	    if(name==null || name == ''){
	       alert('请输入科室关键字');
	    }else{
		  $.ajax({
	         url:path+"/system/dept!findJSONByDeptName.action?name="+myFilterEncode(name)+"&dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
	                 queryRecordResult(data); 
		      }
		  });
	   }
    }else if(type == '2'){
	    if(name==null || name == ''){
	       alert('请输入用户名关键字');
	    }else{
		  $.ajax({
	         url:path+"/system/account!searchByNameOrCodeForJson.action?name="+myFilterEncode(name)+"&dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
		       $("#s0").empty();    
	           loadAccountResult(data); 
		      }
		  });
	   }
    }else if(type == '3'){
	    if(name==null || name == ''){
	       alert('请输入帐号关键字');
	    }else{
		  $.ajax({
	         url:path+"/system/account!searchByNameOrCodeForJson.action?code="+myFilterEncode(name)+"&dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
		       $("#s0").empty();    
	           loadAccountResult(data); 
		      }
		  });
	   }
    }
}

function queryRecordResult(data){
  var selectedids = sOk();
  var arr = selectedids.split(',');
  $("#s0").empty();
  var totalNum = data.length;
  if(totalNum <1){
    alert('搜索结果为空');
  }else{
	  for(i=0;i<totalNum;i++){
	     $("#s0").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');   
	  }
  }
}


function selectedManager(){
  $.ajax({
     url:path+"/system/account!findGroupAccountForJson.action?manager=1&groupId="+groupId+"&dateStr="+(new Date()),
     dataType:"json",
     success:function(data){
        selectedManagerResult(data); 
      }
   });
}

function selectedManagerResult(data){
 for(i=0;i<data.length;i++){
   $("#s3").append('<option value="'+data[i].id+'" title="'+data[i].title+'">'+data[i].name+'</option>');   
 }
}

function loadAccount(id){
  $.ajax({
     url:path+"/system/account!findAllByDeptIdForJson.action?dateStr="+(new Date())+"&id="+id,
     dataType:"json",
     success:function(data){
        loadAccountResult(data); 
      }
   });
}

function loadAccountResult(data){
 $("#s1").empty();
 for(i=0;i<data.length;i++){
    $("#s1").append('<option value="'+data[i].id+'" title="'+data[i].title+'">'+data[i].name+'</option>');   
 }
}

function sOk(){
  var alloptions = $("#s2 option");
  var selectids = '';
  var selectnames = '';
  for(i=0;i<alloptions.length;i=i+1)
  {
    if(i==0){
	    selectids = selectids + alloptions[i].value ;
	    selectnames = selectnames + alloptions[i].text ;
    }else{
	    selectids = selectids + ',' + alloptions[i].value;
	    selectnames = selectnames + ',' + alloptions[i].text;
    }
  }
  
  var alloptions3 = $("#s3 option");
  var selectids3 = '';
  var selectnames3 = '';
  for(i=0;i<alloptions3.length;i=i+1)
  {
    if(i==0){
	    selectids3 = selectids3 + alloptions3[i].value ;
	    selectnames3 = selectnames3 + alloptions3[i].text ;
    }else{
	    selectids3 = selectids3 + ',' + alloptions3[i].value;
	    selectnames3 = selectnames3 + ',' + alloptions3[i].text;
    }
  }
  if(selectids == "")selectids = "-1";
  if(selectids3 == "") selectids3 = "-1";
  return selectids+"="+selectids3;
}

function sClose(){
   window.close();
}