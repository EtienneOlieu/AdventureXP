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
    @CrossOrigin
    public ResponseEntity<?> saveActivity(@RequestBody ActivityAndRequirement activityAndRequirement){
        Activity savedActivity = new Activity();

        Requirement requirements = new Requirement();
        requirements.setMinimumAttendants(activityAndRequirement.getMinimumAttendants());
        requirements.setMaximumAttendants(activityAndRequirement.getMaximumAttendants());
        requirements.setAlcoholLevel(activityAndRequirement.getAlcoholLevel());
        requirements.setMaxWeight(activityAndRequirement.getMaxWeight());
        requirements.setMinimumHeight(activityAndRequirement.getMinimumHeight());
        requirements.setMaximumHeight(activityAndRequirement.getMaximumHeight());
        requirements.setMinimumAge(activityAndRequirement.getMinimumAge());
        requirements.setMaximumAge(activityAndRequirement.getMaximumAge());
        requirements.setRequirementsDescrip(activityAndRequirement.getRequirementsDescrip());
        Requirement savedRequirements = requirementJPA.save(requirements);
        if (savedRequirements != null) {
            System.out.println("Saved Requirement" + savedRequirements);
            Activity activity = new Activity();
            activity.setName(activityAndRequirement.getName());
            activity.setDescription(activityAndRequirement.getDescription());
            activity.setPrice(activityAndRequirement.getPrice());
            activity.setRequirement(savedRequirements);
            savedActivity = activityJPA.save(activity);
        }
        return new ResponseEntity<>(savedActivity, HttpStatus.OK);
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
            Long id = activity.getRequirement().getId();
            Requirement requirement = requirementJPA.findById(id).get();
            activityAndRequirement.setActivityId(activity.getId());
            activityAndRequirement.setName(activity.getName());
            activityAndRequirement.setDescription(activity.getDescription());
            activityAndRequirement.setPrice(activity.getPrice());
            activityAndRequirement.setRequirementId(id);
            activityAndRequirement.setMinimumAttendants(requirement.getMinimumAttendants());
            activityAndRequirement.setMaximumAttendants(requirement.getMaximumAttendants());
            activityAndRequirement.setAlcoholLevel(requirement.getAlcoholLevel());
            activityAndRequirement.setMaxWeight(requirement.getMaxWeight());
            activityAndRequirement.setMinimumHeight(requirement.getMinimumHeight());
            activityAndRequirement.setMaximumHeight(requirement.getMaximumHeight());
            activityAndRequirement.setMinimumAge(requirement.getMinimumAge());
            activityAndRequirement.setMaximumAge(requirement.getMaximumAge());
            activityAndRequirement.setRequirementsDescrip(requirement.getRequirementsDescrip());
            activityAndRequirements.add(activityAndRequirement);
        });
        return new ResponseEntity<>(activityAndRequirements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<ActivityAndRequirement> getActivityById(@PathVariable Long id){
        Optional<Activity> activity = activityJPA.findById(id);
        Long activityId = activity.get().getRequirement().getId();
        Optional<Requirement> requirement = requirementJPA.findById(activityId);
        ActivityAndRequirement activityAndRequirement = new ActivityAndRequirement();
        activityAndRequirement.setActivityId(activity.get().getId());
        activityAndRequirement.setName(activity.get().getName());
        activityAndRequirement.setDescription(activity.get().getDescription());
        activityAndRequirement.setPrice(activity.get().getPrice());
        activityAndRequirement.setRequirementId(requirement.get().getId());
        activityAndRequirement.setMinimumAttendants(requirement.get().getMinimumAttendants());
        activityAndRequirement.setMaximumAttendants(requirement.get().getMaximumAttendants());
        activityAndRequirement.setAlcoholLevel(requirement.get().getAlcoholLevel());
        activityAndRequirement.setMaxWeight(requirement.get().getMaxWeight());
        activityAndRequirement.setMinimumHeight(requirement.get().getMinimumHeight());
        activityAndRequirement.setMaximumHeight(requirement.get().getMaximumHeight());
        activityAndRequirement.setMinimumAge(requirement.get().getMinimumAge());
        activityAndRequirement.setMaximumAge(requirement.get().getMaximumAge());
        activityAndRequirement.setRequirementsDescrip(requirement.get().getRequirementsDescrip());
        return new ResponseEntity<>(activityAndRequirement, HttpStatus.OK);
    }

  /*  @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable Activity activity){
*/
        @PutMapping()
        @CrossOrigin
        public ResponseEntity<?> updateActivity(@RequestBody ActivityAndRequirement activityAndRequirement){
            Optional<Activity> activityToUpdate = activityJPA.findById(activityAndRequirement.getActivityId());
            Optional<Requirement> requirementToUpdate = requirementJPA.findById(activityAndRequirement.getRequirementId());
            if (activityToUpdate.isPresent() && requirementToUpdate.isPresent()) {
                Requirement requirement = requirementToUpdate.get();
                requirement.setId(requirement.getId());
                requirement.setMinimumAttendants(activityAndRequirement.getMinimumAttendants());
                requirement.setMaximumAttendants(activityAndRequirement.getMaximumAttendants());
                requirement.setAlcoholLevel(activityAndRequirement.getAlcoholLevel());
                requirement.setMaxWeight(activityAndRequirement.getMaxWeight());
                requirement.setMinimumHeight(activityAndRequirement.getMinimumHeight());
                requirement.setMaximumHeight(activityAndRequirement.getMaximumHeight());
                requirement.setMinimumAge(activityAndRequirement.getMinimumAge());
                requirement.setMaximumAge(activityAndRequirement.getMaximumAge());
                requirement.setRequirementsDescrip(activityAndRequirement.getRequirementsDescrip());

                Requirement savedRequirement = requirementJPA.save(requirement);

                Activity activity = activityToUpdate.get();
                activity.setId(activity.getId());
                activity.setName(activityAndRequirement.getName());
                activity.setDescription(activityAndRequirement.getDescription());
                activity.setPrice(activityAndRequirement.getPrice());
                activity.setRequirement(savedRequirement);
                System.out.println("Activity before save" + activity);
                Activity savedActivity = activityJPA.save(activity);
                System.out.println("Activity after save" + savedActivity);

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
