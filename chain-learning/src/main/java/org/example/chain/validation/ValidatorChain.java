package org.example.chain.validation;

import org.example.chain.exception.ValidatorException;
import org.example.chain.handler.ValidatorHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {
    private List<ValidatorHandler> handlers = new ArrayList<>();

    public void validate(Object value) throws ValidatorException {
        for (ValidatorHandler handler : handlers) {
            handler.validate(value);
        }
    }

    public void addLastValidator(ValidatorHandler handler){
        this.handlers.add(handler);
    }
}
