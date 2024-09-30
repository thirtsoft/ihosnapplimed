package com.iho.sn.dossiermedical.consultation.remote.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BilanParacliniqueDs {

    private String biologie;

    private String biochimie ;
}
