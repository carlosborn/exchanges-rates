package br.ceborn.exchange.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@AllArgsConstructor
@Getter
public class InfoResponse implements Response {

    private String name;
    private String description;
    private String version;
    private String docs;
    private String source;

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

    public String toString() {
        return this.toJSON().toString();
    }
}
