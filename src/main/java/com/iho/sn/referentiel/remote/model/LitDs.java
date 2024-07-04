package com.iho.sn.referentiel.remote.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LitDs {

    private Long id;

    @NotEmpty(message = "Le code ne doit pas etre null ou vide")
    private String numero;

    @NotEmpty(message = "Le code de la chambre ne doit pas etre null ou vide")
    private Long ChambreId;

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
