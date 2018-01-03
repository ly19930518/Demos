package designpattern.factory;
/**
 * 运算工厂类
 *
 */
public class OperationFactory {
	
	public static Operation CreateOperation(String operator){
		Operation operation = null;
		switch (operator) {
		case "+":
			operation = new addOperation();
			break;
		case "-":
			operation = new subOperation();
			break;
		case "*":
			operation = new rediOperation();
			break;
		case "/":
			operation = new exceptOperation();
			break;
		default:
			operation = new Operation();
			break;
		}
		return operation;
	}
	/**
	 * 高内聚低耦合
	 * 
	 * 封装、继承、多态
	 * 
	 * 
	 * 用户类
	 * 基本属性
	 * 管理员
	 * 权限
	 * 普通成员
	 * 
	 * 
	 * 
	 */
}
