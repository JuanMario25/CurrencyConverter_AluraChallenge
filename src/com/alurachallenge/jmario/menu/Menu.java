package com.alurachallenge.jmario.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
   public static final String WELCOME_MESSAGE = "!! WELCOME !!";

   public static final String BASE_CURRENCY_MESSAGE =
                                             """
                                             **************************************************************************
                                             Please Select the base currency:
                                             1.- Mexican Peso (MXN)
                                             2.- American Dollar (USD)
                                             3.- Brazilian Real (BRL)
                                             4.- Euro (EUR)
                                             5.- Argentine Peso (ARS)
                                             6.- Canadian Dollar (CAD)
                                             7.- Exit
                                             """;

   public static final String TARGET_CURRENCY_MESSAGE =
                                                """
                                                Please Select the target currency:
                                                1.- Mexican Peso (MXN)
                                                2.- American Dollar (USD)
                                                3.- Brazilian Real (BRL)
                                                4.- Euro (EUR)
                                                5.- Argentine Peso (ARS)
                                                6.- Canadian Dollar (CAD)
                                                """;

   public static final String ENTER_AMOUNT_OF_MONEY_MESSAGE = "Please entre the amount of money";

   public static final List<String> CURRENCY_CODE = Arrays.asList("MXN","USD","BRL","EUR","ARS","CAD");

   public static String printResult(double moneyAmount, double conversionResult,String baseCode,String targetCode){
      return "$%.2f %S are equal to $%.2f %S".formatted(
              moneyAmount,
              baseCode,
              conversionResult,
              targetCode
      );
   }

}
