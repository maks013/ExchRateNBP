package com.exchratenbp.domain.currency;

import java.util.HashMap;
import java.util.Map;

class CurrencyRateFetcherImpl implements CurrencyRateFetcher {

    Map<String, Double> inMemoryCurrencyValues = new HashMap<>();

    CurrencyRateFetcherImpl() {
        inMemoryCurrencyValues.put("USD", 3.95);
        inMemoryCurrencyValues.put("GBP", 5.02);
        inMemoryCurrencyValues.put("EUR", 4.25);
    }

    @Override
    public double fetchCurrencyRate(String currencyCode) {
        return inMemoryCurrencyValues.get(currencyCode);
    }
}
