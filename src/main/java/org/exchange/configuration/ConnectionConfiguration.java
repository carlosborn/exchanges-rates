package org.exchange.configuration;

import org.json.JSONObject;

import java.util.Map;

interface ConnectionConfiguration {

    public String getBaseURL();
    public String getCompleteURL();

    public JSONObject getResponse();

    public void addParameter(String key, Object value);

    public void setParameters(Map<String, Object> parameters);

    public Map<String, Object> getParameters();

    public void removeParameter(String key);

    public void resetParameters();

}
