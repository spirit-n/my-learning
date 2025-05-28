package org.example.chain.validation;

import org.example.chain.annotation.Length;
import org.example.chain.annotation.Max;
import org.example.chain.annotation.Min;
import org.example.chain.handler.LengthValidatorHandler;
import org.example.chain.handler.MaxValidatorHandler;
import org.example.chain.handler.MinValidatorHandler;

import java.lang.reflect.Field;

public class Validator {


    public void validate(Object bean) throws Exception {
        Class<?> beanClass = bean.getClass();
        for (Field field : beanClass.getDeclaredFields()) {
            field.setAccessible(true);

            ValidatorChain validatorChain = buildValidatorChain(field);

            validatorChain.validate(field.get(bean));

        }
    }

    private ValidatorChain buildValidatorChain(Field field ) {
        ValidatorChain validatorChain = new ValidatorChain();
        Length length = field.getAnnotation(Length.class);
        if(length != null){
            validatorChain.addLastValidator(new LengthValidatorHandler(length.value()));
        }
        Min min = field.getAnnotation(Min.class);
        if(min != null){
            validatorChain.addLastValidator(new MinValidatorHandler(min.value()));
        }

        Max max = field.getAnnotation(Max.class);
        if(max != null){
            validatorChain.addLastValidator(new MaxValidatorHandler(max.value()));
        }


        return validatorChain;
    }
}
