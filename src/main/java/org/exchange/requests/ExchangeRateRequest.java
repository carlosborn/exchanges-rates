package org.exchange.requests;

import lombok.Getter;
import lombok.Setter;
import org.exchange.enums.CurrencyBase;
import org.exchange.helpers.DateConverter;

import java.util.Date;

@Getter
@Setter
public class ExchangeRateRequest {

    private Date iniDate;
    private Date endDate;
    private CurrencyBase currencyBase;
    private CurrencyBase[] symbols;

    public String mountParameters() {
        StringBuilder parameters = new StringBuilder("/");

        if (this.iniDate != null) {
            String iniDate = DateConverter.convertDateToString(this.iniDate);
            parameters.append(iniDate);
        }

        if (this.endDate != null) {
            String endDate = DateConverter.convertDateToString(this.endDate);
            parameters.append("..").append(endDate);
        }

        if (this.currencyBase != null) {
            parameters.append("base=").append(this.currencyBase.getSymbol());
        }

        if (this.symbols != null) {
            for (CurrencyBase cb : this.symbols) {
                parameters.append(cb.getSymbol()).append(",");
            }
        }

        return parameters.toString();
    }

}
