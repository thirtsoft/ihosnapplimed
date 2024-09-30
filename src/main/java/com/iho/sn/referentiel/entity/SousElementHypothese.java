package com.iho.sn.referentiel.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
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
@Table(name = "iho_sous_element_hypothese")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SousElementHypothese extends AbstractAuditableEntity implements Serializable {

    @Column(unique = true)
    private String libelle;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "souselementdermatoseinf_par_souselementhypothese",
            joinColumns = @JoinColumn(name = "sous_element_hypothese_uid"))
    @Column(name = "sous_element_dermatose_inf_uid")
    private Set<Long> sousElementDermatoseInfs;

    private int actif;

    public boolean isActif() {
        return actif == 1;
    }

    public void setActif(boolean actif) {
        if (actif)
            this.actif = 1;
        else
            this.actif = 0;
    }
}
