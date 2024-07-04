package com.iho.sn.referentiel.entity;

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
@Table(name = "iho_medicament")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicament extends ReferencetielEntity implements Serializable {

    @Column(name = "category_medicament_uid" , nullable = false)
    private Long categoryMedicamentId;

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
