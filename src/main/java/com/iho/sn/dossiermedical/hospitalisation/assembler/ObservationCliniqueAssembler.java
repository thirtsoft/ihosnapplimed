package com.iho.sn.dossiermedical.hospitalisation.assembler;

import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.hospitalisation.entity.ObservationClinique;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.ObservationCliniqueDs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ObservationCliniqueAssembler {

    private final ExamenPhysiqueAssembler examenPhysiqueAssembler;
    private final AntecedentAssembler antecedentAssembler;
    private final UtilisateurService utilisateurService;


    public List<ObservationCliniqueDs> assembleEntitiesFrom(List<ObservationClinique> observationCliniques) {
        return observationCliniques.stream().map(this::assembleEntityToDs).toList();
    }

    public List<ObservationClinique> assembleEntitiesFromDs(List<ObservationCliniqueDs> observationCliniqueDs) {
        return observationCliniqueDs.stream().map(this::assembleObservationCliniqueFromDs).toList();
    }

    public ObservationCliniqueDs assembleEntityToDs(ObservationClinique observationClinique) {
        ObservationCliniqueDs observationCliniqueDs = new ObservationCliniqueDs();
        if (observationClinique.getId() != null) observationCliniqueDs.setId(observationClinique.getId());
        observationCliniqueDs.setMotifsHospitalisation(observationClinique.getMotifsHospitalisation());
        observationCliniqueDs.setHistoireMaladie(observationClinique.getHistoireMaladie());
        if (observationClinique.getAntecedent() != null)
            observationCliniqueDs.setAntecedentDs(antecedentAssembler.assembleEntityToDs(observationClinique.getAntecedent()));
        if (observationClinique.getExamenPhysique() != null)
            observationCliniqueDs.setExamenPhysiqueDs(examenPhysiqueAssembler.assembleEntityToDs(observationClinique.getExamenPhysique()));
        if (observationClinique.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(observationClinique.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            observationCliniqueDs.setNomCompletAgent(nomAgent);
        }
        return observationCliniqueDs;
    }

    public ObservationClinique assembleObservationCliniqueFromDs(ObservationCliniqueDs observationCliniqueDs) {
        ObservationClinique observationClinique = new ObservationClinique();
        if (observationCliniqueDs.getId() != null) observationClinique.setId(observationCliniqueDs.getId());
        observationClinique.setMotifsHospitalisation(observationCliniqueDs.getMotifsHospitalisation());
        observationClinique.setHistoireMaladie(observationCliniqueDs.getHistoireMaladie());
        if (observationCliniqueDs.getExamenPhysiqueDs() != null)
            observationClinique.setExamenPhysique(examenPhysiqueAssembler.assembleExamenPhysiqueFromDs(observationCliniqueDs.getExamenPhysiqueDs()));
        if (observationCliniqueDs.getAntecedentDs() != null)
            observationClinique.setAntecedent(antecedentAssembler.assembleAntecedentFromDs(observationCliniqueDs.getAntecedentDs()));
        return observationClinique;
    }

    public ObservationClinique assembleUpdateObservationCliniqueFromDs(ObservationClinique observationClinique, ObservationCliniqueDs observationCliniqueDs) {
        observationClinique.setMotifsHospitalisation(observationCliniqueDs.getMotifsHospitalisation());
        observationClinique.setHistoireMaladie(observationCliniqueDs.getHistoireMaladie());
        if (observationCliniqueDs.getExamenPhysiqueDs() != null)
            observationClinique.setExamenPhysique(examenPhysiqueAssembler.assembleUpdateExamenPhysiqueFromDs(observationClinique.getExamenPhysique(), observationCliniqueDs.getExamenPhysiqueDs()));
        if (observationCliniqueDs.getAntecedentDs() != null)
            observationClinique.setAntecedent(antecedentAssembler.assembleUpdateAntecedentFromDs(observationClinique.getAntecedent(), observationCliniqueDs.getAntecedentDs()));
        return observationClinique;
    }
}
