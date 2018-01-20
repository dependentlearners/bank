package com.dependentlearners.services.transaction.controller;

import com.dependentlearners.common.representation.Transaction;
import com.dependentlearners.services.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getTransactions(), HttpStatus.OK);
    }

    @RequestMapping(path = "{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<Transaction>(transactionService.getTransactionById(id), HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return null;
    }

    @RequestMapping(path = "{id}",
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> removeTransaction(@PathVariable(value = "id") long id) {
        return null;
    }

    @RequestMapping(path = "{id}",
            method = RequestMethod.PUT,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> modifyTransaction(@PathVariable(value = "id") long id, @RequestBody Transaction transaction) {
        return null;
    }
}
