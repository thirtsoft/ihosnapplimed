package com.iho.sn.dossiermedical.patient.remote.controller;

import com.iho.sn.dossiermedical.patient.PatientAssembler;
import com.iho.sn.dossiermedical.patient.entity.Patient;
import com.iho.sn.dossiermedical.patient.remote.controller.api.PatientApi;
import com.iho.sn.dossiermedical.patient.remote.model.PatientAddDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientListDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientUpdateByMedecinDs;
import com.iho.sn.dossiermedical.patient.remote.model.ResponsePatientDs;
import com.iho.sn.dossiermedical.patient.service.PatientService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController implements PatientApi {

    private final PatientService patientService;

    private final PatientAssembler patientAssembler;

    @Override
    public ResponsePatientDs creerPatient(PatientAddDs patientAddDs) {
        try {
            Patient savedPatient = patientService.savePatient(patientAssembler.assemblePatientFromPatientAddDs(patientAddDs));
            PatientListDs patientMinDs = patientAssembler.assemblePatientListDsFrom(savedPatient);
            return new ResponsePatientDs("OK", "", patientMinDs);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponsePatientDs("FAILED", e.getMessage(), null);
        }
    }

    @Override
    public ResponseEntity<PatientListDs> creerDossierPatient(PatientListDs patientDetailDs) throws Exception {
        return null;
    }

    @Override
    public void updatePatientByMedecin(Long id, PatientUpdateByMedecinDs patientUpdateDs) throws Exception {
        Patient patientModifier = patientAssembler.assembleUpdatePatientByMedecin(patientUpdateDs);
        patientService.updatePatientByMedeccin(id, patientModifier);
    }

    @Override
    public ResponseEntity<PatientListDs> updatePatientByAdministration(Long id, PatientAddDs patientDetailDs) throws Exception {
        Patient patientAjouter = patientAssembler.assembleUpdatePatientFromDs(patientDetailDs);
        return new ResponseEntity<>(patientAssembler.assemblePatientListDsFrom(patientService.updatePatient(id, patientAjouter)), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<PatientDetailDs> findById(Long id) {
        PatientDetailDs patientResult = patientAssembler.assemblePatientDetails(patientService.findById(id));
        return new ResponseEntity<>(patientResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientDetailDs> findPatientByIndex(String index) {
        PatientDetailDs patientResult = patientAssembler.assemblePatientDetails(patientService.findByCode(index));
        return new ResponseEntity<>(patientResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PatientListDs>> findAllPatients() {
        List<PatientListDs> patientResult = patientAssembler.assembleEntitiesFrom(patientService.findAllPatients());
        return new ResponseEntity<>(patientResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PatientListDs>> findAllPatients(Integer pageNumber, Integer pageSize) {
        List<PatientListDs> patientResult = patientAssembler.assembleEntitiesFrom(patientService.findAllPatients());
        return new ResponseEntity<>(patientResult, HttpStatus.OK);
    }

    @Override
    public void deletePatient(Long id) {
        patientService.deletePatient(id);
    }

    @Override
    public ResponseEntity<InputStreamResource> exportPatients() {
        return null;
    }

    @Override
    public void exportPatientsToPDF(HttpServletResponse response) throws IOException {

    }

    @Override
    public ResponseEntity<List<PatientListDs>> findAllPatientOrderByFirstName() {
        List<PatientListDs> patientResult = patientAssembler.assembleEntitiesFrom(patientService.findAllActivesPatients());
        return new ResponseEntity<>(patientResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InputStreamResource> exportDossierPatient() {
        return null;
    }

    @Override
    public ResponseEntity<InputStreamResource> exportPatientComplete() {
        return null;
    }

    @Override
    public long countNumberOfPatient() {
        return patientService.countNumberOfPatient();
    }

    @Override
    public long countNumberPassageOfPatient(String code) {
        return patientService.countNumberPassagePatient(code);
    }

    @Override
    public long countNumberConsultationMedicalByPatient(String code) {
        return patientService.countNumberConsultationMedicalByPatient(code);
    }

    @Override
    public long countNumberHospitalisationByPatient(String code) {
        return patientService.countNumberHospitalisationByPatient(code);
    }
}
