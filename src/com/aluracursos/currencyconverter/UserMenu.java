package com.aluracursos.currencyconverter;

public class UserMenu {
    public void firstMessageToUser(String process){
        System.out.println("Welcome to currency converter. Please select the currencies you want to" + process +": ");
    }
    public void currenciesMenu(){
        System.out.println("""
               ==============================******************===========================
               |1. American dollar (USA) |2.Mexican Peso (MXN)      |3.Brazilian Real (BRL)
               |4.Chilean Peso (CLP)    |5.Colombian Peso (COP)    |6.Argentine peso (ARS)""");
    }
}
