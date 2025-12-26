package com.java;

import java.util.*;

public class EWalletSystem {

    // لتخزين البيانات ومنع التكرار
    private Set<String> usernames = new HashSet<>();
    private Set<String> phoneNumbers = new HashSet<>();
    private Set<Account> accounts = new HashSet<>();

    // Scanner واحد فقط لكل السيستم
    private Scanner sc = new Scanner(System.in);

    /* ================= Username ================= */
    // تحقق فقط (من غير إضافة)
    boolean validateUsername(String username) {
        if (username == null || username.isEmpty()) return false;
        if (username.length() < 3 || username.length() > 20) return false;
        return !usernames.contains(username);
    }

    /* ================= Password ================= */
    boolean validatePassword(String password) {
        if (password == null || password.length() < 8) return false;

        boolean upper = false, lower = false, digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isLowerCase(c)) lower = true;
            else if (Character.isDigit(c)) digit = true;
        }
        return upper && lower && digit;
    }

    /* ================= Age ================= */
    boolean validateAge(int age) {
        return age >= 18;
    }

    /* ================= Phone ================= */
    boolean validatePhoneNumber(String phone) {
        if (phone == null || phone.length() != 11) return false;
        if (!phone.startsWith("01")) return false;

        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return !phoneNumbers.contains(phone);
    }

    /* ================= Account ================= */
    public void addAccount(Account acc) {
        accounts.add(acc);
        usernames.add(acc.getUsername());
        phoneNumbers.add(acc.getPhoneNumber());
    }

    private Account findAccount(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username))
                return acc;
        }
        return null;
    }

    /* ================= Login ================= */
    public Account login() {
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            Account acc = findAccount(u);

            if (acc == null) {
                System.out.println("User not found!");
                attempts++;
                continue;
            }

            if (!acc.isActive()) {
                System.out.println("Account is inactive!");
                return null;
            }

            if (!acc.getPassword().equals(p)) {
                System.out.println("Wrong password!");
                acc.addTransaction("Failed login at " + new Date());
                attempts++;
                continue;
            }

            acc.addTransaction("Login at " + new Date());
            System.out.println("Login successful 🎉");
            return acc;
        }

        System.out.println("Too many attempts!");
        return null;
    }

    /* ================= Operations ================= */
    public void showAccountDetails(Account acc) {
        System.out.println("\n=== Account Info ===");
        System.out.println("Username: " + acc.getUsername());
        System.out.println("Age: " + acc.getAge());
        System.out.println("Phone: " + acc.getPhoneNumber());
        System.out.println("Balance: " + acc.getBalance() + " EGP");
    }

    public void deposit(Account acc) {
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        acc.setBalance(acc.getBalance() + amount);
        acc.addTransaction("Deposit " + amount + " at " + new Date());
        System.out.println("Done ✅");
    }

    public void withdraw(Account acc) {
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0 || amount > acc.getBalance()) {
            System.out.println("Invalid amount!");
            return;
        }

        acc.setBalance(acc.getBalance() - amount);
        acc.addTransaction("Withdraw " + amount + " at " + new Date());
        System.out.println("Done ✅");
    }

    public void transfer(Account sender) {
        System.out.print("Recipient username: ");
        String name = sc.nextLine();

        Account receiver = findAccount(name);

        if (receiver == null || receiver == sender) {
            System.out.println("Invalid recipient!");
            return;
        }

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0 || amount > sender.getBalance()) {
            System.out.println("Invalid amount!");
            return;
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        sender.addTransaction("Sent " + amount + " to " + receiver.getUsername());
        receiver.addTransaction("Received " + amount + " from " + sender.getUsername());

        System.out.println("Transfer successful ✅");
    }
    public void changePassword(Account account) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your current password: ");
        String oldPassword = sc.nextLine();

        // التأكد من الباسورد القديم
        if (!account.getPassword().equals(oldPassword)) {
            System.out.println("Incorrect current password!");
            return;
        }

        String newPassword;
        do {
            System.out.print("Enter new password: ");
            newPassword = sc.nextLine();

            if (!validatePassword(newPassword)) {
                System.out.println("Password must be ≥8 chars with uppercase, lowercase, and number.");
            }

        } while (!validatePassword(newPassword));

        account.setPassword(newPassword);
        account.addTransaction("Password changed at " + new Date());

        System.out.println("Password changed successfully ✅");
    }

}
