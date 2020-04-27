package com.emre.spring.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//tüm rest classlarındaki exceptionlar buraya düşer
//GENEL EXP HANDLER - Rest controllerin tamamı için + projedekilerin tamamı
//bu yapıda özel exp atamıyoruz
@RestControllerAdvice
public class MyExceptionHandler {
	// neleri handle edeceksem anotatione ekle
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDTO> handleException(final Exception exp) {
		ErrorDTO errDto = new ErrorDTO(exp.getMessage(), 1923);
		if (exp instanceof IllegalArgumentException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errDto);
		} else if (exp instanceof IllegalStateException) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errDto);
		} else if (exp instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException) exp;
			List<ObjectError> allErrors = manve.getBindingResult().getAllErrors();
			for (ObjectError objectErrorLoc : allErrors) {
				errDto.addErrorObjs(new ErrorDTO(objectErrorLoc.getDefaultMessage(), 1111));
			}
			errDto.setErrorDesc("validation error");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errDto);
		} else {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errDto);

		}
	}
}
