package com.example.juc.T_01_wait;

public class WaitTest {

    public static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        synchronized (o) {
            o.wait();
        }

    }
}
