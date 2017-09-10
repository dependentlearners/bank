package com.dependentlearners.presentation.mobile.api.representation;

import com.dependentlearners.presentation.mobile.api.constant.CustomerType;

public class Customer {

    private long customerId;
    private String name;
    private CustomerType type = CustomerType.PERSON;

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public CustomerType getType() {
        return type;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
