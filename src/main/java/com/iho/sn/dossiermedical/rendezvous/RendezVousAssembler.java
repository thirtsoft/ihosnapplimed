package com.iho.sn.dossiermedical.rendezvous;

import com.iho.sn.admin.assembler.UtilisateurAssembler;
import com.iho.sn.admin.entities.Utilisateur;
import com.iho.sn.admin.remote.model.UtilisateurDs;
import com.iho.sn.admin.service.UtilisateurService;
import com.iho.sn.dossiermedical.patient.PatientAssembler;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import com.iho.sn.dossiermedical.rendezvous.entity.RendezVous;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezVousDeplaceDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezVousDetailsDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezvousDs;
import com.iho.sn.dossiermedical.rendezvous.remote.model.RendezvousListeDs;
import com.iho.sn.dossiermedical.rendezvous.service.RendezVousService;
import com.iho.sn.utils.ConstantSigps;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RendezVousAssembler {
    private final PatientService patientService;
    private final PatientAssembler patientAssembler;
    private final UtilisateurService utilisateurService;
    private final UtilisateurAssembler utilisateurAssembler;
    private final RendezVousService rendezVousService;

    public RendezVousAssembler(PatientService patientService,
                               PatientAssembler patientAssembler,
                               UtilisateurService utilisateurService,
                               UtilisateurAssembler utilisateurAssembler,
                               RendezVousService rendezVousService) {
        this.patientService = patientService;
        this.patientAssembler = patientAssembler;
        this.utilisateurService = utilisateurService;
        this.utilisateurAssembler = utilisateurAssembler;
        this.rendezVousService = rendezVousService;
    }

    public List<RendezVousDetailsDs> assembleEntitiesFrom(List<RendezVous> rendezVous) {
        return rendezVous.stream().map(this::assembleEntitiesToDs).toList();
    }

    public RendezvousDs assembleEntityToDs(RendezVous rendezVous) {
        RendezvousDs rendezVousDs = new RendezvousDs();
        rendezVousDs.setId(rendezVous.getId());
        rendezVousDs.setLibelle(rendezVous.getLibelle());
        rendezVousDs.setPatientId(rendezVous.getPatientId());
        rendezVousDs.setMedecinId(rendezVous.getMedecinId());
        rendezVousDs.setEtat(rendezVous.getEtat());
        rendezVousDs.setDateRendezVous(rendezVous.getDateRendezVous());
        rendezVousDs.setHeure(rendezVous.getHeure());
        rendezVousDs.setCreateDate(rendezVous.getCreateDate());
        rendezVousDs.setActif(rendezVous.isActif());
        return rendezVousDs;
    }

    public RendezvousListeDs assembleRendezVousListeDsFromRendezVous(RendezVous rendezVous) {
        RendezvousListeDs rendezVousDs = new RendezvousListeDs();
        rendezVousDs.setId(rendezVous.getId());
        rendezVousDs.setLibelle(rendezVous.getLibelle());
        rendezVousDs.setEtat(rendezVous.getEtat());
        rendezVousDs.setDateRendezVous(rendezVous.getDateRendezVous());
        rendezVousDs.setHeure(rendezVous.getHeure());
        rendezVousDs.setCreateDate(rendezVous.getCreateDate());
        rendezVousDs.setActif(rendezVous.isActif());
        if (rendezVous.getMedecinId() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurById(rendezVous.getMedecinId());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            rendezVousDs.setNomCompletMedecin(nomAgent);
        }
        if (rendezVous.getPatientId() != null) {
            Patient patient = patientService.findById(rendezVous.getPatientId());
            String nomPatient = patient.getPrenom() + ' ' + patient.getNom();
            rendezVousDs.setNomCompletPatient(nomPatient);
        }
        return rendezVousDs;
    }

    public List<RendezvousListeDs> assembleListeRendezvousListeFromEntities(List<RendezVous> rendezVous) {
        return rendezVous.stream().map(this::assembleRendezVousListeDsFromRendezVous).toList();
    }

    public RendezVous assembleRendezVoRendezVoususFromDs(RendezvousDs rendezVousDs) {
        RendezVous rendezVous = new RendezVous();
        if (rendezVousDs.getId() != null)
            rendezVous.setId(rendezVousDs.getId());
        rendezVous.setPatientId(rendezVousDs.getPatientId());
        rendezVous.setLibelle(rendezVousDs.getLibelle());
        rendezVous.setMedecinId(rendezVousDs.getMedecinId());
        rendezVous.setDateRendezVous(rendezVousDs.getDateRendezVous());
        rendezVous.setHeure(rendezVousDs.getHeure());
        rendezVous.setCreateDate(rendezVousDs.getCreateDate());
        rendezVous.setActif(rendezVousDs.isActif());
        return rendezVous;
    }

    public RendezVous assembleUpdateRendezVousFromDs(RendezvousDs rendezVousDs) {
        RendezVous rendezVous = rendezVousService.findById(rendezVousDs.getId());
        rendezVous.setPatientId(rendezVousDs.getPatientId());
        rendezVous.setLibelle(rendezVousDs.getLibelle());
        rendezVous.setMedecinId(rendezVousDs.getMedecinId());
        rendezVous.setDateRendezVous(rendezVousDs.getDateRendezVous());
        rendezVous.setHeure(rendezVousDs.getHeure());
        return rendezVous;
    }

    public RendezVousDetailsDs assembleEntitiesToDs(RendezVous rendezVous) {
        RendezVousDetailsDs rendezVousDs = new RendezVousDetailsDs();
        if (rendezVous.getId() != null)
            rendezVousDs.setId(rendezVous.getId());
        rendezVousDs.setLibelle(rendezVous.getLibelle());
        rendezVousDs.setDateRendezVous(rendezVous.getDateRendezVous());
        rendezVousDs.setHeure(rendezVous.getHeure());
        rendezVousDs.setCreateDate(rendezVous.getCreateDate());
        rendezVousDs.setActif(rendezVous.isActif());
        rendezVousDs.setPatientId(rendezVous.getPatientId());
        rendezVousDs.setMedecinId(rendezVous.getMedecinId());
        if (rendezVous.getPatientId() != null) {
            Patient patient = patientService.findById(rendezVous.getPatientId());
            String nomPatient = patient.getPrenom() + ' ' + patient.getNom();
            PatientDetailDs patientDetailDs = patientAssembler.assemblePatientDetails(patient);
            rendezVousDs.setPatient(patientDetailDs);
            rendezVousDs.setNomCompletPatient(nomPatient);
        }
        if (rendezVous.getCreatedByUser() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurByMatricule(rendezVous.getCreatedByUser());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            rendezVousDs.setNomCompletAgent(nomAgent);
        }
        if (rendezVous.getMedecinId() != null) {
            Utilisateur utilisateur = utilisateurService.findUtilisateurById(rendezVous.getMedecinId());
            String nomAgent = utilisateur.getPrenom() + ' ' + utilisateur.getNom();
            UtilisateurDs utilisateurDs = utilisateurAssembler.assembleUtilisateurDsFromEntity(utilisateur);
            rendezVousDs.setUtilisateurDs(utilisateurDs);
            rendezVousDs.setNomCompletAgent(nomAgent);
        }
        rendezVousDs.setEtat(rendezVous.getEtat());
        rendezVousDs.setLibelleEtat(getLibelleEtat(rendezVous.getEtat()));
        return rendezVousDs;
    }

    public RendezVous assembleEntitiesToDeplaceRendezVous(RendezVousDeplaceDs rendezVousDeplaceDs) {
        RendezVous rendezVous = null;
        List<RendezVousDetailsDs> rendezVousDetailDsList = rendezVousDeplaceDs.getRendezVousDetailDs();
        for (RendezVousDetailsDs rendezVousDetailDs : rendezVousDetailDsList) {
            rendezVous = rendezVousService.findById(rendezVousDetailDs.getId());
            rendezVous.setDateRendezVous(rendezVousDeplaceDs.getDateDeplace());
            rendezVous.setHeure(rendezVousDeplaceDs.getHeure());
        }
        return rendezVous;

    }

    public String getLibelleEtat(int etat) {
        if (etat == ConstantSigps.ETAT_PROGRAMME)
            return "PROGRAMME";
        else if (etat == ConstantSigps.ETAT_ACCEPTE)
            return "ACCEPTE";
        else if (etat == ConstantSigps.ETAT_EVAL_PATIENT)
            return "EVALUATION";
        else if (etat == ConstantSigps.ETAT_REJETE)
            return "REJETE";
        return "";
    }
}
