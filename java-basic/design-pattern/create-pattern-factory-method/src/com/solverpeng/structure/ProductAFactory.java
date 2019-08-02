package com.solverpeng.structure;

public class ProductAFactory extends Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
