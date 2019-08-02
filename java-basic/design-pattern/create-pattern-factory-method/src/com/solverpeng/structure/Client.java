package com.solverpeng.structure;


public class Client {
    public static void main(String[] args) {
        Factory factory = new ProductAFactory();
        Product product = factory.createProduct();
        product.produce();
    }
}
