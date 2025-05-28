package org.example.chain.handler;

import org.example.chain.exception.ValidatorException;

public class MinValidatorHandler implements ValidatorHandler {

    private final int min;

    public MinValidatorHandler(int min) {
        this.min = min;
    }

    @Override
    public void validate(Object value) {
        if (value instanceof Integer) {
            if ((Integer) value < min) {
                throw new ValidatorException("min value is " + min + " but actual value is " + value);
            }
        }
    }
}
