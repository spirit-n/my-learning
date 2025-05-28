package org.example.chain.handler;

import org.example.chain.exception.ValidatorException;

public class LengthValidatorHandler implements ValidatorHandler {

    private final int length;

    public LengthValidatorHandler(int length) {
        this.length = length;
    }

    @Override
    public void validate(Object value) {
        if (value instanceof String) {
            if (((String) value).length() != length) {
                throw new ValidatorException("length is " + length + " but actual length is " + ((String) value).length());
            }
        }
    }
}
