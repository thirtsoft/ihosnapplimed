package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.ExamenDermatologique;
import com.iho.sn.dossiermedical.consultation.remote.model.ExamenDermatologiqueDs;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import com.iho.sn.referentiel.service.ElementConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExamenDermatologiqueAssembler {

    private final ReferentielAssembler referentielAssembler;
    private final ElementConsultationService elementConsultationService;

    public List<ExamenDermatologiqueDs> assembleEntitiesFrom(List<ExamenDermatologique> examenDermatologiques) {
        return examenDermatologiques.stream().map(this::assembleFromEntityToDs).toList();
    }

    public ExamenDermatologiqueDs assembleFromEntityToDs(ExamenDermatologique examenDermatologique) {
        ExamenDermatologiqueDs examenDermatologiqueDs = new ExamenDermatologiqueDs();
        examenDermatologiqueDs.setElementExamenDermatologiques(referentielAssembler.createListeElementExamenDermatologiqueDs(
                examenDermatologique.getElementExamenDermatologiques()
        ));
        return examenDermatologiqueDs;
    }

    public ExamenDermatologique assembleAntecedentFromDs(ExamenDermatologiqueDs examenDermatologiqueDs) {
        ExamenDermatologique examenDermatologique = new ExamenDermatologique();
        examenDermatologique.setElementExamenDermatologiques(referentielAssembler.createSetElementExamenDermatologique(
                examenDermatologiqueDs.getElementExamenDermatologiques()
        ));
        return examenDermatologique;
    }

    public ExamenDermatologique assembleUpdateEntityFromDs(ExamenDermatologique examenDermatologique,
                                                           ExamenDermatologiqueDs examenDermatologiqueDs) {
        examenDermatologique.setElementExamenDermatologiques(
                referentielAssembler.createSetElementExamenDermatologique(examenDermatologiqueDs.getElementExamenDermatologiques())
        );
        return examenDermatologique;
    }
}
