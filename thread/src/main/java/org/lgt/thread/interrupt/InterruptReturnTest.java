package org.lgt.thread.interrupt;

import java.time.LocalDateTime;

public class InterruptReturnTest extends Thread {
    @Override
    public void run() {
        while (true) {
            if(this.isInterrupted()) {
                System.out.println("stop and return");
                return;
            }
            System.out.println(LocalDateTime.now());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptReturnTest thread = new InterruptReturnTest();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
