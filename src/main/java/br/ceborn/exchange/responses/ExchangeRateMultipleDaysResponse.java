package br.ceborn.exchange.responses;

import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.helpers.DateConverter;
import lombok.Getter;
import org.json.JSONObject;

import java.util.*;

@Getter
public class ExchangeRateMultipleDaysResponse implements Response {

    private final Double amount;
    private final CurrencyBase base;
    private final Date startDate;
    private final Date endDate;
    private final Map<String, Map<CurrencyBase, Double>> rates;

    public ExchangeRateMultipleDaysResponse(Double amount, CurrencyBase currencyBase, Date startDate, Date endDate, JSONObject rates) {
        this.amount = amount;
        this.base = currencyBase;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rates = this.loadRatesFromJSONObject(rates);
    }

    @Override
    public JSONObject toJSON() {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("amount", this.amount);
            jsonObject.put("base", this.base.getSymbol());
            jsonObject.put("start_date", DateConverter.convertDateToString(this.startDate));
            jsonObject.put("end_date", DateConverter.convertDateToString(this.endDate));
            jsonObject.put("rates", this.rates);

            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Map<CurrencyBase, Double>> loadRatesFromJSONObject(JSONObject jsonObject) {
        try {
            Date dateKey = this.startDate;

            Map<String, Map<CurrencyBase, Double>> ratesMap = new HashMap<>();

            Iterator<String> dates = jsonObject.keys();
            while (dates.hasNext()) {

                String dateFormat = dates.next();

                JSONObject rates = jsonObject.getJSONObject(dateFormat);

                ratesMap.put(dateFormat, this.loadRates(rates));

                dateKey = this.addOneDayInDate(dateKey);
            }

            return ratesMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Map<CurrencyBase, Double> loadRates(JSONObject rates) {
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

    private Date addOneDayInDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    public String toString() {
        return this.toJSON().toString();
    }
}
