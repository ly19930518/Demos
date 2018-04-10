package designpattern.decoration;

public class Chicken extends Pancake{
	private Pancake pancake;
	public Chicken(Pancake pancake) {
		this.pancake = pancake;
	}
	@Override
	public double getPrice() {
		return pancake.getPrice()+2.5d;
	}
	@Override
	public String getDes() {
		// TODO Auto-generated method stub 
		return pancake.getDes()+"鸡柳";
	}
}
