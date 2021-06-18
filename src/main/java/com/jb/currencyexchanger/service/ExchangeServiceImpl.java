package com.jb.currencyexchanger.service;

import com.jb.currencyexchanger.exception.NotFoundException;
import com.jb.currencyexchanger.model.ExchangeRateApiResponseDetails;
import com.jb.currencyexchanger.model.ExchangeResponseDetails;
import com.jb.currencyexchanger.model.ExchangesHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RequiredArgsConstructor
@Service
public class ExchangeServiceImpl implements ExchangeService {
    private static final String EXCHANGE_API_BASE_URL = "https://api.exchangerate-api.com/v4/latest/%s";
    private final ExchangesHistory exchangesHistory;
    private final RestTemplate restTemplate;

    @Override
    public ExchangeResponseDetails calculateCurrency(String fromCurrency, String toCurrency, double amount) throws NotFoundException {
        ExchangeResponseDetails exchangeResponseDetailsFromHistory = exchangesHistory.getExchangeIfExists(fromCurrency, toCurrency, amount);
        if (exchangeResponseDetailsFromHistory != null) {
            return exchangeResponseDetailsFromHistory;
        }
        ExchangeRateApiResponseDetails rates = getRates(fromCurrency);
        double rate = rates.getRates().getOrDefault(toCurrency, 0.0);

        if (rate == 0.0) {
            throw new NotFoundException(String.format("No rate was found for '%s'", toCurrency));
        }

        double calculatedRate = amount * rate;
        ExchangeResponseDetails newExchangeResponseDetails = new ExchangeResponseDetails(fromCurrency, toCurrency, amount, calculatedRate);
        exchangesHistory.addExchange(newExchangeResponseDetails);
        return newExchangeResponseDetails;
    }

    @Override
    public ExchangeRateApiResponseDetails getRates(String fromCurreny) throws NotFoundException {
        String url = String.format(EXCHANGE_API_BASE_URL, fromCurreny);
        try {
            ResponseEntity<ExchangeRateApiResponseDetails> allRates = restTemplate.getForEntity(url, ExchangeRateApiResponseDetails.class);
            return allRates.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new NotFoundException(String.format("No Currency symbol '%s'", fromCurreny));
        }
    }
}
