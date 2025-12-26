package com.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EWalletSystem wallet = new EWalletSystem();

        boolean running = true;

        while (running) {

            System.out.println("\n=== Welcome to E-Wallet System ===");
            System.out.println("1- Sign Up");
            System.out.println("2- Login");
            System.out.println("3- Exit");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    signUp(sc, wallet);
                    break;

                case 2:
                    loginMenu(sc, wallet);
                    break;

                case 3:
                    System.out.println("Goodbye 👋");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    /* ================= Sign Up ================= */
    private static void signUp(Scanner sc, EWalletSystem wallet) {

        System.out.println("\n=== Sign Up ===");

        String username, password, phone;
        int age;

        do {
            System.out.print("Username: ");
            username = sc.nextLine();
            if (!wallet.validateUsername(username))
                System.out.println("Invalid or already used username!");
        } while (!wallet.validateUsername(username));

        do {
            System.out.print("Password: ");
            password = sc.nextLine();
            if (!wallet.validatePassword(password))
                System.out.println("Password must be ≥8 chars with upper, lower and number!");
        } while (!wallet.validatePassword(password));

        do {
            System.out.print("Age: ");
            try {
                age = sc.nextInt();
                sc.nextLine();
                if (!wallet.validateAge(age))
                    System.out.println("Age must be 18 or older!");
            } catch (Exception e) {
                System.out.println("Please enter a valid age!");
                sc.nextLine();
                age = 0;
            }
        } while (!wallet.validateAge(age));

        do {
            System.out.print("Phone number: ");
            phone = sc.nextLine();
            if (!wallet.validatePhoneNumber(phone))
                System.out.println("Invalid or already used phone number!");
        } while (!wallet.validatePhoneNumber(phone));

        Account acc = new Account(username, password, age, phone);
        wallet.addAccount(acc);

        System.out.println("Account created successfully ✅");
    }

    /* ================= Login Menu ================= */
    private static void loginMenu(Scanner sc, EWalletSystem wallet) {

        Account logged = wallet.login();
        if (logged == null) return;

        boolean stay = true;

        while (stay) {

            System.out.println("\n=== Account Menu ===");
            System.out.println("1- Show Account Details");
            System.out.println("2- Deposit");
            System.out.println("3- Withdraw");
            System.out.println("4- Transfer");
            System.out.println("5- Change Password");
            System.out.println("6- Logout");
            System.out.print("Choice: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Enter a number!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    wallet.showAccountDetails(logged);
                    break;
                case 2:
                    wallet.deposit(logged);
                    break;
                case 3:
                    wallet.withdraw(logged);
                    break;
                case 4:
                    wallet.transfer(logged);
                    break;
                case 5:
                    wallet.changePassword(logged);
                    break;
                case 6:
                    System.out.println("Logged out.");
                    stay = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
