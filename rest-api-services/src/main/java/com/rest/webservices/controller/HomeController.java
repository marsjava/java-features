package com.rest.webservices.controller;

import com.rest.webservices.model.Helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
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

}
