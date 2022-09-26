package com.example.adventure.controller;


import com.example.adventure.service.RequirementsJPA;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequirementsController {

    private final RequirementsJPA reqJPA;

    public RequirementsController(RequirementsJPA reqJPA) {
        this.reqJPA = reqJPA;
    }

}
