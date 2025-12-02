package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Double> doubles = Arrays.asList(2.0, 4.0, 6.0, 10.0);
        //                           تحويلها لـ stream خاص بالدبل
        Double avg=doubles.stream().mapToDouble(D->D).average().getAsDouble();
        System.out.println(avg);
    }

    }

