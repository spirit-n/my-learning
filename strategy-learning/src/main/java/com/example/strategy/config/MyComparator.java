package com.example.strategy.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class MyComparator implements Comparator<Object>, BeanFactoryPostProcessor {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof CommonAnnotationBeanPostProcessor && o2 instanceof AutowiredAnnotationBeanPostProcessor) {
            return -1;
        }
        return 0;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ((DefaultListableBeanFactory)beanFactory).setDependencyComparator(this::compare);
    }
}
