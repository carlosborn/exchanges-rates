package br.ceborn.exchange.configurations;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

public class ExchangeRateConfiguration implements ConnectionConfiguration {

    private final Integer DEFAULT_TIMEOUT = 30;

    private Integer timeout = DEFAULT_TIMEOUT;

    @Override
    public String getBaseURL() {
        return "https://api.frankfurter.dev/";
    }

    @Override
    public String getCompleteURL() {
        final String API_VERSION = "v1";
        return this.getBaseURL() + API_VERSION + "/";
    }

    @Override
    public Integer getTimeout() {
        return this.timeout;
    }

    @Override
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
