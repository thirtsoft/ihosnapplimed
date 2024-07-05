package com.iho.sn.exception;

public class ActionAlreadyExistException extends RuntimeException {
    public ActionAlreadyExistException(String message) {
        super(message);
    }
}