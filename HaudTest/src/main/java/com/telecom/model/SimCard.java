package com.telecom.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Simcard")
@Builder
public class SimCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "imei", nullable = false)
    private long imei;

    @Column(name = "simno", nullable = false)
    private long simno;
    
    @Column(name = "created_by", updatable = false, nullable = false, columnDefinition = "nvarchar(255)")
    private String createdBy;
    
    @Column(name = "created_on", updatable = false, nullable = false, columnDefinition = "datetime")
    private Timestamp createdOn;
    
    @Column(name = "updated_by", nullable = true, columnDefinition = "nvarchar(255)")
    private String updatedBy;

    @Column(name = "updated_on", nullable = true, columnDefinition = "datetime")
    private Timestamp updatedOn;
    
    @PrePersist
    public void onCreate() {

        this.createdOn = Timestamp.from(Instant.now());
    }

    @PreUpdate
    public void onUpdate() {

        this.updatedOn = Timestamp.from(Instant.now());
    }
}
