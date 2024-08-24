package com.iho.sn.enumeration;

import org.junit.jupiter.api.Test;

import static com.iho.sn.enumeration.StatusHospitalisation.DECES;
import static com.iho.sn.enumeration.StatusHospitalisation.EN_COURS;
import static com.iho.sn.enumeration.StatusHospitalisation.SORTIE;
import static com.iho.sn.enumeration.StatusHospitalisation.TRANSFERE;
import static com.iho.sn.enumeration.StatusHospitalisation.forHospitalisation;
import static org.assertj.core.api.Assertions.assertThat;

class StatusHospitalisationTest {

    @Test
    void forHospitalisation_returnsEnCours() {
        assertThat(forHospitalisation("En Cours")).isEqualTo(EN_COURS);
    }

    @Test
    void forHospitalisation_returnsSortie() {
        assertThat(forHospitalisation("Sortie")).isEqualTo(SORTIE);
    }

    @Test
    void forHospitalisation_returnsTransfere() {
        assertThat(forHospitalisation("Transféré")).isEqualTo(TRANSFERE);
    }

    @Test
    void forHospitalisation_returnsDeces() {
        assertThat(forHospitalisation("Décès")).isEqualTo(DECES);
    }

    @Test
    void forHospitalisation_throwsNoSuchElementException() {
        assertThat(forHospitalisation("Test")).isNull();
    }
}