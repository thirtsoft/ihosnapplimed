package com.iho.sn.dossiermedical.hospitalisation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_observation_clinique")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObservationClinique extends AbstractAuditableEntity implements Serializable {


    @Column(name = "motifs_hospitalisation", columnDefinition = "TEXT")
    private String motifsHospitalisation;

    @Column(name = "histoire_maladie", columnDefinition = "TEXT")
    private String histoireMaladie;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Antecedent antecedent;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private ExamenPhysique examenPhysique;
}