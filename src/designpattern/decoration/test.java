package designpattern.decoration;


public class test {
	public static void main(String[] args) {
		Pancake roujiamo = new Roujiamo("肉夹馍");
		
		System.out.println(roujiamo.name);
		roujiamo = new FriedEggs(roujiamo);
		System.out.println(roujiamo.name);
		roujiamo = new HamSausage(roujiamo);
		roujiamo = new Chicken(roujiamo);
		
		Class<?> cls = roujiamo.getClass();
		
		System.out.println(cls.getClassLoader());
		System.out.println(cls.getInterfaces());
		
		roujiamo = new FriedEggs(roujiamo);
		
		roujiamo = new FriedEggs(roujiamo);
		
		roujiamo = new FriedEggs(roujiamo);
		roujiamo = new FriedEggs(roujiamo);
		roujiamo = new FriedEggs(roujiamo);
		roujiamo = new FriedEggs(roujiamo);
		roujiamo = new FriedEggs(roujiamo);
		
		System.out.println(roujiamo.getDes()+" 总价:"+roujiamo.getPrice());
		
		
		//气息
		
		
		//乌云遮蔽了天空，窗外又是阴雨时候，伞下的恋人中，不在有你我手牵手，一切过了太久，我们的十字路口，下一站是谁在等候，你我的方向盘，却向着相反的彼岸，终点还是分开，告别你我离开之后，这回忆可以保留，当初那美好的感动，你说你记住了，不为彼此难受，过各自的生活
	}
}
