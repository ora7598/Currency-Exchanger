package com.jb.currencyexchanger.clr;

import com.jb.currencyexchanger.model.ExchangeResponseDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Order(2)
@RequiredArgsConstructor
public class TestExchangeService implements CommandLineRunner {
    private static final String TEST_URL = "http://localhost:8080/money/convert?fromCurrency=USD&toCurrency=ILS&amount=100";
    private final RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Testing exchange service -->");
        System.out.println("--------------------------------");
        ResponseEntity<ExchangeResponseDetails> exchangeResponseDetails = restTemplate.getForEntity(TEST_URL, ExchangeResponseDetails.class);
        System.out.println(exchangeResponseDetails.getBody());
    }
}
