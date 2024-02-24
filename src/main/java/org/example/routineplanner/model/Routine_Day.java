package org.example.routineplanner.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashMap;

@Entity
public class Routine_Day {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "day_number", nullable = false)
    private int dayNumber;


    @ManyToMany
    @MapKeyTemporal(TemporalType.TIMESTAMP)
    @JoinTable(name = "routine_day_activities",
            joinColumns = @JoinColumn(name = "tag_time"),
            inverseJoinColumns = @JoinColumn(name = "activity"))
    private HashMap<Timestamp, ActivityBlock> activities = new HashMap<>();


    @ManyToOne
    @JoinColumn(name = "routine_id", nullable = false)
    private Routine routine;


    public Routine_Day() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }


    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}
