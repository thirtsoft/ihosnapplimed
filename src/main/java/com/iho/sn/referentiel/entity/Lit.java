package com.iho.sn.referentiel.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "iho_lit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lit extends AbstractAuditableEntity implements Serializable {

    @Column(unique = true)
    private String numero;

    @Column(name = "chambre_uid", nullable = false)
    private Long chambreId;

    private boolean est_disponible;

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
