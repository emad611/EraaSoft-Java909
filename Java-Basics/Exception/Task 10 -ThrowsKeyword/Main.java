package com.model;

import com.model.service.MyIOException;

public class Main {
    public static void main(String[] args) {
        MyIOException demo = new MyIOException();

        try{
            demo.readFile();
        }catch(Exception e){
            System.out.println("I/O Exception "+e.getMessage());
        }
    }
}
