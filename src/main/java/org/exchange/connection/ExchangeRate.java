package org.exchange.connection;

import lombok.AllArgsConstructor;
import org.exchange.configuration.ConnectionConfiguration;
import org.exchange.configuration.ExchangeRateConfiguration;
import org.exchange.enums.CurrencyBase;
import org.exchange.helpers.HTTPRequest;
import org.exchange.requests.ExchangeRateRequest;
import org.exchange.responses.InfoResponse;
import org.exchange.responses.Response;
import org.json.JSONObject;

import java.util.Date;

@AllArgsConstructor
public class ExchangeRate {

    private ConnectionConfiguration configuration;

    /**
     * Get the API's information
     *
     * @return Response
     */
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

    public Response getLatestExchange() {
        return this.getExchange(new Date(), null, CurrencyBase.USD, null);
    }

    public Response getExchange(Date iniDate, Date endDate, CurrencyBase currencyBase, CurrencyBase[] symbols) {
        ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
        exchangeRateRequest.setIniDate(iniDate);
        exchangeRateRequest.setEndDate(endDate);
        exchangeRateRequest.setCurrencyBase(currencyBase);
        exchangeRateRequest.setSymbols(symbols);

        String parameters = exchangeRateRequest.mountParameters();

        try {
            JSONObject jsonObject = HTTPRequest.sendGET(this.configuration.getCompleteURL() + parameters);
            return this.mountResponseExchangeRate(jsonObject, exchangeRateRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Response mountResponseExchangeRate(JSONObject jsonObject, ExchangeRateRequest exchangeRateRequest) {
        return null;
    }

}
