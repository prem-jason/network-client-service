package com.bloomberg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the ApplicationNetworkServiceApplication
 */
@SpringBootApplication
public class NetworkServiceApplication {

    private static final Logger log = LogManager.getLogger(NetworkServiceApplication.class);

    /**
     * main method starts the NetworkServiceApplication
     *
     * @param args
     */
    public static void main(final String[] args) {

        log.info("Starting NetworkServiceApplication");
        SpringApplication.run(NetworkServiceApplication.class, args);
    }
}
