package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.dto.CurrencyRequestDto;
import com.exchratenbp.domain.currency.dto.CurrencyResponse;
import com.exchratenbp.domain.currency.dto.CurrencyValueRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CurrencyFacade {

    private final CurrencyRepository currencyRepository;
    private final CurrencyService currencyService;

    public List<CurrencyRequestDto> findAllCurrencyRequests() {
        return currencyRepository.findAll()
                .stream()
                .map(CurrencyRequest::toDto)
                .toList();
    }

    @Transactional
    public CurrencyResponse getCurrencyValue(CurrencyValueRequestDto currencyValueRequestDto) {

        final CurrencyRequestDto currencyRequestDto = currencyService
                .fetchCurrencyRateValueAndSaveRequest(currencyValueRequestDto).toDto();

        return new CurrencyResponse(currencyRequestDto.value());
    }
}
