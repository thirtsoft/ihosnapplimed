package com.iho.sn.dossiermedical.consultation.remote.controller.api;


import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalDetailsDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalListeDs;
import com.iho.sn.dossiermedical.consultation.remote.model.ConsultationMedicalSearchDs;
import com.iho.sn.message.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "/consultation")
public interface ConsultationMedicalApi {

    @PostMapping(value = "/save")
    @ResponseBody
    ResponseMessage creerConsultationMedical(@RequestBody ConsultationMedicalDs consultationMedicalDs);

    @PutMapping(value = "/edit/{id}")
    @ResponseBody
    ResponseMessage updateConsultationMedical(@PathVariable Long id, @RequestBody ConsultationMedicalDs consultationMedicalDs);

    @GetMapping(value = "/{id}")
    ResponseEntity<ConsultationMedicalDetailsDs> findById(@PathVariable Long id);

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ConsultationMedicalListeDs>> findAllConsultationMedicals();

    @PostMapping(value = "/searchBy", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ConsultationMedicalListeDs>> findByCriteria(@RequestBody ConsultationMedicalSearchDs searchDs);

    @GetMapping(value = "/detail/patient/{code}")
    ResponseEntity<List<ConsultationMedicalDetailsDs>> getConsultationMedicalsDetailsByPatient(@PathVariable("code") String code);

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseMessage deleteConsultationMedical(@PathVariable Long id);


    @GetMapping(value = "nombrehomme")
    int countConsultationMedicalHomme();

    @GetMapping(value = "nombrefemme")
    int countConsultationMedicalFemme();

    @GetMapping(value = "nombreconsultationmedical")
    long countConsultationMedical();
}
