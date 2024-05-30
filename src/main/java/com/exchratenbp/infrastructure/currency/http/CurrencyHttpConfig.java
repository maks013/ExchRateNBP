package com.exchratenbp.infrastructure.currency.http;

import com.exchratenbp.domain.currency.CurrencyRateFetcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class CurrencyHttpConfig {

    @Bean
    public ResponseErrorHandler restTemplateResponseErrorHandler() {
        return new ResponseErrorHandler();
    }

    @Bean
    public RestTemplate restTemplate(@Value("${currency.http.client.config.connectionTimeout:1000}") long connectionTimeout,
                                     @Value("${currency.http.client.config.readTimeout:1000}") long readTimeout,
                                     ResponseErrorHandler responseErrorHandler) {
        return new RestTemplateBuilder()
                .errorHandler(responseErrorHandler)
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
    }

    @Bean
    public CurrencyRateFetcher remoteOfferClient(RestTemplate restTemplate,
                                                 @Value("${currency.http.client.config.uri}") String uri) {
        return new CurrencyRateFetcherRestTemplate(restTemplate, uri);
    }
}
