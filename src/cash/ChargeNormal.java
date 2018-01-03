package cash;

/**
 * 
 * 正常收费
 * 
 */
public class ChargeNormal extends Charge {
	double money;
	public ChargeNormal(double money) {
		this.money = money;
	}
	@Override
	public double getReturn() {
		// TODO Auto-generated method stub
		return money;
	}

}
