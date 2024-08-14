package com.iho.sn.dossiermedical.hospitalisation.assembler;

import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.hospitalisation.entity.Synthese;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.SyntheseDs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SyntheseAssembler {

    private final UtilisateurService utilisateurService;

    public SyntheseAssembler(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public List<SyntheseDs> assembleEntitiesFrom(List<Synthese> syntheseList) {
        return syntheseList.stream().map(this::assembleEntityToDs).toList();
    }

    public List<Synthese> assembleEntitiesFromDs(List<SyntheseDs> syntheseList) {
        return syntheseList.stream().map(this::assembleSyntheseFromDs).toList();
    }

    public SyntheseDs assembleEntityToDs(Synthese synthese) {
        SyntheseDs syntheseDs = new SyntheseDs();
        if (synthese.getId() != null)
            syntheseDs.setId(synthese.getId());
        syntheseDs.setObservation(synthese.getObservation());
        if (synthese.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(synthese.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            syntheseDs.setNomCompletAgent(nomAgent);
        }
        return syntheseDs;
    }

    public Synthese assembleSyntheseFromDs(SyntheseDs syntheseDs) {
        Synthese synthese = new Synthese();
        if (syntheseDs.getId() != null)
            synthese.setId(syntheseDs.getId());
        synthese.setObservation(syntheseDs.getObservation());
        return synthese;
    }

    public Synthese assembleUpdateSyntheseFromDs(Synthese synthese, SyntheseDs syntheseDs) {
        synthese.setObservation(syntheseDs.getObservation());
        return synthese;
    }
}