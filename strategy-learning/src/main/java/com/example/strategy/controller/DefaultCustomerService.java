package com.example.strategy.controller;

import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "找不到客服";
    }
}
