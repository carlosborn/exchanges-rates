package br.ceborn.exchange;

import br.ceborn.exchange.configurations.ExchangeRateConfiguration;
import br.ceborn.exchange.connections.ExchangeRate;
import br.ceborn.exchange.enums.CurrencyBase;

import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        ExchangeRate exchangeRate = new ExchangeRate(new ExchangeRateConfiguration());

        Calendar c = Calendar.getInstance();
        c.set(2024, Calendar.DECEMBER, 29);

        Date data1 = c.getTime();
        CurrencyBase[] cr = new CurrencyBase[3];
        cr[0] = CurrencyBase.AUD;
        cr[1] = CurrencyBase.BRL;
        cr[2] = CurrencyBase.EUR;

        System.out.println(exchangeRate.getExchange(data1, new Date(), CurrencyBase.USD, cr).toJSON());
    }
}
