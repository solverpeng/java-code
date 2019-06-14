package com.solverpeng.member;

public class OutClass {
    private int filed = 10;

    public void outMethod() {
        System.out.println("this is out, out filed = " + filed);
    }

    public class InnerClass {
        private int filed = 11;

        public void innerMethod() {
            System.out.println("this is inner, inner filed = " + filed);
            System.out.println("this is inner, out filed = " + OutClass.this.filed);
            OutClass.this.outMethod();
        }
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.outMethod();

        InnerClass innerClass = outClass.new InnerClass();
        innerClass.innerMethod();

    }

}
