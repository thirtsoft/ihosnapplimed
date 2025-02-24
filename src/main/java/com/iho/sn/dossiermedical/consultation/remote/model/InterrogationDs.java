package com.iho.sn.dossiermedical.consultation.remote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterrogationDs {

    private RechercheNotionDs rechercheNotionDs;

    private TerrainDs terrainDs;

    private PlainteDs plainteDs;
}
