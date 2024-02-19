package org.example.routineplanner.model;

import jakarta.persistence.*;

@Entity
@Table(name="activity")
public class Activity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;

    private int color;
    private int iconId;

    public Activity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIcon_id() {
        return iconId;
    }

    public void setIcon(int iconId) {
        this.iconId = iconId;
    }
}
