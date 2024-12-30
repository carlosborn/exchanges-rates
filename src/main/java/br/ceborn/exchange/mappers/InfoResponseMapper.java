package br.ceborn.exchange.mappers;

import br.ceborn.exchange.responses.InfoResponse;
import br.ceborn.exchange.responses.Response;
import org.json.JSONObject;

public class InfoResponseMapper implements Mapper {

    private InfoResponse infoResponse;

    @Override
    public void fromJSON(JSONObject jsonObject) {
        try {
            String name = jsonObject.getString("name");
            String description = jsonObject.getString("description");
            String version = jsonObject.getJSONObject("versions").getString("v1");
            String docs = jsonObject.getString("docs");
            String source = jsonObject.getString("source");

            this.infoResponse = new InfoResponse(name, description, version, docs, source);
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
        return this.infoResponse;
    }
}
