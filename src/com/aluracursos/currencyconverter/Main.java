package com.aluracursos.currencyconverter;

import com.aluracursos.currencyconverter.userinterface.ExitException;
import com.aluracursos.currencyconverter.userinterface.NoValidOptionsException;
import com.aluracursos.currencyconverter.userinterface.UserInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserMenu messageInfo = new UserMenu();
        Scanner input = new Scanner(System.in);

        APIhandler requestData = new APIhandler();
        LibraryWriter writer = new LibraryWriter();
        ArrayList<UserInput> allElements = new ArrayList<>();

        messageInfo.currenciesMenu();

        while (true) {

            try {
                UserInput base = new UserInput();

                messageInfo.firstMessageToUser(" exchange");
                base.setCurrentValue(getCurrencyValueFromUser(input));

                messageInfo.firstMessageToUser(" obtain");
                base.setNewValue(getCurrencyValueFromUser(input));

                CurrencyRate data = requestData.requestDataFromApi(base.getCurrentValue());

                float factor = data.conversion_rates().get(base.getNewValue());

                exchangeCalc(factor, input, base);
                allElements.add(base);

                if(!additionalOptions(input, messageInfo, writer, base, allElements)){
                    System.out.println("Thanks for use our currency converter");
                    break;

                }
            }catch (IllegalArgumentException e){
                System.out.println("Url error, please check de link");
            }catch (ExitException e){
                System.out.println(e.getMessage());
                break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
    public static String getCurrencyValueFromUser(Scanner input) throws ExitException{

        int choseOption;
        String currency ="";

        choseOption = input.nextInt();
        if (choseOption == 7){
            throw new ExitException("Program exit success! Thank you for use our Currency Converter");
        }
        try{
            optionsChecker(choseOption);
            currency = getUserCurrency(choseOption);

        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("\n Error: invalid input value. Try again.");
        }catch (NoValidOptionsException e){
            System.out.println(e.getMessage());
        }

        return currency;
    }
    public static  void optionsChecker (int option) throws NoValidOptionsException{
        if (option <=0 || option >7){
            throw new NoValidOptionsException("Invalid option, please try again");
        }

    }
    public static String getUserCurrency(int choseOption){
        String currency ="";

        switch (choseOption){
            case 1:
                currency = "USD";
                break;
            case 2:
                currency = "MXN";
                break;
            case 3:
                currency = "BRL";
                break;
            case 4:
                currency = "CLP";
                break;
            case 5:
                currency = "COP";
                break;
            case 6:
                currency = "ARS";
                break;
            default:
                System.out.println("Error. Chose a valid option");
                break;
        }
        return  currency;
    }
    private static void exchangeCalc(float conversionFactor, Scanner input, UserInput base){
        float exchangedCurrency;
        float currencyToExchange;
        System.out.println("Write the currency amount you want to exchange: $");
        base.setCurrencyValue(input.nextFloat());

        exchangedCurrency = base.getCurrencyValue() * conversionFactor;
        base.setNewCurrencyValue((float) (Math.round(exchangedCurrency * 100.00)/100.00));

        System.out.println("\n==========================================================");
        System.out.println("The exchange rate of "+ base.getCurrencyValue() + " "+ base.getCurrentValue()+ " to "
                + base.getNewValue()+ " it's $ " + base.getNewCurrencyValue()+ "("+base.getNewValue()+")");
        System.out.println("\n===========================================================");

    }
    private static boolean additionalOptions(Scanner input, UserMenu messageInfo, LibraryWriter writer, UserInput base,
                                             ArrayList<UserInput> allElements)throws IOException{
        int continueAnswer;

        System.out.println("\n Would you like to get another conversion? Please select an option to continue");
        System.out.println("|1.Yes | |2.No");
        continueAnswer = input.nextInt();

        if(continueAnswer == 1){
            messageInfo.currenciesMenu();
            return true;
        } else if (continueAnswer == 2) {
            allElements.clear();
            return false;
        }else{
            System.out.println("Invalid input please try again");
            return additionalOptions(input, messageInfo, writer, base, allElements);
        }
    }
}