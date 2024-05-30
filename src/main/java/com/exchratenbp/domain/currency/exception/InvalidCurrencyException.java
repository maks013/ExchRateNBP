package com.exchratenbp.domain.currency.exception;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String currency) {
        super("Invalid currency code: " + currency);
    }
}
