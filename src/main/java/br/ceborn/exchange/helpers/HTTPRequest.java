package br.ceborn.exchange.helpers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequest {

    public static JSONObject sendGET(String urlParameter, Integer timeout) throws Exception {
        URL url = new URL(urlParameter);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        ;
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(timeout);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return new JSONObject(content.toString());
    }

}
