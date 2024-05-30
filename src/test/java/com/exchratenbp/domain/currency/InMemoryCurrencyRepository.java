package com.exchratenbp.domain.currency;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryCurrencyRepository implements CurrencyRepository {

    Map<Long, CurrencyRequest> inMemoryDb = new ConcurrentHashMap<>();

    @Override
    public CurrencyRequest save(CurrencyRequest currencyRequest) {

        final long id = inMemoryDb.size() + 1L;

        currencyRequest.setId(id);
        inMemoryDb.put(id, currencyRequest);

        return currencyRequest;
    }

    @Override
    public List<CurrencyRequest> findAll() {
        return inMemoryDb.values()
                .stream()
                .toList();
    }

    public void addCurrencyRequest(CurrencyRequest currencyRequest) {
        inMemoryDb.put(currencyRequest.getId(), currencyRequest);
    }
}
