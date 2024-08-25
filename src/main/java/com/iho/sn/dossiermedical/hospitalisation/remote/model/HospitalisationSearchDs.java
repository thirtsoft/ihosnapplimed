package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class HospitalisationSearchDs {

    private String statusHospitalisation;
    private String code;
    private LocalDate from;
    private LocalDate to;


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
