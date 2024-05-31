package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.exception.InvalidCurrencyException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CurrencyCodeValidator {

    private static final Set<String> VALID_CURRENCIES =
            new HashSet<>(Arrays.asList(
                    "THB", "USD", "AUD", "HKD", "CAD", "NZD", "SGD",
                    "EUR", "HUF", "CHF", "GBP", "UAH", "JPY", "CZK",
                    "DKK", "ISK", "NOK", "SEK", "RON", "BGN", "TRY",
                    "ILS", "CLP", "PHP", "MXN", "ZAR", "BRL", "MYR",
                    "IDR", "INR", "KRW", "CNY", "XDR"
            ));

    static void isCurrencyCodeValid(String currency) {
        if (currency != null && !currency.isEmpty()) {
            if (!VALID_CURRENCIES.contains(currency.toUpperCase())) {
                throw new InvalidCurrencyException(currency);
            }
        } else {
            throw new InvalidCurrencyException("empty or null");
        }
    }
}
