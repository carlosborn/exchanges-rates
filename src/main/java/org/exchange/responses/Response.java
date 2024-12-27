package org.exchange.responses;

import org.json.JSONObject;

public interface Response {

    public void fromJSON(JSONObject jsonObject);
    public void fromJSON(String json);
    public JSONObject toJSON();

}
