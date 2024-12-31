package br.ceborn.exchange;

import static org.junit.jupiter.api.Assertions.*;

import br.ceborn.exchange.configurations.ConnectionConfiguration;
import br.ceborn.exchange.configurations.ExchangeRateConfiguration;
import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.requests.ExchangeRateRequest;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ExchangeRatesRequest {

    private final ConnectionConfiguration configuration = new ExchangeRateConfiguration();

    @Test
    void mountParametersURL(){

        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.FEBRUARY, 15);

        ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest.ExchangeRateRequestBuilder()
                .setIniDate(c.getTime())
                .setCurrencyBase(CurrencyBase.USD)
                .build();

        assertEquals("2022-02-15?base=USD", exchangeRateRequest.mountParameters());
    }

}
