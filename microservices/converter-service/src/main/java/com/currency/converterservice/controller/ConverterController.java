package com.currency.converterservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {
    @GetMapping
    public String getConverter(){
        return "Converter service.";
    }
}
