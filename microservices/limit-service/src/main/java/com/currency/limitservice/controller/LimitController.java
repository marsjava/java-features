package com.currency.limitservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
    @GetMapping
    public String getMessage(){
        return "Limit service.";
    }
}
