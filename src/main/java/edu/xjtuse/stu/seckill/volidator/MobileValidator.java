package edu.xjtuse.stu.seckill.volidator;

import edu.xjtuse.stu.seckill.utils.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<edu.xjtuse.stu.seckill.volidator.Mobile, String> {

	private boolean required = false;
	
	public void initialize(edu.xjtuse.stu.seckill.volidator.Mobile constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return ValidatorUtil.isMobile(value);
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else {
				return ValidatorUtil.isMobile(value);
			}
		}
	}

}
