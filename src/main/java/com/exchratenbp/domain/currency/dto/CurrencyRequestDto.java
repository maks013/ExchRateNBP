package com.exchratenbp.domain.currency.dto;

import lombok.Builder;

@Builder
public record CurrencyRequestDto(
        String currency,
        String name,
        String date,
        double value
) {
}
