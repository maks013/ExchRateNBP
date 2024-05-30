package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.dto.CurrencyRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
class CurrencyRequest {

    private Long id;
    private String currency;
    private String name;
    private LocalDateTime date;
    private Double value;


    CurrencyRequestDto toDto() {
        return CurrencyRequestDto.builder()
                .currency(currency)
                .name(name)
                .date(date.toString())
                .value(value)
                .build();
    }
}
