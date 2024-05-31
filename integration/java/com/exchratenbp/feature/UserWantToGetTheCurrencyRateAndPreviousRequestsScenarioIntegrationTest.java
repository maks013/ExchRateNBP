package com.exchratenbp.feature;

import com.exchratenbp.BaseIntegrationTest;
import com.exchratenbp.domain.currency.dto.CurrencyRequestDto;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserWantToGetTheCurrencyRateAndPreviousRequestsScenarioIntegrationTest
        extends BaseIntegrationTest
        implements ExampleJson {

    private static final String GET_CURRENCY_RATE_PATH = "/currencies/get-current-currency-value-command";
    private static final String GET_REQUESTS_PATH = "/currencies/requests";

    @Test
    void user_should_get_currency_rate_and_previous_requests_all_steps() throws Exception {

        /* 1. User attempts to get currency rate by currency code equals null
              and gets response 400 - BAD REQUEST  */

        // given, when
        ResultActions nullCurrencyCode = mockMvc.perform(post(GET_CURRENCY_RATE_PATH)
                .content(currencyRequestBodyWithNullCode().trim())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        nullCurrencyCode.andExpect(status().isBadRequest());

        /* 2. User attempts to get currency rate by empty currency code
              and gets response 400 - BAD REQUEST  */

        // given, when
        ResultActions emptyCurrencyCode = mockMvc.perform(post(GET_CURRENCY_RATE_PATH)
                .content(currencyRequestBodyWithEmptyCode().trim())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        emptyCurrencyCode.andExpect(status().isBadRequest());

        /* 3. User attempts to get currency rate with name equals null
              and gets response 400 - BAD REQUEST  */

        // given, when
        ResultActions nullName = mockMvc.perform(post(GET_CURRENCY_RATE_PATH)
                .content(currencyRequestBodyWithNullName().trim())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        nullName.andExpect(status().isBadRequest());

        /* 4. User attempts to get currency rate with empty name
              and gets response 400 - BAD REQUEST  */

        // given, when
        ResultActions emptyName = mockMvc.perform(post(GET_CURRENCY_RATE_PATH)
                .content(currencyRequestBodyWithEmptyName().trim())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        emptyName.andExpect(status().isBadRequest());

        /* 5. User attempts to get currency rate with invalid currency code
              and gets response 400 - BAD REQUEST  */

        // given, when
        ResultActions invalidCode = mockMvc.perform(post(GET_CURRENCY_RATE_PATH)
                .content(currencyRequestBodyWithInvalidCode().trim())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        invalidCode.andExpect(status().isBadRequest());


        /* 6. User attempts to get currency rate with correct request body
              and gets response 200 - OK  */

        // given, when
        ResultActions correctRequest = mockMvc.perform(post(GET_CURRENCY_RATE_PATH)
                .content(currencyRequestBody().trim())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        correctRequest.andExpect(status().isOk());

        /* 7. User attempts to get currency requests
              and gets response 200 - OK
              with response body includes latest request */

        // given, when
        ResultActions getRequests = mockMvc.perform(get(GET_REQUESTS_PATH)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        // then
        String requests = getRequests.andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        List<CurrencyRequestDto> requestsResult = objectMapper.readValue(requests, new TypeReference<List<CurrencyRequestDto>>() {
        });
        assertThat(requestsResult).hasSize(1);

    }

}
