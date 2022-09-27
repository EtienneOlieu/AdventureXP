package com.example.adventure.controller;

import com.example.adventure.model.Activity;
import com.example.adventure.model.Requirements;
import com.example.adventure.service.ActivityService;
import com.example.adventure.service.RequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class RequirementControllerNoRest {

    @Autowired
    RequirementsService requirementsService;
    @Autowired
    ActivityService activityService;

    @GetMapping("/show-requirement/{activity_id}")
    public String showRequirement(@PathVariable long activity_id, Model model){
        Optional<Activity> activity = activityService.findById(activity_id);
        if (activity.isPresent()) {
           Optional<Requirements> requirements = requirementsService.findById(activity.get().getRequirements().getId());
            if (requirements.isPresent()) {
                System.out.print(requirements.get().getAlcoholLevel());
                model.addAttribute("requirements", requirements.get());
                return "/KravListe";
            }
        }
        return "/error";
    }
}
