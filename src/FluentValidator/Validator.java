package FluentValidator;

import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

public class Validator<T> extends ValidatorHandler<T>{
	@Override
	public boolean validate(ValidatorContext context, T t) {
		System.out.println("我是Validator父类");
		return super.validate(context, t);
	}
}
