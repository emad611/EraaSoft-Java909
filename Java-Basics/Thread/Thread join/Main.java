package com.java;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 running...");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 running...");
        });

        t1.start();
        t2.start();

        try {
            t1.join(); // انتظر انتهاء t1
            t2.join(); // انتظر انتهاء t2
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Both threads finished, main continues...");
    }
}
