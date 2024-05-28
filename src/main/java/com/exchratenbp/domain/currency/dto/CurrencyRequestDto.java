package com.exchratenbp.domain.currency.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CurrencyRequestDto(
        String currency,
        String name,
        LocalDateTime date,
        double value
) {
}
