package com.wutreg.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

    private String endOfEmail;

    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        endOfEmail = constraintAnnotation.value();
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext context) {

        return enteredValue.endsWith(endOfEmail);
    }
}
