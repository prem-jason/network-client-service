package com.bloomberg.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bloomberg.grpc.api.MathServiceGrpc;
import com.bloomberg.grpc.api.MathServiceOuterClass;

import io.grpc.stub.StreamObserver;

/**
 * MultiplicationServiceImpl Service used to perform multiplication of two integer numbers using gRPC API
 */
@Service
public class MultiplicationServiceImpl extends MathServiceGrpc.MathServiceImplBase {

    private static final Logger log = LogManager.getLogger(MultiplicationServiceImpl.class);

    /**
     * sendRequest method performs multiplication using gRPC API
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void sendRequest(final MathServiceOuterClass.MathRequest request,
                            final StreamObserver<MathServiceOuterClass.MathResponse> responseObserver) {

        final MathServiceOuterClass.MathResponse response = MathServiceOuterClass.MathResponse.newBuilder()
                .setResult(String.valueOf(request.getA() * request.getB())).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        log.info("the multiplication performed on the operands {}, {} and the result is {}", request.getA(), request.getB(), response.getResult());
    }

}
