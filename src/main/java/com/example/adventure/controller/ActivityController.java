package com.example.adventure.controller;

import com.example.adventure.model.Activity;
import com.example.adventure.service.ActivityJPA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class ActivityController {
        //hej hej ehj
    ActivityJPA activityJPA;

    public ActivityController(ActivityJPA activityJPA) {
        this.activityJPA = activityJPA;
    }

    @PostMapping("/saveActivity")
    public ResponseEntity<?> saveActivity(@RequestBody Activity activity){
        Activity savedActivity = activityJPA.save(activity);
        if (savedActivity == null){
            return new ResponseEntity<>("Fejl i opretttelse af aktivitet", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(savedActivity, HttpStatus.OK);
        }
    }

    @GetMapping("/findAllActivities")
    public ResponseEntity<Set<Activity>> getAllActivities(){
        Set allActivities = activityJPA.findAll();
        return new ResponseEntity<>(allActivities, HttpStatus.OK);
    }

    @PutMapping("/updateActivity")
    public ResponseEntity<?> updateActivity(@RequestBody Activity activity){
        Optional<Activity> activityToUpdate = activityJPA.findById(activity.getId());
        if (activityToUpdate.isPresent()) {
            Activity savedActivity = activityJPA.save(activity);
            if (savedActivity == null) {
                return new ResponseEntity<>("Fejl i opdatering af aktivitet", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(savedActivity, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("Kunne ikke finde aktivitet", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteActivity/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable Long id){
        activityJPA.deleteById(id);
        return new ResponseEntity<>("Aktivitet med id " + id + " blev slettet", HttpStatus.OK);
    }
}
