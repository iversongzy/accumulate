package org.lgt.thread.synchronize;

public class Father {
    synchronized public void method1() {
        System.out.println("in father, begin "+Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in father, end "+Thread.currentThread().getName());
    }

}
