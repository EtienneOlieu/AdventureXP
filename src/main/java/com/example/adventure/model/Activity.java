package com.example.adventure.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;
    private int price;

    //@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne()
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Requirement requirement;

    @OneToMany (mappedBy = "activity")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<Shift> activities = new HashSet<>();

}
