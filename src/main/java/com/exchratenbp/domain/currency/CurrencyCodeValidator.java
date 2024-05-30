package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.exception.InvalidCurrencyException;

public enum CurrencyCodeValidator {

    THB, USD, AUD, HKD, CAD, NZD, SGD,
    EUR, HUF, CHF, GBP, UAH, JPY, CZK,
    DKK, ISK, NOK, SEK, RON, BGN, TRY,
    ILS, CLP, PHP, MXN, ZAR, BRL, MYR,
    IDR, INR, KRW, CNY, XDR;

    public static void isCurrencyCodeValid(String currency) {
        try {
            CurrencyCodeValidator.valueOf(currency.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new InvalidCurrencyException(currency);
        }
    }
}
