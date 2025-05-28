package org.example.chain;

import org.example.chain.validation.Validator;
import org.example.chain.validation.ValidatorChain;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("张三aa", 111);
        Validator validator = new Validator();
        validator.validate(user);
    }
}
