package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservationCliniqueDetailDs {

    private Long id;

    private List<String> motifsHospitalisation;

    private String histoireMaladie;

    private AntecedentDs antecedentDs;

    private List<ExamenPhysiqueDs> examenPhysiqueDs;

    private Long createdBy;

    private Date createdDate;
}