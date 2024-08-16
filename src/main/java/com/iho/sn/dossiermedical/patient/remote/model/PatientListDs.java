package com.iho.sn.dossiermedical.patient.remote.model;

import com.iho.sn.dossiermedical.patient.remote.model.DiagnosticDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientListDs {

    private Long id;

    private String code;

    private String prenom;

    private String nom;

    private String telephone;

    private Date dateAdmission;

    private DiagnosticDs diagnosticDs;

    private int nombre_passage;

    private int isCircuitGenerated;
}
