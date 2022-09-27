package com.example.adventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActivityControllerNoRest {

    @GetMapping("/show-activity-list")
    public String showActivityList(){
        return "ActivityListAdmin";
    }
}
