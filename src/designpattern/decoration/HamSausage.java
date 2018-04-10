package designpattern.decoration;

public class HamSausage extends Condiment{
	private Pancake pancake;
	public HamSausage(Pancake pancake) {
		this.pancake = pancake;
	}
	@Override
	public String getDes() {
		System.out.println(this.getClass()+""+pancake.name);
		// TODO Auto-generated method stub
		return pancake.getDes() +" 火腿肠";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return pancake.getPrice() + 2.5d;
	}

}
