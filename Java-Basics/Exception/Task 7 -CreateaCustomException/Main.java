package com.model;
//create custom exception
public class Main {
    public static void main(String[] args) {

        InvalidAgeException invalidAgeException=new InvalidAgeException();
invalidAgeException.setAge(14);
try {
    invalidAgeException.checkage();
} catch (InvalidAgeException e) {
    System.out.println(e.getMessage());
}
    }
}
