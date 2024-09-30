package com.iho.sn.referentiel.entity;

import com.iho.sn.admin.entities.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_sous_element_dermatose_infectieuse")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SousElementDermatoseInf extends AbstractEntity implements Serializable {

    @Column(unique = true)
    private String libelle;

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
