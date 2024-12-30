package br.ceborn.exchange.connections;

import br.ceborn.exchange.mappers.InfoResponseMapper;
import br.ceborn.exchange.mappers.Mapper;
import lombok.AllArgsConstructor;
import br.ceborn.exchange.configurations.ConnectionConfiguration;
import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.helpers.HTTPRequest;
import br.ceborn.exchange.requests.ExchangeRateRequest;
import br.ceborn.exchange.responses.InfoResponse;
import br.ceborn.exchange.responses.Response;
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

            Mapper mapper = new InfoResponseMapper();
            mapper.fromJSON(json);

            return mapper.getLoadedResponse();
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
