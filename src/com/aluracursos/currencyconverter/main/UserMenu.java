package com.aluracursos.currencyconverter.main;

public class UserMenu {
    public void firstMessageToUser(String process){
        System.out.println("Please select the currency you want to" + process +" (ONLY NUMBERS): ");
    }
    public void currenciesMenu(){
        System.out.println("""
              ////////////////////////////////////////////////////////////////////////////
               ***********> W E L C O M E TO C U R R E N C Y C O N V E R T E R <*********
               ///////////////////////////////////////////////////////////////////////////
               |1. American dollar (USA) |2.Mexican Peso (MXN)      |3.Brazilian Real (BRL)
               |4.Chilean Peso (CLP)    |5.Colombian Peso (COP)    |6.Argentine peso (ARS)
               ===========================================================================""");
    }
}
