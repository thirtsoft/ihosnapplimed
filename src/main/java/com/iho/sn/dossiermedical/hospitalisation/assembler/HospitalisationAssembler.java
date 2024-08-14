package com.iho.sn.dossiermedical.hospitalisation.assembler;


import com.iho.sn.admin.assembler.UtilisateurAssembler;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.hospitalisation.entity.Hospitalisation;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDetailDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationListDs;
import com.iho.sn.dossiermedical.hospitalisation.service.HospitalisationService;
import com.iho.sn.dossiermedical.patient.PatientAssembler;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.iho.sn.utils.UtilString.createNumeroHospitalisation;

@Component
@RequiredArgsConstructor
public class HospitalisationAssembler {

    private final ObservationCliniqueAssembler observationCliniqueAssembler;
    private final ExamenComplementaireAssembler examenComplementaireAssembler;
    private final TraitementMedicalAssembler traitementMedicalAssembler;
    private final SyntheseAssembler syntheseAssembler;
    private final PatientAssembler patientAssembler;
    private final PatientService patientService;
    private final UtilisateurService utilisateurService;
    private final UtilisateurAssembler utilisateurAssembler;
    private final DiscussionAssembler discussionAssembler;
    private final HospitalisationService hospitalisationService;

    public List<HospitalisationListDs> assembleEntitiesFrom(List<Hospitalisation> hospitalisationList) {
        return hospitalisationList.stream().map(this::assembleEntityToListDs).toList();
    }

    public List<HospitalisationDetailDs> assembleHospitalisationsDetailsFromEntity(List<Hospitalisation> hospitalisationList) {
        return hospitalisationList.stream().map(this::assembleHospitalisationDetailDsFromHospitalisation).toList();
    }

