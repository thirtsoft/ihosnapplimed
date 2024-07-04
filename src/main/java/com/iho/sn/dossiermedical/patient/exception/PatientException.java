package com.iho.sn.dossiermedical.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PatientException extends RuntimeException {

    public PatientException(String message) {
        super(message);
    }
}
