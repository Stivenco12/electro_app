package com.electroapp.electro_app.infrastructure.Utils.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import com.electroapp.electro_app.application.services.ICountryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByCountrynameValidation implements ConstraintValidator<ExistsByCountryname, String> {
    @Autowired
    private ICountryService countryService;

    @Override
    public boolean isValid(String countryName, ConstraintValidatorContext context) {
        if (countryService == null) {
            return true;
        }
        return countryService.existsByCountryname(countryName);
    }
}
