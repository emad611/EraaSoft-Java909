package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 40, 30, 50);

// إيجاد ثاني أكبر قيمة
        int secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder()) // ترتيب تنازلي
                .skip(1)                           // تخطي أكبر رقم
                .findFirst()                       // أخذ الرقم التالي مباشرة
                .get();

        System.out.println(secondHighest); // 40

    }

    }

