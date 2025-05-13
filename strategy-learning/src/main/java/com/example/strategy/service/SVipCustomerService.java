package com.example.strategy.service;

import com.example.strategy.annotation.SupportUserType;
import com.example.strategy.enums.UserType;
import org.springframework.stereotype.Service;

@SupportUserType(UserType.SVIP)
@Service
public class SVipCustomerService implements CustomerService{
    @Override
    public String findCustomer() {
        return "SVIP客服";
    }
}
