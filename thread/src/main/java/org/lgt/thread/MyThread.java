package org.lgt.thread;

public class MyThread extends Thread {
    private int i = 100;

    @Override
    public void run() {
        System.out.println("i=" + (i--) + "threadName=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 100; i++) {
            new Thread(myThread).start();
        }
    }
}
