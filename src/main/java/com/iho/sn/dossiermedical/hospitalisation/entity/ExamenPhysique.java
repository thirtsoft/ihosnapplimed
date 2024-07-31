package com.iho.sn.dossiermedical.hospitalisation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_examen_physique")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamenPhysique extends AbstractAuditableEntity implements Serializable {

    @Column(name = "examen_general", columnDefinition = "TEXT")
    private String examenGeneral;

    @Column(name = "examen_appareil", columnDefinition = "TEXT")
    private String examenAppareil;

    @Column(name = "pression_arterielle_systolique")
    private int pressionArterielS;

    @Column(name = "pression_arterielle_diastolique")
    private int pressionArterielD;

    private float temperature;

    @Column(name = "frequence_cardique")
    private int frequenceC;

    @Column(name = "frequence_respiratoire")
    private int frequenceR;

    @Column(name = "saturation_oxygene")
    private float saturationOxygene;

    private float diurese;

    private float poids;

    private float taille;

    private float imc;

    @Column(name = "tour_taille")
    private float tourTaille;

    @Column(name = "tour_hanche")
    private float tourHanche;

    private int glycemie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "observation_clinique_uid")
    private ObservationClinique observationClinique;
    private Long observationCliniqueId;
}