package com.my.datastrcture.interview;

public class CustomeException extends RuntimeException{
    public CustomeException(String message, Throwable ex){
        super(message, ex);
    }

}
