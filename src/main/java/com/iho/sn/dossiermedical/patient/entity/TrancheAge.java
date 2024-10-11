package com.iho.sn.dossiermedical.patient.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "iho_tranche_age")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrancheAge extends AbstractAuditableEntity implements Serializable {

    private String code;

    private String libelle;


}
