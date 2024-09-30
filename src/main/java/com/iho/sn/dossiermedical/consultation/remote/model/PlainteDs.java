package com.iho.sn.dossiermedical.consultation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlainteDs {

    private int douleur;

    private int prurit;

    private int autresP;

    private String libellePlainte;
}
