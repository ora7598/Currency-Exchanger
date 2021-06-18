package com.jb.currencyexchanger.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String key;
    private String content;
    private int statusCode;
}
