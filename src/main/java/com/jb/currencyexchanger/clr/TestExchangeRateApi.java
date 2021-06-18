package com.jb.currencyexchanger.clr;

import com.jb.currencyexchanger.model.ExchangeRateApiResponseDetails;
import com.jb.currencyexchanger.model.ExchangeResponseDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order(1)
@RequiredArgsConstructor
public class TestExchangeRateApi implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private static final String TEST_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Testing Third party application API -->");
        System.out.println("--------------------------------");
        ResponseEntity<ExchangeRateApiResponseDetails> response = restTemplate.getForEntity(TEST_URL, ExchangeRateApiResponseDetails.class);
        System.out.println(response.getBody());
    }
}
