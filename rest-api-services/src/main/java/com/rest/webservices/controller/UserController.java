package com.rest.webservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.rest.webservices.exception.UserNotFoundException;
import com.rest.webservices.model.User;
import com.rest.webservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public EntityModel<User> retrieveOneUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id-"+id);
        }
        WebMvcLinkBuilder linkToUser = linkTo(methodOn(this.getClass()).retrieveAllUser());
        EntityModel<User> model = EntityModel.of(user);
        model.add(linkToUser.withRel("all-users"));
        return model;
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable int id){
        User user = service.deleteOne(id);
        if(user == null) {
            throw new UserNotFoundException("id-"+id);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
        User savedUser = service.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
