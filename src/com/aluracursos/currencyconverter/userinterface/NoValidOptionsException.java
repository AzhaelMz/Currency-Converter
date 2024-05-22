package com.aluracursos.currencyconverter.userinterface;

public class NoValidOptionsException extends Exception{
    public NoValidOptionsException(String message){
        super(message);
    }
}
