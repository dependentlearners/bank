package com.dependentlearners.services.transaction.representation;

import com.dependentlearners.services.transaction.constant.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
