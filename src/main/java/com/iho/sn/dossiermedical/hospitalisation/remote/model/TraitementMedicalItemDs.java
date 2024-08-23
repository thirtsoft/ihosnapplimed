package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraitementMedicalItemDs {

    private Long id;
    private Long medicamendId;
    private String psologie;
    private String nbrePrise;
    private String administrePar;
    private int estAdministre;
    private LocalDateTime datePrescription;
    private String libelleMedicament;
}