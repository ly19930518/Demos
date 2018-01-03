package designpattern.factory;

public class rediOperation extends Operation{
	@Override
	public double getResult() {
		// TODO Auto-generated method stub
		return Double.parseDouble(strA) * Double.parseDouble(strB);
	}
}
