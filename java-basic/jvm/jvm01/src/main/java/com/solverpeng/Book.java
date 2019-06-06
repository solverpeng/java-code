package com.solverpeng;

public class Book {
    public static void main(String[] args) {
        System.out.println("hello!");
        new Book();
    }

    public Book() {
        System.out.println("book构造器！");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    {
        System.out.println("书的普通代码块！");
    }

    int price = 10;

    static {
        System.out.println("book静态代码块");
        amount = 11;
    }

    static int amount;

}
