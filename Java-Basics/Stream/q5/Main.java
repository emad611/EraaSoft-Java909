package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);
      List<Integer>res= numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(res);

        System.out.println("---------------------");
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        List<String>results=names.stream().distinct().collect(Collectors.toList());
        System.out.println(results);
    }

    }

