package org.exchange;

import org.exchange.configuration.ExchangeRateConfiguration;
import org.exchange.connection.ExchangeRate;

public class App {
    public static void main(String[] args) {
        ExchangeRate exchangeRate = new ExchangeRate(new ExchangeRateConfiguration());
        exchangeRate.getInfos();
    }
}
