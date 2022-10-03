package com.example.adventure.controller;

import com.example.adventure.model.Activity;
import com.example.adventure.model.ActivityAndRequirement;
import com.example.adventure.model.Requirement;
import com.example.adventure.service.ActivityJPA;
import com.example.adventure.service.RequirementJPA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {
    ActivityJPA activityJPA;
    RequirementJPA requirementJPA;

    public ActivityController(ActivityJPA activityJPA, RequirementJPA requirementJPA) {
        this.activityJPA = activityJPA;
        this.requirementJPA =requirementJPA;
    }

    @PostMapping
    public ResponseEntity<?> saveActivity(@RequestBody Activity activity){
        Activity savedActivity = activityJPA.save(activity);
        if (savedActivity == null){
            return new ResponseEntity<>("Fejl i opretttelse af aktivitet", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(savedActivity, HttpStatus.OK);
        }
    }

/*    @GetMapping
    public ResponseEntity<Set<Activity>> getAllActivities(){
        Set allActivities = activityJPA.findAll();
        return new ResponseEntity<>(allActivities, HttpStatus.OK);
    }*/

    @GetMapping
    public ResponseEntity<List<ActivityAndRequirement>> getAllActivities(){
        Set<Activity> allActivities = activityJPA.findAll();
        List<ActivityAndRequirement> activityAndRequirements = new ArrayList<>();
        allActivities.forEach(activity -> {
            ActivityAndRequirement activityAndRequirement = new ActivityAndRequirement();
            Long id = activity.getId();
            Requirement requirement = requirementJPA.findById(id).get();
            activityAndRequirement.setName(activity.getName());
            activityAndRequirement.setDescription(activity.getDescription());
            activityAndRequirement.setPrice(activity.getPrice());
            activityAndRequirement.setId(requirement.getId());
            activityAndRequirements.add(activityAndRequirement);
        });
        return new ResponseEntity<>(activityAndRequirements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id){
        Optional<Activity> activity = activityJPA.findById(id);
        System.out.println(activity.get().getName());
        return new ResponseEntity<>(activity.get(), HttpStatus.OK);
    }

  /*  @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable Activity activity){
*/
        @PutMapping()
        @CrossOrigin
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable Long id){
        activityJPA.deleteById(id);
        return new ResponseEntity<>("Aktivitet med id " + id + " blev slettet", HttpStatus.OK);
    }

}
