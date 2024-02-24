package org.example.routineplanner.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    // maybe name should be PK ?
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name ="name", nullable = false, unique = true)
    private String name;

    @Column(name = "color_rgb", nullable = false)
    private int color;

    @Column(name = "icon_id", nullable = false)
    private int iconId;

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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color=" + color +
                ", iconId=" + iconId +
                '}';
    }
}