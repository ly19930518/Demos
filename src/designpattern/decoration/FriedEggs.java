package designpattern.decoration;

public class FriedEggs extends Condiment{
	private Pancake pancake;
	public FriedEggs(Pancake pancake) {
		this.pancake = pancake;
	}
	@Override
	public String getDes() {
		System.out.println(this.getClass()+" "+pancake.name);
		return pancake.getDes() +" 煎蛋";
		
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return pancake.getPrice() +2.0d;
	}

}
