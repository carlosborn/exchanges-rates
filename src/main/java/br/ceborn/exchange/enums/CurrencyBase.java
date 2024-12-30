package br.ceborn.exchange.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CurrencyBase {

    AUD("AUD", "Australian Dollar"),
    BGN("BGN", "Bulgarian Lev"),
    BRL("BRL", "Brazilian Real"),
    CAD("CAD", "Canadian Dollar"),
    CHF("CHF", "Swiss Franc"),
    CNY("CNY", "Chinese Renminbi Yuan"),
    CZK("CZK", "Czech Koruna"),
    DKK("DKK", "Danish Krone"),
    EUR("EUR", "Euro"),
    GBP("GBP", "British Pound"),
    HKD("HKD", "Hong Kong Dollar"),
    HUF("HUF", "Hungarian Forint"),
    IDR("IDR", "Indonesian Rupiah"),
    ILS("ILS", "Israeli New Sheqel"),
    INR("INR", "Indian Rupee"),
    ISK("ISK", "Icelandic Króna"),
    JPY("DKK", "Japanese Yen"),
    KRW("KRW", "South Korean Won"),
    MXN("MXN", "Mexican Peso"),
    MYR("MYR", "Malaysian Ringgit"),
    NOK("NOK", "Norwegian Krone"),
    NZD("NZD", "New Zealand Dollar"),
    PHP("PHP", "Philippine Peso"),
    PLN("PLN", "Polish Złoty"),
    RON("RON", "Romanian Leu"),
    SEK("SEK", "Swedish Krona"),
    SGD("SGD", "Singapore Dollar"),
    THB("THB", "Thai Baht"),
    TRY("TRY", "Turkish Lira"),
    USD("USD", "United States Dollar"),
    ZAR("ZAR", "South African Rand");

    private final String symbol;
    private final String description;

    public static CurrencyBase getBySymbol(String symbol) {
        for (CurrencyBase currencyBase : CurrencyBase.values()) {
            if (symbol.equals(currencyBase.getSymbol())) {
                return currencyBase;
            }
        }
        return null;
    }

}
