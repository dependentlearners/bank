package com.dependentlearners.services.transaction.service;

import com.dependentlearners.common.representation.Transaction;
import com.dependentlearners.common.resource.CustomerResource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public List<Transaction> getTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        transaction1.setSender(customerResource.getCustomerById(1).getBody());
        transaction1.setReceiver(customerResource.getCustomerById(2).getBody());
        transaction1.setAmount(new BigDecimal(100));
        transaction1.setTransactionText("Sample text of transaction");
        Transaction transaction2 = new Transaction();
        transaction2.setSender(customerResource.getCustomerById(1).getBody());
        transaction2.setReceiver(customerResource.getCustomerById(3).getBody());
        transaction2.setAmount(new BigDecimal(100));
        transaction2.setTransactionText("Sample text of transaction");
        transactions.add(transaction1);
        transactions.add(transaction2);
        return transactions;
    }
}
