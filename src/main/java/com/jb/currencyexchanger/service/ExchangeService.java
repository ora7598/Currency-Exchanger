package com.jb.currencyexchanger.service;


import com.jb.currencyexchanger.exception.InvalidCurrencyDetails;
import com.jb.currencyexchanger.exception.NotFoundException;
import com.jb.currencyexchanger.model.ExchangeRateApiResponseDetails;
import com.jb.currencyexchanger.model.ExchangeResponseDetails;

public interface ExchangeService {
    ExchangeResponseDetails calculateCurrency(String fromCurrency, String toCurrency, double amount) throws NotFoundException;

    ExchangeRateApiResponseDetails getRates(String fromCurreny) throws NotFoundException;
}
