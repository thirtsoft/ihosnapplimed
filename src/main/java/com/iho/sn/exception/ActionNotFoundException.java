package com.iho.sn.exception;

public class ActionNotFoundException extends RuntimeException {

    public ActionNotFoundException(String message) {
        super(message);
    }
}
