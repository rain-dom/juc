package com.example.juc.T_01_wait;

public class DeadLock {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                try {
                    Thread.sleep(1000);
                    System.out.println("weak up,want 2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("get resource2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource2) {
                try {
                    Thread.sleep(1000);
                    System.out.println("weak up,want 1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("get resource1");
                }
            }
        }).start();


    }

}
