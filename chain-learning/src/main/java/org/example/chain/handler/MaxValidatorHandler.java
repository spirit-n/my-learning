package org.example.chain.handler;

import org.example.chain.exception.ValidatorException;

public class MaxValidatorHandler implements ValidatorHandler {

    private final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }

    @Override
    public void validate(Object value) {
        if (value instanceof Integer) {
            if ((Integer) value > max) {
                throw new ValidatorException("max value is " + max + " but actual value is " + value);
            }
        }
    }
}
