package com.example.strategy.controller;

import com.example.strategy.annotation.SupportUserType;
import com.example.strategy.enums.UserType;
import com.example.strategy.service.CustomerService;
import com.example.strategy.service.DefaultCustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private Map<UserType, CustomerService> customerServiceMap;

    @Resource
    private DefaultCustomerService defaultCustomerService;

    @GetMapping("/customer/{recharge}")
    public String customer(@PathVariable(value = "recharge") int recharge) {
        UserType userType = UserType.typeOf(recharge);

        CustomerService customerService = customerServiceMap.getOrDefault(userType,defaultCustomerService);

        return customerService.findCustomer();
    }

    @Resource
    public void setCustomerServiceMap(List<CustomerService> customerServiceList) {
        this.customerServiceMap = customerServiceList.stream()
                .filter(customerService -> customerService.getClass().isAnnotationPresent(SupportUserType.class))
                .collect(Collectors.toMap(
                this::findUserType,
                Function.identity(),
                (existing, replacement) -> existing // 或者选择 replacement，根据业务决定
        ));
    }

    private UserType findUserType(CustomerService customerService) {
        SupportUserType annotation = customerService.getClass().getAnnotation(SupportUserType.class);
        return annotation.value();
    }


    public void setDefaultCustomerService(DefaultCustomerService defaultCustomerService) {
        this.defaultCustomerService = defaultCustomerService;
    }
}
