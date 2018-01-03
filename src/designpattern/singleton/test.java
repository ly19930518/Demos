package designpattern.singleton;

import java.util.Date;

public class test extends Thread{
	public static void main(String[] args) {
		test t1 = new test();
		t1.start();
		test t2 = new test();
		t2.start();
		test t3 = new test();
		t3.start();
		test t4 = new test();
		t4.start();
		test t5 = new test();
		t5.start();
		test t6 = new test();
		t6.start();
	}

	@Override
	public void run() {
		while(true){
			System.out.println(this.getName()+"start:"+new Date().getTime());

			synchronized (test.class) {
				try {
					Thread.sleep(1000*5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Singleton2.getSingleton().sum ++;
//				System.out.println(Singleton2.getSingleton().sum);
			}
			System.out.println(this.getName()+"  end:"+new Date().getTime());
		}
	}
	
	
	
	
	
	
	
}
