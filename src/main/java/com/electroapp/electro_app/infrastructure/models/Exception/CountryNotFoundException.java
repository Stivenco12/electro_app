package com.electroapp.electro_app.infrastructure.models.Exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String message) {
        super(message);
    }
}
