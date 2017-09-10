package com.dependentlearners.presentation.mobile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionResource transactionResource;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTransaction(@PathVariable long id){
        return transactionResource.getTransactionById(id);
    }
}
