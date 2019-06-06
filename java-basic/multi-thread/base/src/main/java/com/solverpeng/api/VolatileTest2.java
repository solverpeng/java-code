package com.solverpeng.api;

public class VolatileTest2  implements Runnable{
    static VolatileTest2 instance = new VolatileTest2();
    static volatile int i = 0;
    public synchronized static void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int i1 = 0; i1 < 100000000; i1++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();
        System.out.println(i);
    }
}
