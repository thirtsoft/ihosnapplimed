package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalisationDs {

    private Long id;

    private String numeroHospitalisation;

    private String code;

    private String nomCompletPatient;

    private String matricule;

    private Long createdBy;

    private Date createdDate;

    private ObservationCliniqueDs observationCliniqueDs;

    private ExamenComplementaireDs examenComplementaireDs;

    private TraitementMedicalDs traitementMedicalDs;

    private DiscussionDs discussionDs;

    private SyntheseDs syntheseDs;

    private String resume;

    private int est_Transfer;
}