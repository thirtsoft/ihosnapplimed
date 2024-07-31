package com.iho.sn.entity.fixture;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;

public class TraitementMedicalFixture {

    private TraitementMedicalFixture() {
        // hide
    }

    public static TraitementMedical traitementMedical(){
        return TraitementMedical.builder()
                .id(1L)
                .protocole("protocole")
                .build();
    }
}