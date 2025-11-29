package com.model;

import com.model.service.*;
// الخلاصه علشان تستخدم لشخص ايا يكن بس تعمل طريقة كود مختلفة هتعمل interface لكذا نوع فى المسالة
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();// هنا عملنا اوبجكت من كلاس اللاعب
        p1.setName("emad");// ادخلنا كل المطاليب
        p1.setAge(19);
        p1.setId("456");
        // ومن ثم عملنا اوبجكت من نوع كلاس PrivateClubClassImpl ولكن باستخدام interface لانو لايسمح بعمل اوبجكت ف علشان كدااستخدمنا كلاس الابن
        PrivateClubPlayer privateClubPlayer=new PrivateClubClassImpl();
        //ومن خلال كلاس الابن استدعينا الميثود وجبنا الاسم
        System.out.println(privateClubPlayer.addPlayer(p1).getName());

        System.out.println("---------------");
         //وكذلك هنا
        PublicClubPlayer publicClubPlayer=new PublicClubClassImpl();
        System.out.println(publicClubPlayer.addPlayer(p1).getName());
    }
}
