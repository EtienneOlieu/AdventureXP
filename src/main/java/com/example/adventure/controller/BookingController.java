package com.example.adventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @GetMapping("/bookActivity/{activity}")
    public String bookActivity(@PathVariable String activity, Model activityToView){
        activityToView.addAttribute("activity", activity);
        return "/book-activity";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String date,
                              @RequestParam String startTime,
                              @RequestParam String endTime,
                              @RequestParam String numberOfPeople){
        System.out.println(name);
        System.out.println(surname);
        System.out.println(date);
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(numberOfPeople);
        return "success";
    }

    @GetMapping("/groupBooking")
    public String groupBooking(){
        return "/group-booking";
    }

    @PostMapping("/saveGroupBooking")
    public String saveGroupBooking(@RequestParam String name,
                                   @RequestParam String surname,
                                   @RequestParam String date,
                                   @RequestParam String startTime,
                                   @RequestParam String endTime,
                                   @RequestParam String numberOfPeople,
                                   @RequestParam(required = false) String paintball,
                                   @RequestParam(required = false) String goCart,
                                   @RequestParam(required = false) String sumoWrestling,
                                   @RequestParam(required = false) String minigolf)
    {

        System.out.println(name);
        System.out.println(surname);
        System.out.println(date);
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(numberOfPeople);
        System.out.println(paintball);
        System.out.println(goCart);
        System.out.println(sumoWrestling);
        System.out.println(minigolf);
        return "/success";
    }
}
