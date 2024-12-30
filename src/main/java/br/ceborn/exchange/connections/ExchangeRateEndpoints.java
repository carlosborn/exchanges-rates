package br.ceborn.exchange.connections;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum ExchangeRateEndpoints {

    LATEST("latest"),
    CURRENCIES("currencies");

    private final String endpoint;
}
