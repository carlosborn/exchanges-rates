package br.ceborn.exchange.configurations;

import org.json.JSONObject;

public class ExchangeRateConfiguration implements ConnectionConfiguration{

    private JSONObject response;

    @Override
    public String getBaseURL() {
        return "https://api.frankfurter.dev/";
    }

    @Override
    public String getCompleteURL() {
        final String API_VERSION = "v1";
        return this.getBaseURL() + API_VERSION + "/";
    }
}
