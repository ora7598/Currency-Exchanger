package com.jb.currencyexchanger.advice;

import com.jb.currencyexchanger.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CurrencyControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails handleCurrencyException(Exception e) {
        return new ErrorDetails("currency_not_found", e.getMessage(), HttpStatus.NOT_FOUND.value());
    }
}
