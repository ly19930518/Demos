package demo;

import java.util.concurrent.TimeUnit;

/**
 * 线程池 实例
 * @author node1
 *
 */
public class test2 {
	
	public static void main(String[] args) {
//		int availableProcessors = Runtime.getRuntime().availableProcessors();
//		System.out.println("处理器"+availableProcessors);
//		System.out.println("test:"+Runtime.getRuntime());
		try {
			for(int i = 0; i < 100;i++){
				System.out.println("cest:"+i);
				TimeUnit.MILLISECONDS.sleep(1000*10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
