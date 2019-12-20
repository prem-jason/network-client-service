package com.bloomberg.exception;

/**
 * FailedToCreateGrpcServerException
 */
public class FailedToCreateGrpcServerException extends RuntimeException {

    private static final long serialVersionUID = -2784524733558464841L;

    /**
     * Constructor for Failed to create gRPC Server
     *
     * @param errorMessage
     * @param err
     */
    public FailedToCreateGrpcServerException(final String errorMessage, final Throwable err) {
        super(errorMessage, err);
    }
}
