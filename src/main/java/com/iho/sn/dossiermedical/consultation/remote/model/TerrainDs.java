package com.iho.sn.dossiermedical.consultation.remote.model;

import com.iho.sn.referentiel.remote.model.ElementTerrainDs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerrainDs {

    private List<ElementTerrainDs> elementTerrains;

}
