package com.iho.sn.dossiermedical.patient.remote.controller.api;

import com.iho.sn.dossiermedical.patient.remote.model.PatientAddDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientDetailDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientListDs;
import com.iho.sn.dossiermedical.patient.remote.model.PatientUpdateByMedecinDs;
import com.iho.sn.dossiermedical.patient.remote.model.ResponsePatientDs;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

import static com.iho.sn.utils.ApiUrlAccess.APP_ROOT;

@RequestMapping(value = "/patient")
public interface PatientApi {

    @PostMapping(value = "/save")
    @ResponseBody
    ResponsePatientDs creerPatient(@RequestBody PatientAddDs patientAddDs);

    @PostMapping(value = "/generated-dossier-patient")
    ResponseEntity<PatientListDs> creerDossierPatient(@RequestBody PatientListDs patientDetailDs) throws Exception;

    @PutMapping(value = "/edit/{id}")
    void updatePatientByMedecin(@PathVariable Long id, @RequestBody PatientUpdateByMedecinDs patientUpdateDs) throws Exception;

    @PutMapping(value = "/edit/by-administration/{id}")
    ResponseEntity<PatientListDs> updatePatientByAdministration(@PathVariable Long id, @RequestBody PatientAddDs patientDetailDs) throws Exception;

    @GetMapping(value = "/{id}")
    ResponseEntity<PatientDetailDs> findById(@PathVariable Long id);

    @GetMapping(value = "/detail/{index}")
    ResponseEntity<PatientDetailDs> findPatientByIndex(@PathVariable String index);

    @GetMapping(value = "/list")
    ResponseEntity<List<PatientListDs>> findAllPatients();

    @GetMapping(value = "/list/{pageNumber}/{pageSize}")
    ResponseEntity<List<PatientListDs>> findAllPatients(@PathVariable Integer pageNumber, @PathVariable Integer pageSize);

    @DeleteMapping(value = "/delete/{id}")
    void deletePatient(@PathVariable Long id);

    @GetMapping(value = "/export-csv")
    @Transactional(readOnly = true)
    ResponseEntity<InputStreamResource> exportPatients();

    @GetMapping(value = "/export-pdf")
    @Transactional(readOnly = true)
    void exportPatientsToPDF(HttpServletResponse response) throws IOException;

    @GetMapping(value = "/list/order")
    ResponseEntity<List<PatientListDs>> findAllPatientOrderByFirstName();

    @GetMapping(value = "/export-dossier")
    @Transactional(readOnly = true)
    ResponseEntity<InputStreamResource> exportDossierPatient();

    @GetMapping(value = "/export-patients")
    @Transactional(readOnly = true)
    ResponseEntity<InputStreamResource> exportPatientComplete();

    @GetMapping(value = "/count-number-patient")
    long countNumberOfPatient();

    @GetMapping(value = "/count-number-passage-patient/{code}")
    long countNumberPassageOfPatient(@PathVariable String code);

    @GetMapping(value = "/number-consultation-patient/{code}")
    long countNumberConsultationMedicalByPatient(@PathVariable String code);

    @GetMapping(value = "/number-hospitalisation-patient/{code}")
    long countNumberHospitalisationByPatient(@PathVariable String code);

}
