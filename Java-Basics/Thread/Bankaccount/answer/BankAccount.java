package com.java;

public class BankAccount {

    // الرصيد الحالي للحساب البنكي
    private int balance;

    // كونستركتور لتحديد الرصيد المبدئي
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // getter لقراءة الرصيد من الخارج
    public int getBalance() {
        return balance;
    }

    // الميثود المسؤول عن الإيداع
    // synchronized: تمنع أكثر من Thread يدخلوا هنا في نفس اللحظة
    public synchronized void deposit(int amount) {

        // إضافة المبلغ إلى الرصيد (الطريقة الصحيحة)
        balance = balance + amount;

        // طباعة العملية للتتبع
        System.out.println("Deposit: +" + amount + " | New Balance = " + balance);

        // notify(): تنبيه أي Thread كان ينتظر داخل withdraw
        notify();
    }

    // الميثود المسؤول عن السحب
    // synchronized: لمنع التداخل بين الإيداع والسحب
    public synchronized void withdraw(int amount) {

        // نستخدم while وليس if لتفادي الاستيقاظ الكاذب
        while (balance < amount) {

            // طباعة أن السحب مرفوض حالياً بسبب عدم توفر رصيد
            System.out.println("Not enough balance, waiting...");

            try {

                // wait(): يوقف التنفيذ حتى يحصل account على notify()
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // هنا الرصيد كافي، نقوم بالسحب
        balance = balance - amount;

        // طباعة العملية للتتبع
        System.out.println("Withdraw: -" + amount + " | New Balance = " + balance);
    }
}
