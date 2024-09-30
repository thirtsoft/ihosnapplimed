package com.iho.sn.dossiermedical.consultation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_constance_physique")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ConstancePhysique extends AbstractAuditableEntity implements Serializable {

    private float poids;

    private float temperature;

    @Column(name = "tension_arterielle_systolique")
    private double tensionArterielS;

    @Column(name = "pression_arterielle_diastolique")
    private double tensionArterielD;

    @Column(name = "frequence_respiratoire")
    private double frequenceR;

    private double poul;

    private float taille;

    private float imc;

    @Column(name = "autre_constances", columnDefinition = "TEXT")
    private String autreConstances;

    @Column(name = "frequence_cardique")
    private int frequenceC;

}
