package util;
/**
 * 检验类
 
 */
public class CheckUtil {
	/**
	 * 检验是否为不为空或""
	 */
	public static boolean isNotNull(String str){
		if(str != null || !"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 检验是否为空或""
	 */
	public static boolean isNull(String str){
		if(str == null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}
}
