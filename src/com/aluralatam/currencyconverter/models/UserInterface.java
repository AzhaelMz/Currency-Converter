package com.aluralatam.currencyconverter.models;

public class UserInterface {

    public void messageToUser(String process){

        System.out.println("Please select the currency you want (use a number input)");
    }
    public void currenciesMenu(){
        System.out.println("""
                ==========================================================================
                |1. USA Dollars (USD) |2. Real Brazilian (BRL) |3. Canadian Dollars (CAN)|
                |4. Mexican Pesos (MXN)| 5. Colombian Pesos (COP)| 6. Argentine peso (ARS)|""");
    }
}
