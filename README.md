# Exchange Rate (PT-BR)

## Introdução

Biblioteca desenvolvida com propósito educacional frisando boas práticas no desenvolvimento de software. Sinta-se livre
para consumi-la como quiser, isso envolve baixá-la, modificá-la e distribui-la como assim preferir.

## Utilização

Para sua utilização, é somente necessário instanciar a classe "ExchangeRate" e utilizar seus métodos padrões.

````
JAVA

public static void main(String[] args){

    ConnectionConfiguration configuration = new ExchangeRateConfiguration();
    ExchangeRate exchangeRate = new ExchangeRate(configuration);
    
    // Busca a última cotação
    Response response = exchangeRate.getLatestExchange();
    
    System.out.println(response.toJSON());
}
````

## Moedas suportadas
A biblioteca suporta um grande número de moedas fiduciárias, como por exemplo: Dólar americano (USD), Euro (EUR), Real 
brasileiro (BRL), Libra (GBP), dentre inúmeras outras. Pode consultar todas elas olhando o enum [CurrencyBase](src/main/java/br/ceborn/exchange/enums/CurrencyBase.java).