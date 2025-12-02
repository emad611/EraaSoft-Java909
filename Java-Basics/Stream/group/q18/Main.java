package com.java;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // تحويل قائمة Strings إلى String مفصول بفواصل
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        String commaSeparated=names.stream().collect(Collectors.joining(","));
        System.out.println(commaSeparated);
    }

    }

