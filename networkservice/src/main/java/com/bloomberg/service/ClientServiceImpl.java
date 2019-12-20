package com.bloomberg.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bloomberg.exception.GrpcServerUnavailableException;
import com.bloomberg.grpc.api.MathServiceGrpc;
import com.bloomberg.grpc.api.MathServiceOuterClass;

import io.grpc.ManagedChannel;

/**
 * ClientServiceImpl implements multiplication method
 */
@Component
public class ClientServiceImpl implements ClientService {

    private static final Logger log = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    private ManagedChannel managedChannel;

    @Override
    public String multiplication(final int operand1, final int operand2) {

        try {

            final MathServiceGrpc.MathServiceBlockingStub stub = MathServiceGrpc.newBlockingStub(managedChannel);
            final MathServiceOuterClass.MathRequest request = MathServiceOuterClass.MathRequest.newBuilder().setA(operand1).setB(operand2).build();

            final MathServiceOuterClass.MathResponse response = stub.sendRequest(request);

            log.info("the result {} received from the multiplication operation", response.getResult());
            return response.getResult();
        } catch (final Exception e) {
            throw new GrpcServerUnavailableException("Issue connecting with Client Service", e);
        }
    }

}
