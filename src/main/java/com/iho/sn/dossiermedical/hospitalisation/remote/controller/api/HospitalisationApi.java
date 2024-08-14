package com.iho.sn.dossiermedical.hospitalisation.remote.controller.api;

import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDetailDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationListDs;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping(value = "/hospitalisation")
public interface HospitalisationApi {

    @PostMapping(value = "/save")
    @ResponseBody
    Long creerHospitalisation(@RequestBody HospitalisationDs hospitalisationDs);

    @PutMapping(value = "/edit/{id}")
    @ResponseBody
    Long updateHospitalisation(@PathVariable Long id, @RequestBody HospitalisationDs hospitalisationDs) throws Exception;

    @GetMapping(value = "/{id}")
    ResponseEntity<HospitalisationDetailDs> findById(@PathVariable Long id);

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<HospitalisationListDs>> findAllHospitalisations();

    @GetMapping(value = "/patient/{code}")
    ResponseEntity<List<HospitalisationListDs>> getHospitalisationListByPatient(@PathVariable("code") String code);

    @GetMapping(value = "/detail/patient/{code}")
    ResponseEntity<List<HospitalisationDetailDs>> getHospitalisationsDetailsByPatient(@PathVariable("code") String code);

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteHospitalisation(@PathVariable Long id);

    @PutMapping("/exam-complementaire/{hospitalisationId}/add-hospitalisation-biologic-file")
    boolean addExamBiologicToHospitalisation(@PathVariable Long hospitalisationId,
                                             @RequestParam(required = false) MultipartFile biologic);

    @PutMapping("/exam-complementaire/{hospitalisationId}/add-hospitalisation-immunologic-file")
    boolean addExamImmunologicToHospitalisation(@PathVariable Long hospitalisationId, @RequestParam(required = false) MultipartFile immunologic);

    @PutMapping("/exam-complementaire/{hospitalisationId}/add-hospitalisation-imager-file")
    boolean addExamImagerToHospitalisation(@PathVariable Long hospitalisationId, @RequestParam(required = false) MultipartFile imager);

    @PutMapping("/exam-complementaire/{hospitalisationId}/add-hospitalisation-hematologic-file")
    boolean addExamHematologicToHospitalisation(@PathVariable Long hospitalisationId, @RequestParam(required = false) MultipartFile hematologic);

    @PutMapping("/protocol/{hospitalisationId}/add-protocol-file")
    boolean addProtocolMedicalTraitFileToHospitalisation(@PathVariable Long hospitalisationId, @RequestParam(required = false) MultipartFile protocol);

    @GetMapping(value = "nombrehomme")
    int countHospitalisationHomme();

    @GetMapping(value = "nombrefemme")
    int countHospitalisationFemme();

    @GetMapping(value = "nombrehospitalisation")
    long countHospitalisation();
}