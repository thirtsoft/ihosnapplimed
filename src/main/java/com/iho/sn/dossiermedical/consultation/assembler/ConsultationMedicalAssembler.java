package com.iho.sn.dossiermedical.consultation.assembler;

import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.consultation.entity.ConsultationMedical;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalDetailsDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalListeDs;
import com.iho.sn.dossiermedical.hospitalisation.assembler.ExamenPhysiqueAssembler;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import com.iho.sn.referentiel.assembler.ReferentielAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.iho.sn.utils.UtilString.createNumeroConsultation;

@Component
@RequiredArgsConstructor
public class ConsultationMedicalAssembler {

    private final PatientService patientService;
    private final UtilisateurService utilisateurService;
    private final BilanParacliniqueAssembler bilanParacliniqueAssembler;
    private final ExamenPhysiqueAssembler examenPhysiqueAssembler;
    private final ExamenAppareilAssembler examenAppareilAssembler;
    private final ResumeSyndromiqueAssembler resumeSyndromiqueAssembler;
    private final ReferentielAssembler referentielAssembler;
    private final ConstancePhysiqueAssembler constancePhysiqueAssembler;


    public List<ConsultationMedicalListeDs> assembleEntitiesFrom(List<ConsultationMedical> consultationMedicals) {
        return consultationMedicals.stream().map(this::assembleFromEntityToListeDs).toList();
    }

    public List<ConsultationMedicalDetailsDs> assembleConsultationMedicalDetailsDsFromEntities(List<ConsultationMedical> consultationMedicals) {
        return consultationMedicals.stream().map(this::assembleFromEntityToDetailsDs).toList();
    }

    public ConsultationMedicalListeDs assembleFromEntityToListeDs(ConsultationMedical consultationMedical) {
        Patient foundPatientbyCode = patientService.findByCode(consultationMedical.getCode());
        String patient = foundPatientbyCode.getPrenom() + " " + foundPatientbyCode.getNom();
        Utilisateur foundUser = utilisateurService.findUtilisateurByMatricule(consultationMedical.getCreatedByUser());
        String user = foundUser.getPrenom() + " " + foundUser.getNom();
        String typePatientConsulte = "";
        if (consultationMedical.getTypePatient() == 1) {
            typePatientConsulte = "Homme";
        } else {
            typePatientConsulte = "Femme";
        }
        return ConsultationMedicalListeDs.builder()
                .id(consultationMedical.getId())
                .dateConsultation(consultationMedical.getDateConsultation())
                .actif(consultationMedical.getActif())
                .numeroConsultation(createNumeroConsultation(consultationMedical.getNumeroConsultation()))
                .nomCompletPatient(patient)
                .nomCompletAgent(user)
                .typePatient(consultationMedical.getTypePatient())
                .patientConsulte(typePatientConsulte)
                .build();
    }

    public ConsultationMedicalDs assembleFromEntityToDs(ConsultationMedical consultationMedical) {
        return ConsultationMedicalDs.builder()
                .code(consultationMedical.getCode())
                .actif(consultationMedical.getActif())
                .dateConsultation(consultationMedical.getDateConsultation())
                .bilanParacliniqueDs(bilanParacliniqueAssembler.assembleFromEntityToDs(consultationMedical.getBilanParaclinique()))
                .examenAppareilDs(examenAppareilAssembler.assembleFromEntityToDs(consultationMedical.getExamenAppareil()))
                .elementExamenDermatologiques(referentielAssembler.createListeElementExamenDermatologiqueDs(
                        consultationMedical.getElementExamenDermatologiques()))
                .elementHypotheses(referentielAssembler.createListElementHypotheseDs(consultationMedical.getElementHypotheses()))
                .constancePhysiqueDs(constancePhysiqueAssembler.assembleConstancePhysiqueDsFromEntity(consultationMedical.getConstancePhysique()))
                .elementRechercheNotions(referentielAssembler.createListeElementRechercheNotionDs(consultationMedical.getElementRechercheNotions()))
                .elementPlaintes(referentielAssembler.createListeElementPlainteDs(consultationMedical.getElementPlaintes()))
                .elementTerrains(referentielAssembler.createListeElementTerrainDs(consultationMedical.getElementTerrains()))
                .resumeSyndromiqueDs(resumeSyndromiqueAssembler.assembleFromEntityToDs(consultationMedical.getResumeSyndromique()))
                .build();

    }

