package com.solverpeng.api;

public class YieldTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "高优先级");
        Thread thread2 = new Thread(myRunnable, "低优先级");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread2.start();
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "-> i=" + i);
        }
    }
}