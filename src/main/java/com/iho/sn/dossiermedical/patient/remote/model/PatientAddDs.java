package com.iho.sn.dossiermedical.patient.remote.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddDs {

    private Long id;

    @NotEmpty(message = "L'index ne doit pas etre null ou vide")
    private String code;

    @NotEmpty(message = "Le prénom ne doit pas etre null ou vide")
    private String prenom;

    @NotEmpty(message = "Le nom ne doit pas etre null ou vide")
    private String nom;

    @NotEmpty(message = "Le sexe ne doit pas etre null ou vide")
    private String sexe;

    @NotEmpty(message = "La civilité ne doit pas etre null ou vide")
    private String civilite;

    private String address;

    private Date dateNaissance;

    private int age;

    @NotEmpty(message = "Le téléphone ne doit pas etre null ou vide")
    @Max(value = 9, message = "Le numéro de téléphone doit au maximum avoir 9 caractères.")
    @Pattern(regexp="(^$|[0-9]{9})", message = "Le téléphone doit comporter des chiffre entre 0 et 9")
    private String numeroTelephone;

    private String profession;

    private String situationMatrimonial;

    private Date dateAdmission;

    private PersonneConfianceDs personneConfianceDs;

    private TrancheAgeDs trancheAgeDs;

    private int modeAdmission;

    private String structureReference;

    private boolean est_accompagne;

}
