package org.bedoing.blog.validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;


public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirm, Object> {
	private String field;
	private String verifyField;
	
	@Override
	public void initialize(PasswordConfirm passwordConfirm) {
		this.field = passwordConfirm.filed();
		this.verifyField = passwordConfirm.verifyFiled();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			String fieldVal = BeanUtils.getProperty(value, field);
			String verifyFieldVal = BeanUtils.getProperty(value, verifyField);
			if(fieldVal == null && verifyFieldVal == null){
				return true;
			}
			
			if(fieldVal != null && !fieldVal.equals(verifyFieldVal)){
				String messageTemplate = context.getDefaultConstraintMessageTemplate();
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(messageTemplate)
				.addNode(verifyField).addConstraintViolation();
				
				return false;
			}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
