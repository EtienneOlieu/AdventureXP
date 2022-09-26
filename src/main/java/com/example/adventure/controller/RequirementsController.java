package com.example.adventure.controller;


import com.example.adventure.model.Requirements;
import com.example.adventure.service.RequirementsJPA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class RequirementsController {

    private final RequirementsJPA reqJPA;

    public RequirementsController(RequirementsJPA reqJPA) {
        this.reqJPA = reqJPA;
    }

    @GetMapping("/getRequirements")
    public ResponseEntity<Set<Requirements>> getAllReqs(){
        return new ResponseEntity<>(reqJPA.findAll(), HttpStatus.OK);
    }
    @GetMapping ("/getRequirementsById")
    public ResponseEntity<Set<Requirements>> getRequirementsById(long id){
        Optional<Requirements> currentReqs = reqJPA.findById(id);
        if(currentReqs.isPresent()){
            return new ResponseEntity<>(reqJPA.findAll(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reqJPA.findAll(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping ("/createRequirements")
    public ResponseEntity<Requirements> addCourse (Requirements newReqs){
        return new ResponseEntity<>(reqJPA.save(newReqs),HttpStatus.OK);
    }

    @DeleteMapping("/deleteRequirements")
    public ResponseEntity<Set<Requirements>> deleteCourse (Requirements requirements){
        reqJPA.delete(requirements);
        return new ResponseEntity<>(reqJPA.findAll(),HttpStatus.OK);
    }

    @PutMapping("/editRequirements")
    public ResponseEntity<Set<Requirements>> editUser(Long id, Requirements requirements){
        Optional<Requirements> updated = reqJPA.findById(id);
        if(updated.isPresent()){
            reqJPA.save(requirements);
            return new ResponseEntity<>(reqJPA.findAll(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reqJPA.findAll(),HttpStatus.NOT_FOUND);
        }
    }

}
