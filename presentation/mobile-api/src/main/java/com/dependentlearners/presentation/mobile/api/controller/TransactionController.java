package com.dependentlearners.presentation.mobile.api.controller;

import com.dependentlearners.common.representation.Transaction;
import com.dependentlearners.common.resource.TransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionResource transactionResource;

    @Autowired
    public TransactionController(TransactionResource transactionResource) {
        this.transactionResource = transactionResource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> getAll(){
        return transactionResource.getAllTransactions();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Transaction> get(@PathVariable long id){
        return transactionResource.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction){
        return transactionResource.createTransaction(transaction);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Transaction> remove(@PathVariable long id){
        return transactionResource.removeTransaction(id);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> update(@PathVariable long id, @RequestBody Transaction transaction){
        return transactionResource.modifyTransaction(id, transaction);
    }
}
