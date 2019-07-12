package com.solverpeng.example;

import java.beans.ConstructorProperties;

public class CustomerInfo {
    private String customerId;
    private String zipCode;

    @ConstructorProperties({"id", "zip"})
    public CustomerInfo(String customerId, String zipCode) {
        this.customerId = customerId;
        this.zipCode = zipCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customerId='" + customerId + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
