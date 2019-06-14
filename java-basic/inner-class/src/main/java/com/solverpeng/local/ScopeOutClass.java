package com.solverpeng.local;

public class ScopeOutClass {
    private int age = 12;

    public void print(boolean x, String value) {
        String name = "lily";

        if (x) {
            class InnerClass {
                private void print() {
                    System.out.println("age:" + age);
                    System.out.println("name:" + name);
                    System.out.println("value:" + value);
                }
            }
            new InnerClass().print();
        }

    }

    public static void main(String[] args) {
        ScopeOutClass scopeOutClass = new ScopeOutClass();
        scopeOutClass.print(true, "test");
    }
}
