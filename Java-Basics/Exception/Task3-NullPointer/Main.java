package com.model;
public class Main {
public static void main(String[] args) {
    String text = null;//هنا عرفت المتغير ب null
    PrintUpperCase printUpperCase = new PrintUpperCase();// من ثم عملت اوبجكت من نوع الكلاس الى هستدعى منو الميثود الى هتعملى uppercase ويحصل  exception ونهندل السطر الى هنستدعيه

    try {
        printUpperCase.printUpperCase(text);//هنا سيتم دخول هذا السطر الى block try حتى نطبع رسالة افضل فى
    } catch (NullPointerException e) {
        System.out.println("invalid input");// block catch راح نطبع رسالة خطا بسبب دخول exception type: NullPointerException
    }


}
}


