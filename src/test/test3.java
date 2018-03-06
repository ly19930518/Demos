package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class test3 {
	public static int highestOneBit(int i){
		System.out.println("0:"+Integer.toBinaryString(i));
		i |= (i >> 1);
		System.out.println("1:"+Integer.toBinaryString(i));
		i |= (i >> 2);
		System.out.println("2:"+Integer.toBinaryString(i));
		i |= (i >> 4);
		System.out.println("3:"+Integer.toBinaryString(i));
		i |= (i >> 8);
		System.out.println("4:"+Integer.toBinaryString(i));
		i |= (i >> 16);
		System.out.println("5:"+Integer.toBinaryString(i));
		return i - (i >> 1);
	}
	public static void main(String[] args) {
		
//		System.out.println(Integer.toBinaryString(test3.highestOneBit(111114111)));
//		System.out.println(Integer.toBinaryString(1));
//		ThreadTest t = new ThreadTest();
//		t.start();
//		System.out.println();
//		System.out.println(2*2*2*2*2*2*2*2);
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();										//64+40     100 + 50 +
//		System.out.println(str);
//		System.err.println("ssssssssss");
//		System.err.printf("%s%n%s", str,222);
//		System.out.println(Integer.toBinaryString(2)); //1 * 16 *16 + 5 * 16 +4  256 +80 +4 = 334   
//		System.gc();
//		System.out.println(System.nanoTime());
		
		String str = "12346578";
		System.out.println(str.substring(2, 23));
		
	}
}
class ServerMap{
	static Map<String,Integer> servers = new HashMap<String,Integer>();
	static{
		servers.put("1G1核-服务器", 1);
		servers.put("2G2核-服务器", 2);
		servers.put("3G3核-服务器", 3);
		servers.put("4G4核-服务器", 4);
		System.out.println("静态代码块执行完毕");
	}
}
class ThreadTest extends Thread{
	public ServerMap server = null;
	@Override
	public void run() {
		while(true){
			System.out.println("server:"+server);
			try {
				this.sleep(1000*2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server = new ServerMap();
		}
	}
}