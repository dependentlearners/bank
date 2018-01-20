package com.dependentlearners.presentation.mobile.api.controller;

import com.dependentlearners.common.representation.Customer;
import com.dependentlearners.common.resource.CustomerResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerResource customerResource;

    public CustomerController(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAll(){
        return customerResource.getCustomers();
    }

}
