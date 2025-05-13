package com.example.strategy.controller;

import org.springframework.stereotype.Service;

@SupportUserType(UserType.SVIP)
@Service
public class SVipCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "SVIP客服";
    }
}
