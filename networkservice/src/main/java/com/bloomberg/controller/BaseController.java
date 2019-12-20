package com.bloomberg.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Base Rest Controller encapsulates error handling
 */
@RequestMapping("networkservice")
public abstract class BaseController {

    private Logger log = LogManager.getLogger(BaseController.class);
    private static final String HTTP_STATUS_ERROR = "Returning {}";

    /**
     * Executed when runtime exception is thrown
     *
     * @param exception
     * @param response
     * @return ErrorResponse
     */
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handlingRuntimeException(final Throwable exception, final HttpServletResponse response) {
        log.error(HTTP_STATUS_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, exception);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }

}
