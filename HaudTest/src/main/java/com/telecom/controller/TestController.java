package com.telecom.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);


    /**
     * Health check string.
     *
     * @return the string
     */
    @RequestMapping(value="/healthCheck")
    public String healthCheck()
    {
        logger.info("Test Controller");

        return "Test Controller Response";
    }

}
