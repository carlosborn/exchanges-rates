package br.ceborn.exchange.mappers;

import br.ceborn.exchange.responses.Response;
import org.json.JSONObject;

public interface Mapper {

    public void fromJSON(JSONObject json);
    public void fromJSON(String json);
    public Response getLoadedResponse();

}
