package com.example.adventure.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ActivityAndRequirement {

    private Long id;
    private String name;
    private String description;
    private int price;
    public int minimumAttendants;
    public int maximumAttendants;
    public int alcoholLevel;
    public int maxWeight;
    public int minimumHeight;
    public int maximumHeight;
    public int minimumAge;
    public int maximumAge;
    public String requirementsDescrip;

}
