package com.solverpeng.classload;

public class Child extends Parent {

    {
        System.out.println("child code");
    }

    public Child() {
        System.out.println("child");
    }
}
