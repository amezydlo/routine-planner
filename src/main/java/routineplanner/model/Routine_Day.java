package routineplanner.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "routine_day")
public class Routine_Day {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "day_number", nullable = false)
    private int dayNumber;


    @ManyToMany
    @MapKeyTemporal(TemporalType.TIMESTAMP)
    @JoinTable(name = "routine_day_activities",
            joinColumns = @JoinColumn(name = "tag_time"),
            inverseJoinColumns = @JoinColumn(name = "activity"))
    private HashMap<Timestamp, ActivityBlock> activities = new HashMap<>();


    @ManyToOne
    @JoinColumn(name = "routine_id", nullable = false)
    @JsonBackReference
    private Routine routine;

}
