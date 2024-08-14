package com.iho.sn.dossiermedical.hospitalisation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Table(name = "iho_traitement_medical_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TraitementMedicalItem extends AbstractAuditableEntity implements Serializable {


    @Column(name = "medicament_uid")
    private Long medicamendId;

    private String psologie;

    private String nbrePrise;

    private String administrePar;

    private int estAdministre;
}