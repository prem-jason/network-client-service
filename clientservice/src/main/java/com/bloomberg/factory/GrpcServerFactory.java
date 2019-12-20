package com.bloomberg.factory;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bloomberg.exception.FailedToCreateGrpcServerException;
import com.bloomberg.service.MultiplicationServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * GrpcServerFactory creates gRPC Server
 */
@Configuration
public class GrpcServerFactory {

    private static final Logger log = LogManager.getLogger(GrpcServerFactory.class);

    private int port;

    /**
     * getServer method creates gRPC Server and returns gRPC Server as bean
     *
     * @return Server
     */
    @Bean
    public Server getServer() {

        try {
            return createServer();
        } catch (final IOException e) {
            throw new FailedToCreateGrpcServerException("failed to create gRPC Server", e);
        }
    }

    /**
     * Sets the port
     *
     * @param port
     */
    @Value("${grpc.server.port}")
    public void setPort(final int port) {
        this.port = port;
    }

    private Server createServer() throws IOException {
        // Create a new server to listen on port
        final Server server = ServerBuilder.forPort(port).addService(new MultiplicationServiceImpl()).build();

        // Start the server
        server.start();

        log.info("created grpc server on port {}", port);
        return server;
    }
}
