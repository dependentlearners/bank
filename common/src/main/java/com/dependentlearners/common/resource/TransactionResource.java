package com.dependentlearners.common.resource;

import com.dependentlearners.common.representation.Transaction;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "transaction")
public interface TransactionResource {

    @RequestMapping(value = "/transaction",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<List<Transaction>> getAllTransactions();

    @RequestMapping(value = "/transaction/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") long id);

    @RequestMapping(value = "/transaction",
            method = RequestMethod.POST,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction);

    @RequestMapping(value = "/transaction/{id}",
            method = RequestMethod.DELETE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> removeTransaction(@PathVariable(value = "id") long id);

    @RequestMapping(value = "/transaction/{id}",
            method = RequestMethod.PUT,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Transaction> modifyTransaction(@PathVariable(value = "id") long id, @RequestBody Transaction transaction);

}
