package org.lgt.thread.synchronize;

public class MyThreadB extends Thread {
    private Son son;

    public MyThreadB(Son son) {
        super();
        this.son = son;
    }

    @Override
    public void run() {
        son.method1();
    }

}
