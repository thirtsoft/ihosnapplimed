package com.iho.sn.dossiermedical.patient.service;

import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.exception.PatientException;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient) throws PatientException;

    Patient updatePatient(Long id, Patient patient) throws PatientException;

    void updatePatientByMedeccin(Long id, Patient patient) throws PatientException;

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
