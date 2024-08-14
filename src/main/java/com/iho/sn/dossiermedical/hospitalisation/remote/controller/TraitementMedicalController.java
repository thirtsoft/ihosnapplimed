package com.iho.sn.dossiermedical.hospitalisation.remote.controller;

import com.iho.sn.dossiermedical.hospitalisation.assembler.TraitementMedicalAssembler;
import com.iho.sn.dossiermedical.hospitalisation.entity.TraitementMedical;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.TraitementMedicalApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.TraitementMedicalDs;
import com.iho.sn.dossiermedical.hospitalisation.service.TraitementMedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TraitementMedicalController implements TraitementMedicalApi {

    private final TraitementMedicalAssembler traitementMedicalAssembler;
    private final TraitementMedicalService traitementMedicalService;

    @Override
    public ResponseEntity<TraitementMedicalDs> creerTraitementMedical(TraitementMedicalDs traitementMedicalDs) {
        return new ResponseEntity<>(traitementMedicalAssembler.assembleEntityToDs(
                traitementMedicalService.saveTraitementMedical(
                        traitementMedicalAssembler.assembleTraitementMedicalFromDs(traitementMedicalDs))
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TraitementMedicalDs> updateTraitementMedical(Long id, TraitementMedicalDs traitementMedicalDs) {
        TraitementMedical traitementMedical = traitementMedicalAssembler.assembleTraitementMedicalFromDs(traitementMedicalDs);
        return new ResponseEntity<>(traitementMedicalAssembler.assembleEntityToDs(
                traitementMedicalService.updateTraitementMedical(id, traitementMedical)
        ), HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<TraitementMedicalDs> findTraitementMedicalById(Long id) {
        return new ResponseEntity<>(traitementMedicalAssembler.assembleEntityToDs(
                traitementMedicalService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TraitementMedicalDs>> findAllTraitementMedicals() {
        return new ResponseEntity<>(traitementMedicalAssembler.assembleEntitiesFrom(
                traitementMedicalService.findAllTraitementMedicals()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteTraitementMedical(Long id) {
        traitementMedicalService.deleteTraitementMedical(id);
    }
}