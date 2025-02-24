package com.iho.sn.admin.remote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurDs {

    @NotNull
    private String codeUtilisateur;
    //    @NotNull
    private String motDePasse;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String email;
    //    @NotNull
//    private String profileCode;
    private String matricule;
    private String civilite;
    private String sexe;
    private String telephone;
    private Date dateRecrutement;

    private Long id;
    private String motdepasseprecedent;
    private int est_valide;
    private int mdpamodifier;

    @NotNull
    private String fonction;

    private String adresse;

    @NotNull
    private String typeUtilisateur;

    private String education;

    private String experience;

    private String speciality;

    @NotNull
    private ProfilDs profilDs;

    private boolean actif;


    public boolean isEst_valide() {
        if (est_valide == 1)
            return true;
        else
            return false;
    }

    public void setEst_valide(boolean est_valide) {
        if (est_valide == true)
            this.est_valide = 1;
        else
            this.est_valide = 0;
    }

    public boolean isMdpamodifier() {
        if (mdpamodifier == 1)
            return true;
        else
            return false;
    }

    public void setMdpamodifier(boolean mdpamodifier) {
        if (mdpamodifier == true)
            this.mdpamodifier = 1;
        else
            this.mdpamodifier = 0;
    }
}