package com.solverpeng.structure;

public enum ProductNameEnum {
    A("A"),
    B("B");

    private String productName;

    ProductNameEnum(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
