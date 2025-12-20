package com.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EWalletSystem eWalletSystem = new EWalletSystem();
        Account account; // نعلن الحساب فقط

        System.out.println("Welcome to E-Wallet System");

        System.out.println("1. Sign-Up");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // تنظيف newline بعد nextInt()
// بدون sc.nextLine() بعد nextInt() → أي nextLine() لاحق يلتقط الـ newline فقط → الاسم يظهر فارغ
        switch (choice) {
            case 1:
           //Sign-Up Flow
                System.out.println("Sign-Up");

                // ===== Username =====
                String name;
                boolean valid;
                // لى استخدمنا do,while ?

 // علشان المستخدم يُسأل مرة واحدة على الأقل
                //
                //لو أخطأ → يعاد السؤال تلقائيًا
                //
                //لو صح → يكمل الخطوة التالية
                do {
                    System.out.print("Please enter your username: ");
                    name = sc.nextLine();
                    valid = eWalletSystem.validateUsername(name);
                    if (!valid) System.out.println("Invalid username, please try again");
                } while (!valid);

                // ===== Password =====
                String password;
                do {
                    System.out.print("Please enter your password: ");
                    password = sc.nextLine();
                    valid = eWalletSystem.validatePassword(password);
                    if (!valid) System.out.println("Invalid password, please try again");
                } while (!valid);

                // ===== Age =====
                int age;
                do {
                    System.out.print("Please enter your age: ");
                    age = sc.nextInt();
                    sc.nextLine(); // تنظيف newline
                    valid = eWalletSystem.valditeAge(age);
                    if (!valid) System.out.println("Invalid age, must be >= 18");
                } while (!valid);

                // ===== Phone Number =====
                String phoneNumber;
                do {
                    System.out.print("Please enter your phone number: ");
                    phoneNumber = sc.nextLine();
                    valid = eWalletSystem.valditePhonenumber(phoneNumber);
                    if (!valid) System.out.println("Invalid phone number, please try again");
                } while (!valid);

                // ===== إنشاء الحساب =====
                account = new Account(name, password, age, phoneNumber);
                eWalletSystem.getAccounts().add(account); // أضف الحساب للمجموعة
                eWalletSystem.getUsernames().add(name);
                eWalletSystem.getPhoneNumbers().add(phoneNumber);

                System.out.println("Sign-Up successful!");
                break;

            case 2:
                System.out.println("Login");

                break;

            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input, please enter 1, 2, or 3");
        }
    }
}
