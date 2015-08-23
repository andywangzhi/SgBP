function init(){
	var typeObj=$(".hidType");
	for(var i=0;i<typeObj.length;i++){
		if($(typeObj[i]).val()=="date"){
			$(typeObj[i]).next(".tabInput").addClass("Wdate");
		}
	}
}
function getFocus(obj){
	var hidType=$(obj).prev(".hidType").val();
	if(hidType=="date" ||hidType=="DATE" || hidType=="TIMESTAMP"){
		WdatePicker({dateFmt:'yyyyMMdd'});
	}
}
function validateInput(){
	var inputObj=$(".tabInput");
	for(var i=0;i<inputObj.length;i++){
		var hidType=$(inputObj[i]).prev(".hidType").val();
		var inputVal=$(inputObj[i]).val();
		var vName=$(inputObj[i]).parent().find(".inputName").val();
		if($.trim(inputVal)==""){
			alert(vName+'不能为空');
			return false;
		}
		if(hidType=="int"){
			//校验数字
			var v=$(inputObj[i]).val();
			if(isNaN(v)){
				alert(vName+'不是数字');
				return false;
			}
		}
	}
	return true;
}
function queryRecord(){
	if(validateInput()){
		var inputObj=$(".tabInput");
		var paramStr="";
		for(var i=0;i<inputObj.length;i++){
			var isLike=$(inputObj[i]).parent().find(".hidIsLike").val();
			var param=$.trim($(inputObj[i]).val());
			if($.trim(isLike)=='1'){
				paramStr+="\'%"+param+"%\',";
			}else{
				paramStr+=param+",";
			}
			
		}
		if(paramStr.length>1){
			paramStr=paramStr.substring(0,paramStr.length-1);
			
		}
		var reportId=$("#reportId").val();
		//var url=path+'/soa/member/dynamicQuery!queryInput.action?form.retrieveSO.reportId='+reportId+'&menuId='+menuId+'&paramStr='+paramStr;
		
		var url=path+'/soa/member/dynamicQuery!retrieveDetail.action?form.retrieveSO.reportId='+reportId+'&menuId='+menuId+'&form.retrieveSO.paramStr='+paramStr;
		
		url=encodeURI(url); 
        url=encodeURI(url);
		window.location.href=url;
	}
}

$(document).ready(function(){ 
	init();
});