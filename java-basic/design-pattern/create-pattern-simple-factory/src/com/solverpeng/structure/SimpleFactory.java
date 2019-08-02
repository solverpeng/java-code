package com.solverpeng.structure;

public class SimpleFactory {

    public static Product createProduct(String productName) {
        if (productName == null || productName.equals("")) {
            return null;
        }
        if ("A".equals(productName)) {
            return new ProductA();
        } else if ("B".equals(productName)) {
            return new ProductB();
        } else {
            return null;
        }
    }
}
