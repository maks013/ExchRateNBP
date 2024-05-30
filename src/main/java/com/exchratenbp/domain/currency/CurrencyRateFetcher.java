package com.exchratenbp.domain.currency;

public interface CurrencyRateFetcher {
    double fetchCurrencyRate(String currencyCode);
}
