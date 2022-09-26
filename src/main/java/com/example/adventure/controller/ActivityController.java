package com.example.adventure.controller;

import com.example.adventure.model.Activity;
import com.example.adventure.service.ActivityJPA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

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
}
