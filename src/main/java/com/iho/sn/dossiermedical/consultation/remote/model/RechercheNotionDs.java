package com.iho.sn.dossiermedical.consultation.remote.model;

import com.iho.sn.referentiel.remote.model.ElementRechercheNotionDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechercheNotionDs {

    private List<ElementRechercheNotionDs> elementRechercheNotions;

}
