package com.exchratenbp.infrastructure.currency.exception;

import com.exchratenbp.domain.currency.exception.InvalidCurrencyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CurrencyControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCurrencyException.class)
    @ResponseBody
    public CurrencyErrorResponse handleC(InvalidCurrencyException invalidCurrencyException) {
        return new CurrencyErrorResponse(invalidCurrencyException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
