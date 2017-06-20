package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.impl.client.HttpClients;
/**
 * 线程池
 * @author node1
 *
 */
public class test {
		public static void main(String[] args) {
			Queue q = new LinkedList();
			for(int i = 0 ; i < 10;i++){
				q.add("A"+i);
			}
			System.out.println("队列"+q.toString());
			ExecutorService singleThreadExecutor = Executors.newFixedThreadPool(10);  
		  for (int i = 0; i < 100; i++) {  
			   final int index = i;  
			   singleThreadExecutor.execute(new Runnable() {  
			    public void run() {  
			     try {  
			      while(true) {  
			       if(q.poll() == null){
			    	   
			       }else{
			    	   System.out.println("我是线程："+index+",执行任务："+q.poll());  
			       }
//			       Thread.sleep(10 * 1000);  
			      }  
			     } catch (Exception e) {  
			      e.printStackTrace();  
			     }  
			    }  
			   });  
			   try {  
//			    Thread.sleep(500);  
			   } catch (Exception e) {  
			    e.printStackTrace();  
			   }  
			  }  }
}
