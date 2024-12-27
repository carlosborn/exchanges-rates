package org.exchange.configuration;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateConfiguration implements ConnectionConfiguration {


    private JSONObject response;
    private Map<String, Object> parameters = new HashMap<>();

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
    public JSONObject getResponse() {
        return this.response;
    }

    @Override
    public void addParameter(String key, Object value) {
        this.parameters.put(key, value);
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    @Override
    public void removeParameter(String key) {
        this.parameters.remove(key);
    }

    @Override
    public void resetParameters() {
        this.parameters.clear();
    }
}
