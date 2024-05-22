package com.aluracursos.currencyconverter.userinterface;

public class UserInput {
    private float currencyValue;
    private float newCurrencyValue;

    private String currentValue;
    private String newValue;

    public float getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(float currencyValue) {
        this.currencyValue = currencyValue;
    }

    public float getNewCurrencyValue() {
        return newCurrencyValue;
    }

    public void setNewCurrencyValue(float newCurrencyValue) {
        this.newCurrencyValue = newCurrencyValue;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

}
