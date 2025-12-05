package com.java;

public class Depositor implements Runnable{
    private BankAccount account; // الحساب المشترك

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        while (true) { // تكرار كل فترة

            account.deposit(50); // إيداع 50

            try {
                Thread.sleep(1500); // انتظار 1.5 ثانية
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

