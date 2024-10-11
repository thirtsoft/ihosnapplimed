package com.iho.sn.dossiermedical.consultation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultationMedicalListeDs {

    private Long id;

    private String numeroConsultation;

    private String nomCompletPatient;

    private String nomCompletAgent;

    private int typePatient;

    private String patientConsulte;

    private LocalDate dateConsultation;

    private int actif;

    public boolean isActif() {
        return actif == 1;
    }

    public void setActif(boolean actif) {
        if (actif)
            this.actif = 1;
        else
            this.actif = 0;
    }
}
