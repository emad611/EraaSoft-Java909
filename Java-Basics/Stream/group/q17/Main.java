package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
      //  تقسيم الأرقام إلى زوجي وفردي باستخدام partitioningBy
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        Map<Boolean, List<Integer>> evenodd=numbers.stream().collect(Collectors.partitioningBy(number -> number % 2 == 0));
        // even ->>> true   odd -->>> false
        System.out.println(evenodd);
    }

    }

