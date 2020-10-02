package org.lgt.thread.synchronize;

public class PublicVar {
    public String userName = "A";
    public String password = "AA";

    //synchronized public void getValue() {
    public void getValue() {
        System.out.println("current Thread: " + Thread.currentThread().getName() +
                "username: " + userName + "password: " + password);
    }

    synchronized public void setValue(String userName, String password) {
        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("current Thread: " + Thread.currentThread().getName() +
                    "username: " + userName + "password: " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
