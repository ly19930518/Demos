/**
 * 显示金额格式
 * @param s 金额
 * @param n 保留小数位数
 * @returns {String}
 */
function fmoney(s, n) {
	var f="";
	if(s<0){
		s=Math.abs(s); 
		f="-";
	}
    n = n > 0 && n <= 20 ? n : 2;  
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";  
    var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];  
    t = "";  
    for (i = 0; i < l.length; i++) {  
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
    }  
    return f+t.split("").reverse().join("") + "." + r;  
}