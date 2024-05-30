package com.exchratenbp.infrastructure.currency.controller;

import com.exchratenbp.domain.currency.CurrencyFacade;
import com.exchratenbp.domain.currency.dto.CurrencyRequestDto;
import com.exchratenbp.domain.currency.dto.CurrencyResponse;
import com.exchratenbp.domain.currency.dto.CurrencyValueRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    @PostMapping("/get-current-currency-value-command")
    ResponseEntity<CurrencyResponse> getCurrentCurrencyValue(@RequestBody
                                                             CurrencyValueRequestDto currencyValueRequestDto) {
        CurrencyResponse currencyResponse = currencyFacade.getCurrencyValue(currencyValueRequestDto);

        return ResponseEntity.ok(currencyResponse);
    }

    @GetMapping("/requests")
    ResponseEntity<List<CurrencyRequestDto>> getAllCurrencyRequests() {

        List<CurrencyRequestDto> currencyRequestDtoList = currencyFacade.findAllCurrencyRequests();

        return ResponseEntity.ok(currencyRequestDtoList);
    }

}
