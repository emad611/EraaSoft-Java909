package com.model;
//2 unchecked
public class Main {
    public static void main(String[] args) {

        String str = null;
        int x = 5;
        int y = 0;

        try {
            // هذا السطر سيطلق NullPointerException لأن str = null
            str.toUpperCase();
// لو حصل exception مش هيبص على باقى وينتقل الى نوع بتاعه وينفذ الرسالة
            // هذا السطر سيطلق ArithmeticException لو وصل إليه
            System.out.println(x / y);

        }
        catch (NullPointerException e) {
            System.out.println("Null Pointer Exception");
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        }
    }
}
