package org.lgt.thread.suspend;

import java.time.LocalDateTime;

public class Mythread extends Thread {
    private long i = 0L;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Mythread thread = new Mythread();
        thread.setDaemon(true);
        thread.start();
        /*Thread.sleep(5000);
        System.out.println("end");*/
    }

    /*public static void main(String[] args) throws InterruptedException {
        Mythread mythread = new Mythread();
        mythread.start();
        Thread.sleep(1000);
        mythread.suspend();
        System.out.println("A="+ LocalDateTime.now()+" getI="+mythread.getI());

        Thread.sleep(2000);
        System.out.println("A="+ LocalDateTime.now()+" getI="+mythread.getI());

        mythread.resume();
        Thread.sleep(2000);

        mythread.suspend();
        System.out.println("B="+ LocalDateTime.now()+" getI="+mythread.getI());

        Thread.sleep(2000);
        System.out.println("B="+ LocalDateTime.now()+" getI="+mythread.getI());
    }*/
}
