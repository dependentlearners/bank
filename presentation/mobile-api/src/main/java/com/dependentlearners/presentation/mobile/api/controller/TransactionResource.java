package com.dependentlearners.presentation.mobile.api.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "transaction")
public interface TransactionResource {

    @RequestMapping(value = "/transaction/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<String> getTransactionById(@PathVariable(value = "id") long id);
}
