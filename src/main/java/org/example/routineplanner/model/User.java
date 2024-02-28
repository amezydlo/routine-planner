package org.example.routineplanner.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "my_user",uniqueConstraints = @UniqueConstraint(columnNames={"username", "userTag"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "user_tag", length = 6, nullable = false)
    private String userTag;

    @OneToMany(mappedBy = "user")
    private List<Routine> routines = new ArrayList<>();

    public User() {

    }
}
