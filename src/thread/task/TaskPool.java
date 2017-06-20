package thread.task;

import thread.ExecutorProcessPool;
import thread.mq.Stack;

/**
 * 任务池
 * @author node1
 *
 */
public class TaskPool extends Stack<String>{
	private static TaskPool taskPool = new TaskPool();
	public static TaskPool getTask(){
		return taskPool;
	}
	public static void main(String[] args) {
		  ExecutorProcessPool pool = ExecutorProcessPool.getInstance();
		  
		  
		  pool.execute(new Stack2(TaskPool.getTask()));
		  try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  pool.execute(new Stack1(TaskPool.getTask(),"处理任务1"));
		  pool.execute(new Stack1(TaskPool.getTask(),"处理任务2"));
		
		  
		  pool.shutdown();
	}
}
/**
 * 任务1
 */
class Stack1 implements Runnable{
	String names;
	private TaskPool task;
	public Stack1(TaskPool task,String name) {
		this.task = task;
		this.names = name;
	}

	@Override
	public void run() {
		boolean is = true;
		System.out.println("我是任务1 成功启动");
		try {
			while(is){
				Thread.sleep(1000*3);
				
				synchronized(this){
					if(!task.empty()){
						String name = task.pop();
						System.out.println("----我"+names+"———————— 处理请求："+name+"--------");
						System.out.println("现在队列是否为空"+task.empty()+" 未处理内容："+task.toString());
					}else{
						is = false;//结束任务
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("我是任务1 任务完毕");
	}
}


/**
 * 任务2
 * 模拟请求
 */
class Stack2 implements Runnable{
	private TaskPool task;
	public Stack2(TaskPool task) {
		this.task = task;
	}

	@Override
	public void run() {
		System.out.println("我是任务2 成功启动");
		//发送1000 个请求
		for(int i = 0 ; i < 1000;i++){
			
			try {
				Thread.sleep(1000*2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			task.push("mq--"+i);
			System.out.println("----我是任务2 成功添加————————mq--"+i+"--------");
		}
		System.out.println("我是任务2 任务完毕");
	}
}
