package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.Interrogation;
import com.iho.sn.dossiermedical.consultation.remote.model.InterrogationDs;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
public class InterrogationAssembler {

    private final PlainteAssembler plainteAssembler;

    private final RecherceNotionAssembler recherceNotionAssembler;

    private final TerrainAssembler terrainAssembler;

    public List<InterrogationDs> assembleEntitiesFrom(List<Interrogation> interrogations) {
        return interrogations.stream().map(this::assembleFromEntityToDs).toList();
    }

    public InterrogationDs assembleFromEntityToDs(Interrogation interrogation) {
        return InterrogationDs.builder()
                .plainteDs(plainteAssembler.assembleFromEntityToDs(interrogation.getPlainte()))
                .rechercheNotionDs(recherceNotionAssembler.assembleFromEntityToDs(interrogation.getRechercheNotion()))
                .terrainDs(terrainAssembler.assembleFromEntityToDs(interrogation.getTerrain()))
                .build();
    }

    public Interrogation assembleEntityFromDs(InterrogationDs interrogationDs) {
        return Interrogation.builder()
                .plainte(plainteAssembler.assembleAntecedentFromDs(interrogationDs.getPlainteDs()))
                .rechercheNotion(recherceNotionAssembler.assembleAntecedentFromDs(interrogationDs.getRechercheNotionDs()))
                .terrain(terrainAssembler.assembleAntecedentFromDs(interrogationDs.getTerrainDs()))
                .build();
    }

    public Interrogation assembleUpdateEntityFromDs(Interrogation interrogation, InterrogationDs interrogationDs) {
        return Interrogation.builder()
                .plainte(plainteAssembler.assembleAntecedentFromDs(interrogationDs.getPlainteDs()))
                .rechercheNotion(recherceNotionAssembler.assembleAntecedentFromDs(interrogationDs.getRechercheNotionDs()))
                .terrain(terrainAssembler.assembleAntecedentFromDs(interrogationDs.getTerrainDs()))
                .build();
    }
}
