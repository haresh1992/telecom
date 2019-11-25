package com.telecom.controller;

import com.telecom.dto.SimCardDTO;
import com.telecom.mapper.SimCardMapper;
import com.telecom.request.SimCardRequest;
import com.telecom.response.SimCardResponse;
import com.telecom.service.ISimCardService;
import com.telecom.utils.HeadersHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/simcard")
public class SimCardController extends ExternalBaseController {

    private static final Logger logger = LogManager.getLogger(SimCardController.class);

    private HttpHeaders headers;

    @Autowired
    private ISimCardService simCardService;

    @RequestMapping(value = "/healthCheck")
    public String healthCheck() {
        logger.info("SimCard Controller");

        return "SimCard Controller Response";
    }

    @PostMapping
    public ResponseEntity createSimCard(@Valid @RequestBody SimCardRequest simCardRequest) {

        logger.info("SimCardController : createSimCard Method Called");

        headers = new HttpHeaders();

        try {

            SimCardDTO simCardDTO = simCardService.createSimCard(simCardRequest);

            SimCardResponse simCardResponse = SimCardMapper.toSimCardResponse(simCardDTO);

            logger.info("SimCard added.");

            HeadersHandler.parseHeadersOnSuccess(headers, "SimCard added.", "SimCard added Successfully.");

            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(simCardResponse);

        } catch (Exception ex) {

            HeadersHandler.parseHeadersOnSuccess(headers, ex.getMessage(), "Error while Adding new SimCard.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(null);
        }

    }
}
