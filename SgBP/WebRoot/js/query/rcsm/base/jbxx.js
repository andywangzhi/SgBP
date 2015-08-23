/*---------------------基本信息添加js----------------------------------------*/

		String.prototype.len=function(){                 
			return  this.replace(/[^\x00-\xff]/g,"rr").length;          
		} 
		
    	var lenghtCheck=true;
    	var errorDisplay="";
    	var p1=['pname','idCard','graduatecollege','specialtyName','messageAddr','pphone','pemail','ppost','workCompany','dutylevel','specialtyStrong'];
    	var p2=['姓名','公民身份号码','毕业院校','专业名称','通讯住址','联系电话','电子邮箱','邮编','现就业单位名称','担任行政职务或级别','其他专长技能描述'];
    	var p3=[32,18,100,100,100,40,100,6,100,100,200];
    	
    	var p4=['cultureTypeother','ptradeother','pquartersother','economyKindother'];
    	var p5=['最高学历其他','现所在行业其他','现从事岗位其他','单位性质其他'];
    	var p6=[32,40,40,20];
    	function checkLen(){
    		errorDisplay="";
    		lenghtCheck=true;
	    	for(var i=0;i<p1.length;i++){
		    	 var value=$("#"+p1[i]).val();
			     if(value!=null&&value.len()>p3[i]){
					errorDisplay=p2[i]+"长度过长!";
					lenghtCheck=false;
					break;
				}
	    	}
	    	if(lenghtCheck){
		    	for(var j=0;j<p4.length;j++){
			    	if(!$("#"+p4[j])){
			    		continue;
			    	}else{
				    	var v1=$("#"+p4[j]).val();
				    	if(v1!=null&&v1.len()>p6[j]){
							errorDisplay=p5[j]+"长度过长!";
							lenghtCheck=false;
							break;
					     }
			    	}
		    	}
	    	}
	    	return lenghtCheck;
    	}
    	
    	var idcardCheck=true;
		function addOrUpdateRecord(param){
			if(clicked){
				clicked=false;
			}else{
				return;
			}
			var str="";  
			var ram=Math.random();
			var pname=$("#pname").val();
			var idCard=$("#idCard").val();
			var pphone=$("#pphone").val();
			var pemail=$("#pemail").val();
			var ppost=$("#ppost").val();
			var operationalDate=$("#operationalDate").val();
			var pattenPhone =/(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\(\d{3}\))|(\d{3}\-))?(1[358]\d{9})$)/; 
			var pattenEmail =/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/;
			var pattenPost = /^[0-9]{6}$/; 
			
			var emailFlag=true;
			var postFlag=true;
			
			//电子邮件和邮编分开验证
			if(pemail!=null&&pemail!=""&&pemail!="@"){
			 	if(!pattenEmail.test(pemail)){
			 	    emailFlag=false;
				 }
			}
			if(ppost!=null&&ppost!=""){
				 if(!pattenPost.test(ppost)){
				    postFlag=false;
				 }
			}
			
			//人才类型
			var personTypes=$(":checkbox:checked").size();
		    if(pname==null||pname==""){
		    	clicked=true;
				alert("姓名不能为空!");
			}else if(idCard==null||idCard==""){
				clicked=true;
				alert("身份证不能为空!");
			}else if(pphone==null||pphone==""){
				clicked=true;
				alert("电话号码不能为空!");
			}else if(operationalDate==null||operationalDate==""){
				clicked=true;
				alert("填表日期不能为空!");
			}else if(!checkLen()){
				clicked=true;
				alert(errorDisplay);
			}else if(!pattenPhone.test(pphone)){
				clicked=true;
			     alert("请填写正确的电话号码:\n(如020-87637686或者18711437897)");
			}else if(!emailFlag){
				clicked=true;
				alert("非法的电子邮件地址!");
			}else if(!postFlag){
				clicked=true;
				alert("非法邮编!");
			}else if(!idcardCheck){
				clicked=true;
				alert("身份证已经存在!");
			}else if(personTypes<=0){
				clicked=true;
				alert("请选择人才类型!");
			}else if(checkIdCardNo(idCard)){
				$("#save").attr("disabled",true);	
				$("#saveAndNext").attr("disabled",true);
				$("input[name='personType']").each(function(){
					if(this.checked){
						str +=$(this).val()+",";
					}
				});
				$("#combinePersonType").attr("value",str);
				$("#frm").ajaxSubmit({
					url: path+'/soa/RsPerson!ajaxSaveOrUpdate.action?menuId='+menuId+'&ram='+ ram,
					dataType:"json",
					success: function(data, status)
					{   
						var flag=data.flag;
						var personId=data.personId;
				        if(flag=="1"){
				        	if(param==1){
					        	alert("基本信息保存成功");
					        	location.href=path+'/soa/RsPerson!toEditPage.action?menuId='+menuId+'&form.retrieveSO.personId='+personId;
				        	}else{
				        		location.href = path+'/soa/tech!query.action?menuId='+menuId; 
				        	}
				        	
				        }else if(flag=="2"){
				        	clicked=true;
				        	alert("基本信息保存失败");
				        }
				        
					},
					error:function()
					{
						clicked=true;
						$("#save").attr("disabled",false);	
						$("#saveAndNext").attr("disabled",false);
						alert("图片上传大小超过1M,请选择合适的图片!");
					}
				});
				//$("#frm").submit();	
			}else{
				clicked=true;
			}	
		} 
		
		function modify(param,param2){
			var str=$("#"+param).find("option:selected").text(); 
			var strOther=$("#"+param+"other");
			var cultureTypeDiv=$("#"+param+"Div");
			if(str=="其他"){
				cultureTypeDiv.show();
				strOther.attr("value",param2);
			}else{
				cultureTypeDiv.hide();
			}
		}
		
		function retrieveRegCity(){
			var proVal=$("#regProv").val();
			var ram=Math.random();
			var registeraddrprov = $("#registeraddrprov").val();
			var registeraddrcity = $("#registeraddrcity").val();
			$.get(path+'/soa/RsPerson!ajaxGetRegCity.action?ram='+ ram,{"form.parentCode":proVal,"form.registeraddrprov":registeraddrprov,"form.registeraddrcity":registeraddrcity},fun,"json");
			function fun(data){
			 	var cityHtml=data.regCityHtml;
			 	$("#regCity").html(cityHtml);
			}	
		}
		
		function checkIdCard(){
			var idCard=$("#idCard").val();
			if(idCard!=null&&idCard!=""){
				var ram=Math.random();
				$.get(path+'/soa/RsPerson!ajaxCheckIdCard.action?ram='+ ram,{"form.idCard":idCard},fun,"json");
				function fun(data){
				 	idcardCheck=data.flag;
				 	if(!idcardCheck){
				 		clicked=true;
				 		alert("身份证已经存在!");
				 	}
				}	
			}
		}
		
		function setImagePreview() {
        var docObj=document.getElementById("uploadFile");
        if(docObj.value==null||docObj.value==''){
        	return;
        }
        if(checkIMG(docObj)) {
        	alert("请上传正确格式的图片!");
        	docObj.outerHTML+='';
			return;
        }
        var imgObjPreview=document.getElementById("showPic");
        imgObjPreview.style.width = "144px";
        docObj.style.width = "144px";
        imgObjPreview.style.height = "130px";
        if(docObj.files && docObj.files[0]){
		    //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式  
		   	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");
			//必须设置初始大小
			localImagId.style.width = "144px";
			localImagId.style.height = "130px";
			try{
				localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch(e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
		}
        return true;
    }

    function checkIMG(obj) {
    	var fileext = obj.value.substring(obj.value.lastIndexOf("."), obj.value.length);//取图片的后缀
        fileext = fileext.toLowerCase();
        if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp')) {
            return true;
        }
        return false;
    }
    
    
    
    

    /*---------------------基本信息查询js----------------------------------------*/
    		function search(){
			$("#frm").submit();
		} 
		
		function firstPage() {
			document.getElementById('currentPage').value = 1;
			document.getElementById('frm').submit();
		}
		
		function prePage(curPage) {
			document.getElementById('currentPage').value = (Number(curPage) - 1);
			document.getElementById('frm').submit();
		}
		
		function nextPage(curPage) {
			document.getElementById('currentPage').value = (Number(curPage) + 1);
			document.getElementById('frm').submit();
		}
		
		function endPage(endPage) {
			document.getElementById('currentPage').value = Number(endPage);
			document.getElementById('frm').submit();
		}
		
		
		String.prototype.trim=function(){
		　　 return this.replace(/(^\s*)|(\s*$)/g, "");
		}
		String.prototype.ltrim=function(){
		　　 return this.replace(/(^\s*)/g,"");
		}
		String.prototype.rtrim=function(){
		　　 return this.replace(/(\s*$)/g,"");
		}
		
		
		
		function preview(uuid,pname,idCard,auditstate){
			var pnameEnCode=encodeURI(pname.trim().ltrim().rtrim());
			location.href=path+'/soa/previewAction.action?menuId='+menuId+'&form.uuid='+uuid+'&form.personDetail.pname='+pnameEnCode+'&form.personDetail.idCard='+idCard+'&form.personDetail.auditstate='+auditstate;
		}
		function openUpload(){
				$("#w").html(" ");
				$('#upload').window('open');
			}
		function closeUpload(){
			$("#w").html(" ");
			$('#upload').window('close');
		}
		function closeInf(){
			$('#w').window('close');
		}

		function saveUpload(){
			var attachFile = $('#attachFile').val();
			if(attachFile==""){
				alert("请选择文件\r\n");
				return ;
				}
			 var pos = attachFile.lastIndexOf(".");
			 var lastname = attachFile.substring(pos,attachFile.length) 
			 if (lastname.toLowerCase()!=".doc")
			 {
			     alert("文件类型必须为doc类型");
			     return ;
			 }
			 $("#formDiv").hide();
			$("#w").html("正在导入，请您稍等.....");
			 $("#fileForm").ajaxSubmit(
						{
							url: "uploadExecl!saveWord.action?dateStr="+(new Date()),
							dataType:'json',
							success: function(data, status)
							{   
							$("#formDiv").show();
							$('#upload').window('close');
							$('#w').html(" ");
							$('#attachFile').attr("value","");
							var error='';
							try   { 
								error = data.error;
								} 
							catch(exception){} 
							var log='';
							try   { 
								log = data.log;
								} 
							catch(exception){} 
							if(error!=null&&error.length>0){
						     	 alert("导入失败，"+error);
							}else if(log!=null&&log.length>0){
								
									alert("导入成功,"+log);
								//	location.href=path+'/uploadExecl!queryBatchlog.action?menuId='+menuId+'&formform.lognumber='+data.lognumber;
								}else{
									alert("导入成功");
								}
							},
							error:function()
							{
								$("#formDiv").show();
								$('#upload').window('close');
								$('#w').html(" ");
								$('#attachFile').attr("value","");
								alert("导入失败");
							}
						});
		}
		
		function toEdit(param){
			location.href=path+'/soa/RsPerson!toEditPage.action?menuId='+menuId+'&form.retrieveSO.personId='+param;
		}
		
		function toDelete(param) {
			if(confirm('您确定删除记录吗？')) {
				var ram=Math.random();
				$.get(path+'/soa/RsPerson!delete.action?ram='+ ram + "&form.retrieveSO.personId=" + param);
				alert('删除成功！');
				$("#frm").submit();
			}
		}