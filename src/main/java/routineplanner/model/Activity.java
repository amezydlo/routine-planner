package routineplanner.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.Duration;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false)
    private Tag tag;

    @Column(name = "duration", nullable = false)
    @Check(name = "duration_positive_check", constraints = "duration > 0")
    private Duration duration;


    @ManyToOne
    @JoinColumn(name = "activity_block_id", referencedColumnName = "id", nullable = false)
    private ActivityBlock activityBlock;

}
