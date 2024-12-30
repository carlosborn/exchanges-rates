package br.ceborn.exchange.configurations;

import java.util.concurrent.TimeUnit;

public interface ConnectionConfiguration {

    public String getBaseURL();

    public String getCompleteURL();

    public Integer getTimeout();
    public void setTimeout(Integer timeout);

}
