package com.iho.sn.dossiermedical.patient.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientUpdateByMedecinDs {
    private Long id;
    private String prenom;
    private String nom;
    private String sexe;
    private String civilite;
    private String profession;
    private String situationMatrimonial;
    private String race;
    private String ethnie;
    private String origine;
    private String originePere;
    private String origineMere;
    private String prototype;
    private String consanguinite;
    private String niveauSocialEconomique;
    private String regimeAlimentaire;
    private DiagnosticDs diagnosticDs;
}
