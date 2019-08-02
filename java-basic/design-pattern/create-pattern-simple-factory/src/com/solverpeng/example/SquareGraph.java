package com.solverpeng.example;

/**
 * 正方形
 */
public class SquareGraph extends Graph {
    @Override
    protected void draw() {
        System.out.println("画正方形");
    }

    @Override
    protected void erase() {
        System.out.println("擦除正方形");
    }
}
