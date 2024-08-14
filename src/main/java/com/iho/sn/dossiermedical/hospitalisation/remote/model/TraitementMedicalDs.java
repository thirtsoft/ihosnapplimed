package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraitementMedicalDs {

    private Long id;

    private Long circuitPatientId;

    private String protocole;

    private String protocoleFileName;

    private List<TraitementMedicalItemDs> traitementMedicalItemDs;

    private Date createdDate;

    private String nomCompletAgent;
}