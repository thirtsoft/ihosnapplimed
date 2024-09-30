package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.Terrain;
import com.iho.sn.dossiermedical.consultation.remote.model.TerrainDs;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
@RequiredArgsConstructor
public class TerrainAssembler {

    private final ReferentielAssembler referentielAssembler;

    public List<TerrainDs> assembleEntitiesFrom(List<Terrain> terrains) {
        return terrains.stream().map(this::assembleFromEntityToDs).toList();
    }

    public TerrainDs assembleFromEntityToDs(Terrain terrain) {
        TerrainDs terrainDs = new TerrainDs();
        terrainDs.setElementTerrains(referentielAssembler.createListeElementTerrainDs(
                terrain.getElementTerrains()
        ));
        return terrainDs;
    }

    public Terrain assembleAntecedentFromDs(TerrainDs terrainDs) {
        Terrain terrain = new Terrain();
        terrain.setElementTerrains(referentielAssembler.createSetElementTerrain(
                terrainDs.getElementTerrains()
        ));
        return terrain;
    }

    public Terrain assembleUpdateEntityFromDs(Terrain terrain, TerrainDs terrainDs) {
        return Terrain.builder()
                .elementTerrains(referentielAssembler.createSetElementTerrain(terrainDs.getElementTerrains()))
                .build();
    }
}
