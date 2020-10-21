package org.lgt.thread.synchronize;

public class Son extends Father {
    @Override
    //public void method1() {
    synchronized public void method1() {
        System.out.println("in son, begin "+Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in son, end "+Thread.currentThread().getName());
        super.method1();
    }
}
