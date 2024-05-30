package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.dto.CurrencyValueRequestDto;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class CurrencyService {

    private final CurrencyRateFetcher currencyRateFetcher;
    private final CurrencyRepository currencyRepository;

    CurrencyRequest fetchCurrencyRateValueAndSaveRequest(CurrencyValueRequestDto currencyValueRequestDto) {

        final String currencyCode = currencyValueRequestDto.currency();

        CurrencyCodeValidator.isCurrencyCodeValid(currencyCode);

        final CurrencyRequest currencyRequest = CurrencyRequest.builder()
                .name(currencyValueRequestDto.name())
                .currency(currencyCode)
                .date(LocalDateTime.now())
                .value(fetchCurrencyRate(currencyCode))
                .build();

        return currencyRepository.save(currencyRequest);
    }

    private double fetchCurrencyRate(String currencyCode) {
        return currencyRateFetcher.fetchCurrencyRate(currencyCode);
    }
}
