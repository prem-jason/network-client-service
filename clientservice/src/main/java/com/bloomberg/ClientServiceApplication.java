package com.bloomberg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the ClientService Application
 */
@SpringBootApplication
public class ClientServiceApplication {

    private static final Logger log = LogManager.getLogger(ClientServiceApplication.class);

    private static ExecutorService executorService;

    /**
     * main method starts the ClientServiceApplication
     *
     * @param args
     */
    public static void main(final String[] args) {

        SpringApplication.run(ClientServiceApplication.class, args);
        keepApplicationAlive();
    }

    /**
     * killClientServiceApplication used to terminate or shutdown the ClientServiceApplication
     */
    public static void killClientServiceApplication() {
        log.info("Terminating ClientServiceApplication");
        executorService.shutdown();
        executorService = null;
    }

    private static void keepApplicationAlive() {
        executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("Keeping ClientServiceApplication alive"));
    }

}
