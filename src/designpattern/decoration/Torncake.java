package designpattern.decoration;

public class Torncake extends Pancake{
	
	public Torncake(String name) {
		this.name  = name;
	}
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 4.0d;
	}

}
