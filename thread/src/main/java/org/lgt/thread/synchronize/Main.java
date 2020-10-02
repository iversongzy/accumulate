package org.lgt.thread.synchronize;

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        MyThreadA myThreadA = new MyThreadA(son);
        myThreadA.setName("AAA");
        myThreadA.start();
        MyThreadB myThreadB = new MyThreadB(son);
        myThreadB.setName("BBB");
        myThreadB.start();
    }
}
