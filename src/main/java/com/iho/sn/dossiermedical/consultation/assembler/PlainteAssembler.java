package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.Plainte;
import com.iho.sn.dossiermedical.consultation.remote.model.PlainteDs;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlainteAssembler {

    private final ReferentielAssembler referentielAssembler;

    public List<PlainteDs> assembleEntitiesFrom(List<Plainte> plainteList) {
        return plainteList.stream().map(this::assembleFromEntityToDs).toList();
    }

    public PlainteDs assembleFromEntityToDs(Plainte plainte) {
        PlainteDs plainteDs = new PlainteDs();
        return plainteDs;
    }

    public Plainte assembleAntecedentFromDs(PlainteDs plainteDs) {
        Plainte plainte = new Plainte();
        return plainte;
    }

    public Plainte assembleUpdateEntityFromDs(Plainte plainte, PlainteDs plainteDs) {
        return plainte;
    }
}
