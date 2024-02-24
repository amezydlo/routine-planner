package org.example.routineplanner.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "activity_block")
public class ActivityBlock {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // @OrderColumn - pozwala na zachowanie kolejności kolekcji (tutaj insertowania)

    @OrderColumn
    @OneToMany(mappedBy = "activityBlock", cascade = CascadeType.ALL)
    private List<Activity> activities;


}
