package org.example.routineplanner.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "activity_block")
public class ActivityBlock {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // @OrderColumn - pozwala na zachowanie kolejności kolekcji (tutaj insertowania)

    @OrderColumn
    @OneToMany(mappedBy = "activityBlock", cascade = CascadeType.ALL)
    private List<Activity> activities;

    public ActivityBlock() {

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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
