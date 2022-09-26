package com.example.adventure.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Krav {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

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
