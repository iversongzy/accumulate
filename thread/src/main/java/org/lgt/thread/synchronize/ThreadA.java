package org.lgt.thread.synchronize;

public class ThreadA extends Thread {
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B","BB");
    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();
        Thread.sleep(200);
        publicVar.getValue();
    }
}
