package com.example.adventure.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "Requirements")
// Alt udkommenteret kode er til senere udvidelse af db
//@SecondaryTable(name = "Req_age", pkJoinColumns = @PrimaryKeyJoinColumn(name = "req_id"))
//@SecondaryTable(name = "Req_height", pkJoinColumns = @PrimaryKeyJoinColumn(name = "req_id"))
//@SecondaryTable(name = "Req_attendants", pkJoinColumns = @PrimaryKeyJoinColumn(name = "req_id"))
public class Requirements {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    public Long Id;

    @Column//(name = "minimumAttendants", table = "Req_attendants")
    public int minimumAttendants;

    @Column//(name = "maximumAttendants", table = "Req_attendants")
    public int maximumAttendants;

    @Column
    public int alcoholLevel;

    @Column
    public int maxWeight;

    @Column//(name = "minimumHeight", table = "Req_height")
    public int minimumHeight;

    @Column//(name = "maximumHeight", table = "Req_height")
    public int maximumHeight;

    @Column//(name = "minimumAge", table = "Req_age")
    public int minimumAge;

    @Column//(name = "maximumAge", table = "Req_age")
    public int maximumAge;

    @Column
    public String requirementsDescrip;


    public Requirements() {
        super();
    }
}
