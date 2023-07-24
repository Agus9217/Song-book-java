package com.justinapp.Exception;

public class MyException extends RuntimeException {

    public MyException(String status, String message) {
        super(status + ": " + message);
    }
}
