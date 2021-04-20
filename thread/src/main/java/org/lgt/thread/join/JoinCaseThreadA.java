package org.lgt.thread.join;

/**
 * @Description join的作用是等待线程对象的销毁
 * @Author liuguotai
 * @Date2021/4/20 0:13
 **/
public class JoinCaseThreadA extends Thread {
    @Override
    public void run() {
        double value = Math.random() * 1000;
        try {
            Thread.sleep((int)value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(value);
    }
}
