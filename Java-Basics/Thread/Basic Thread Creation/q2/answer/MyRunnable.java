package com.java;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable running "+ Thread.currentThread().getName());
    }

}

