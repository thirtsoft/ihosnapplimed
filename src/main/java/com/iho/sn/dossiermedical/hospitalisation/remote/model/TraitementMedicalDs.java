package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraitementMedicalDs {

    private Long id;

    private String protocole;

    private String protocoleFileName;

    private List<TraitementMedicalItemDs> traitementMedicalItemDs;

    private LocalDateTime createdDate;

    private String nomCompletAgent;
}