package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * 获取文件MD5签名
 * @author tl
 * @version 1.0.0.0
 * 2017年3月10日14:42:16
 */
public class MD5Util {
	private static final String []hexDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c",
		"d","e","f"};
	
	/**
	 * 获取MD5文件签名
	 * @param String url 文件绝对路径
	 */
	public static String getFileMD5(String url){
		String md5 = null;
		File file = new File(url);//104adebe56caf91020d7ce39c937df05
		try {
			FileInputStream is = new FileInputStream(file);
			FileChannel fc = is.getChannel();
			MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//获取文件信息摘要
			MessageDigest digest = MessageDigest.getInstance("MD5");
			//指定字节 更新摘要
			digest.update(buffer);
			md5 = byteArrayToHexString(digest.digest());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return md5;
	}
	
	/**
	 * /将字节数字转换成 16进制字符串
	 * @param byte digest 字节数组
	 * @return 16进制字符串
	 */
	private static String byteArrayToHexString(byte[] digest) {
		StringBuffer buffer = new StringBuffer();
		for(int i = 0 ; i < digest.length ;i++){
			buffer.append(byteToHexString(digest[i]));
		}
		return buffer.toString();
	}
	/**
	 * 字节转16进制
	 * @param b 字节对象
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int d1 = (b&0xf0)>>4;
		int d2 = b&0xf;
		return hexDigits[d1]+hexDigits[d2];
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(MD5Util.getFileMD5("C:\\xxx\\Penguins.jpg"));
		System.out.println(10000000&0xf0>>4);
		System.out.println(10000000&0xf);
	}
}
