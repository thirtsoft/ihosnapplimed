package com.iho.sn.referentiel.remote.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementPlainteDs {

    private Long id;

    @NotEmpty(message = "Le libellé ne doit pas etre null ou vide")
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
