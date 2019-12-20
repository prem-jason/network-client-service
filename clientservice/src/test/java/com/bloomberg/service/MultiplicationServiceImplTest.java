package com.bloomberg.service;

import org.junit.*;

import com.bloomberg.grpc.api.MathServiceOuterClass;
import com.bloomberg.grpc.api.MathServiceOuterClass.MathResponse;

import io.grpc.stub.StreamObserver;

public class MultiplicationServiceImplTest {

    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Before
    public void setup() {
        multiplicationServiceImpl = new MultiplicationServiceImpl();
    }

    @Test
    public void sendRequest_validInputs_result() {

        final MathServiceOuterClass.MathRequest request = MathServiceOuterClass.MathRequest.newBuilder().setA(1).setB(2).build();

        final StreamObserverStub streamObserver = new StreamObserverStub();

        multiplicationServiceImpl.sendRequest(request, streamObserver);

        Assert.assertEquals(String.valueOf(2), streamObserver.getResult());
    }

    private class StreamObserverStub implements StreamObserver<MathResponse> {

        private String result;

        @Override
        public void onNext(final MathResponse response) {
            this.result = response.getResult();
        }

        @Override
        public void onError(final Throwable t) {
        }

        @Override
        public void onCompleted() {
        }

        public String getResult() {
            return this.result;
        }

    }

}
