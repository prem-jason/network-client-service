package com.bloomberg.exception;

/**
 * GrpcServerUnavailableException called when gRPC Server is Unavailable
 */
public class GrpcServerUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 2221261221450935596L;

    /**
     * Constructor for gRPC Server Unavailable Exception
     *
     * @param errorMessage
     * @param err
     */
    public GrpcServerUnavailableException(final String errorMessage, final Throwable err) {
        super(errorMessage, err);
    }

}
