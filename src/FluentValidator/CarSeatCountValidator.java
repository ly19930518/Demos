package FluentValidator;

import com.baidu.unbiz.fluentvalidator.ValidateCallback;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 验证座位数
 * @author tlj
 *
 */
public class CarSeatCountValidator extends ValidatorHandler<Integer> implements Validator<Integer>{
	@Override
	public boolean validate(ValidatorContext context, Integer t) {
		System.out.println("座位数："+t);
		if(t < 2){
			System.out.println(t);
			context.addError(ValidationError.create("你的是自行车吗?").setErrorCode(100).setField("seatCount").setInvalidValue(t));// 错误信息、错误码、属性/字段、错误值
			return false;
		}
		return true;
	}
}
