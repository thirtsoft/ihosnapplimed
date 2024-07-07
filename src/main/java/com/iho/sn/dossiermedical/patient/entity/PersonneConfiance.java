package com.iho.sn.dossiermedical.patient.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "iho_personne_confiance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneConfiance  extends AbstractAuditableEntity implements Serializable {
    private String prenom;
    private String nom;
    private String telephone;
    private String email;
}
