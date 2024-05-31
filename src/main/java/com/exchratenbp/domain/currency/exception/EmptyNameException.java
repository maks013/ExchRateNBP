package com.exchratenbp.domain.currency.exception;

public class EmptyNameException extends RuntimeException {
    public EmptyNameException() {
        super("Name can not be empty or null");
    }
}
