package org.example.routineplanner.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routine")
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @ManyToOne(optional = false)
    @JsonIgnoreProperties("routines")
    private User user;

    @OneToMany(mappedBy = "routine")
    @OrderBy(value = "dayNumber")
    @JsonManagedReference
    private List<Routine_Day> routineDays = new ArrayList<>();


    public Routine() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
