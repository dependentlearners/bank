package com.dependentlearners.services.customer.service;

import com.dependentlearners.common.constant.CustomerType;
import com.dependentlearners.common.representation.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomerById(long customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName("Ankit");
        customer.setType(CustomerType.PERSON);
        return customer;
    }
}
