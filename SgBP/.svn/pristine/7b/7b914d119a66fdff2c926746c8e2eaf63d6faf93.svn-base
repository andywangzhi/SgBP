
// 产生所有的年份
function addYearOpts(_id){
	var c = document.getElementById(_id);
	c.options.length=0;
	var now = new Date();
    var year = now.getFullYear();       //年
    var old = year-70;
	for(var i=year;i>=old;i--){
		var opt = new Option(i,i);
		c.options.add(opt);
	}
	document.getElementById(_id).value=getNowYear();
}
// 产生所有的月份
function addMonthOpts(_id){
	var c = document.getElementById(_id);
	c.options.length=0;
	for(var i=1;i<=12;i++){
		var _MM = i<10?("0"+i):i;
		var opt = new Option(_MM,_MM);
		
		c.options.add(opt);
	}
	document.getElementById(_id).value=getNowMonth();
}
// 选择日期值改变
function selectChange(_my, _index, _type, _aObj, _bObj, _cObj, _dataList){
	/*var _type = _my.istype;
	var _aObj = _my.aobj;
	var _bObj = _my.bobj;
	var _cObj = _my.dateType;// start开始:end结束
	var _dataList=_my.dataList;//数据集：如form.dtoList
	alert("_type:"+_type);
alert("_aObj:"+_aObj);alert("_dataList:"+_dataList);*/
	var _defalutDataList="form.dtoList";
	if(null!=_dataList){
		_defalutDataList=_dataList;
	}
	if(_type=="year"){
		var _y = _my.value;
		var _m = document.getElementById(_aObj+_index).value;
		var _d = "";
		if(_cObj=="start"){
			_d="01";
		}else if(_cObj=="end"){
			_d = DayNumOfMonth(_y,_m);
		}
		
		document.getElementById(_defalutDataList+"["+_index+"]."+_bObj).value = _y + "-" + _m + "-" + _d;
	}else if(_type=="month"){
		var _y = document.getElementById(_aObj+_index).value;
		var _m = _my.value
		var _d = "";
		if(_cObj=="start"){
			_d="01";
		}else if(_cObj=="end"){
			_d = DayNumOfMonth(_y,_m);
		}
		document.getElementById(_defalutDataList+"["+_index+"]."+_bObj).value = _y + "-" + _m + "-" + _d;
	}
}
// 根据年月获得当前月的天数
function DayNumOfMonth(Year,Month)
{ 
    var d = new Date(Year,Month,0);
    return d.getDate(); 
} 
// 获得当前日期月的第一天yyyy-MM-01
function getFirstDay()
{ 
    var now = new Date();
   
    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = "01"						//日
   
    var clock = year + "-";
   
    if(month < 10)
        clock += "0";
   
    clock += month + "-";
   
    clock += day;
   
    return clock; 
}
// 获得当前日期月的最后一天yyyy-MM-dd
function getEndDay()
{ 
    var now = new Date();
   
    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = DayNumOfMonth(year,month);//日
   
    var clock = year + "-";
   
    if(month < 10)
        clock += "0";
   
    clock += month + "-";
   
    if(day < 10)
        clock += "0";
       
    clock += day;
   
    return clock; 
}
// 获取当前年
function getNowYear(){
	var now = new Date();
    var year = now.getFullYear();       //年
	return year;
}
// 获取当前月
function getNowMonth(){
    var now = new Date();
    var month = now.getMonth() + 1;     //月

    if(month < 10)
    	month = "0"+month;
   return month;
}
