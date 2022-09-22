package com.example.adventure.controller;

import com.example.adventure.model.User;
import com.example.adventure.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    private UserService uService;

    public UserController(UserService uService){
        this.uService = uService;
    }
    //Show all users in DB
    @GetMapping("/users")
    public ResponseEntity<Set<User>> getUsers(){
    return new ResponseEntity<>(uService.findAll(), HttpStatus.OK);
    }

    //Add user and save in DB
    @PostMapping("/adduser")
    public ResponseEntity<Set<User>>addUser(User name){
        uService.save(name);
    return new ResponseEntity<>(uService.findAll(), HttpStatus.OK);
    }



}
