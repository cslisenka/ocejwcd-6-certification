package com.example.web.elfunc;

public class MyELFunctions {

    public static String hello(String name) {
        return "Hello " + name + "!";
    }

    public static double randomNumber() {
        return Math.random() * 1000;
    }
}