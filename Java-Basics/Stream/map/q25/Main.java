package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
     List<String>res=  names.stream().filter(Objects::nonNull).filter(s->!s.equals(""))
        .filter(name->name.startsWith("A")||name.startsWith("a"))// تبدأ بـ A
               .map(String::toUpperCase)//نحولها لحروف كبيرة
               .collect(Collectors.toList());
        System.out.println(res);
    }

    }

