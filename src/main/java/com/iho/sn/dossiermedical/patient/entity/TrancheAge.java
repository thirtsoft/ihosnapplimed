package com.iho.sn.dossiermedical.patient.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "iho_tranche_age")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrancheAge extends AbstractAuditableEntity implements Serializable {

    @Column(unique = true)
    private String code;

    private String libelle;


}
