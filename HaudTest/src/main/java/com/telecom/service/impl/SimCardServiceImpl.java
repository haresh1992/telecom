package com.telecom.service.impl;

import com.telecom.dto.SimCardDTO;
import com.telecom.mapper.SimCardMapper;
import com.telecom.model.SimCard;
import com.telecom.repository.ISimCardRepository;
import com.telecom.request.SimCardRequest;
import com.telecom.service.ISimCardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimCardServiceImpl implements ISimCardService {

    private static final Logger logger = LogManager.getLogger(SimCardServiceImpl.class);

    @Autowired
    private ISimCardRepository simCardRepository;

    /**
     * This API is used to save SimCard
     * @param simCardRequest
     * @return SimCardDTO
     */
    @Override
    public SimCardDTO createSimCard(SimCardRequest simCardRequest) {

        logger.info("SimCardServiceImpl : createSimCard Method Called");

        SimCardDTO simCardDTO;

        try {

            SimCard simCard = SimCardMapper.toSimCard(simCardRequest);
            simCard.setCreatedBy(simCardRequest.getLoginUserName());
            simCard = simCardRepository.save(simCard);

            logger.info("SimCard Added.");

            simCardDTO = SimCardMapper.toSimCardDTO(simCard);

        } catch (Exception ex) {

            logger.error(ex.getMessage(), ex);
            throw ex;
        }

        return simCardDTO;
    }
}
