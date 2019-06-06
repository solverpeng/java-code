package com.solverpeng.api;


public class VolatileTest {
    private static boolean ready;
    private static int number;

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReaderThread readerThread = new ReaderThread();
        readerThread.start();
        Thread.sleep(1000);
        number = 22;
        ready = true;
    }

}
