package com.model;
public class Main {
    public static void main(String[] args) {
        System.out.println("Start of main");

        try {
            System.out.println("Inside try block");
            int result = 10 / 0; // سيحدث ArithmeticException
            System.out.println("This line won't execute");
        }
        catch (ArithmeticException e) {
            System.out.println("Inside catch block: " + e.getMessage());
            // لو عملنا return هنا، finally هينفذ قبل الرجوع
            return;
        }
        // هى بلوك بيتنفذ قبل انهاء ميثود catch حتى لو حصل exception or not هتتنفذ يعنى مضمونه التنفيذ
        finally {
            System.out.println("Inside finally block - always executes!");
        }

        System.out.println("End of main");
    }
}
