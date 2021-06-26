package com.rest.webservices.controller;

import com.rest.webservices.model.User;
import com.rest.webservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUser(){
        return service.getUserList();
    }

    @GetMapping("/users/{id}")
    public User retrieveOneUser(@PathVariable int id){
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        User savedUser = service.createUser(user);
    }
}
