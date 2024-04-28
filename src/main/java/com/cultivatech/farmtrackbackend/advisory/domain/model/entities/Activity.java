package com.cultivatech.farmtrackbackend.advisory.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "activities")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "project_id")
    private long projectId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="date")
    private String date;

    @Column(name = "completed")
    private boolean completed;

}
