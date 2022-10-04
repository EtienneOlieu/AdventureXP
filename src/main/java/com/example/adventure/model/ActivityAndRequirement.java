package com.example.adventure.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

@Data
@ToString
public class ActivityAndRequirement {

    private Long activityId;
    private String name;
    private String description;
    private int price;

    private Long requirementId;
    private int minimumAttendants;
    private int maximumAttendants;
    private int alcoholLevel;
    private int maxWeight;
    private int minimumHeight;
    private int maximumHeight;
    private int minimumAge;
    private int maximumAge;
    private String requirementsDescrip;

}
