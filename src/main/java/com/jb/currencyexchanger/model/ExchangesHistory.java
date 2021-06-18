package com.jb.currencyexchanger.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Data
public class ExchangesHistory {
    private final Set<ExchangeResponseDetails> exchangesHistory = new HashSet<>();

    public void addExchange(ExchangeResponseDetails exchangeResponseDetails) {
        exchangesHistory.add(exchangeResponseDetails);
    }

    public void resetHistorySet() {
        exchangesHistory.clear();
    }

    public ExchangeResponseDetails getExchangeIfExists(String fromCurrency, String toCurrency, double amount) {
        return exchangesHistory.stream().filter(set -> set.getFromCurrency().equals(fromCurrency)
                && set.getToCurrency().equals(toCurrency)
                && set.getAmount() == amount).findFirst().orElse(null);
    }
}
