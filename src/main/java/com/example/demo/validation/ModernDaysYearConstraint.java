package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ModernDaysYearConstraintValidator.class)
public @interface ModernDaysYearConstraint {
    String message() default "{ModernDaysYearConstraint.MovieDTO.ReleaseYear}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
