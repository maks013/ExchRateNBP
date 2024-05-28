package com.exchratenbp.domain.currency;

import java.util.List;

interface CurrencyRepository {

    CurrencyRequest save(CurrencyRequest currencyRequest);

    List<CurrencyRequest> findAll();

}
