package com.example.adventure.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Requirements {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column
    public int minimumAttendants;

    @Column
    public int maximumAttendants;

    @Column
    public int alcoholLevel;

    @Column
    public int maxWeight;

    @Column
    public int minimumHeight;

    @Column
    public int maximumHeight;

    @Column
    public int minimumAge;

    @Column
    public int maximumAge;

    @Column
    public String requirementsDescrip;


    public Requirements() {
        super();
    }
}
