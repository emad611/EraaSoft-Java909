package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

// نستخدم reduce لجمع العناصر
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
int sum=numbers.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);
    }

    }

