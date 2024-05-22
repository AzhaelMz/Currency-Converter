package com.aluracursos.currencyconverter.userinterface;

public class ExitException extends RuntimeException{
    public ExitException (String message){
        super(message);
    }
}
