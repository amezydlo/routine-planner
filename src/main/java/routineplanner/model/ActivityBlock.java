package routineplanner.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "activity_block")
public class ActivityBlock {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // @OrderColumn - pozwala na zachowanie kolejności kolekcji (tutaj insertowania) // TODO move to docs

    @OrderColumn
    @OneToMany(mappedBy = "activityBlock", cascade = CascadeType.ALL)
    private List<Activity> activities;
}
