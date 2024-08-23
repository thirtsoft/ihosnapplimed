package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import com.iho.sn.admin.remote.model.UtilisateurDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalisationDetailDs {

    private Long id;

    private String numeroHospitalisation;

    private UtilisateurDs utilisateurDs;

    private ObservationCliniqueDs observationCliniqueDs;

    private ExamenComplementaireDs examenComplementaireDs;

    private TraitementMedicalDs traitementMedicalDs;

    private DiscussionDs discussionDs;

    private SyntheseDs syntheseDs;

    private Long createdBy;

    private LocalDateTime createdDate;

    private String resume;

    private String nomCompletMedecin;

    private String nomCompletPatient;

    private String civilitePatient;

    private String codePatient;

    private String situationMatrimonialPatient;

    private String telephonePatient;

    private int estTransfer;

    private Date createDate;
}