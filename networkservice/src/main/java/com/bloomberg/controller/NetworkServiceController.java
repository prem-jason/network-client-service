package com.bloomberg.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bloomberg.service.ClientService;

/**
 * NetworkServiceController is responsible for specific end points
 */
@RestController
public class NetworkServiceController extends BaseController implements NetworkService {

    private static final Logger log = LogManager.getLogger(NetworkServiceController.class);

    private ClientService clientService;

    @Override
    @GetMapping("/multiplication/{operand1}/{operand2}")
    @ResponseBody
    public String multiplication(@PathVariable("operand1") final int operand1, @PathVariable("operand2") final int operand2) {
        log.debug("the multiplication operand values received from URI are {}, {}", operand1, operand2);
        return clientService.multiplication(operand1, operand2);
    }

    /**
     * Sets ClientService
     *
     * @param clientService
     */
    @Autowired
    public void setClientService(final ClientService clientService) {
        this.clientService = clientService;
    }
}
