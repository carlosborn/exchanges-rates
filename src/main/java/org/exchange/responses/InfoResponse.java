package org.exchange.responses;

import lombok.Getter;
import org.json.JSONObject;

@Getter
public class InfoResponse implements Response {

    private String name;
    private String description;
    private String version;
    private String docs;
    private String source;

    @Override
    public void fromJSON(JSONObject jsonObject) {
        try {
            this.name = jsonObject.getString("name");
            this.description = jsonObject.getString("description");
            this.version = jsonObject.getJSONObject("versions").getString("v1");
            this.docs = jsonObject.getString("docs");
            this.source = jsonObject.getString("source");
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
    public JSONObject toJSON() {
        try {
            JSONObject versions = new JSONObject();
            versions.put("v1", "/v1");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", this.name);
            jsonObject.put("description", this.description);
            jsonObject.put("versions", versions);
            jsonObject.put("docs", this.docs);
            jsonObject.put("source", this.source);

            return jsonObject;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
