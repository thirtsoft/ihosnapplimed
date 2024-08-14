package com.iho.sn.dossiermedical.hospitalisation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_hospitalisation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Hospitalisation extends AbstractAuditableEntity implements Serializable {

    @Column(name = "numero_hospisatisation", nullable = false, unique = true)
    private int numeroHospitalisation;

    @Column(name = "patient_uid")
    private String code;

    @OneToOne(cascade = {CascadeType.ALL})
    private ObservationClinique observationClinique;

    @OneToOne(cascade = {CascadeType.ALL})
    private ExamenComplementaire examenComplementaire;

    @OneToOne(cascade = {CascadeType.ALL})
    private TraitementMedical traitementMedical;

    @OneToOne(cascade = {CascadeType.ALL})
    private Discussion discussion;

    @OneToOne(cascade = {CascadeType.ALL})
    private Synthese synthese;

    @Column(name = "type_patient", columnDefinition = "int default 1")
    private int typePatient;
}