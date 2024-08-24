package com.iho.sn.enumeration;

import lombok.Getter;

import java.io.Serializable;
import java.util.stream.Stream;

@Getter
public enum StatusHospitalisation implements Serializable {
    EN_COURS("En Cours"),
    SORTIE("Sortie"),
    TRANSFERE("Transféré"),
    DECES("Décès");

    private final String label;

    StatusHospitalisation(String label) {
        this.label = label;
    }

    public boolean isStatusEnCour() {
        return this.equals(EN_COURS);
    }


    public static StatusHospitalisation forHospitalisation(String label) {
        return Stream.of(values())
                .filter(statusHospitalisation -> label.equalsIgnoreCase(statusHospitalisation.getLabel()))
                .findFirst()
                .orElse(null);
    }
}
