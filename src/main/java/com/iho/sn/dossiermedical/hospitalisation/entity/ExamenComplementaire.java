package com.iho.sn.dossiermedical.hospitalisation.entity;

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
@Table(name = "iho_examen_complementaire")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ExamenComplementaire extends AbstractAuditableEntity implements Serializable {

    @Column(columnDefinition = "TEXT")
    private String biologie;

    private String biologieFileName;

    @Column(columnDefinition = "TEXT")
    private String immunologie;

    private String immunologieFileName;

    @Column(columnDefinition = "TEXT")
    private String imagerie;

    private String imagerieFileName;

    @Column(columnDefinition = "TEXT")
    private String anatomopathologie;

    private String anatomopathologieFileName;
}