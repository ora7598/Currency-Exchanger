package com.jb.currencyexchanger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateApiResponseDetails {
    private String provider;
    private String WARNING_UPGRADE_TO_V6;
    private String terms;
    private String base;
    private String date;
    private String time_last_updated;
    private Map<String, Double> rates;
}
