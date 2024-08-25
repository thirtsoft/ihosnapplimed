package com.iho.sn.entity.fixture;

import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;

import static com.iho.sn.enumeration.StatusHospitalisation.EN_COURS;

public class HospitalisationFixture {

    private HospitalisationFixture() {
        // hide
    }

    public static Hospitalisation hospitalisation() {
        return Hospitalisation.builder()
                .numeroHospitalisation(1)
                .code("Code")
                .statusHospitalisation(EN_COURS)
                .build();
    }
}