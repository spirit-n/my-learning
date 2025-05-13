package com.example.strategy.service;

import com.example.strategy.annotation.SupportUserType;
import com.example.strategy.enums.UserType;
import org.springframework.stereotype.Service;

@SupportUserType(UserType.NORMAL)
@Service
public class NormalCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "🍇客服";
    }
}
