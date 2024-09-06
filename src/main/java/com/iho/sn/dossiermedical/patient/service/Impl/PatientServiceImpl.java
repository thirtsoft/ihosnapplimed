package com.iho.sn.dossiermedical.patient.service.Impl;

import com.iho.sn.dossiermedical.patient.entity.TrancheAge;
import com.iho.sn.dossiermedical.patient.repository.PatientRepositry;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.repository.TrancheAgeRepository;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import com.iho.sn.dossiermedical.patient.exception.PatientException;
import com.iho.sn.utils.MessageException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepositry patientRepositry;
    private final TrancheAgeRepository trancheAgeRepository;

    @Override
    public Patient savePatient(Patient patient) {
        if (patient == null)
            throw new PatientException(MessageException.NULL_OBJECT);
        String code = patient.getCode();
        Optional<Patient> byCode = patientRepositry.findByCode(code);
        if (patient.getId() == null && byCode.isPresent()
                || (patient.getId() != null && byCode.isPresent() && !byCode.get().getId().equals(patient.getId()))) {
            throw new PatientException(String.format("L'index %s est déjà associé à un autre patient.", code));
        }
        String telephone = patient.getNumeroTelephone();
        Optional<Patient> byTelephone = patientRepositry.findByNumeroTelephone(telephone);
        if (patient.getId() == null && byTelephone.isPresent()
                || (patient.getId() != null && byTelephone.isPresent() && !byTelephone.get().getId().equals(patient.getId()))) {
            throw new PatientException(String.format("Le numéro téléphone %s est déjà associé à un autre patient.", telephone));
        }
        patient.setActif(true);
        patient.setDateAdmission(new Date());
        Patient savePatient = patientRepositry.save(patient);
        if (savePatient.getAge()>=0 && savePatient.getAge()<14) {
            TrancheAge trancheAge = new TrancheAge();
            trancheAge.setCode("ENF");
            trancheAge.setLibelle("Enfant");
            trancheAgeRepository.save(trancheAge);
        }else if (savePatient.getAge()>=14 && savePatient.getAge()<18) {
            TrancheAge trancheAge = new TrancheAge();
            trancheAge.setCode("ADO");
            trancheAge.setLibelle("Adolescent");
            trancheAgeRepository.save(trancheAge);
        }else if (savePatient.getAge()>=18 && savePatient.getAge()<45) {
            TrancheAge trancheAge = new TrancheAge();
            trancheAge.setCode("ADLT");
            trancheAge.setLibelle("Adulte");
            trancheAgeRepository.save(trancheAge);
        } else {
            TrancheAge trancheAge = new TrancheAge();
            trancheAge.setCode("PAR");
            trancheAge.setLibelle("Parent");
            trancheAgeRepository.save(trancheAge);
        }
        return savePatient;
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        if (!patientRepositry.existsById(id)) {
            throw new PatientException("Le patient n'existe pas");
        }
        Patient patientResult = patientRepositry.findPatientById(id);
        if (patientResult == null) {
            throw new PatientException("Le patient n'existe pas");
        }
        patientResult.setPrenom(patient.getPrenom());
        patientResult.setNom(patient.getNom());
        patientResult.setAddress(patient.getAddress());
        patientResult.setSexe(patient.getSexe());
        patientResult.setNumeroTelephone(patient.getNumeroTelephone());
        patientResult.setCivilite(patient.getCivilite());
        patientResult.setDateNaissance(patient.getDateNaissance());
        patientResult.setAge(patient.getAge());
        patientResult.setNationalite(patient.getNationalite());
        patientResult.setProfession(patient.getProfession());
        patientResult.setSituationMatrimonial(patient.getSituationMatrimonial());
        patientResult.setPersonneConfiance(patient.getPersonneConfiance());
        return patientRepositry.save(patientResult);
    }

    @Override
    public void updatePatientByMedeccin(Long id, Patient patient) {
        if (!patientRepositry.existsById(id)) {
            throw new PatientException("Ce patient n'existe pas");
        }
        Patient patientResult = patientRepositry.findPatientById(id);
        if (patientResult == null) {
            throw new PatientException("Ce patient n'existe pas");
        }
        patientResult.setPrenom(patient.getPrenom());
        patientResult.setNom(patient.getNom());
        patientResult.setSexe(patient.getSexe());
        patientResult.setCivilite(patient.getCivilite());
        patientResult.setProfession(patient.getProfession());
        patientResult.setSituationMatrimonial(patient.getSituationMatrimonial());
        patientResult.setRace(patient.getRace());
        patientResult.setEthnie(patient.getEthnie());
        patientResult.setOrigine(patient.getOrigine());
        patientResult.setOrigineMere(patient.getOrigineMere());
        patientResult.setOriginePere(patient.getOriginePere());
        patientResult.setPrototype(patient.getPrototype());
        patientResult.setConsanguinite(patient.getConsanguinite());
        patientResult.setNiveauSocialEconomique(patient.getNiveauSocialEconomique());
        patientResult.setRegimeAlimentaire(patient.getRegimeAlimentaire());
        patientRepositry.save(patientResult);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepositry.findPatientById(id);
    }

    @Override
    public Patient findByCode(String code) {
        return patientRepositry.findPatientByCode(code);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepositry.findAllPatients();
    }

    @Override
    public void deletePatient(Long id) {
Patient patient = findById(id);
patient.setActif(false);
patientRepositry.save(patient);
    }

    @Override
    public List<Patient> findAllActivesPatients() {
        return patientRepositry.findAllPatientOrderByFirstName();
    }

    @Override
    public long countNumberOfPatient() {
        return patientRepositry.countActivePatient();
    }

    @Override
    public long countNumberPassagePatient(String code) {
        return 0;
    }

    @Override
    public long countNumberConsultationMedicalByPatient(String code) {
        return 0;
    }

    @Override
    public long countNumberHospitalisationByPatient(String code) {
        return 0;
    }
}
