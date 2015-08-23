//remove the left  space
function ltrim(s)
{
    return s.replace(/^\s*/, "");
}
//remove the right space
function rtrim(s)
{
    return s.replace(/\s*$/, "");
}
//remove the left and the right space
function trim(s)
{
    //return rtrim(ltrim(s));// can remove half-width characters only
	var temp=s.replace(/(^\s*)|(\s*$)/g, "");// firstly , remove half-width characters space
	return temp.replace(/(^　*)|(　*$)/g, "");// second,remove full-width characters space.
}

function filterSpecialStr(str)
{

    var filterStr1 = str ;
    //filterStr = str.replaceAll(filterStr, "", "","");
    //filterStr += str.replaceAll(filterStr, "'", "");
    for (var i = 0; i < filterStr1.length; i ++)
    {
        //filterStr1 = filterStr1.replace( " ", "");
        filterStr1 = filterStr1.replace("%", "");
        filterStr1 = filterStr1.replace("#", "");
        filterStr1 = filterStr1.replace("&", "");
        filterStr1 = filterStr1.replace("*", "");
        filterStr1 = filterStr1.replace("(", "");
        filterStr1 = filterStr1.replace(")", "");
        filterStr1 = filterStr1.replace("@", "");
        filterStr1 = filterStr1.replace("`", "");
        filterStr1 = filterStr1.replace("/", "");
        filterStr1 = filterStr1.replace("\"", "");
        filterStr1 = filterStr1.replace(",", "");
        //filterStr1 = filterStr1.replace( ".", "");
        filterStr1 = filterStr1.replace("=", "");
        //filterStr1 = filterStr1.replace( "<", "");
        //filterStr1 = filterStr1.replace( ">", "");
        filterStr1 = filterStr1.replace("$", "");
        filterStr1 = filterStr1.replace("!", "");
        filterStr1 = filterStr1.replace("?", "");
        filterStr1 = filterStr1.replace("^", "");
        //filterStr1 = filterStr1.replace( "~", "");
        filterStr1 = filterStr1.replace(":", "");
        filterStr1 = filterStr1.replace(";", "");
        filterStr1 = filterStr1.replace("+", "");
    }

    if (filterStr1 == str)
    {
        return true;
    }
    else
    {
        return false;
    }
}



/**
 * js合法性检查工具文件
 * 包含的功能如下：
 *     isNull(str)    检查输入字符串是否为空或者全部都是空格
 *     rtrim(stringObj)    去字符串右端空格
 *     ltrim(stringObj)    去字符串左端空格
 *     trim(stringObj)    去字符串两端空格
 *     isNumber(str)      检查输入字符串是否符合正整数格式
 *     getMaxDay(year, month)    取得指定年月的最大天数
 *     isDate(date, fmt)    是否是按指定格式格式化日期字符串
 *     checkTwoDate(startDate, endDate, fmt)  检查输入的起止日期是否正确，规则为两个日期的格式正确，且结束如期>=起始日期
 *     isLastMatch(str1, str2)  判断字符1是否以字符串2结束
 *     isEmail(s)  检查输入对象的值是否符合E-Mail格式
 *     cTrim(sInputString, iType)  字符串去空格的函数
 */


/**
 * 检查输入字符串是否为空或者全部都是空格
 * @param str  需要进行检查的字符串
 * @return  如果全是空返回true,否则返回false
 */
function isNull(str) {
    if (str == "") return true;
    var regu = "^[ ]+$";
    var re = new RegExp(regu);
    return re.test(str);
}


/**
 * 检查输入字符串是否符合正整数格式
 * @param str  需要进行检查的字符串
 * @return  如果通过验证返回true,否则返回false
 */
function isNumber(str) {
    var regu = "^[0-9]+$";
    var re = new RegExp(regu);
    if (str.search(re) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * 取得指定年月的最大天数
 * @param year  年
 * @param month  月
 * @return 指定年月的最大天数
 * 1=31 2=29/30 3=31 4=30 5=31 6=30 7=31 8=31 9=30 10=31 11=30 12=31
 */
function getMaxDay(year, month) {
    if (month == 4 || month == 6 || month == 9 || month == 11)
        return "30";
    if (month == 2) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)return "29";
        else return "28";
    }
    return "31";
}

