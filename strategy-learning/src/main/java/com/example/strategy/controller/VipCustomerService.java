package com.example.strategy.controller;

import org.springframework.stereotype.Service;

@SupportUserType(UserType.VIP)
@Service
public class VipCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "VIP客服";
    }
}
