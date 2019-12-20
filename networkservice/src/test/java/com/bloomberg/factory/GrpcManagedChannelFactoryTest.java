package com.bloomberg.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.grpc.ManagedChannel;

public class GrpcManagedChannelFactoryTest {

    private GrpcManagedChannelFactory grpcManagedChannelFactory;

    @Before
    public void setup() {
        grpcManagedChannelFactory = new GrpcManagedChannelFactory();
    }

    @Test
    public void getManagedChannel_validInputs_createManagedChannel() {

        final ManagedChannel managedChannel = grpcManagedChannelFactory.getManagedChannel();

        assertNotNull(managedChannel);
    }

}
