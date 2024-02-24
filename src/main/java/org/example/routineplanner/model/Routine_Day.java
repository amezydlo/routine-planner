package org.example.routineplanner.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashMap;

@Entity
public class Routine_Day {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "day_number")
    private int dayNumber;


    @ManyToMany
    @MapKeyTemporal(TemporalType.TIMESTAMP)
    @JoinTable(name = "routine_day_activities",
            joinColumns = @JoinColumn(name = "tag_time"),
            inverseJoinColumns = @JoinColumn(name = "activity"))
    private HashMap<Timestamp, ActivityBlock> activities;
}
