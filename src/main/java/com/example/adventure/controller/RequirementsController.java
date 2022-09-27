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
    public ResponseEntity<Set<Requirements>> deleteReqs (Requirements requirements){
        reqJPA.delete(requirements);
        return new ResponseEntity<>(reqJPA.findAll(),HttpStatus.OK);
    }

    @PatchMapping("/editRequirements")
    public ResponseEntity<Requirements> editReqs(@RequestBody Requirements requirements){

        Optional<Requirements> reqTemp = reqJPA.findById(requirements.getId());

        System.out.println(requirements.alcoholLevel);

        if(reqTemp.isPresent()){
            if(requirements.getId() == null) {
                requirements.setId(requirements.getId());
            }
            if(requirements.getMinimumAttendants() == 0) {
                requirements.setMinimumAttendants(reqTemp.get().minimumAttendants);
            }
            if(requirements.getMaximumAttendants() == 0) {
                requirements.setMaximumAttendants(reqTemp.get().maximumAttendants);
            }
            if(requirements.getAlcoholLevel() == 0) {
                requirements.setAlcoholLevel(reqTemp.get().alcoholLevel);
            }
            if(requirements.getMaxWeight() == 0){
                requirements.setMaxWeight(reqTemp.get().maxWeight);
            }
            if(requirements.getMinimumHeight() == 0) {
                requirements.setMinimumHeight(reqTemp.get().minimumHeight);
            }
            if(requirements.getMaximumHeight() == 0) {
                requirements.setMaximumHeight(reqTemp.get().maximumHeight);
            }
            if(requirements.getMinimumAge() == 0) {
                requirements.setMinimumAge(reqTemp.get().minimumAge);
            }
            if(requirements.getMaximumAge() == 0) {
                requirements.setMaximumAge(reqTemp.get().maximumAge);
            }
            if(requirements.getRequirementsDescrip() == null) {
                requirements.setRequirementsDescrip(reqTemp.get().requirementsDescrip);
            }
            reqJPA.save(requirements);
            System.out.println(requirements.alcoholLevel);
            return new ResponseEntity<>(requirements,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(requirements,HttpStatus.NOT_FOUND);
        }
    }

}
