package com.bloomberg.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * GrpcManagedChannelFactory class creates the gRPC ManagedChannel
 */
@Configuration
public class GrpcManagedChannelFactory {

    private String serverIP;
    private int port;

    /**
     * getManagedChannel creates ManagedChannel Bean
     *
     * @return ManagedChannel
     */
    @Bean
    public ManagedChannel getManagedChannel() {
        return ManagedChannelBuilder.forTarget(serverIP + ":" + port).usePlaintext(true).build();
    }

    /**
     * Sets the gRPC ServerIP
     *
     * @param serverIP
     */
    @Value("${grpc.server.ip}")
    public void setServerIP(final String serverIP) {
        this.serverIP = serverIP;
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

}
