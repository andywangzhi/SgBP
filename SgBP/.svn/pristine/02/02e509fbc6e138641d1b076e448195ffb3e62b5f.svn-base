function myFilterDecode(originalStr)
{
    var decodeStr = decodeURI(decodeURI(originalStr, "utf-8"), "utf-8");
    var filterStr = "" ;
    for (var i = 0; i < decodeStr.length; i ++)
    {
        if ("+" == decodeStr.substring(i, i + 1))
        {
            filterStr += " ";
        }
        else
        {
            filterStr += decodeStr.substring(i, i + 1);
        }

    }
    return filterStr;
}

function myFilterEncode(originalStr)
{
    var encodeString = encodeURI(encodeURI(originalStr,"utf-8"),"utf-8");
    return encodeString;
}

function clearData(formName)
{
	var formObj = document.forms[formName];     
	var formEl = formObj.elements;     
	for (var i=0; i<formEl.length; i++)     
	{         
		var element = formEl[i];         
		if (element.type == 'submit') { continue; }         
		if (element.type == 'reset') { continue; }         
		if (element.type == 'button') { continue; }         
		if (element.type == 'hidden') { continue; }          
		if (element.type == 'text') { element.value = ''; }         
		if (element.type == 'textarea') { element.value = ''; }         
		if (element.type == 'checkbox') { element.checked = false; }         
		if (element.type == 'radio') { element.checked = false; }   
		if (element.type == 'select-multiple') { element.selectedIndex = 0; }
		if (element.type == 'select-one') { element.selectedIndex = 0; }   
	}   
}

function openWindow(url,width,height){ 
   var top = (window.screen.height-height)/2;
   var left = (window.screen.width-width)/2;
   window.open(url,null,"height="+height+", width="+width+", top="+top+", left="+left+",location=no,menubar=no,toolbar=no,status=no,resizable=no,scrollbars=no");
}

