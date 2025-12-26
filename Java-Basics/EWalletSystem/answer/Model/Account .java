package com.java;

import java.util.*;

public class Account {

    private String username;              // اسم المستخدم (فريد)
    private String password;              // كلمة المرور
    private int age;
    private String phoneNumber;
    private double balance;

    private boolean isAdmin;              // هل الحساب ادمن؟
    private boolean isActive;             // الحساب مفعل ولا لا

    private List<String> transactionHistory; // سجل العمليات

    // Constructor أساسي
    public Account(String username, String password, int age, String phoneNumber, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;

        this.balance = 0.0;
        this.isActive = true;
        this.transactionHistory = new ArrayList<>();

        transactionHistory.add("Account created at " + new Date());
    }

    // Constructor عادي (User مش Admin)
    public Account(String username, String password, int age, String phoneNumber) {
        this(username, password, age, phoneNumber, false);
    }

    /* ================= Getters ================= */

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isActive() {
        return isActive;
    }

    // نرجع نسخة للقراءة فقط
    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    /* ================= Setters ================= */

    // تغيير الباسورد فقط (من خلال منطق السيستم)
    public void setPassword(String password) {
        this.password = password;
        addTransaction("Password changed at " + new Date());
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setActive(boolean active) {
        this.isActive = active;
        addTransaction(active ? "Account activated" : "Account deactivated");
    }

    /* ================= Transactions ================= */

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    /* ================= Set Behavior ================= */
    // مهم جدًا عشان HashSet يشتغل صح
   // نكتب equals عشان نحدد إمتى حسابين يعتبروا نفس الحساب
@Override
public boolean equals(Object o) {
    if (this == o) return true;          // لو نفس العنوان بالضبط → نفس الحساب
    if (!(o instanceof Account)) return false; // لو مش Account → أكيد مش نفس الحساب

    Account acc = (Account) o;           // نعمل cast للـ Object إلى Account
    return this.username.equals(acc.username); // لو نفس username → نفس الحساب
}

// hashCode لازم يتوافق مع equals عشان الـ HashSet يشتغل صح
@Override
public int hashCode() {
    return username.hashCode();          // نستخدم hash للكلمة username بس
}
//"equals و hashCode مهمين لما نستخدم HashSet علشان نحدد يعني إيه Object مكرر."
    /* ================= Debug ================= */
    @Override
    //"toString بيساعد في عرض بيانات الـ Object أثناء الـ Debugging."
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                ", active=" + isActive +
                '}';
    }
}
