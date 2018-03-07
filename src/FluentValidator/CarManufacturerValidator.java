package FluentValidator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

public class CarManufacturerValidator extends Validator<String>{
	@Override
	public boolean validate(ValidatorContext context, String t) {
		super.validate(context, t);
		System.out.println("验证生产商信息："+t);
		if("".equals(t)){
			System.out.println("生产商错误");
			context.addError(ValidationError.create("生产商不能为空").setErrorCode(100).setField("manufacturer").setInvalidValue(t));
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}
}
