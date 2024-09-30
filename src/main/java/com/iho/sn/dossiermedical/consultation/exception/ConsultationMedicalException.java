package com.iho.sn.dossiermedical.consultation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsultationMedicalException extends RuntimeException {

    public ConsultationMedicalException(String message) {
        super(message);
    }
}