    public HospitalisationListDs assembleEntityToListDs(Hospitalisation hospitalisation) {
        HospitalisationListDs hospitalisationListDs = new HospitalisationListDs();
        if (hospitalisation.getId() != null)
            hospitalisationListDs.setId(hospitalisation.getId());
        hospitalisationListDs.setNumeroHospitalisation(createNumeroHospitalisation(hospitalisation.getNumeroHospitalisation())
        );
        if (hospitalisation.getCode() != null) {
            Patient patient = patientService.findByCode(hospitalisation.getCode());
            String nomPatient = patient.getPrenom() + ' ' + patient.getNom();
            hospitalisationListDs.setNomCompletPatient(nomPatient);
        }
        if (hospitalisation.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(hospitalisation.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            hospitalisationListDs.setNomCompletMedecin(nomAgent);
        }
        return hospitalisationListDs;
    }

    public HospitalisationDs assembleEntityToDs(Hospitalisation hospitalisation) {
        HospitalisationDs hospitalisationDs = new HospitalisationDs();
        if (hospitalisation.getId() != null)
            hospitalisationDs.setId(hospitalisation.getId());
        hospitalisationDs.setCode(hospitalisation.getCode());
        hospitalisationDs.setNumeroHospitalisation(
                createNumeroHospitalisation(hospitalisation.getNumeroHospitalisation()));
        if (hospitalisation.getObservationClinique() != null)
            hospitalisationDs.setObservationCliniqueDs(observationCliniqueAssembler.assembleEntityToDs(
                    hospitalisation.getObservationClinique()));
        if (hospitalisation.getExamenComplementaire() != null)
            hospitalisationDs.setExamenComplementaireDs(examenComplementaireAssembler
                    .assembleEntityToDs(hospitalisation.getExamenComplementaire()));
        if (hospitalisation.getTraitementMedical() != null)
            hospitalisationDs.setTraitementMedicalDs(traitementMedicalAssembler
                    .assembleEntityToDs(hospitalisation.getTraitementMedical()));
        if (hospitalisation.getSynthese() != null)
            hospitalisationDs.setSyntheseDs(syntheseAssembler
                    .assembleEntityToDs(hospitalisation.getSynthese()));
        if (hospitalisation.getDiscussion() != null)
            hospitalisationDs.setDiscussionDs(discussionAssembler.assembleEntityToDs(hospitalisation.getDiscussion()));
        return hospitalisationDs;
    }

    public Hospitalisation assembleDsToEntity(HospitalisationDs hospitalisationDs) {
        Hospitalisation hospitalisation = new Hospitalisation();
        if (hospitalisationDs.getId() != null)
            hospitalisation.setId(hospitalisationDs.getId());
        hospitalisation.setCode(hospitalisationDs.getCode());
        if (hospitalisationDs.getObservationCliniqueDs() != null)
            hospitalisation.setObservationClinique(observationCliniqueAssembler.assembleObservationCliniqueFromDs(hospitalisationDs.getObservationCliniqueDs()));
        if (hospitalisationDs.getExamenComplementaireDs() != null)
            hospitalisation.setExamenComplementaire(examenComplementaireAssembler.assembleExamenComplementaireFromDs(hospitalisationDs.getExamenComplementaireDs()));
        if (hospitalisationDs.getTraitementMedicalDs() != null)
            hospitalisation.setTraitementMedical(traitementMedicalAssembler.assembleTraitementMedicalFromDs(hospitalisationDs.getTraitementMedicalDs()));
        if (hospitalisationDs.getSyntheseDs() != null)
            hospitalisation.setSynthese(syntheseAssembler.assembleSyntheseFromDs(hospitalisationDs.getSyntheseDs()));
        if (hospitalisationDs.getDiscussionDs() != null)
            hospitalisation.setDiscussion(discussionAssembler.assembleDiscussionFromDs(hospitalisationDs.getDiscussionDs()));
        return hospitalisation;
    }


    public Hospitalisation assembleUpdateHospitalisation(HospitalisationDs hospitalisationDs) {
        Hospitalisation hospitalisation = hospitalisationService.findById(hospitalisationDs.getId());

        if (hospitalisationDs.getObservationCliniqueDs() != null)
            hospitalisation.setObservationClinique(observationCliniqueAssembler.
                    assembleUpdateObservationCliniqueFromDs
                            (hospitalisation.getObservationClinique(), hospitalisationDs.getObservationCliniqueDs()));

        if (hospitalisationDs.getExamenComplementaireDs() != null)
            hospitalisation.setExamenComplementaire(examenComplementaireAssembler
                    .assembleUpdateExamenComplementaireFromDs(hospitalisation.getExamenComplementaire(), hospitalisationDs.getExamenComplementaireDs()));

        if (hospitalisationDs.getTraitementMedicalDs() != null)
            hospitalisation.setTraitementMedical(traitementMedicalAssembler
                    .assembleUpdateTraitementMedicalFromDs(hospitalisation.getTraitementMedical(), hospitalisationDs.getTraitementMedicalDs()));

        if (hospitalisationDs.getSyntheseDs() != null)
            hospitalisation.setSynthese(syntheseAssembler
                    .assembleUpdateSyntheseFromDs(hospitalisation.getSynthese(), hospitalisationDs.getSyntheseDs()));
        if (hospitalisationDs.getDiscussionDs() != null)
            hospitalisation.setDiscussion(discussionAssembler
                    .assembleUpdateDiscussionFromDs(hospitalisation.getDiscussion(), hospitalisationDs.getDiscussionDs()));
        return hospitalisation;
    }


    public HospitalisationDetailDs assembleHospitalisationDetailDsFromHospitalisation(Hospitalisation hospitalisation) {
        if (hospitalisation == null)
            return null;
        HospitalisationDetailDs hospitalisationDetailDs = new HospitalisationDetailDs();
        if (hospitalisation.getId() != null)
            hospitalisationDetailDs.setId(hospitalisation.getId());
        if (hospitalisation.getObservationClinique() != null)
            hospitalisationDetailDs.setObservationCliniqueDs(observationCliniqueAssembler.assembleEntityToDs(hospitalisation.getObservationClinique()));
        if (hospitalisation.getExamenComplementaire() != null)
            hospitalisationDetailDs.setExamenComplementaireDs(examenComplementaireAssembler.assembleEntityToDs(hospitalisation.getExamenComplementaire()));
        if (hospitalisation.getTraitementMedical() != null)
            hospitalisationDetailDs.setTraitementMedicalDs(traitementMedicalAssembler.assembleEntityToDs(hospitalisation.getTraitementMedical()));
        if (hospitalisation.getSynthese() != null)
            hospitalisationDetailDs.setSyntheseDs(syntheseAssembler.assembleEntityToDs(hospitalisation.getSynthese()));
        if (hospitalisation.getDiscussion() != null)
            hospitalisationDetailDs.setDiscussionDs(discussionAssembler.assembleEntityToDs(hospitalisation.getDiscussion()));
        hospitalisationDetailDs.setNumeroHospitalisation(
                createNumeroHospitalisation(hospitalisation.getNumeroHospitalisation())
        );
        if (hospitalisation.getCode() != null) {
            Patient patient = patientService.findByCode(hospitalisation.getCode());
            PatientDetailDs patientDetailDs = patientAssembler.assemblePatientDetails(patient);
            hospitalisationDetailDs.setPatientDetailDs(patientDetailDs);
        }
        if (hospitalisation.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(hospitalisation.getCreatedByUser());
            UtilisateurDs utilisateurDs = utilisateurAssembler.assembleUtilisateurDsFromEntity(utilisateur);
            hospitalisationDetailDs.setUtilisateurDs(utilisateurDs);
            hospitalisationDetailDs.setNomCompletMedecin(utilisateur.getPrenom() + ' ' + utilisateur.getNom());
        }

        return hospitalisationDetailDs;
    }

/*    public List<AllCircuitPatientDs> assembleAllCircuitPatientEntitiesFrom(List<Hospitalisation> hospitalisationList) {
        return hospitalisationList.stream().map(this::assembleAllCircuitPatientDsFromEntity).toList();
    }

    public AllCircuitPatientDs assembleAllCircuitPatientDsFromEntity(Hospitalisation hospitalisation) {
        AllCircuitPatientDs allCircuitPatientDs = new AllCircuitPatientDs();
        if (hospitalisation.getId() != null)
            allCircuitPatientDs.setId(hospitalisation.getId());
        allCircuitPatientDs.setActif(hospitalisation.isActif());
        allCircuitPatientDs.setNumeroCircuit(UtilString.createNumeroCircuitPatient(
                hospitalisation.getNumeroHospitalisation()));
        allCircuitPatientDs.setCreateDate(hospitalisation.getCreatedDate());
        allCircuitPatientDs.setType("Hospitalisation");
        if (hospitalisation.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(hospitalisation.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            allCircuitPatientDs.setNomCompletAgent(nomAgent);
        }
        return allCircuitPatientDs;
    }*/
}