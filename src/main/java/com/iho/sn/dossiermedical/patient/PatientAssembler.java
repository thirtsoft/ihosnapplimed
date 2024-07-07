package com.iho.sn.dossiermedical.patient;

import com.iho.sn.dossiermedical.patient.entity.Diagnostic;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.entity.PersonneConfiance;
import com.iho.sn.dossiermedical.patient.remote.model.DiagnosticDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientAddDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientListDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientUpdateByMedecinDs;
import com.iho.sn.dossiermedical.patient.remote.model.PersonneConfianceDs;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class PatientAssembler {

    private final PatientService patientService;

    public List<PatientListDs> assembleEntitiesFrom(List<Patient> patients) {
        return patients.stream().map(this::assemblePatientListDsFrom).toList();
    }

    public PatientAddDs assemblePatientAddDsFromPatient(Patient patient) {
        PatientAddDs patientAddDs = new PatientAddDs();
        patientAddDs.setCode(patient.getCode());
        patientAddDs.setNom(patient.getNom());
        patientAddDs.setPrenom(patient.getPrenom());
        patientAddDs.setSexe(patient.getSexe());
        patientAddDs.setCivilite(patient.getCivilite());
        patientAddDs.setAddress(patient.getAddress());
        patientAddDs.setDateNaissance(patient.getDateNaissance());
        patientAddDs.setAge(patient.getAge());
        patientAddDs.setNumeroTelephone(patient.getNumeroTelephone());
        patientAddDs.setProfession(patient.getProfession());
        patientAddDs.setSituationMatrimonial(patient.getSituationMatrimonial());
        patientAddDs.setDateAdmission(patient.getDateAdmission());
        patientAddDs.setEst_accompagne(patient.isEst_accompagne());
        if (patient.getPersonneConfiance() != null)
            patientAddDs.setPersonneConfianceDs(assembleDsFromEntity(patient.getPersonneConfiance()));
        return patientAddDs;
    }

    public Patient assemblePatientFromPatientAddDs(PatientAddDs patient) {
        Patient patientAddDs = new Patient();
        patientAddDs.setCode(patient.getCode());
        patientAddDs.setNom(patient.getNom());
        patientAddDs.setPrenom(patient.getPrenom());
        patientAddDs.setSexe(patient.getSexe());
        patientAddDs.setCivilite(patient.getCivilite());
        patientAddDs.setAddress(patient.getAddress());
        patientAddDs.setDateNaissance(patient.getDateNaissance());
        patientAddDs.setAge(patient.getAge());
        patientAddDs.setNumeroTelephone(patient.getNumeroTelephone());
        patientAddDs.setProfession(patient.getProfession());
        patientAddDs.setSituationMatrimonial(patient.getSituationMatrimonial());
        patientAddDs.setDateAdmission(patient.getDateAdmission());
        patientAddDs.setEst_accompagne(patient.isEst_accompagne());
        if (patient.getPersonneConfianceDs() != null)
            patientAddDs.setPersonneConfiance(assemblePersonneConfianceFromDs(patient.getPersonneConfianceDs()));
        return patientAddDs;
    }

    public PatientListDs assemblePatientListDsFrom(Patient patient) {
        PatientListDs patientMinDs = new PatientListDs();
        patientMinDs.setId(patient.getId());
        patientMinDs.setNom(patient.getNom());
        patientMinDs.setPrenom(patient.getPrenom());
        patientMinDs.setTelephone(patient.getNumeroTelephone());
        patientMinDs.setDateAdmission(patient.getDateAdmission());
        patientMinDs.setIsCircuitGenerated(patient.getIsCircuitGenerated());
        patientMinDs.setDiagnosticDs(assembleDiagnosticToDs(patient.getDiagnostic()));
        patientMinDs.setNombre_passage(patient.getNombre_passage());
        return patientMinDs;

    }

    public PatientDetailDs assemblePatientDetails(Patient patient) {
        PatientDetailDs patientDetailDs = new PatientDetailDs();
        if (patient.getCode() != null)
            patientDetailDs.setCode(patient.getCode());
        patientDetailDs.setId(patient.getId());
        patientDetailDs.setDateAdmission(patient.getDateAdmission());
        patientDetailDs.setNom(patient.getNom());
        patientDetailDs.setPrenom(patient.getPrenom());
        patientDetailDs.setSexe(patient.getSexe());
        patientDetailDs.setAge(patient.getAge());
        patientDetailDs.setCivilite(patient.getCivilite());
        patientDetailDs.setAddress(patient.getAddress());
        patientDetailDs.setDateNaissance(patient.getDateNaissance());
        patientDetailDs.setNumeroTelephone(patient.getNumeroTelephone());
        patientDetailDs.setProfession(patient.getProfession());
        patientDetailDs.setSituationMatrimonial(patient.getSituationMatrimonial());
        patientDetailDs.setPhoto(patient.getPhoto());
        patientDetailDs.setRace(patient.getRace());
        patientDetailDs.setEthnie(patient.getEthnie());
        patientDetailDs.setOrigine(patient.getOrigine());
        patientDetailDs.setNationalite(patient.getNationalite());
        patientDetailDs.setOriginePere(patient.getOriginePere());
        patientDetailDs.setOrigineMere(patient.getOrigineMere());
        patientDetailDs.setPrototype(patient.getPrototype());
        patientDetailDs.setConsanguinite(patient.getConsanguinite());
        patientDetailDs.setNiveauSocialEconomique(patient.getNiveauSocialEconomique());
        patientDetailDs.setRegimeAlimentaire(patient.getRegimeAlimentaire());
        if (patient.getPersonneConfiance() != null)
            patientDetailDs.setPersonneConfianceDs(assembleDsFromEntity(patient.getPersonneConfiance()));
        patientDetailDs.setIsCircuitGenerated(patient.getIsCircuitGenerated());
        patientDetailDs.setEst_accompagne(patient.isEst_accompagne());
        if (patient.getDiagnostic() != null)
            patientDetailDs.setDiagnosticDs(assembleDiagnosticToDs(patient.getDiagnostic()));
        return patientDetailDs;
    }

    public Patient assemblePatientFromDs(PatientDetailDs patientDetailDs) {
        Patient patient = new Patient();
        patient.setCode(patientDetailDs.getCode());
        patient.setDateAdmission(patientDetailDs.getDateAdmission());
        patient.setNom(patientDetailDs.getNom());
        patient.setPrenom(patientDetailDs.getPrenom());
        patient.setSexe(patientDetailDs.getSexe());
        patient.setAge(patientDetailDs.getAge());
        patient.setCivilite(patientDetailDs.getCivilite());
        patient.setAddress(patientDetailDs.getAddress());
        patient.setDateNaissance(patientDetailDs.getDateNaissance());
        patient.setNumeroTelephone(patientDetailDs.getNumeroTelephone());
        patient.setProfession(patientDetailDs.getProfession());
        patient.setSituationMatrimonial(patientDetailDs.getSituationMatrimonial());
        patient.setPhoto(patientDetailDs.getPhoto());
        patient.setRace(patientDetailDs.getRace());
        patient.setEthnie(patientDetailDs.getEthnie());
        patient.setOrigine(patientDetailDs.getOrigine());
        patient.setNationalite(patientDetailDs.getNationalite());
        patient.setOriginePere(patientDetailDs.getOriginePere());
        patient.setOrigineMere(patientDetailDs.getOrigineMere());
        patient.setPrototype(patientDetailDs.getPrototype());
        patient.setConsanguinite(patientDetailDs.getConsanguinite());
        patient.setNiveauSocialEconomique(patientDetailDs.getNiveauSocialEconomique());
        patient.setRegimeAlimentaire(patientDetailDs.getRegimeAlimentaire());
        if (patientDetailDs.getPersonneConfianceDs() != null)
            patient.setPersonneConfiance(assemblePersonneConfianceFromDs(patientDetailDs.getPersonneConfianceDs()));
        patient.setIsCircuitGenerated(patientDetailDs.getIsCircuitGenerated());
        patient.setEst_accompagne(patientDetailDs.isEst_accompagne());
        if (patientDetailDs.getDiagnosticDs() != null)
            patient.setDiagnostic(assembleDiagnosticFromDiagnosticDs(patientDetailDs.getDiagnosticDs()));
        return patient;
    }

    public Patient assembleUpdatePatientFromDs(PatientAddDs patientDetailDs) {
        Patient patient = patientService.findById(patientDetailDs.getId());
        if (patientDetailDs.getPersonneConfianceDs() != null)
            patient.setPersonneConfiance(assembleUpdatePersonneConfianceFromDs(patient.getPersonneConfiance(), patientDetailDs.getPersonneConfianceDs()));
        patient.setEst_accompagne(patientDetailDs.isEst_accompagne());
        return patient;
    }

    public Patient assembleUpdatePatientByMedecin(PatientUpdateByMedecinDs patientUpdateDs) {
        Patient patient = patientService.findById(patientUpdateDs.getId());
        patient.setPrenom(patientUpdateDs.getPrenom());
        patient.setNom(patientUpdateDs.getNom());
        patient.setSexe(patientUpdateDs.getSexe());
        patient.setCivilite(patientUpdateDs.getCivilite());
        patient.setProfession(patientUpdateDs.getProfession());
        patient.setSituationMatrimonial(patientUpdateDs.getSituationMatrimonial());
        patient.setRace(patientUpdateDs.getRace());
        patient.setEthnie(patientUpdateDs.getEthnie());
        patient.setOrigine(patientUpdateDs.getOrigine());
        patient.setOrigineMere(patientUpdateDs.getOrigineMere());
        patient.setOriginePere(patientUpdateDs.getOriginePere());
        patient.setPrototype(patientUpdateDs.getPrototype());
        patient.setConsanguinite(patientUpdateDs.getConsanguinite());
        patient.setNiveauSocialEconomique(patientUpdateDs.getNiveauSocialEconomique());
        patient.setRegimeAlimentaire(patientUpdateDs.getRegimeAlimentaire());
        if (patientUpdateDs.getDiagnosticDs() != null)
            patient.setDiagnostic(assembleUpdateDiagnosticFromDs(patient.getDiagnostic(), patientUpdateDs.getDiagnosticDs()));
        return patient;
    }

    public PersonneConfianceDs assembleDsFromEntity(PersonneConfiance personneConfiance) {
        PersonneConfianceDs personneConfianceDs = new PersonneConfianceDs();
        if (personneConfiance.getId() != null)
            personneConfianceDs.setId(personneConfiance.getId());
        personneConfianceDs.setNom(personneConfiance.getNom());
        personneConfianceDs.setPrenom(personneConfiance.getPrenom());
        personneConfianceDs.setTelephone(personneConfiance.getTelephone());
        personneConfianceDs.setEmail(personneConfiance.getEmail());
        return personneConfianceDs;
    }

    public PersonneConfiance assemblePersonneConfianceFromDs(PersonneConfianceDs personneConfiance) {
        PersonneConfiance personneConfianceDs = new PersonneConfiance();
        if (personneConfiance.getId() != null)
            personneConfianceDs.setId(personneConfiance.getId());
        personneConfianceDs.setNom(personneConfiance.getNom());
        personneConfianceDs.setPrenom(personneConfiance.getPrenom());
        personneConfianceDs.setTelephone(personneConfiance.getTelephone());
        personneConfianceDs.setEmail(personneConfiance.getEmail());
        return personneConfianceDs;
    }

    public PersonneConfiance assembleUpdatePersonneConfianceFromDs(PersonneConfiance personneConfiance, PersonneConfianceDs personneConfianceDs) {
        personneConfiance.setNom(personneConfianceDs.getNom());
        personneConfiance.setPrenom(personneConfianceDs.getPrenom());
        personneConfiance.setTelephone(personneConfianceDs.getTelephone());
        personneConfiance.setEmail(personneConfianceDs.getEmail());
        return personneConfiance;
    }

    public DiagnosticDs assembleDiagnosticToDs(Diagnostic diagnostic) {
        if (diagnostic == null)
            return null;
        DiagnosticDs diagnosticDs = new DiagnosticDs();
        if (diagnostic.getId() != null)
            diagnosticDs.setId(diagnostic.getId());
        diagnosticDs.setDiagnostic_principal(diagnostic.getDiagnostic_principal());
        diagnosticDs.setDiagnostic_associe(diagnostic.getDiagnostic_associe());
        return diagnosticDs;
    }

    public Diagnostic assembleDiagnosticFromDiagnosticDs(DiagnosticDs diagnostic) {
        if (diagnostic == null)
            return null;
        Diagnostic diagnosticDs = new Diagnostic();
        if (diagnostic.getId() != null)
            diagnosticDs.setId(diagnostic.getId());
        diagnosticDs.setDiagnostic_principal(diagnostic.getDiagnostic_principal());
        diagnosticDs.setDiagnostic_associe(diagnostic.getDiagnostic_associe());
        return diagnosticDs;
    }

    public Diagnostic assembleUpdateDiagnosticFromDs(Diagnostic diagnostic, DiagnosticDs diagnosticDs) {
        diagnostic.setDiagnostic_principal(diagnosticDs.getDiagnostic_principal());
        diagnostic.setDiagnostic_associe(diagnosticDs.getDiagnostic_associe());
        return diagnostic;
    }



}