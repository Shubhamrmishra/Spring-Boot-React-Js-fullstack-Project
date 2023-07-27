package com.shuubham.exception;

public class UserNotFountException extends RuntimeException{

    public UserNotFountException(long id){
        super("user not found with id " + id);
    }
}
