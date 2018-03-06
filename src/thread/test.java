package thread;

public class test extends Thread{
	public static void main(String[] args) {
		test t = new test();
		t.start();
	}

	@Override
	public void run() {
			
			int sum = 0;
			while(true){
				this.setName("线程任务"+sum);
				try {
					this.t1();
				} catch (Exception e) {
					e.printStackTrace();
				}
				sum++;
			}
	
		
	}
	public void t1() throws Exception{
		
		for(int i = 0 ; i < 1000 ; i ++){
			Thread.sleep(1000*1);
			System.out.println(this.getName());
			System.out.println(i);
			System.out.println(i%10);
			if(i%10==0 && !(i<100)){
				System.out.println((this.getName()+" ").substring(0, 100));
			}else{
				System.out.println(this.getName()+" "+i);
			}
		}
	}
}
