package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.HypotheseDiagnostique;
import com.iho.sn.dossiermedical.consultation.remote.model.HypotheseDiagnostiqueDs;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HypotheseDiagnostiqueAssembler {

    private final ReferentielAssembler referentielAssembler;

    public List<HypotheseDiagnostiqueDs> assembleEntitiesFrom(List<HypotheseDiagnostique> hypotheseDiagnostiques) {
        return hypotheseDiagnostiques.stream().map(this::assembleFromEntityToDs).toList();
    }

    public HypotheseDiagnostiqueDs assembleFromEntityToDs(HypotheseDiagnostique hypotheseDiagnostique) {
        HypotheseDiagnostiqueDs hypotheseDiagnostiqueDs = new HypotheseDiagnostiqueDs();
    //    hypotheseDiagnostiqueDs.setDermatologieInf(referentielAssembler.createSetSousElementDermatoseInf(hypotheseDiagnostiqueDs.getDermatologieInf()));
        return hypotheseDiagnostiqueDs;
    }

    public HypotheseDiagnostique assembleAntecedentFromDs(HypotheseDiagnostiqueDs hypotheseDiagnostiqueDs) {
        HypotheseDiagnostique hypotheseDiagnostique = new HypotheseDiagnostique();
      //  hypotheseDiagnostique.setDermatologieInf(hypotheseDiagnostiqueDs.getDermatologieInf());
        return hypotheseDiagnostique;
    }

    public HypotheseDiagnostique assembleUpdateEntityFromDs(HypotheseDiagnostique hypotheseDiagnostique, HypotheseDiagnostiqueDs hypotheseDiagnostiqueDs) {
    //    hypotheseDiagnostique.setDermatologieInf(hypotheseDiagnostiqueDs.getDermatologieInf());
        return hypotheseDiagnostique;
    }
}