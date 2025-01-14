package com.iho.sn.dossiermedical.patient.remote.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePatientDs {
    private String statut;

    private String message;

    private PatientListDs patientListDs;
}
