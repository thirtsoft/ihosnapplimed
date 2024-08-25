package com.iho.sn.dossiermedical.hospitalisation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import com.iho.sn.enumeration.StatusHospitalisation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDate;

import static com.iho.sn.enumeration.StatusHospitalisation.EN_COURS;

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

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate dateEnregistrement;

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

    @Enumerated(EnumType.STRING)
    private StatusHospitalisation statusHospitalisation = EN_COURS;
}