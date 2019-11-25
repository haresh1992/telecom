package com.telecom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelecomProjectApplication {

	private static final Logger logger = LogManager.getLogger(TelecomProjectApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(TelecomProjectApplication.class, args);

		logger.info("Service Started");
	}

}
