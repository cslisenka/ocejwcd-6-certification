package com.example.web;

public class MyBusinessException extends Exception {

    public MyBusinessException() {
        super();
    }

    public MyBusinessException(String message) {
        super(message);
    }
}