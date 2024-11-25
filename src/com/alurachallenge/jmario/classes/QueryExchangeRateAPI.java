package com.alurachallenge.jmario.classes;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryExchangeRateAPI {

    public CurrencyConversionData conversionData(String baseCode, String targetCode) {

        URI url = URI.create("https://v6.exchangerate-api.com/v6/98dc2669403ef3b9040ba21b/pair/%S/%S".formatted(baseCode,targetCode));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), CurrencyConversionData.class);
            } catch (Exception e) {
                throw new RuntimeException("""
                        %S
                        Something went wrong with the API connexion""".formatted(e.getMessage()));
            }

    }

}
