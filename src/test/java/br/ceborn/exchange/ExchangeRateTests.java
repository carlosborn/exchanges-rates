package br.ceborn.exchange;

import static org.junit.jupiter.api.Assertions.*;

import br.ceborn.exchange.configurations.ExchangeRateConfiguration;
import br.ceborn.exchange.connections.ExchangeRate;
import br.ceborn.exchange.responses.AvailableCurrenciesResponse;
import br.ceborn.exchange.responses.ExchangeRateMultipleDaysResponse;
import br.ceborn.exchange.responses.ExchangeRateSingleDayResponse;
import br.ceborn.exchange.responses.InfoResponse;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ExchangeRateTests {

    private final ExchangeRate exchangeRate = new ExchangeRate(new ExchangeRateConfiguration());

    @Test
    void getLatest() {
        assertInstanceOf(ExchangeRateSingleDayResponse.class, exchangeRate.getLatestExchange());
    }

    @Test
    void getExchangeSingleDay(){
        Date date = new Date();
        assertInstanceOf(ExchangeRateSingleDayResponse.class, exchangeRate.getExchange(date));
    }

    @Test
    void getExchangeMultipleDays(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.FEBRUARY, 15);

        Date dateIni = calendar.getTime();

        calendar.set(2022, Calendar.FEBRUARY, 17);
        Date dateEnd = calendar.getTime();

        assertInstanceOf(ExchangeRateMultipleDaysResponse.class, exchangeRate.getExchange(dateIni, dateEnd));
    }

    @Test
    void getAvailableCurrenciesResponse(){
        assertInstanceOf(AvailableCurrenciesResponse.class, exchangeRate.getAvailableCurrencies());
    }

    @Test
    void getInfoResponse(){
        assertInstanceOf(InfoResponse.class, exchangeRate.getInfos());
    }

}
