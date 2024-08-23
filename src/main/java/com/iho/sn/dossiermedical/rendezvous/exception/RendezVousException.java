package com.iho.sn.dossiermedical.rendezvous.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RendezVousException extends RuntimeException {

    public RendezVousException(String message) {
        super(message);
    }
}
