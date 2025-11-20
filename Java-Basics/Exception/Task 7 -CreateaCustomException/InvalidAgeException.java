package com.model;

public class InvalidAgeException extends Exception {
    private int age;
   public  InvalidAgeException() {
       super();
   }
    public InvalidAgeException(int age, String message) {
        super(message);
        this.age = age;
    }
    public void checkage() throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException(age, "Invalid age: " + age);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

