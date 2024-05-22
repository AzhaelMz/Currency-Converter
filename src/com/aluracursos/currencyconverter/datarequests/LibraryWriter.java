package com.aluracursos.currencyconverter.datarequests;

import com.aluracursos.currencyconverter.exceptions.UserInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryWriter {
    public void jsonSaver(ArrayList<UserInput> data) throws IOException{

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter script = new FileWriter("CurrenciesData.json");
        script.write(gson.toJson(data));
        script.close();
    }
}
