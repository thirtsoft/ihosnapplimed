package com.iho.sn.dossiermedical.consultation.remote.model;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ConsultationMedicalSearchDs {

    private String code;
    private LocalDate from;
    private LocalDate to;
    private String numero;


    public boolean estRempli() {
        return getTo() != null && getFrom() != null;
    }

    public boolean estVide() {
        return getTo() == null && getFrom() == null;
    }

    @AssertTrue
    public boolean isDateIntervalValid() {
        return !estRempli() || (getTo().equals(getFrom())) || getTo().isAfter(getFrom());
    }
}
