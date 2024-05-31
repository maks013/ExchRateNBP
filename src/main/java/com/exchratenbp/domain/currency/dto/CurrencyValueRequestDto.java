package com.exchratenbp.domain.currency.dto;

import lombok.Builder;

@Builder
public record CurrencyValueRequestDto(
        String currency,
        String name
) {
}
