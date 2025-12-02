package com.model;
//unchecked exception

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String number=sc.nextLine();

try{
    int num=Integer.parseInt(number);//123 true ---- 123h3 --->false --> التحويل من string to int
    //  الان دلوقتى البرنامج هيستلم الرقم كنص ولما تعمل تحويل لعدد صحيح هيشتغل لو هو رقم غير كدا هيحصل  exception فالسطر دا هو اللغز
    System.out.println("number: "+num);//  لو حصل   excp السطر دا عمره ماهيتنفذ
    }
catch(NumberFormatException e){
   // System.out.println(e.getMessage()); ممكن الرسالة تطلع مش مفهومه فالافضل لى انا اكتب الرسالة
    System.out.println("Invalid number, please enter digits only.");

}

  }


}


