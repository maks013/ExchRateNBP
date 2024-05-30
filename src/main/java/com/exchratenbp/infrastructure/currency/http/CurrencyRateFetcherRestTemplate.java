package com.exchratenbp.infrastructure.currency.http;

import com.exchratenbp.domain.currency.CurrencyRateFetcher;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Log4j2
public class CurrencyRateFetcherRestTemplate implements CurrencyRateFetcher {

    private final RestTemplate restTemplate;
    private final String uri;

    @Override
    public double fetchCurrencyRate(String currencyCode) {
        String url = UriComponentsBuilder.fromHttpUrl(uri).toUriString();

        try {
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Map<String, Object>>>() {}
            );

            return Objects.requireNonNull(response.getBody())
                    .stream()
                    .flatMap(table -> ((List<Map<String, Object>>) table.get("rates")).stream())
                    .filter(rate -> currencyCode.equals(rate.get("code")))
                    .map(rate -> (double) rate.get("mid"))
                    .findFirst()
                    .orElseThrow(() -> {
                        log.info("Currency code not found: " + currencyCode);
                        return new ResponseStatusException(HttpStatus.NOT_FOUND);
                    });

        } catch (Exception e) {
            log.error("Fetching currency rate failed: " + e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to fetch currency rate", e);
        }
    }
}
