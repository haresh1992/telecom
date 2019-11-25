package com.telecom.response;

import com.telecom.model.SimCard;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private long id;

    private String name;

    private String emailId;

    private List<SimCard> simCards =  new ArrayList<>();

    private String createdBy;

    private Timestamp createdOn;

    private String updatedBy;

    private Timestamp updatedOn;


}
