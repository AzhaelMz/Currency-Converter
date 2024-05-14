package com.aluralatam.currencyconverter.calculator;

import com.aluralatam.currencyconverter.models.CurrencyRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataRequest {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public CurrencyRate requestDataFromRate(String currentCurrencyValue){
        CurrencyRate currencyInfo = null;

        try{
            URI urlClient = URI.create("https://v6.exchangerate-api.com/v6/e5fd6e67c8f82c87fa81e00c/latest/"+ currentCurrencyValue);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(urlClient)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            currencyInfo = gson.fromJson(json, CurrencyRate.class);

        }catch (IllegalArgumentException e) {
            System.out.println("Error");
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        return currencyInfo;
    }
}