package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.dossiermedical.consultation.entity.ConstancePhysique;
import com.iho.sn.dossiermedical.consultation.remote.model.ConstancePhysiqueDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConstancePhysiqueAssembler {

    public List<ConstancePhysiqueDs> assembleEntitiesFrom(List<ConstancePhysique> constancePhysiques) {
        return constancePhysiques.stream().map(this::assembleConstancePhysiqueDsFromEntity).toList();
    }

    public ConstancePhysiqueDs assembleConstancePhysiqueDsFromEntity(ConstancePhysique constancePhysique) {
        return ConstancePhysiqueDs.builder()
                .poids(constancePhysique.getPoids())
                .temperature(constancePhysique.getTemperature())
                .frequenceR(constancePhysique.getFrequenceR())
                .taille(constancePhysique.getTaille())
                .autreConstances(constancePhysique.getAutreConstances())
                .imc(constancePhysique.getImc())
                .poul(constancePhysique.getPoul())
                .frequenceC(constancePhysique.getFrequenceC())
                .tensionArterielD(constancePhysique.getTensionArterielD())
                .tensionArterielS(constancePhysique.getTensionArterielS())
                .build();
    }

    public ConstancePhysique assembleConstancePhysiqueFromDs(ConstancePhysiqueDs constancePhysiqueDs) {
        return ConstancePhysique.builder()
                .poids(constancePhysiqueDs.getPoids())
                .temperature(constancePhysiqueDs.getTemperature())
                .frequenceR(constancePhysiqueDs.getFrequenceR())
                .taille(constancePhysiqueDs.getTaille())
                .autreConstances(constancePhysiqueDs.getAutreConstances())
                .imc(constancePhysiqueDs.getImc())
                .poul(constancePhysiqueDs.getPoul())
                .frequenceC(constancePhysiqueDs.getFrequenceC())
                .tensionArterielD(constancePhysiqueDs.getTensionArterielD())
                .tensionArterielS(constancePhysiqueDs.getTensionArterielS())
                .build();
    }
}
