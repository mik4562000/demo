package com.example.demo.validation;

import com.example.demo.validation.ModernDaysYearConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ModernDaysYearConstraintValidator implements ConstraintValidator<ModernDaysYearConstraint, Integer> {
    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        return year > 1900 && year < 2100;
    }
}
