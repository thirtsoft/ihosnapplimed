package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalisationListDs {

    private Long id;

    private String numeroHospitalisation;

    private String nomCompletPatient;

    private String nomCompletMedecin;

    private String resume;

    private int est_Transfer;

    private LocalDateTime createDate;

    private String createdByUser;
}