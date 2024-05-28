package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.dto.CurrencyRequestDto;

import java.time.LocalDateTime;

class CurrencyRequest {

    private Long id;
    private CurrencyRate currency;
    private String name;
    private LocalDateTime date;
    private Double value;


    CurrencyRequestDto toDto() {
        return CurrencyRequestDto.builder()
                .currency(currency.name())
                .name(name)
                .date(date)
                .value(value)
                .build();
    }
}
