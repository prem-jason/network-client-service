package com.bloomberg.controller;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bloomberg.service.ClientService;

public class NetworkServiceControllerTest {

    private NetworkServiceController networkServiceController;

    @Before
    public void setup() {
        networkServiceController = new NetworkServiceController();
    }

    @Test
    public void multiplication_validInput_validResult() {
        final ClientService clientService = createMock(ClientService.class);
        networkServiceController.setClientService(clientService);

        expect(clientService.multiplication(anyInt(), anyInt())).andReturn(String.valueOf(200));
        replay(clientService);
        final String result = networkServiceController.multiplication(10, 20);
        verify(clientService);

        assertEquals("200", result);
    }

}
