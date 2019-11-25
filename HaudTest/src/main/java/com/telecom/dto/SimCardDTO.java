package com.telecom.dto;

import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimCardDTO {

    private long id;

    private long imei;

    private long simno;
    
    private String createdBy;
    
    private Timestamp createdOn;
    
    private String updatedBy;

    private Timestamp updatedOn;
    
}
