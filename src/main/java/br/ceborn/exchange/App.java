package br.ceborn.exchange;

import br.ceborn.exchange.configurations.ExchangeRateConfiguration;
import br.ceborn.exchange.connections.ExchangeRate;
import br.ceborn.exchange.enums.CurrencyBase;

import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        ExchangeRate exchangeRate = new ExchangeRate(new ExchangeRateConfiguration());

        System.out.println(exchangeRate.getAvailableCurrencies().toJSON().toString());
    }
}
