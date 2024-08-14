package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyntheseDs {

    private Long id;

    private String observation;

    private Long circuitPatientId;

    private Date createdDate;

    private String nomCompletAgent;
}