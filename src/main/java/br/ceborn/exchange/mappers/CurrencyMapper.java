package br.ceborn.exchange.mappers;

import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.responses.AvailableCurrenciesResponse;
import br.ceborn.exchange.responses.Response;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencyMapper implements Mapper {

    private Response response;

    @Override
    public void fromJSON(JSONObject json) {
        try {
            this.response = new AvailableCurrenciesResponse(this.getAllCurrencies(json));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fromJSON(String json) {
        this.fromJSON(new JSONObject(json));
    }

    @Override
    public Response getLoadedResponse() {
        return this.response;
    }

    private CurrencyBase[] getAllCurrencies(JSONObject json) {
        Iterator<String> iterator = json.keys();
        List<CurrencyBase> currencies = new ArrayList<>();

        while (iterator.hasNext()) {

            String symbol = iterator.next();
            String description = json.getString(symbol);

            CurrencyBase currencyBase = CurrencyBase.getBySymbol(symbol);
            if (currencyBase == null) {
                continue;
            }

            currencies.add(currencyBase);
        }

        return currencies.toArray(new CurrencyBase[0]);
    }
}
