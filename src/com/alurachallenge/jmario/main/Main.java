package com.alurachallenge.jmario.main;

import com.alurachallenge.jmario.classes.CurrencyConversionData;
import com.alurachallenge.jmario.classes.CurrencyConverter;
import com.alurachallenge.jmario.classes.QueryExchangeRateAPI;
import com.alurachallenge.jmario.jsongenerator.JsonFileGenerator;
import com.alurachallenge.jmario.menu.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int baseCurrencyIndex = 0;  // works as index in the list Menu.CURRENCY_CODE, also works as enter condition to the while loop

        System.out.println(Menu.WELCOME_MESSAGE);

        try{
            while (baseCurrencyIndex != 6) {

                System.out.println(Menu.BASE_CURRENCY_MESSAGE);
                baseCurrencyIndex = (Integer.parseInt(userInput.nextLine())) - 1;

                if ((baseCurrencyIndex > -1) && (baseCurrencyIndex < 6)) {

                    System.out.println(Menu.TARGET_CURRENCY_MESSAGE);
                    int targetCurrencyIndex = (Integer.parseInt(userInput.nextLine())) - 1;

                    System.out.println(Menu.ENTER_AMOUNT_OF_MONEY_MESSAGE);
                    double moneyAmount = Double.parseDouble(userInput.nextLine());

                    QueryExchangeRateAPI queryExchangeRateAPI = new QueryExchangeRateAPI();
                    CurrencyConversionData currencyConversionData = queryExchangeRateAPI.conversionData(
                            Menu.CURRENCY_CODE.get(baseCurrencyIndex),
                            Menu.CURRENCY_CODE.get(targetCurrencyIndex)
                    );

                    CurrencyConverter currencyConverter = new CurrencyConverter(currencyConversionData);
                    currencyConverter.setConversion_result(moneyAmount);
                    currencyConverter.setSummary();

                    JsonFileGenerator operationRegisterFile = new JsonFileGenerator();
                    operationRegisterFile.jsonFile(currencyConverter);


                } else if ((baseCurrencyIndex <= -1) || (baseCurrencyIndex > 6)) {
                    throw new RuntimeException("Enter only the options available !!");
                } else {
                    System.out.println("The program has ended !!");
                }
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("Make sure enter only numbers available in the options");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unexpected exception has occurred");
        }


    }
}
