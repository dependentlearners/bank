package com.dependentlearners.services.customer.service;

import com.dependentlearners.common.constant.CustomerType;
import com.dependentlearners.common.representation.Customer;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    public Customer getCustomerById(long customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setName("Ankit");
        customer.setType(CustomerType.PERSON);
        return customer;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setCustomerId(1);
        customer1.setName("Ankit");
        customer1.setType(CustomerType.PERSON);
        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setName("Singh");
        customer2.setType(CustomerType.PERSON);
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }

}
