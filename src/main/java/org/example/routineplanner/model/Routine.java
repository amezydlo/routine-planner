package org.example.routineplanner.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routine")
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @OneToMany(mappedBy = "routine")
    @OrderBy(value = "dayNumber")
    private List<Routine_Day> routineDays = new ArrayList<>();

    public Routine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
