package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyntheseDs {

    private Long id;

    private String observation;

    private LocalDateTime createdDate;

    private String nomCompletAgent;
}