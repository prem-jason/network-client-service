package com.bloomberg.service;

/**
 * ClientService defines multiplication operation
 */
public interface ClientService {

    /**
     * multiplication used to calculate multiplication of two integer number using Grpc client
     *
     * @param operand1
     * @param operand2
     * @return
     */
    String multiplication(int operand1, int operand2);

}
