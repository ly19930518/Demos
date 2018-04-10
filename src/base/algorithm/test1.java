package base.algorithm;

public class test1 {
	
	
	//爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法。 
	public static int ClimbStairs(int n){
		System.out.println(n);
		
		int i = 1;
		if(n <= 0){
			return 0;
		}else if(n == 1){
			return i;
		}else if(n == 2){
			return i++;
		}else{
			return ClimbStairs(n-1)+ClimbStairs(n-2);
		}
	}
	

	
	public static void main(String[] args) {
		System.out.println("结果："+test1.ClimbStairs(4));
	}
	
}
//汉诺塔问题：一次只能移动一个盘子；不能把大盘子放在小盘子上；除去盘子在两个柱子之间移动的瞬间，
//盘子必须都在柱子上。（在这三点要求下把盘子从起始柱子A全部移动到目标柱子C上） 
	
class HanNuoTower{
	public void tower(int n,char s,char m,char e){
		if(n == 1){
			moven(s,e);
		}else{
			tower(n-1, s, e, m);
			moven(s, e);
			tower(n-1, m, s, e);
		}
	}
	
	private void moven(char s, char e) {
		System.out.println("moven:"+s+" to "+e);
	}
	public static void main(String[] args) {
		HanNuoTower hanNuoTower = new HanNuoTower();
		hanNuoTower.tower(5,'a', 'b','c');
	}
	
	

}

//计算阶乘
class TraditionalThread{
	public int factorial(int n){
		if(n == 1){
			return 1;
		}else{
			return n * factorial(n-1);
		}
	}
	
	public static void main(String[] args) {
		TraditionalThread t = new TraditionalThread();
		int i = t.factorial(10);
		System.out.println(i);
	}
}