package designpattern.singleton;

/**
 *	单例模式 
 *
 */
public class Singleton1 {
	public int sum = 0 ;
	private static Singleton1 singleton1 = new Singleton1();
	public static Singleton1 getSingleton(){
		return singleton1;
	}
}
