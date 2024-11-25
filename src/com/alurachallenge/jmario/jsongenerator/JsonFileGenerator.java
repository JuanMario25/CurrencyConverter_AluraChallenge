package com.alurachallenge.jmario.jsongenerator;

import com.alurachallenge.jmario.classes.CurrencyConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileGenerator {
    public void jsonFile(CurrencyConverter currencyConverter) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter newJsonFile = new FileWriter("%S_To_%S_%S.json".formatted(currencyConverter.getBase_code(),
                currencyConverter.getTarget_code(),
                currencyConverter.getQuery_date_time()));
        newJsonFile.write(gson.toJson(currencyConverter));
        newJsonFile.close();
    }
}
