package com.exchratenbp.domain.currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyFacadeConfig {

    @Bean
    CurrencyFacade currencyFacade(CurrencyRateFetcher fetcher,
                                  CurrencyRepository repository) {
        CurrencyService service = new CurrencyService(fetcher, repository);
        return new CurrencyFacade(repository, service);
    }
}
