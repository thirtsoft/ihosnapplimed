package com.iho.sn.dossiermedical.rendezvous.remote.model;

import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVousDetailsDs {

    private Long id;
    private String libelle;
    private Long patientId;
    private PatientDetailDs patient;
    private String nomCompletPatient;
    private Long medecinId;
    private UtilisateurDs utilisateurDs;
    private Date dateRendezVous;
    private String heure;
    private Date createDate;
    private String libelleEtat;
    private Long createdBy;
    private String nomCompletAgent;
    private int actif;
    private int etat;

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }
}
