package br.ceborn.exchange.mappers;

import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.helpers.DateConverter;
import br.ceborn.exchange.responses.ExchangeRateMultipleDaysResponse;
import br.ceborn.exchange.responses.ExchangeRateSingleDayResponse;
import br.ceborn.exchange.responses.Response;
import org.json.JSONObject;

public class ExchangeRateMapper implements Mapper {

    private Response response;

    @Override
    public void fromJSON(JSONObject json) {
        try {

            // If the JSON has 'date' in body, it's a single day and have a little differences between each other
            if (json.has("date")) {
                this.loadExchangeRateSingleDayResponse(json);
                return;
            }

            this.loadExchangeRateMultipleDaysResponse(json);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fromJSON(String json) {
        try {
            this.fromJSON(new JSONObject(json));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Response getLoadedResponse() {
        return this.response;
    }

    private void loadExchangeRateSingleDayResponse(JSONObject jsonObject) {
        try {
            this.response = new ExchangeRateSingleDayResponse(
                    CurrencyBase.getBySymbol(jsonObject.getString("base")),
                    DateConverter.convertStringToDate(jsonObject.getString("date")),
                    jsonObject.getJSONObject("rates")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadExchangeRateMultipleDaysResponse(JSONObject jsonObject) {
        try {
            this.response = new ExchangeRateMultipleDaysResponse(
                    jsonObject.getDouble("amount"),
                    CurrencyBase.getBySymbol(jsonObject.getString("base")),
                    DateConverter.convertStringToDate(jsonObject.getString("start_date")),
                    DateConverter.convertStringToDate(jsonObject.getString("end_date")),
                    jsonObject.getJSONObject("rates")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
