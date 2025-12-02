package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
//float map -->تسطيح List داخل List وتحويلها لقائمة واحدة
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        // استخراج الأحرف بدون تكرار
       List<Character>chars= names.stream().filter(Objects::nonNull).filter(s->!s.equals(""))
               .flatMap(word->word.chars().mapToObj(c->(char)c))//نحول كل كلمة لأحرف
                .distinct()//نمنع التكرار 
                .collect(Collectors.toList());//نجمعهم فى قاءمة

        System.out.println(chars);
    }

    }

