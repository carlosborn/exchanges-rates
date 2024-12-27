package org.exchange.connection;

import lombok.AllArgsConstructor;
import org.exchange.configuration.ExchangeRateConfiguration;
import org.exchange.helpers.HTTPRequest;
import org.exchange.responses.InfoResponse;
import org.exchange.responses.Response;
import org.json.JSONObject;

@AllArgsConstructor
public class ExchangeRate {

    private ExchangeRateConfiguration configuration;

    public Response getInfos() {
        try {
            JSONObject json = HTTPRequest.sendGET(configuration.getBaseURL());

            Response response = new InfoResponse();
            response.fromJSON(json);

            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
