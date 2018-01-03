package designpattern.singleton;

public class Singleton2 {
	int sum = 0;
	private static Singleton2 singleton;
	public Singleton2() {
		// TODO Auto-generated constructor stub
	}
	public synchronized static Singleton2 getSingleton(){
		if(singleton == null ){
			singleton = new Singleton2();
		}
		return singleton;
	}
}
