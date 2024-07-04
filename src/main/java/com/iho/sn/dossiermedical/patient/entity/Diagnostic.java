package com.iho.sn.dossiermedical.patient.entity;

import com.iho.sn.config.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "iho_diagnostic")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diagnostic extends AbstractAuditableEntity implements Serializable {

    @Column(columnDefinition = "TEXT")
    private String diagnostic_principal;

    @Column(columnDefinition = "TEXT")
    private String diagnostic_associe;

}
