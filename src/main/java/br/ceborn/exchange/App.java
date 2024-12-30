package br.ceborn.exchange;

import br.ceborn.exchange.configurations.ExchangeRateConfiguration;
import br.ceborn.exchange.connections.ExchangeRate;

public class App {
    public static void main(String[] args) {
        ExchangeRate exchangeRate = new ExchangeRate(new ExchangeRateConfiguration());
        exchangeRate.getInfos();
    }
}
