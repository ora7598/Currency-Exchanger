package com.jb.currencyexchanger.controller;

import com.jb.currencyexchanger.exception.InvalidCurrencyDetails;
import com.jb.currencyexchanger.exception.NotFoundException;
import com.jb.currencyexchanger.model.ExchangeResponseDetails;
import com.jb.currencyexchanger.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/money")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/convert")
    public ResponseEntity<?> convertCurrency(@RequestParam String fromCurrency,
                                             @RequestParam String toCurrency,
                                             @RequestParam double amount) throws NotFoundException {
        ExchangeResponseDetails exchangeResponseDetails = exchangeService.calculateCurrency(fromCurrency, toCurrency, amount);
        return new ResponseEntity<>(exchangeResponseDetails, HttpStatus.OK);
    }
}
