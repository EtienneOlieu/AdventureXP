package com.example.adventure.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Time startTime;
    private Time endTime;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Activity activity;


}
