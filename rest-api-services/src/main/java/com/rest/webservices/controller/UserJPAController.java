package com.rest.webservices.controller;

import com.rest.webservices.exception.UserNotFoundException;
import com.rest.webservices.model.Post;
import com.rest.webservices.model.User;
import com.rest.webservices.repository.PostRepository;
import com.rest.webservices.repository.UserRepository;
import com.rest.webservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {
    @Autowired
    private UserDaoService service;
    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUser(){
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveOneUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException("id-"+id);
        }
        EntityModel<User> entity = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
        entity.add(linkTo.withRel("all-users"));
        return entity;
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteById(@PathVariable int id){
        repository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveUserPosts(@PathVariable int id){
        Optional<User> userOptional = repository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        return userOptional.get().getPosts();
    }
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> savePost(@Valid @PathVariable int id, @RequestBody Post post){
        Optional<User> userOptional = repository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
