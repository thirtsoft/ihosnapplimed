package com.iho.sn.dossiermedical.hospitalisation.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_traitement_medical")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TraitementMedical extends AbstractAuditableEntity implements Serializable {

    @Column(columnDefinition = "TEXT")
    private String protocole;
    private String protocoleFileName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "traitement_medical_item_par_traitement",
            joinColumns = @JoinColumn(name = "traitement_uid"),
            inverseJoinColumns = @JoinColumn(name = "traitement_medical_item_uid"))
    private Set<TraitementMedicalItem> traitementMedicalItems;
}