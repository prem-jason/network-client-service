package com.bloomberg.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.grpc.Server;

public class GrpcServerFactoryTest {

    private GrpcServerFactory grpcServerFactory;

    @Before
    public void setup() {
        grpcServerFactory = new GrpcServerFactory();
    }

    @Test
    public void getServer_validInputs_server() {

        final Server server = grpcServerFactory.getServer();
        assertNotNull(server);
    }

    @Test
    public void setPort() {
        grpcServerFactory.setPort(100);
    }

}
