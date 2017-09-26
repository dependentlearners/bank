package com.dependentlearners.presentation.mobile.api.controller;

import com.dependentlearners.common.representation.Transaction;
import com.dependentlearners.common.resource.TransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    private final TransactionResource transactionResource;

    @Autowired
    public TransactionController(TransactionResource transactionResource) {
        this.transactionResource = transactionResource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return transactionResource.getAllTransactions();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable long id){
        return transactionResource.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Transaction transaction){
        return transactionResource.createTransaction(transaction);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable long id){
        return transactionResource.removeTransaction(id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Transaction transaction){
        return transactionResource.modifyTransaction(id, transaction);
    }
}
