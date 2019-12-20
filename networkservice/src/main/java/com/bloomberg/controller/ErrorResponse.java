package com.bloomberg.controller;

/**
 * encapsulates an error.
 */
public class ErrorResponse {

    private int statusCode;
    private String message;

    /**
     * Default Constructor
     */
    public ErrorResponse() {
    }

    /**
     * Creates ErrorResponse based on statusCode and message
     *
     * @param statusCode
     * @param message
     */
    public ErrorResponse(final int statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode
     *            the statusCode to set
     */
    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }

}
