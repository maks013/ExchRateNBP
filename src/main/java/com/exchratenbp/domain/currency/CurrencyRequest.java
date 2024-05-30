package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.dto.CurrencyRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "currency_requests")
@NoArgsConstructor
@AllArgsConstructor
class CurrencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;
    private String name;
    private LocalDateTime date;
    private Double currencyValue;


    CurrencyRequestDto toDto() {
        return CurrencyRequestDto.builder()
                .currency(currency)
                .name(name)
                .date(date.toString())
                .value(currencyValue)
                .build();
    }
}
