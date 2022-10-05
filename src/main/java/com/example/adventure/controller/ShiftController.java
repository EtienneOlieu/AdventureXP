package com.example.adventure.controller;

import com.example.adventure.model.Activity;
import com.example.adventure.model.Shift;
import com.example.adventure.model.ShiftAndActivity;
import com.example.adventure.service.ActivityService;
import com.example.adventure.service.ShiftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/shift")
public class ShiftController {

    private ShiftService shiftService;
    private ActivityService activityService;

    public ShiftController(ShiftService shiftService, ActivityService activityService) {
        this.shiftService = shiftService;
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<?> allShifts(){
        return new ResponseEntity<>(shiftService.findAll(), HttpStatus.OK);
    }

    @PermitAll
    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> saveShift(@RequestBody ShiftAndActivity shiftAndActivity){

        Optional<Activity> activity = activityService.findById(shiftAndActivity.getActivityId());

        if (activity.isPresent()){
            Shift shift = new Shift();
            shift.setEmployeeName(shiftAndActivity.getEmployeeName());
            shift.setStartTime(shiftAndActivity.getStartTime());
            shift.setEndTime(shiftAndActivity.getEndTime());
            shift.setActivity(activity.get());
            Shift savedShift = shiftService.save(shift);
            return new ResponseEntity<>(savedShift, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Shift(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShift(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShift(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
