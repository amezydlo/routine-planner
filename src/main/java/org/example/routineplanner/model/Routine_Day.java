package org.example.routineplanner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

@Entity
public class Routine_Day {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
    @JsonBackReference
    private Routine routine;


    public Routine_Day() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
