package com.example.adventure.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Product(){

    }
    @Column
    public String name;

    @Column
    public double price;

}
