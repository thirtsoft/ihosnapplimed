package com.iho.sn.dossiermedical.rendezvous.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RendezvousListeDs {

    private Long id;

    private String libelle;

    private String nomCompletPatient;

    private String nomCompletMedecin;

    private String heure;

    private Date dateRendezVous;

    private Date createDate;

    private int actif;

    private int etat;

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
