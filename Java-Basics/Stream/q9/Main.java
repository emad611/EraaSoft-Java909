package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//set منع التكرار لانها 
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
   Set<Integer> numbersSet = numbers.stream().collect(Collectors.toSet());
        System.out.println(numbersSet);
    }

    }

