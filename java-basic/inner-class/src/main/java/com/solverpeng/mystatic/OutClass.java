package com.solverpeng.mystatic;

public class OutClass {
    private static String outFiled = "out filed";

    public static class InnerClass {
        public static String innerFiled = "inner filed";
        public static void display() {
            System.out.println("out static filed:" + outFiled + ", innerFiled:" + innerFiled);
        }
    }

    public static void main(String[] args) {
        InnerClass.display();
    }
}
