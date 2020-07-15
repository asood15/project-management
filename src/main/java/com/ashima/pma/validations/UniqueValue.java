package com.ashima.pma.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy=UniqueValidator.class)
public @interface UniqueValue {

	String message() default "Unique Constraint violated";
	
	Class<?>[] groups() default{};
	Class<? extends Payload> [] payload() default{};
  }
