package com.aluralatam.currencyconverter.main;

import com.aluralatam.currencyconverter.calculator.DataRequest;
import com.aluralatam.currencyconverter.calculator.RequestSaver;
import com.aluralatam.currencyconverter.models.ExitExceptions;
import com.aluralatam.currencyconverter.models.UserInput;
import com.aluralatam.currencyconverter.models.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface messageInfo = new UserInterface();
        Scanner user = new Scanner(System.in);

        DataRequest dataRequest = new DataRequest();
        RequestSaver writer = new RequestSaver();
        ArrayList<UserInput> allElements = new ArrayList<>();

        messageInfo.currenciesMenu();

        while (true){
            try {
                UserInput model = new UserInput();

                messageInfo.currenciesMenu("change");
                model.setCurrentCurrencyValue(getCurrencyFromUser(Scanner));
            }
        }
    }
    public static String getCurrencyFromUser(Scanner scanner) throws ExitExceptions{
        int userSelectedOption;
        String currency ="";

        userSelectedOption = scanner.nextInt();
        if (userSelectedOption == 0){
            throw new ExitExceptions("Thanks for use our currency converter");
        }
        try{

        }
    }
}
