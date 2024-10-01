package com.iho.sn.referentiel.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
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
@Table(name = "iho_element_hypothese")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ElementHypothese extends AbstractAuditableEntity implements Serializable {

    @Column(unique = true)
    private String libelle;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "souselementhypothese_par_elementhypothese",
            joinColumns = @JoinColumn(name = "element_hypothese_uid"),
            inverseJoinColumns = @JoinColumn(name = "sous_element_hypothese_uid"))
    private Set<SousElementHypothese> sousElementHypothese;

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
