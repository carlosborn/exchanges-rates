package br.ceborn.exchange.responses;

import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.helpers.DateConverter;
import lombok.Getter;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ExchangeRateSingleDayResponse implements Response {

    private final CurrencyBase base;
    private final Date date;
    private final Map<CurrencyBase, Double> rates;

    public ExchangeRateSingleDayResponse(CurrencyBase base, Date date, JSONObject rates) {
        this.base = base;
        this.date = date;
        this.rates = this.loadRatesFromJSONObject(rates);
    }

    @Override
    public JSONObject toJSON() {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("base", this.base.getSymbol());
            jsonObject.put("date", DateConverter.convertDateToString(this.date));
            jsonObject.put("rates", this.rates);

            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map<CurrencyBase, Double> loadRatesFromJSONObject(JSONObject rates) {
        try {
            Map<CurrencyBase, Double> ratesMap = new HashMap<>();

            for (CurrencyBase currencyBase : CurrencyBase.values()) {

                String symbol = currencyBase.getSymbol();

                // Get the symbol value
                if (rates.has(symbol)) {
                    ratesMap.put(currencyBase, rates.getDouble(symbol));
                }
            }

            return ratesMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.toJSON().toString();
    }
}
