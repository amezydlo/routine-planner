package routineplanner.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {
    // maybe name should be PK ?
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "color_rgb", nullable = false)
    private int color;

    @Column(name = "icon_id", nullable = false)
    private int iconId;

}
