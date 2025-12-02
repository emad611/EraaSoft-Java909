package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        Optional هو كلاس في Java بيحتوي على قيمة ممكن تكون موجودة أو مش موجودة.
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
        Optional<Integer> res=numbers.stream().filter(num ->num>7).findFirst();
        System.out.println(res);
    }

    }

