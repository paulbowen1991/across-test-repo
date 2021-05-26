package com.across.demo.impl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {
    private static String API_KEY = "Undefined";
    private static String DEFAULT_CURRENCY = "USD";

    public Double convert(Double priceFloor, String currency) {
        try {
            HttpRequest request = buildRequest(priceFloor, DEFAULT_CURRENCY, currency);
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            Double result = jsonResponse.getDouble("result");
            return result;
        } catch (IOException ex) {

        } catch (InterruptedException ex) {

        } catch (JSONException ex) {

        }
        return null;
    }

    public Double convert(Double priceFloor, String toCurrency, String fromCurrency) {
        try {
            HttpRequest request = buildRequest(priceFloor, toCurrency, fromCurrency);
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            Double result = jsonResponse.getDouble("result");
            return result;
        } catch (IOException ex) {

        } catch (InterruptedException ex) {

        } catch (JSONException ex) {

        }
        return null;
    }

    private HttpRequest buildRequest(Double priceFloor, String toCurrency, String fromCurrency) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.currencylayer.com/convert?access_key=" +
                        API_KEY +
                        "&amount="
                        + priceFloor.toString() +
                        "&to=" +
                        toCurrency +
                        "&from=" +
                        fromCurrency))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return request;
    }
}
