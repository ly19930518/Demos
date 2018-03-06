package queue;

import java.util.Random;

public class test {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		
		new Thread( new Runnable() {
			public void run() {
				while(true){
					try {
						Thread.sleep(1000 * 2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println();
					int random = (int)(Math.random()*10000);
					queue.push(random);
					System.out.println("队列： "+random+" 入队成功");
				
				}
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					int res = queue.peek() == null ? 0:queue.peek();
					try {
						Thread.sleep(1000 * 3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("队列："+res+" 处理成功");
					queue.pop();
				
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000 * 5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("队列大小："+queue.getSize());
				}
			}
		}).start();
		
		
		
		
	}
}
