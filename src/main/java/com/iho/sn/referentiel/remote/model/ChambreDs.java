package com.iho.sn.referentiel.remote.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChambreDs {

    private Long id;
    @NotEmpty(message = "Le code ne doit pas etre null ou vide")
    private String code;

    @NotEmpty(message = "Le libellé ne doit pas etre null ou vide")
    private String libelle;

    @NotEmpty(message = "Le nombre de lit ne doit pas etre null ou vide")
    @Pattern(regexp="(^$|[0-9])", message = "Le téléphone doit comporter des chiffre entre 0 et 9")
    private int nbreLit;

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
