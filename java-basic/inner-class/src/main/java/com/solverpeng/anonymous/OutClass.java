package com.solverpeng.anonymous;

public class OutClass {
    private int age = 10;
    public MyInterface getMyInterface(int num, String  str) {
        String name = "tom";
        return new MyInterface() {
            @Override
            public void print(String value) {
                System.out.println("num:" + num);
                System.out.println("str:" + str);
                System.out.println("value:" + value);
                System.out.println("name:" + name);
                System.out.println("age:" + age);
            }
        };
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        MyInterface myInterface = outClass.getMyInterface(12, "lily");
        myInterface.print("test");
    }
}
