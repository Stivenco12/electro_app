package com.electroapp.electro_app.infrastructure.exceptionController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import com.electroapp.electro_app.infrastructure.models.ErrorCustom;
import com.electroapp.electro_app.infrastructure.models.Exception.CountryNotFoundException;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorCustom> notFoundEx(NoResourceFoundException e) { 
        ErrorCustom error = new ErrorCustom();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class,CountryNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> ContryNotFoundException(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "el usuario no existe o no fue encontrado!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }
}
