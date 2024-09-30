package com.iho.sn.dossiermedical.consultation.remote.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConstancePhysiqueDs {

    private float poids;

    private float temperature;

    private double tensionArterielS;

    private double tensionArterielD;

    private double frequenceR;

    private double poul;

    private float taille;

    private float imc;

    private String autreConstances;

    private int frequenceC;

}