    public ConsultationMedical assembleEntityFromDs(ConsultationMedicalDs consultationMedicalDs) {
        return ConsultationMedical.builder()
                .code(consultationMedicalDs.getCode())
                .actif(consultationMedicalDs.getActif())
                .dateConsultation(consultationMedicalDs.getDateConsultation())
                .bilanParaclinique(bilanParacliniqueAssembler.assembleAntecedentFromDs(consultationMedicalDs.getBilanParacliniqueDs()))
                .examenAppareil(examenAppareilAssembler.assembleAntecedentFromDs(consultationMedicalDs.getExamenAppareilDs()))
                .elementExamenDermatologiques(referentielAssembler.createSetElementExamenDermatologique(consultationMedicalDs.getElementExamenDermatologiques()))
                .constancePhysique(constancePhysiqueAssembler.assembleConstancePhysiqueFromDs(consultationMedicalDs.getConstancePhysiqueDs()))
                .elementHypotheses(referentielAssembler.createSetElementHypothese(consultationMedicalDs.getElementHypotheses()))
                .elementRechercheNotions(referentielAssembler.createSetElementRechercheNotion(consultationMedicalDs.getElementRechercheNotions()))
                .elementPlaintes(referentielAssembler.createSetElementPlainte(consultationMedicalDs.getElementPlaintes()))
                .elementTerrains(referentielAssembler.createSetElementTerrain(consultationMedicalDs.getElementTerrains()))
                .resumeSyndromique(resumeSyndromiqueAssembler.assembleAntecedentFromDs(consultationMedicalDs.getResumeSyndromiqueDs()))
                .build();
    }

    public ConsultationMedical assembleUpdateEntityFromDs(ConsultationMedical consultationMedical, ConsultationMedicalDs consultationMedicalDs) {
        return ConsultationMedical.builder()
                .code(consultationMedicalDs.getCode())
                .actif(consultationMedicalDs.getActif())
                .dateConsultation(consultationMedicalDs.getDateConsultation())
                .bilanParaclinique(bilanParacliniqueAssembler.assembleAntecedentFromDs(consultationMedicalDs.getBilanParacliniqueDs()))
                .examenAppareil(examenAppareilAssembler.assembleAntecedentFromDs(consultationMedicalDs.getExamenAppareilDs()))
                .elementExamenDermatologiques(referentielAssembler.createSetElementExamenDermatologique(consultationMedicalDs.getElementExamenDermatologiques()))
                .elementHypotheses(referentielAssembler.createSetElementHypothese(consultationMedicalDs.getElementHypotheses()))
                .elementRechercheNotions(referentielAssembler.createSetElementRechercheNotion(consultationMedicalDs.getElementRechercheNotions()))
                .elementPlaintes(referentielAssembler.createSetElementPlainte(consultationMedicalDs.getElementPlaintes()))
                .elementTerrains(referentielAssembler.createSetElementTerrain(consultationMedicalDs.getElementTerrains()))
                .constancePhysique(constancePhysiqueAssembler.assembleConstancePhysiqueFromDs(consultationMedicalDs.getConstancePhysiqueDs()))
                .resumeSyndromique(resumeSyndromiqueAssembler.assembleAntecedentFromDs(consultationMedicalDs.getResumeSyndromiqueDs()))
                .build();
    }

    public ConsultationMedicalDetailsDs assembleFromEntityToDetailsDs(ConsultationMedical consultationMedical) {
        ConsultationMedicalDetailsDs detailsDs = new ConsultationMedicalDetailsDs();
        Patient foundPatientbyCode = patientService.findByCode(consultationMedical.getCode());
        String patient = foundPatientbyCode.getPrenom() + " " + foundPatientbyCode.getNom();
        Utilisateur foundUser = utilisateurService.findUtilisateurByMatricule(consultationMedical.getCreatedByUser());
        String user = foundUser.getPrenom() + " " + foundUser.getNom();
        return ConsultationMedicalDetailsDs.builder()
                .id(consultationMedical.getId())
                .typePatient(consultationMedical.getTypePatient())
                .nomCompletPatient(patient)
                .civilitePatient(foundPatientbyCode.getCivilite())
                .telephone(foundPatientbyCode.getNumeroTelephone())
                .indexPatient(foundPatientbyCode.getCode())
                .age(foundPatientbyCode.getAge())
                .situationMatrimonial(foundPatientbyCode.getSituationMatrimonial())
                .nomCompletAgent(user)
                .numeroConsultation(createNumeroConsultation(consultationMedical.getNumeroConsultation()))
                .actif(consultationMedical.getActif())
                .dateConsultation(consultationMedical.getDateConsultation())
                .bilanParacliniqueDs(bilanParacliniqueAssembler.assembleFromEntityToDs(consultationMedical.getBilanParaclinique()))
                .examenAppareilDs(examenAppareilAssembler.assembleFromEntityToDs(consultationMedical.getExamenAppareil()))
                .elementExamenDermatologiques(referentielAssembler.createListeElementExamenDermatologiqueDs(consultationMedical.getElementExamenDermatologiques()))
                .elementHypotheses(referentielAssembler.createListElementHypotheseDs(consultationMedical.getElementHypotheses()))
                .elementRechercheNotions(referentielAssembler.createListeElementRechercheNotionDs(consultationMedical.getElementRechercheNotions()))
                .elementPlaintes(referentielAssembler.createListeElementPlainteDs(consultationMedical.getElementPlaintes()))
                .elementTerrains(referentielAssembler.createListeElementTerrainDs(consultationMedical.getElementTerrains()))
                .constancePhysiqueDs(constancePhysiqueAssembler.assembleConstancePhysiqueDsFromEntity(consultationMedical.getConstancePhysique()))
                .resumeSyndromiqueDs(resumeSyndromiqueAssembler.assembleFromEntityToDs(consultationMedical.getResumeSyndromique()))
                .build();
    }
}
