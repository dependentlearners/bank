package com.dependentlearners.services.customer.controller;

import com.dependentlearners.common.representation.Customer;
import com.dependentlearners.services.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long id){
        return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
    }

}
