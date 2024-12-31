package br.ceborn.exchange.responses;

import br.ceborn.exchange.enums.CurrencyBase;
import org.json.JSONObject;

public class AvailableCurrenciesResponse implements Response {

    private final CurrencyBase[] currencyBases;

    public AvailableCurrenciesResponse(CurrencyBase[] currencyBases) {
        this.currencyBases = currencyBases;
    }

    @Override
    public JSONObject toJSON() {
        try {
            JSONObject jsonObject = new JSONObject();

            for (CurrencyBase cr : this.currencyBases) {
                jsonObject.put(cr.getSymbol(), cr.getDescription());
            }

            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.toJSON().toString();
    }
}
