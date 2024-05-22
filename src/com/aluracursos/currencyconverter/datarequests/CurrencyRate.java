package com.aluracursos.currencyconverter.datarequests;

import java.util.Map;

public record CurrencyRate(String base_code, Map<String, Float> conversion_rates){
}
