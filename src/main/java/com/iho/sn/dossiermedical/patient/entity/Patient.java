package com.iho.sn.dossiermedical.patient.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "iho_patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Patient extends AbstractAuditableEntity implements Serializable {

    @Column(unique = true)
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

    @Column(name = "is_circuit_generated", columnDefinition = "int default 0")
    private int isCircuitGenerated;

    @Column(name = "est_accompagne")
    private boolean est_accompagne;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private PersonneConfiance personneConfiance;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Diagnostic diagnostic;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private TrancheAge trancheAge;

    @Column(name = "mode_admission", columnDefinition = "int default 1")
    private int modeAdmission;

    @Column(name = "structure_reference")
    private String structureReference;

    @Column(name = "nombre_passage", columnDefinition = "int default 0")
    private int nombre_passage;

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
