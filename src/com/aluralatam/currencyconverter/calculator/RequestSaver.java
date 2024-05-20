package com.aluralatam.currencyconverter.calculator;

import com.aluralatam.currencyconverter.models.UserInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RequestSaver {
    public void saveJson(ArrayList<UserInput> data) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting().create();

        FileWriter scrip = new FileWriter("currencyData.json");
        scrip.write(gson.toJson(data));
        scrip.close();
    }
}
