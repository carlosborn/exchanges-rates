package br.ceborn.exchange.requests;

import lombok.Getter;
import lombok.Setter;
import br.ceborn.exchange.enums.CurrencyBase;
import br.ceborn.exchange.helpers.DateConverter;

import java.util.Date;

@Getter
public class ExchangeRateRequest {

    private final Date iniDate;
    private final Date endDate;
    private final CurrencyBase currencyBase;
    private final CurrencyBase[] symbols;

    private ExchangeRateRequest(ExchangeRateRequestBuilder builder) {
        this.iniDate = builder.iniDate;
        this.endDate = builder.endDate;
        this.currencyBase = builder.currencyBase;
        this.symbols = builder.symbols;
    }

    public String mountParameters() {
        StringBuilder parameters = new StringBuilder();

        if (this.iniDate != null) {
            String iniDate = DateConverter.convertDateToString(this.iniDate);
            parameters.append(iniDate);
        }

        if (this.endDate != null) {
            String endDate = DateConverter.convertDateToString(this.endDate);
            parameters.append("..").append(endDate);
        }

        if (this.currencyBase != null) {
            parameters.append("?base=").append(this.currencyBase.getSymbol());
        }

        if (this.symbols != null) {
            for (CurrencyBase cb : this.symbols) {
                parameters.append("&").append(cb.getSymbol()).append(",");
            }
        }

        return parameters.toString();
    }

    public static class ExchangeRateRequestBuilder {

        // All those parameters are optionals
        private Date iniDate;
        private Date endDate;
        private CurrencyBase currencyBase;
        private CurrencyBase[] symbols;

        public ExchangeRateRequestBuilder() {
            this.iniDate = new Date();
        }

        public ExchangeRateRequestBuilder setIniDate(Date iniDate) {
            this.iniDate = iniDate;
            return this;
        }

        public ExchangeRateRequestBuilder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public ExchangeRateRequestBuilder setCurrencyBase(CurrencyBase currencyBase) {
            this.currencyBase = currencyBase;
            return this;
        }

        public ExchangeRateRequestBuilder setSymbols(CurrencyBase[] symbols) {
            this.symbols = symbols;
            return this;
        }

        public ExchangeRateRequest build() {
            return new ExchangeRateRequest(this);
        }
    }

}
