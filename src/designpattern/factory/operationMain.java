package designpattern.factory;

public class operationMain {
	public static void main(String[] args) {
		String strA = "10";
		String strB = "20";
		String operator = "*1";
		//从工厂中获取对应的对象
		Operation operation = OperationFactory.CreateOperation(operator);
		operation.strA = strA;
		operation.strB = strB;
		System.out.println(operation.getResult());
	}
}
