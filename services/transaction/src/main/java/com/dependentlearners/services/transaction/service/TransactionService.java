package com.dependentlearners.services.transaction.service;

import com.dependentlearners.services.transaction.representation.Customer;
import com.dependentlearners.services.transaction.representation.Transaction;
import com.dependentlearners.services.transaction.resource.CustomerResource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final CustomerResource customerResource;

    public TransactionService(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    public Transaction getTransactionById(long transactionId){
        Transaction transaction = new Transaction();
        transaction.setSender(customerResource.getCustomerById(1).getBody());
        transaction.setReceiver(customerResource.getCustomerById(2).getBody());
        transaction.setAmount(new BigDecimal(100));
        transaction.setTransactionText("Sample text of transaction");
        return transaction;
    }
}
