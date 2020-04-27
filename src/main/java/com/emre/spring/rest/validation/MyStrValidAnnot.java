package com.emre.spring.rest.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//annotasyon extends edemez
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = MyCustomValidator.class)
public @interface MyStrValidAnnot {

	// bunu zorunlu tuttuk
	int length();

	String message() default "Yeni yazdıgımız String validasyonu patladı";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
