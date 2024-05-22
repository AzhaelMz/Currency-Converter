package com.aluracursos.currencyconverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIhandler {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CurrencyRate requestDataFromApi(String currentValue){
        CurrencyRate currencyData = null;

        try{
            URI apiUrl = URI.create("https://v6.exchangerate-api.com/v6/e5fd6e67c8f82c87fa81e00c/latest/"+currentValue);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(apiUrl)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            currencyData = gson.fromJson(json, CurrencyRate.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return currencyData;
    }




}
