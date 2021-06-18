package com.jb.currencyexchanger.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExchangeResponseDetails {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double result;
}
