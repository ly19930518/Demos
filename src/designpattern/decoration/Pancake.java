package designpattern.decoration;

/**
 * 饼类   设计模式-装饰模式
 * @author tlj
 *
 */
public abstract class Pancake {
	public String name = "我是一个不具体的饼";
	
	public String getDes() {
	       return name;
	}
	public abstract double getPrice();
}
