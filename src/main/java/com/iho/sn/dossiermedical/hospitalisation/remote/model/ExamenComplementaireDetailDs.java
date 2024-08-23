package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamenComplementaireDetailDs {

    private Long id;

    private Long createdBy;

    private String biologie;

    private String biologieFileName;

    private String immunologie;

    private String immunologieFileName;

    private String imagerie;

    private String imagerieFileName;

    private String anatomopathologie;

    private String anatomopathologieFileName;

    private LocalDateTime createdDate;

    private String nomCompletAgent;
}