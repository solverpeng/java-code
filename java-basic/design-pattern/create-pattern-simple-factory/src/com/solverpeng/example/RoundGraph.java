package com.solverpeng.example;

/**
 * 圆形
 */
public class RoundGraph extends Graph {
    @Override
    protected void draw() {
        System.out.println("画圆");
    }

    @Override
    protected void erase() {
        System.out.println("擦除圆形");
    }
}
