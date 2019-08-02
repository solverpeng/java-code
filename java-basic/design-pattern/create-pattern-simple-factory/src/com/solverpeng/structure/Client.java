package com.solverpeng.structure;

public class Client {
    public static void main(String[] args) {

        Product productA = SimpleFactory.createProduct("A");
        Product productB = SimpleFactory.createProduct("B");
        productA.produce();
        productB.produce();

    }
}
