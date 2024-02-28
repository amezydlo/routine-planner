package org.example.routineplanner.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.Duration;
import java.util.UUID;

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
    @JoinColumn(name="activity_block_id", referencedColumnName = "id", nullable = false)
    private ActivityBlock activityBlock;

    public Activity() {

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", tag=" + tag +
                ", duration=" + duration +
                '}';
    }
}
