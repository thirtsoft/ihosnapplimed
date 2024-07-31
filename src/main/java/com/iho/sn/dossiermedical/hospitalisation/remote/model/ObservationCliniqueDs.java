package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservationCliniqueDs {

    private Long id;

    private String motifsHospitalisation;

    private String histoireMaladie;

    private AntecedentDs antecedentDs;

    private ExamenPhysiqueDs examenPhysiqueDs;

    private Long createdBy;

    private String nomCompletAgent;

    private Date createdDate;
}