package com.iho.sn.exception;

public class ProfilAlreadyExistsException extends RuntimeException {
    public ProfilAlreadyExistsException(String message) {
        super(message);
    }
}