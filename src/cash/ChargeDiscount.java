package cash;

/**
 * 
 *  折扣 
 *
 */
public class ChargeDiscount extends Charge{
	double money;
	double discount;
	/**
	 * 初始化
	 * money 原价
	 * discount 折扣(如0.8 折)
	 */
	public ChargeDiscount(double money,double discount) {
		this.money = money;
		this.discount = discount;
	}
	@Override
	public double getReturn() {
		return money * discount;
	}

}
