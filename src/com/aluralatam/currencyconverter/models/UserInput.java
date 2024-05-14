package com.aluralatam.currencyconverter.models;

public class UserInput {
    private float currrencyValue;

    private float newCurrencyValue;
    private String currentCurrencyValue;
    private String newCurrency;

    public float getCurrrencyValue() {
        return currrencyValue;
    }

    public void setCurrrencyValue(float currrencyValue) {
        this.currrencyValue = currrencyValue;
    }

    public float getNewCurrencyValue() {
        return newCurrencyValue;
    }

    public void setNewCurrencyValue(float newCurrencyValue) {
        this.newCurrencyValue = newCurrencyValue;
    }

    public String getCurrentCurrencyValue() {
        return currentCurrencyValue;
    }

    public void setCurrentCurrencyValue(String currentCurrencyValue) {
        this.currentCurrencyValue = currentCurrencyValue;
    }

    public String getNewCurrency() {
        return newCurrency;
    }

    public void setNewCurrency(String newCurrency) {
        this.newCurrency = newCurrency;
    }
}
