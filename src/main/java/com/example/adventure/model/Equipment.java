package com.example.adventure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Equipment(){

    }
    @Column
    public String name;
}
