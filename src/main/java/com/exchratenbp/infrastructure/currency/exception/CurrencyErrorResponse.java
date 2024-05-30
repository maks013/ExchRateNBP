package com.exchratenbp.infrastructure.currency.exception;

import org.springframework.http.HttpStatus;

public record CurrencyErrorResponse(String message,
                                    HttpStatus status
) {
}