/**
 * 是否是按指定格式格式化日期字符串
 * @param date 日期
 * @param fmt  格式化的格式
 * @return  如果是返回true,否则返回false
 */
function isDate(date, fmt) {
    if (fmt == null) fmt = "yyyyMMdd";
    var yIndex = fmt.indexOf("yyyy");
    if (yIndex == -1) return false;
    var year = date.substring(yIndex, yIndex + 4);
    var mIndex = fmt.indexOf("MM");
    if (mIndex == -1) return false;
    var month = date.substring(mIndex, mIndex + 2);
    var dIndex = fmt.indexOf("dd");
    if (dIndex == -1) return false;
    var day = date.substring(dIndex, dIndex + 2);
    if (!isNumber(year) || year > "2100" || year < "1900") return false;
    if (!isNumber(month) || month > "12" || month < "01") return false;
    if (day > getMaxDay(year, month) || day < "01") return false;
    return true;
}

/**
 * 检查输入的起止日期是否正确，规则为两个日期的格式正确，且结束如期>=起始日期
 * @param startDate  起始日期，字符串
 * @param endDate    结束如期，字符串
 * @param fmt   日期格式化格式
 * @return  如果通过验证返回true,否则返回false
 */
function checkTwoDate(startDate, endDate, fmt) {
    if (!isDate(startDate, fmt)) {
        alert("起始日期不正确!");
        return false;
    } else if (!isDate(endDate, fmt)) {
        alert("终止日期不正确!");
        return false;
    } else if (startDate > endDate) {
        alert("起始日期不能大于终止日期!");
        return false;
    }
    return true;
}

/**
 * 判断字符1是否以字符串2结束
 * @param str1
 * @param str2
 * @return 如果通过验证返回true,否则返回false
 */
function isLastMatch(str1, str2) {
    var index = str1.lastIndexOf(str2);
    if (str1.length == index + str2.length) return true;
    return false;
}

/*
 * 检查输入对象的值是否符合E-Mail格式
 * @param s 输入的字符串
 * @return 如果通过验证返回true,否则返回false
*/
function isEmail(s) {
    if (s == null || s == "" || s.length < 5 || s.length > 150)
        return false;
    var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[_.0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT|INFO|info|tom|TOM|biz|BIZ)$";
    var re = new RegExp(regu);
    if (s.search(re) != -1)
        return true;
    else
        return false;
}

/**
 * 字符串去空格的函数
 * @param sInputString 原始字符串
 * @param iType  0=去掉字符串左边和右边的空格
 *                1=去掉字符串左边的空格
 *                2=去掉字符串左边的空格
 * @return 去掉空格的字符串
 */
function cTrim(sInputString, iType) {
    var sTmpStr = ' ';
    var i = -1;
    if (iType == 0 || iType == 1) {
        while (sTmpStr == ' ') {
            ++i;
            sTmpStr = sInputString.substr(i, 1);
        }
        sInputString = sInputString.substring(i);
    }
    if (iType == 0 || iType == 2) {
        sTmpStr = ' ';
        i = sInputString.length;
        while (sTmpStr == ' ') {
            --i;
            sTmpStr = sInputString.substr(i, 1);
        }
        sInputString = sInputString.substring(0, i + 1);
    }
    return sInputString;
}

