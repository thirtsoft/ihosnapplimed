package com.iho.sn.dossiermedical.hospitalisation.assembler;

import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedicalItem;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.TraitementMedicalItemDs;
import com.iho.sn.dossiermedical.hospitalisation.service.TraitementMedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TraitementMedicalItemAssembler {

    private final TraitementMedicalService traitementMedicalService;


    public List<TraitementMedicalItemDs> assembleEntitiesFrom(List<TraitementMedicalItem> traitementMedicalItemList) {
        return traitementMedicalItemList.stream().map(this::assembleEntityToDs).toList();
    }

    public List<TraitementMedicalItemDs> createListTraitementMedicalItemDs(Set<TraitementMedicalItem> traitementMedicalItems) {
        if (traitementMedicalItems == null) return Collections.emptyList();
        List<TraitementMedicalItemDs> dtos = new ArrayList<>();
        for (TraitementMedicalItem TraitementMedicalItem : traitementMedicalItems) {
            dtos.add(assembleEntityToDs(TraitementMedicalItem));
        }
        return dtos;
    }

    public Set<TraitementMedicalItem> createSetTraitementMedicalItem(List<TraitementMedicalItemDs> traitementMedicalItemDs) {
        if (traitementMedicalItemDs == null) return null;
        Set<TraitementMedicalItem> actions = new HashSet<>();
        for (TraitementMedicalItemDs dto : traitementMedicalItemDs)
            if (dto != null) actions.add(assembleTraitementMedicalItemFromDs(dto));
        return actions;
    }

    public TraitementMedicalItemDs assembleEntityToDs(TraitementMedicalItem traitementMedicalItem) {
        TraitementMedicalItemDs traitementMedicalItemDs = new TraitementMedicalItemDs();
        if (traitementMedicalItem.getId() != null)
            traitementMedicalItemDs.setId(traitementMedicalItem.getId());
        traitementMedicalItemDs.setPsologie(traitementMedicalItem.getPsologie());
        traitementMedicalItemDs.setNbrePrise(traitementMedicalItem.getNbrePrise());
        traitementMedicalItemDs.setAdministrePar(traitementMedicalItem.getAdministrePar());
        traitementMedicalItemDs.setEstAdministre(traitementMedicalItem.getEstAdministre());
        traitementMedicalItemDs.setMedicamendId(traitementMedicalItem.getMedicamendId());
        return traitementMedicalItemDs;
    }

    public TraitementMedicalItem assembleTraitementMedicalItemFromDs(TraitementMedicalItemDs traitementMedicalItemDs) {
        TraitementMedicalItem traitementMedicalItem = new TraitementMedicalItem();
        if (traitementMedicalItemDs.getId() != null)
            traitementMedicalItem.setId(traitementMedicalItemDs.getId());
        if (traitementMedicalItemDs.getMedicamendId() != null)
            traitementMedicalItem.setMedicamendId(traitementMedicalItemDs.getMedicamendId());
        traitementMedicalItem.setPsologie(traitementMedicalItemDs.getPsologie());
        traitementMedicalItem.setNbrePrise(traitementMedicalItemDs.getNbrePrise());
        traitementMedicalItem.setAdministrePar(traitementMedicalItemDs.getAdministrePar());
        traitementMedicalItem.setEstAdministre(traitementMedicalItemDs.getEstAdministre());
        return traitementMedicalItem;
    }

    public Set<TraitementMedicalItem> createUpdateSetTraitementMedicalItem(List<TraitementMedicalItemDs> traitementMedicalItemDs) {
        if (traitementMedicalItemDs == null) {
            return null;
        }
        Set<TraitementMedicalItem> actions = new HashSet<>();
        for (TraitementMedicalItemDs dto : traitementMedicalItemDs) {
            actions.add(assembleUpdateTraitementMedicalItemFromDs(dto));
        }
        return actions;
    }

    public TraitementMedicalItem assembleUpdateTraitementMedicalItemFromDs(TraitementMedicalItemDs traitementMedicalItemDs) {

        if (traitementMedicalItemDs.getId() == null) {
            return traitementMedicalService.saveTraitementMedicalItem(this.assembleTraitementMedicalItemFromDs(traitementMedicalItemDs));
        }
        TraitementMedicalItem traitementMedicalItem = traitementMedicalService.findTraitementMedicalItemById(traitementMedicalItemDs.getId());

        if (traitementMedicalItemDs.getMedicamendId() != null) {
            traitementMedicalItem.setMedicamendId(traitementMedicalItemDs.getMedicamendId());
        }
        traitementMedicalItem.setPsologie(traitementMedicalItemDs.getPsologie());
        traitementMedicalItem.setNbrePrise(traitementMedicalItemDs.getNbrePrise());
        traitementMedicalItem.setAdministrePar(traitementMedicalItemDs.getAdministrePar());
        traitementMedicalItem.setEstAdministre(traitementMedicalItemDs.getEstAdministre());

        return traitementMedicalItem;
    }
}