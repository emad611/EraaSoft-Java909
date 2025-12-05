package com.java;

public class Withdrawer implements Runnable{
    private BankAccount account; // الحساب المشترك

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        while (true) {

            account.withdraw(100); // محاولة سحب 100

            try {
                Thread.sleep(1000); // انتظار 1 ثانية
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

