package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.RechercheNotion;
import com.iho.sn.dossiermedical.consultation.remote.model.RechercheNotionDs;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecherceNotionAssembler {

    private final ReferentielAssembler referentielAssembler;

    public List<RechercheNotionDs> assembleEntitiesFrom(List<RechercheNotion> rechercheNotions) {
        return rechercheNotions.stream().map(this::assembleFromEntityToDs).toList();
    }

    public RechercheNotionDs assembleFromEntityToDs(RechercheNotion rechercheNotion) {
        RechercheNotionDs rechercheNotionDs = new RechercheNotionDs();
        rechercheNotionDs.setElementRechercheNotions(referentielAssembler.createListeElementRechercheNotionDs(
                rechercheNotion.getElementRechercheNotions()
        ));
        return rechercheNotionDs;
    }

    public RechercheNotion assembleAntecedentFromDs(RechercheNotionDs rechercheNotionDs) {
        RechercheNotion rechercheNotion = new RechercheNotion();
        rechercheNotion.setElementRechercheNotions(referentielAssembler.createSetElementRechercheNotion(
                rechercheNotionDs.getElementRechercheNotions()
        ));
        return rechercheNotion;
    }

    public RechercheNotion assembleUpdateEntityFromDs(RechercheNotion rechercheNotion, RechercheNotionDs rechercheNotionDs) {
        rechercheNotion.setElementRechercheNotions(referentielAssembler.createSetElementRechercheNotion(
                rechercheNotionDs.getElementRechercheNotions()
        ));
        return rechercheNotion;
    }
}
