package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
//float map -->تسطيح List داخل List وتحويلها لقائمة واحدة
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
      List<Integer>flat=  listOfLists.stream().//نفتح Stream من القوائم
                flatMap(list -> list.stream())// نفتح كل قائمة داخلية إلى عناصر
                .collect(Collectors.toList());// نجمع العناصر في قائمة واحدة

        System.out.println(flat );
    }

    }

