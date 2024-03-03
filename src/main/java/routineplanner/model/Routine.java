package routineplanner.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
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

}
