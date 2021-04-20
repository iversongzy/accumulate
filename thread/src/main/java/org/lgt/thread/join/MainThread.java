package org.lgt.thread.join;

/**
 * @Description 主线程想等待子线程执行完成之后再结束
 * @Author liuguotai
 * @Date2021/4/20 0:15
 **/
public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        JoinCaseThreadA thread = new JoinCaseThreadA();
        thread.start();
        System.out.println("I don't want to stop right now");
        thread.join();
        System.out.println("success");
    }
}
