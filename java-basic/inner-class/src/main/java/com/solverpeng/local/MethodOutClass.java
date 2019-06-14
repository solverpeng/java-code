package com.solverpeng.local;

public class MethodOutClass {
    private int filed = 10;

    public void outMethod(int value) {
        int filed2 = 11;

        class InnerClass {
            public void print() {
                System.out.println("filed:" + filed);
                System.out.println("filed2:" + filed2);
                System.out.println("value:" + value);
            }
        }

        new InnerClass().print();
    }

    public static void main(String[] args) {
        MethodOutClass methodOutClass = new MethodOutClass();
        methodOutClass.outMethod(12);

    }

}
