package cash;

/**
 * 根据传入的对象进行计算 
 *
 */
public class Content {
	Charge charge;
	public Content(Charge charge) {
		this.charge = charge;
	}
	public double getReturn(){
		return charge.getReturn();
	}
}
