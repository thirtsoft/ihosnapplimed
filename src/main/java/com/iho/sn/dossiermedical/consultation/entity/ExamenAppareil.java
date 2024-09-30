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
@Table(name = "iho_examen_appareil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ExamenAppareil extends AbstractAuditableEntity implements Serializable {

    @Column(name = "examen_appareil", columnDefinition = "TEXT")
    private String examenApp;
}
