package com.iho.sn.dossiermedical.consultation.remote.model;

import com.iho.sn.referentiel.remote.model.ElementExamenDermatologiqueDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamenDermatologiqueDs {

    private List<ElementExamenDermatologiqueDs> elementExamenDermatologiques;

}
