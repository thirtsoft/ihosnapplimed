package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalisationDetailDs {

    private Long id;

    private String numeroHospitalisation;

    private PatientDetailDs patientDetailDs;

    private UtilisateurDs utilisateurDs;

    private ObservationCliniqueDs observationCliniqueDs;

    private ExamenComplementaireDs examenComplementaireDs;

    private TraitementMedicalDs traitementMedicalDs;

    private DiscussionDs discussionDs;

    private SyntheseDs syntheseDs;

    private Long createdBy;

    private Date createdDate;

    private String resume;

    private String nomCompletMedecin;

    private int estTransfer;

    private Date createDate;
}