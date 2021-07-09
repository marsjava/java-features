package com.currency.exchangeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    @GetMapping
    public String getExchange(){
        return "Exchange service.";
    }
}
