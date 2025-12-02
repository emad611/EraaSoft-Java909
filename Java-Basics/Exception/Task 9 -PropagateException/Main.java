package com.model;

import com.model.service.ExceptionDemo;

public class Main {
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo(); //تم انشاء اوبجكت من كلاس custom extend excption or throwable ودا انت مجبور تحط keyword throws and block try,catch
        try{
            demo.CallDemo();//هنا استدعيت الميثود الى استدعيت ميثود عملت عملية throw
        }catch(Exception e){
            System.out.println("Exception caught in main: " + e.getMessage());//هنا هنفذ الرسالة الى موجوده داخل throw 
        }

    }
}
