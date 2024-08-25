package com.iho.sn.dossiermedical.hospitalisation.remote.controller;


import com.iho.sn.dossiermedical.hospitalisation.assembler.HospitalisationAssembler;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.HospitalisationApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDetailDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationListDs;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.HospitalisationSearchDs;
import com.iho.sn.dossiermedical.hospitalisation.service.HospitalisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalisationController implements HospitalisationApi {

    private final HospitalisationService hospitalisationService;
    private final HospitalisationAssembler hospitalisationAssembler;

    @Override
    public Long creerHospitalisation(HospitalisationDs hospitalisationDs) {
        return hospitalisationService.saveHospitalisation(hospitalisationAssembler.assembleDsToEntity(hospitalisationDs));

    }

    @Override
    public Long updateHospitalisation(Long id, HospitalisationDs hospitalisationDs) {
        return hospitalisationService.updateHospitalisation(id, hospitalisationAssembler.assembleUpdateHospitalisation(hospitalisationDs));
    }

    @Override
    public ResponseEntity<HospitalisationDetailDs> findById(Long id) {
        return new ResponseEntity<>(hospitalisationAssembler.assembleHospitalisationDetailDsFromHospitalisation(
                hospitalisationService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HospitalisationListDs>> findAllHospitalisations() {
        return new ResponseEntity<>(hospitalisationAssembler
                .assembleEntitiesFrom(hospitalisationService.findAllHospitalisations()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HospitalisationListDs>> findByCriteria(HospitalisationSearchDs searchDs) {
        return new ResponseEntity<>(hospitalisationAssembler
                .assembleEntitiesFrom(hospitalisationService.findByCriteria(searchDs)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HospitalisationListDs>> getHospitalisationListByPatient(String code) {
        return new ResponseEntity<>(hospitalisationAssembler
                .assembleEntitiesFrom(hospitalisationService.findAllByPatient(code)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<HospitalisationDetailDs>> getHospitalisationsDetailsByPatient(String code) {
        return new ResponseEntity<>(hospitalisationAssembler
                .assembleHospitalisationsDetailsFromEntity(hospitalisationService.findAllByPatient((code))), HttpStatus.OK);

    }

    @Override
    public void deleteHospitalisation(Long id) {
        hospitalisationService.deleteHospitalisation(id);
    }

    @Override
    public boolean addExamBiologicToHospitalisation(Long hospitalisationId, MultipartFile biologic) {
        return hospitalisationService.addExamBiologicToHospitalisation(hospitalisationId, biologic);
    }

    @Override
    public boolean addExamImmunologicToHospitalisation(Long hospitalisationId, MultipartFile immunologic) {
        return hospitalisationService.addExamImmunologicToHospitalisation(hospitalisationId, immunologic);
    }

    @Override
    public boolean addExamImagerToHospitalisation(Long hospitalisationId, MultipartFile imager) {
        return hospitalisationService.addExamImagerToHospitalisation(hospitalisationId, imager);
    }

    @Override
    public boolean addExamHematologicToHospitalisation(Long hospitalisationId, MultipartFile hematologic) {
        return hospitalisationService.addExamHematologicToHospitalisation(hospitalisationId, hematologic);
    }

    @Override
    public boolean addProtocolMedicalTraitFileToHospitalisation(Long hospitalisationId, MultipartFile protocol) {
        return hospitalisationService.addProtocolMedicalTraitFileToHospitalisation(hospitalisationId, protocol);
    }

    @Override
    public int countHospitalisationHomme() {
        return hospitalisationService.countHospitalisationHomme();
    }

    @Override
    public int countHospitalisationFemme() {
        return hospitalisationService.countHospitalisationFemme();
    }

    @Override
    public long countHospitalisation() {
        return hospitalisationService.countHospitalisation();
    }
}