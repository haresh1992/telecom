package com.telecom.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "emailId", nullable = false, columnDefinition = "nvarchar(50)")
    private String emailId;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id",referencedColumnName="id")
    private List<SimCard> simCards =  new ArrayList<>();
    
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
