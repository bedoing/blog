package org.bedoing.blog.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
/**
 * 敏感词过滤
 *
 */
public class WordsValidator implements ConstraintValidator<Words, String> {
	private String[] words = {"aaa", "sss", "ddd", "fff"};
	
	@Override
	public void initialize(Words wordsAnnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isBlank(value)) {
			return true;
		}
		
		String val = StringUtils.trim(value);
		for (String word : words) {
			if(val.contains(word)){
				return false;
			}
		}
		return true;
	}
}
