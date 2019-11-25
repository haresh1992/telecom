package com.telecom.service;

import com.telecom.dto.SimCardDTO;
import com.telecom.request.SimCardRequest;

public interface ISimCardService {

    SimCardDTO createSimCard(SimCardRequest simCardRequest);

}
