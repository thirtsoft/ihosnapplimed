package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionDs {
    private Long id;

    private String resume;

    private Long circuitPatientId;

    private String nomCompletAgent;
}
