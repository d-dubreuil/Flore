package flore.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import flore.model.Flore;


public class FloreValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Flore.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Flore flore = (Flore) target;

	}

}