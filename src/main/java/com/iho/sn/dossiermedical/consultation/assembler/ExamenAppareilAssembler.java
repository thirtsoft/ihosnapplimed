package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.ExamenAppareil;
import com.iho.sn.dossiermedical.consultation.remote.model.ExamenAppareilDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamenAppareilAssembler {

    public List<ExamenAppareilDs> assembleEntitiesFrom(List<ExamenAppareil> examenAppareils) {
        return examenAppareils.stream().map(this::assembleFromEntityToDs).toList();
    }

    public ExamenAppareilDs assembleFromEntityToDs(ExamenAppareil examenAppareil) {
        ExamenAppareilDs examenAppareilDs = new ExamenAppareilDs();
        examenAppareilDs.setExamenApp(examenAppareil.getExamenApp());
        return examenAppareilDs;
    }

    public ExamenAppareil assembleAntecedentFromDs(ExamenAppareilDs examenAppareilDs) {
        ExamenAppareil examenAppareil = new ExamenAppareil();
        examenAppareil.setExamenApp(examenAppareilDs.getExamenApp());
        return examenAppareil;
    }

    public ExamenAppareil assembleUpdateEntityFromDs(ExamenAppareil examenAppareil, ExamenAppareilDs examenAppareilDs) {
        examenAppareil.setExamenApp(examenAppareilDs.getExamenApp());
        return examenAppareil;
    }
}
