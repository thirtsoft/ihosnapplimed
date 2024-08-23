package com.iho.sn.dossiermedical.hospitalisation.assembler;

import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.TraitementMedicalDs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TraitementMedicalAssembler {

    private final TraitementMedicalItemAssembler traitementMedicalItemAssembler;
    private final UtilisateurService utilisateurService;

    public List<TraitementMedicalDs> assembleEntitiesFrom(List<TraitementMedical> traitementMedicals) {
        return traitementMedicals.stream().map(this::assembleEntityToDs).toList();
    }

    public List<TraitementMedical> assembleEntitiesFromDs(List<TraitementMedicalDs> traitementMedicalDs) {
        return traitementMedicalDs.stream().map(this::assembleTraitementMedicalFromDs).toList();
    }

    public TraitementMedicalDs assembleEntityToDs(TraitementMedical traitementMedical) {
        TraitementMedicalDs traitementMedicalDs = new TraitementMedicalDs();
        if (traitementMedical.getId() != null)
            traitementMedicalDs.setId(traitementMedical.getId());
        traitementMedicalDs.setTraitementMedicalItemDs(traitementMedicalItemAssembler.createListTraitementMedicalItemDs(traitementMedical.getTraitementMedicalItems()));
        traitementMedicalDs.setProtocole(traitementMedical.getProtocole());
        traitementMedicalDs.setProtocoleFileName(traitementMedical.getProtocoleFileName());
        if (traitementMedical.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(traitementMedical.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            traitementMedicalDs.setNomCompletAgent(nomAgent);
        }
        traitementMedicalDs.setCreatedDate(traitementMedical.getCreationDate());
        return traitementMedicalDs;
    }

    public TraitementMedical assembleTraitementMedicalFromDs(TraitementMedicalDs traitementMedicalDs) {
        TraitementMedical traitementMedical = new TraitementMedical();
        if (traitementMedicalDs.getId() != null)
            traitementMedical.setId(traitementMedicalDs.getId());
        traitementMedical.setTraitementMedicalItems(traitementMedicalItemAssembler.createSetTraitementMedicalItem(traitementMedicalDs.getTraitementMedicalItemDs()));
        traitementMedical.setProtocole(traitementMedicalDs.getProtocole());
        traitementMedical.setProtocoleFileName(traitementMedicalDs.getProtocoleFileName());
        return traitementMedical;
    }

    public TraitementMedical assembleUpdateTraitementMedicalFromDs(TraitementMedical traitementMedical, TraitementMedicalDs traitementMedicalDs) {
        traitementMedical.setTraitementMedicalItems(traitementMedicalItemAssembler
                .createUpdateSetTraitementMedicalItem(traitementMedicalDs.getTraitementMedicalItemDs()));
        traitementMedical.setProtocole(traitementMedicalDs.getProtocole());
        traitementMedical.setProtocoleFileName(traitementMedicalDs.getProtocoleFileName());
        return traitementMedical;
    }
}