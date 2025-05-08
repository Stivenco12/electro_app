package com.electroapp.electro_app.infrastructure.Utils.Validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistsByCountrynameValidation.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsByCountryname {
    String message() default "Country name already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
