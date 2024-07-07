package com.iho.sn.dossiermedical.patient.service;

import com.iho.sn.dossiermedical.patient.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient) throws Exception;

    Patient updatePatient(Long id, Patient patient) throws Exception;

    void updatePatientByMedeccin(Long id, Patient patient) throws Exception;

    Patient findById(Long id);

    Patient findByCode(String code);

    List<Patient> findAllPatients();

    void deletePatient(Long id);

    List<Patient> findAllActivesPatients();

    long countNumberOfPatient();

    long countNumberPassagePatient(String code);

    long countNumberConsultationMedicalByPatient(String code);

    long countNumberHospitalisationByPatient(String code);

}
