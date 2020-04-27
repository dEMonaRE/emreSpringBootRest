package com.emre.spring.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyCustomValidator implements ConstraintValidator<MyStrValidAnnot, String> {

	private MyStrValidAnnot contraintAnno;

	@Override
	public void initialize(MyStrValidAnnot constraintAnnotation) {
		// ConstraintValidator.super.initialize(constraintAnnotation);
		// override etikki özelleştirilen isValid kulanabilelim
		this.contraintAnno = constraintAnnotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// logic burada olmalu
		// value girilen değer buna göre kontrol edilebilir
		// Burada custom validation yaptık
		int len = 0;
		if (this.contraintAnno != null) {
			len = this.contraintAnno.length();
		}
		return value.length() > len;
	}

}
