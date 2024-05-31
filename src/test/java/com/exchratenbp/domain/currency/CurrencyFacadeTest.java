package com.exchratenbp.domain.currency;

import com.exchratenbp.domain.currency.dto.CurrencyResponse;
import com.exchratenbp.domain.currency.dto.CurrencyValueRequestDto;
import com.exchratenbp.domain.currency.exception.EmptyNameException;
import com.exchratenbp.domain.currency.exception.InvalidCurrencyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CurrencyFacadeTest {

    private final InMemoryCurrencyRepository inMemRepo = new InMemoryCurrencyRepository();
    private final CurrencyRateFetcherImpl fetcher = new CurrencyRateFetcherImpl();

    private final CurrencyFacade currencyFacade = new CurrencyFacade(
            inMemRepo,
            new CurrencyService(fetcher, inMemRepo)
    );

    private final CurrencyRequest currencyRequest1 =
            new CurrencyRequest(1L, "USD", "Jan Kowalski", LocalDateTime.now(), 3.95);
    private final CurrencyRequest currencyRequest2 =
            new CurrencyRequest(2L, "EUR", "Kamil Nowak", LocalDateTime.now(), 4.25);
    private final CurrencyRequest currencyRequest3 =
            new CurrencyRequest(3L, "GBP", "Filip Kowal", LocalDateTime.now(), 5.02);

    @BeforeEach
    void addCurrencyRequests() {
        inMemRepo.addCurrencyRequest(currencyRequest1);
        inMemRepo.addCurrencyRequest(currencyRequest2);
        inMemRepo.addCurrencyRequest(currencyRequest3);
    }

    @Test
    void should_find_all_currency_requests() {

        // given
        final int sizeOfAllCurrencyRequests =
                currencyFacade.findAllCurrencyRequests().size();
        // when
        // then
        assertEquals(3, sizeOfAllCurrencyRequests);
    }

    @Test
    void should_throw_exception_when_user_try_to_get_invalid_code_currency_value() {

        // given
        final String invalidCode = "EXAMPLE";
        CurrencyValueRequestDto currencyValueRequestDto = new CurrencyValueRequestDto(
                invalidCode,
                "John Doe"
        );

        // when
        // then
        assertThrows(InvalidCurrencyException.class,
                () -> currencyFacade.getCurrencyValue(currencyValueRequestDto),
                "Invalid currency code:" + invalidCode);
    }

    @Test
    void should_get_currency_value() {

        // given
        CurrencyValueRequestDto currencyValueRequestDto = new CurrencyValueRequestDto(
                "USD",
                "John Doe"
        );

        // when
        CurrencyResponse currencyResponse = currencyFacade.getCurrencyValue(currencyValueRequestDto);

        // then
        assertEquals(3.95, currencyResponse.value());
    }

    @Test
    void should_throw_exception_when_user_try_to_get_currency_with_empty_name() {

        // given
        CurrencyValueRequestDto currencyValueRequestDto = new CurrencyValueRequestDto(
                "USD",
                ""
        );

        // when
        // then
        assertThrows(EmptyNameException.class, () -> currencyFacade.getCurrencyValue(currencyValueRequestDto),
                "Name can not be empty or null");
    }

    @Test
    void should_throw_exception_when_user_try_to_get_currency_with_name_equals_null() {

        // given
        CurrencyValueRequestDto currencyValueRequestDto = CurrencyValueRequestDto.builder()
                .currency("USD")
                .build();

        // when
        // then
        assertThrows(EmptyNameException.class, () -> currencyFacade.getCurrencyValue(currencyValueRequestDto),
                "Name can not be empty or null");
    }

    @Test
    void should_throw_exception_when_user_try_to_get_currency_value_with_empty_code() {

        // given
        final String emptyCode = "";

        CurrencyValueRequestDto currencyValueRequestDto = new CurrencyValueRequestDto(
                emptyCode,
                "John Doe"
        );

        // when
        // then
        assertThrows(InvalidCurrencyException.class, () -> currencyFacade.getCurrencyValue(currencyValueRequestDto),
                "Invalid currency code: " + "empty or null");
    }

    @Test
    void should_throw_exception_when_user_try_to_get_currency_value_with_code_equals_null() {

        // given
        CurrencyValueRequestDto currencyValueRequestDto = CurrencyValueRequestDto.builder()
                .name("John Doe")
                .build();

        // when
        // then
        assertThrows(InvalidCurrencyException.class, () -> currencyFacade.getCurrencyValue(currencyValueRequestDto),
                "Invalid currency code: " + "empty or null");
    }
}
