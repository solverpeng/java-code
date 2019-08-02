package com.solverpeng.structure;

public class ProductBFactory extends Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
