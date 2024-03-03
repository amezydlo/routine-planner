package routineplanner.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "my_user", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "userTag"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "user_tag", length = 6, nullable = false)
    private String userTag;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user") // TODO warning
    private List<Routine> routines = new ArrayList<>();


}