/*
用途：检查输入字符串是否符合金额格式
格式定义为带小数的正数，小数点后最多三位
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function isMoney(s) {
    //var regu = "^[0-9]+[\.][0-9]{0,3}$";
    var regu = /^[0-9]+.?[0-9]{0,2}$/
    var re = new RegExp(regu);
    if (re.test(s)) {
        return true;
    } else {
        return false;
    }
}
/*
用途：检查输入字符串是否符合正整数格式
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function isNumber(s) {
    var regu = "^[0-9]+$";
    var re = new RegExp(regu);
    if (s.search(re) != -1) {
        return true;
    } else {
        return false;
    }
}
/*
用途：检查输入字符串是否是域名
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false
*/
function isdomainchar(strdomainchar) {
    var regu_domainchar = "^[_0-9a-zA-Z-]+$";
    var re_domainchar = new RegExp(regu_domainchar);
    if (strdomainchar.search(re_domainchar) != -1) {
        return true;
    } else {
        return false;
    }
}
function isdomainlastgroup(strdomainlastgroup) {
    var mygroup = new Array(13);
    mygroup[0] = "com";
    mygroup[1] = "cn";
    mygroup[2] = "net";
    mygroup[3] = "gov";
    mygroup[4] = "mobi";
    mygroup[5] = "biz";
    mygroup[6] = "cc";
    mygroup[7] = "mil";
    mygroup[8] = "org";
    mygroup[9] = "edu";
    mygroup[10] = "int";
    mygroup[11] = "info";
    mygroup[12] = "tom";
    for (imygroup = 0; imygroup < mygroup.length; imygroup++)if (strdomainlastgroup == mygroup[imygroup])break;
    if (imygroup == mygroup.length)return false;
    else return true;
}
function isDomain(strDomain) {
    var strDomainlowcase = strDomain.toLowerCase();
    var doaminArr = strDomainlowcase.split(".");
    if (doaminArr.length < 2 || doaminArr.length > 4){
		//alert("doaminArr.length="+doaminArr.length+" doaminArr.length < 2 || doaminArr.length > 4");
		return false;
		} //域名至少有两组 www.baidu.com 或baidu.com  最多4 组
    for (idomain = 0; idomain < doaminArr.length; idomain++) {
        if (doaminArr[idomain] == null || doaminArr[idomain] == "" || !isdomainchar(doaminArr[idomain])){
			//alert("isDomain()=no");
			return false;
			}
    }
    //判断最后一组
    if (!isdomainlastgroup(doaminArr[doaminArr.length - 1])){
    	//alert("判断最后一组是否是域名的后缀！");
    	return false;
    	}
    return true;
}
function isDomainString(strDomainString) {
    var domainstring_js=window.location.hostname;
    var indexpointfirst=domainstring_js.indexOf(".");
    var domainsecond_js=".ctoshop.com";
    if(indexpointfirst!=-1) domainsecond_js=domainstring_js.substring(indexpointfirst);

    var strDomainStringlowcase = strDomainString.toLowerCase();
    var isok = "yes";
    var DomainStringArr = strDomainStringlowcase.split(",");
    if (strDomainStringlowcase.length < 4 || strDomainStringlowcase.indexOf(domainsecond_js) != -1)
    {
        return false;
    }
    var strDomainStringlowcase_piont=","+strDomainStringlowcase;//方便判断域名是否有重复的

    for (iDomainString = 0; iDomainString < DomainStringArr.length; iDomainString++) {
     if (DomainStringArr[iDomainString] == null || DomainStringArr[iDomainString] == "" || !isDomain(DomainStringArr[iDomainString]) || strDomainStringlowcase_piont.indexOf(","+DomainStringArr[iDomainString]) != strDomainStringlowcase_piont.lastIndexOf(","+DomainStringArr[iDomainString]))
        //判断是否有重复的域名
        {
			      isok = "no";
            break;
        }
    }
    if (isok == "yes"){
    	//alert("isok =================================== yes");
    	return true;
    	}
    else {
    	//alert("isok ==================================== no");
    	return false;
    	}
}

/**
 * 检测输入的域名是否合法
 * @param str_url  域名字符串
 */
function isValidURL(str_url) {
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+:)?[0-9a-z_!~*'().&=+$%-]+@)?"
            + "(([0-9]{1,3}\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\."
            + "[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
    var re = new RegExp(strRegex);
    return (re.test(str_url) ? (true) : (false));
}


