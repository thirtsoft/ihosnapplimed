package com.iho.sn.dossiermedical.patient.remote.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosticDs {

    private Long id;
    private String diagnostic_principal;
    private String diagnostic_associe;
}
