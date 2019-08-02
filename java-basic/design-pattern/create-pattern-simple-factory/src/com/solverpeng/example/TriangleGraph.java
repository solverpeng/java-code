package com.solverpeng.example;

public class TriangleGraph extends Graph {
    @Override
    protected void draw() {
        System.out.println("画三角形");
    }

    @Override
    protected void erase() {
        System.out.println("擦除三角形");
    }
}
