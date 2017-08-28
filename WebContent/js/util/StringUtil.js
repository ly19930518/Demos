/**
 * 字符串工具类
 * 2017-8-1 17:11:49
 */


/**
 * 利用正在表达式获取一个url 字符串中的参数值
 * @param urlstr 需要处理的url 字符串
 * 		  key 获取获取对应的参数名
 */
var getQueryString = function(urlstr,key){
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = urlstr.substr(1).match(reg);
	if(r != null){
		return unescape(r[2]);
	}else{
		return null;
	}
}
/**
 * 利用正在表达式获取一个url 字符串中的参数值
 * @param key 获取获取对应的参数名
 */
var getQueryString = function(key){
	var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if(r != null){
		return unescape(r[2]);
	}else{
		return null;
	}
}