package com.example.strategy.controller;

import org.springframework.stereotype.Service;

@SupportUserType(UserType.NORMAL)
@Service
public class NormalCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "🍇客服";
    }
}
