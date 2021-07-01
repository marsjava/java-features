package com.rest.webservices.controller;

import com.rest.webservices.model.Helloworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HomeController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world..";
    }

    @GetMapping("/hello-bean")
    public Helloworld helloWorldBean() {
        return new Helloworld("hello world bean..");
    }

    @GetMapping("/hello-bean-param/{name}")
    public Helloworld helloWorldBeanParam(@PathVariable String name) {
        return new Helloworld(String.format("hello world bean.. %s",name.toUpperCase()));
    }
    @GetMapping("/hello-i18n-param")
    public String helloWorldInternalizationWithParam(@RequestHeader(name = "Accept-Language", required = false)Locale locale) {
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
    @GetMapping("/hello-i18n")
    public String helloWorldInternalizationWithoutParam() {
        return messageSource.getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
    }
}
