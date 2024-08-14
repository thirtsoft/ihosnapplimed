package com.iho.sn.dossiermedical.hospitalisation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AntecedentDs {

    private Long id;

    private String antecedentsMedicaux;

    private String antecedentsChirurgicaux;

    private String antecedentsGynecologiques;

    private String antecedentsFamilialsAscendant;

    private String antecedentsFamilialsCollateral;

    private String antecedentsFamilialsDescendant;

    private String modeVies;

    private Date createDate;
}