package com.iho.sn.dossiermedical.rendezvous.entity;

import com.iho.sn.admin.entities.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "iho_rendez_vous")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezVous extends AbstractAuditableEntity implements Serializable {

    private String libelle;

    @Column(name = "patient_uid")
    private Long patientId;

    @Column(name = "medecin_uid")
    private Long medecinId;

    @Column(name = "date_rendez_vous")
    @Temporal(TemporalType.DATE)
    private Date dateRendezVous;

    private Date createDate;

    private String heure;

    private int etat;

    private int actif;

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }
}
