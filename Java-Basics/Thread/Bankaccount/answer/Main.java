package com.java;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(0);
        // حساب يبدأ برصيد صفر

        // إنشاء Thread المودّع والساحب
        Thread depositorThread = new Thread(new Depositor(account));
        Thread withdrawerThread = new Thread(new Withdrawer(account));

        depositorThread.start();  // يبدأ الإيداع
        withdrawerThread.start(); // يبدأ السحب
    }
}
