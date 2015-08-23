$(function(){
   $("#s0").dblclick(function(){
     var alloptions = $("#s0 option");
     var so = $("#s0 option:selected");
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s1").append(so);
   });
  
   $("#s1").dblclick(function(){
     var alloptions = $("#s1 option");
     var so = $("#s1 option:selected");
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s0").append(so);
   });
  
  
   $("#add").click(function(){
     var alloptions = $("#s0 option");
     var so = $("#s0 option:selected");
     if(so.length > 0){
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s1").append(so);
     }
   });
  
   $("#remove").click(function(){
     var alloptions = $("#s1 option");
     var so = $("#s1 option:selected");
       if(so.length > 0){
     so.get(so.length-1).index == alloptions.length-1?so.prev().attr("selected",true):so.next().attr("selected",true);
     $("#s0").append(so);
     }
   });
  
   $("#addall").click(function(){
     $("#s1").append($("#s0 option").attr("selected",true));
   });
  
   $("#removeall").click(function(){
     $("#s0").append($("#s1 option").attr("selected",true));
   });
  selectedUser();
 });

function selectedUser(){
  $.ajax({
     url:path+"/system/account!findSelectedDeptAccountForJson.action?deptId="+deptId+"&dateStr="+(new Date()),
     dataType:"json",
     success:function(data){
        selectedUserResult(data); 
      }
   });
}

function selectedUserResult(data){
 for(i=0;i<data.length;i++){
   $("#s1").append('<option value="'+data[i].id+'" title="'+data[i].title+'">'+data[i].name+'</option>');   
 }
}

function queryRecord(){
    var name = $.trim($("#search_name").val());
    var type = $.trim($("#search_type").val());
    if(type == '1'){
	    if(name==null || name == ''){
	       alert('请输入用户名关键字');
	    }else{
		  $.ajax({
	         url:path+"/system/account!searchByNameOrCodeForDeptForJson.action?name="+myFilterEncode(name)+"&dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
		       $("#s0").empty();    
	           loadAccountResult(data); 
		      }
		  });
	   }
    }else if(type == '2'){
	    if(name==null || name == ''){
	       alert('请输入帐号关键字');
	    }else{
		  $.ajax({
	         url:path+"/system/account!searchByNameOrCodeForDeptForJson.action?code="+myFilterEncode(name)+"&dateStr="+(new Date()),
		     dataType:"json",
		     success:function(data){
		       $("#s0").empty();    
	           loadAccountResult(data); 
		      }
		  });
	   }
    }
}

function loadAccountResult(data){
 $("#s0").empty();
 for(i=0;i<data.length;i++){
    $("#s0").append('<option value="'+data[i].id+'" title="'+data[i].title+'">'+data[i].name+'</option>');   
 }
}

function sOk(){
  var alloptions = $("#s1 option");
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
  return selectids;
}

function sClose(){
   window.close();
}