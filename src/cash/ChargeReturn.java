package cash;

public class ChargeReturn extends Charge{
	/**
	 * 满减计费
	 */
	double money;
	double returnmoney;
	double ifmoney;
	public ChargeReturn(double money,double returnmoney,double ifmoney) {
		this.money = money;
		this.returnmoney = returnmoney;
		this.ifmoney = ifmoney;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getReturn() {
		// TODO Auto-generated method stub
		return money >= ifmoney ?  money - returnmoney : money ;
	}

}
