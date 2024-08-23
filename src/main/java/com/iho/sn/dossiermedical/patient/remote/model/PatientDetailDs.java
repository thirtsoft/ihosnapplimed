package com.iho.sn.dossiermedical.patient.remote.model;


import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDetailDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetailDs {
    private Long id;
    private String code;
    private String prenom;
    private String nom;
    private String sexe;
    private String civilite;
    private String address;
    private Date dateNaissance;
    private int age;
    private String numeroTelephone;
    private String profession;
    private String situationMatrimonial;
    private String photo;
    private String race;
    private String ethnie;
    private String origine;
    private String nationalite;
    private String originePere;
    private String origineMere;
    private String prototype;
    private String consanguinite;
    private String niveauSocialEconomique;
    private String regimeAlimentaire;
    private Date dateAdmission;

    private int isCircuitGenerated;

    private boolean est_accompagne;

    private PersonneConfianceDs personneConfianceDs;

    private DiagnosticDs diagnosticDs;

    private int nombre_passage;

    private List<HospitalisationDetailDs> hospitalisationDsList;

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
