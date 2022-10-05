package com.example.adventure.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import java.sql.Time;
import java.util.Date;

@Data
@ToString
public class ShiftAndActivity {
    private Long shiftId;
    private Date date;
    private Time startTime;
    private Time endTime;

    private Long activityId;
    private String name;
    private String description;
    private int price;
}
