package com.bloomberg.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bloomberg.exception.GrpcServerUnavailableException;

public class ClientServiceImplTest {

    private ClientServiceImpl clientServiceImpl;

    @Before
    public void setup() {
        clientServiceImpl = new ClientServiceImpl();
    }

    @Test(expected = GrpcServerUnavailableException.class)
    public void multiplication_serverUnavailable_throwsException() {

        final String result = clientServiceImpl.multiplication(10, 20);

        Assert.assertEquals("200", result);
    }

}
