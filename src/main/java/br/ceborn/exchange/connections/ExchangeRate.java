package br.ceborn.exchange.connections;

import br.ceborn.exchange.mappers.ExchangeRateMapper;
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
            JSONObject json = HTTPRequest.sendGET(configuration.getBaseURL(), configuration.getTimeout());

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

        ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest.ExchangeRateRequestBuilder()
                .setIniDate(iniDate)
                .setEndDate(endDate)
                .setCurrencyBase(currencyBase)
                .setSymbols(symbols)
                .build();

        String parameters = exchangeRateRequest.mountParameters();
        String url = this.configuration.getCompleteURL() + parameters;

        try {
            JSONObject jsonObject = HTTPRequest.sendGET(url, this.configuration.getTimeout());

            Mapper exchangeRateMapper = new ExchangeRateMapper();
            exchangeRateMapper.fromJSON(jsonObject);

            return exchangeRateMapper.getLoadedResponse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
