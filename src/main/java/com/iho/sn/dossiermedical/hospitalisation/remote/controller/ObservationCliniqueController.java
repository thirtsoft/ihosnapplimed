package com.iho.sn.dossiermedical.hospitalisation.remote.controller;

import com.iho.sn.dossiermedical.hospitalisation.assembler.ObservationCliniqueAssembler;
import com.iho.sn.dossiermedical.hospitalisation.entity.ObservationClinique;
import com.iho.sn.dossiermedical.hospitalisation.remote.controller.api.ObservationCliniqueApi;
import com.iho.sn.dossiermedical.hospitalisation.remote.model.ObservationCliniqueDs;
import com.iho.sn.dossiermedical.hospitalisation.service.ObservationCliniqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ObservationCliniqueController implements ObservationCliniqueApi {

    private final ObservationCliniqueAssembler observationCliniqueAssembler;
    private final ObservationCliniqueService observationCliniqueService;

    @Override
    public void creerObservationClinique(ObservationCliniqueDs observationCliniqueDs) {
        ObservationClinique observationClinique = observationCliniqueAssembler.assembleObservationCliniqueFromDs(
                observationCliniqueDs
        );
        observationCliniqueService.saveObservationClinique(observationClinique);
    }

    @Override
    public void updateObservationClinique(Long id, ObservationCliniqueDs observationCliniqueDs) {
        ObservationClinique observationClinique = observationCliniqueAssembler.assembleObservationCliniqueFromDs(
                observationCliniqueDs
        );
        observationCliniqueService.updateObservationClinique(id, observationClinique);
    }

    @Override
    public ResponseEntity<ObservationCliniqueDs> findById(Long id) {
        return new ResponseEntity<>(observationCliniqueAssembler.assembleEntityToDs(
                observationCliniqueService.findById(id)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ObservationCliniqueDs>> findObservationCliniques() {
        return new ResponseEntity<>(observationCliniqueAssembler.assembleEntitiesFrom(
                observationCliniqueService.findAllObservationCliniques()
        ), HttpStatus.OK);
    }

    @Override
    public void deleteObservationClinique(Long id) {
        observationCliniqueService.deleteObservationClinique(id);
    }
}