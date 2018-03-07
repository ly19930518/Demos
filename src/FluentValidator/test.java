package FluentValidator;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.ValidationError;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
public class test {
	public static void main(String[] args) {
		Car car = new Car();
		car.setManufacturer("");
		car.setLicensePlate("SB00001");
		car.setSeatCount(2);
		Result result = FluentValidator.checkAll()
				.on(car.getSeatCount(), new CarSeatCountValidator())
				.on(car.getManufacturer(), new CarManufacturerValidator())
				.doValidate()
				.result(toSimple());//toSimple 静态方式 需要先导入  import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;
		ComplexResult complexResult = FluentValidator.checkAll()
				.on(car.getSeatCount(), new CarSeatCountValidator())
				.on(car.getManufacturer(), new CarManufacturerValidator())
				.doValidate()
				.result(toComplex());//toSimple 静态方式 需要先导入  import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;
		
		System.out.println(complexResult);
		System.out.println(complexResult.isSuccess());
		for(ValidationError res : complexResult.getErrors()){
			System.out.println(res.getErrorMsg());
			System.out.println(res.getErrorCode());
			System.out.println(res.getInvalidValue());
		}
	}
}
